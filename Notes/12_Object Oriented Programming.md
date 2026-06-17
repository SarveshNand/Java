# Java OOP: Classes & Objects

---

# Table of Contents

1. Why OOP Was Introduced
2. Procedural Programming Problems
3. What is OOP?
4. Real World Modeling
5. Class vs Object
6. Blueprint Analogy
7. Creating a Class
8. Creating Objects
9. Stack vs Heap Memory
10. Reference Variables
11. Dot Operator
12. Fields vs Methods
13. Object Lifecycle
14. Multiple Objects
15. Naming Conventions
16. Java and OOP
17. Common Interview Questions
18. Quick Revision Sheet

---

# 1. Why OOP Was Introduced

Before OOP, programmers mostly used:

```text
Procedural Programming
```

Programs were built using:

- Variables
- Functions
- Loops
- Conditions

---

# Problem Example

Suppose we want to represent a student.

Without OOP:

```java
String name = "Aditya";
int age = 20;
int roll = 101;
String college = "ABC";
```

---

# Problem 1: Data is Scattered

```text
name
age
roll
college
```

are separate variables.

The compiler sees them independently.

---

Humans know:

```text
All belong to one student.
```

Compiler doesn't.

---

# Problem 2: Multiple Students

Student 2:

```java
String name2="Rohit";
int age2=21;
int roll2=102;
```

Student 3:

```java
String name3="Aman";
int age3=22;
int roll3=103;
```

Code becomes:

❌ Huge

❌ Difficult to maintain

❌ Error-prone

---

# Problem 3: Function Calls

Suppose we want to print student details.

---

Without OOP:

```java
print(name,age,roll,college);
```

Need to pass every variable.

---

Imagine:

```text
20 fields
```

Now function call becomes:

```java
print(field1,
      field2,
      field3,
      ...
      field20);
```

Very messy.

---

# Problem 4: No Ownership

Any code can modify variables.

Example:

```java
age = -500;
```

No structure controls the data.

---

# 2. What is OOP?

OOP stands for:

```text
Object Oriented Programming
```

---

# Definition

A programming paradigm that models software using:

```text
Objects
```

similar to real-world entities.

---

# Goal

```text
Group related data and behavior together.
```

---

# Real World Example

Student:

Characteristics:

```text
Name
Age
Roll Number
College
```

Behaviors:

```text
Attend Class
Give Exam
Mark Attendance
```

---

OOP allows us to represent this directly.

---

# 3. Real World Modeling

---

# Important Idea

We DO NOT copy reality completely.

We copy only:

```text
Relevant Features
```

---

Example:

Student in College Portal

Needed:

```text
Name
Roll Number
Email
```

Not Needed:

```text
Favorite Food
Shoe Size
Blood Group
```

unless application requires them.

---

# Another Example

Bank Account

Properties:

```text
Account Number
Balance
```

Behaviors:

```text
Deposit()
Withdraw()
```

---

# Non-Physical Objects

OOP can model:

✅ Bank Accounts

✅ GPS Coordinates

✅ Transactions

✅ Shopping Carts

✅ Online Orders

---

# 4. Class vs Object

Most Important OOP Interview Question

---

# Class

A class is:

```text
Blueprint
Template
Design
```

It describes what an object will contain.

---

Example:

```java
class Student
{
    String name;
    int age;
}
```

No actual student exists yet.

---

# Object

Object is:

```text
Actual Instance
```

created from class.

---

Example:

```java
Student s1 = new Student();
```

Now an actual student exists.

---

# Blueprint Analogy

---

# House Blueprint

Architect Draws:

```text
House Design
```

Blueprint:

```text
2 Bedrooms
1 Kitchen
1 Hall
```

---

Does blueprint contain actual rooms?

```text
NO
```

---

Actual House:

```text
Concrete Building
```

is equivalent to:

```text
Object
```

---

# Summary

| Class | Object |
|---------|---------|
| Blueprint | Real Instance |
| No actual data | Holds actual data |
| Design | Implementation |
| Logical entity | Physical entity |

---

# 5. Creating a Class

---

## Syntax

```java
class Student
{
    String name;
    int age;
}
```

---

# Visualization

```text
Student

+----------------+
| name           |
| age            |
+----------------+
```

---

This only defines structure.

No memory for students yet.

---

# 6. Creating Objects

---

## Step 1: Declaration

```java
Student s1;
```

---

Memory:

```text
Stack

+------+
| s1 ? |
+------+
```

Object not created yet.

---

# Step 2: Instantiation

```java
s1 = new Student();
```

---

Now JVM creates object.

---

# Combined Form

```java
Student s1 = new Student();
```

Most common.

---

# Memory Visualization

```text
Stack

+----------+
| s1=1000  |
+----------+

      |
      ▼

Heap

Address 1000

+-------------+
| name = null |
| age = 0     |
+-------------+
```

---

# Key Point

```text
s1 is NOT object.
```

---

It is:

```text
Reference Variable
```

pointing to object.

---

# 7. Understanding "new"

Interview Favorite

---

# What does new do?

```java
new Student()
```

performs:

```text
1. Allocates Memory

2. Creates Object

3. Returns Reference
```

---

Flowchart

```text
new Student()
      |
      ▼
Allocate Heap Memory
      |
      ▼
Initialize Fields
      |
      ▼
Return Address
```

---

# Example

```java
Student s1 = new Student();
```

Suppose object starts at:

```text
Address 5000
```

Then:

```text
s1 = 5000
```

---

# 8. Stack vs Heap Memory

Very Important

---

# Stack

Stores:

```text
Primitive Variables
References
Function Calls
```

---

Example

```java
int x = 10;
```

```text
Stack

x = 10
```

---

# Heap

Stores:

```text
Objects
Arrays
Strings
```

---

Example

```java
new Student()
```

Stored in:

```text
Heap
```

---

# Full Diagram

```text
STACK

s1 = 5000

      |
      ▼

HEAP

5000

+-----------+
| name      |
| age       |
+-----------+
```

---

# 9. Dot Operator

Used to access object members.

---

Syntax

```java
reference.member
```

---

Assigning Values

```java
s1.name = "Aditya";
s1.age = 20;
```

---

Reading Values

```java
System.out.println(s1.name);
```

---

# Internal Working

```text
s1
 ↓
Object Address
 ↓
Find field
 ↓
Read/Write value
```

---

# Memory Diagram

```text
s1

 |
 ▼

+------------------+
| name="Aditya"    |
| age=20           |
+------------------+
```

---

# 10. Fields vs Methods

Objects contain:

```text
Data + Behavior
```

---

# Fields (Variables)

Store information.

```java
String name;
int age;
```

---

# Methods (Functions)

Define actions.

```java
void study()
{
}
```

---

# Example

```java
class Student
{
    String name;

    void markAttendance()
    {
        System.out.println("Marked");
    }
}
```

---

# Real World Mapping

```text
Characteristics
      ↓
    Fields

Behaviors
      ↓
    Methods
```

---

# 11. Complete Example

```java
class Student
{
    String name;
    int age;

    void markAttendance()
    {
        System.out.println(name + " present");
    }
}
```

---

Object Creation

```java
Student s1 = new Student();

s1.name = "Aditya";
s1.age = 20;

s1.markAttendance();
```

Output:

```text
Aditya present
```

---

# Execution Flow

```text
Create Object
      |
      ▼
Assign Values
      |
      ▼
Call Method
      |
      ▼
Method Executes
```

---

# 12. Multiple Objects

---

Example

```java
Student s1 = new Student();
Student s2 = new Student();
```

---

Memory

```text
Stack

s1 = 1000
s2 = 2000


Heap

1000 → Student Object

2000 → Student Object
```

---

# Visualization

```text
Student Object 1

Name: Aditya

Student Object 2

Name: Rohit
```

Independent objects.

---

# 13. Object Lifecycle

---

Creation

```java
new Student()
```

---

Usage

```java
s1.name="Aditya";
```

---

Becomes Unreachable

```java
s1 = null;
```

---

Garbage Collection

```text
JVM automatically frees memory.
```

---

Flowchart

```text
Object Created
      |
      ▼
Object Used
      |
      ▼
No References Left
      |
      ▼
Garbage Collector
      |
      ▼
Memory Released
```

---

# 14. Naming Conventions

---

# Classes

Use:

```text
Pascal Case
```

Examples:

```java
Student
BankAccount
EmployeeRecord
```

---

# Variables

Use:

```text
camelCase
```

Examples:

```java
firstName
studentAge
rollNumber
```

---

# Methods

Use:

```text
camelCase
```

Examples:

```java
markAttendance()
calculateSalary()
```

---

# Constants

Use:

```text
UPPER_CASE
```

Example:

```java
MAX_SIZE
```

---

# 15. Java and OOP

---

Java is:

```text
Almost Completely OOP
```

---

Reason:

Everything is organized inside:

```java
class
```

---

Even simplest Java program:

```java
public class Demo
{
    public static void main(String[] args)
    {
    }
}
```

requires:

```text
Class
```

---

# Why "Almost" OOP?

Because Java still supports:

```text
Primitive Types
```

such as:

```java
int
double
char
boolean
```

which are not objects.

---

# Common Interview Questions

---

## Q1. Difference between Class and Object?

Class:

```text
Blueprint
```

Object:

```text
Instance
```

---

## Q2. Where are objects stored?

```text
Heap Memory
```

---

## Q3. Where are references stored?

```text
Stack Memory
```

---

## Q4. What does new do?

Creates object and allocates heap memory.

---

## Q5. Is s1 an object?

```java
Student s1;
```

No.

It is a:

```text
Reference Variable
```

---

## Q6. Why OOP?

To combine:

```text
Data + Behavior
```

inside one unit.

---

## Q7. What happens if reference becomes null?

Object becomes eligible for:

```text
Garbage Collection
```

---

## Q8. Can one class create multiple objects?

Yes.

```java
Student s1;
Student s2;
Student s3;
```

all from same class.

---

# Quick Revision Sheet

```text
OOP
===
Object Oriented Programming

CLASS
=====
Blueprint

OBJECT
======
Instance of Class

NEW
===
Creates Object

STACK
=====
Reference Variable

HEAP
====
Actual Object

FIELDS
======
Data

METHODS
=======
Behavior

DOT OPERATOR
============
Access Members

CLASS
=====
PascalCase

VARIABLE
========
camelCase

METHOD
======
camelCase
```

---

# Memory Trick

```text
CLASS
=====
Design

OBJECT
======
Real Thing

REFERENCE
=========
Address Holder

NEW
===
Allocate Memory

FIELDS
======
Characteristics

METHODS
=======
Behaviors

STACK
=====
Reference

HEAP
====
Object
```

---

# OOP Foundation Formula

```text
Class
   ↓
Object
   ↓
Fields + Methods
   ↓
Real World Modeling
```

---
