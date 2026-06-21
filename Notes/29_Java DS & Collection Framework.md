# Java Data Structures & Collections Framework

---

# 1. Big Picture: Why Do We Need Data Structures?

In programming, everything revolves around **Data**.

The real question is:

> How should data be stored so that operations on it become efficient?

Operations include:

* Insert
* Delete
* Search
* Update
* Sort
* Traverse

This leads to:

```text
            DATA
              │
              ▼
     Store Efficiently
              │
              ▼
      DATA STRUCTURE
              │
              ▼
   Fast Queries & Operations
```

---

# What is a Data Structure?

A Data Structure is a way of organizing and storing data so that operations can be performed efficiently.

Example:

Suppose we store student roll numbers.

```java
10 20 30 40 50
```

Questions:

* Find 40
* Insert 60
* Delete 20

The efficiency depends on how data is stored.

---

# Trade-Off Concept (Most Asked Interview Question)

There is NO perfect data structure.

Every data structure sacrifices one thing to improve another.

Example:

| Data Structure | Search   | Insert      |
| -------------- | -------- | ----------- |
| Array          | O(n)     | O(1) at end |
| Sorted Array   | O(log n) | O(n)        |
| Linked List    | O(n)     | O(1)        |
| HashSet        | O(1)     | O(1)        |

Interview Answer:

> Choosing a Data Structure is about balancing trade-offs between insertion, deletion, searching, memory usage, and ordering requirements.

---

# 2. Arrays

## What is an Array?

An array stores elements in contiguous memory locations.

```text
Index : 0   1   2   3

Value : 10  20  30  40
```

Memory:

```text
+----+----+----+----+
|10  |20  |30  |40  |
+----+----+----+----+
```

---

## Advantages

### Fast Access

```java
arr[2]
```

Direct access.

Complexity:

```text
Access = O(1)
```

---

## Disadvantages

Fixed Size

```java
int arr[] = new int[5];
```

Cannot store 6th element.

```java
arr[5] = 100;
```

Produces:

```text
ArrayIndexOutOfBoundsException
```

---

# 3. Dynamic Array (ArrayList)

## Problem with Arrays

```text
Size fixed forever
```

Need:

```text
Grow when required
```

Solution:

```java
ArrayList
```

---

# Internal Working of ArrayList

Suppose:

```java
ArrayList<Integer> list = new ArrayList<>();
```

Initial Capacity:

```text
10
```

---

### Step 1

```text
[1][2][3][4][5][6][7][8][9][10]
```

Array becomes full.

---

### Step 2 (Resize)

Create new array:

```text
Capacity = Old × 1.5 (Java implementation)
```

Conceptually often taught as:

```text
Double Size
```

---

### Flowchart

```text
Add Element
     │
     ▼
Array Full ?
     │
 ┌───┴────┐
 │        │
No       Yes
 │        │
 ▼        ▼
Insert   Create Bigger Array
          │
          ▼
     Copy Elements
          │
          ▼
       Insert
```

---

# Internal Visualization

Before:

```text
Capacity = 5

+----+----+----+----+----+
|10  |20  |30  |40  |50  |
+----+----+----+----+----+
```

Add 60

After:

```text
New Capacity = 10

+----+----+----+----+----+----+----+----+----+----+
|10  |20  |30  |40  |50  |60  |    |    |    |    |
+----+----+----+----+----+----+----+----+----+----+
```

---

# Complexity

| Operation     | Complexity     |
| ------------- | -------------- |
| Get           | O(1)           |
| Add End       | O(1) Amortized |
| Insert Middle | O(n)           |
| Delete Middle | O(n)           |

---

# Interview Question

Why is ArrayList insertion O(1) if resizing occurs?

Answer:

Because resizing does NOT happen every time.

The resize cost gets distributed across many insertions.

This is called:

```text
Amortized Analysis
```

---

# 4. Linked List

## Core Idea

Array:

```text
Data stored together
```

Linked List:

```text
Data stored anywhere in memory
```

Nodes connect using references.

---

# Node Structure

```java
class Node{
    int data;
    Node next;
}
```

---

# Visualization

```text
Head
 │
 ▼

+----+-----+    +----+-----+    +----+------+
| 10 |  •──────►| 20 |  •──────►| 30 | NULL |
+----+-----+    +----+-----+    +----+------+
```

---

# Memory View

```text
Address 1000 -> Node(10)
Address 7000 -> Node(20)
Address 3000 -> Node(30)
```

Not contiguous.

---

# Insertion Example

Insert 15 between 10 and 20.

Before:

```text
10 → 20 → 30
```

After:

```text
10 → 15 → 20 → 30
```

Only links change.

---

### Flow

```text
Create Node(15)
       │
       ▼
15.next = 20
       │
       ▼
10.next = 15
```

Done.

No shifting required.

---

# Linked List Complexity

| Operation    | Complexity |
| ------------ | ---------- |
| Search       | O(n)       |
| Insert Head  | O(1)       |
| Delete Head  | O(1)       |
| Access Index | O(n)       |

---

# ArrayList vs LinkedList

| Feature        | ArrayList | LinkedList |
| -------------- | --------- | ---------- |
| Random Access  | O(1)      | O(n)       |
| Insert Middle  | O(n)      | O(1)*      |
| Memory         | Less      | More       |
| Cache Friendly | Yes       | No         |

*Provided node reference already exists.

---

# 5. Stack

## Principle

```text
LIFO
Last In First Out
```

Example:

Stack of plates.

---

# Diagram

```text
Push(10)

┌────┐
│10  │
└────┘
```

Push(20)

```text
┌────┐
│20  │ ← Top
├────┤
│10  │
└────┘
```

Pop()

```text
Remove 20
```

---

# Operations

```java
push()
pop()
peek()
isEmpty()
```

---

# Complexity

| Operation | Complexity |
| --------- | ---------- |
| Push      | O(1)       |
| Pop       | O(1)       |
| Peek      | O(1)       |

---

# Applications

* Undo operation
* Browser history
* Expression evaluation
* Function call stack

---

# 6. Queue

## Principle

```text
FIFO
First In First Out
```

Example:

Ticket counter.

---

# Diagram

```text
Front

10 → 20 → 30 → 40

              Rear
```

Remove:

```text
10 removed first
```

---

# Operations

```java
offer()
poll()
peek()
```

---

# Complexity

| Operation | Complexity |
| --------- | ---------- |
| Insert    | O(1)       |
| Delete    | O(1)       |

---

# Applications

* CPU Scheduling
* Printer Queue
* Task Processing
* Messaging Systems

---

# 7. Hashing (Foundation of Set and Map)

Most Important Interview Topic.

---

# Problem

Searching in array:

```text
O(n)
```

Need:

```text
O(1)
```

---

# Hash Function

Converts data into an integer.

```java
hashCode()
```

Example:

```java
"Aman".hashCode()
```

Output:

```text
63457821
```

---

# Index Calculation

```java
index = hashCode % arrayLength
```

Example:

```text
63457821 % 16

= 13
```

Store at bucket 13.

---

# Flowchart

```text
Element
   │
   ▼
hashCode()
   │
   ▼
Calculate Bucket Index
   │
   ▼
Store in Bucket
```

---

# Collision

Two elements produce same bucket.

Example:

```text
Rahul → Bucket 5

Rohit → Bucket 5
```

Collision occurs.

---

# Chaining

Java stores a Linked List (or Tree in newer versions) inside bucket.

```text
Bucket 5

Rahul
  │
  ▼
Rohit
  │
  ▼
Aman
```

---

# Complexity

Average:

```text
O(1)
```

Worst:

```text
O(n)
```

---

# 8. Set

## Definition

Stores unique elements only.

Duplicates automatically rejected.

---

# Example

```java
Set<Integer> s = new HashSet<>();

s.add(10);
s.add(20);
s.add(10);
```

Result:

```text
10 20
```

---

# Internal Flow

```text
Add Element
      │
      ▼
Generate Hash
      │
      ▼
Bucket Found
      │
      ▼
Already Exists ?
      │
 ┌────┴────┐
 │         │
Yes       No
 │         │
 ▼         ▼
Ignore    Store
```

---

# Set Implementations

## HashSet

```text
Unordered
Fastest
```

Complexity:

```text
O(1)
```

---

## LinkedHashSet

```text
Maintains insertion order
```

Example:

```java
10 20 30
```

Output:

```text
10 20 30
```

---

## TreeSet

```text
Sorted order
```

Uses:

```text
Red Black Tree
```

Output:

```text
10 20 30
```

Complexity:

```text
O(log n)
```

---

# 9. Map

## Definition

Stores:

```text
Key → Value
```

---

# Example

```java
Map<String,Integer> map =
new HashMap<>();
```

```java
map.put("Aman",101);
map.put("Rahul",102);
```

---

# Diagram

```text
Aman  ─────► 101

Rahul ─────► 102

Rohit ─────► 103
```

---

# Internal Node

```java
class Node{
    K key;
    V value;
    Node next;
}
```

---

# Flow

```text
Key
 │
 ▼
Hash Function
 │
 ▼
Bucket Index
 │
 ▼
Store Key+Value Node
```

---

# Why Keys Must Be Unique?

Because key is used for searching.

```java
map.put("Aman",101);
map.put("Aman",999);
```

Result:

```text
Aman → 999
```

Old value overwritten.

---

# Map Implementations

## HashMap

```text
Fastest
No Order
```

Complexity:

```text
O(1)
```

---

## LinkedHashMap

```text
Maintains insertion order
```

---

## TreeMap

```text
Sorted by Key
```

Complexity:

```text
O(log n)
```

---

# 10. Java Collections Framework

Big Interview Topic.

---

# Hierarchy Diagram

```text
                    Iterable
                        │
                        ▼
                   Collection
                  /    |     \
                 /     |      \
                ▼      ▼       ▼
              List    Set    Queue
               │       │        │
     ┌─────────┘       │        └───────────┐
     ▼                 ▼                    ▼
 ArrayList         HashSet           PriorityQueue
 LinkedList        TreeSet           ArrayDeque
                  LinkedHashSet
```

---

# Why Interfaces?

Suppose:

```java
List<Integer> list =
new ArrayList<>();
```

Later:

```java
List<Integer> list =
new LinkedList<>();
```

No code changes required.

This is:

```text
Polymorphism
```

---

# Common Collection Methods

```java
add()
remove()
contains()
size()
clear()
isEmpty()
```

Available because they come from:

```text
Collection Interface
```

---

# Why Map is Separate?

Collections:

```text
Value Only
```

Example:

```java
10
20
30
```

Map:

```text
Key + Value
```

Example:

```java
Aman → 101
```

Different architecture.

Therefore:

```text
Map does NOT extend Collection
```

---

# Complete Complexity Cheat Sheet

| Structure  | Search   | Insert   | Delete   |
| ---------- | -------- | -------- | -------- |
| Array      | O(n)     | O(n)     | O(n)     |
| ArrayList  | O(n)     | O(1)*    | O(n)     |
| LinkedList | O(n)     | O(1)     | O(1)     |
| Stack      | O(n)     | O(1)     | O(1)     |
| Queue      | O(n)     | O(1)     | O(1)     |
| HashSet    | O(1)     | O(1)     | O(1)     |
| TreeSet    | O(log n) | O(log n) | O(log n) |
| HashMap    | O(1)     | O(1)     | O(1)     |
| TreeMap    | O(log n) | O(log n) | O(log n) |

* Amortized O(1)

---

# Interview Quick Revision

### ArrayList

* Dynamic Array
* Contiguous memory
* Fast random access
* Slow middle insertion

### LinkedList

* Nodes + References
* No shifting
* Slow random access

### Stack

* LIFO
* push(), pop(), peek()

### Queue

* FIFO
* offer(), poll(), peek()

### HashSet

* Unique elements
* Uses HashMap internally
* O(1)

### TreeSet

* Sorted Set
* Red Black Tree
* O(log n)

### HashMap

* Key-Value pair
* Unique keys
* O(1)

### TreeMap

* Sorted Keys
* O(log n)

### Collection Framework

* Iterable → Collection → List/Set/Queue
* Map is separate hierarchy

---

# Golden Interview Answer

> Data Structures are specialized ways of organizing data to optimize operations such as searching, insertion, deletion, and traversal. Java provides the Collections Framework which offers ready-made implementations like ArrayList, LinkedList, HashSet, TreeSet, HashMap, and TreeMap. The choice of data structure depends on the trade-off between performance, memory usage, ordering requirements, and access patterns.
