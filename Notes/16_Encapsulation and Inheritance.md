# Encapsulation, Access Modifiers, Packages & Inheritance in Java

---

# Table of Contents

1. Encapsulation
2. Why Encapsulation?
3. Bank Account Example
4. Access Modifiers
5. Packages in Java
6. Inheritance
7. Types of Inheritance
8. Diamond Problem
9. `super` Keyword
10. Getters and Setters
11. Memory & Inheritance Flow
12. Interview Questions
13. Quick Revision Sheet

---

# 1. Encapsulation: First Pillar of OOP

## Definition

**Encapsulation** is the process of wrapping:

* Data (Variables)
* Behavior (Methods)

into a single unit called a **Class**.

---

## Real-Life Example

Think about a medicine capsule:

```text
┌────────────────────┐
│     CAPSULE        │
│                    │
│  Medicine A        │
│  Medicine B        │
│  Medicine C        │
└────────────────────┘
```

Different medicines are enclosed inside one capsule.

Similarly:

```text
┌────────────────────┐
│      Student       │
│--------------------│
│ Name               │
│ Age                │
│ Roll Number        │
│ College            │
│--------------------│
│ printDetails()     │
│ markAttendance()   │
└────────────────────┘
```

Data and behavior are grouped together.

---

# 2. Two Core Principles of Encapsulation

## Principle 1: Bundle Data and Methods

Keep related variables and methods together.

### Bad Design

```java
String name;
int age;
int rollNumber;
```

Scattered everywhere.

---

### Good Design

```java
class Student {
    String name;
    int age;
    int rollNumber;

    void printDetails() {
        System.out.println(name);
    }
}
```

Everything is grouped.

---

## Principle 2: Restrict Direct Access

Not everyone should modify data directly.

---

# 3. Bank Account Example

---

## Without Encapsulation

```java
class BankAccount {

    public double balance;
}
```

Usage:

```java
BankAccount acc = new BankAccount();

acc.balance = 1000000;
```

Problem:

```text
Anyone can become a millionaire!
```

No validation exists.

---

## With Encapsulation

```java
class BankAccount {

    private double balance;

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {

        if(amount <= balance)
            balance -= amount;
    }
}
```

---

## Flow Diagram

```text
User
 │
 ▼
deposit()
 │
 ▼
Validation
 │
 ▼
Balance Updated
```

Direct modification blocked.

---

# Advantages of Encapsulation

### Security

Protects sensitive data.

### Validation

Checks data before storing.

### Maintainability

Easy to modify later.

### Flexibility

Internal implementation can change.

---

# 4. Access Modifiers

Access modifiers decide:

```text
Who can access what?
```

---

## Access Modifier Hierarchy

```text
Private
   ↓
Default
   ↓
Protected
   ↓
Public
```

More downward = More Accessible

---

## Comparison Table

| Modifier  | Same Class | Same Package | Child Class | Anywhere |
| --------- | ---------- | ------------ | ----------- | -------- |
| Private   | ✅          | ❌            | ❌           | ❌        |
| Default   | ✅          | ✅            | ❌           | ❌        |
| Protected | ✅          | ✅            | ✅           | ❌        |
| Public    | ✅          | ✅            | ✅           | ✅        |

---

# Private

Most restricted.

```java
class Student {

    private String name;
}
```

Only inside Student class.

---

# Default

No keyword used.

```java
class Student {
}
```

Accessible inside same package.

---

# Protected

```java
protected int age;
```

Accessible:

* Same package
* Child classes

---

# Public

```java
public String name;
```

Accessible from anywhere.

---

# Memory View

```text
PUBLIC
┌───────────────────┐
│ Accessible All    │
└───────────────────┘

PROTECTED
┌───────────────────┐
│ Package + Child   │
└───────────────────┘

DEFAULT
┌───────────────────┐
│ Package Only      │
└───────────────────┘

PRIVATE
┌───────────────────┐
│ Class Only        │
└───────────────────┘
```

---

# Root-Level Class Restriction

Valid:

```java
public class Student
```

```java
class Student
```

Invalid:

```java
private class Student
```

```java
protected class Student
```

Reason:

Root class has no parent context.

---

# 5. Packages in Java

## What is a Package?

A package is simply a folder containing related classes.

---

## Real-Life Example

```text
college
│
├── Student.java
├── Teacher.java
└── Course.java
```

---

## Creating Package

```java
package college;
```

Must be first line.

---

## Importing Classes

```java
import college.Student;
```

Now Student class can be used.

---

## Import Flow

```text
Main Program
      │
      ▼
Import Statement
      │
      ▼
JVM Loads Class Bytecode
      │
      ▼
Class Available
```

---

# Common Java Packages

## java.lang

Imported automatically.

Contains:

```java
String
Math
System
Integer
```

---

## java.util

Contains:

```java
ArrayList
Scanner
HashMap
```

---

## java.io

Contains:

```java
File
BufferedReader
PrintWriter
```

---

# 6. Inheritance

## Definition

Inheritance allows one class to acquire properties and methods from another class.

---

## Real-Life Relationship

```text
Car IS-A Vehicle
```

```text
Dog IS-A Animal
```

```text
MedicalStudent IS-A Student
```

---

## Syntax

```java
class Child extends Parent
{
}
```

---

## Example

```java
class Vehicle {

    void start() {
        System.out.println("Vehicle Started");
    }
}
```

```java
class Car extends Vehicle {

}
```

Usage:

```java
Car c = new Car();

c.start();
```

Output:

```text
Vehicle Started
```

---

# Inheritance Diagram

```text
      Vehicle
         │
         │
   ┌─────┴─────┐
   │           │
  Car        Bike
```

Both inherit start().

---

# Advantage: Code Reusability

Without inheritance:

```java
Car -> start()
Bike -> start()
Truck -> start()
```

Repeated code.

---

With inheritance:

```text
Vehicle
  │
  ├─ start()
  │
  ├─ Car
  ├─ Bike
  └─ Truck
```

One implementation.

---

# 7. Types of Inheritance

---

## 1. Single Inheritance

```text
A
│
B
```

```java
class B extends A
```

---

## 2. Multi-Level Inheritance

```text
Student
   │
EngineeringStudent
   │
CSEStudent
```

---

## 3. Hierarchical Inheritance

```text
          Student
         /   |   \
        /    |    \
      CSE  ECE  Medical
```

One parent.

Many children.

---

## 4. Multiple Inheritance

```text
      A
     / \
    /   \
   B     C
```

Not allowed for classes.

---

# 8. Diamond Problem

Suppose:

```java
class A {
    void show()
}
```

```java
class B {
    void show()
}
```

Child:

```java
class C extends A, B
```

Now:

```java
C c = new C();
c.show();
```

Question:

```text
Which show() should execute?
A.show() ?
B.show() ?
```

Ambiguity.

---

## Diamond Diagram

```text
        A
       / \
      /   \
     B     C
      \   /
       \ /
        D
```

This ambiguity is called:

```text
Diamond Problem
```

Therefore:

```text
Java does NOT support
multiple inheritance using classes.
```

---

# 9. The `super` Keyword

## Definition

`super` refers to the parent class object.

---

## `this` vs `super`

| Keyword | Refers To      |
| ------- | -------------- |
| this    | Current Object |
| super   | Parent Object  |

---

# Use 1: Access Parent Variable

```java
class Parent {

    int x = 10;
}
```

```java
class Child extends Parent {

    int x = 20;

    void print() {

        System.out.println(super.x);
    }
}
```

Output:

```text
10
```

---

# Use 2: Call Parent Method

```java
class Parent {

    void show() {
        System.out.println("Parent");
    }
}
```

```java
class Child extends Parent {

    void show() {

        super.show();

        System.out.println("Child");
    }
}
```

Output:

```text
Parent
Child
```

---

# Use 3: Call Parent Constructor

Parent:

```java
class Person {

    Person(String name) {

    }
}
```

Child:

```java
class Student extends Person {

    Student(String name) {

        super(name);
    }
}
```

---

## Rule

```java
super(...)
```

must be FIRST statement.

---

## Invalid

```java
Student() {

    System.out.println("Hello");

    super();
}
```

Compilation Error.

---

# Constructor Flow

```text
Create Child Object
       │
       ▼
Parent Constructor
       │
       ▼
Child Constructor
```

Parent always initializes first.

---

# 10. Getters and Setters

Professional encapsulation uses:

```text
Private Variables
+
Public Methods
```

---

# Getter

Returns value.

```java
public String getName() {
    return name;
}
```

---

# Setter

Updates value.

```java
public void setName(String name) {
    this.name = name;
}
```

---

# Full Example

```java
class Student {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

Usage:

```java
Student s = new Student();

s.setName("Aditya");

System.out.println(s.getName());
```

Output:

```text
Aditya
```

---

# Validation Using Setter

```java
class Student {

    private int age;

    public void setAge(int age) {

        if(age >= 0 && age <= 150)
            this.age = age;
    }
}
```

---

## Flow

```text
User Input
     │
     ▼
 Setter
     │
 Validation
     │
 ┌───┴────┐
 │        │
Valid   Invalid
 │        │
 ▼        ▼
Store   Reject
```

---

# Interview Questions

## Q1. What is Encapsulation?

Wrapping data and methods into one unit and restricting direct access.

---

## Q2. Why Use Private Variables?

To protect data and enforce validation.

---

## Q3. Difference Between Public and Private?

| Public                | Private                      |
| --------------------- | ---------------------------- |
| Accessible Everywhere | Accessible Only Inside Class |

---

## Q4. What is a Package?

A folder containing related classes and interfaces.

---

## Q5. What is Inheritance?

Acquiring properties and methods from another class.

---

## Q6. Which Keyword is Used for Inheritance?

```java
extends
```

---

## Q7. Why Doesn't Java Support Multiple Inheritance?

Because of:

```text
Diamond Problem
```

---

## Q8. What is `super`?

Reference to parent class object.

---

## Q9. Difference Between `this` and `super`?

| this           | super         |
| -------------- | ------------- |
| Current Object | Parent Object |

---

## Q10. What are Getters and Setters?

Methods used to access and modify private variables safely.

---

# Quick Revision Sheet

```text
ENCAPSULATION
=============
Wrap Data + Methods

GOALS
=====
1. Group Data
2. Restrict Access

ACCESS MODIFIERS
================
Private
Default
Protected
Public

PACKAGE
=======
Folder Of Classes

IMPORT
======
Makes Classes Available

INHERITANCE
===========
IS-A Relationship

KEYWORD
=======
extends

TYPES
=====
Single
Multilevel
Hierarchical

NOT SUPPORTED
=============
Multiple Inheritance (Classes)

REASON
======
Diamond Problem

SUPER
=====
Parent Reference

USES OF SUPER
=============
1. Parent Variable
2. Parent Method
3. Parent Constructor

GETTER
======
Read Data

SETTER
======
Modify Data

BENEFIT
=======
Validation + Security
```

---

# Complete OOP Flow

```text
Class Created
      │
      ▼
Encapsulation
(Data + Methods)
      │
      ▼
Access Modifiers
(Control Access)
      │
      ▼
Packages
(Organize Classes)
      │
      ▼
Inheritance
(Code Reuse)
      │
      ▼
super
(Access Parent)
      │
      ▼
Getters & Setters
(Safe Access)
```

---
