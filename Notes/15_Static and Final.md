# Java `static`, `final`, and `main()` Method Notes

---

# Table of Contents

1. Static Keyword
2. Static Variables
3. Static Methods
4. Static Blocks
5. Limitations of Static
6. Final Keyword
7. Final Variables
8. Final Parameters
9. Final Methods & Classes
10. Deep Dive into `main()`
11. Command Line Arguments
12. `static final`
13. Interview Questions
14. Quick Revision Sheet

---

# 1. The `static` Keyword

The `static` keyword makes a member belong to the **class itself** rather than individual objects.

Without `static`:

```java
class Student {
    String name;
}
```

Every object gets its own copy of `name`.

With `static`:

```java
class Student {
    static String college = "IIT Guwahati";
}
```

All objects share one copy.

---

# 2. Static Variables (Class Variables)

## Definition

A static variable belongs to the class and is shared among all objects.

---

## Memory Layout

```text
CLASS AREA

college = "IIT Guwahati"

      ▲
      │
 ┌────┴────┐
 │         │
s1        s2
```

Only one copy exists.

---

## Example

```java
class Student {
    String name;
    static String college = "IIT Guwahati";
}
```

```java
Student s1 = new Student();
Student s2 = new Student();

System.out.println(Student.college);
```

Output:

```text
IIT Guwahati
```

---

## Why Use Static?

### Without Static

```java
class Student {
    String college;
}
```

1000 students:

```text
1000 × 4 bytes
= 4000 bytes
```

---

### With Static

```java
static String college;
```

Only:

```text
4 bytes
```

for the entire application.

---

## Accessing Static Variables

### Allowed

```java
Student.college
```

### Also Allowed

```java
s1.college
```

### Professional Practice

```java
Student.college
```

because it clearly indicates class-level data.

---

## Shared Nature

```java
s1.college = "IIT Delhi";
```

Now:

```java
System.out.println(s2.college);
```

Output:

```text
IIT Delhi
```

because both use the same variable.

---

# 3. Static Methods

## Definition

Static methods belong to the class.

They can be called without creating objects.

---

## Example

```java
class MathUtil {

    static int add(int a, int b) {
        return a + b;
    }
}
```

Usage:

```java
int ans = MathUtil.add(10, 20);
```

Output:

```text
30
```

---

## Memory Diagram

```text
CLASS AREA

add()

No object required
```

---

# 4. Rules of Static Methods

---

## Rule 1: Can Call Only Static Methods Directly

```java
class Demo {

    static void display() {
        print();
    }

    static void print() {
        System.out.println("Hello");
    }
}
```

Valid.

---

### Invalid Example

```java
class Demo {

    void show() {
    }

    static void display() {
        show(); // Error
    }
}
```

Reason:

```text
Which object's show()?
```

JVM doesn't know.

---

## Rule 2: Can Access Only Static Variables Directly

```java
class Demo {

    static int x = 10;

    static void display() {
        System.out.println(x);
    }
}
```

Valid.

---

### Invalid

```java
class Demo {

    int age = 20;

    static void display() {
        System.out.println(age);
    }
}
```

Error.

No object exists yet.

---

## Rule 3: Cannot Use `this`

```java
static void display() {
    System.out.println(this);
}
```

Compilation Error.

---

### Why?

`this` means:

```text
Current Object
```

Static methods belong to class.

No current object exists.

---

# 5. Static Blocks

## Purpose

Used to initialize static variables.

---

## Syntax

```java
class Demo {

    static int x;

    static {
        x = 100;
        System.out.println("Static Block");
    }
}
```

---

## Execution Flow

```text
Class Loaded
      ↓
Static Block Executes
      ↓
main() Starts
```

---

## Example

```java
class Demo {

    static {
        System.out.println("Loaded");
    }

    public static void main(String[] args) {
        System.out.println("Main");
    }
}
```

Output:

```text
Loaded
Main
```

---

## Important Rule

Static block executes:

```text
Only Once
```

when class loads.

---

# 6. Limitations of Static

---

## Parameters Cannot Be Static

Invalid:

```java
void print(static int x)
```

Reason:

Parameters are local variables.

---

## Top-Level Class Cannot Be Static

Invalid:

```java
static class Student {
}
```

---

### Nested Class Can Be Static

```java
class Outer {

    static class Inner {
    }
}
```

Valid.

---

# 7. The `final` Keyword

`final` means:

```text
Cannot Be Modified
```

Used for constants.

---

# 8. Final Variables

## Example

```java
final double PI = 3.14159;
```

After assignment:

```java
PI = 10;
```

Compilation Error.

---

## Naming Convention

Use:

```java
final double PI_VALUE = 3.14;
```

Rules:

```text
UPPERCASE
Words separated by _
```

---

## Initialization Styles

---

### During Declaration

```java
final int X = 10;
```

---

### Inside Constructor

```java
class Student {

    final int roll;

    Student(int r) {
        roll = r;
    }
}
```

Valid.

---

# 9. One-Time Assignment Rule

Valid:

```java
final int x;

x = 10;
```

---

Invalid:

```java
x = 20;
```

Second assignment not allowed.

---

# 10. Final Parameters

## Example

```java
void print(final String name)
{
    name = "Rohit";
}
```

Compilation Error.

---

### Why?

Method cannot modify parameter.

---

# 11. Final Methods

## Example

```java
class Parent {

    final void show() {
    }
}
```

---

Invalid:

```java
class Child extends Parent {

    void show() {
    }
}
```

Cannot override final method.

---

# 12. Final Classes

## Example

```java
final class Car {
}
```

---

Invalid:

```java
class BMW extends Car {
}
```

Cannot inherit.

---

# 13. Understanding `main()`

Java Entry Point:

```java
public static void main(String[] args)
```

---

# Breaking It Down

---

## public

Accessible to JVM.

---

## static

Can be called without object.

---

## void

Returns nothing.

---

## main

Special method name recognized by JVM.

---

## String[] args

Stores command line arguments.

---

# Why Is Main Static?

Suppose:

```java
public void main(String[] args)
```

Then JVM would need:

```java
Demo d = new Demo();
```

before running program.

But JVM doesn't know how to create your object.

Hence:

```java
main()
```

must be static.

---

# Execution Flow

```text
JVM Starts
      ↓
Class Loaded
      ↓
Static Blocks Execute
      ↓
main() Executes
```

---

# 14. Command Line Arguments

Program:

```java
public class Demo {

    public static void main(String[] args) {

        for(String s : args)
            System.out.println(s);
    }
}
```

Run:

```bash
java Demo Aditya Rohit Java
```

Output:

```text
Aditya
Rohit
Java
```

---

## Memory View

```text
args

+----------+
| Aditya   |
+----------+
| Rohit    |
+----------+
| Java     |
+----------+
```

---

# 15. Combining `static` and `final`

Very common.

---

## Example

```java
static final double PI = 3.14159;
```

---

### Static Means

```text
One Shared Copy
```

---

### Final Means

```text
Cannot Change
```

---

### Result

```text
One Shared Constant
```

---

# Static Final Initialization

## Direct

```java
static final int MAX = 100;
```

---

## Static Block

```java
static final int MAX;

static {
    MAX = 100;
}
```

Valid.

---

# Real Examples

```java
Math.PI
Integer.MAX_VALUE
Integer.MIN_VALUE
```

---

# Interview Questions

---

## Q1. Difference Between Static and Non-Static Variable?

| Static      | Non-Static    |
| ----------- | ------------- |
| One copy    | Separate copy |
| Class level | Object level  |
| Shared      | Not shared    |

---

## Q2. Can Static Method Access Instance Variables?

```text
No
```

Requires object.

---

## Q3. Can Static Method Use `this`?

```text
No
```

---

## Q4. How Many Times Does Static Block Execute?

```text
Once
```

per class loading.

---

## Q5. Can Constructor Be Static?

```text
No
```

Constructors belong to objects.

---

## Q6. Can Variables Be Both Static and Final?

```text
Yes
```

Example:

```java
static final double PI = 3.14;
```

---

## Q7. Why Is Main Static?

Because JVM must call it without creating an object.

---

## Q8. Can Final Variable Be Reassigned?

```text
No
```

Only one assignment allowed.

---

## Q9. Can Final Method Be Overridden?

```text
No
```

---

## Q10. Can Final Class Be Inherited?

```text
No
```

---

# Quick Revision Sheet

```text
STATIC
======
Belongs To Class

STATIC VARIABLE
===============
One Copy Shared By All Objects

STATIC METHOD
=============
Can Be Called Without Object

STATIC BLOCK
============
Runs Once During Class Loading

FINAL
=====
Cannot Change

FINAL VARIABLE
==============
Constant

FINAL METHOD
============
Cannot Override

FINAL CLASS
===========
Cannot Inherit

MAIN METHOD
===========
Program Entry Point

public static void main(String[] args)

STATIC + FINAL
==============
Shared Constant

Example:
Math.PI
```

---

# Memory Trick

```text
STATIC
======
Shared By Everyone

FINAL
=====
Locked Forever

STATIC + FINAL
==============
Shared And Locked

MAIN
====
JVM Calls Directly

THIS
====
Current Object

STATIC
======
No Current Object
```

---

# Complete Flow

```text
Program Starts
      ↓
Class Loaded
      ↓
Static Variables Created
      ↓
Static Block Executes
      ↓
main() Executes
      ↓
Objects Created
      ↓
Instance Variables Initialized
      ↓
Constructors Execute
```

---
