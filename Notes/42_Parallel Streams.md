# Java Parallel Streams & Primitive Optional Classes

---

# 1. Why Parallel Streams?

Before Java 8, if we wanted to process large amounts of data concurrently, we had to manually manage:

* Threads
* Executors
* Synchronization
* Locks
* Thread Pools

Example:

```java
Thread t1 = new Thread(() -> processChunk1());
Thread t2 = new Thread(() -> processChunk2());

t1.start();
t2.start();
```

Problems:

* Complex code
* Difficult debugging
* Thread management overhead
* Risk of race conditions

Java 8 introduced:

```java
parallelStream()
```

which automatically handles parallel execution.

---

# What is a Parallel Stream?

A Parallel Stream divides data into multiple chunks and processes those chunks simultaneously using multiple threads.

---

## Sequential Stream

```java
list.stream()
```

Processing:

```text
1 → Process
2 → Process
3 → Process
4 → Process
5 → Process
```

Single Thread

---

## Parallel Stream

```java
list.parallelStream()
```

Processing:

```text
            Fork
              │
      ┌───────┼───────┐
      │       │       │
      ▼       ▼       ▼

    1,2     3,4     5,6

      │       │       │

      ▼       ▼       ▼

   Thread1 Thread2 Thread3

      │       │       │

      └───────┼───────┘
              │
            Join
```

Multiple Threads

---

# Sequential vs Parallel

## Sequential

```java
List<Integer> list =
        List.of(1,2,3,4,5);

list.stream()
    .map(x -> x * 2)
    .forEach(System.out::println);
```

Output:

```text
2
4
6
8
10
```

Order preserved.

---

## Parallel

```java
list.parallelStream()
    .map(x -> x * 2)
    .forEach(System.out::println);
```

Possible Output:

```text
6
10
2
8
4
```

Order not guaranteed.

---

# Why Order Changes?

Different threads finish at different times.

Example:

```text
Thread-1 → 2
Thread-2 → 6
Thread-3 → 10
Thread-1 → 4
Thread-2 → 8
```

Results arrive based on completion time.

Not insertion order.

---

# Maintaining Order

Use:

```java
forEachOrdered()
```

Example:

```java
list.parallelStream()
    .map(x -> x * 2)
    .forEachOrdered(System.out::println);
```

Output:

```text
2
4
6
8
10
```

---

# Cost of forEachOrdered()

Maintaining order requires:

```text
Wait
Synchronize
Rearrange
Merge
```

Extra overhead.

Sometimes slower than sequential streams.

---

# Interview Question

## Difference Between forEach() and forEachOrdered()

| forEach()                    | forEachOrdered()              |
| ---------------------------- | ----------------------------- |
| Faster                       | Slower                        |
| Unordered                    | Ordered                       |
| Best for parallel processing | Adds synchronization overhead |

---

# 2. Internal Architecture

Parallel Streams are built on:

```text
Fork-Join Framework
```

introduced in Java 7.

---

# Fork Join Workflow

```text
Large Task
     │
     ▼
    Fork
     │
 ┌───┼───┐
 ▼   ▼   ▼

Task1
Task2
Task3

 │    │    │

 ▼    ▼    ▼

Process Concurrently

 │    │    │

 ▼    ▼    ▼

    Join
     │
     ▼

 Final Result
```

---

# Real Example

Dataset:

```text
1 2 3 4 5 6 7 8
```

Fork:

```text
[1 2 3 4] [5 6 7 8]
```

Further Fork:

```text
[1 2] [3 4] [5 6] [7 8]
```

Threads process independently.

---

# Fork Join Pool

Parallel streams use:

```java
ForkJoinPool.commonPool()
```

Default threads:

```java
CPU Cores - 1
```

Example:

8-core machine

```text
7 Worker Threads
```

---

# Interview Question

## Which Thread Pool Is Used?

Answer:

```java
ForkJoinPool.commonPool()
```

---

# 3. Spliterator

The hidden hero behind Parallel Streams.

Meaning:

```text
Split + Iterator
```

---

# Responsibilities

## 1. Traversal

Like Iterator

```text
Move Through Elements
```

---

## 2. Splitting

```text
Data
 │
 ▼

Split
 │
 ▼

Chunks
```

---

## 3. Metadata

Provides:

```text
Size
Ordering
Characteristics
```

to optimize processing.

---

# Spliterator Diagram

```text
ArrayList

1 2 3 4 5 6 7 8

         │

         ▼

     Spliterator

         │

 ┌───────┼───────┐

 ▼       ▼       ▼

1,2     3,4     5,6,7,8
```

---

# 4. Performance Considerations

Many developers assume:

```text
Parallel = Faster
```

Wrong.

Sometimes:

```text
Parallel < Sequential
```

---

# Performance Formula

```text
Useful Work
     >
Parallelization Cost
```

Otherwise performance decreases.

---

# 5. Stateless Operations

Best candidates for parallel streams.

Examples:

```java
map()
filter()
peek()
```

---

# Why?

Each element can be processed independently.

Example:

```java
list.parallelStream()
    .map(x -> x * x);
```

For:

```text
1 2 3 4
```

Calculating:

```text
1²
2²
3²
4²
```

No dependency.

Perfect parallelization.

---

# Stateless Flow

```text
Element1 → Process

Element2 → Process

Element3 → Process

Element4 → Process
```

Independent.

---

# 6. Stateful Operations

Examples:

```java
sorted()
distinct()
limit()
skip()
```

Need knowledge of other elements.

---

# Example: sorted()

Before sorting:

```text
5 2 8 1 7
```

Thread cannot sort:

```text
5
```

alone.

It must know:

```text
2
8
1
7
```

Therefore:

```text
Synchronization Required
```

---

# Stateful Bottleneck

```text
Thread1
Thread2
Thread3

    WAIT

Collect All Data

Sort

Continue
```

Performance suffers.

---

# Interview Question

## Which Operations Are Bad for Parallel Streams?

Answer:

```java
sorted()
distinct()
limit()
skip()
```

because they are stateful.

---

# 7. Data Structure Impact

---

# ArrayList

Excellent choice.

Reason:

```text
Random Access
```

Middle element:

```java
list.get(size/2)
```

Complexity:

```text
O(1)
```

---

# LinkedList

Poor choice.

To find middle:

```text
Traverse Node By Node
```

Complexity:

```text
O(n)
```

---

# Splitting Comparison

```text
ArrayList
    │
    ▼
Fast Split

LinkedList
    │
    ▼
Expensive Split
```

---

# Interview Question

## Which Collection Is Best for Parallel Streams?

Answer:

```java
ArrayList
Array
```

because splitting is cheap.

---

# 8. CPU-Bound vs IO-Bound Tasks

---

# CPU-Bound

Examples:

```text
Encryption
Compression
Image Processing
Mathematical Calculations
```

Parallel Streams work well.

---

# Example

```java
list.parallelStream()
    .map(this::heavyCalculation)
    .toList();
```

All CPU cores utilized.

---

# IO-Bound Tasks

Examples:

```text
Database Calls
API Calls
Network Requests
File Reads
```

Not ideal.

Why?

Threads spend time waiting.

---

# CPU Utilization Diagram

```text
CPU Task

Core1 Busy
Core2 Busy
Core3 Busy
Core4 Busy

Excellent
```

---

```text
IO Task

Core1 Waiting
Core2 Waiting
Core3 Waiting
Core4 Waiting

Wasteful
```

---

# 9. Shared Mutable State

Most important interview topic.

---

# Dangerous Example

```java
List<Integer> result =
        new ArrayList<>();

list.parallelStream()
    .forEach(result::add);
```

Looks harmless.

Actually dangerous.

---

# What Happens?

```text
Thread1 -> add(1)

Thread2 -> add(2)

Thread3 -> add(3)

Simultaneously
```

ArrayList isn't thread-safe.

---

# Race Condition

```text
Thread1 reads index = 5

Thread2 reads index = 5

Thread1 writes

Thread2 overwrites
```

Data loss occurs.

---

# Result

Possible:

```text
Missing Elements
Duplicate Elements
Corrupted Data
```

---

# Safe Alternative

Use collectors.

```java
List<Integer> result =
    list.parallelStream()
        .collect(Collectors.toList());
```

Framework handles synchronization.

---

# Race Condition Diagram

```text
Shared Variable

      │

 ┌────┼────┐

 ▼    ▼    ▼

T1   T2   T3

     Conflict

      ▼

 Wrong Result
```

---

# Interview Question

## Why Is Shared Mutable State Dangerous?

Because multiple threads can modify the same memory simultaneously causing race conditions.

---

# 10. Primitive Optional Classes

---

# Problem with Optional<Integer>

```java
Optional<Integer>
```

requires:

```text
Boxing
Unboxing
```

---

# Boxing

```java
int → Integer
```

---

# Unboxing

```java
Integer → int
```

Extra object creation.

Extra memory.

Extra CPU.

---

# Solution

Primitive Optionals.

---

# Available Classes

```java
OptionalInt
OptionalLong
OptionalDouble
```

---

# Comparison

## Generic Optional

```java
Optional<Integer>
```

Stores:

```text
Integer Object
```

---

## Primitive Optional

```java
OptionalInt
```

Stores:

```text
Primitive int
```

No boxing.

---

# Example

```java
IntStream stream =
        IntStream.of(1,2,3,4);

OptionalInt max =
        stream.max();
```

---

# Retrieving Value

```java
if(max.isPresent()){

    System.out.println(
        max.getAsInt()
    );
}
```

Output:

```text
4
```

---

# Primitive Getters

| Class          | Getter        |
| -------------- | ------------- |
| OptionalInt    | getAsInt()    |
| OptionalLong   | getAsLong()   |
| OptionalDouble | getAsDouble() |

---

# Example: Average

```java
OptionalDouble avg =
    IntStream.of(1,2,3,4)
             .average();
```

Retrieve:

```java
avg.getAsDouble();
```

Output:

```text
2.5
```

---

# 11. When to Use Parallel Streams?

Decision Flowchart

```text
Large Dataset?
     │
 ┌───┴───┐
 │       │
No      Yes
 │       │
 ▼       ▼

Use   CPU Intensive?
Seq       │
       ┌──┴──┐
       │     │
      No    Yes
       │     │
       ▼     ▼

Sequential
          Stateless?
              │
         ┌────┴────┐
         │         │
        No        Yes
         │         │
         ▼         ▼

     Sequential  Parallel
```

---

# Best Practices

✔ Large datasets

✔ CPU-intensive tasks

✔ Stateless operations

✔ Arrays and ArrayList

✔ Immutable data

✔ Collectors instead of shared variables

---

# Avoid Parallel Streams When

❌ Small datasets

❌ Database operations

❌ REST API calls

❌ LinkedList

❌ sorted()

❌ distinct()

❌ Shared mutable state

❌ Order must be preserved

---

# Quick Revision Sheet

```text
parallelStream()
    -> Multiple Threads

forEach()
    -> Unordered

forEachOrdered()
    -> Ordered but slower

ForkJoinPool
    -> Common Pool

Spliterator
    -> Split + Traverse

Stateless
    -> map(), filter()

Stateful
    -> sorted(), distinct()

Best Collection
    -> ArrayList

Worst Collection
    -> LinkedList

Race Condition
    -> Shared mutable state

Primitive Optionals
    -> OptionalInt
       OptionalLong
       OptionalDouble
```

---

# Interview One-Liner

"Parallel Streams use the Fork-Join Framework and Spliterator to divide work across multiple CPU cores. They provide performance benefits for large, CPU-intensive, stateless operations but can degrade performance when used with stateful operations, shared mutable state, or small datasets."
