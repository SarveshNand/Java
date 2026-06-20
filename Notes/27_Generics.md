
---

# 1. Why Java Needs Type Safety

Java is a **Strongly Typed Language**.

This means every variable must have a specific type.

```java
int age = 25;
String name = "John";
boolean isActive = true;
```

Each type has its own rules.

| Type | Allowed Operations |
|--------|------------------|
| int | +, -, *, / |
| String | length(), charAt() |
| boolean | logical operations |
| double | decimal arithmetic |

---

## Example

```java
int x = 10;
x = 20;        // Valid

x = 10.5;      // Compile Error
```

Why?

Because an `int` variable can only store integer values.

---

## Benefits of Type Safety

✅ Prevents invalid operations

✅ Detects errors during compilation

✅ Improves IDE suggestions

✅ Makes code reliable

---

# Type Safety Flow

```text
      Write Code
           |
           v
   Compiler Checks Types
           |
     +-----+-----+
     |           |
   Valid      Invalid
     |           |
     v           v
 Program      Compile Error
 Executes
```

---

# 2. Object-Oriented Relationships

Suppose:

```java
class Animal {
    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking");
    }
}
```

Relationship:

```text
      Animal
         ^
         |
        Dog
```

Dog IS-A Animal.

---

# 3. Upcasting

## Definition

Converting a Child Object into Parent Reference.

```java
Dog d = new Dog();

Animal a = d;
```

OR

```java
Animal a = new Dog();
```

This happens automatically.

---

## Diagram

```text
          Dog Object
               |
               |
               v
      Animal Reference
```

---

## Why Safe?

Every Dog is an Animal.

Compiler knows this relationship.

---

## Accessible Methods

```java
Animal a = new Dog();

a.eat();     // Allowed
a.bark();    // Error
```

Why?

Reference type decides accessible methods.

Compiler sees:

```text
Animal a
```

So only Animal methods are visible.

---

## Runtime Reality

```text
Reference Type = Animal
Actual Object  = Dog
```

---

# Upcasting Flow

```text
Dog Object Created
         |
         v
Assign to Animal Reference
         |
         v
Only Parent Methods Visible
         |
         v
Safe Conversion
```

---

# 4. Downcasting

## Definition

Converting Parent Reference back to Child Reference.

```java
Animal a = new Dog();

Dog d = (Dog)a;
```

Manual cast required.

---

## Diagram

```text
Animal Reference
       |
       v
 Dog Object

Downcast

       |
       v

Dog Reference
```

---

## Why Manual?

Compiler cannot guarantee the actual object type.

---

## Valid Example

```java
Animal a = new Dog();

Dog d = (Dog)a;

d.bark();
```

Output:

```text
Barking
```

---

## Dangerous Example

```java
Object obj = 100;

String s = (String)obj;
```

Runtime:

```text
ClassCastException
```

---

# Downcasting Flow

```text
Parent Reference
        |
        v
Check Actual Object Type
        |
   +----+----+
   |         |
 Match    No Match
   |         |
   v         v
Success  ClassCastException
```

---

# Safe Downcasting

Always use:

```java
instanceof
```

Example:

```java
if(obj instanceof String) {
    String s = (String)obj;
}
```

---

# Interview Question

### Difference Between Upcasting and Downcasting

| Upcasting | Downcasting |
|------------|-------------|
| Child → Parent | Parent → Child |
| Automatic | Manual |
| Safe | Risky |
| No cast needed | Cast needed |
| No exception | May throw ClassCastException |

---

# 5. Problem Before Generics

Before Java 5, collections used Object.

Example:

```java
class Box {
    Object value;
}
```

Since every class extends Object:

```java
Box b = new Box();

b.value = "Hello";
```

Later:

```java
String s = (String)b.value;
```

Works.

---

## Problem 1: Lost Type Information

```java
Object value = "Hello";
```

Compiler only sees:

```text
Object
```

Original type information is hidden.

---

## Problem 2: Manual Casting

```java
String s = (String)value;
```

Must cast every time.

---

## Problem 3: Runtime Errors

```java
Object value = 100;

String s = (String)value;
```

Runtime:

```text
ClassCastException
```

---

# Life Before Generics

```text
Store Data
    |
    v
Convert to Object
    |
Type Information Lost
    |
Retrieve Data
    |
Manual Casting
    |
Possible Runtime Error
```

---

# 6. Generics - The Solution

Generics provide:

> Compile-Time Type Safety

Introduced in Java 5.

---

# Generic Class Syntax

```java
class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
```

---

# Understanding T

`T` = Type Parameter

Think of it as a placeholder.

```text
T = Integer
T = String
T = Double
```

---

# Generic Object Creation

```java
Box<Integer> box = new Box<>(10);
```

Compiler replaces:

```text
T → Integer
```

Conceptually:

```java
class Box {
    Integer value;
}
```

---

# Example

```java
Box<String> box =
        new Box<>("Hello");

String s = box.getValue();
```

No casting needed.

---

# Generic Flow

```text
Create Generic Class
          |
          v
Provide Type Argument
          |
          v
Compiler Replaces T
          |
          v
Type-Safe Code
```

---

# Type Parameter vs Type Argument

## Type Parameter

```java
class Box<T>
```

T is Type Parameter.

---

## Type Argument

```java
Box<Integer>
```

Integer is Type Argument.

---

# Visualization

```text
Class Definition

Box<T>

        |
        |
        v

Object Creation

Box<Integer>

T becomes Integer
```

---

# Benefits of Generics

---

## 1. Compile-Time Safety

```java
Box<Integer> box =
       new Box<>(10);

box = new Box<>("Hello");
```

Compile Error.

---

## 2. No Casting

Without Generics:

```java
String s = (String)obj;
```

With Generics:

```java
String s = box.getValue();
```

---

## 3. Better Readability

```java
List<String>
```

Immediately tells:

```text
This list stores Strings.
```

---

## 4. Better IDE Support

Autocomplete becomes more accurate.

---

# Comparison

## Without Generics

```java
Object obj = "Java";

String s = (String)obj;
```

---

## With Generics

```java
Box<String> box =
        new Box<>("Java");

String s = box.getValue();
```

Cleaner and safer.

---

# 7. Generic Methods

Methods can also use Type Parameters.

---

## Syntax

```java
public static <T> T method(T value)
```

Important:

```java
<T>
```

comes BEFORE return type.

---

## Example

```java
public static <T> T getResult(T x) {
    return x;
}
```

Usage:

```java
String s = getResult("Hello");

Integer n = getResult(100);
```

---

# Type Inference

Java can infer type automatically.

```java
getResult("Hello");
```

Compiler infers:

```text
T = String
```

---

## Explicit Type

```java
GenericDemo.<String>
getResult("Hello");
```

Rarely needed.

---

# Generic Method Flow

```text
Method Called
      |
      v
Compiler Detects Argument Type
      |
      v
Assigns T
      |
      v
Returns Same Type
```

---

# 8. Bounded Types

Sometimes any type is NOT acceptable.

Need restrictions.

---

# Unbounded Generic

```java
class Box<T>
```

Can store:

```java
String
Integer
Double
Dog
Animal
Anything
```

---

# Upper Bound

```java
class Box<T extends Number>
```

Now only Number subclasses allowed.

---

# Number Hierarchy

```text
        Number
      /    |    \
     /     |     \
Integer Double Float
```

---

## Valid

```java
Box<Integer> b1;

Box<Double> b2;

Box<Float> b3;
```

---

## Invalid

```java
Box<String> b4;
```

Compile Error.

---

# Why Use Bounds?

Because compiler now knows:

```text
T is a Number
```

So Number methods become available.

---

## Example

```java
class Box<T extends Number> {

    private T value;

    public double square() {
        return value.doubleValue()
             * value.doubleValue();
    }
}
```

Works because:

```java
doubleValue()
```

belongs to Number class.

---

# Bounded Type Flow

```text
Generic Class
      |
      v
T extends Number
      |
      v
Only Numeric Types Allowed
      |
      v
Number Methods Accessible
```

---

# 9. Multiple Bounds

A type can be restricted to:

- One Class
- Multiple Interfaces

---

## Syntax

```java
<T extends ClassA
      & InterfaceA
      & InterfaceB>
```

---

# Rule

Class MUST come first.

Correct:

```java
<T extends Animal
    & Swimmable
    & Runnable>
```

Wrong:

```java
<T extends Swimmable
    & Animal>
```

Compile Error.

---

# Example

```java
interface Swimmable {
    void swim();
}

class Animal {}

class Duck extends Animal
          implements Swimmable {

    public void swim() {}
}
```

Generic:

```java
class Pond<T extends Animal
          & Swimmable> {
}
```

Valid:

```java
Pond<Duck> pond =
       new Pond<>();
```

---

# Multiple Bounds Diagram

```text
                Animal
                   ^
                   |
                 Duck
                   |
                   |
         Implements Swimmable
```

Requirement:

```text
Animal  + Swimmable
```

Duck satisfies both.

---

# Interview Questions

---

## Q1. Why Generics?

Answer:

```text
1. Compile-time type safety
2. Removes casting
3. Prevents ClassCastException
4. Improves readability
```

---

## Q2. Why Object Was Used Before Generics?

Because Object is the parent of all classes and could store any type.

---

## Q3. What Problem Does Generics Solve?

Loss of type information and unsafe runtime casting.

---

## Q4. Difference Between T and ?

| T | ? |
|---|---|
| Named type parameter | Wildcard |
| Used in declaration | Used in consumption |
| Can be referenced | Cannot be referenced |

---

## Q5. Why Use Bounds?

To restrict acceptable types and gain access to parent methods.

---

## Q6. Can Primitive Types Be Used?

❌ No

```java
Box<int>
```

Invalid.

Use wrapper classes.

```java
Box<Integer>
Box<Double>
```

---

# Memory Trick

```text
UPcasting
↑
Child → Parent

DOWNcasting
↓
Parent → Child
```

---

# One-Line Summary

```text
Generics provide compile-time type safety by replacing unsafe Object-based programming with parameterized types, eliminating unnecessary casting and reducing runtime errors.
```