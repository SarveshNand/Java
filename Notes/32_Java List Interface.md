# Java List Interface

---

# 1. What is a List?

A **List** is an ordered collection that stores elements in a sequence.

Unlike Sets:

✅ Preserves insertion order

✅ Allows duplicates

✅ Supports index-based access

Think of a List like seats in a movie theater.

```text
Index →   0    1    2    3
         ┌──┬──┬──┬──┐
Values → │A │B │C │D │
         └──┴──┴──┴──┘
```

Every element has a position (index).

---

# 2. Complete Hierarchy

## Java 20 and Earlier

```text
Object
  │
  ▼
Iterable
  │
  ▼
Collection
  │
  ▼
List
```

---

## Java 21+

Java introduced SequencedCollection.

```text
Object
  │
  ▼
Iterable
  │
  ▼
Collection
  │
  ▼
SequencedCollection
  │
  ▼
List
```

---

# Why SequencedCollection?

Many collections have:

* First element
* Last element

Java finally standardized operations for them.

```java
getFirst()
getLast()

addFirst()
addLast()

removeFirst()
removeLast()
```

---

# 3. Implementations of List

```text
List
│
├── ArrayList
│
├── LinkedList
│
├── Vector
│
└── Stack
```

---

# Relationship Diagram

```text
                List
                  │
      ┌───────────┼───────────┐
      │           │           │
      ▼           ▼           ▼
 ArrayList   LinkedList    Vector
                                │
                                ▼
                              Stack
```

---

# Interview Question

## Does Stack implement List?

Answer:

No.

Stack extends Vector.

Vector implements List.

```text
Stack
  │
extends
  │
Vector
  │
implements
  │
List
```

---

# 4. Characteristics of List

## Property 1: Ordered

Insertion order maintained.

```java
List<Integer> list =
    List.of(10,20,30);
```

Output:

```text
10 20 30
```

Always same order.

---

## Property 2: Index Based

```java
list.get(1);
```

Output:

```text
20
```

---

## Property 3: Duplicates Allowed

```java
List<Integer> list =
    List.of(10,10,10);
```

Valid.

```text
[10,10,10]
```

---

# Memory Visualization

```text
Index

0 → Apple
1 → Banana
2 → Apple
3 → Mango
```

Duplicates are allowed.

---

# 5. List Methods Overview

```text
List Methods

                List
                  │
      ┌───────────┼───────────┐
      │           │           │
      ▼           ▼           ▼
 Position      Search     Sequenced
 Methods       Methods     Methods
```

---

# Position Based Methods

```java
get()
set()
add(index)
remove(index)
```

---

# Search Methods

```java
indexOf()
lastIndexOf()
contains()
```

---

# Java 21 Methods

```java
getFirst()
getLast()

addFirst()
addLast()

removeFirst()
removeLast()
```

---

# 6. get(index)

Fetches value at a position.

```java
List<String> list =
    List.of("A","B","C");

System.out.println(list.get(1));
```

Output

```text
B
```

---

# Visualization

```text
Index

0   1   2

A   B   C

get(1)

▼

B
```

---

# Complexity

| Structure  | Complexity |
| ---------- | ---------- |
| ArrayList  | O(1)       |
| LinkedList | O(n)       |

Important interview question.

---

# 7. set(index,value)

Replaces existing value.

```java
List<String> list =
    new ArrayList<>(List.of("A","B","C"));

list.set(1,"X");
```

Result

```text
[A,X,C]
```

---

# Flow

```text
Before

[A][B][C]

set(1,"X")

After

[A][X][C]
```

---

# Important

set()

does NOT shift elements.

It simply replaces.

---

# 8. add(index,element)

Inserts element.

```java
list.add(1,"X");
```

---

# Visualization

Before

```text
[A][B][C]
```

Insert at index 1

```text
[A][X][B][C]
```

---

# Internal Flow

```text
Shift Right

A B C

▼

A X B C
```

---

# Complexity

| Structure  | Complexity |
| ---------- | ---------- |
| ArrayList  | O(n)       |
| LinkedList | O(n)       |

---

# Interview Difference

## set()

Replace

```text
A B C

↓

A X C
```

---

## add(index)

Insert

```text
A B C

↓

A X B C
```

---

# 9. remove(index)

Deletes element.

```java
list.remove(1);
```

---

Before

```text
[A][B][C]
```

After

```text
[A][C]
```

---

# Internal Working

```text
Remove B

Shift Left

A B C

↓

A C
```

---

# Complexity

| Structure  | Complexity |
| ---------- | ---------- |
| ArrayList  | O(n)       |
| LinkedList | O(n)       |

---

# remove(index) vs remove(Object)

Most asked interview question.

---

## remove(index)

```java
list.remove(2);
```

Means:

```text
Remove element at index 2
```

---

## remove(Object)

```java
list.remove("Java");
```

Means:

```text
Find "Java"
Remove it
```

---

# 10. indexOf()

Returns first occurrence.

```java
List<Integer> list =
    List.of(10,20,30,20);
```

```java
list.indexOf(20);
```

Output

```text
1
```

---

# Visualization

```text
10 20 30 20
   ▲
   First 20

indexOf = 1
```

---

# 11. lastIndexOf()

Returns last occurrence.

```java
list.lastIndexOf(20);
```

Output

```text
3
```

---

# Visualization

```text
10 20 30 20
         ▲

lastIndexOf = 3
```

---

# 12. List.of()

Creates Immutable List.

```java
List<Integer> list =
    List.of(1,2,3);
```

---

Trying:

```java
list.add(4);
```

Throws:

```text
UnsupportedOperationException
```

---

# Memory Diagram

```text
Immutable List

[1,2,3]

Add?
Remove?
Modify?

❌ Not Allowed
```

---

# 13. Deep Dive: ArrayList

Most important List implementation.

Used in approximately 90%+ real projects.

---

# Internal Structure

```text
ArrayList

Uses Dynamic Array
```

---

# Memory Layout

```text
Index

0   1   2   3

10  20  30  40
```

Stored continuously in memory.

---

# Why Fast?

Formula:

```text
Address =
Base + (index × size)
```

Direct access possible.

No traversal needed.

---

# Random Access

```java
list.get(5000);
```

ArrayList directly jumps.

Complexity:

```text
O(1)
```

---

# Capacity vs Size

Interview Favorite

---

## Size

Actual elements.

```text
[10,20,30]

Size = 3
```

---

## Capacity

Storage available.

```text
Capacity = 10
Size = 3
```

---

# Visualization

```text
Capacity = 10

[10][20][30][_][_][_][_][_][_][_]

Size = 3
```

---

# Growth Mechanism

When full:

```text
Old Capacity = 10

New Capacity

10 + (10/2)

= 15
```

---

# Formula

```text
New Capacity

= Old Capacity + (Old Capacity / 2)

= 1.5x
```

---

# Resizing Flow

```text
Capacity Full

      │
      ▼

Create Bigger Array

      │
      ▼

Copy Old Elements

      │
      ▼

Delete Old Array
```

Expensive operation.

---

# ensureCapacity()

Preallocates memory.

```java
ArrayList<Integer> list =
    new ArrayList<>();

list.ensureCapacity(10000);
```

Avoids repeated resizing.

---

# trimToSize()

Shrinks unused memory.

```java
list.trimToSize();
```

---

Example

```text
Capacity = 1000
Size = 100
```

After:

```text
Capacity = 100
Size = 100
```

---

# ArrayList Complexity

| Operation     | Complexity     |
| ------------- | -------------- |
| get()         | O(1)           |
| set()         | O(1)           |
| add(end)      | O(1) amortized |
| add(index)    | O(n)           |
| remove(index) | O(n)           |
| contains()    | O(n)           |

---

# 14. Deep Dive: LinkedList

Uses Doubly Linked List.

---

# Node Structure

```text
┌───────────┐
│ prev ptr  │
├───────────┤
│   data    │
├───────────┤
│ next ptr  │
└───────────┘
```

---

# Memory Layout

```text
null

 ←prev

┌─────┐    ┌─────┐    ┌─────┐
│ 10  │⇄──►│ 20  │⇄──►│ 30  │
└─────┘◄───└─────┘◄───└─────┘

                          null
```

---

# Why Called Doubly Linked?

Each node stores:

```java
previous node
next node
```

---

# Fetching an Element

Suppose:

```java
get(7)
```

Java cannot jump directly.

Must traverse.

---

# Optimization

```text
index < size/2 ?

Yes
↓
Start from head

No
↓
Start from tail
```

---

# Example

Size = 100

Need index = 95

ArrayList:

```text
Direct Jump
```

LinkedList:

```text
Start from tail
Move backward
```

---

# Complexity

| Operation     | Complexity |
| ------------- | ---------- |
| get()         | O(n)       |
| set()         | O(n)       |
| addFirst()    | O(1)       |
| addLast()     | O(1)       |
| removeFirst() | O(1)       |
| removeLast()  | O(1)       |

---

# Why LinkedList is Less Popular?

Problems:

❌ More memory

❌ Cache unfriendly

❌ Slow traversal

❌ Poor random access

Modern CPUs love arrays.

---

# Production Usage

```text
ArrayList  → 90%+
LinkedList → Rare
```

---

# 15. ListIterator

Special iterator for Lists.

---

# Iterator Limitation

```text
Forward Only
```

---

# ListIterator Advantage

```text
Forward
Backward
Modify While Iterating
```

---

# Visualization

```text
1 ⇄ 2 ⇄ 3 ⇄ 4
      ▲
     Cursor

next()

Move Right

previous()

Move Left
```

---

# Example

```java
ListIterator<Integer> it =
      list.listIterator();
```

---

# Forward Traversal

```java
while(it.hasNext())
{
    System.out.println(it.next());
}
```

---

# Backward Traversal

```java
while(it.hasPrevious())
{
    System.out.println(it.previous());
}
```

---

# Start From Any Index

```java
ListIterator<Integer> it =
      list.listIterator(5);
```

Cursor starts at index 5.

---

# 16. Vector

Legacy Collection.

---

# Characteristics

```text
Dynamic Array
+
Thread Safe
```

---

# Internal Mechanism

Every operation synchronized.

```java
public synchronized boolean add(E e)
```

---

# Result

More safety

BUT

Less speed

---

# ArrayList vs Vector

| Feature      | ArrayList   | Vector |
| ------------ | ----------- | ------ |
| Thread Safe  | No          | Yes    |
| Speed        | Faster      | Slower |
| Modern Usage | Very Common | Rare   |

---

# 17. Stack

LIFO Structure.

```text
Last In First Out
```

---

# Visualization

```text
Push 10
Push 20
Push 30

      30 ← Top
      20
      10
```

---

# Pop

```text
30 removed first
```

---

# Operations

```java
push()
pop()
peek()
empty()
```

---

# Why Stack is Legacy?

Because it inherits Vector.

Extra synchronization overhead.

---

# Modern Alternative

```java
ArrayDeque<Integer> stack =
      new ArrayDeque<>();
```

Preferred in interviews and production.

---

# ArrayList vs LinkedList Summary

| Feature          | ArrayList     | LinkedList         |
| ---------------- | ------------- | ------------------ |
| Structure        | Dynamic Array | Doubly Linked List |
| Random Access    | O(1)          | O(n)               |
| Memory           | Less          | More               |
| Cache Friendly   | Yes           | No                 |
| Insert Middle    | O(n)          | O(n)*              |
| Read Performance | Excellent     | Poor               |
| Production Usage | Very High     | Low                |

*Finding the position itself takes O(n).

---

# Interview Questions

## Q1. Why is ArrayList faster than LinkedList?

Because ArrayList supports direct index access and is cache-friendly.

---

## Q2. Difference between size and capacity?

Size = Actual elements

Capacity = Internal storage space

---

## Q3. Why is add(index) slow in ArrayList?

Elements must be shifted.

---

## Q4. Which List implementation is used most in industry?

ArrayList.

---

## Q5. Why was SequencedCollection introduced?

To standardize first/last element operations.

---

## Q6. Difference between set() and add()?

set() → Replace

add() → Insert and shift

---

## Q7. Why is LinkedList memory-heavy?

Each node stores:

* Data
* Next pointer
* Previous pointer

Extra memory overhead per element.

---

# Quick Revision Sheet

```text
LIST

✔ Ordered
✔ Indexed
✔ Duplicates Allowed

IMPLEMENTATIONS

ArrayList
LinkedList
Vector
Stack

ARRAYLIST

✔ Dynamic Array
✔ O(1) get()
✔ O(n) insert/delete

LINKEDLIST

✔ Doubly Linked List
✔ O(1) addFirst/addLast
✔ O(n) get()

JAVA 21

getFirst()
getLast()

addFirst()
addLast()

removeFirst()
removeLast()

ITERATORS

Iterator      → Forward Only

ListIterator  → Forward + Backward

LEGACY

Vector → Thread Safe

Stack  → LIFO

Modern Stack → ArrayDeque
```
