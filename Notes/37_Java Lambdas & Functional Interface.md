# Java Functional Programming, Functional Interfaces & Lambda Expressions

---

# 1. Why Functional Programming Was Introduced?

Before Java 8, Java was primarily an **Object-Oriented Programming (OOP)** language.

In OOP:

```text
Behavior (Logic)
      ↓
Must be placed inside
      ↓
Class
      ↓
Create Object
      ↓
Call Method
```

---

## Traditional OOP Approach

Suppose we want to print:

```text
Hello World
```

We need:

```java
class MyPrinter {

    void print() {
        System.out.println("Hello");
    }
}

public class Main {

    public static void main(String[] args) {

        MyPrinter obj = new MyPrinter();

        obj.print();
    }
}
```

---

## Problem

For very small logic:

```text
Create Class
Create Object
Call Method
```

Too much boilerplate code.

---

## Real Life Analogy

Imagine ordering food.

### OOP Style

```text
Need Water

↓

Hire Employee

↓

Employee Carries Water

↓

Drink Water
```

---

### Functional Style

```text
Need Water

↓

Take Water Directly
```

---

## Functional Programming Idea

Instead of passing:

```text
Objects
```

Pass:

```text
Behavior (Logic)
```

directly.

---

# 2. Evolution of Java

---

## Before Java 8

Java treated:

```text
Data
```

as first-class citizens.

Example:

```java
int x = 10;
String name = "Aditya";
```

Data can be:

```text
Stored
Passed
Returned
```

---

## But Methods?

Not possible.

```java
void greet() {}
```

Cannot do:

```java
someMethod(greet);
```

---

## Java 8 Solution

Introduce:

```text
Lambda Expressions
```

and

```text
Functional Interfaces
```

---

# Functional Programming Concept

Now behavior can be:

```text
Stored
Passed
Returned
```

like data.

---

# 3. Functional Interface

## Definition

A Functional Interface is:

```text
An Interface Having Exactly
One Abstract Method
```

---

# Structure

```java
@FunctionalInterface
interface Demo {

    void show();

}
```

---

# Diagram

```text
Functional Interface

     │

     ▼

Exactly ONE

Abstract Method
```

---

# Valid Functional Interface

```java
@FunctionalInterface
interface Calculator {

    int add(int a, int b);

}
```

---

# Invalid Functional Interface

```java
@FunctionalInterface
interface Demo {

    void m1();

    void m2();
}
```

Compiler Error.

Because:

```text
Two Abstract Methods
```

---

# Can Functional Interface Have Default Methods?

YES.

```java
@FunctionalInterface
interface Demo {

    void show();

    default void display() {

    }
}
```

Valid.

---

# Can It Have Static Methods?

YES.

```java
@FunctionalInterface
interface Demo {

    void show();

    static void test() {

    }
}
```

Valid.

---

# Rule

Count only:

```text
Abstract Methods
```

---

# Functional Interface Formula

```text
1 Abstract Method

+

Any Number Of

Default Methods

+

Any Number Of

Static Methods
```

---

# Why @FunctionalInterface?

Annotation is optional.

But recommended.

---

# Benefit

Compiler checks:

```text
Exactly One
Abstract Method
```

---

# Example

```java
@FunctionalInterface
interface Demo {

    void m1();

    void m2();
}
```

Compiler Error immediately.

---

# Built-In Functional Interfaces

---

## Comparable

```java
public interface Comparable<T> {

    int compareTo(T o);

}
```

One abstract method.

Functional Interface.

---

## Comparator

```java
public interface Comparator<T> {

    int compare(T o1,T o2);

}
```

Functional Interface.

---

# Common Functional Interfaces

| Interface      | Method            |
| -------------- | ----------------- |
| Comparable     | compareTo()       |
| Comparator     | compare()         |
| Runnable       | run()             |
| Callable       | call()            |
| ActionListener | actionPerformed() |

---

# 4. Lambda Expressions

---

## Definition

A Lambda Expression is:

```text
A Short Way To Implement
A Functional Interface
```

---

# General Syntax

```java
(parameters) -> expression
```

or

```java
(parameters) -> {
    statements
}
```

---

# Read As

```text
Parameters

maps to

Implementation
```

---

# Visualization

```text
Input

  │

  ▼

(parameters)

  │

  ▼

   →

  │

  ▼

Implementation
```

---

# Example 1

Traditional:

```java
interface Greeting {

    void sayHello();
}
```

Implementation:

```java
Greeting g =
    new Greeting() {

        public void sayHello() {
            System.out.println("Hello");
        }
    };
```

---

# Lambda Version

```java
Greeting g =
    () -> System.out.println("Hello");
```

Same functionality.

Much shorter.

---

# 5. Lambda Syntax Variations

---

## No Parameters

```java
() -> System.out.println("Hello");
```

---

# Visualization

```text
No Input

↓

Execute Logic
```

---

## One Parameter

```java
x -> x * x
```

Parentheses optional.

Equivalent:

```java
(x) -> x * x
```

---

# Example

```java
x -> x * x
```

Input:

```text
5
```

Output:

```text
25
```

---

## Multiple Parameters

```java
(a,b) -> a + b
```

Parentheses mandatory.

---

# Example

```java
(a,b) -> a + b
```

Input:

```text
10 , 20
```

Output:

```text
30
```

---

## Multi-Line Lambda

```java
(a,b) -> {

    int sum = a + b;

    return sum;
};
```

---

# Rule

When using:

```text
{}
```

Must use:

```java
return
```

if value is returned.

---

# Single Line Lambda

```java
(a,b) -> a+b
```

Return automatically inferred.

---

# Lambda Syntax Cheat Sheet

| Situation           | Syntax                     |
| ------------------- | -------------------------- |
| No Parameter        | `() -> {}`                 |
| One Parameter       | `x -> x*x`                 |
| Multiple Parameters | `(a,b) -> a+b`             |
| Multiple Statements | `(a,b) -> { return a+b; }` |

---

# 6. Sorting Evolution (Most Important Interview Topic)

Suppose:

```java
class Student {

    String name;
    int marks;
}
```

Need sorting by:

```text
Marks
```

---

# Approach 1 : Separate Comparator Class

```java
class SortByMarks
implements Comparator<Student> {

    public int compare(
        Student s1,
        Student s2)
    {
        return s1.marks
             - s2.marks;
    }
}
```

Usage:

```java
Collections.sort(
    list,
    new SortByMarks()
);
```

---

# Problems

```text
Extra Class

Extra File

Extra Object
```

---

# Approach 2 : Anonymous Inner Class

```java
Collections.sort(
    list,
    new Comparator<Student>() {

        @Override
        public int compare(
            Student s1,
            Student s2)
        {
            return s1.marks
                 - s2.marks;
        }
    }
);
```

---

# Problems

Still verbose.

Too much boilerplate.

---

# Approach 3 : Lambda Expression

```java
Collections.sort(
    list,
    (s1,s2) ->
        s1.marks - s2.marks
);
```

---

# Reduction Visualization

```text
Separate Class

50+ Characters
      ↓

Anonymous Class

30+ Characters
      ↓

Lambda

Few Characters
```

---

# Modern Java

```java
list.sort(
    (s1,s2) ->
        s1.marks - s2.marks
);
```

Preferred.

---

# 7. Target Typing

Interview Favorite.

---

# Question

How does Java know:

```java
(s1,s2) ->
s1.marks-s2.marks
```

belongs to:

```java
compare()
```

?

---

# Answer

Target Typing.

---

# Example

```java
Collections.sort(
    list,
    (s1,s2) ->
    s1.marks-s2.marks
);
```

---

# Compiler Thinking

Step 1

```java
Collections.sort()
```

expects:

```java
Comparator<Student>
```

---

Step 2

Compiler checks:

```java
Comparator
```

contains:

```java
compare()
```

---

Step 3

Lambda automatically becomes:

```java
compare(s1,s2)
```

implementation.

---

# Diagram

```text
Collections.sort()

        │

Needs Comparator

        │

Comparator Has

compare()

        │

Lambda Assigned To

compare()
```

---

# 8. Benefits of Lambda Expressions

---

## Reduced Boilerplate

Before:

```java
new Comparator<Student>() {

}
```

After:

```java
(s1,s2) -> ...
```

---

## Improved Readability

Focus only on:

```text
Logic
```

Not syntax noise.

---

## Pass Behavior As Argument

Example:

```java
list.sort(
    (a,b) -> a-b
);
```

Logic passed directly.

---

## Better Stream API Support

Used heavily in:

```java
Streams

Collections

Concurrency

Optional
```

---

# Real-World Example

Sort Employees by Salary

```java
employees.sort(
    (e1,e2) ->
    e1.salary - e2.salary
);
```

---

Filter Users

```java
users.removeIf(
    user -> user.age < 18
);
```

---

Print Collection

```java
list.forEach(
    item -> System.out.println(item)
);
```

---

# Functional Programming Flow

```text
Traditional OOP

Behavior
   ↓
Class
   ↓
Object
   ↓
Method Call
```

---

```text
Functional Programming

Behavior
   ↓
Lambda
   ↓
Pass Directly
```

---

# Functional Interface vs Normal Interface

| Feature              | Functional Interface | Normal Interface    |
| -------------------- | -------------------- | ------------------- |
| Abstract Methods     | Exactly 1            | Any Number          |
| Lambda Support       | Yes                  | No                  |
| @FunctionalInterface | Recommended          | Not Applicable      |
| Purpose              | Behavior Passing     | Contract Definition |

---

# Quick Revision Sheet

```text
FUNCTIONAL INTERFACE

Exactly One Abstract Method

Can Have:

Default Methods

Static Methods

ANNOTATION

@FunctionalInterface

LAMBDA

(parameters) -> body

NO PARAMETER

() -> {}

ONE PARAMETER

x -> x*x

MULTIPLE PARAMETERS

(a,b) -> a+b

TARGET TYPING

Compiler Uses Context

SORTING EVOLUTION

Comparator Class

↓

Anonymous Class

↓

Lambda

BENEFITS

Less Code

Better Readability

Pass Behavior Directly

Stream API Friendly
```

---

# Most Asked Interview Questions

1. What is a Functional Interface?
2. Why is Comparator a Functional Interface?
3. What is a Lambda Expression?
4. Difference between Anonymous Class and Lambda?
5. What is Target Typing?
6. Can Functional Interfaces have default methods?
7. Can Functional Interfaces have static methods?
8. Why was Functional Programming introduced in Java?
9. What are the advantages of Lambdas?
10. Explain sorting evolution from Comparator class to Lambda.
11. What is the purpose of `@FunctionalInterface`?
12. Why can't a Functional Interface have two abstract methods?
13. How does Java map a Lambda to a method?
14. What is behavior passing?
15. How are Lambdas used in Collections and Streams?

```
Java 8 Revolution

Functional Interface
          │
          ▼
      Lambda
          │
          ▼
  Behavior As Data
          │
          ▼
 Cleaner & Shorter Code
```
