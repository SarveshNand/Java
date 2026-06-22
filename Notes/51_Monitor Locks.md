# Java Synchronization (`synchronized`)

---

# Why Do We Need Synchronization?

Previously, we learned about:

```text
Race Condition
Atomicity Problem
Visibility Problem
Ordering Problem
```

All of these occur because multiple threads access the same resource simultaneously.

Example:

```java
count++;
```

Internally:

```text
Read
 ↓
Modify
 ↓
Write
```

If two threads execute this at the same time:

```text
Thread-1 ---> count
Thread-2 ---> count
```

Result:

```text
Data Corruption
```

---

# The Solution: synchronized

## Definition

The `synchronized` keyword allows only one thread at a time to execute a critical section.

Think of it as a room with a single key.

```text
            LOCK
              |
              |
              v

         Critical Section

              ^
              |
              |
         One Thread Only
```

---

# Real-Life Analogy

Consider a bathroom with only one key.

```text
Thread-1
    |
    v
 Uses Bathroom

Thread-2
    |
    v
 Waits Outside
```

Only after Thread-1 exits can Thread-2 enter.

This is exactly how synchronization works.

---

# How synchronized Solves Race Conditions

Without Synchronization:

```text
Thread-1
Read count = 0

Thread-2
Read count = 0

Thread-1
Write 1

Thread-2
Write 1

Final Count = 1
```

Expected:

```text
2
```

---

With Synchronization:

```text
Thread-1 acquires lock

Read
Modify
Write

Releases lock

Thread-2 acquires lock

Read
Modify
Write

Releases lock
```

Final:

```text
2
```

Correct result.

---

# Internal Working: Monitor Lock

Every Java object has a built-in lock.

Also called:

```text
Monitor Lock
Object Lock
Intrinsic Lock
```

Managed automatically by JVM.

---

# Lock Acquisition Process

```text
Thread Wants Lock
         |
         v

Is Lock Free?
      |
   +--+--+
   |     |
  Yes    No
   |     |
   v     v

Acquire  BLOCKED
 Lock      |
           |
      Waiting Queue

```

---

# Complete Flow

```text
Thread-1
     |
     v

Acquire Lock
     |
     v

Execute Critical Section
     |
     v

Release Lock
     |
     v

Thread-2 Gets Chance
```

---

# Context Switch Scenario

Suppose:

```java
synchronized(this) {

    count++;

}
```

Thread-1 enters.

```text
Thread-1 owns lock
```

CPU performs context switch.

```text
Thread-2 starts running
```

Can Thread-2 enter synchronized block?

```text
NO
```

Because Thread-1 still owns the lock.

---

# Thread States During Synchronization

```text
Thread-1
    |
    v
 Acquires Lock
    |
    v
 RUNNING


Thread-2
    |
    v
 Tries Same Lock
    |
    v
 BLOCKED
```

---

# Instance Synchronization

## Synchronized Method

```java
public synchronized void increment() {

    count++;
}
```

Equivalent to:

```java
public void increment() {

    synchronized(this) {

        count++;
    }
}
```

---

# Lock Used?

```text
this
(Current Object)
```

---

# Diagram

```text
Counter Object
------------------

Lock

increment()
reset()
print()
```

All synchronized methods share the same lock.

---

# One Object = One Lock

Example:

```java
class Counter {

    synchronized void m1(){}

    synchronized void m2(){}
}
```

---

Suppose:

```text
Thread-1 executes m1()
```

Then:

```text
Thread-2 cannot execute m2()
```

because both use:

```text
Same Object Lock
```

---

# Visualization

```text
Counter Object
     |
     v
   LOCK

  /      \
m1()    m2()

Only One Thread
```

---

# Example

```java
class Counter {

    public synchronized void increment() {

        count++;
    }

    public synchronized void reset() {

        count = 0;
    }
}
```

Both methods share the same lock.

---

# Multiple Objects

```java
Counter c1 = new Counter();

Counter c2 = new Counter();
```

Each object gets its own lock.

```text
c1 ---> Lock-1

c2 ---> Lock-2
```

---

## Parallel Execution Possible

```text
Thread-1 -> c1.increment()

Thread-2 -> c2.increment()
```

No blocking.

Different locks.

---

# Synchronized Blocks

## Why Needed?

Method synchronization locks the entire method.

Sometimes only a few lines are risky.

---

## Example

```java
public void update() {

    System.out.println("Start");

    synchronized(this) {

        count++;
    }

    System.out.println("End");
}
```

---

# Diagram

```text
update()

 |
 |
 v

Non-Critical Code
     |
     |
     v

Synchronized Block
(Critical Section)

     |
     |
     v

Non-Critical Code
```

---

# Advantage

Only the dangerous code is locked.

```text
Less Blocking
More Performance
```

---

# Fine-Grained Locking

```java
synchronized(this) {

    count++;
}
```

Only:

```java
count++;
```

is protected.

---

# Static Synchronization

## Static Synchronized Method

```java
public static synchronized void update() {

}
```

---

# Which Lock Is Used?

Not:

```text
this
```

Instead:

```text
ClassName.class
```

---

# Diagram

```text
Counter.class
      |
      v
  Class Lock
```

---

# Example

```java
class Counter {

    public static synchronized void print() {

    }
}
```

Lock:

```text
Counter.class
```

---

# Class Lock vs Object Lock

```java
Counter c1 = new Counter();
Counter c2 = new Counter();
```

Thread-1:

```java
Counter.print();
```

Uses:

```text
Class Lock
```

Thread-2:

```java
c1.increment();
```

Uses:

```text
Object Lock
```

---

## Can They Run Together?

✅ Yes

Different locks.

---

# Visualization

```text
Counter.class
      |
      v
 Class Lock


Counter Object
      |
      v
 Object Lock
```

Independent.

---

# Custom Lock Objects

Java allows any object to act as a lock.

---

## Example

```java
private final Object lock1 =
        new Object();

private final Object lock2 =
        new Object();
```

---

# Why Use Multiple Locks?

To increase concurrency.

---

# Bank Example

```java
class Bank {

    private final Object depositLock =
            new Object();

    private final Object withdrawLock =
            new Object();

}
```

---

## Deposit

```java
public void deposit() {

    synchronized(depositLock) {

        // deposit logic
    }
}
```

---

## Withdraw

```java
public void withdraw() {

    synchronized(withdrawLock) {

        // withdraw logic
    }
}
```

---

# Diagram

```text
deposit()
     |
     v
 depositLock


withdraw()
     |
     v
 withdrawLock
```

---

# Benefit

```text
Deposit Thread
       |
       v

Can Run

       |

Withdraw Thread
```

No unnecessary blocking.

---

# Critical Interview Question

## synchronized(new Object())

```java
synchronized(new Object()) {

    count++;
}
```

Looks synchronized.

Actually useless.

---

# Why?

Every execution creates:

```text
New Object
New Lock
```

---

# Example

Thread-1:

```text
Object A
```

Thread-2:

```text
Object B
```

Thread-3:

```text
Object C
```

---

# Visualization

```text
Thread-1 -> Lock A

Thread-2 -> Lock B

Thread-3 -> Lock C
```

Nobody waits.

No synchronization happens.

---

# Memory Trick

```text
Same Lock
    ↓
Synchronization

Different Locks
    ↓
No Synchronization
```

---

# Benefits of synchronized

---

# 1. Atomicity

Makes critical section execute as one unit.

```text
Read
Modify
Write
```

cannot be interrupted.

---

# 2. Visibility

When lock is released:

```text
CPU Cache
     |
     v
RAM
```

Changes are flushed.

Other threads see updated values.

---

# Diagram

```text
Thread-1

Changes Data
      |
      v

Release Lock
      |
      v

Write To RAM


Thread-2
      |
      v

Acquire Lock
      |
      v

Read Latest Data
```

---

# 3. Ordering

Prevents instruction reordering across synchronization boundaries.

---

## Example

```java
synchronized(lock) {

    data = 100;

    flag = true;
}
```

JVM guarantees proper order.

---

# Drawbacks of synchronized

---

# 1. Performance Overhead

Lock acquisition takes time.

```text
Acquire Lock
Execute
Release Lock
```

More expensive than normal code.

---

# 2. Blocking

Threads may spend time waiting.

```text
Thread-1 Running

Thread-2 BLOCKED

Thread-3 BLOCKED
```

---

# 3. Deadlock Risk

Possible when multiple locks are involved.

```text
Thread-1 waits for Lock-B

Thread-2 waits for Lock-A

Forever
```

---

# Deadlock Visualization

```text
Thread-1
   |
 Lock-A
   |
 Waiting Lock-B


Thread-2
   |
 Lock-B
   |
 Waiting Lock-A
```

Neither can continue.

---

# Synchronization Scope Comparison

| Type                | Lock Used       |
| ------------------- | --------------- |
| synchronized method | this            |
| synchronized(this)  | this            |
| synchronized(obj)   | obj             |
| static synchronized | ClassName.class |

---

# Who Gets Blocked?

| Synchronization Type | Blocked Threads                |
| -------------------- | ------------------------------ |
| Instance Method      | Threads using same object      |
| synchronized(this)   | Threads using same object      |
| synchronized(obj)    | Threads using same lock object |
| Static Method        | Threads using same class lock  |

---

# Complete Lock Hierarchy

```text
Java Locking

          synchronized
                 |
    --------------------------
    |            |           |
    |            |           |
 Instance     Static     Custom
  Lock         Lock       Lock

   this     ClassName     Any Object
             .class
```

---

# Quick Revision Table

| Concept             | Meaning                     |
| ------------------- | --------------------------- |
| Monitor Lock        | Built-in object lock        |
| Object Lock         | Lock associated with object |
| Class Lock          | Lock associated with class  |
| synchronized Method | Locks entire method         |
| synchronized Block  | Locks specific code         |
| BLOCKED State       | Waiting for lock            |
| Custom Lock         | User-defined lock object    |
| Atomicity           | One thread at a time        |
| Visibility          | Latest value visible        |
| Ordering            | Prevents reordering         |

---

# One-Line Memory Tricks

```text
synchronized      → One thread at a time

Monitor Lock      → Hidden JVM lock

this              → Object Lock

ClassName.class   → Class Lock

BLOCKED           → Waiting for lock

Custom Lock       → Multiple independent locks

Atomicity         → Complete operation

Visibility        → Fresh data

Ordering          → Correct execution order

new Object()      → New lock every time (Wrong!)
```

---

# Most Asked Interview Questions

### What lock does a synchronized method use?

```text
this
(Current Object)
```

---

### What lock does a static synchronized method use?

```text
ClassName.class
```

---

### Can two threads execute synchronized methods on different objects?

✅ Yes

Different objects → Different locks.

---

### Does synchronized solve race conditions?

✅ Yes

---

### Does synchronized solve visibility problems?

✅ Yes

---

### Does synchronized solve instruction reordering?

✅ Yes

---

### Why is synchronized(new Object()) wrong?

Because every thread gets a new lock object, so no actual synchronization occurs.

---

### Which thread state occurs when waiting for a lock?

```text
BLOCKED
```

---

### What are the three guarantees of synchronized?

```text
1. Atomicity
2. Visibility
3. Ordering
```
