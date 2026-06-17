# Java Object Memory, Call by Value, Shallow Copy & Deep Copy

---

# Table of Contents

1. Object Memory Allocation
2. Stack vs Heap Memory
3. Reference Variables
4. Object Size Calculation
5. JVM Object Layout
6. Memory Diagrams
7. Call by Value vs Call by Reference
8. Java Parameter Passing
9. Shallow Copy
10. Deep Copy
11. Copy Constructor
12. Interview Questions
13. Quick Revision Sheet

---

# 1. Object Memory Allocation

Whenever an object is created:

```java
Student s1 = new Student();
```

Java uses two memory regions:

```text
Stack Memory
Heap Memory
```

---

## What Happens Internally?

```text
Student s1 = new Student();
```

### Step 1

Create reference variable

```text
s1
```

inside Stack Memory.

### Step 2

Allocate memory in Heap.

```text
new Student()
```

creates actual object.

### Step 3

Store object's address inside `s1`.

---

## Memory Diagram

```text
STACK

+-------------+
| s1 = 1000   |
+-------------+

       |
       ▼

HEAP

Address 1000

+-------------------+
| name              |
| age               |
| rollNumber        |
+-------------------+
```

---

# 2. Stack vs Heap Memory

## Stack Memory

Stores:

```text
Local Variables
Method Calls
Reference Variables
```

Example:

```java
int x = 10;
Student s1;
```

---

## Heap Memory

Stores:

```text
Objects
Arrays
Strings
```

Example:

```java
new Student()
new String("Java")
new int[10]
```

---

## Comparison Table

| Feature           | Stack                        | Heap              |
| ----------------- | ---------------------------- | ----------------- |
| Stores            | References & Local Variables | Objects           |
| Access Speed      | Faster                       | Slower            |
| Memory Management | Automatic                    | Garbage Collector |
| Lifetime          | Method Lifetime              | Object Lifetime   |

---

# 3. Reference Variables

A common misconception:

```java
Student s1 = new Student();
```

Many beginners think:

```text
s1 = Object
```

Wrong.

---

Actually:

```text
s1 = Address of Object
```

---

Visualization

```text
s1

  |
  ▼

Object in Heap
```

---

## Example

```java
Student s1 = new Student();
Student s2 = s1;
```

Memory:

```text
STACK

s1 = 1000
s2 = 1000

       |
       ▼

HEAP

Object @1000
```

Both references point to the same object.

---

# 4. Size of Reference Variables

Depends on JVM implementation.

Typical values:

| Architecture                 | Reference Size |
| ---------------------------- | -------------- |
| 32-bit JVM                   | 4 Bytes        |
| 64-bit JVM (Compressed OOPs) | 4 Bytes        |
| 64-bit JVM (No Compression)  | 8 Bytes        |

---

# 5. JVM Object Layout

Every object contains:

```text
Object Header
+
Fields
+
Padding
```

---

## Object Structure

```text
+--------------------+
| Object Header      |
+--------------------+
| Instance Fields    |
+--------------------+
| Padding            |
+--------------------+
```

---

# 6. Object Header

Contains JVM metadata.

---

## Mark Word

Usually:

```text
8 Bytes
```

Stores:

```text
Lock Information
Synchronization Data
Hash Code
GC Information
```

---

## Class Pointer

Usually:

```text
4 Bytes
```

Points to:

```text
Class Metadata
```

Example:

```java
Student.class
```

---

## Total Header Size

Typical:

```text
12 Bytes
```

---

# 7. Field Size Rules

| Type      | Size    |
| --------- | ------- |
| byte      | 1 Byte  |
| boolean   | 1 Byte  |
| char      | 2 Bytes |
| short     | 2 Bytes |
| int       | 4 Bytes |
| float     | 4 Bytes |
| reference | 4 Bytes |
| long      | 8 Bytes |
| double    | 8 Bytes |

---

# 8. Padding and Alignment

Modern CPUs prefer:

```text
8-byte alignment
```

Therefore JVM rounds object size to:

```text
Multiple of 8
```

---

# Example 1: Student Object

```java
class Student
{
    String name;
    int age;
    int roll;
    String college;
}
```

---

## Field Size

```text
name      = 4
age       = 4
roll      = 4
college   = 4

Total     = 16 Bytes
```

---

## Add Header

```text
Header = 12

16 + 12 = 28
```

---

## Alignment

Next multiple of 8:

```text
32
```

Padding:

```text
4 Bytes
```

---

## Final Size

```text
32 Bytes
```

---

# Example 2: Person Object

```java
class Person
{
    byte age;
}
```

---

Calculation:

```text
Header = 12
Field  = 1

Total = 13
```

Next multiple of 8:

```text
16
```

Padding:

```text
3 Bytes
```

Final Size:

```text
16 Bytes
```

---

# 9. Call by Value vs Call by Reference

Interview Favorite.

---

## Important Truth

Java is:

```text
100% Call By Value
```

There is NO true Call By Reference.

---

# Primitive Example

```java
static void change(int x)
{
    x = 100;
}
```

```java
int a = 10;
change(a);

System.out.println(a);
```

Output:

```text
10
```

---

## Why?

Memory:

```text
a = 10

copy

x = 10
```

Different variables.

---

Diagram

```text
MAIN

a = 10

       Copy

METHOD

x = 10
```

---

Changing:

```java
x = 100;
```

does not affect:

```java
a
```

---

# 10. Object Example

```java
class Student
{
    int age;
}
```

```java
static void update(Student s)
{
    s.age = 50;
}
```

---

```java
Student s1 = new Student();
s1.age = 20;

update(s1);
```

Output:

```text
50
```

---

Why?

Because copied value is:

```text
Address
```

not object.

---

Memory

```text
s1 = 1000

Copy

s  = 1000
```

Both point to same object.

---

Diagram

```text
s1 -----------+
              |
              ▼
         Student Object

s ------------+
```

---

# Interview Statement

Java is:

```text
Pass By Value
```

but value copied for objects is:

```text
Reference Address
```

which creates the illusion of:

```text
Pass By Reference
```

---

# 11. Shallow Copy

## Definition

Copying reference only.

---

Example

```java
Student s2 = s1;
```

---

Memory

```text
s1 = 1000
s2 = 1000
```

---

Diagram

```text
s1 -----+
         |
         ▼
      Object

s2 -----+
```

---

## Behavior

```java
s2.age = 50;
```

Then:

```java
System.out.println(s1.age);
```

Output:

```text
50
```

Same object.

---

## Characteristics

✅ Fast

✅ No extra memory

❌ Shared data

❌ Side effects possible

---

# 12. Deep Copy

## Definition

Create completely new object and copy data.

---

Example

```java
Student s2 = new Student();

s2.age = s1.age;
```

---

Memory

```text
s1 -> Object A

s2 -> Object B
```

---

Diagram

```text
s1
 |
 ▼
Object A

s2
 |
 ▼
Object B
```

---

## Behavior

```java
s2.age = 100;
```

does NOT affect:

```java
s1.age
```

---

# 13. Copy Constructor

Common way to perform deep copy.

---

Example

```java
class Student
{
    String name;
    int age;

    Student(Student other)
    {
        this.name = other.name;
        this.age = other.age;
    }
}
```

---

Usage

```java
Student s2 = new Student(s1);
```

---

Flow

```text
Original Object
        |
        ▼
Copy Constructor
        |
        ▼
New Independent Object
```

---

# 14. Shallow vs Deep Copy

| Feature           | Shallow Copy | Deep Copy |
| ----------------- | ------------ | --------- |
| New Object        | No           | Yes       |
| Memory Allocation | No           | Yes       |
| Shares Data       | Yes          | No        |
| Faster            | Yes          | No        |
| Independent       | No           | Yes       |

---

# 15. Interview Questions

---

## Q1. Where are objects stored?

```text
Heap Memory
```

---

## Q2. Where are references stored?

```text
Stack Memory
```

---

## Q3. What is stored inside reference variable?

```text
Memory Address
```

---

## Q4. Does Java support Call By Reference?

```text
No
```

Java is strictly:

```text
Call By Value
```

---

## Q5. Why do object changes reflect outside methods?

Because copied value is:

```text
Reference Address
```

and both references point to same object.

---

## Q6. What is shallow copy?

Copying address only.

---

## Q7. What is deep copy?

Creating new object and copying data.

---

## Q8. What is Copy Constructor?

Constructor that receives object of same class and copies data.

---

## Q9. What is object header?

JVM metadata area storing:

```text
Lock Information
GC Information
Class Information
```

---

## Q10. Why does JVM use padding?

For:

```text
Memory Alignment
CPU Optimization
```

---

# Quick Revision Sheet

```text
STACK
=====
References
Local Variables

HEAP
====
Objects
Arrays
Strings

REFERENCE
=========
Stores Address

OBJECT SIZE
===========
Header + Fields + Padding

HEADER
======
Mark Word + Class Pointer

JAVA
====
100% Call By Value

PRIMITIVE
=========
Value Copied

OBJECT
======
Reference Address Copied

SHALLOW COPY
============
Copy Address

DEEP COPY
=========
Copy Data

COPY CONSTRUCTOR
================
Creates Independent Object
```

---

# Memory Trick

```text
REFERENCE
=========
Address Holder

OBJECT
======
Data Holder

SHALLOW COPY
============
Same House
Two Names

DEEP COPY
=========
Two Different Houses

JAVA
====
Never Passes Objects

Only Passes
Values
```

---

# Complete Object Formula

```text
Student s1 = new Student();

        |
        ▼
Reference Created
        |
        ▼
Heap Memory Allocated
        |
        ▼
Object Header Created
        |
        ▼
Fields Initialized
        |
        ▼
Constructor Executes
        |
        ▼
Address Returned
        |
        ▼
Stored In Reference Variable
```

---

