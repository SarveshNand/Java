# Java Generics Deep Dive
## Wildcards, PECS, Variance, and Type Erasure

---

# Table of Contents

1. Why Generics Exist
2. The Inheritance Problem with Generics
3. Arrays vs Generics
4. Understanding Variance
5. Wildcards (`?`)
6. Unbounded Wildcards (`?`)
7. Upper Bound Wildcards (`? extends T`)
8. Lower Bound Wildcards (`? super T`)
9. PECS Rule
10. Complete Variance Diagram
11. Type Erasure
12. Consequences of Type Erasure
13. Common Interview Questions
14. Quick Revision Sheet

---

# 1. Why Generics Exist

Before Java 5, collections stored everything as `Object`.

```java
ArrayList list = new ArrayList();

list.add("Hello");
list.add(100);

String str = (String) list.get(0);
```

Problems:

- No compile-time type checking
- Manual casting required
- Runtime ClassCastException possible

Example:

```java
ArrayList list = new ArrayList();

list.add(100);

String str = (String) list.get(0); // Runtime Error
```

Generics solve this problem.

```java
ArrayList<String> list = new ArrayList<>();

list.add("Hello");

// Compile-time Error
list.add(100);
```

---

# 2. The Inheritance Problem with Generics

Consider:

```java
class Animal {}
class Dog extends Animal {}
```

Normal inheritance works:

```java
Animal a = new Dog();
```

Diagram:

```text
Dog
 ↑
 |
Animal
```

---

## Question

Can we do this?

```java
List<Animal> animals = new ArrayList<Dog>();
```

Answer:

❌ NO

Even though:

```text
Dog IS-A Animal
```

Java says:

```text
List<Dog> IS NOT-A List<Animal>
```

This is called:

# Invariance

---

# 3. Why Invariance Exists

Suppose Java allowed this:

```java
List<Animal> animals = new ArrayList<Dog>();

animals.add(new Cat());
```

Diagram:

```text
animals
   ↓
List<Dog>

Add Cat()
   ↓
List<Dog, Cat>
```

Now later:

```java
Dog d = dogList.get(1);
d.bark();
```

But index 1 contains a Cat.

Result:

```text
Runtime Crash
```

Java prevents this at compile time.

---

# 4. Arrays vs Generics

## Arrays are Covariant

Allowed:

```java
Dog[] dogs = new Dog[5];

Animal[] animals = dogs;
```

Diagram:

```text
Dog[]
  ↑
  |
Animal[]
```

---

Now:

```java
animals[0] = new Cat();
```

Compiles successfully.

But runtime:

```text
ArrayStoreException
```

---

## Generics are Invariant

```java
List<Dog> dogs = new ArrayList<>();

List<Animal> animals = dogs;
```

Compile Error.

Benefits:

```text
Error detected at compile-time
```

instead of

```text
Error detected at runtime
```

Generics are safer.

---

# 5. Variance Overview

```text
INVARIANT
---------
List<Dog> ≠ List<Animal>


COVARIANT
---------
List<? extends Animal>


CONTRAVARIANT
-------------
List<? super Dog>
```

Memory Trick:

```text
extends = Read

super = Write
```

---

# 6. Wildcards ( ? )

Wildcard means:

```java
?
```

means

```text
Some Unknown Type
```

Examples:

```java
List<String>
List<Integer>
List<Double>
```

can all be assigned to:

```java
List<?>
```

---

Diagram:

```text
List<String>
       \
List<Integer> ----> List<?>
       /
List<Double>
```

---

Example:

```java
void print(List<?> list)
{
    for(Object obj : list)
    {
        System.out.println(obj);
    }
}
```

Usage:

```java
print(List<String>);
print(List<Integer>);
print(List<Dog>);
```

All valid.

---

# Why Can't We Add?

Suppose:

```java
List<?> list;
```

Compiler doesn't know:

```text
List<String> ?
List<Integer> ?
List<Dog> ?
```

Therefore:

```java
list.add("Hello");
```

Could be unsafe.

Hence:

```java
list.add(...)
```

❌ Forbidden

Only allowed:

```java
list.add(null);
```

---

# Wildcard Summary

```text
Read  -> Yes
Write -> No
```

---

# 7. Upper Bound Wildcards

Syntax:

```java
? extends Animal
```

Meaning:

```text
Animal OR Any Child of Animal
```

---

Diagram

```text
          Animal
         /      \
       Dog      Cat
        |
     Labrador
```

Allowed:

```java
List<Animal>
List<Dog>
List<Cat>
List<Labrador>
```

All fit into:

```java
List<? extends Animal>
```

---

Flowchart

```text
Is type Animal or Child?
          |
          v
        YES
          |
          v
List<? extends Animal>
```

---

Example

```java
static void printAnimals(
        List<? extends Animal> list)
{
    for(Animal a : list)
    {
        a.eat();
    }
}
```

Usage:

```java
printAnimals(dogs);
printAnimals(cats);
printAnimals(animals);
```

All valid.

---

## Why Reading Is Safe

Compiler knows:

```text
Everything is at least Animal
```

Therefore:

```java
Animal a = list.get(0);
```

Safe.

---

## Why Writing Is Unsafe

Imagine:

```java
List<? extends Animal> list
```

Actual object:

```java
List<Cat>
```

Now:

```java
list.add(new Dog());
```

Bad!

Dog entered Cat collection.

Compiler blocks it.

---

Upper Bound Rule:

```text
READ = YES

WRITE = NO
```

---

# 8. Lower Bound Wildcards

Syntax:

```java
? super Dog
```

Meaning:

```text
Dog OR Parent of Dog
```

---

Hierarchy

```text
Object
  ↑
Animal
  ↑
 Dog
```

Allowed:

```java
List<Dog>
List<Animal>
List<Object>
```

---

Diagram

```text
Dog
 ↑
 |
Animal
 ↑
 |
Object
```

All fit into:

```java
List<? super Dog>
```

---

Example

```java
static void addDogs(
        List<? super Dog> list)
{
    list.add(new Dog());
}
```

Valid:

```java
List<Dog>
List<Animal>
List<Object>
```

---

Why Writing Is Safe

If list is:

```java
List<Animal>
```

Adding Dog:

```java
animals.add(new Dog());
```

Perfectly valid.

If list is:

```java
List<Object>
```

Adding Dog:

```java
objects.add(new Dog());
```

Also valid.

---

Why Reading Is Unsafe

Suppose:

```java
List<? super Dog> list
```

Actual object:

```java
List<Object>
```

Reading:

```java
Dog d = list.get(0);
```

Not safe.

Could contain:

```java
Object
String
Integer
```

Compiler only guarantees:

```java
Object
```

Therefore:

```java
Object obj = list.get(0);
```

is allowed.

---

Lower Bound Rule

```text
READ = Object only

WRITE = YES
```

---

# 9. PECS Rule

The most important interview rule.

PECS:

```text
Producer Extends
Consumer Super
```

---

## Producer

If data comes OUT of collection

Use:

```java
extends
```

Example:

```java
List<? extends Animal>
```

Diagram:

```text
Collection
    |
Produces
    |
 Animal
```

---

## Consumer

If data goes INTO collection

Use:

```java
super
```

Diagram:

```text
Dog
 |
Consumed by
 |
Collection
```

---

Example

```java
void addDogs(
    List<? super Dog> list)
{
    list.add(new Dog());
}
```

---

PECS Cheat Sheet

```text
Reading?
   -> extends

Writing?
   -> super

Both?
   -> exact type
```

---

# 10. Complete Variance Diagram

```text
Animal
 /    \
Dog   Cat
```

---

## Invariant

```java
List<Dog>
```

Can ONLY accept:

```java
List<Dog>
```

---

## Covariant

```java
List<? extends Animal>
```

Accepts:

```java
List<Animal>
List<Dog>
List<Cat>
```

Read Only.

---

## Contravariant

```java
List<? super Dog>
```

Accepts:

```java
List<Dog>
List<Animal>
List<Object>
```

Write Safe.

---

# 11. Type Erasure

Most important JVM concept.

---

Question:

Does JVM know Generics?

Answer:

```text
NO
```

Generics exist only during compilation.

---

Flow

```text
Java Source
     |
     v
 Compiler
     |
 Type Erasure
     |
     v
 Bytecode
     |
     v
 JVM
```

---

Example

Source Code:

```java
List<String> list =
        new ArrayList<>();
```

After Erasure:

```java
List list =
        new ArrayList();
```

Generic information removed.

---

# 12. Rules of Type Erasure

## Rule 1

Unbounded Type

```java
<T>
```

becomes

```java
Object
```

---

Example

Before:

```java
class Box<T>
{
    T value;
}
```

After:

```java
class Box
{
    Object value;
}
```

---

## Rule 2

Bounded Type

```java
<T extends Number>
```

becomes

```java
Number
```

---

Before

```java
class Box<T extends Number>
{
    T value;
}
```

After

```java
class Box
{
    Number value;
}
```

---

# 13. Automatic Cast Insertion

Source:

```java
List<Integer> list =
        new ArrayList<>();

Integer x = list.get(0);
```

After Erasure:

```java
Integer x =
      (Integer) list.get(0);
```

Compiler inserts cast automatically.

---

Diagram

```text
Generic Code
      |
      v
Erasure
      |
      v
Object
      |
Auto Cast Added
      |
      v
Integer
```

---

# 14. Consequences of Type Erasure

---

## A. No instanceof

Invalid:

```java
if(list instanceof List<String>)
```

Reason:

Runtime only sees:

```java
List
```

not

```java
List<String>
```

---

Valid:

```java
if(list instanceof List)
```

---

## B. No Generic Array Creation

Invalid:

```java
new T[10];
```

Reason:

Type T erased.

Compiler doesn't know actual type.

---

## C. No Method Overloading

Invalid:

```java
void print(List<String> list)
{
}

void print(List<Integer> list)
{
}
```

After Erasure:

```java
void print(List list)
{
}

void print(List list)
{
}
```

Same signature.

Compile Error.

---

## D. No Primitive Types

Invalid:

```java
List<int>
```

Valid:

```java
List<Integer>
```

Reason:

Generics work with Objects.

Primitives are not Objects.

---

Diagram

```text
Primitive
---------
int
char
double

Not Allowed


Wrapper Classes
---------------
Integer
Character
Double

Allowed
```

---

# 15. Common Interview Questions

### Q1: Why is List<Dog> not a subtype of List<Animal>?

Because Generics are invariant to maintain type safety.

---

### Q2: Difference between Arrays and Generics?

Arrays:
- Covariant
- Runtime checks

Generics:
- Invariant
- Compile-time checks

---

### Q3: What is PECS?

```text
Producer Extends
Consumer Super
```

---

### Q4: Why can't we add elements to List<? extends Animal>?

Actual list may be:

```java
List<Cat>
```

Adding Dog would break type safety.

---

### Q5: Why can we add to List<? super Dog>?

Because collection is guaranteed to be Dog or its parent.

---

### Q6: Does JVM know generic types?

No.

Generic information is removed using Type Erasure.

---

### Q7: Why can't Generics use primitives?

Type Erasure replaces generic types with Object.

Primitives don't inherit from Object.

---

# 16. Ultimate Revision Sheet

```text
List<Dog> ≠ List<Animal>
(Invariance)

--------------------------------

List<?>
Read  -> Object
Write -> No

--------------------------------

List<? extends Animal>

Accept:
Animal
Dog
Cat

Read  -> Animal
Write -> No

--------------------------------

List<? super Dog>

Accept:
Dog
Animal
Object

Read  -> Object
Write -> Dog

--------------------------------

PECS

Producer -> Extends
Consumer -> Super

--------------------------------

Type Erasure

<T> -> Object

<T extends Number>
        ->
      Number

--------------------------------

No instanceof List<String>

No method overloading
with generic types

No List<int>

Use List<Integer>

--------------------------------

Arrays:
Covariant
Runtime Safe

Generics:
Invariant
Compile-Time Safe
```

### One-line Interview Summary

> Java Generics are invariant for compile-time type safety, wildcards (`extends` and `super`) provide controlled covariance and contravariance through the PECS principle, and all generic type information is removed during compilation via Type Erasure.