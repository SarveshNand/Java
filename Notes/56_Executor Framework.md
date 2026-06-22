# Java Executor Framework

---

# 1. Why `new Thread()` is a Bad Approach?

Before Java 5, developers manually created threads:

```java
new Thread(() -> {
    System.out.println("Task Running");
}).start();
```

Although this works, it becomes problematic in real-world applications.

---

## Problem 1: High Memory Consumption

Each Java thread requires:

* Stack Memory (typically 512KB - 1MB)
* Program Counter Register
* Native OS Thread Resources

### Example

```text
1 Thread  ≈ 1 MB

1000 Threads ≈ 1000 MB (1 GB)
```

Even before executing actual business logic, huge memory is consumed.

---

## Problem 2: Thread Creation is Expensive

Creating a thread is not just object creation.

```text
Java Code
    ↓
JVM
    ↓
Operating System
    ↓
Native Thread Creation
```

The JVM must make a **System Call** to the OS.

System Calls are relatively expensive operations.

---

## Problem 3: Context Switching

Suppose:

```text
CPU Cores = 4
Threads   = 500
```

Only 4 threads can execute simultaneously.

The OS continuously pauses and resumes threads.

```text
Thread-1 → Pause
Thread-2 → Run
Thread-2 → Pause
Thread-100 → Run
Thread-100 → Pause
```

This switching process is called:

## Context Switching

Too much switching causes:

## Thrashing

```text
CPU Time

Actual Work        ████
Context Switching  ███████████████
```

The CPU spends more time managing threads than doing work.

---

## Problem 4: One-Time Use

```java
Thread t = new Thread(task);
t.start();
```

Thread lifecycle:

```text
Created
   ↓
Started
   ↓
Executed Task
   ↓
Destroyed
```

After completing one task, the thread dies.

For every new task:

```text
Create Thread
Execute
Destroy Thread

Create Thread
Execute
Destroy Thread

Create Thread
Execute
Destroy Thread
```

Huge waste of resources.

---

# 2. Executor Framework Overview

Introduced in:

```text
Java 5
java.util.concurrent
```

The framework separates:

```text
WHAT to do  → Task
HOW to do it → Executor
```

Instead of managing threads manually:

```java
ExecutorService executor =
        Executors.newFixedThreadPool(3);

executor.submit(task);
```

The framework manages:

* Thread creation
* Thread reuse
* Scheduling
* Queue management
* Shutdown

---

# 3. Core Concept: Thread Pool

A Thread Pool is a collection of reusable worker threads.

---

## Thread Pool Architecture

```text
                Submit Task
                     |
                     V

           +----------------+
           |   Task Queue   |
           +----------------+
             |    |     |
             V    V     V

      +---------+ +---------+
      |Worker-1 | |Worker-2 |
      +---------+ +---------+
            |         |
            V         V

         Execute   Execute

            |
            V

      Return to Pool
```

---

## Execution Flow

### Step 1

Application submits task.

```java
executor.submit(task);
```

---

### Step 2

Executor checks:

```text
Is any worker thread free?
```

---

### Step 3

If YES

```text
Worker picks task
        ↓
Executes task
        ↓
Returns to pool
```

---

### Step 4

If NO

Task goes to queue.

```text
Task-1
Task-2
Task-3
Task-4
```

Workers take tasks one by one.

---

# 4. Executor Framework Hierarchy

```text
                    Executor
                        |
                        |
                        V
               ExecutorService
                        |
                        |
        +---------------+----------------+
        |                                |
        V                                V

 ThreadPoolExecutor     ScheduledExecutorService
        |
        V
ScheduledThreadPoolExecutor
```

---

# 5. Executor Interface

Top-level interface.

```java
public interface Executor {
    void execute(Runnable command);
}
```

Example:

```java
Executor executor =
        Executors.newFixedThreadPool(2);

executor.execute(() ->
        System.out.println("Hello"));
```

---

# 6. ExecutorService Interface

Adds advanced features.

```java
ExecutorService executor =
        Executors.newFixedThreadPool(5);
```

Important methods:

```java
submit()
shutdown()
shutdownNow()
invokeAll()
invokeAny()
```

---

# 7. Runnable vs Callable

## Runnable

```java
Runnable task = () -> {
    System.out.println("Running");
};
```

Limitations:

❌ Cannot return value

❌ Cannot throw checked exceptions

---

## Callable

```java
Callable<Integer> task = () -> {
    return 100;
};
```

Advantages:

✅ Returns value

✅ Throws checked exceptions

---

## Comparison

| Feature           | Runnable | Callable |
| ----------------- | -------- | -------- |
| Return Value      | ❌ No     | ✅ Yes    |
| Checked Exception | ❌ No     | ✅ Yes    |
| Method            | run()    | call()   |

---

# 8. Future

When Callable is submitted:

```java
Future<Integer> future =
        executor.submit(task);
```

Future represents:

```text
A value that will be available later
```

---

## Future Flow

```text
Submit Callable
        |
        V

Future Object Returned
        |
        |
        V

Task Running in Background
        |
        V

Result Ready
        |
        V

future.get()
```

---

## Example

```java
Callable<Integer> task = () -> {
    Thread.sleep(3000);
    return 50;
};

Future<Integer> future =
        executor.submit(task);

System.out.println("Doing other work");

Integer result = future.get();

System.out.println(result);
```

Output:

```text
Doing other work
(wait 3 sec)
50
```

---

## Important Interview Point

```java
future.get();
```

is a

# Blocking Call

```text
Current Thread
       |
       V

Waiting...
Waiting...
Waiting...
```

until result becomes available.

---

# 9. Fixed Thread Pool

```java
ExecutorService executor =
    Executors.newFixedThreadPool(3);
```

Creates exactly 3 worker threads.

---

## Diagram

```text
Pool Size = 3

Worker-1
Worker-2
Worker-3

Task-4 -> Queue
Task-5 -> Queue
Task-6 -> Queue
```

---

## Best Use Case

```text
Database Requests
REST API Processing
Business Logic Tasks
```

---

## Interview Warning

Uses:

```text
LinkedBlockingQueue
```

which is effectively unbounded.

Too many tasks may cause:

```text
Memory Issues
```

---

# 10. Cached Thread Pool

```java
ExecutorService executor =
    Executors.newCachedThreadPool();
```

Characteristics:

```text
Queue Size = 0
```

Creates new threads as needed.

---

## Flow

```text
Task-1 → Thread-1

Task-2 → Thread-2

Task-3 → Thread-3
```

No waiting queue.

---

## Idle Threads

```text
Idle > 60 Seconds
        ↓
Thread Destroyed
```

---

## Best Use Case

```text
Short-lived Tasks
Many Independent Requests
```

---

# 11. Single Thread Executor

```java
ExecutorService executor =
    Executors.newSingleThreadExecutor();
```

Only one worker thread.

---

## Diagram

```text
Task-1
Task-2
Task-3
Task-4
```

Execution:

```text
Task-1
   ↓
Task-2
   ↓
Task-3
   ↓
Task-4
```

Sequential execution guaranteed.

---

## Use Cases

* Logging
* File Writing
* Order Processing

Where ordering matters.

---

# 12. Scheduled Thread Pool

Used for delayed and periodic tasks.

```java
ScheduledExecutorService scheduler =
        Executors.newScheduledThreadPool(2);
```

---

## Delayed Task

```java
scheduler.schedule(
    task,
    5,
    TimeUnit.SECONDS
);
```

```text
Wait 5 Seconds
      ↓
Execute Task
```

---

## Repeated Task

```java
scheduler.scheduleAtFixedRate(
        task,
        0,
        2,
        TimeUnit.SECONDS
);
```

Execution:

```text
0 sec → Run
2 sec → Run
4 sec → Run
6 sec → Run
```

---

# 13. ThreadPoolExecutor Deep Dive

Real implementation behind most executors.

---

## Constructor

```java
ThreadPoolExecutor(
    corePoolSize,
    maximumPoolSize,
    keepAliveTime,
    unit,
    workQueue
)
```

---

# Parameter 1: Core Pool Size

Minimum threads always alive.

```java
corePoolSize = 2
```

```text
Worker-1
Worker-2
```

remain alive even if idle.

---

# Parameter 2: Maximum Pool Size

Maximum threads allowed.

```java
maximumPoolSize = 5
```

Pool can never exceed:

```text
5 Threads
```

---

# Parameter 3: Keep Alive Time

Extra threads die after inactivity.

```java
keepAliveTime = 60 seconds
```

Applies to:

```text
Threads > Core Pool Size
```

---

# Parameter 4: Work Queue

Stores waiting tasks.

Examples:

```java
ArrayBlockingQueue<>(100)
```

Fixed size.

```java
LinkedBlockingQueue<>()
```

Potentially unbounded.

---

# 14. Complete Task Processing Algorithm

Suppose:

```java
Core = 2
Max = 4
Queue = 2
```

---

## Task 1

```text
Threads = 0 < Core

Create Thread-1
```

---

## Task 2

```text
Threads = 1 < Core

Create Thread-2
```

---

## Task 3

```text
Core Full

Add to Queue
```

Queue:

```text
[T3]
```

---

## Task 4

Queue:

```text
[T3 T4]
```

Queue Full.

---

## Task 5

```text
Queue Full
Threads = 2 < Max
```

Create:

```text
Thread-3
```

---

## Task 6

Create:

```text
Thread-4
```

---

## Task 7

```text
Queue Full
Threads = Max
```

Result:

```text
REJECT TASK
```

---

# Visual Flowchart

```text
            New Task
                |
                V

    Threads < Core Pool Size ?
            /      \
          Yes       No
          /          \
 Create Thread     Queue Task
                       |
                       V

              Queue Full ?
                /    \
              No      Yes
              |        |
           Wait     Threads < Max ?
                        /      \
                      Yes      No
                      |         |
               Create Thread  Reject
```

---

# 15. Rejection Policies

When queue and thread limits are reached.

---

## AbortPolicy (Default)

```java
new ThreadPoolExecutor.AbortPolicy()
```

Behavior:

```text
Throws RejectedExecutionException
```

---

## DiscardPolicy

```java
new ThreadPoolExecutor.DiscardPolicy()
```

Behavior:

```text
New Task Deleted
No Exception
```

---

## DiscardOldestPolicy

```java
new ThreadPoolExecutor.DiscardOldestPolicy()
```

Behavior:

```text
Remove Oldest Task
Add New Task
```

Queue:

```text
[T1 T2 T3]
```

New Task:

```text
T4
```

Result:

```text
[T2 T3 T4]
```

---

# 16. Graceful Shutdown

Very important interview topic.

---

## shutdown()

```java
executor.shutdown();
```

Behavior:

```text
Accept New Tasks?  NO
Running Tasks?     Continue
Queued Tasks?      Continue
```

Diagram:

```text
Current Tasks
      ↓
Finish Normally
      ↓
Executor Stops
```

---

## shutdownNow()

```java
executor.shutdownNow();
```

Behavior:

```text
Accept New Tasks? NO
Running Tasks? Attempt Interrupt
Queued Tasks? Discard
```

Diagram:

```text
Running Tasks
      ↓
Interrupt Signal
      ↓
Stop If Possible
```

---

# 17. Best Practices

### ✔ Use Fixed Thread Pool for most applications

```java
Executors.newFixedThreadPool(
    Runtime.getRuntime()
           .availableProcessors()
);
```

---

### ✔ Always shutdown executor

```java
executor.shutdown();
```

---

### ✔ Use Callable when result is needed

```java
Callable<String>
Future<String>
```

---

### ✔ Use ScheduledExecutorService for timers

Avoid:

```java
Thread.sleep()
```

for scheduling repeated tasks.

---

### ✔ Prefer ThreadPoolExecutor for production tuning

Allows:

* Core Pool Size
* Max Pool Size
* Queue Size
* Rejection Policies

---

# 18. Most Asked Interview Questions

### Q1: Why use Executor Framework?

**Answer:**
It reuses threads through thread pools, reducing thread creation cost, memory usage, and context switching overhead.

---

### Q2: Difference between Runnable and Callable?

```text
Runnable → No return value

Callable → Returns value and throws checked exceptions
```

---

### Q3: What is Future?

A placeholder representing an asynchronous computation result.

---

### Q4: Is `Future.get()` blocking?

✅ Yes.

It blocks until the result becomes available.

---

### Q5: Difference between execute() and submit()?

| execute()       | submit()            |
| --------------- | ------------------- |
| Runnable only   | Runnable + Callable |
| No Future       | Returns Future      |
| Fire-and-forget | Track result        |

---

### Q6: Difference between shutdown() and shutdownNow()?

| shutdown()             | shutdownNow()         |
| ---------------------- | --------------------- |
| Graceful               | Immediate Attempt     |
| Completes queued tasks | Discards queued tasks |
| No interruption        | Sends interruption    |

---

### Q7: What happens when queue is full?

```text
1. Create extra thread (if below max)

OR

2. Apply Rejection Policy
```

---

# One-Line Summary

> The Executor Framework is Java's concurrency management system that improves performance and scalability by reusing worker threads through thread pools, managing task execution, scheduling, queuing, and lifecycle handling efficiently.
