# Java Heap Memory & Garbage Collection (GC)

---

# 1. Why Heap is Divided into Generations?

Most Java objects:

```text
Created
   ↓
Used briefly
   ↓
Destroyed quickly
```

Research shows:

```text
~90% of objects die young
```

Examples:

```java
String temp = "Hello";

for(int i=0;i<1000;i++){
    String s = "Java";
}
```

These objects exist only briefly.

Instead of scanning the entire heap every time, JVM divides heap into generations.

---

# Heap Architecture

```text
                    HEAP

 ┌─────────────────────────────────┐
 │                                 │
 │        Young Generation         │
 │                                 │
 │ ┌──────┐ ┌─────┐ ┌─────┐        │
 │ │Eden  │ │ S0  │ │ S1  │        │
 │ └──────┘ └─────┘ └─────┘        │
 │                                 │
 └─────────────────────────────────┘

                │
                ▼

 ┌─────────────────────────────────┐
 │                                 │
 │      Old Generation             │
 │      (Tenured Space)            │
 │                                 │
 └─────────────────────────────────┘
```

---

# 2. Young Generation

The Young Generation stores:

```text
Newly Created Objects
```

---

## Components

### Eden Space

Every new object starts here.

Example:

```java
Student s =
      new Student();
```

Object Location:

```text
Eden Space
```

---

### Survivor Space 0 (S0)

Stores objects that survive first GC.

---

### Survivor Space 1 (S1)

Stores objects that survive subsequent GCs.

---

# Memory Trick

```text
Eden
 ↓
S0
 ↓
S1
 ↓
Old Generation
```

---

# 3. Object Lifecycle

## Step 1: Object Creation

```java
Student s =
      new Student();
```

Stored in:

```text
Eden
```

---

## Step 2: Eden Becomes Full

```text
Eden Full
      ↓
Minor GC Runs
```

---

## Step 3: Object Survives

If object is reachable:

```text
Move Eden → S0

Age = 1
```

---

## Step 4: Another Minor GC

If object survives again:

```text
S0 → S1

Age = 2
```

---

## Step 5: Ping-Pong Movement

Objects continuously move:

```text
S0 → S1
S1 → S0
S0 → S1
```

Age increases every cycle.

---

# Lifecycle Diagram

```text
New Object
     │
     ▼

 Eden

     │
Minor GC

     ▼

 Survivor S0

     │
Minor GC

     ▼

 Survivor S1

     │
Minor GC

     ▼

 Survivor S0

     │
Age Threshold

     ▼

 Old Generation
```

---

# 4. Object Aging

Every surviving GC cycle:

```text
Age++
```

Example:

```text
After 1 GC = Age 1

After 2 GC = Age 2

After 3 GC = Age 3
```

---

# Promotion Threshold

Default JVM threshold:

```text
15
```

When:

```text
Age >= 15
```

Object moves to:

```text
Old Generation
```

---

# Interview Question

### Why does JVM promote objects?

Because repeated survival indicates:

```text
Long-Lived Object
```

Keeping it in Young Generation becomes inefficient.

---

# 5. Large Object Allocation

Normally:

```text
New Object
   ↓
Eden
```

But huge objects may skip Young Generation.

---

## Example

```java
byte[] arr =
      new byte[10_000_000];
```

Large allocation.

JVM may directly place it in:

```text
Old Generation
```

---

# Why?

Avoid expensive copying:

```text
Eden
 ↓
S0
 ↓
S1
```

for very large objects.

---

# 6. Types of Garbage Collection

---

# Minor GC

Operates on:

```text
Young Generation
```

---

## Trigger

```text
Eden Full
```

---

## Characteristics

✔ Frequent

✔ Fast

✔ Small Memory Area

---

# Minor GC Diagram

```text
Young Generation

 Eden Full
      │
      ▼

 Minor GC

      │
      ▼

 Dead Objects Removed

 Live Objects → Survivor
```

---

# Major GC

Operates on:

```text
Old Generation
```

---

## Trigger

```text
Old Generation Full
```

---

## Characteristics

❌ Slow

❌ Expensive

❌ Larger Memory Scan

---

# Full GC

Cleans:

```text
Young Generation

+

Old Generation

+

Other Heap Areas
```

---

# Comparison

| Minor GC         | Major GC       |
| ---------------- | -------------- |
| Young Generation | Old Generation |
| Fast             | Slow           |
| Frequent         | Rare           |
| Less Memory      | Large Memory   |

---

# 7. Stop The World (STW)

One of the most important JVM interview topics.

---

# Problem

While GC is running:

```text
Application Thread
```

and

```text
Garbage Collector
```

cannot modify memory simultaneously.

---

# Solution

JVM pauses application.

```text
STOP THE WORLD
```

---

# Flow

```text
Application Running
       │
       ▼

GC Starts
       │
       ▼

Pause Application
       │
       ▼

GC Work
       │
       ▼

Resume Application
```

---

# User Experience

Frequent STW causes:

```text
Lag

Slow Response

Performance Issues
```

---

# Modern JVM Solution

Use:

```text
Parallel GC

G1 GC

ZGC

Shenandoah
```

to reduce pause time.

---

# 8. Strong References

Default reference type in Java.

---

## Example

```java
Student s =
      new Student();
```

---

# Diagram

```text
s ───────► Student Object
```

---

# GC Behavior

As long as:

```text
Reference Exists
```

object survives.

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
GC Eligible
```

---

# 9. Soft References

Stored using:

```java
SoftReference<T>
```

---

# Behavior

Collected only when JVM needs memory.

---

# Example

```java
SoftReference<Student> ref =
      new SoftReference<>(
            new Student()
      );
```

---

# Use Case

Caching.

---

# Cache Logic

```text
Memory Available
       │
       ▼

Keep Object

Memory Low
       │
       ▼

Remove Object
```

---

# Interview Question

### Why SoftReference is used in caches?

Because cached objects remain available until memory pressure occurs.

---

# 10. Weak References

Stored using:

```java
WeakReference<T>
```

---

# Behavior

Removed during next GC cycle.

Even if memory is available.

---

# Example

```java
WeakReference<Student> ref =
      new WeakReference<>(
            new Student()
      );
```

---

# Flow

```text
Weak Reference
       │
       ▼

Next GC
       │
       ▼

Object Removed
```

---

# Common Use

```java
WeakHashMap
```

---

# 11. Phantom References

Most advanced reference type.

---

# Behavior

Object already finalized.

Reference exists only for tracking.

---

# Purpose

```text
Post-Mortem Cleanup

Memory Tracking

Resource Monitoring
```

---

# Interview Tip

Rarely used in application development.

Mostly JVM/Internal framework usage.

---

# Reference Comparison

| Reference Type | GC Behavior                      |
| -------------- | -------------------------------- |
| Strong         | Never collected while referenced |
| Soft           | Collected when memory needed     |
| Weak           | Collected in next GC             |
| Phantom        | After object cleanup             |

---

# 12. Garbage Collection Algorithms

---

# A. Mark and Sweep

Most fundamental algorithm.

---

## Step 1: Mark

GC identifies reachable objects.

```text
Reachable = Marked
```

---

## Step 2: Sweep

Unmarked objects removed.

---

# Diagram

```text
Object A  ✔

Object B  ✘

Object C  ✔

Object D  ✘
```

After Sweep:

```text
A Survives

B Removed

C Survives

D Removed
```

---

# Problem: Fragmentation

Memory becomes:

```text
[Obj][Free][Obj][Free]
```

Scattered free spaces.

---

# Fragmentation Diagram

```text
┌───┬───┬───┬───┐
│Obj│   │Obj│   │
└───┴───┴───┴───┘
```

---

# Drawback

Large object allocation becomes difficult.

---

# B. Mark and Compact

Adds compaction step.

---

# Steps

```text
Mark

↓

Sweep

↓

Compact
```

---

# Diagram

Before:

```text
Obj Free Obj Free Obj
```

After:

```text
Obj Obj Obj Free Free
```

---

# Benefit

No fragmentation.

---

# Drawback

Object movement is expensive.

---

# C. Copying Algorithm

Commonly used in Young Generation.

---

# Process

Instead of cleaning memory piece by piece:

```text
Copy Live Objects
```

to another region.

Then:

```text
Delete Entire Old Region
```

---

# Example

```text
Eden

A Alive
B Dead
C Alive
D Dead
```

After Copy:

```text
Survivor

A
C
```

Entire Eden cleaned.

---

# Why Fast?

Most objects are dead.

Only few need copying.

---

# 13. System.gc()

Manual request for GC.

---

# Example

```java
System.gc();
```

---

# Important Interview Question

### Does System.gc() force GC?

No.

It only requests:

```text
Dear JVM,
Please run GC
```

JVM may ignore it.

---

# 14. Heap Dump

Heap snapshot at a specific moment.

---

# Contains

```text
All Objects

Memory Usage

Reference Chains

Class Statistics
```

---

# Purpose

Detect:

```text
Memory Leaks

Large Objects

Excessive Memory Usage
```

---

# Popular Tools

```text
VisualVM

Eclipse MAT

JProfiler

YourKit
```

---

# 15. Memory Leaks

Java can still have memory leaks.

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

---

# Why GC Can't Remove Them?

Objects are still:

```text
Reachable
```

through:

```text
cache
```

---

# Memory Leak Definition

```text
Objects Not Needed

BUT

Still Referenced
```

---

# Leak Diagram

```text
Cache
  │
  ▼

Object

Object

Object

Object

Object
```

GC cannot remove them.

---

# 16. OutOfMemoryError

Occurs when:

```text
Heap Full
```

and GC cannot free enough memory.

---

# Flow

```text
Allocate Object
      │
      ▼

Heap Full
      │
      ▼

GC Runs
      │
      ▼

No Space Available
      │
      ▼

OutOfMemoryError
```

---

# Quick Revision Sheet

```text
Eden
  -> New Objects

S0/S1
  -> Surviving Objects

Old Generation
  -> Long-Lived Objects

Minor GC
  -> Young Generation

Major GC
  -> Old Generation

Strong Reference
  -> Normal Reference

Soft Reference
  -> Cache

Weak Reference
  -> Removed Next GC

Phantom Reference
  -> Cleanup Tracking

Mark-Sweep
  -> Fragmentation

Mark-Compact
  -> No Fragmentation

Copying
  -> Young Generation

STW
  -> Application Pause

System.gc()
  -> GC Request

Heap Dump
  -> Memory Analysis

OutOfMemoryError
  -> Heap Exhausted
```

---

# Interview One-Liner

"Java Heap Memory is divided into Young and Old Generations to optimize garbage collection. Objects begin in Eden, move through Survivor Spaces based on age, and are eventually promoted to the Old Generation. Garbage Collection uses algorithms such as Mark-Sweep, Mark-Compact, and Copying while managing object reachability through Strong, Soft, Weak, and Phantom references."
