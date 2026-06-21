# Java Iterable & Iterator

---

# 1. Why Do We Need Iterable?

Imagine Java had only arrays.

```java
int arr[] = {10,20,30,40};

for(int i=0;i<arr.length;i++){
    System.out.println(arr[i]);
}
```

Works perfectly because arrays have:

* Indexes
* Fixed positions
* Random access

---

Now consider:

```java
HashSet<Integer> set = new HashSet<>();
```

Question:

```java
set.get(0);
```

Possible?

❌ No

Because HashSet does not store data using indexes.

---

Similarly:

```java
Queue<Integer>
Stack<Integer>
TreeSet<Integer>
LinkedHashSet<Integer>
```

None of these provide index-based access.

So Java needed:

> A universal mechanism to traverse any collection regardless of how it stores data internally.

This led to:

```text
Iterable Interface
```

---

# 2. Collection Hierarchy

Understanding where Iterable sits is important.

```text
                    Object
                       │
                       ▼
                    Iterable
                       │
                       ▼
                   Collection
                 /     |      \
                /      |       \
               ▼       ▼        ▼
             List     Set     Queue
              │        │         │
      ┌───────┘        │         └───────┐
      ▼                ▼                 ▼
 ArrayList         HashSet         PriorityQueue
 LinkedList        TreeSet         ArrayDeque
```

---

# Key Idea

Anything that wants to support:

```java
for(Type item : collection)
```

must implement:

```java
Iterable<T>
```

---

# Real Life Analogy

Think of a TV remote.

You don't need to know:

* Internal circuits
* Processor
* Signal protocol

You only press:

```text
Next Channel
```

Similarly:

```text
Iterator
```

lets you move through elements without knowing how they're stored.

---

# 3. Problems With Traditional Loops

## Problem 1: No Index

Array:

```java
arr[2]
```

works.

HashSet:

```java
set[2]
```

does not exist.

---

## Problem 2: Different Data Structures

Suppose Java forced different traversal methods.

```java
stack.pop()
queue.poll()
tree.getLeft()
```

Every collection would need unique code.

Bad design.

---

## Problem 3: LinkedList Performance Trap

Many beginners write:

```java
for(int i=0;i<list.size();i++){
    System.out.println(list.get(i));
}
```

For:

```java
LinkedList<Integer>
```

This becomes:

```text
get(0)
get(1)
get(2)
...
get(n)
```

Each get() traverses nodes.

---

# Visualization

```text
Node1 → Node2 → Node3 → Node4
```

To access:

```java
get(3)
```

LinkedList walks through:

```text
Node1
   ↓
Node2
   ↓
Node3
   ↓
Node4
```

Cost:

```text
O(n)
```

Repeated n times:

```text
O(n²)
```

Huge performance issue.

---

# Solution

Use:

```java
Iterator
```

which naturally walks node by node.

Total cost:

```text
O(n)
```

---

# 4. Iterable Interface

Definition:

```java
public interface Iterable<T>
```

Contains one important method:

```java
Iterator<T> iterator();
```

---

# Flow

```text
Collection
     │
     ▼
iterator()
     │
     ▼
Iterator Object
     │
     ▼
Traverse Elements
```

---

# Example

```java
List<Integer> list =
        new ArrayList<>();

list.add(10);
list.add(20);
list.add(30);

Iterator<Integer> it =
        list.iterator();
```

---

# 5. Iterator Interface

Iterator is the actual traversal machine.

---

## Core Methods

```java
boolean hasNext()
```

```java
E next()
```

```java
void remove()
```

---

# Method 1: hasNext()

Checks if another element exists.

```text
Current Position
        │
        ▼

10 20 30
      ^
```

Still elements left?

```java
true
```

---

# Method 2: next()

Returns element and moves cursor.

Before:

```text
10 20 30
^
```

```java
next()
```

returns:

```text
10
```

Cursor moves.

After:

```text
10 20 30
   ^
```

---

# Method 3: remove()

Safely removes current element.

```java
iterator.remove();
```

Important for avoiding:

```text
ConcurrentModificationException
```

---

# 6. Internal Working

Suppose:

```java
ArrayList<Integer> list
```

contains:

```text
10 20 30
```

---

# Step 1

```java
Iterator<Integer> it =
        list.iterator();
```

Java creates:

```text
Iterator Object
```

with:

```java
position = 0;
```

---

# Internal Diagram

```text
ArrayList

Index:
0  1  2

10 20 30
 ^
position=0
```

---

# hasNext()

Internally:

```java
position < size
```

```java
0 < 3
```

returns:

```text
true
```

---

# next()

Returns:

```java
array[position]
```

Then:

```java
position++
```

---

After next():

```text
10 20 30
    ^
position=1
```

---

# Flowchart

```text
Start
  │
  ▼
hasNext() ?
  │
 ┌┴───────┐
 │        │
No       Yes
 │        │
 ▼        ▼
End     next()
           │
           ▼
      Move Cursor
           │
           ▼
      Repeat
```

---

# 7. Why Multiple Iterators Work

Interview Favorite.

Suppose:

```java
Iterator<Integer> i1 =
        list.iterator();

Iterator<Integer> i2 =
        list.iterator();
```

Java creates:

```text
Iterator Object A

position=0
```

and

```text
Iterator Object B

position=0
```

Both are independent.

---

# Visualization

```text
10 20 30 40

A ^
B ^
```

After:

```java
i1.next();
```

```text
10 20 30 40

   A ^
B  ^
```

Only A moved.

---

# Therefore

Nested loops work correctly.

```java
for(Integer a : list)
{
    for(Integer b : list)
    {
    }
}
```

---

# 8. Enhanced For Loop (For-Each)

Most developers use:

```java
for(Integer num : list)
{
    System.out.println(num);
}
```

Looks simple.

---

# Compiler Conversion

Java converts it into:

```java
Iterator<Integer> it =
        list.iterator();

while(it.hasNext())
{
    Integer num = it.next();

    System.out.println(num);
}
```

---

# Flow

```text
For-Each Loop
      │
      ▼
Compiler Converts
      │
      ▼
Iterator
      │
      ▼
While Loop
```

---

# Requirement for For-Each

Must implement:

```java
Iterable
```

OR

be an Array.

---

# Valid

```java
ArrayList
HashSet
TreeSet
LinkedList
```

---

# Invalid

Normal class:

```java
class Student
{
}
```

Cannot use:

```java
for(Student s : obj)
```

unless Student implements:

```java
Iterable<Student>
```

---

# 9. ConcurrentModificationException

Most Common Interview Question.

---

# Example

```java
List<Integer> list =
    new ArrayList<>();

list.add(10);
list.add(20);
list.add(30);

for(Integer num : list)
{
    if(num == 20)
    {
        list.remove(num);
    }
}
```

Runtime:

```text
ConcurrentModificationException
```

---

# Why?

Iterator expects:

```text
Collection structure remains unchanged
```

But:

```java
list.remove()
```

changes structure directly.

---

# Internal Idea

Iterator stores:

```java
expectedModCount
```

Collection stores:

```java
actualModCount
```

When different:

```text
Boom 💥
ConcurrentModificationException
```

---

# Diagram

```text
Iterator

expectedModCount = 3
```

Collection:

```text
modCount = 4
```

Mismatch.

Exception thrown.

---

# Safe Removal

Use:

```java
Iterator<Integer> it =
        list.iterator();

while(it.hasNext())
{
    Integer val = it.next();

    if(val == 20)
    {
        it.remove();
    }
}
```

---

# Why Safe?

Iterator updates both counters.

No mismatch.

---

# 10. Custom Iterable Class

Suppose we build our own collection.

---

# Step 1

Implement:

```java
Iterable<String>
```

---

# Step 2

Override:

```java
iterator()
```

---

# Step 3

Return Iterator

---

# Complete Flow

```text
Custom Class
      │
      ▼
implements Iterable
      │
      ▼
iterator()
      │
      ▼
Return Iterator
      │
      ▼
For-Each Works
```

---

# Example

```java
class NameContainer
        implements Iterable<String>
{
    private String[] names =
    {
        "Aman",
        "Rahul",
        "Rohit"
    };

    @Override
    public Iterator<String> iterator()
    {
        return new Iterator<String>()
        {
            int pos = 0;

            public boolean hasNext()
            {
                return pos < names.length;
            }

            public String next()
            {
                return names[pos++];
            }
        };
    }
}
```

Usage:

```java
NameContainer nc =
        new NameContainer();

for(String name : nc)
{
    System.out.println(name);
}
```

Output:

```text
Aman
Rahul
Rohit
```

---

# Iterable vs Iterator

| Feature        | Iterable                   | Iterator           |
| -------------- | -------------------------- | ------------------ |
| Purpose        | Creates iterator           | Traverses elements |
| Method         | iterator()                 | hasNext(), next()  |
| Count          | Usually one per collection | Multiple possible  |
| Responsibility | Provide traversal object   | Perform traversal  |

---

# Interview Questions

## Q1 Why does Collection extend Iterable?

Because every collection should be traversable.

---

## Q2 Why doesn't Map implement Iterable?

Map stores:

```text
Key → Value
```

not individual elements.

Instead:

```java
map.keySet()
map.values()
map.entrySet()
```

return iterable collections.

---

## Q3 Why is for-each faster on LinkedList?

Because it uses Iterator internally.

Traversal:

```text
Node → Node → Node
```

Only:

```text
O(n)
```

---

## Q4 Difference Between Enumeration and Iterator?

| Enumeration        | Iterator           |
| ------------------ | ------------------ |
| Legacy             | Modern             |
| Read only          | Can remove         |
| Less functionality | More functionality |

---

## Q5 What is Fail-Fast Iterator?

An iterator that throws:

```text
ConcurrentModificationException
```

when collection structure changes unexpectedly.

---

# Quick Revision Sheet

```text
Iterable
    │
    └── iterator()

Iterator
    │
    ├── hasNext()
    ├── next()
    └── remove()

For-Each
    │
    └── Uses Iterator Internally

Benefits
    │
    ├── Uniform Traversal
    ├── Works For All Collections
    ├── O(n) Traversal
    ├── Data Structure Independent
    └── Supports Custom Collections

Fail-Fast
    │
    ├── Collection Modified
    ├── Iterator Detects Change
    └── ConcurrentModificationException
```

---

# Golden Interview Answer

> `Iterable` is the root interface of the Java Collection hierarchy that enables objects to be traversed sequentially. It exposes the `iterator()` method, which returns an `Iterator` object responsible for element traversal using `hasNext()` and `next()`. The enhanced for-loop internally uses an Iterator. This design separates data storage from traversal logic, providing a uniform, efficient, and extensible mechanism for iterating across different collection types while supporting fail-fast behavior through `ConcurrentModificationException`.
