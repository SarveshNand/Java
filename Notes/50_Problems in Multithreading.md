# Java Multithreading Problems

## Race Condition, Atomicity, Visibility & Ordering

---

# Why Do Multithreading Problems Occur?

Multiple threads execute simultaneously and may access the same data.

```text
          Thread-1
              |
              |
              v
         Shared Data
              ^
              |
              |
          Thread-2
```

When multiple threads read/write the same resource without proper synchronization, problems occur.

These problems are:

1. Race Condition
2. Atomicity Problem
3. Visibility Problem
4. Ordering (Reordering) Problem
5. Thread Interference
6. Data Inconsistency

---

# 1. Race Condition

## Definition

A Race Condition occurs when the program's result depends on the timing and order of thread execution.

Since thread scheduling is controlled by the OS scheduler, the result becomes unpredictable.

---

## Real-Life Example

Imagine two people trying to book the last movie ticket.

```text
Available Seats = 1

Person A checks seat
Person B checks seat

Both see:
Seat Available

Both book seat

Result:
2 bookings for 1 seat
```

This is a Race Condition.

---

# Race Condition in Java

Consider:

```java
count++;
```

Looks like one statement.

Actually it consists of 3 operations.

```text
Step 1: Read
Step 2: Increment
Step 3: Write
```

---

## Internal Working

Initial value:

```text
count = 0
```

### Thread-1

```text
Read count = 0
```

### Thread-2

```text
Read count = 0
```

### Thread-1

```text
Increment → 1
Write → 1
```

### Thread-2

```text
Increment → 1
Write → 1
```

Final value:

```text
1
```

Expected:

```text
2
```

One update is lost.

---

# Diagram

```text
Initial count = 0

            count++
          /         \
         /           \

Thread-1           Thread-2

Read 0             Read 0

Increment          Increment

1                  1

Write 1            Write 1

Final Value = 1
```

---

# Example Program

```java
class Counter {

    int count = 0;

    public void increment() {
        count++;
    }
}
```

```java
Counter c = new Counter();

Thread t1 = new Thread(() -> {

    for(int i=0;i<10000;i++) {
        c.increment();
    }
});

Thread t2 = new Thread(() -> {

    for(int i=0;i<10000;i++) {
        c.increment();
    }
});

t1.start();
t2.start();

t1.join();
t2.join();

System.out.println(c.count);
```

Expected:

```text
20000
```

Actual:

```text
17342
18891
19453
```

Output changes every run.

---

# Why Called "Race"?

Both threads are racing to update the same variable.

Who wins depends on timing.

---

# Interview Questions

### Is count++ atomic?

❌ No

---

### Is race condition deterministic?

❌ No

---

### Why is count++ unsafe?

Because it performs:

```text
Read → Modify → Write
```

which can be interrupted.

---

# 2. Atomicity Problem

## Definition

An operation is Atomic if it executes completely or not at all.

No thread can see a partially completed operation.

---

# Atomic vs Non-Atomic

## Atomic

```java
x = 10;
```

Single operation.

```text
Complete
or
Not Complete
```

Nothing in between.

---

## Non-Atomic

```java
count++;
```

Actually:

```text
Read
Modify
Write
```

Multiple operations.

Can be interrupted.

---

# Visual Diagram

```text
Atomic Operation

Start
  |
  v
Complete
```

```text
Non Atomic Operation

Read
  |
Modify
  |
Write
```

Thread switch can happen anywhere.

---

# Banking Example

Suppose:

```text
Balance = ₹1000
Withdraw = ₹800
```

Two threads:

```text
ATM-1
ATM-2
```

Both check balance.

```text
Balance >= 800
```

Both see YES.

Both withdraw.

Result:

```text
Balance = -600
```

Impossible state.

---

# Check-Then-Act Problem

```java
if(balance >= amount) {

    balance -= amount;
}
```

Looks safe.

Not atomic.

---

## Actual Flow

```text
Check Balance

Context Switch

Another Thread Withdraws

Context Switch

Deduct Again
```

Result:

```text
Incorrect Balance
```

---

# Interview Questions

### What is Atomicity?

An operation that cannot be interrupted midway.

---

### Is count++ atomic?

No.

---

### Is assignment atomic?

Usually yes.

```java
x = 5;
```

---

# 3. Shared Resource

## Definition

Any resource accessed by multiple threads.

Examples:

```text
Bank Account
Counter
File
Database Connection
List
Queue
Map
```

---

# Diagram

```text
Thread-1
     \
      \
       \
    Shared Resource
       /
      /
     /
Thread-2
```

---

# Critical Section

## Definition

The code that accesses shared resources.

This code must be protected.

---

## Example

```java
public void increment() {

    count++;
}
```

Critical Section:

```java
count++;
```

because multiple threads access it.

---

# Real-Life Example

```text
Bank Account Balance
```

Shared Resource:

```text
balance
```

Critical Section:

```java
balance -= amount;
```

---

# Easy Memory Trick

```text
Shared Resource
      ↓
Actual Data

Critical Section
      ↓
Code Accessing Data
```

---

# 4. Visibility Problem

## Definition

One thread updates a variable but another thread cannot immediately see the updated value.

---

# Why Does It Happen?

Modern CPUs use cache memory.

Cache is faster than RAM.

---

# Architecture

```text
                RAM
                 |
      -----------------------
      |                     |
      |                     |
   CPU-1                 CPU-2
   Cache                 Cache
      |                     |
      |                     |
 Thread-1              Thread-2
```

Each CPU may store its own copy.

---

# Example

Initial:

```text
flag = false
```

Thread-2:

```java
while(!flag) {

}
```

Thread-1:

```java
flag = true;
```

Expected:

```text
Loop Stops
```

Actual:

```text
Loop Runs Forever
```

---

# Why?

Thread-2 keeps reading:

```text
flag = false
```

from its CPU cache.

Never refreshes from RAM.

---

# Visibility Diagram

```text
RAM

flag = true
      |
      |
      v

CPU Cache

flag = false
```

Thread sees stale data.

---

# Solution → volatile

```java
volatile boolean flag;
```

---

# What volatile Does

## Rule 1

Every write goes directly to RAM.

```text
Thread-1
     |
     v
RAM
```

---

## Rule 2

Every read comes from RAM.

```text
RAM
 |
 v
Thread-2
```

---

# Diagram

Without volatile:

```text
Thread → Cache
```

With volatile:

```text
Thread → RAM
```

---

# Example

```java
volatile boolean flag = false;
```

Thread-1:

```java
flag = true;
```

Thread-2:

```java
while(!flag) {

}
```

Now loop exits correctly.

---

# Important Interview Question

### Does volatile solve race conditions?

❌ No

Example:

```java
volatile int count = 0;

count++;
```

Still unsafe.

Because:

```text
Read
Modify
Write
```

is non-atomic.

---

# 5. Ordering (Reordering) Problem

## Definition

Compiler and CPU may reorder instructions for performance optimization.

---

# Example

Program:

```java
data = 100;
flag = true;
```

Expected order:

```text
1. data = 100
2. flag = true
```

---

# Possible Reordering

CPU may execute:

```text
1. flag = true
2. data = 100
```

---

# Why Dangerous?

Thread-2:

```java
if(flag) {

    System.out.println(data);
}
```

Possible Output:

```text
0
```

instead of:

```text
100
```

because data wasn't initialized yet.

---

# Diagram

Expected:

```text
data = 100
     |
     v
flag = true
```

Reordered:

```text
flag = true
     |
     v
data = 100
```

---

# Solution

Use:

```java
volatile
```

or

```java
synchronized
```

Both establish memory ordering guarantees.

---

# 6. Thread Interference

## Definition

When multiple threads interfere with each other's execution due to shared data access.

---

# Causes

```text
Race Condition
Atomicity Issues
Visibility Issues
Reordering
```

All contribute to interference.

---

# Diagram

```text
Thread-1
      \
       \
        \
         Shared Data
        /
       /
      /
Thread-2

      ↓

Interference
```

---

# Data Inconsistency

## Definition

When application data becomes incorrect because of thread interference.

---

# Banking Example

Expected:

```text
Balance = ₹1000
```

Actual:

```text
Balance = -600
```

This is Data Inconsistency.

---

# Why Dangerous?

Critical systems:

```text
Banking
Trading
Healthcare
Airlines
Payment Gateways
```

cannot tolerate inconsistent data.

---

# Complete Problem Map

```text
Multiple Threads
         |
         v

Shared Resource
         |
         v

-------------------------
|                       |
Race Condition      Visibility
|                       |
Atomicity           Stale Data
|                       |
-------------------------
         |
         v

Thread Interference
         |
         v

Data Inconsistency
```

---

# Solution Summary

| Problem                    | Solution                          |
| -------------------------- | --------------------------------- |
| Race Condition             | synchronized, Lock, AtomicInteger |
| Atomicity                  | synchronized, Atomic Classes      |
| Visibility                 | volatile, synchronized            |
| Reordering                 | volatile, synchronized            |
| Shared Resource Protection | Critical Section + Locking        |
| Data Consistency           | Proper Synchronization            |

---

# Quick Revision Table

| Concept             | Meaning                                 |
| ------------------- | --------------------------------------- |
| Race Condition      | Result depends on thread timing         |
| Atomicity           | Operation cannot be interrupted         |
| Shared Resource     | Data used by multiple threads           |
| Critical Section    | Code accessing shared data              |
| Visibility          | Updated value not seen by other threads |
| volatile            | Ensures visibility + ordering           |
| Reordering          | CPU changes instruction order           |
| Thread Interference | Threads affect each other unexpectedly  |
| Data Inconsistency  | Corrupted or incorrect data             |

---

# One-Line Memory Tricks

```text
Race Condition  → Who updates first?
Atomicity       → All or Nothing
Visibility      → Can others see changes?
volatile        → Read/Write from RAM
Reordering      → Instructions shuffled
Critical Section→ Dangerous code area
Shared Resource → Common data
Interference    → Threads collide
Consistency     → Correct data
```

---

# Most Asked Interview Questions

### Why is count++ not thread-safe?

Because it performs:

```text
Read → Modify → Write
```

which is not atomic.

---

### What does volatile solve?

✅ Visibility

✅ Ordering

❌ Atomicity

❌ Race Conditions

---

### What is a Critical Section?

Code that accesses shared resources and must be synchronized.

---

### What is the difference between Atomicity and Visibility?

| Atomicity                | Visibility           |
| ------------------------ | -------------------- |
| Complete operation       | Latest value visible |
| Prevents partial updates | Prevents stale reads |

---

### Can volatile replace synchronized?

❌ No

Because volatile does not make compound operations atomic.

---

### What is the biggest risk in multithreading?

✅ Data Inconsistency
