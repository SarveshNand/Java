# Java Memory Management & JVM Memory Areas

---

# 1. What is Memory Management?

Memory Management is the process of:

```text
Allocate Memory
      ↓
Use Memory
      ↓
Free Memory
```

performed by the JVM.

---

# Why Memory Management?

Every Java application continuously creates:

* Objects
* Arrays
* Variables
* Threads
* Method Calls

All require memory.

Example:

```java
String name = "John";

Student s =
        new Student("Aditya",28);
```

Memory must be allocated and later released.

---

# Without Memory Management

Imagine:

```text
Create Object
Create Object
Create Object
Create Object
Create Object
```

But never remove them.

Result:

```text
Memory Full
Program Crash
```

---

# Manual vs Automatic Memory Management

---

## C/C++

Programmer manages memory.

```cpp
Student* s = new Student();

delete s;
```

If forgotten:

```text
Memory Leak
```

---

## Java

JVM handles cleanup.

```java
Student s =
        new Student();
```

No delete keyword.

Garbage Collector handles cleanup.

---

# Interview Question

### Why Java doesn't have delete keyword?

Because memory is managed automatically through Garbage Collection.

---

# 2. JVM Memory Architecture

The JVM divides memory into multiple areas.

---

# Complete JVM Memory Layout

```text
                   JVM MEMORY

 ┌─────────────────────────────────────┐
 │                                     │
 │            Method Area              │
 │                                     │
 └─────────────────────────────────────┘

 ┌─────────────────────────────────────┐
 │                                     │
 │               Heap                  │
 │                                     │
 └─────────────────────────────────────┘


        Thread 1                 Thread 2

 ┌───────────────┐      ┌───────────────┐
 │     Stack     │      │     Stack     │
 └───────────────┘      └───────────────┘

 ┌───────────────┐      ┌───────────────┐
 │ PC Register   │      │ PC Register   │
 └───────────────┘      └───────────────┘
```

---

# Memory Classification

## Shared By All Threads

```text
Method Area
Heap
```

---

## Private To Each Thread

```text
Stack
PC Register
```

---

# Memory Trick

```text
Shared
    →
Method Area
Heap

Private
    →
Stack
PC Register
```

---

# 3. Method Area

Also called:

```text
Class Metadata Area
```

Stores class-level information.

---

# What Gets Stored?

```text
Class Names

Method Definitions

Bytecode

Static Variables

Constant Pool

Inheritance Information
```

---

# Example

```java
class Student {

    static String college =
        "ABC College";

    void display() {

    }

}
```

Stored in Method Area:

```text
Student Class

display()

college

Bytecode
```

---

# Method Area Diagram

```text
Method Area

 ┌─────────────────────┐

 Student Class

 display()

 static college

 Bytecode

 └─────────────────────┘
```

---

# Why Needed?

When JVM sees:

```java
new Student();
```

it must know:

```text
What is Student?

What fields exist?

What methods exist?
```

Information comes from Method Area.

---

# Interview Question

### Are static variables stored in Heap?

No.

Stored in:

```text
Method Area
```

(Class-level memory)

---

# 4. Heap Memory

Largest JVM memory area.

---

# Purpose

Stores:

```text
Objects

Arrays

Instance Variables

String Pool Objects
```

---

# Example

```java
Student s =
    new Student();
```

Object goes to:

```text
Heap
```

---

# Heap Diagram

```text
Heap

 ┌─────────────────────┐

 Student Object

 name = Aditya

 age = 28

 └─────────────────────┘
```

---

# Why Heap?

Objects usually live longer.

Need dynamic memory.

---

# Characteristics

```text
Shared Memory

Managed By GC

Largest Area
```

---

# Interview Question

### Where are Objects Stored?

Answer:

```text
Heap Memory
```

---

# 5. Stack Memory

Also called:

```text
Execution Memory
```

Stores method execution information.

---

# What Gets Stored?

```text
Local Variables

Method Parameters

References

Return Addresses
```

---

# Example

```java
void test(){

    int x = 10;

}
```

Stored in stack:

```text
x = 10
```

---

# Stack Structure

Uses:

```text
LIFO

Last In First Out
```

---

# Stack Visualization

```text
TOP

MethodB()

MethodA()

main()

BOTTOM
```

---

# Method Call Flow

```java
main()
{
    methodA();
}

methodA()
{
    methodB();
}
```

Stack:

```text
TOP

methodB()

methodA()

main()
```

---

# When methodB Ends

```text
POP methodB
```

Stack becomes:

```text
TOP

methodA()

main()
```

---

# Why Stack Is Fast?

Operations:

```text
Push
Pop
```

Only pointer movement.

No Garbage Collection.

---

# Speed Comparison

```text
Stack
   ↓
Very Fast

Heap
   ↓
Slower
```

---

# 6. Stack Frame

Each method call creates a:

```text
Stack Frame
```

---

# Stack Frame Contents

```text
Local Variables

Parameters

Return Address

Temporary Variables
```

---

# Example

```java
void add(int a,int b){

    int sum = a+b;

}
```

Frame:

```text
Stack Frame

a

b

sum

return address
```

---

# Stack Frame Diagram

```text
┌────────────────┐

return address

sum

b

a

└────────────────┘
```

---

# 7. Return Address

Frequently asked JVM interview topic.

---

# Problem

Suppose:

```java
main()
{
    methodA();

    System.out.println("Done");
}
```

When:

```java
methodA()
```

finishes,

JVM must know:

```text
Where should execution continue?
```

---

# Solution

Store:

```text
Return Address
```

inside Stack Frame.

---

# Diagram

```text
main()

Line 10 -> methodA()

Line 11 -> Print Done

Return Address = Line 11
```

---

# Execution Flow

```text
methodA finishes
      │
      ▼

Read Return Address
      │
      ▼

Resume Line 11
```

---

# 8. Program Counter (PC Register)

Small memory area.

One PC Register per thread.

---

# Purpose

Stores:

```text
Current Instruction Address
```

being executed.

---

# Example

```java
System.out.println("A");

System.out.println("B");

System.out.println("C");
```

PC Register tracks:

```text
Current Line
```

---

# Why Needed?

Without PC Register:

```text
JVM doesn't know
which instruction to execute next.
```

---

# PC Register Flow

```text
Instruction 1

PC -> 1

Instruction 2

PC -> 2

Instruction 3

PC -> 3
```

---

# Interview Question

### Why does every thread have its own PC Register?

Because each thread executes different instructions independently.

---

# 9. Class Loading Process

When JVM starts:

```java
Student s =
    new Student();
```

JVM must first load Student class.

---

# Class Loading Steps

```text
.class File
      │
      ▼

Class Loader
      │
      ▼

Method Area
      │
      ▼

Ready For Object Creation
```

---

# Workflow Diagram

```text
Student.class

       │

       ▼

Class Loader

       │

       ▼

Method Area

       │

       ▼

new Student()
```

---

# 10. Complete Execution Example

Code:

```java
int x = 5;

Student s =
    new Student(
        "Aditya",
        28
    );
```

---

# Step 1

Class Loader loads:

```text
Student.class
```

into:

```text
Method Area
```

---

# Step 2

Main thread starts.

Creates:

```text
Stack

PC Register
```

---

# Step 3

Primitive variable:

```java
int x = 5;
```

stored in:

```text
Stack
```

---

# Step 4

Object creation:

```java
new Student(...)
```

stored in:

```text
Heap
```

---

# Step 5

Reference variable:

```java
s
```

stored in:

```text
Stack
```

pointing to heap.

---

# Diagram

```text
Stack

s ─────────────┐
               │
               ▼

Heap

Student Object

name = Aditya

age = 28
```

---

# Step 6

Method ends.

Stack frame removed.

Reference disappears.

```text
s removed
```

---

# Heap Object

Now has:

```text
No References
```

---

# Result

Object becomes:

```text
Eligible For Garbage Collection
```

---

# 11. Garbage Collection Basics

GC removes:

```text
Unused Objects
```

from heap.

---

# Reachability Concept

Referenced Object:

```text
Reachable
```

Not collected.

---

# Example

```java
Student s =
    new Student();
```

Object reachable.

---

# Example

```java
s = null;
```

Now:

```text
No Reference
```

Object becomes:

```text
Garbage
```

---

# Reachability Diagram

```text
Reference Exists?
     │
 ┌───┴───┐
 │       │
Yes      No
 │       │
 ▼       ▼

Alive   GC Eligible
```

---

# Important Interview Question

### Does GC immediately remove an object?

No.

Object becomes:

```text
Eligible For Collection
```

Actual removal depends on JVM.

---

# 12. Heap Tuning

JVM heap size can be configured.

---

# Initial Heap

```bash
-Xms512m
```

Meaning:

```text
Initial Heap = 512 MB
```

---

# Maximum Heap

```bash
-Xmx2g
```

Meaning:

```text
Maximum Heap = 2 GB
```

---

# Example

```bash
java -Xms512m -Xmx2g App
```

---

# Memory Growth

```text
Start
  │
512 MB
  │
Grow
  │
2 GB Max
```

---

# 13. OutOfMemoryError

Occurs when:

```text
Heap Full
```

and JVM cannot allocate more memory.

---

# Example

```java
List<Object> list =
    new ArrayList<>();

while(true){

    list.add(new Object());

}
```

Result:

```text
OutOfMemoryError
```

---

# Flow

```text
Create Object
      │
      ▼

Heap Full
      │
      ▼

GC Runs
      │
      ▼

No Space
      │
      ▼

OutOfMemoryError
```

---

# 14. StackOverflowError

Occurs when:

```text
Stack Full
```

---

# Common Cause

Infinite recursion.

Example:

```java
void test(){

    test();

}
```

---

# What Happens?

```text
test()

test()

test()

test()

test()

...
```

New stack frames continuously created.

Eventually:

```text
Stack Full
```

---

# Result

```java
StackOverflowError
```

---

# Stack Overflow Diagram

```text
TOP

test()

test()

test()

test()

test()

No Space Left
```

---

# Stack vs Heap

| Feature         | Stack              | Heap             |
| --------------- | ------------------ | ---------------- |
| Stores          | Local Variables    | Objects          |
| Access Speed    | Fast               | Slower           |
| Shared          | No                 | Yes              |
| Managed By      | JVM Push/Pop       | GC               |
| Thread Specific | Yes                | No               |
| Error           | StackOverflowError | OutOfMemoryError |
| Structure       | LIFO               | Dynamic          |

---

# Memory Leaks in Java

Many think Java cannot have memory leaks.

Wrong.

---

# Example

```java
static List<Object> cache =
        new ArrayList<>();
```

```java
cache.add(new Object());
```

Repeated forever.

Objects remain referenced.

GC cannot remove them.

---

# Memory Leak Definition

```text
Objects Not Needed
But Still Reachable
```

---

# Best Practices

✔ Null unused references

✔ Close resources

✔ Use try-with-resources

✔ Avoid unnecessary static collections

✔ Use proper cache eviction

✔ Monitor heap usage

---

# Quick Revision Sheet

```text
Method Area
    -> Class Metadata

Heap
    -> Objects & Arrays

Stack
    -> Local Variables

PC Register
    -> Current Instruction

Stack Frame
    -> Method Execution

Return Address
    -> Resume Point

GC
    -> Heap Cleanup

OutOfMemoryError
    -> Heap Full

StackOverflowError
    -> Stack Full

-Xms
    -> Initial Heap

-Xmx
    -> Maximum Heap
```

---

# JVM Memory Trick

```text
Method Area
     ↓
Blueprint

Heap
     ↓
Objects

Stack
     ↓
Execution

PC Register
     ↓
Instruction Pointer
```

---

# Interview One-Liner

"Java Memory Management is handled by the JVM through distinct memory regions such as the Method Area, Heap, Stack, and PC Register. Objects are allocated in the Heap, execution state is maintained in Stack Frames, class metadata resides in the Method Area, and memory cleanup is largely automated through Garbage Collection."
