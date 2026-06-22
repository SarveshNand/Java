# Java Functional Interfaces, Method References & Functional Composition

---

# 1. Custom Functional Interfaces

## Definition

A Functional Interface is an interface containing:

```text
Exactly One Abstract Method
```

It serves as the foundation of:

```text
Lambda Expressions
Method References
Stream API
Functional Programming
```

---

# Why Functional Interfaces?

Before Java 8:

```text
Logic
 ↓
Class
 ↓
Object
 ↓
Method Call
```

After Java 8:

```text
Logic
 ↓
Lambda
 ↓
Pass Directly
```

---

# Using @FunctionalInterface

```java
@FunctionalInterface
interface Calculator {

    int calculate(int a, int b);

}
```

---

## Benefit

Compiler ensures:

```text
Only One Abstract Method Exists
```

---

### Valid

```java
@FunctionalInterface
interface Demo {

    void show();

    default void display() {}

    static void test() {}

}
```

---

### Invalid

```java
@FunctionalInterface
interface Demo {

    void show();

    void print();
}
```

Compiler Error:

```text
Multiple Abstract Methods
```

---

# Custom Functional Interface Example

```java
@FunctionalInterface
interface Calculator {

    int calculate(int a, int b);

}
```

---

## Addition

```java
Calculator add =
        (a,b) -> a+b;
```

---

## Multiplication

```java
Calculator multiply =
        (a,b) -> a*b;
```

---

## Usage

```java
System.out.println(
    add.calculate(10,5)
);
```

Output

```text
15
```

---

# Visualization

```text
Calculator

    │

    ▼

calculate(a,b)

    │

    ▼

Lambda Provides Logic

(a,b) -> a+b
```

---

# 2. Built-in Functional Interfaces

Java provides ready-made functional interfaces inside:

```java
java.util.function
```

Used in:

```text
Streams
Collections
Concurrency
Reactive Programming
```

---

# Core Functional Interfaces

```text
Function
Consumer
Supplier
Predicate
```

---

# Memory Trick

```text
Function  → Transform

Consumer  → Consume

Supplier  → Supply

Predicate → Test
```

---

# 3. Function<T,R>

## Purpose

Takes:

```text
Input
```

Returns:

```text
Output
```

---

## Syntax

```java
Function<T,R>
```

---

## Internal Method

```java
R apply(T t)
```

---

# Diagram

```text
Input(T)

   │

   ▼

Function

   │

   ▼

Output(R)
```

---

# Example

Square Number

```java
Function<Integer,Integer>
square = x -> x*x;
```

---

Usage

```java
square.apply(5);
```

Output

```text
25
```

---

# Real World Example

Convert Name To Uppercase

```java
Function<String,String>
upper = String::toUpperCase;
```

---

```java
upper.apply("java");
```

Output

```text
JAVA
```

---

# 4. Consumer<T>

## Purpose

Consumes input.

Returns nothing.

---

## Internal Method

```java
void accept(T t)
```

---

# Diagram

```text
Input

  │

  ▼

Consumer

  │

  ▼

No Output
```

---

# Example

```java
Consumer<String>
printer =
s -> System.out.println(s);
```

---

Usage

```java
printer.accept("Hello");
```

Output

```text
Hello
```

---

# Real World Uses

```text
Logging

Printing

Sending Emails

Writing Files
```

---

# 5. Supplier<T>

## Purpose

No Input

Returns Output

---

## Internal Method

```java
T get()
```

---

# Diagram

```text
No Input

   │

   ▼

Supplier

   │

   ▼

Output
```

---

# Example

```java
Supplier<Double>
random =
() -> Math.random();
```

---

Usage

```java
random.get();
```

Output

```text
0.8732
```

(Random)

---

# Real World Uses

```text
Random Number Generation

Object Creation

Configuration Loading
```

---

# 6. Predicate<T>

## Purpose

Tests a condition.

Returns:

```text
true / false
```

---

## Internal Method

```java
boolean test(T t)
```

---

# Diagram

```text
Input

  │

  ▼

Condition

  │

  ▼

true / false
```

---

# Example

```java
Predicate<Integer>
isEven =
x -> x%2==0;
```

---

Usage

```java
isEven.test(10);
```

Output

```text
true
```

---

# Real World Uses

```text
Filtering Data

Validation

Searching
```

---

# Quick Comparison

| Interface | Input | Output  |
| --------- | ----- | ------- |
| Function  | Yes   | Yes     |
| Consumer  | Yes   | No      |
| Supplier  | No    | Yes     |
| Predicate | Yes   | Boolean |

---

# 7. Primitive Functional Interfaces

## Problem

Generics use wrapper classes.

Example:

```java
Function<Integer,Integer>
```

Internally:

```text
int
 ↓
Integer
 ↓
Operation
 ↓
Integer
 ↓
int
```

---

# Auto Boxing

```java
int → Integer
```

---

# Unboxing

```java
Integer → int
```

---

# Problem

Millions of iterations:

```text
More Memory

More CPU

Slower Performance
```

---

# Solution

Primitive Functional Interfaces

---

## IntFunction

```java
IntFunction<String>
```

Input:

```text
int
```

Output:

```text
Object
```

---

## IntConsumer

```java
IntConsumer
```

Input:

```text
int
```

Output:

```text
void
```

---

## IntPredicate

```java
IntPredicate
```

Input:

```text
int
```

Output:

```text
boolean
```

---

## IntSupplier

```java
IntSupplier
```

Input:

```text
None
```

Output:

```text
int
```

---

# Interview Point

Use primitive functional interfaces in:

```text
High Performance Code

Large Loops

Data Processing Pipelines
```

---

# 8. UnaryOperator & BinaryOperator

Specialized Functions.

---

## UnaryOperator

Input and output same type.

```java
UnaryOperator<Integer>
square =
x -> x*x;
```

---

Diagram

```text
Integer
   │
   ▼
Integer
```

---

## BinaryOperator

Two inputs.

Same output type.

```java
BinaryOperator<Integer>
add =
(a,b) -> a+b;
```

---

Diagram

```text
Integer + Integer

        │

        ▼

      Integer
```

---

# 9. Method References

## Definition

A shorter form of Lambda.

---

# Lambda

```java
x -> System.out.println(x)
```

---

# Method Reference

```java
System.out::println
```

---

# Rule

Use Method Reference when lambda only calls an existing method.

---

# Syntax

```java
ClassName::methodName

object::methodName

ClassName::new
```

---

# Types of Method References

---

# Static Method Reference

Lambda

```java
x -> Math.abs(x)
```

Method Reference

```java
Math::abs
```

---

# Instance Method Reference

Lambda

```java
x -> System.out.println(x)
```

Method Reference

```java
System.out::println
```

---

# Constructor Reference

Lambda

```java
() -> new ArrayList<>()
```

Method Reference

```java
ArrayList::new
```

---

# Visualization

```text
Lambda

x -> method(x)

       ↓

Method Reference

Class::method
```

---

# 10. Functional Composition

Combine small functions into larger pipelines.

---

# Example Functions

```java
Function<Integer,Integer>
add2 =
x -> x+2;
```

---

```java
Function<Integer,Integer>
multiply3 =
x -> x*3;
```

---

# 11. andThen()

Left → Right

---

```java
add2.andThen(multiply3)
```

---

Flow

```text
Input

  │

  ▼

+2

  │

  ▼

×3

  │

  ▼

Output
```

---

Example

```java
5
```

Step 1

```text
5 + 2 = 7
```

Step 2

```text
7 × 3 = 21
```

Output

```text
21
```

---

# Formula

```text
g(f(x))
```

---

# 12. compose()

Right → Left

---

```java
add2.compose(multiply3)
```

---

Flow

```text
Input

  │

  ▼

×3

  │

  ▼

+2

  │

  ▼

Output
```

---

Example

Input

```text
5
```

Step 1

```text
5 × 3 = 15
```

Step 2

```text
15 + 2 = 17
```

Output

```text
17
```

---

# Formula

```text
f(g(x))
```

---

# andThen vs compose

| Method    | Direction    |
| --------- | ------------ |
| andThen() | Left → Right |
| compose() | Right → Left |

---

# 13. Predicate Chaining

---

## Predicate AND

```java
Predicate<Integer>
positive =
x -> x>0;
```

```java
Predicate<Integer>
even =
x -> x%2==0;
```

---

```java
positive.and(even)
```

---

Meaning

```text
Positive AND Even
```

---

# Predicate OR

```java
positive.or(even)
```

Meaning

```text
Positive OR Even
```

---

# Predicate Negate

```java
even.negate()
```

Meaning

```text
NOT Even
```

---

# Visualization

```text
Predicate1

   AND

Predicate2

   ↓

Combined Predicate
```

---

# 14. Consumer Chaining

---

```java
Consumer<String>
print =
System.out::println;
```

---

```java
Consumer<String>
log =
s -> System.out.println(
     "LOG:"+s
);
```

---

Combine

```java
print.andThen(log);
```

---

Flow

```text
Input

  │

  ▼

Print

  │

  ▼

Log

  │

  ▼

Done
```

---

# 15. Bi-Functional Interfaces

Normal interfaces:

```text
One Input
```

Bi interfaces:

```text
Two Inputs
```

---

# BiFunction

```java
BiFunction<Integer,
           Integer,
           Integer>
add =
(a,b) -> a+b;
```

---

# Diagram

```text
Input1

Input2

   │

   ▼

BiFunction

   │

   ▼

Output
```

---

# BiConsumer

```java
BiConsumer<String,Integer>
printer =
(name,age) ->
System.out.println(
name+" "+age
);
```

---

# BiPredicate

```java
BiPredicate<Integer,Integer>
greater =
(a,b) -> a>b;
```

---

# Bi Interface Summary

| Interface   | Inputs | Output  |
| ----------- | ------ | ------- |
| BiFunction  | 2      | Yes     |
| BiConsumer  | 2      | No      |
| BiPredicate | 2      | Boolean |

---

# 16. Imperative vs Declarative Programming

---

# Imperative Style

Focuses on:

```text
HOW
```

to perform task.

---

Example

```java
for(int i=0;i<list.size();i++) {

    System.out.println(
        list.get(i)
    );
}
```

---

# Declarative Style

Focuses on:

```text
WHAT
```

to perform.

---

Example

```java
list.forEach(
    System.out::println
);
```

---

# Comparison

| Imperative         | Declarative        |
| ------------------ | ------------------ |
| How to do          | What to do         |
| More Code          | Less Code          |
| Manual Loops       | Stream Pipelines   |
| Harder Readability | Easier Readability |

---

# Visualization

```text
Imperative

Step 1
Step 2
Step 3
Step 4
```

---

```text
Declarative

Desired Result
      ↓
Java Handles Steps
```

---

# Complete Functional Interface Family Tree

```text
java.util.function

│
├── Function
│
├── Consumer
│
├── Supplier
│
├── Predicate
│
├── UnaryOperator
│
├── BinaryOperator
│
├── BiFunction
│
├── BiConsumer
│
└── BiPredicate
```

---

# Interview Cheat Sheet

```text
FUNCTIONAL INTERFACE

Exactly One Abstract Method

ANNOTATION

@FunctionalInterface

CORE INTERFACES

Function

Consumer

Supplier

Predicate

FUNCTION

Input → Output

CONSUMER

Input → No Output

SUPPLIER

No Input → Output

PREDICATE

Input → Boolean

METHOD REFERENCE

System.out::println

Math::abs

ArrayList::new

COMPOSITION

andThen()

Left → Right

compose()

Right → Left

PRIMITIVE INTERFACES

IntFunction

IntConsumer

IntPredicate

IntSupplier

BI INTERFACES

BiFunction

BiConsumer

BiPredicate

PROGRAMMING STYLES

Imperative = HOW

Declarative = WHAT
```
