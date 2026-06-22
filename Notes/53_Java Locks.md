# Java Advanced Locks & Concurrency Utilities

## Lock Interface, ReentrantLock, ReadWriteLock, StampedLock, Semaphore & Condition

---

# Why Was `synchronized` Not Enough?

The `synchronized` keyword is simple and powerful, but it has limitations.

## Problem 1: No Timeout

```java
synchronized(lock) {
    // acquire lock or wait forever
}
```

If another thread holds the lock:

```text
Thread-1 → Owns Lock

Thread-2 → Waits Forever
```

No timeout mechanism exists.

---

## Problem 2: No Alternative Action

Suppose:

```text
If lock available
    → Update Database

Else
    → Do Something Else
```

Cannot be implemented with `synchronized`.

Thread simply becomes:

```text
BLOCKED
```

---

## Problem 3: No Fairness

Waiting queue:

```text
T1 (waiting 10 sec)
T2 (waiting 5 sec)
T3 (new)
```

JVM may grant lock to:

```text
T3
```

instead of:

```text
T1
```

Possible result:

```text
Starvation
```

---

## Problem 4: Automatic Unlocking Only

With synchronized:

```java
synchronized(lock) {

}
```

Lock is released only when block exits.

You cannot manually release it midway.

---

# The Lock Interface

Package:

```java
java.util.concurrent.locks
```

Provides explicit locking mechanisms.

Main implementation:

```java
ReentrantLock
```

---

# Lock vs Synchronized

| Feature              | synchronized | Lock |
| -------------------- | ------------ | ---- |
| Explicit lock/unlock | ❌            | ✅    |
| Timeout support      | ❌            | ✅    |
| Fairness             | ❌            | ✅    |
| tryLock()            | ❌            | ✅    |
| Multiple Conditions  | ❌            | ✅    |
| Manual Unlock        | ❌            | ✅    |

---

# ReentrantLock

## Basic Usage

```java
Lock lock = new ReentrantLock();

lock.lock();

try {

    System.out.println("Critical Section");

} finally {

    lock.unlock();
}
```

---

# Why try-finally?

Suppose:

```java
lock.lock();

int x = 10 / 0;
```

Exception occurs.

Without finally:

```text
Lock Never Released
```

Other threads:

```text
BLOCKED Forever
```

---

# Safe Pattern

```java
lock.lock();

try {

    // Critical Section

} finally {

    lock.unlock();
}
```

---

# ReentrantLock Flow

```text
Thread Requests Lock
          |
          v

Lock Available?

      |
   +--+--+
   |     |
  Yes    No
   |     |
   v     v

 Execute  Wait
```

---

# Why Is It Called Reentrant?

A thread can acquire the same lock multiple times.

---

## Example

```java
lock.lock(); // Hold Count = 1

lock.lock(); // Hold Count = 2
```

Allowed.

No deadlock.

---

# Internal Mechanism

```text
Owner Thread
      |
      v

Hold Count = 2
```

Must release twice.

```java
lock.unlock();

lock.unlock();
```

Now:

```text
Hold Count = 0
```

Lock becomes available.

---

# ReentrantLock Diagram

```text
Thread-1

lock()
  |
  v

Hold Count = 1

lock()
  |
  v

Hold Count = 2

unlock()
  |
  v

Hold Count = 1

unlock()
  |
  v

Hold Count = 0
```

---

# tryLock()

One of the biggest advantages over synchronized.

---

## Example

```java
if(lock.tryLock()) {

    try {

        process();

    } finally {

        lock.unlock();
    }

} else {

    System.out.println("Doing something else");
}
```

---

# Flow

```text
Try Lock
    |
    v

Available?

  +---+---+
  |       |
 Yes      No
  |       |
  v       v

Work   Alternative Task
```

---

# Interview Point

`tryLock()` never blocks.

Returns:

```java
true
```

or

```java
false
```

immediately.

---

# Timed tryLock()

```java
lock.tryLock(
        2,
        TimeUnit.SECONDS
);
```

Meaning:

```text
Wait Up To 2 Seconds
```

If lock unavailable:

```text
Give Up
```

---

# Fair Locks

Default:

```java
new ReentrantLock();
```

Non-fair.

---

# Fair Version

```java
new ReentrantLock(true);
```

---

# FIFO Behavior

```text
Waiting Queue

T1
T2
T3
```

Lock granted:

```text
T1 → T2 → T3
```

---

# Diagram

```text
Fair Lock

Queue

T1
 |
 v

T2
 |
 v

T3
```

---

# Trade-Off

| Lock Type | Speed  |
| --------- | ------ |
| Non-Fair  | Faster |
| Fair      | Slower |

---

# Starvation

Without fairness:

```text
T1 waits
T2 waits
T3 arrives
T3 gets lock
```

Repeatedly.

Result:

```text
T1 never executes
```

Starvation.

---

# ReadWriteLock

Package:

```java
java.util.concurrent.locks
```

Used when:

```text
Many Reads
Few Writes
```

---

# Real Example

```text
Database
Configuration File
Cache
Shared Document
```

---

# Traditional Lock

```text
Reader-1
Reader-2
Reader-3
```

Only one allowed.

Wasteful.

---

# ReadWriteLock Solution

Two locks:

```text
Read Lock

Write Lock
```

---

# Read Lock (Shared)

Many readers allowed.

```text
Reader-1
Reader-2
Reader-3
```

Simultaneously.

---

# Diagram

```text
Read Lock

Reader-1
Reader-2
Reader-3

All Allowed
```

---

# Write Lock (Exclusive)

```text
Writer-1
```

Only one allowed.

---

# Diagram

```text
Writer Active

Reader-1 ❌
Reader-2 ❌
Writer-2 ❌
```

Everyone waits.

---

# ReadWriteLock Rules

| Situation        | Allowed |
| ---------------- | ------- |
| Multiple Readers | ✅       |
| Reader + Writer  | ❌       |
| Multiple Writers | ❌       |

---

# Example

```java
ReadWriteLock rw =
        new ReentrantReadWriteLock();
```

Read:

```java
rw.readLock().lock();
```

Write:

```java
rw.writeLock().lock();
```

---

# Lock Downgrading

Allowed.

```text
Write Lock
     |
     v

Read Lock
```

---

# Why Useful?

After updating data:

```text
Write
  |
  v

Immediately Read
```

Without releasing ownership.

---

# Lock Upgrading

```text
Read Lock
     |
     v

Write Lock
```

Not allowed.

Can cause deadlocks.

---

# StampedLock

Modern alternative to ReadWriteLock.

Introduced for:

```text
Better Performance
```

---

# Key Idea

Instead of lock ownership:

```text
Stamp (ID)
```

is returned.

---

# Optimistic Read

Most important feature.

---

## Traditional Read Lock

```text
Reader Acquires Lock
```

Overhead exists.

---

## Optimistic Read

```java
long stamp =
    lock.tryOptimisticRead();
```

No actual lock acquired.

---

# Flow

```text
Get Stamp
    |
Read Data
    |
Validate Stamp
```

---

# Example

```java
long stamp =
        lock.tryOptimisticRead();

int value = data;

if(!lock.validate(stamp)) {

    // fallback
}
```

---

# Diagram

```text
Reader
   |
   v

Read Data

   |
   v

Validate

   |
 +---+---+
 |       |
Valid   Invalid
 |         |
 v         v

Done   Real Lock
```

---

# Benefits

```text
Less Locking

Higher Throughput

Better Performance
```

---

# Important Limitation

StampedLock is:

```text
NOT REENTRANT
```

---

# Example

```java
writeLock();

writeLock();
```

Same thread.

Result:

```text
Deadlock
```

---

# Semaphore

Semaphore controls:

```text
How Many Threads
Can Access Resource
```

---

# Lock vs Semaphore

| Lock             | Semaphore        |
| ---------------- | ---------------- |
| Usually 1 thread | Multiple threads |
| Ownership based  | Permit based     |

---

# Example

Database allows:

```text
3 Connections
```

Create:

```java
Semaphore sem =
    new Semaphore(3);
```

---

# Diagram

```text
Permits = 3

T1 -> Permit 1
T2 -> Permit 2
T3 -> Permit 3

T4 -> Wait
```

---

# Acquire Permit

```java
sem.acquire();
```

---

# Release Permit

```java
sem.release();
```

---

# Flow

```text
Acquire Permit
      |
      v

Permit Available?

  +---+---+
  |       |
 Yes      No
  |       |
  v       v

Work    Wait
```

---

# Important Difference

Locks:

```text
Owner must unlock
```

Semaphores:

```text
Any Thread
Can Release Permit
```

No ownership tracking.

---

# API Rate Limiter Example

Allow:

```text
100 Requests
Per Minute
```

Use:

```text
Semaphore
```

to restrict concurrent access.

---

# Condition Interface

Modern replacement for:

```java
wait()
notify()
notifyAll()
```

---

# Legacy Mapping

| Legacy      | Modern      |
| ----------- | ----------- |
| wait()      | await()     |
| notify()    | signal()    |
| notifyAll() | signalAll() |

---

# Creating Condition

```java
Lock lock =
        new ReentrantLock();

Condition condition =
        lock.newCondition();
```

---

# await()

Equivalent to:

```java
wait()
```

---

```java
condition.await();
```

---

# signal()

Equivalent to:

```java
notify()
```

---

```java
condition.signal();
```

---

# signalAll()

Equivalent to:

```java
notifyAll()
```

---

```java
condition.signalAll();
```

---

# Biggest Advantage

Multiple waiting queues.

---

# Producer Consumer Example

Instead of:

```text
One Waiting Queue
```

Use:

```text
Producer Queue

Consumer Queue
```

---

# Diagram

```text
            Lock
              |
      ----------------
      |              |
      |              |
      v              v

ProducerQ      ConsumerQ
```

---

# Flow

```text
Producer Finishes
        |
        v

signal()

        |
        v

Consumer Queue Only
```

No random wakeups.

---

# Benefits of Condition

```text
Precise Signaling

Multiple Queues

Better Control

Higher Efficiency
```

---

# Concurrency Utilities Hierarchy

```text
java.util.concurrent

        |
        |
        v

    Locks

        |
   -------------------------
   |           |           |
   |           |           |
Reentrant  ReadWrite   Stamped
 Lock        Lock       Lock


        |
        v

   Condition


Semaphore
(Concurrency Control)
```

---

# Quick Revision Table

| Utility       | Purpose                   |
| ------------- | ------------------------- |
| ReentrantLock | Advanced lock             |
| tryLock()     | Non-blocking lock attempt |
| Fair Lock     | FIFO scheduling           |
| Read Lock     | Multiple readers          |
| Write Lock    | Single writer             |
| StampedLock   | Optimistic reading        |
| Semaphore     | Permit-based access       |
| Condition     | Advanced wait/notify      |

---

# One-Line Memory Tricks

```text
synchronized → Simple lock

ReentrantLock → Manual lock

tryLock() → Don't wait

Fair Lock → FIFO

Read Lock → Shared

Write Lock → Exclusive

StampedLock → Optimistic Read

Semaphore → Permit Counter

Condition → Modern wait/notify

await() → wait()

signal() → notify()

signalAll() → notifyAll()
```

---

# Most Asked Interview Questions

### Why use ReentrantLock over synchronized?

Because it supports:

```text
tryLock()
Timeouts
Fairness
Multiple Conditions
Manual Locking
```

---

### Why is it called ReentrantLock?

The same thread can acquire the same lock multiple times.

---

### What is starvation?

A thread waits indefinitely because others keep getting the resource.

---

### Can multiple readers access ReadWriteLock simultaneously?

✅ Yes

---

### Can multiple writers access ReadWriteLock simultaneously?

❌ No

---

### What is Optimistic Read?

Reading data without actually locking, then validating afterward.

---

### Is StampedLock reentrant?

❌ No

---

### What is a Semaphore?

A concurrency utility that controls access using permits.

---

### Difference between Lock and Semaphore?

Lock controls ownership.

Semaphore controls permits.

---

### Condition vs wait/notify?

Condition provides multiple waiting queues and precise signaling.

---

### Modern replacements?

```text
wait()      → await()

notify()    → signal()

notifyAll() → signalAll()
```
