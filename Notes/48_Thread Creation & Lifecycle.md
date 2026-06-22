# Java Thread Creation & Lifecycle

---

# 1. Introduction

In Java, a **Thread** is represented by an object.

A thread is responsible for executing a task concurrently within a process.

---

# Thread Creation Overview

Java provides two traditional approaches:

```text
1. Extend Thread Class

2. Implement Runnable Interface
```

Modern Java also supports:

```text
3. Lambda Expressions
```

---

# Thread Creation Flow

```text
Create Thread
      │
      ▼

Call start()

      │
      ▼

JVM Requests OS

      │
      ▼

New Thread Created

      │
      ▼

run() Executes
```

---

# 2. Method 1: Extending Thread Class

A custom thread can be created by extending the `Thread` class.

---

## Step 1

Create child class.

```java
class MyThread extends Thread {

    @Override
    public void run() {

        System.out.println(
            "Thread Running"
        );
    }
}
```

---

## Step 2

Create object.

```java
MyThread t1 =
        new MyThread();
```

---

## Step 3

Start thread.

```java
t1.start();
```

---

# Complete Example

```java
class MyThread extends Thread {

    @Override
    public void run() {

        System.out.println(
            "Thread is running"
        );
    }
}

public class Demo {

    public static void main(String[] args) {

        MyThread t1 =
                new MyThread();

        t1.start();
    }
}
```

---

# Execution Diagram

```text
MyThread Object

      │

      ▼

start()

      │

      ▼

New Thread Created

      │

      ▼

run()
```

---

# Advantages

✔ Easy to understand

✔ Simple implementation

---

# Disadvantages

❌ Cannot extend another class

Reason:

```text
Java Supports
Single Inheritance
```

---

# Example Problem

```java
class A {

}

class MyThread
      extends A,
      Thread
{

}
```

Not allowed.

---

# Interview Question

### Why is extending Thread generally not preferred?

Because it prevents extending another class and mixes task logic with thread management.

---

# 3. Method 2: Implementing Runnable Interface

This is the most commonly used approach in real-world applications.

---

# Runnable Concept

Separate:

```text
Task Logic
```

from

```text
Thread Execution
```

---

# Step 1

Implement Runnable.

```java
class MyRunnable
        implements Runnable {

    @Override
    public void run() {

        System.out.println(
            "Task Running"
        );
    }
}
```

---

# Step 2

Create Runnable object.

```java
MyRunnable r1 =
        new MyRunnable();
```

---

# Step 3

Pass task to Thread.

```java
Thread t1 =
        new Thread(r1);
```

---

# Step 4

Start thread.

```java
t1.start();
```

---

# Complete Example

```java
class MyRunnable
        implements Runnable {

    @Override
    public void run() {

        System.out.println(
            "Runnable Executing"
        );
    }
}

public class Demo {

    public static void main(String[] args) {

        MyRunnable r1 =
                new MyRunnable();

        Thread t1 =
                new Thread(r1);

        t1.start();
    }
}
```

---

# Architecture Diagram

```text
Runnable Task

      │

      ▼

Thread Object

      │

      ▼

start()

      │

      ▼

run()
```

---

# Benefits

✔ Better design

✔ Reusable task

✔ Supports inheritance

✔ Cleaner architecture

✔ Production standard

---

# Interview Question

### Why is Runnable preferred over Thread?

Because it separates business logic from thread execution and supports inheritance.

---

# 4. Runnable vs Thread

---

# Thread Approach

```text
MyThread IS A Thread
```

Inheritance relationship.

---

# Runnable Approach

```text
Thread HAS A Task
```

Composition relationship.

---

# Diagram

```text
Thread Approach

MyThread
     │
     ▼
  Thread
```

---

```text
Runnable Approach

Thread
   │
   ▼
Runnable Task
```

---

# Interview Tip

Prefer:

```text
Composition
```

over

```text
Inheritance
```

whenever possible.

---

# 5. Lambda Expressions

Since Runnable contains exactly one abstract method:

```java
void run()
```

it is a:

```text
Functional Interface
```

---

# Traditional Runnable

```java
Runnable r = new Runnable() {

    @Override
    public void run() {

        System.out.println(
            "Running"
        );
    }
};
```

---

# Lambda Version

```java
Runnable r =
    () -> System.out.println(
        "Running"
    );
```

---

# Thread Example

```java
Thread t1 =
    new Thread(() -> {

        System.out.println(
            "Lambda Thread"
        );

    });

t1.start();
```

---

# Diagram

```text
Lambda

    │

    ▼

Runnable

    │

    ▼

Thread

    │

    ▼

start()
```

---

# Benefits

✔ Less code

✔ Cleaner syntax

✔ Preferred in Java 8+

---

# 6. start() vs run()

One of the most important interview questions.

---

# Using start()

```java
t1.start();
```

---

# Internal Flow

```text
start()

   │

   ▼

JVM

   │

   ▼

OS Creates Thread

   │

   ▼

run()
```

---

# New Thread Created?

```text
YES
```

---

# Using run()

```java
t1.run();
```

---

# Internal Flow

```text
run()

   │

   ▼

Normal Method Call

   │

   ▼

Executed By Main Thread
```

---

# New Thread Created?

```text
NO
```

---

# Example

```java
Thread t1 =
    new Thread(() -> {

        System.out.println(
            Thread.currentThread()
                  .getName()
        );

    });

t1.run();
```

Output:

```text
main
```

because no new thread was created.

---

# Using start()

```java
t1.start();
```

Output:

```text
Thread-0
```

or another worker thread.

---

# Comparison

| start()              | run()                |
| -------------------- | -------------------- |
| Creates new thread   | No new thread        |
| Calls run internally | Direct method call   |
| Concurrent execution | Sequential execution |
| Preferred            | Not for threading    |

---

# Interview Question

### Why should we call start() instead of run()?

Because start() creates a new thread while run() behaves like a normal method call.

---

# 7. Double Start Rule

A thread can be started only once.

---

# Example

```java
Thread t1 =
        new Thread();

t1.start();

t1.start();
```

---

# Result

```java
IllegalThreadStateException
```

---

# Why?

Thread lifecycle already progressed.

A terminated thread cannot restart.

---

# Diagram

```text
NEW

 │

 ▼

RUNNABLE

 │

 ▼

TERMINATED
```

Cannot go back.

---

# 8. Thread Names

Every thread has a name.

---

# Default Names

```text
Thread-0

Thread-1

Thread-2
```

---

# Get Current Thread

```java
Thread.currentThread()
      .getName();
```

---

# Example

```java
System.out.println(
    Thread.currentThread()
          .getName()
);
```

Output:

```text
main
```

---

# Custom Thread Name

```java
t1.setName(
    "EmailProcessor"
);
```

---

# Output

```text
EmailProcessor
```

---

# Why Useful?

Helpful for:

```text
Logging

Monitoring

Debugging
```

---

# Example

```java
Thread.currentThread()
      .getName();
```

Output:

```text
PaymentThread

EmailThread

ReportThread
```

Easy to identify.

---

# 9. Thread ID

Each thread has a unique ID.

---

# Example

```java
Thread.currentThread()
      .threadId();
```

Modern Java preferred API.

---

# Purpose

```text
Unique Identification
```

for debugging.

---

# 10. Thread Scheduling

When multiple threads start:

```java
t1.start();

t2.start();
```

order is unpredictable.

---

# Why?

CPU Scheduler decides.

---

# Example

Possible Output:

```text
T1

T2
```

---

Or

```text
T2

T1
```

---

# This is Called

```text
Non-Deterministic Execution
```

---

# Scheduler Diagram

```text
CPU Scheduler

      │

      ├──► Thread 1

      ├──► Thread 2

      └──► Thread 3
```

---

# Important Rule

Never assume:

```text
Thread Start Order
=
Thread Finish Order
```

---

# 11. Thread Lifecycle

Every thread passes through multiple states.

---

# Lifecycle Diagram

```text
NEW
 │
 ▼
RUNNABLE
 │
 ▼
RUNNING
 │
 ▼
TERMINATED
```

Additional waiting states:

```text
BLOCKED

WAITING

TIMED_WAITING
```

---

# Complete Lifecycle

```text
                NEW
                 │
                 ▼

             RUNNABLE
                 │
                 ▼

             RUNNING

       ┌─────────┼─────────┐
       ▼         ▼         ▼

   BLOCKED   WAITING   TIMED_WAITING

       └─────────┼─────────┘
                 ▼

             RUNNABLE

                 ▼

            TERMINATED
```

---

# 12. NEW State

Thread object created.

```java
Thread t1 =
      new Thread();
```

---

# State

```text
NEW
```

---

# Characteristics

✔ Exists in memory

✔ start() not called

✔ OS unaware

---

# Example

```java
System.out.println(
    t1.getState()
);
```

Output:

```text
NEW
```

---

# 13. RUNNABLE State

After:

```java
t1.start();
```

---

# State

```text
RUNNABLE
```

---

# Meaning

Ready for CPU.

Waiting for scheduler.

---

# Diagram

```text
start()

   │

   ▼

RUNNABLE

   │

Waiting For CPU
```

---

# 14. RUNNING State

CPU currently executing:

```java
run()
```

---

# Note

Java combines:

```text
RUNNABLE

RUNNING
```

under:

```text
RUNNABLE
```

internally.

---

# 15. BLOCKED State

Occurs when thread waits for monitor lock.

---

# Example

```java
synchronized(obj)
{
   ...
}
```

Lock already occupied.

---

# Flow

```text
Thread Wants Lock

      │

      ▼

Lock Busy

      │

      ▼

BLOCKED
```

---

# 16. WAITING State

Waiting indefinitely.

---

# Example

```java
wait();
```

---

# Requires

Another thread to call:

```java
notify();
```

or

```java
notifyAll();
```

---

# State Diagram

```text
WAITING

   │

notify()

   ▼

RUNNABLE
```

---

# 17. TIMED_WAITING State

Waiting for a fixed duration.

---

# Example

```java
Thread.sleep(5000);
```

---

# State

```text
TIMED_WAITING
```

---

# Flow

```text
sleep(5 sec)

      │

      ▼

TIMED_WAITING

      │

Time Expired

      ▼

RUNNABLE
```

---

# 18. TERMINATED State

Thread execution completed.

---

# Example

```java
public void run() {

    System.out.println(
        "Done"
    );
}
```

After completion:

```text
TERMINATED
```

---

# Important Rule

A terminated thread:

```text
Cannot Restart
```

---

# 19. Checking Thread State

```java
Thread t1 =
    new Thread(() -> {

        System.out.println(
            "Running"
        );

    });

System.out.println(
    t1.getState()
);
```

Output:

```text
NEW
```

---

After:

```java
t1.start();
```

Possible Output:

```text
RUNNABLE
```

or

```text
TERMINATED
```

depending on timing.

---

# Quick Revision Sheet

```text
Thread Creation

1. Extend Thread

2. Implement Runnable

3. Lambda

start()
   -> Creates New Thread

run()
   -> Normal Method Call

Runnable
   -> Preferred

Thread States

NEW

RUNNABLE

BLOCKED

WAITING

TIMED_WAITING

TERMINATED

Thread Name
   -> getName()

Current Thread
   -> currentThread()

Custom Name
   -> setName()

Thread Scheduling
   -> Non-Deterministic

Double Start
   -> IllegalThreadStateException
```

---

# Interview One-Liner

"Java threads can be created either by extending the Thread class or implementing the Runnable interface, with Runnable being the preferred approach due to better separation of concerns. A thread starts execution through start(), transitions through lifecycle states such as NEW, RUNNABLE, BLOCKED, WAITING, and TERMINATED, and is ultimately scheduled by the operating system in a non-deterministic manner."
