# Java Set & Map Advanced Concepts

# TreeSet, NavigableSet, Advanced Map Methods & Specialized Maps

---

# 1. Set Hierarchy

Most developers know:

```java
HashSet
LinkedHashSet
TreeSet
```

But interviewers often ask:

> "What interfaces does TreeSet implement?"

---

# Complete Set Hierarchy

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
Set
  │
  ├───────────────┐
  │               │
  ▼               ▼
HashSet      SortedSet
  │               │
  ▼               ▼
LinkedHashSet  NavigableSet
                  │
                  ▼
               TreeSet
```

---

# Why So Many Interfaces?

Each interface adds new functionality.

```text
Collection
      +
No Duplicates
      ↓
Set

Sorted Data
      ↓
SortedSet

Navigation Features
      ↓
NavigableSet

Implementation
      ↓
TreeSet
```

---

# Quick Memory Trick

```text
Set

↓

SortedSet

↓

NavigableSet

↓

TreeSet
```

Think:

```text
Unique

↓

Sorted

↓

Navigable

↓

Concrete Class
```

---

# 2. HashSet Constructors

---

# Constructor 1

Default Constructor

```java
HashSet<Integer> set =
       new HashSet<>();
```

Uses:

```text
Capacity = 16

Load Factor = 0.75
```

---

# Internal View

```text
Bucket Array

0
1
2
3
4
...
15
```

16 buckets.

---

# Constructor 2

Specify Capacity

```java
HashSet<Integer> set =
       new HashSet<>(100);
```

---

# Why?

Suppose:

```java
for(int i=1;i<=1000;i++)
{
    set.add(i);
}
```

Without capacity:

```text
16 → 32 → 64 → 128 ...
```

Many rehashes.

---

With:

```java
new HashSet<>(1000)
```

Less resizing.

Better performance.

---

# Constructor 3

Capacity + Load Factor

```java
HashSet<Integer> set =
      new HashSet<>(100,0.80f);
```

---

Meaning

```text
Threshold

= 100 × 0.80

= 80
```

Resize only after 80 elements.

---

# Constructor 4

Collection Constructor

```java
List<Integer> list =
      List.of(1,2,3,4);

Set<Integer> set =
      new HashSet<>(list);
```

---

Purpose

```text
Convert Collection → Set
```

and automatically remove duplicates.

---

# Example

```java
List<Integer> list =
      List.of(1,1,2,2,3,3);

Set<Integer> set =
      new HashSet<>(list);
```

Result

```text
[1,2,3]
```

---

# LinkedHashSet Constructors

Exactly same as HashSet.

```java
new LinkedHashSet<>();

new LinkedHashSet<>(100);

new LinkedHashSet<>(100,0.75f);

new LinkedHashSet<>(collection);
```

---

# 3. TreeSet Internals

TreeSet does NOT use hashing.

Interview favorite.

---

# Uses

```text
Red Black Tree
```

Internally:

```java
TreeMap
```

Just like:

```java
HashSet → HashMap
```

Similarly:

```java
TreeSet → TreeMap
```

---

# Visualization

```text
Insert:

50
20
80
10
30
```

Stored as:

```text
         50
        /  \
      20    80
     / \
   10  30
```

Automatically sorted.

---

# Output

```text
10 20 30 50 80
```

---

# Complexity

| Operation  | Complexity |
| ---------- | ---------- |
| add()      | O(log n)   |
| remove()   | O(log n)   |
| contains() | O(log n)   |
| first()    | O(log n)   |
| last()     | O(log n)   |

---

# Why Not O(1)?

Because TreeSet doesn't use hashing.

Uses tree traversal.

---

# 4. SortedSet Methods

Available because:

```text
TreeSet
implements
NavigableSet

extends

SortedSet
```

---

# first()

Returns smallest element.

```java
TreeSet<Integer> set =
       new TreeSet<>();

set.add(50);
set.add(10);
set.add(80);
```

---

```java
set.first();
```

Output

```text
10
```

---

# Visualization

```text
      50
     /  \
   10   80

Leftmost Node

= 10
```

---

# last()

Returns largest element.

```java
set.last();
```

Output

```text
80
```

---

# Visualization

```text
      50
     /  \
   10   80

Rightmost Node

= 80
```

---

# headSet()

Returns values smaller than given element.

```java
TreeSet<Integer> set =
      new TreeSet<>(
      List.of(10,20,30,40,50));
```

---

```java
set.headSet(40);
```

Output

```text
[10,20,30]
```

---

# Flow

```text
Values < 40
```

---

# tailSet()

Returns:

```text
Values >= element
```

---

```java
set.tailSet(30);
```

Output

```text
[30,40,50]
```

---

# Visualization

```text
10 20 30 40 50

       ▲

Take Everything Right
```

---

# subSet()

Range query.

```java
set.subSet(20,50);
```

Output

```text
20 30 40
```

---

# Important

Default Rule

```text
From → Inclusive

To → Exclusive
```

---

# Formula

```text
[from,to)
```

Exactly like mathematics.

---

# Example

```java
subSet(20,50)
```

Means

```text
20 included

50 excluded
```

Result

```text
20 30 40
```

---

# Interview Question

Difference between:

```java
headSet()
tailSet()
subSet()
```

Answer:

```text
headSet()

All smaller elements

tailSet()

All larger/equal elements

subSet()

Specific range
```

---

# 5. NavigableSet Methods

Most important TreeSet methods.

---

# Why Introduced?

To find nearest elements.

---

Suppose:

```text
10 20 30 40 50
```

User searches:

```text
25
```

Not present.

Need nearest values.

---

# lower()

Strictly smaller.

```java
set.lower(25);
```

Output

```text
20
```

---

# Visualization

```text
10 20 30 40 50
      ▲
      25

Nearest Smaller

20
```

---

# floor()

Smaller OR Equal.

```java
set.floor(30);
```

Output

```text
30
```

---

```java
set.floor(25);
```

Output

```text
20
```

---

# Rule

```text
<=
```

---

# higher()

Strictly greater.

```java
set.higher(25);
```

Output

```text
30
```

---

# Rule

```text
>
```

---

# ceiling()

Greater OR Equal.

```java
set.ceiling(30);
```

Output

```text
30
```

---

```java
set.ceiling(25);
```

Output

```text
30
```

---

# Rule

```text
>=
```

---

# Comparison Table

| Method     | Meaning |
| ---------- | ------- |
| lower(x)   | < x     |
| floor(x)   | <= x    |
| higher(x)  | > x     |
| ceiling(x) | >= x    |

---

# Memory Trick

```text
L → Lower

Strict Left

F → Floor

Touch Allowed

H → Higher

Strict Right

C → Ceiling

Touch Allowed
```

---

# Visualization

```text
10 20 30 40 50

Search = 30

lower(30)   → 20

floor(30)   → 30

higher(30)  → 40

ceiling(30) → 30
```

---

# pollFirst()

Fetches and removes smallest element.

---

Before

```text
10 20 30 40
```

---

```java
set.pollFirst();
```

Returns:

```text
10
```

Remaining:

```text
20 30 40
```

---

# pollLast()

Fetches and removes largest.

---

Returns:

```text
40
```

Remaining:

```text
20 30
```

---

# Interview Favorite

Difference:

```java
first()
```

and

```java
pollFirst()
```

---

```text
first()

Read only

pollFirst()

Read + Remove
```

---

# 6. Advanced Map Methods

Most production code uses these.

---

# Problem with get()

```java
Map<String,Integer> map =
       new HashMap<>();
```

---

```java
map.get("Java");
```

Output

```text
null
```

---

Then:

```java
map.get("Java") + 1
```

Throws:

```text
NullPointerException
```

---

# getOrDefault()

Safer alternative.

```java
map.getOrDefault("Java",0);
```

Output

```text
0
```

---

# Word Frequency Example

```java
map.put(
word,
map.getOrDefault(word,0)+1
);
```

Most common interview usage.

---

# putIfAbsent()

Insert only if key doesn't exist.

---

```java
map.put("Java",100);
```

---

```java
map.putIfAbsent("Java",500);
```

Result

```text
Java → 100
```

Not replaced.

---

# Difference

put()

```text
Always overwrite
```

---

putIfAbsent()

```text
Overwrite only if absent
```

---

# replace()

Safe update.

---

```java
map.replace("Java",100,200);
```

Meaning

```text
If current value is 100

Replace with 200
```

---

# Flow

```text
Key Exists?
      │
      ▼
Value Match?
      │
 ┌────┴────┐
 │         │
Yes       No
 │         │
 ▼         ▼
Update   Ignore
```

---

# entrySet()

Most efficient way to iterate map.

---

# Without entrySet

```java
for(Integer key : map.keySet())
{
   map.get(key);
}
```

Extra lookup.

---

# Better

```java
for(Map.Entry<Integer,String> e
        : map.entrySet())
{
    System.out.println(
      e.getKey()
    );

    System.out.println(
      e.getValue()
    );
}
```

---

# Visualization

```text
Entry Object

┌─────────┐
│ Key     │
├─────────┤
│ Value   │
└─────────┘
```

---

# 7. IdentityHashMap

Very rare interview topic.

---

# Normal HashMap

Uses:

```java
equals()
```

---

Example

```java
String s1 =
      new String("Java");

String s2 =
      new String("Java");
```

---

```java
s1.equals(s2)
```

Output

```text
true
```

HashMap treats them as same key.

---

# IdentityHashMap

Uses:

```java
==
```

Reference comparison.

---

```java
s1 == s2
```

Output

```text
false
```

Different objects.

---

# Result

IdentityHashMap stores both.

---

# Visualization

```text
Object A → Java

Object B → Java

HashMap

1 Entry

IdentityHashMap

2 Entries
```

---

# Interview Answer

HashMap

```text
Logical Equality
```

IdentityHashMap

```text
Reference Equality
```

---

# 8. EnumMap

One of the fastest maps in Java.

---

# Example

```java
enum Day
{
   MON,TUE,WED
}
```

---

```java
EnumMap<Day,String> map =
      new EnumMap<>(Day.class);
```

---

# Internal Working

No hashing.

Uses:

```text
Enum Ordinal
```

---

Example

```text
MON → 0

TUE → 1

WED → 2
```

---

# Storage

```text
Array

0 → Value

1 → Value

2 → Value
```

---

# Benefits

```text
✔ Faster

✔ Less Memory

✔ Predictable Order
```

---

# Restriction

```java
map.put(null,"Java");
```

Throws exception.

No null keys.

---

# 9. ConcurrentHashMap

Modern Thread Safe Map.

---

# Legacy Solution

```java
Hashtable
```

Problem:

```text
Entire Map Locked
```

Slow.

---

# ConcurrentHashMap

Uses fine-grained locking and concurrent algorithms.

Benefits:

```text
✔ Thread Safe

✔ Faster

✔ High Throughput
```

---

# Interview Answer

Preferred over Hashtable.

---

# Comparison

| Feature      | Hashtable | ConcurrentHashMap |
| ------------ | --------- | ----------------- |
| Thread Safe  | Yes       | Yes               |
| Performance  | Slow      | Fast              |
| Modern Usage | Rare      | Common            |

---

# 10. Properties Class

Used for configuration files.

---

# Example

```properties
username=admin

password=123

port=8080
```

---

# Java

```java
Properties p =
      new Properties();

p.load(fileReader);
```

---

# Output

```java
p.getProperty("username");
```

Returns:

```text
admin
```

---

# Used In

```text
Spring Boot

Hibernate

Maven

Java Applications
```

---

# Complete Map Comparison

| Map Type          | Equality Check | Null Key | Ordering   |
| ----------------- | -------------- | -------- | ---------- |
| HashMap           | equals()       | Yes      | No         |
| LinkedHashMap     | equals()       | Yes      | Insertion  |
| TreeMap           | compareTo()    | No       | Sorted     |
| IdentityHashMap   | ==             | Yes      | No         |
| EnumMap           | Ordinal        | No       | Enum Order |
| ConcurrentHashMap | equals()       | No       | No         |

---

# Quick Revision Sheet

```text
TREESET

Uses Red Black Tree

O(log n)

first()
last()

headSet()

tailSet()

subSet()

NAVIGABLE METHODS

lower()   <

floor()   <=

higher()  >

ceiling() >=

MAP METHODS

getOrDefault()

putIfAbsent()

replace()

entrySet()

SPECIAL MAPS

IdentityHashMap
→ Uses ==

EnumMap
→ Uses Enum Ordinal

ConcurrentHashMap
→ Thread Safe

Properties
→ Config Files
```
