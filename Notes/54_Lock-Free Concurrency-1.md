# Java Atomic Variables & CAS (Compare-And-Set)

## Lock-Free Concurrency, AtomicInteger, AtomicReference & Interview Guide

---

# 1. Why Do We Need Atomic Variables?

## The Core Problem

In multithreading, multiple threads may access the same variable simultaneously.

Example:

```java
count++;
```

Looks like:

```text
One Operation
```

Reality:

```text
Three Operations
```

---

# What Actually Happens?

```java
count++;
```

Internally:

```text
Step 1 → Read Value
Step 2 → Increment Value
Step 3 → Write Back Value
```

---

# Diagram

```text
Memory
  |
count = 0
  |
  v

Thread-1
Read 0

Thread-2
Read 0

Thread-1
Increment → 1

Thread-2
Increment → 1

Thread-1
Write 1

Thread-2
Write 1
```

Final value:

```text
1
```

Expected:

```text
2
```

---

# Race Condition Visualization

```text
Expected

0
↓
1
↓
2

Actual

0
↓
1
```

One update is lost.

---

# Why Does This Happen?

Because:

```text
count++
```

is:

```text
NON-ATOMIC
```

---

# What Is Atomicity?

## Definition

An atomic operation is:

```text
All-Or-Nothing
```

It cannot be interrupted midway.

---

# Atomic Operation

```text
Read
Increment
Write
```

performed as:

```text
ONE UNIT
```

---

# Diagram

Non-Atomic:

```text
Read
 |
Context Switch
 |
Increment
 |
Write
```

Dangerous.

---

Atomic:

```text
Read + Increment + Write

Single Step
```

Safe.

---

# Atomic Variables

Package:

```java
java.util.concurrent.atomic
```

Provides lock-free thread-safe variables.

---

# Common Atomic Classes

| Class              | Purpose            |
| ------------------ | ------------------ |
| AtomicInteger      | Integer operations |
| AtomicLong         | Long operations    |
| AtomicBoolean      | Boolean operations |
| AtomicReference    | Object references  |
| AtomicIntegerArray | Integer arrays     |
| AtomicLongArray    | Long arrays        |

---

# Why Use Atomic Variables?

Traditional approach:

```java
synchronized
```

uses locks.

---

# Lock-Based Flow

```text
Thread-1
   |
Acquire Lock
   |
Work
   |
Release Lock

Thread-2 Waits
```

---

# Problems

```text
Lock Overhead

Context Switching

Possible Deadlock

Possible Contention
```

---

# Atomic Variables

No locking.

```text
Thread-1
     |
     v

CAS

     ^
     |
Thread-2
```

---

# Benefits

```text
Fast

Lock-Free

No Deadlocks

No Starvation

Thread Safe
```

---

# AtomicInteger Example

## Traditional Counter

```java
class Counter {

    int count = 0;

    void increment() {

        count++;
    }
}
```

Not thread-safe.

---

# Atomic Counter

```java
AtomicInteger count =
        new AtomicInteger(0);
```

---

Increment:

```java
count.incrementAndGet();
```

Thread-safe.

---

# Diagram

```text
Thread-1
    |
incrementAndGet()
    |
    v

AtomicInteger

    ^
    |
Thread-2
```

Only one update succeeds at a time.

---

# Creating AtomicInteger

```java
AtomicInteger count =
        new AtomicInteger();
```

Default:

```text
0
```

---

Or:

```java
AtomicInteger count =
        new AtomicInteger(100);
```

---

# Important Methods

## get()

```java
count.get();
```

Returns current value.

---

## set()

```java
count.set(50);
```

Updates value safely.

---

## incrementAndGet()

Equivalent to:

```java
++count
```

---

Example:

```java
AtomicInteger count =
        new AtomicInteger(5);

System.out.println(
    count.incrementAndGet()
);
```

Output:

```text
6
```

---

# Diagram

```text
5
 |
+1
 |
 v

6
```

Returns:

```text
6
```

---

# getAndIncrement()

Equivalent to:

```java
count++
```

---

Example

```java
AtomicInteger count =
        new AtomicInteger(5);

System.out.println(
    count.getAndIncrement()
);
```

Output:

```text
5
```

New value:

```text
6
```

---

# Difference

| Method            | Returns       |
| ----------------- | ------------- |
| incrementAndGet() | Updated value |
| getAndIncrement() | Old value     |

---

# Memory Trick

```text
incrementAndGet

First Increment
Then Return
```

---

```text
getAndIncrement

First Return
Then Increment
```

---

# decrementAndGet()

Equivalent:

```java
--count
```

---

Example

```java
count.decrementAndGet();
```

---

# addAndGet()

```java
count.addAndGet(10);
```

Adds:

```text
+10
```

atomically.

---

# Example

```java
AtomicInteger count =
        new AtomicInteger(20);

count.addAndGet(5);
```

Result:

```text
25
```

---

# The Heart of Atomic Classes

## Compare And Set (CAS)

Everything revolves around:

```java
compareAndSet()
```

---

# What Is CAS?

CAS means:

```text
Compare
      +
Set
```

---

# Basic Idea

```text
If Current Value
Matches Expected Value

Then Update
```

Otherwise:

```text
Do Nothing
```

---

# Method Signature

```java
compareAndSet(
    expectedValue,
    newValue
);
```

---

# Example

```java
AtomicInteger count =
        new AtomicInteger(10);

boolean result =
    count.compareAndSet(
        10,
        20
    );
```

---

# Flow

```text
Current Value = 10

Expected = 10

Match?

YES

Update To 20
```

Returns:

```text
true
```

---

# Diagram

```text
Memory

10
 |
Compare
 |
10 ?

YES
 |
 v

20
```

---

# Failure Case

```java
AtomicInteger count =
        new AtomicInteger(15);

count.compareAndSet(
    10,
    20
);
```

---

Flow

```text
Current = 15

Expected = 10

Match?

NO
```

Result:

```text
No Update
```

Returns:

```text
false
```

---

# Diagram

```text
15
 |
Compare
 |
10 ?

NO

Remain 15
```

---

# Why CAS Solves Race Conditions

Suppose:

```text
Thread-1
Thread-2
```

Both want to update value.

---

Initial:

```text
count = 0
```

---

Both Read:

```text
0
```

---

Thread-1 Executes CAS

```text
Expected = 0

Update = 1
```

Success.

---

Memory:

```text
1
```

---

Thread-2 Executes CAS

```text
Expected = 0

Current = 1
```

Fails.

---

Diagram

```text
T1 ---- CAS ---- SUCCESS

T2 ---- CAS ---- FAIL
```

---

# Retry Mechanism

Most atomic operations internally do:

```text
Read
 |
CAS
 |
Success?
 |
+----+----+
|         |
Yes       No
|          |
Done     Retry
```

---

# Internal Logic

Simplified:

```java
while(true){

    int oldValue = get();

    int newValue = oldValue + 1;

    if(compareAndSet(
            oldValue,
            newValue)){

        break;
    }
}
```

---

# AtomicReference

Used for objects instead of numbers.

---

Example

```java
AtomicReference<String> seat =
    new AtomicReference<>("EMPTY");
```

---

# Real World Example

## Seat Booking System

Initial:

```text
Seat = EMPTY
```

---

Thread-1:

```text
Book For Alice
```

---

Thread-2:

```text
Book For Bob
```

---

Without AtomicReference

```text
Alice Sees EMPTY

Bob Sees EMPTY

Both Book Seat
```

Problem.

---

# CAS Solution

Alice:

```java
seat.compareAndSet(
        "EMPTY",
        "Alice"
);
```

Success.

---

Now:

```text
Seat = Alice
```

---

Bob:

```java
seat.compareAndSet(
        "EMPTY",
        "Bob"
);
```

Fails.

---

Diagram

```text
EMPTY
   |
Alice CAS
   |
Success
   |
Alice

Bob CAS
   |
Fail
```

---

# Hardware Level Magic

Interview Favorite.

---

Question:

```text
How Is CAS Atomic
On Multi-Core CPUs?
```

---

# CPU-Level Support

Modern CPUs provide special atomic instructions.

Examples:

```text
LOCK CMPXCHG
```

(x86 processors)

---

# Simplified Flow

```text
CPU Core-1
      |
LOCK Signal
      |
Memory Controller
      |
Exclusive Access
```

---

Other cores:

```text
WAIT
```

for a tiny moment.

---

# Diagram

```text
Core-1
  |
Atomic Operation
  |
LOCK

Core-2
Core-3
Core-4

Wait
```

---

# Why No Two Threads Win Together?

Because memory controller processes requests sequentially.

```text
Request A
Request B
```

Even if extremely close:

```text
A arrives first
```

---

Memory hardware cannot process:

```text
Half A
Half B
```

simultaneously.

---

# Atomic Variables vs Synchronized

| Feature         | Atomic    | synchronized |
| --------------- | --------- | ------------ |
| Locks           | ❌         | ✅            |
| Fast            | ✅         | ❌            |
| Deadlock Risk   | ❌         | ✅            |
| Starvation Risk | ❌         | Possible     |
| Simple Counter  | Excellent | Overkill     |
| Complex Logic   | Limited   | Better       |

---

# Visibility Guarantee

Atomic classes internally provide visibility guarantees.

Thus:

```java
AtomicInteger count;
```

does NOT require:

```java
volatile
```

---

# Important Limitation

Atomic methods are safe.

Combining them may not be.

---

# Dangerous Example

```java
if(count.get() > 4){

    count.incrementAndGet();
}
```

Looks safe.

Actually:

```text
NOT SAFE
```

---

# Why?

Flow:

```text
Thread-1

count.get()

Context Switch

Thread-2 Changes Value

Thread-1 Continues
```

Race condition possible.

---

# Diagram

```text
get()
 |
Context Switch
 |
increment()
```

Still vulnerable.

---

# Rule

Individual atomic methods:

```text
SAFE
```

Combination of operations:

```text
May Not Be Safe
```

---

# When To Use Atomic Variables

Perfect For:

```text
Counters

Request Counts

Sequence Numbers

Flags

Statistics

Metrics

Hit Counters

Rate Limiting
```

---

# Avoid For

```text
Complex Business Logic

Multiple Variables

Large Transactions
```

Use:

```text
Locks
synchronized
Transactions
```

instead.

---

# Complete Atomic Flow

```text
Thread
   |
Read Value
   |
Create New Value
   |
CAS
   |
+-----+-----+
|           |
Success    Fail
|            |
Done       Retry
```

---

# Quick Revision Table

| Concept         | Meaning                      |
| --------------- | ---------------------------- |
| Atomicity       | Cannot be interrupted        |
| AtomicInteger   | Thread-safe integer          |
| AtomicLong      | Thread-safe long             |
| AtomicBoolean   | Thread-safe boolean          |
| AtomicReference | Thread-safe object reference |
| CAS             | Compare And Set              |
| compareAndSet() | Atomic update                |
| Lock-Free       | No synchronized needed       |
| Visibility      | Automatically guaranteed     |

---

# One-Line Memory Tricks

```text
count++ → Not Atomic

AtomicInteger → Atomic Counter

CAS → Compare Then Update

CAS Success → Update

CAS Failure → Retry

AtomicReference → Atomic Object

Lock-Free → No Waiting

Atomic Classes → Fast Counters

incrementAndGet() → Increment First

getAndIncrement() → Return First
```

---

# Most Asked Interview Questions

### Why is count++ not thread-safe?

Because it performs:

```text
Read
Increment
Write
```

as separate operations.

---

### What is AtomicInteger?

A lock-free thread-safe integer implementation.

---

### What is CAS?

Compare current value with expected value and update atomically if they match.

---

### What happens if CAS fails?

Returns:

```text
false
```

and operation may retry.

---

### Do atomic variables need volatile?

❌ No

Visibility is already guaranteed.

---

### Are atomic variables lock-free?

✅ Yes

---

### Can atomic variables cause deadlocks?

❌ No

No locks are used.

---

### Difference between incrementAndGet() and getAndIncrement()?

```text
incrementAndGet()
→ increment first

getAndIncrement()
→ return first
```

---

### Is this thread-safe?

```java
if(count.get() > 5){
    count.incrementAndGet();
}
```

❌ No

Multiple atomic operations combined are not automatically atomic.

---

### When should AtomicInteger be preferred?

For high-performance counters, statistics, sequence generators, and simple shared numeric state.
