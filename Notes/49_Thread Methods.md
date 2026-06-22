# Java Thread Control Methods & Thread Management

---

# 1. Thread Lifecycle Overview

Before understanding `sleep()`, `join()`, and `yield()`, it is important to know the lifecycle of a thread.

```text
                    start()
 NEW ---------------------------------> RUNNABLE
                                          |
                                          |
                                          | CPU Assigned
                                          v
                                      RUNNING
                                          |
          --------------------------------------------------
          |                    |                 |         |
          | sleep()            | join()          | wait()  |
          |                    |                 |         |
          v                    v                 v         |
      TIMED_WAITING         WAITING         WAITING        |
          |                    |                 |         |
          | timeout            | target thread   | notify()
          | completed          | finishes        |
          v                    v                 |
      RUNNABLE <---------------------------------
          |
          |
          v
     TERMINATED
```

### States Summary

| State         | Meaning                               |
| ------------- | ------------------------------------- |
| NEW           | Thread object created but not started |
| RUNNABLE      | Ready to run or running               |
| RUNNING       | CPU executing thread                  |
| WAITING       | Waiting indefinitely                  |
| TIMED_WAITING | Waiting for specific time             |
| TERMINATED    | Execution completed                   |

---

# 2. Thread.sleep()

## Definition

`Thread.sleep()` pauses the currently executing thread for a specified duration.

```java
Thread.sleep(milliseconds);
```

---

## Flow Diagram

```text
RUNNING
   |
   | sleep(3000)
   v
TIMED_WAITING
   |
   | 3 sec completed
   v
RUNNABLE
   |
   | Scheduler picks thread
   v
RUNNING
```

---

## Important Points

### 1. Current Thread Sleeps

```java
Thread.sleep(2000);
```

The thread executing this statement sleeps.

---

### 2. Lock is NOT Released

Many students incorrectly assume sleeping releases locks.

❌ Wrong

```java
synchronized(lock){
    Thread.sleep(5000);
}
```

Lock remains occupied.

Other threads:

```text
Thread-1 → sleeping with lock

Thread-2 → BLOCKED
```

---

### Visual Representation

```text
Thread-1
---------
Acquire Lock
      |
      v
sleep(5 sec)
      |
      v
Still owns lock

Thread-2
---------
Waiting for lock
(BLOCKED)
```

---

### 3. InterruptedException

Sleep throws checked exception.

```java
try{
    Thread.sleep(2000);
}
catch(InterruptedException e){
    e.printStackTrace();
}
```

---

## Easy Example

```java
public class SleepDemo {

    public static void main(String[] args)
            throws Exception {

        System.out.println("Start");

        Thread.sleep(3000);

        System.out.println("End");
    }
}
```

### Output

```text
Start

(3 second pause)

End
```

---

## Interview Questions

### Q1: Does sleep release lock?

**Answer:** No.

### Q2: Which state does sleep put thread into?

**Answer:** TIMED_WAITING.

### Q3: Is sleep static?

**Answer:** Yes.

```java
Thread.sleep(1000);
```

---

# 3. join()

## Definition

`join()` makes one thread wait until another thread completes.

---

## Real-Life Analogy

```text
Mother cooking food
Child waits

Child cannot eat
until cooking finishes
```

Thread waiting = Main Thread

Cooking thread = Worker Thread

---

## Flow Diagram

```text
Main Thread
     |
     | t1.join()
     v
WAITING
     |
     | t1 finishes
     v
RUNNABLE
     |
     v
RUNNING
```

---

## Example

```java
class MyThread extends Thread {

    public void run() {

        for(int i=1;i<=5;i++) {
            System.out.println(i);
        }
    }
}

public class JoinDemo {

    public static void main(String[] args)
            throws Exception {

        MyThread t1 = new MyThread();

        t1.start();

        t1.join();

        System.out.println("Main Finished");
    }
}
```

### Output

```text
1
2
3
4
5
Main Finished
```

---

## Without join()

```java
t1.start();

System.out.println("Main Finished");
```

Possible Output

```text
Main Finished
1
2
3
4
5
```

Execution order is unpredictable.

---

## Timed Join

```java
t1.join(3000);
```

Wait only 3 seconds.

---

## State Transition

### join()

```text
RUNNING
   |
 join()
   |
   v
WAITING
```

### join(3000)

```text
RUNNING
   |
join(3000)
   |
   v
TIMED_WAITING
```

---

## Interview Questions

### Q1: Why use join()?

To ensure execution order.

---

### Q2: Does join() release CPU?

Yes.

Calling thread waits.

---

### Q3: What state after join()?

WAITING.

---

# 4. Thread.yield()

## Definition

Yield tells scheduler:

> "I am willing to give my CPU time to another thread."

---

## Flow Diagram

```text
RUNNING
   |
yield()
   |
   v
RUNNABLE
   |
   | Scheduler Decision
   |
   +----> Same Thread Runs Again
   |
   +----> Another Thread Runs
```

---

## Important Point

Yield is only a suggestion.

OS may ignore it.

---

## Example

```java
class MyThread extends Thread {

    public void run() {

        for(int i=1;i<=5;i++) {

            System.out.println("Child");

            Thread.yield();
        }
    }
}
```

Output is unpredictable.

---

## Interview Questions

### Q1: Is yield guaranteed?

No.

### Q2: Which state after yield?

RUNNABLE.

### Q3: Is yield static?

Yes.

---

# 5. Interrupt Mechanism

## What is Interrupt?

Interrupt is a polite request asking a thread to stop.

It does NOT forcefully kill a thread.

---

## Internal Interrupt Flag

Every thread contains:

```text
interruptFlag = false
```

Initially:

```text
false
```

After:

```java
t1.interrupt();
```

```text
interruptFlag = true
```

---

## Visual Diagram

```text
Thread
   |
interrupt()
   |
   v

+----------------+
| Interrupt Flag |
+----------------+
|     true       |
+----------------+
```

---

# 6. Handling Interrupt Gracefully

## Example

```java
class Worker extends Thread {

    public void run() {

        while(!isInterrupted()) {

            System.out.println("Working...");
        }

        System.out.println("Stopped");
    }
}
```

---

## Execution

```java
Worker w = new Worker();

w.start();

w.interrupt();
```

Output

```text
Working...
Working...
Stopped
```

---

## Flow Diagram

```text
interruptFlag = false

       |
       v

while(true)
      |
      v

interrupt()

      |
      v

interruptFlag = true

      |
      v

Loop exits

      |
      v

Thread ends
```

---

# 7. InterruptedException

When thread is sleeping or waiting:

```java
Thread.sleep(5000);
```

If another thread executes:

```java
t1.interrupt();
```

Then:

```text
InterruptedException
```

is thrown immediately.

---

## Visual

```text
Thread Sleeping
      |
      |
interrupt()
      |
      v

InterruptedException

      |
      v

Wake Up Early
```

---

# 8. isInterrupted() vs interrupted()

---

## isInterrupted()

Checks flag only.

```java
t1.isInterrupted();
```

Flag remains unchanged.

---

### Example

```java
true
true
true
```

---

## Thread.interrupted()

Checks AND clears flag.

```java
Thread.interrupted();
```

---

### Example

```java
true
false
```

---

## Comparison Table

| Method          | Static | Clears Flag |
| --------------- | ------ | ----------- |
| isInterrupted() | No     | No          |
| interrupted()   | Yes    | Yes         |

---

# 9. isAlive()

## Definition

Checks whether thread has started and not yet terminated.

---

## Diagram

```text
NEW
 |
 | isAlive()
 |
 v

false


RUNNING
 |
 | isAlive()
 |
 v

true


TERMINATED
 |
 | isAlive()
 |
 v

false
```

---

## Example

```java
Thread t = new Thread();

System.out.println(t.isAlive());

t.start();

System.out.println(t.isAlive());
```

Output

```text
false
true
```

---

# 10. currentThread()

Returns currently executing thread.

---

## Example

```java
System.out.println(
    Thread.currentThread().getName()
);
```

Output

```text
main
```

---

## Use Cases

* Logging
* Debugging
* Monitoring

---

# 11. Thread Naming

Default names:

```text
Thread-0
Thread-1
Thread-2
```

---

## Custom Names

```java
Thread t1 = new Thread();

t1.setName("Payment-Service");
```

---

## Example

```java
System.out.println(
    Thread.currentThread().getName()
);
```

Output

```text
Payment-Service
```

---

## Why Important?

Production logs become readable.

Bad:

```text
Thread-17 failed
```

Good:

```text
Payment-Service failed
```

---

# 12. Thread Priorities

Range:

```text
1 → 10
```

---

## Constants

```java
Thread.MIN_PRIORITY   = 1
Thread.NORM_PRIORITY  = 5
Thread.MAX_PRIORITY   = 10
```

---

## Diagram

```text
Low Priority                    High Priority

1  2  3  4  5  6  7  8  9  10
^              ^
MIN          DEFAULT
```

---

## Example

```java
t1.setPriority(10);

t2.setPriority(1);
```

---

## Important

Priority is only a suggestion.

OS may ignore it.

---

## Interview Question

### Does higher priority guarantee execution first?

**No.**

Scheduler decides.

---

# 13. Daemon Threads

## Definition

Background service threads.

They support user threads.

---

## JVM Rule

```text
At least one User Thread alive
             ↓
        JVM alive

No User Thread alive
             ↓
Daemon Threads killed
             ↓
JVM exits
```

---

## Diagram

```text
Main Thread (User)
          |
          |
          v

Daemon Thread
(Garbage Collector)

          |

Main Ends
          |

Daemon Killed
          |

JVM Exit
```

---

## Example

```java
Thread t1 = new Thread(() -> {

    while(true){

        System.out.println("Daemon Running");
    }
});

t1.setDaemon(true);

t1.start();
```

When main finishes:

```text
Daemon thread terminated automatically
```

---

## Important Rules

### Correct

```java
t1.setDaemon(true);

t1.start();
```

### Wrong

```java
t1.start();

t1.setDaemon(true);
```

Throws:

```text
IllegalThreadStateException
```

---

## Common Daemon Threads

| Thread            | Daemon? |
| ----------------- | ------- |
| Garbage Collector | Yes     |
| Finalizer         | Yes     |
| Signal Dispatcher | Yes     |

---

# 14. Quick Interview Revision Table

| Method          | State           | Releases Lock? | Purpose                 |
| --------------- | --------------- | -------------- | ----------------------- |
| sleep()         | TIMED_WAITING   | No             | Pause execution         |
| join()          | WAITING         | N/A            | Wait for another thread |
| join(time)      | TIMED_WAITING   | N/A            | Wait for limited time   |
| yield()         | RUNNABLE        | N/A            | Suggest CPU switch      |
| interrupt()     | No state change | N/A            | Signal thread           |
| isAlive()       | N/A             | N/A            | Check active status     |
| currentThread() | N/A             | N/A            | Get current thread      |
| setDaemon()     | N/A             | N/A            | Make background thread  |
| setPriority()   | N/A             | N/A            | Suggest importance      |

---

# Ultimate Interview Questions

### 1. Difference between sleep() and wait()?

| sleep()               | wait()                |
| --------------------- | --------------------- |
| Thread class          | Object class          |
| Does not release lock | Releases lock         |
| TIMED_WAITING         | WAITING/TIMED_WAITING |

---

### 2. Difference between sleep() and join()?

| sleep()              | join()                  |
| -------------------- | ----------------------- |
| Pause current thread | Wait for another thread |
| Time-based           | Thread-completion based |
| TIMED_WAITING        | WAITING                 |

---

### 3. Difference between isInterrupted() and interrupted()?

| isInterrupted()    | interrupted() |
| ------------------ | ------------- |
| Doesn't clear flag | Clears flag   |
| Instance method    | Static method |

---

### 4. Can daemon thread keep JVM alive?

No.

Only User Threads keep JVM alive.

---

### 5. Does interrupt() stop thread immediately?

No.

It only sets the interrupt flag or causes `InterruptedException` if the thread is waiting/sleeping.

---

# One-Line Memory Tricks

```text
sleep()      → Pause me
join()       → Wait for him
yield()      → You go first
interrupt()  → Please stop
isAlive()    → Are you alive?
daemon()     → Background worker
priority()   → Importance hint
currentThread() → Who am I?
```
