# Java Atomic Variables, CAS, ABA Problem & Lock-Free Concurrency

## Volatile vs Atomic Variables

One of the most common interview questions is the difference between **volatile** and **atomic variables**.

### Volatile

`volatile` guarantees **visibility**.

When a variable is declared as volatile:

```java
private volatile boolean flag;
```

Java ensures:

* Reads happen from Main Memory (RAM)
* Writes are immediately flushed to Main Memory
* All threads see the latest value

### What Volatile Solves

```text
Visibility Problem
Instruction Reordering
```

### What Volatile Does NOT Solve

```text
Race Conditions
Atomicity Problems
```

Example:

```java
volatile int count = 0;

count++;
```

Still NOT thread-safe.

Reason:

```text
Read
Increment
Write
```

are still separate operations.

---

## Atomic Variables

Atomic variables provide:

```text
Atomicity
Visibility
Thread Safety
```

Examples:

```java
AtomicInteger
AtomicLong
AtomicBoolean
AtomicReference
```

Example:

```java
AtomicInteger count =
        new AtomicInteger(0);

count.incrementAndGet();
```

This operation is atomic.

---

## Volatile vs Atomic

| Feature               | volatile | Atomic Variables |
| --------------------- | -------- | ---------------- |
| Visibility            | ✅        | ✅                |
| Atomicity             | ❌        | ✅                |
| Thread Safe Increment | ❌        | ✅                |
| Uses CAS              | ❌        | ✅                |
| Lock-Free             | N/A      | ✅                |

---

# CAS (Compare-And-Set)

CAS stands for:

```text
Compare And Set
```

or

```text
Compare And Swap
```

CAS is the core mechanism behind all Java atomic classes.

---

## compareAndSet()

Method:

```java
compareAndSet(
    expectedValue,
    newValue
);
```

Logic:

```text
If Current Value == Expected Value

      ↓

Update To New Value

      ↓

Return true
```

Otherwise:

```text
Do Nothing

Return false
```

---

## Example

```java
AtomicInteger count =
        new AtomicInteger(10);

boolean result =
        count.compareAndSet(
                10,
                20
        );
```

Result:

```text
Current = 10
Expected = 10

Match

Update To 20

Return true
```

---

## Failure Example

```java
AtomicInteger count =
        new AtomicInteger(15);

boolean result =
        count.compareAndSet(
                10,
                20
        );
```

Result:

```text
Current = 15
Expected = 10

Mismatch

No Update

Return false
```

---

# Why CAS Is Lock-Free

Traditional synchronization:

```text
Acquire Lock
      ↓
Execute
      ↓
Release Lock
```

Threads may become:

```text
BLOCKED
```

---

CAS approach:

```text
Try Update
      ↓
Success ?
      ↓
Yes → Done
No  → Retry
```

Threads never block.

---

## Locking vs CAS

### Lock-Based

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

### CAS-Based

```text
Thread-1
      \
       \
        CAS
       /
      /

Thread-2
```

All threads try simultaneously.

Only one succeeds.

Others retry.

---

# Lock-Free Retry Loop

CAS can fail if another thread updates the value first.

Therefore retry logic is needed.

---

## Problem Without Retry

Suppose:

```text
count = 0
```

Thread-1:

```text
Read 0
```

Thread-2:

```text
Read 0
```

Both calculate:

```text
1
```

Both update:

```text
count = 1
```

One update is lost.

---

## Retry Loop Solution

```java
while (true) {

    int oldValue = count.get();

    int newValue = oldValue + 1;

    if (count.compareAndSet(
            oldValue,
            newValue)) {

        break;
    }
}
```

---

## Retry Loop Flow

```text
Read Current Value
        |
        v

Calculate New Value
        |
        v

CAS Attempt
        |
   +----+----+
   |         |
 Success   Failure
   |         |
   v         |
  Done       |
             |
             v
          Retry
```

---

# How AtomicInteger Works Internally

Methods like:

```java
incrementAndGet()

getAndIncrement()

addAndGet()
```

internally use:

```text
CAS
+
Retry Loop
```

Exactly the same mechanism shown above.

---

# AtomicReferenceArray

Used when multiple threads access an array.

---

## Problem With Normal Arrays

```java
String[] seats =
        new String[100];
```

Multiple threads can update:

```java
seats[5]
```

simultaneously.

This causes:

```text
Race Conditions
```

---

## AtomicReferenceArray

```java
AtomicReferenceArray<String> seats =
        new AtomicReferenceArray<>(100);
```

Provides thread-safe operations.

---

## Methods

### get()

```java
seats.get(5);
```

---

### set()

```java
seats.set(5, "Alice");
```

---

### compareAndSet()

```java
seats.compareAndSet(
        5,
        "EMPTY",
        "Alice"
);
```

---

# Seat Booking Example

Initial:

```text
Seat-5 = EMPTY
```

Thread-1:

```text
Book For Alice
```

Thread-2:

```text
Book For Bob
```

---

## Using CAS

Alice:

```java
seats.compareAndSet(
        5,
        "EMPTY",
        "Alice"
);
```

Success.

---

Now:

```text
Seat-5 = Alice
```

---

Bob:

```java
seats.compareAndSet(
        5,
        "EMPTY",
        "Bob"
);
```

Fails.

---

## Diagram

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

# ABA Problem

One of the most important advanced interview topics.

---

## What Is ABA?

A value changes:

```text
A → B → A
```

and CAS fails to detect it.

---

## Scenario

### Step 1

Thread-1 reads:

```text
Value = A
```

Then gets interrupted.

---

### Step 2

Thread-2 changes:

```text
A → B
```

Then:

```text
B → A
```

---

### Step 3

Thread-1 resumes.

Checks:

```text
Expected = A

Current = A
```

CAS succeeds.

---

## Problem

Thread-1 thinks:

```text
Nothing Changed
```

Reality:

```text
A → B → A
```

A change DID occur.

The history was lost.

---

# ABA Visualization

```text
Thread-1
Reads A
   |
Interrupted
   |
-----------------

Thread-2

A → B

B → A

-----------------

Thread-1

Still Sees A

CAS Success
```

Dangerous.

---

# Why ABA Is Dangerous

The value may appear unchanged.

However:

```text
System State
Business Logic
Resource Ownership
```

may have changed completely.

---

# Solution: Versioning

Instead of tracking only:

```text
Value
```

track:

```text
Value + Version
```

---

# AtomicStampedReference

Java solution:

```java
AtomicStampedReference<T>
```

A stamp acts like a version number.

---

## Example

Initially:

```text
Value = A
Version = 1
```

Thread-1 reads:

```text
A, Version 1
```

---

Thread-2 changes:

```text
A, V1

↓

B, V2

↓

A, V3
```

---

Thread-1 attempts CAS:

```text
Expected

A, V1
```

Current:

```text
A, V3
```

Mismatch.

CAS fails.

---

# Diagram

```text
A (V1)
   |
   v

B (V2)
   |
   v

A (V3)

Thread-1 Expected

A (V1)

Mismatch
```

---

# Benefits Of AtomicStampedReference

```text
Detects Hidden Changes

Prevents ABA

Provides Version History

Improves Data Consistency
```

---

# Pessimistic vs Optimistic Concurrency

## Pessimistic Locking

Used by:

```java
synchronized
ReentrantLock
```

Assumption:

```text
Conflict Will Happen
```

Strategy:

```text
Lock Everything
```

---

## Optimistic Locking

Used by:

```java
CAS
Atomic Variables
```

Assumption:

```text
Conflict Is Rare
```

Strategy:

```text
Try
Fail
Retry
```

---

# Comparison Table

| Feature           | Locking (`synchronized`) | Lock-Free (CAS) |
| ----------------- | ------------------------ | --------------- |
| Strategy          | Pessimistic              | Optimistic      |
| Thread State      | BLOCKED                  | Active          |
| Context Switching | High                     | Low             |
| Performance       | Slower                   | Faster          |
| Deadlock Risk     | Possible                 | None            |
| Starvation        | Possible                 | Rare            |
| Complexity        | Easy                     | Higher          |
| ABA Problem       | No                       | Yes             |

---

# Complete CAS Workflow

```text
Read Value
    |
    v

Calculate New Value
    |
    v

compareAndSet()
    |
+---+---+
|       |
Pass   Fail
|        |
v        |
Done     |
         |
         v
       Retry
```

---

# Quick Revision Table

| Concept                | Meaning                   |
| ---------------------- | ------------------------- |
| volatile               | Visibility only           |
| AtomicInteger          | Atomic counter            |
| CAS                    | Compare and Set           |
| Retry Loop             | Retry after CAS failure   |
| AtomicReferenceArray   | Thread-safe array         |
| ABA Problem            | Hidden A→B→A change       |
| AtomicStampedReference | Value + Version           |
| Pessimistic Locking    | Block Others              |
| Optimistic Locking     | Retry Instead Of Blocking |

---

# Interview Questions

### Does volatile provide atomicity?

❌ No

Only visibility and ordering.

---

### Do Atomic Variables need volatile?

❌ No

They are internally volatile.

---

### What is CAS?

Compare current value with expected value and update atomically if they match.

---

### What happens when CAS fails?

Returns:

```text
false
```

and usually retries.

---

### What is the ABA Problem?

When a value changes:

```text
A → B → A
```

and CAS incorrectly assumes nothing changed.

---

### How do you solve ABA?

Using:

```java
AtomicStampedReference
```

which tracks:

```text
Value + Version
```

---

### Which is faster?

Generally:

```text
Atomic Variables > synchronized
```

for simple counters and lightweight shared state.

---

### What is the difference between optimistic and pessimistic locking?

```text
Pessimistic:
Lock First

Optimistic:
Try First, Retry If Needed
```
