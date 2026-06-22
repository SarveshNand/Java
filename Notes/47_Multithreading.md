# Java Multithreading Fundamentals

---

# 1. Introduction

Before learning Java Multithreading, it is important to understand three fundamental concepts:

```text
Program
   ↓
Process
   ↓
Thread
```

Most interview questions on multithreading start from these basics.

---

# 2. What is a Program?

A **Program** is a collection of instructions written in a programming language and stored on disk.

Examples:

```text
Demo.java

Demo.class

Calculator.exe
```

A program is:

* Passive
* Not executing
* Stored on HDD/SSD

---

## Program Diagram

```text
Hard Disk

 ┌───────────────┐
 │   Demo.java   │
 └───────────────┘

        OR

 ┌───────────────┐
 │  Demo.class   │
 └───────────────┘
```

---

## Key Point

A program is simply:

```text
Instructions Stored On Disk
```

It does nothing until executed.

---

# Interview Question

### Is a `.java` file a process?

No.

A `.java` file is only a **Program**.

---

# 3. What is a Process?

A **Process** is a program that is currently running.

---

## How Process is Created?

When user executes:

```bash
java Demo
```

OS performs:

```text
Program on Disk
        ↓
Loaded into RAM
        ↓
Process Created
```

---

## Process Diagram

```text
Disk

Demo.class

      │
      ▼

RAM

┌─────────────────┐
│     Process     │
└─────────────────┘
```

---

## Resources Allocated

Each process receives:

```text
Memory (RAM)

CPU Time

Files

Network Resources
```

---

## Process Characteristics

✔ Independent

✔ Own Memory

✔ Own Resources

✔ Protected by OS

---

# Real Example

When coding:

```text
VS Code Process

Chrome Process

Spotify Process

Zoom Process
```

Each process has separate memory.

---

# Process Isolation

```text
Chrome Process
     │
     ▼
 Own Memory


VS Code Process
     │
     ▼
 Own Memory
```

One process cannot directly access another process memory.

---

# Interview Question

### Can Chrome directly access VS Code memory?

No.

Processes are isolated by the Operating System.

---

# 4. What is a Thread?

A **Thread** is the smallest unit of execution that can run independently.

---

## Definition

```text
Thread = Lightweight Process
```

---

## Important Rule

Every process has at least:

```text
One Thread
```

called:

```text
Main Thread
```

---

## Example

When JVM starts:

```java
public static void main(String[] args)
{
    System.out.println("Hello");
}
```

JVM automatically creates:

```text
Main Thread
```

to execute `main()`.

---

# Thread Diagram

```text
Process

 ┌─────────────────────┐
 │                     │
 │     Main Thread     │
 │                     │
 └─────────────────────┘
```

---

# Multiple Threads

A process can contain many threads.

```text
Process

 ┌──────────────────────┐

 Main Thread

 Thread 1

 Thread 2

 Thread 3

 └──────────────────────┘
```

---

# Interview Question

### Can a process exist without a thread?

No.

Every process requires at least one thread.

---

# 5. Why Multithreading?

Many people think:

```text
Multithreading = Speed
```

Not always.

The primary goal is:

```text
Concurrency
```

---

# Real World Example

Consider VS Code.

While typing:

```text
Typing Code
```

simultaneously:

```text
Error Detection

Auto Completion

Syntax Highlighting
```

are also running.

---

# VS Code Thread Model

```text
VS Code Process

 ┌────────────────────┐

 Main Thread
     │
     ▼
 Typing

 Thread 1
     │
     ▼
 Error Checking

 Thread 2
     │
     ▼
 Auto Complete

 └────────────────────┘
```

---

# Benefits

✔ Better Responsiveness

✔ Better User Experience

✔ Efficient CPU Utilization

✔ Concurrent Task Execution

---

# 6. Process vs Thread

---

## Process

Heavyweight execution unit.

```text
Program
   ↓
Process
```

---

## Thread

Lightweight execution unit inside process.

```text
Process
   ↓
Threads
```

---

# Comparison Table

| Feature             | Process   | Thread      |
| ------------------- | --------- | ----------- |
| Memory              | Separate  | Shared      |
| Creation Cost       | High      | Low         |
| Communication       | Difficult | Easy        |
| Isolation           | Strong    | Weak        |
| Resource Usage      | Heavy     | Lightweight |
| Context Switch Cost | Expensive | Cheaper     |

---

# Visual Comparison

```text
Process A

Memory A


Process B

Memory B
```

Processes do not share memory.

---

```text
One Process

Thread A

Thread B

Thread C

Shared Heap
```

Threads share memory.

---

# 7. JVM Memory Model in Multithreading

When JVM starts:

```bash
java Demo
```

A process is created.

Inside that process:

```text
JVM Memory Areas Created
```

---

# Memory Layout

```text
                JVM PROCESS

 ┌─────────────────────────────┐
 │                             │
 │        Method Area          │
 │          Shared             │
 │                             │
 └─────────────────────────────┘

 ┌─────────────────────────────┐
 │                             │
 │            Heap             │
 │          Shared             │
 │                             │
 └─────────────────────────────┘


 Thread-1               Thread-2

 ┌────────────┐      ┌────────────┐
 │   Stack    │      │   Stack    │
 └────────────┘      └────────────┘

 ┌────────────┐      ┌────────────┐
 │ PC Register│      │ PC Register│
 └────────────┘      └────────────┘
```

---

# 8. Shared Memory Areas

Shared by all threads.

---

## Heap Memory

Stores:

```text
Objects

Arrays

Instance Variables
```

---

## Method Area

Stores:

```text
Class Metadata

Static Variables

Bytecode
```

---

# Shared Memory Diagram

```text
Thread-1
      │
      ▼

      Heap

      ▲
      │

Thread-2
```

Both threads can access same objects.

---

# Example

```java
Student s =
      new Student();
```

Object stored in Heap.

Both threads can access it.

---

# 9. Private Memory Areas

Each thread gets its own:

```text
Stack

PC Register
```

---

# Thread Stack

Stores:

```text
Method Calls

Local Variables

Parameters
```

---

# Example

```java
void test()
{
    int x = 10;
}
```

Variable:

```text
x
```

stored inside thread's stack.

---

# Why Private?

To prevent interference.

Thread-1 local variables should not affect Thread-2.

---

# 10. Program Counter (PC Register)

Every thread has its own:

```text
Program Counter
```

---

## Purpose

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

# Why Separate PC?

Each thread executes different code.

Therefore each needs its own instruction pointer.

---

# 11. CPU Execution Model

CPU executes threads.

---

# Single-Core CPU

Only one thread runs at a time.

---

# How Multiple Threads Work?

Using:

```text
Context Switching
```

---

# Context Switching

CPU executes:

```text
Thread 1
```

for small time.

Then:

```text
Save State
```

and switches to:

```text
Thread 2
```

---

# Flow

```text
Thread 1

     ▼

Save Context

     ▼

Thread 2

     ▼

Save Context

     ▼

Thread 1
```

---

# Result

Appears simultaneous.

Actually:

```text
One Thread At A Time
```

---

# Interview Question

### Is multithreading truly parallel on a single-core CPU?

No.

It is concurrency through context switching.

---

# 12. What is Context?

Context includes:

```text
Stack Data

Program Counter

Current Execution State
```

---

# Context Switching Diagram

```text
CPU

Thread-1
   ↓
Save State

Thread-2
   ↓
Save State

Thread-1
```

---

# Drawback

Too many switches:

```text
Performance Overhead
```

---

# 13. Multi-Core CPU

Modern CPUs contain multiple cores.

Example:

```text
Dual Core

Quad Core

Octa Core
```

---

# True Parallelism

```text
Core 1 → Thread 1

Core 2 → Thread 2
```

running simultaneously.

---

# Diagram

```text
CPU

 ┌───────────┐
 │  Core 1   │
 └───────────┘
       │
       ▼
    Thread 1


 ┌───────────┐
 │  Core 2   │
 └───────────┘
       │
       ▼
    Thread 2
```

---

# Concurrency vs Parallelism

---

## Concurrency

```text
One Core

Multiple Threads

Switching Between Them
```

---

## Parallelism

```text
Multiple Cores

Multiple Threads

Running Simultaneously
```

---

# Comparison

| Concurrency               | Parallelism            |
| ------------------------- | ---------------------- |
| Single Core               | Multiple Cores         |
| Context Switching         | Simultaneous Execution |
| Illusion of Parallel Work | Actual Parallel Work   |

---

# 14. Multitasking vs Multithreading

---

## Multitasking

Operating System executes:

```text
Multiple Processes
```

---

# Example

```text
Chrome

VS Code

Spotify
```

running together.

---

# Multitasking Diagram

```text
OS

Chrome Process

VS Code Process

Spotify Process
```

---

## Multithreading

Single process executes:

```text
Multiple Threads
```

---

# Example

```text
VS Code

Typing Thread

Error Checking Thread

Auto Complete Thread
```

---

# Diagram

```text
VS Code Process

Thread A

Thread B

Thread C
```

---

# Comparison

| Multitasking       | Multithreading   |
| ------------------ | ---------------- |
| Multiple Processes | Multiple Threads |
| OS Level           | Program Level    |
| Higher Cost        | Lower Cost       |
| Independent Memory | Shared Memory    |

---

# 15. What Happens When Java Program Starts?

Code:

```java
public class Demo {

    public static void main(String[] args) {

        System.out.println("Hello");
    }
}
```

---

# Execution Flow

## Step 1

OS creates process.

```text
Demo Process
```

---

## Step 2

JVM loads into process.

---

## Step 3

Main Thread created.

---

## Step 4

Main Thread receives:

```text
Stack

PC Register
```

---

## Step 5

Stack Frame for `main()` created.

---

## Step 6

CPU executes instructions.

---

# Complete Flow

```text
Demo.class

      │
      ▼

OS Creates Process

      │
      ▼

JVM Starts

      │
      ▼

Main Thread Created

      │
      ▼

Stack Created

      │
      ▼

PC Register Created

      │
      ▼

main() Executes
```

---

# Quick Revision Sheet

```text
Program
   -> Stored On Disk

Process
   -> Running Program

Thread
   -> Smallest Execution Unit

Main Thread
   -> Created By JVM

Heap
   -> Shared

Method Area
   -> Shared

Stack
   -> Thread Private

PC Register
   -> Thread Private

Single Core
   -> Concurrency

Multi Core
   -> Parallelism

Context Switching
   -> CPU Changes Threads

Multitasking
   -> Multiple Processes

Multithreading
   -> Multiple Threads
```

---

# Interview One-Liner

"A program is a passive set of instructions stored on disk, a process is an executing instance of a program in memory, and a thread is the smallest unit of execution within a process. In Java, all threads share the Heap and Method Area while maintaining their own Stack and Program Counter, enabling concurrent and parallel execution."
