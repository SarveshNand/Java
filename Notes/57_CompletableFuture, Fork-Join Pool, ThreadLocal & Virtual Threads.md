# Java CompletableFuture, ForkJoinPool, ThreadLocal & Virtual Threads

---

# 19. Evolution of Future in Java

Before Java 8, asynchronous programming was mainly handled using:

```java
Future<T>
```

A `Future` represents the result of an asynchronous computation.

---

# Future Workflow

```text
Main Thread
     |
     V

Submit Task
     |
     V

Executor Service
     |
     V

Background Thread
     |
     V

Computes Result
     |
     V

Future Object
     |
     V

future.get()
```

---

# Three Ways to Submit Tasks

## 1. Submit Callable

Returns a result.

```java
Callable<Integer> task = () -> 100;

Future<Integer> future =
        executor.submit(task);

System.out.println(future.get());
```

Output:

```text
100
```

---

## 2. Submit Runnable

Runnable doesn't return anything.

```java
Runnable task = () ->
        System.out.println("Running");

Future<?> future =
        executor.submit(task);
```

```java
System.out.println(future.get());
```

Output:

```text
Running
null
```

---

### Why Return Future Then?

Even though result is null:

```java
future.isDone();
future.cancel(true);
```

can still be used.

Useful for:

* Completion Tracking
* Cancellation
* Monitoring

---

## 3. Submit Runnable With Result

```java
Runnable task =
        () -> System.out.println("Work Done");

Future<String> future =
        executor.submit(task, "SUCCESS");
```

```java
System.out.println(future.get());
```

Output:

```text
Work Done
SUCCESS
```

---

# Problems With Future

Although Future was revolutionary, it has serious limitations.

---

## Problem 1: Blocking

```java
Future<Integer> future =
        executor.submit(task);

Integer result = future.get();
```

Execution:

```text
Main Thread
     |
     V

future.get()
     |
     |
 Waiting...
 Waiting...
 Waiting...
     |
     V

Result Arrives
```

Main thread becomes blocked.

---

## Problem 2: No Chaining

Suppose:

```text
Task A → Task B → Task C
```

Future cannot naturally express:

```text
Get Result
Transform Result
Store Result
Send Email
```

Everything must be written manually.

---

## Problem 3: Complex Coordination

Combining multiple asynchronous tasks is difficult.

Example:

```text
Fetch User
Fetch Orders
Fetch Payments
Combine Results
```

Future doesn't provide elegant APIs.

---

# Solution: CompletableFuture

Introduced in:

```text
Java 8
```

It is:

```text
Future + Callback + Chaining
```

---

# CompletableFuture Benefits

✅ Non-blocking

✅ Chaining

✅ Combining Tasks

✅ Exception Handling

✅ Functional Style APIs

---

# Creating CompletableFuture

## supplyAsync()

Used when returning value.

```java
CompletableFuture<Integer> future =
        CompletableFuture.supplyAsync(() -> 10);
```

Returns:

```text
CompletableFuture<Integer>
```

---

## Flow

```text
supplyAsync()
      |
      V

Background Thread
      |
      V

Returns Result
      |
      V

CompletableFuture
```

---

## runAsync()

Used when no value is returned.

```java
CompletableFuture<Void> future =
        CompletableFuture.runAsync(() ->
                System.out.println("Running"));
```

Equivalent to Runnable.

---

# CompletableFuture Chaining

The biggest advantage.

---

# thenApply()

Transforms output.

```java
CompletableFuture<Integer> future =
    CompletableFuture
        .supplyAsync(() -> 10)
        .thenApply(x -> x * 2);
```

Flow:

```text
10
 |
 V

x * 2

 |
 V

20
```

Result:

```text
20
```

---

# Multiple thenApply()

```java
CompletableFuture<Integer> future =
    CompletableFuture
        .supplyAsync(() -> 10)
        .thenApply(x -> x * 2)
        .thenApply(x -> x + 5)
        .thenApply(x -> x * 3);
```

Flow:

```text
10
 |
 V

20
 |
 V

25
 |
 V

75
```

---

# thenAccept()

Consumes result.

Returns:

```text
CompletableFuture<Void>
```

Example:

```java
CompletableFuture
        .supplyAsync(() -> 100)
        .thenAccept(System.out::println);
```

Output:

```text
100
```

---

# Flow

```text
Generate Result
       |
       V

thenAccept()
       |
       V

Print Result
```

No new value is produced.

---

# thenRun()

Runs after completion.

Ignores result.

```java
CompletableFuture
        .supplyAsync(() -> 100)
        .thenRun(() ->
            System.out.println("Finished"));
```

Output:

```text
Finished
```

---

# Difference

| Method     | Receives Result? | Returns Value? |
| ---------- | ---------------- | -------------- |
| thenApply  | Yes              | Yes            |
| thenAccept | Yes              | No             |
| thenRun    | No               | No             |

---

# Combining Multiple Futures

Suppose:

```text
Future A = User Data

Future B = Order Data
```

Need:

```text
User + Orders
```

---

# thenCombine()

```java
CompletableFuture<String> user =
    CompletableFuture
            .supplyAsync(() -> "John");

CompletableFuture<String> order =
    CompletableFuture
            .supplyAsync(() -> "Laptop");

CompletableFuture<String> result =
    user.thenCombine(
            order,
            (u, o) -> u + " ordered " + o
    );
```

Output:

```text
John ordered Laptop
```

---

# Visual Diagram

```text
          User Future
               |
               V

            John

               \
                \
                 \

                 thenCombine
                      |
                      V

                 Final Result

                      ^
                     /
                    /

               Laptop
                    |
                    V

              Order Future
```

---

# CompletableFuture Pipeline

```java
CompletableFuture
    .supplyAsync(() -> 10)
    .thenApply(x -> x * 2)
    .thenApply(x -> x + 5)
    .thenAccept(System.out::println);
```

Visual:

```text
Task-1
  |
  V

10

  |
  V

20

  |
  V

25

  |
  V

Print
```

No blocking involved.

---

# 20. ForkJoinPool

Internal engine behind many CompletableFuture operations.

Designed for:

```text
Parallel Processing
Divide and Conquer
```

---

# Core Idea

Large problem:

```text
100000 Records
```

Split into:

```text
50000
50000
```

Split again:

```text
25000
25000
25000
25000
```

Continue recursively.

This is called:

## Fork

---

After all subtasks finish:

```text
Merge Results
```

This is called:

## Join

---

# Fork-Join Diagram

```text
                Task
                  |
                  V

          +---------------+
          | 100000 Items  |
          +---------------+

             /       \

            /         \

       50000         50000

        / \           / \

   25000 25000   25000 25000

        \   \     /   /

         \   \   /   /

           Merge Results
```

---

# Work-Stealing Algorithm

Traditional Thread Pool:

```text
Worker-1 -> Busy
Worker-2 -> Idle
Worker-3 -> Idle
```

Idle threads remain unused.

---

ForkJoinPool Solution:

```text
Worker-1 Queue
[T1 T2 T3 T4 T5]

Worker-2 Queue
[]

Worker-3 Queue
[]
```

Worker-2 steals:

```text
T5
```

Worker-3 steals:

```text
T4
```

---

# Visual

```text
Worker-1
[T1 T2 T3 T4 T5]

       |
       |
  Steal T5
       |
       V

Worker-2
[T5]

  Steal T4
       |
       V

Worker-3
[T4]
```

Result:

```text
Better CPU Utilization
```

---

# RecursiveTask

Returns result.

```java
class SumTask
extends RecursiveTask<Integer>
{
}
```

Use when:

```text
Need Result
```

---

# RecursiveAction

Returns nothing.

```java
class PrintTask
extends RecursiveAction
{
}
```

Use when:

```text
Need Side Effects
```

---

# Interview Question

Why ForkJoinPool is fast?

Answer:

```text
Work-Stealing Algorithm
+
Parallel Divide-And-Conquer Processing
```

---

# 21. ThreadLocal

Provides thread-private storage.

---

# Problem Without ThreadLocal

Shared Variable:

```java
int count = 0;
```

Threads:

```text
Thread-1
Thread-2
Thread-3
```

All modify same variable.

Result:

```text
Race Conditions
```

---

# ThreadLocal Solution

Each thread gets:

```text
Own Private Copy
```

Diagram:

```text
Thread-1 -> count = 10

Thread-2 -> count = 20

Thread-3 -> count = 30
```

No sharing.

---

# Visual Representation

```text
                 Heap

           ThreadLocal Object
                    |
    ---------------------------------
    |               |               |
    V               V               V

Thread-1       Thread-2       Thread-3

count=10       count=20       count=30
```

---

# Example

```java
ThreadLocal<String> user =
        new ThreadLocal<>();

user.set("John");

System.out.println(user.get());
```

Output:

```text
John
```

---

# Multi-thread Example

```java
ThreadLocal<String> user =
        new ThreadLocal<>();

Runnable task = () -> {

    user.set(
        Thread.currentThread().getName());

    System.out.println(user.get());
};
```

Output:

```text
Thread-1
Thread-2
Thread-3
```

Each thread sees only its own value.

---

# Common Use Cases

## Request Context

```text
User ID
Session ID
Transaction ID
```

---

## Logging

```text
Correlation ID
Trace ID
```

---

## Database Transactions

```text
Connection Per Thread
```

---

# Important Interview Point

Always clean up.

```java
threadLocal.remove();
```

Otherwise:

```text
Memory Leak Risk
```

Especially in thread pools.

---

# 22. Virtual Threads

Introduced by:

```text
Project Loom
Java 21
```

---

# Traditional Threads (Platform Threads)

Mapping:

```text
1 Java Thread
      |
      V
1 OS Thread
```

Called:

```text
1 : 1 Mapping
```

---

# Problem

Each thread:

```text
~1 MB Memory
```

Suppose:

```text
100,000 Threads
```

Need:

```text
100 GB Memory
```

Impossible.

---

# Virtual Threads Solution

Mapping:

```text
100000 Virtual Threads
           |
           V

Few OS Threads
```

Called:

```text
Many : Few Mapping
```

---

# Architecture

```text
Virtual Thread
Virtual Thread
Virtual Thread
Virtual Thread
Virtual Thread
       |
       V

 JVM Scheduler
       |
       V

Platform Threads
(OS Threads)
```

---

# Memory Comparison

| Type            | Memory |
| --------------- | ------ |
| Platform Thread | ~1 MB  |
| Virtual Thread  | Few KB |

---

# Blocking Problem

Traditional Thread:

```text
Thread
   |
Database Call
   |
Waiting...
Waiting...
Waiting...
```

OS thread wasted.

---

# Virtual Thread Magic

When waiting:

```text
Virtual Thread
       |
       V

Detached From OS Thread
```

OS thread immediately executes another task.

---

# Diagram

```text
Virtual Thread-1
      |
      V

Waiting For DB

      |
      V

Detached

      |
      V

OS Thread Free
      |
      V

Runs Virtual Thread-2
```

---

# Traditional Thread Flow

```text
DB Request
     |
     V

OS Thread BLOCKED
     |
     V

CPU Wasted
```

---

# Virtual Thread Flow

```text
DB Request
     |
     V

Virtual Thread Suspended
     |
     V

OS Thread Reused
```

---

# Creating Virtual Thread

## Method 1

```java
Thread.startVirtualThread(() -> {
    System.out.println("Hello");
});
```

---

## Method 2

```java
try (ExecutorService executor =
     Executors.newVirtualThreadPerTaskExecutor()) {

    executor.submit(task);
}
```

---

# When To Use Virtual Threads

Best For:

✅ Database Calls

✅ REST APIs

✅ File I/O

✅ Network Calls

✅ Microservices

---

# When Not To Use

❌ Heavy CPU Computation

For CPU-bound tasks:

```text
ForkJoinPool
Parallel Streams
```

are often better choices.

---

# Traditional vs Virtual Threads

| Feature       | Platform Thread  | Virtual Thread     |
| ------------- | ---------------- | ------------------ |
| Managed By    | OS               | JVM                |
| Memory Cost   | High             | Very Low           |
| Creation Cost | Expensive        | Cheap              |
| Scalability   | Thousands        | Millions           |
| Blocking      | Blocks OS Thread | Releases OS Thread |
| Best For      | CPU Tasks        | I/O Tasks          |

---

# Most Asked Interview Questions

## Q1: Why CompletableFuture over Future?

Answer:

```text
Future is blocking and lacks chaining.

CompletableFuture provides:
- Non-blocking execution
- Chaining
- Combining tasks
- Better error handling
```

---

## Q2: Difference Between thenApply and thenAccept?

```text
thenApply  -> Transform result

thenAccept -> Consume result
```

---

## Q3: What powers CompletableFuture?

```text
ForkJoinPool.commonPool()
```

(default behavior)

---

## Q4: What is Work-Stealing?

Idle worker threads steal tasks from busy worker queues to improve CPU utilization.

---

## Q5: Why ThreadLocal?

To provide thread-private storage without synchronization.

---

## Q6: Why remove() in ThreadLocal?

To avoid memory leaks, especially when using thread pools.

---

## Q7: Why are Virtual Threads revolutionary?

Because millions of concurrent tasks can be created without requiring millions of OS threads.

---

# One-Line Summary

> CompletableFuture enables non-blocking asynchronous pipelines, ForkJoinPool provides efficient parallel execution through work-stealing, ThreadLocal gives thread-private memory, and Virtual Threads bring lightweight, massively scalable concurrency by decoupling Java threads from OS threads.
