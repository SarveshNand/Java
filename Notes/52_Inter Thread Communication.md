# Java Inter-Thread Communication (ITC)

## wait(), notify(), notifyAll()

---

# 1. What is Inter-Thread Communication (ITC)?

## Definition

Inter-Thread Communication (ITC) is a mechanism that allows threads to communicate and coordinate with each other.

Synchronization solves:

```text
One thread at a time
```

But it does NOT solve:

```text
Which thread should run first?
```

For coordination we use:

```java
wait()
notify()
notifyAll()
```

---

# Why Do We Need ITC?

Consider:

```text
Producer Thread
       |
       v
   Creates Data

Consumer Thread
       |
       v
   Uses Data
```

Problem:

```text
Consumer runs first
```

Box is empty.

Result:

```text
null
Empty Data
Incorrect Output
```

---

## Real-Life Example

Imagine a restaurant.

```text
Chef = Producer

Customer = Consumer
```

Customer cannot eat until food is prepared.

```text
Food Ready?
      |
      |
     No
      |
      v

Wait
```

This waiting and notification process is Inter-Thread Communication.

---

# Synchronization vs ITC

| Synchronization          | Inter-Thread Communication |
| ------------------------ | -------------------------- |
| Controls access          | Controls coordination      |
| One thread at a time     | Correct execution order    |
| Uses lock                | Uses wait/notify           |
| Prevents race conditions | Prevents wrong timing      |

---

# Core Methods

All ITC methods belong to:

```java
java.lang.Object
```

Not:

```java
Thread
```

---

# Why Object Class?

Because waiting happens on an object's monitor lock.

Every object has:

```text
Monitor Lock
Waiting Queue
```

Therefore methods belong to Object.

---

# Methods Overview

| Method      | Purpose                         |
| ----------- | ------------------------------- |
| wait()      | Suspend thread and release lock |
| notify()    | Wake one waiting thread         |
| notifyAll() | Wake all waiting threads        |

---

# Visual Overview

```text
Thread
   |
wait()
   |
   v

Waiting Queue

   ^
   |
notify()

```

---

# 2. Producer Consumer Problem

This is the most famous ITC example.

---

# Scenario

```text
Producer
    |
    v

 Shared Box

    ^
    |
    |

Consumer
```

---

# Problems Without ITC

## Problem 1

Consumer runs first.

```text
Consumer
     |
     v

Reads Empty Box
```

Result:

```text
null
```

---

## Problem 2

Producer too fast.

```text
Produce A
Produce B
Produce C
```

Consumer reads:

```text
Only C
```

Previous values lost.

---

# Goal

```text
Producer
    |
    v

Put Item

    |
    v

Consumer Reads

    |
    v

Producer Creates Next Item
```

---

# Shared Box Example

```java
class Box {

    private int item;

    private boolean hasItem = false;
}
```

---

# Box State Diagram

```text
Empty
  |
  |
Produce
  |
  v

Full
  |
  |
Consume
  |
  v

Empty
```

---

# Producer Logic

```java
public synchronized void produce(int value)
        throws InterruptedException {

    while(hasItem) {

        wait();
    }

    item = value;

    hasItem = true;

    notify();
}
```

---

# Flow

```text
Producer
    |
    v

Box Full?

    |
 +--+--+
 |     |
Yes    No
 |      |
 v      v

wait() Produce
```

---

# Consumer Logic

```java
public synchronized void consume()
        throws InterruptedException {

    while(!hasItem) {

        wait();
    }

    System.out.println(item);

    hasItem = false;

    notify();
}
```

---

# Flow

```text
Consumer
    |
    v

Item Available?

    |
 +--+--+
 |     |
No    Yes
 |      |
 v      v

wait() Consume
```

---

# Complete Interaction

```text
Producer
    |
    v

Produce Item

    |
notify()
    |
    v

Consumer Wakes

    |
    v

Consume Item

    |
notify()
    |
    v

Producer Wakes
```

---

# 3. wait() Internal Working

When thread executes:

```java
wait();
```

Three things happen.

---

# Step 1: Release Lock

Thread currently owns monitor lock.

```text
Before wait()

Thread-1
    |
Owns Lock
```

After wait():

```text
Lock Released
```

---

# Why Important?

If lock isn't released:

```text
Other Thread
      |
      v

Cannot Enter
```

Then nobody could call:

```java
notify()
```

Deadlock would occur.

---

# Step 2: Enter Waiting Queue

```text
Object Monitor
       |
       |
       v

Waiting Queue

[Thread-1]
```

Thread becomes inactive.

---

# Step 3: WAITING State

```text
RUNNING
    |
wait()
    |
    v

WAITING
```

Thread pauses indefinitely.

---

# Complete Flow

```text
RUNNING
    |
wait()
    |
    v

Release Lock

    |
    v

Waiting Queue

    |
    v

WAITING State
```

---

# 4. notify() Internal Working

Suppose waiting queue contains:

```text
Waiting Queue

[T1]
[T2]
[T3]
```

---

Thread executes:

```java
notify();
```

One thread is chosen.

```text
Waiting Queue

[T1]
[T2]
[T3]

notify()

      |
      v

Random Thread Wakes
```

Maybe:

```text
T2
```

Maybe:

```text
T1
```

No guarantee.

---

# Important Interview Question

Does notify() immediately run the thread?

❌ No

---

# Actual Flow

```text
WAITING
    |
notify()
    |
    v

BLOCKED
    |
Acquire Lock
    |
    v

RUNNABLE
```

---

# Why BLOCKED?

Thread must regain monitor lock.

---

# Diagram

```text
wait()

WAITING
   |
notify()
   |
   v

BLOCKED
   |
Lock Acquired
   |
   v

RUNNABLE
```

---

# 5. notifyAll()

Instead of waking one thread:

```java
notifyAll();
```

wakes everyone.

---

# Example

Before:

```text
Waiting Queue

[T1]
[T2]
[T3]
[T4]
```

After:

```text
notifyAll()

     |
     v

All Wake Up
```

---

# Then What?

All compete for lock.

```text
T1
T2
T3
T4

      |
      v

Only One Gets Lock
```

Others become BLOCKED.

---

# Diagram

```text
WAITING THREADS

T1
T2
T3

      |
notifyAll()
      |
      v

BLOCKED

T1
T2
T3

      |
Lock Available
      |
      v

One Runs
```

---

# 6. IllegalMonitorStateException

Most Common Interview Question.

---

# Wrong Code

```java
public void test() {

    wait();
}
```

Output:

```text
IllegalMonitorStateException
```

---

# Why?

Thread does not own monitor lock.

---

# Correct

```java
synchronized(this) {

    wait();
}
```

or

```java
public synchronized void test() {

    wait();
}
```

---

# Rule

```text
wait()
notify()
notifyAll()

MUST be called

Inside synchronized block
or
Inside synchronized method
```

---

# Memory Trick

```text
No Lock
   ↓
Exception

Own Lock
   ↓
Allowed
```

---

# 7. notify() vs notifyAll()

## notify()

```java
notify();
```

Wakes:

```text
ONE Thread
```

---

## notifyAll()

```java
notifyAll();
```

Wakes:

```text
ALL Threads
```

---

# Diagram

notify():

```text
[T1]
[T2]
[T3]

notify()

     |
     v

[T2]
```

Only one wakes.

---

notifyAll():

```text
[T1]
[T2]
[T3]

notifyAll()

     |
     v

T1
T2
T3
```

All wake.

---

# Which Is Safer?

Production systems usually prefer:

```java
notifyAll();
```

---

# Why?

Multiple Producers + Consumers

```text
Producer
Producer
Consumer
Consumer
```

Using notify():

```text
Producer wakes Producer
```

Possible.

Everyone may end up waiting.

---

Using notifyAll():

```text
Wake Everybody
```

Correct thread gets chance.

---

# 8. Spurious Wake-Up

Rare JVM/OS optimization issue.

A waiting thread wakes without notification.

---

# Problem

```java
if(!hasItem) {

    wait();
}
```

Thread wakes unexpectedly.

Continues execution.

May consume empty data.

---

# Wrong Approach

```java
if(!hasItem) {

    wait();
}
```

Condition checked only once.

---

# Correct Approach

```java
while(!hasItem) {

    wait();
}
```

---

# Why While?

After waking:

```text
Condition Rechecked
```

If still false:

```text
Back To Waiting
```

---

# Guarded Block Pattern

```java
while(conditionNotSatisfied) {

    wait();
}
```

---

# Flow

```text
Condition False
       |
       v

wait()

       |
Wake Up
       |
       v

Check Condition Again

       |
 +-----+------+
 |            |
True         False
 |             |
Continue     wait()
```

---

# Interview Rule

Always use:

```java
while()
```

Never:

```java
if()
```

with wait().

---

# Thread State Transition

```text
RUNNING
   |
wait()
   |
   v

WAITING
   |
notify()
   |
   v

BLOCKED
   |
Lock Acquired
   |
   v

RUNNABLE
```

---

# Complete ITC Architecture

```text
Producer
    |
    |
    v

+------------+
|    Box     |
|------------|
| wait()     |
| notify()   |
+------------+

    ^
    |
    |
Consumer
```

---

# wait() vs sleep()

Most Asked Interview Question

| Feature                     | wait()               | sleep()       |
| --------------------------- | -------------------- | ------------- |
| Class                       | Object               | Thread        |
| Lock Released               | Yes                  | No            |
| State                       | WAITING              | TIMED_WAITING |
| Wake Up                     | notify()/notifyAll() | Time Expiry   |
| Must Be Inside synchronized | Yes                  | No            |
| Used For                    | Communication        | Delay         |

---

# Diagram

sleep():

```text
RUNNING
   |
sleep(5 sec)
   |
   v

TIMED_WAITING

   |
5 sec
   |
   v

RUNNABLE
```

---

wait():

```text
RUNNING
   |
wait()
   |
   v

WAITING

   |
notify()
   |
   v

BLOCKED

   |
Lock
   |
   v

RUNNABLE
```

---

# Quick Revision Table

| Concept                      | Meaning                  |
| ---------------------------- | ------------------------ |
| ITC                          | Thread coordination      |
| wait()                       | Release lock and wait    |
| notify()                     | Wake one waiting thread  |
| notifyAll()                  | Wake all waiting threads |
| Waiting Queue                | Stores waiting threads   |
| Guarded Block                | while(condition) wait()  |
| Spurious Wake-Up             | Unexpected wake-up       |
| IllegalMonitorStateException | No lock ownership        |
| Producer                     | Creates data             |
| Consumer                     | Uses data                |

---

# One-Line Memory Tricks

```text
wait()       → Sleep and release lock

notify()     → Wake one thread

notifyAll()  → Wake everyone

WAITING      → Sleeping forever

BLOCKED      → Waiting for lock

Producer     → Creates data

Consumer     → Uses data

while(wait)  → Safe

if(wait)     → Dangerous

sleep()      → Delay

wait()       → Communication
```

---

# Most Asked Interview Questions

### Why do wait(), notify(), and notifyAll() belong to Object class?

Because they operate on an object's monitor lock and waiting queue.

---

### What happens when wait() is called?

1. Releases lock
2. Enters waiting queue
3. Moves to WAITING state

---

### Does wait() release lock?

✅ Yes

---

### Does sleep() release lock?

❌ No

---

### Can wait() be called outside synchronized block?

❌ No

Throws:

```text
IllegalMonitorStateException
```

---

### Why use while instead of if with wait()?

To handle:

```text
Spurious Wake-Ups
```

and recheck conditions.

---

### Does notify() wake a specific thread?

❌ No

Random waiting thread.

---

### Which is safer in production?

✅ notifyAll()

---

### What state comes after notify()?

```text
WAITING
   ↓
BLOCKED
```

Not directly RUNNABLE.

---

### What is the Producer-Consumer Problem?

A synchronization problem where producers create data and consumers use it, requiring coordination through wait/notify.
