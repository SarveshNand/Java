# Java Set & Map Framework

---

# 1. Why Do We Need Set and Map?

Suppose we have:

```java
List<String> emails = new ArrayList<>();
```

Problem:

```text
abc@gmail.com
abc@gmail.com
abc@gmail.com
```

Duplicates allowed.

What if duplicates are not allowed?

Use:

```java
Set<String> emails = new HashSet<>();
```

---

# Real Life Examples

## Set

Store:

* User IDs
* Email IDs
* Aadhaar Numbers
* PAN Numbers

Because duplicates should not exist.

---

## Map

Store:

```text
Roll Number → Student Name
```

Example:

```java
101 → Amit
102 → Rahul
103 → Neha
```

Each roll number is unique.

---

# 2. Collection Hierarchy

```text
Iterable
    │
    ▼
Collection
    │
 ┌──┴──┐
 │     │
 ▼     ▼
List   Set

Map (Separate Hierarchy)
```

---

# Why Map Doesn't Extend Collection?

Collection stores:

```text
Single Object
```

Example:

```java
10
20
30
```

Map stores:

```text
Key → Value
```

Example:

```java
101 → Amit
102 → Rahul
```

Therefore Map is separate.

---

# 3. Set Characteristics

A Set guarantees:

```text
✔ No Duplicates
✔ Fast Search
✔ Unique Elements
```

---

# Example

```java
Set<Integer> set =
    new HashSet<>();

set.add(10);
set.add(20);
set.add(10);
```

Result:

```text
[10,20]
```

Duplicate ignored.

---

# Flow

```text
Add 10
   │
   ▼
Not Present
   │
   ▼
Added

Add 10 Again
   │
   ▼
Already Exists
   │
   ▼
Ignored
```

---

# 4. Map Characteristics

Stores:

```text
Key → Value
```

---

# Example

```java
Map<Integer,String> map =
    new HashMap<>();

map.put(101,"Amit");
map.put(102,"Rahul");
```

Memory:

```text
101 → Amit
102 → Rahul
```

---

# Rules

## Keys

Must be unique.

```java
map.put(101,"Amit");
map.put(101,"Rahul");
```

Result:

```text
101 → Rahul
```

Old value replaced.

---

## Values

Can be duplicated.

```java
101 → Amit
102 → Amit
103 → Amit
```

Perfectly valid.

---

# 5. Secret Behind O(1)

Interview Favorite

Question:

How does HashMap find data so fast?

Answer:

Using Hashing.

---

# Traditional Search

```text
10
20
30
40
50
```

Find 50:

```text
10 → 20 → 30 → 40 → 50
```

Complexity:

```text
O(n)
```

---

# Hashing Approach

```text
Hash Function

Element
   │
   ▼
Hash Code
   │
   ▼
Bucket Index
```

Direct access.

Complexity:

```text
O(1)
```

---

# 6. Bucket Structure

HashMap internally uses:

```text
Array of Buckets
```

---

# Visualization

```text
Bucket Array

Index

0
1
2
3
4
5
6
7
```

Each bucket can store data.

---

# 7. How HashMap Finds Bucket?

Suppose:

```java
map.put("Java",100);
```

---

# Step 1

Call:

```java
"Java".hashCode()
```

Suppose:

```text
2301506
```

---

# Step 2

Calculate bucket index.

```java
index = hashCode % capacity
```

Example:

```text
2301506 % 16

= 2
```

Store in bucket 2.

---

# Flowchart

```text
Key
 │
 ▼
hashCode()
 │
 ▼
Hash Value
 │
 ▼
Modulo (%)
 │
 ▼
Bucket Index
 │
 ▼
Store Data
```

---

# 8. Collision

Most important interview topic.

---

# Problem

Two different keys may generate same bucket.

Example:

```text
Java → Bucket 2

Python → Bucket 2
```

Both want same location.

---

# This is called:

```text
Collision
```

---

# Visualization

```text
Bucket 2

Java

Python
```

Multiple elements same bucket.

---

# 9. Collision Resolution

Java uses:

```text
Separate Chaining
```

---

# Structure

```text
Bucket

   Java
     │
     ▼
  Python
     │
     ▼
   C++
```

Internally:

```text
Linked List
```

---

# Memory Diagram

```text
Bucket[2]

┌─────┐
│Java │
└──┬──┘
   ▼
┌──────┐
│Python│
└──┬───┘
   ▼
┌─────┐
│ C++ │
└─────┘
```

---

# Searching in Collision Bucket

Need to compare keys.

Uses:

```java
equals()
```

Important interview answer.

---

# Search Flow

```text
Same Bucket

Key Match?

No
│
▼
Next Node

Key Match?

Yes
│
▼
Return Value
```

---

# 10. hashCode() and equals()

Golden Interview Question

---

# Rule

If two objects are equal

```java
a.equals(b)
```

returns:

```text
true
```

then

```java
a.hashCode()
```

and

```java
b.hashCode()
```

must be same.

---

# Example

```java
String s1 = "Java";
String s2 = "Java";
```

```java
s1.equals(s2)
```

```text
true
```

Therefore:

```java
s1.hashCode() ==
s2.hashCode()
```

---

# Why Needed?

To place equal objects into same bucket.

---

# Interview Answer

HashMap uses:

```text
hashCode()
```

for locating bucket.

and

```text
equals()
```

for identifying exact key.

---

# 11. Internal Working of HashSet

Most students don't know this.

---

# Reality

HashSet internally uses:

```java
HashMap
```

---

# Simplified Source Code

```java
class HashSet<E>{

   HashMap<E,Object> map;

}
```

---

# Storage

When you add:

```java
set.add("Java");
```

Internally:

```java
map.put("Java",PRESENT);
```

---

# Memory

```text
Key      Value

Java  → PRESENT
C++   → PRESENT
Python→ PRESENT
```

---

# PRESENT Object

Dummy object used by HashSet.

```java
private static final Object PRESENT
```

---

# Interview Question

How is duplicate detection done in HashSet?

Answer:

Since keys in HashMap are unique,
duplicate keys cannot exist.

Hence HashSet automatically prevents duplicates.

---

# 12. Java 8 Treeification

Before Java 8

```text
Bucket

A
│
B
│
C
│
D
│
E
```

Long linked list.

Search becomes:

```text
O(n)
```

---

# Java 8 Solution

Convert Linked List to Red Black Tree.

---

# Trigger Condition

```text
Bucket Size > 8
```

---

# Transformation

Before:

```text
A
│
B
│
C
│
D
```

After:

```text
       C
      / \
     B   D
    /
   A
```

Balanced Tree.

---

# Complexity Improvement

Before

```text
O(n)
```

After

```text
O(log n)
```

---

# Treeification Flow

```text
Collision
    │
    ▼
Linked List
    │
    ▼
Nodes > 8 ?
    │
 ┌──┴───┐
 │      │
No     Yes
 │      │
 ▼      ▼
Keep  Convert To
List  Red Black Tree
```

---

# 13. HashMap Internal Structure (Java 8+)

```text
Bucket Array

0
1
2 → Linked List / Tree
3
4
5
```

---

# Node Structure

```text
┌──────────┐
│ hash     │
├──────────┤
│ key      │
├──────────┤
│ value    │
├──────────┤
│ next     │
└──────────┘
```

---

# 14. Capacity

Default buckets:

```java
new HashMap<>();
```

Creates:

```text
16 Buckets
```

Default Capacity:

```text
16
```

---

# 15. Load Factor

Controls resizing.

Default:

```text
0.75
```

Meaning:

```text
75%
```

---

# Formula

```text
Threshold

=
Capacity × LoadFactor
```

---

# Example

```text
Capacity = 16

LoadFactor = 0.75

Threshold

= 16 × 0.75

= 12
```

---

# Meaning

When elements become:

```text
13
```

Resize required.

---

# 16. Rehashing

When threshold exceeded.

---

# Before

```text
Capacity = 16
```

---

# After

```text
Capacity = 32
```

Doubles.

---

# Flowchart

```text
Insert Element
      │
      ▼
Threshold Reached?
      │
 ┌────┴────┐
 │         │
No        Yes
 │         │
 ▼         ▼
Store   Double Capacity
             │
             ▼
       Recalculate Buckets
             │
             ▼
          Rehash
```

---

# Why Rehash?

Bucket positions depend on:

```java
hash % capacity
```

When capacity changes:

```text
Bucket index changes
```

Need relocation.

---

# 17. HashSet vs LinkedHashSet vs TreeSet

---

# HashSet

Uses:

```text
Hash Table
```

Order:

```text
No Guarantee
```

Example:

```java
10 20 30 40
```

May print:

```java
30 10 40 20
```

---

# LinkedHashSet

Preserves insertion order.

---

# Memory

```text
Hash Table
      +
Doubly Linked List
```

---

# Diagram

```text
10 ⇄ 20 ⇄ 30 ⇄ 40
```

Output:

```text
10 20 30 40
```

Always.

---

# TreeSet

Uses:

```text
Red Black Tree
```

No hashing.

---

# Automatic Sorting

```java
TreeSet<Integer> set =
     new TreeSet<>();

set.add(30);
set.add(10);
set.add(20);
```

Output

```text
10 20 30
```

---

# Tree Structure

```text
      20
     /  \
   10   30
```

---

# Complexity

```text
O(log n)
```

---

# 18. HashMap vs LinkedHashMap vs TreeMap

---

# HashMap

```text
Fastest
No Order
```

---

# LinkedHashMap

```text
Insertion Order Maintained
```

---

# TreeMap

```text
Sorted By Key
```

---

# Example

Input

```java
30=A
10=B
20=C
```

---

TreeMap Output

```text
10=B
20=C
30=A
```

Automatically sorted.

---

# 19. Null Handling

Interview Favorite

---

# HashMap

Allowed:

```java
map.put(null,"Java");
```

Valid.

---

# HashSet

Allowed:

```java
set.add(null);
```

One null allowed.

---

# Why?

Stored in bucket 0.

---

# TreeMap

```java
map.put(null,"Java");
```

Throws:

```text
NullPointerException
```

---

# TreeSet

```java
set.add(null);
```

Throws:

```text
NullPointerException
```

---

# Reason

Tree structures use:

```java
compareTo()
```

Cannot compare null.

---

# Complete Comparison Table

| Feature     | HashSet/HashMap | LinkedHashSet/LinkedHashMap | TreeSet/TreeMap          |
| ----------- | --------------- | --------------------------- | ------------------------ |
| Structure   | Hash Table      | Hash Table + DLL            | Red Black Tree           |
| Ordering    | No              | Insertion Order             | Sorted                   |
| Search      | O(1)            | O(1)                        | O(log n)                 |
| Null Key    | Allowed         | Allowed                     | Not Allowed              |
| Null Values | Allowed         | Allowed                     | Allowed (TreeMap values) |
| Hashing     | Yes             | Yes                         | No                       |
| Memory      | Low             | Medium                      | High                     |

---

# Production Usage Guide

```text
Need Fast Lookup?

→ HashMap

Need Fast Lookup + Order?

→ LinkedHashMap

Need Sorting?

→ TreeMap
```

Same applies to:

```text
HashSet
LinkedHashSet
TreeSet
```

---

# Quick Revision Sheet

```text
SET

✔ Unique Values
✔ No Duplicates

MAP

✔ Key → Value
✔ Unique Keys

HASHMAP

✔ O(1)
✔ Uses Hashing
✔ Uses Buckets

COLLISION

Two Keys
Same Bucket

RESOLUTION

Linked List
(Java 8 → Tree)

TREEIFICATION

Bucket Size > 8

Convert To

Red Black Tree

LOAD FACTOR

0.75

DEFAULT CAPACITY

16

REHASH

16 → 32 → 64

HASHSET

Internally Uses HashMap

LINKEDHASHMAP

Maintains Insertion Order

TREEMAP

Sorted Order
Uses Red Black Tree
O(log n)
```
