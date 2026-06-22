# Java Queue, Deque, ArrayDeque & PriorityQueue

---

# 1. What is a Queue?

A **Queue** is a linear data structure that follows:

```text
FIFO
(First In First Out)
```

Meaning:

```text
First Entered
       ↓
First Removed
```

---

# Real Life Examples

## Ticket Counter

```text
A → B → C → D
```

A enters first.

Service order:

```text
A → B → C → D
```

---

## Printer Queue

```text
Document1
Document2
Document3
```

Printed in same order.

---

# Queue Visualization

```text
Front                    Rear

┌─────┬─────┬─────┬─────┐
│ 10  │ 20  │ 30  │ 40  │
└─────┴─────┴─────┴─────┘

Remove Here      Add Here
```

---

# Core Operations

| Operation | Meaning     |
| --------- | ----------- |
| Enqueue   | Insert      |
| Dequeue   | Remove      |
| Peek      | View Front  |
| isEmpty   | Check Empty |

---

# Queue Rule

```text
Insert → Rear

Delete → Front
```

---

# Example

```java
Queue<Integer> q =
    new LinkedList<>();

q.offer(10);
q.offer(20);
q.offer(30);
```

Memory:

```text
Front

10 → 20 → 30

            Rear
```

---

# Removal

```java
q.poll();
```

Removes:

```text
10
```

Remaining:

```text
20 → 30
```

---

# Complexity

Ideal Queue Operations:

| Operation | Complexity |
| --------- | ---------- |
| Insert    | O(1)       |
| Remove    | O(1)       |
| Peek      | O(1)       |

---

# 2. Queue Implementations

Two major ways:

```text
Queue

├── Array Based
│
└── Linked List Based
```

---

# 3. Array Based Queue

Uses:

```text
Array
+
Front Pointer
+
Rear Pointer
```

---

# Initial State

```text
front = -1
rear  = -1
```

---

# Insert 10

```text
front = 0
rear  = 0

┌─────┐
│ 10  │
└─────┘
```

---

# Insert 20

```text
front = 0
rear  = 1

┌─────┬─────┐
│ 10  │ 20  │
└─────┴─────┘
```

---

# Problem

After removals:

```text
Remove 10
Remove 20
```

Pointers:

```text
front = 2
rear  = 4
```

Memory at beginning becomes unused.

---

# Wastage

```text
┌───┬───┬───┬───┬───┐
│ X │ X │30 │40 │50 │
└───┴───┴───┴───┴───┘
```

Empty spaces wasted.

---

# Solution: Circular Queue

---

# Circular Concept

Instead of:

```text
0 → 1 → 2 → 3 → 4
```

Use:

```text
      ┌───────┐
      ▼       │

0 → 1 → 2 → 3 → 4

▲               │
└───────────────┘
```

---

# Formula

```java
rear = (rear + 1) % capacity;
```

---

# Example

Capacity:

```text
5
```

Current:

```text
rear = 4
```

Next:

```java
(4 + 1) % 5
```

```text
= 0
```

Wraps around.

---

# Circular Queue Diagram

```text
          [0]
       /       \
    [4]         [1]
     |           |
    [3]         [2]
```

---

# Queue Full Condition

```text
(rear + 1) % capacity == front
```

---

# 4. Resizing in Array Queue

When array becomes full:

```text
Capacity = 16
```

Create larger array.

```text
Capacity = 24
or
Capacity = 32
```

---

# Process

```text
Old Array
     │
     ▼
Create Bigger Array
     │
     ▼
Copy Elements
     │
     ▼
Replace Reference
```

---

# Complexity

Resize:

```text
O(n)
```

Normal insert:

```text
O(1)
```

---

# 5. Linked List Based Queue

Uses:

```text
Node
+
Front Pointer
+
Rear Pointer
```

---

# Node Structure

```text
┌──────┐
│ Data │
├──────┤
│ Next │
└──────┘
```

---

# Queue Diagram

```text
Front
  │
  ▼

┌────┐     ┌────┐     ┌────┐
│ 10 │ ──► │ 20 │ ──► │ 30 │
└────┘     └────┘     └────┘

                       ▲
                       │
                      Rear
```

---

# Insertion

```java
rear.next = newNode;
rear = newNode;
```

---

# Removal

```java
front = front.next;
```

---

# Benefits

```text
✔ Dynamic Size

✔ No Resizing

✔ No Circular Logic
```

---

# Drawbacks

```text
Extra Memory

Node Allocation Cost
```

---

# 6. Queue Hierarchy

---

# Collection Framework Hierarchy

```text
Iterable
   │
   ▼
Collection
   │
   ▼
Queue
   │
   ▼
Deque
```

---

# Meaning

```text
Queue

Single Ended
```

```text
Deque

Double Ended
```

---

# Implementations

```text
Queue

├── LinkedList
├── PriorityQueue
└── ArrayDeque

Deque

├── ArrayDeque
└── LinkedList
```

---

# 7. What is Deque?

Deque means:

```text
Double Ended Queue
```

---

# Normal Queue

```text
Insert → Rear

Remove → Front
```

---

# Deque

```text
Insert → Front/Rear

Remove → Front/Rear
```

---

# Visualization

```text
Front

▼

┌────┬────┬────┬────┐
│10  │20  │30  │40  │
└────┴────┴────┴────┘

▲                    ▲

Front Operations
Rear Operations
```

---

# Deque Methods

| Front        | Rear        |
| ------------ | ----------- |
| addFirst()   | addLast()   |
| offerFirst() | offerLast() |
| pollFirst()  | pollLast()  |
| peekFirst()  | peekLast()  |

---

# Example

```java
Deque<Integer> dq =
    new ArrayDeque<>();

dq.offerFirst(20);
dq.offerFirst(10);
dq.offerLast(30);
```

Result:

```text
10 20 30
```

---

# 8. Safe vs Unsafe Methods

Interview Favorite

---

# Insertion

Unsafe:

```java
add()
```

Safe:

```java
offer()
```

---

# Removal

Unsafe:

```java
remove()
```

Safe:

```java
poll()
```

---

# Inspection

Unsafe:

```java
element()
```

Safe:

```java
peek()
```

---

# Why Safe?

Consider empty queue:

```java
Queue<Integer> q =
    new LinkedList<>();
```

---

# remove()

```java
q.remove();
```

Throws:

```text
NoSuchElementException
```

---

# poll()

```java
q.poll();
```

Returns:

```text
null
```

Program continues.

---

# Comparison Table

| Operation | Unsafe    | Safe    |
| --------- | --------- | ------- |
| Insert    | add()     | offer() |
| Remove    | remove()  | poll()  |
| Inspect   | element() | peek()  |

---

# Production Recommendation

Always prefer:

```text
offer()

poll()

peek()
```

---

# 9. Stack Using ArrayDeque

---

# Traditional Stack

```java
Stack<Integer> stack =
      new Stack<>();
```

Legacy class.

Avoid in modern Java.

---

# Recommended

```java
ArrayDeque<Integer> stack =
      new ArrayDeque<>();
```

---

# Why?

```text
✔ Faster

✔ No Synchronization Overhead

✔ Modern API
```

---

# Stack Rule

```text
LIFO

Last In First Out
```

---

# Example

```java
stack.push(10);
stack.push(20);
stack.push(30);
```

Memory:

```text
Top

30
20
10
```

---

# pop()

```java
stack.pop();
```

Removes:

```text
30
```

---

# Remaining

```text
20
10
```

---

# Internal Mapping

| Stack Method | Deque Method |
| ------------ | ------------ |
| push()       | offerFirst() |
| pop()        | pollFirst()  |
| peek()       | peekFirst()  |

---

# Flow

```text
push(10)

10

push(20)

20
10

push(30)

30
20
10

pop()

20
10
```

---

# 10. Priority Queue

Most important queue interview topic.

---

# Normal Queue

FIFO

```text
10 20 30

Output

10 20 30
```

---

# Priority Queue

Removes according to:

```text
Priority
```

Not insertion order.

---

# Example

```java
PriorityQueue<Integer> pq =
      new PriorityQueue<>();

pq.offer(30);
pq.offer(10);
pq.offer(20);
```

---

# Output

```java
pq.poll();
```

Returns:

```text
10
```

Smallest element.

---

# Why?

Default PriorityQueue is:

```text
Min Heap
```

---

# 11. Binary Heap

PriorityQueue uses:

```text
Binary Heap
```

Internally.

---

# Heap Type

Default:

```text
Min Heap
```

Rule:

```text
Parent ≤ Children
```

---

# Example

Insert:

```text
30
10
20
5
```

Heap:

```text
        5
      /   \
    10     20
   /
 30
```

---

# Root Always Contains

```text
Minimum Element
```

---

# 12. Heap Stored as Array

Interview Favorite

---

# Heap

```text
        10
       /  \
      20   30
     / \
   40  50
```

Stored:

```text
[10,20,30,40,50]
```

---

# Index Relationships

Parent index:

```text
i
```

Left Child:

```java
2*i + 1
```

Right Child:

```java
2*i + 2
```

---

# Example

Parent:

```text
Index 1
```

Value:

```text
20
```

Children:

```java
Left  = 2(1)+1 = 3

Right = 2(1)+2 = 4
```

Values:

```text
40 and 50
```

---

# Parent Formula

Given child:

```java
(child-1)/2
```

---

# 13. Offer Operation (Up Heapify)

Insert:

```text
10
20
30
```

Add:

```text
5
```

Temporary:

```text
      10
     /  \
   20   30
  /
 5
```

Violation.

---

# Up Heapify

Compare with parent.

```text
5 < 20
```

Swap.

---

```text
      10
     /  \
    5   30
   /
 20
```

Again:

```text
5 < 10
```

Swap.

---

Final:

```text
      5
     / \
   10  30
   /
 20
```

---

# Complexity

```text
O(log n)
```

---

# 14. Poll Operation (Down Heapify)

Remove root.

---

Before:

```text
      5
     / \
   10  30
   /
 20
```

---

Remove:

```text
5
```

---

Move last element:

```text
      20
     /  \
   10   30
```

---

Violation:

```text
20 > 10
```

Swap.

---

Final:

```text
      10
     /  \
   20   30
```

---

# Complexity

```text
O(log n)
```

---

# 15. Creating Max Heap

Default:

```java
PriorityQueue<Integer> pq =
    new PriorityQueue<>();
```

Min Heap.

---

# Max Heap

```java
PriorityQueue<Integer> pq =
    new PriorityQueue<>(
        (a,b)->b-a
    );
```

---

# Example

```java
pq.offer(10);
pq.offer(50);
pq.offer(20);
```

---

Output

```java
pq.poll();
```

Returns:

```text
50
```

Largest element.

---

# Memory Trick

```text
Default PQ

Smallest First

Min Heap

Comparator Reverse

Largest First

Max Heap
```

---

# 16. ArrayDeque vs LinkedList

Most Asked Interview Comparison

---

# Internal Structure

ArrayDeque

```text
Dynamic Circular Array
```

LinkedList

```text
Doubly Linked List
```

---

# Memory

ArrayDeque

```text
Only Data
```

LinkedList

```text
Data

Prev Pointer

Next Pointer
```

More memory.

---

# Cache Friendliness

ArrayDeque

```text
Excellent
```

Data stored together.

---

LinkedList

```text
Poor
```

Nodes scattered in RAM.

---

# Why Faster?

CPU loads nearby elements into cache.

Array storage benefits greatly.

---

# Null Values

ArrayDeque

```text
❌ Not Allowed
```

---

LinkedList

```text
✔ Allowed
```

---

# Comparison Table

| Feature          | ArrayDeque    | LinkedList         |
| ---------------- | ------------- | ------------------ |
| Structure        | Dynamic Array | Doubly Linked List |
| Memory           | Low           | High               |
| Cache Friendly   | Yes           | No                 |
| Null Allowed     | No            | Yes                |
| Queue Operations | O(1)          | O(1)               |
| Stack Operations | O(1)          | O(1)               |
| Recommended      | ✅ Yes         | ⚠️ Usually No      |

---

# Interview Cheat Sheet

```text
QUEUE

FIFO

Insert Rear

Delete Front

SAFE METHODS

offer()
poll()
peek()

DEQUE

Double Ended Queue

addFirst()
addLast()

ARRAYDEQUE

Best Queue
Best Stack

STACK

LIFO

push()
pop()
peek()

PRIORITYQUEUE

Uses Binary Heap

Default = Min Heap

offer() = O(log n)

poll() = O(log n)

HEAP FORMULAS

Left Child

2i+1

Right Child

2i+2

Parent

(i-1)/2

ARRAYDEQUE VS LINKEDLIST

ArrayDeque Preferred

Cache Friendly

Less Memory

Faster
```
