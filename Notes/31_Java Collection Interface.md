# Java Collection Interface

---

# 1. What is Collection?

The **Collection Interface** is the root interface of the Java Collection Framework (except Map).

It represents a group of objects stored together.

Think of Collection as a **contract** that defines common operations such as:

- Add elements
- Remove elements
- Search elements
- Traverse elements
- Check size

Every major data structure like List, Set, and Queue follows this contract.

---

# Collection Hierarchy

```text
                    Iterable
                        │
                        ▼
                  Collection
                        │
        ┌───────────────┼───────────────┐
        │               │               │
        ▼               ▼               ▼
       List            Set            Queue
        │               │               │
        │               │               │
 ┌──────┼──────┐    ┌───┼────┐     ┌────┼────┐
 ▼      ▼      ▼    ▼   ▼    ▼     ▼    ▼    ▼
Array  Linked Vector Hash Tree Linked Priority
List   List         Set  Set  List   Queue
```

---

# Why Collection Extends Iterable?

Because every collection should be traversable.

```java
Collection<Integer> nums = List.of(10,20,30);

for(Integer n : nums){
    System.out.println(n);
}
```

Enhanced for-loop internally uses Iterator.

```text
Collection
      │
      ▼
  Iterator
      │
      ▼
Traverse Elements
```

---

# 2. Polymorphism in Collection Framework

One of the biggest interview topics.

Instead of programming to implementation:

❌ Bad

```java
ArrayList<Integer> list = new ArrayList<>();
```

Use interface reference:

✅ Good

```java
Collection<Integer> c = new ArrayList<>();
```

Now implementation can change anytime.

```java
Collection<Integer> c = new HashSet<>();
```

or

```java
Collection<Integer> c = new LinkedList<>();
```

without changing remaining code.

---

# Interview Question

## Why use Collection reference instead of ArrayList reference?

### Answer

Because it provides:

- Loose coupling
- Flexibility
- Runtime polymorphism
- Easy replacement of implementation

---

# Collection vs Collections

Very common interview question.

## Collection

Interface

```java
Collection<Integer> c = new ArrayList<>();
```

Used to store data.

---

## Collections

Utility Class

Contains static methods.

```java
Collections.sort(list);
Collections.reverse(list);
Collections.shuffle(list);
```

---

# Quick Comparison

| Collection | Collections |
|------------|------------|
| Interface | Utility Class |
| Stores Data | Operates on Data |
| Parent of List/Set/Queue | Contains static methods |
| java.util.Collection | java.util.Collections |

---

# Core Methods Overview

```text
Collection
│
├── Query Operations
│      ├─ size()
│      ├─ isEmpty()
│      └─ contains()
│
├── Modification Operations
│      ├─ add()
│      ├─ remove()
│      └─ clear()
│
├── Bulk Operations
│      ├─ addAll()
│      ├─ removeAll()
│      ├─ retainAll()
│      └─ containsAll()
│
└── Conversion
       └─ toArray()
```

---

# 3. size()

Returns total number of elements.

```java
Collection<Integer> c = List.of(1,2,3);

System.out.println(c.size());
```

Output

```text
3
```

---

# Internal Visualization

```text
Collection

[10,20,30,40]

size() = 4
```

---

# Time Complexity

| Structure | Complexity |
|------------|------------|
| ArrayList | O(1) |
| HashSet | O(1) |
| LinkedList | O(1) |

Because size is usually stored internally.

---

# 4. isEmpty()

Checks whether collection contains zero elements.

```java
Collection<Integer> c = new ArrayList<>();

System.out.println(c.isEmpty());
```

Output

```text
true
```

---

# Flow

```text
isEmpty()

      │
      ▼
 size == 0 ?
      │
 ┌────┴────┐
 │         │
Yes       No
 │         │
 ▼         ▼
true     false
```

---

# Why Prefer isEmpty()?

Instead of

```java
if(c.size()==0)
```

use

```java
if(c.isEmpty())
```

Reason:

- Cleaner
- More readable
- Often optimized internally

---

# 5. contains()

Checks whether element exists.

```java
Collection<String> c = List.of("A","B","C");

System.out.println(c.contains("B"));
```

Output

```text
true
```

---

# Internal Working

contains() uses equals()

```java
target.equals(element)
```

Visualization

```text
contains("B")

[A] [B] [C]

Step1 -> A == B ? No
Step2 -> B == B ? Yes

Return true
```

---

# Complexity

## ArrayList

```text
Linear Search

O(n)
```

## LinkedList

```text
Linear Search

O(n)
```

## HashSet

```text
Hash Lookup

O(1)
```

Interview favorite.

---

# 6. add()

Adds element.

```java
Collection<Integer> c = new ArrayList<>();

c.add(10);
c.add(20);
```

Result

```text
[10,20]
```

---

# Return Type

```java
boolean add(E e)
```

Returns:

```text
true  -> Collection changed

false -> Collection unchanged
```

---

# HashSet Example

```java
Set<Integer> set = new HashSet<>();

System.out.println(set.add(10));
System.out.println(set.add(10));
```

Output

```text
true
false
```

Reason:

Duplicate not added.

---

# Flowchart

```text
add(element)
      │
      ▼
 Can Add?
      │
 ┌────┴────┐
 │         │
Yes       No
 │         │
 ▼         ▼
Add      Ignore
 │         │
 ▼         ▼
true     false
```

---

# 7. remove()

Removes specified element.

```java
Collection<Integer> c =
        new ArrayList<>(List.of(10,20,30));

c.remove(20);
```

Result

```text
[10,30]
```

---

# Flow

```text
remove(20)

[10][20][30]

Find 20
   │
Found?
   │
 ┌─┴──┐
 │    │
Yes  No
 │    │
Delete Return false
 │
 ▼
Return true
```

---

# 8. clear()

Removes everything.

```java
c.clear();
```

Before

```text
[10,20,30]
```

After

```text
[]
```

---

# 9. addAll()

Adds entire collection.

```java
Collection<Integer> c1 =
        new ArrayList<>(List.of(1,2));

Collection<Integer> c2 =
        List.of(3,4);

c1.addAll(c2);
```

Result

```text
[1,2,3,4]
```

---

# Diagram

```text
c1 = [1,2]

c2 = [3,4]

addAll()

        │
        ▼

[1,2,3,4]
```

---

# 10. containsAll()

Checks whether all elements exist.

```java
List<Integer> a =
    List.of(1,2,3,4);

List<Integer> b =
    List.of(2,3);

a.containsAll(b);
```

Output

```text
true
```

---

# Visualization

```text
A = [1,2,3,4]
B = [2,3]

Every element of B
exists in A

TRUE
```

---

# 11. removeAll()

Set Difference Operation

```java
A.removeAll(B);
```

---

Example

```java
A = [1,2,3,4]
B = [2,3]
```

Result

```text
[1,4]
```

---

# Diagram

```text
Before

A = [1,2,3,4]
B = [2,3]

Remove Common Elements

Result

[1,4]
```

---

# 12. retainAll()

Most important bulk operation.

Acts like Mathematical Intersection.

```java
A.retainAll(B);
```

---

Example

```java
A = [1,2,3,4]
B = [2,3,5]
```

Result

```text
[2,3]
```

---

# Visualization

```text
          A
     1 2 3 4

          ∩

          B
      2 3 5

          ▼

       [2,3]
```

---

# Interview Tip

## Difference Between removeAll and retainAll

| Method | Meaning |
|----------|----------|
| removeAll | A - B |
| retainAll | A ∩ B |

---

# 13. toArray()

Converts collection to array.

---

## Method 1

```java
Object[] arr = c.toArray();
```

Result

```text
Object Array
```

Need casting.

---

## Method 2 (Preferred)

```java
Integer[] arr =
      c.toArray(new Integer[0]);
```

Result

```text
Integer[]
```

No casting required.

---

# Internal Flow

```text
Collection
[1,2,3]

      │
      ▼

toArray(new Integer[0])

      │
      ▼

Integer[]
[1,2,3]
```

---

# Why new Integer[0] ?

It acts as a type hint.

Java determines:

```text
Return Integer[]
instead of Object[]
```

---

# 14. toString()

Collection overrides Object's toString().

---

Without Override

```text
java.util.ArrayList@3feba861
```

---

With Override

```text
[10,20,30]
```

---

# Visualization

```text
Collection

[10]
[20]
[30]

↓

"[10,20,30]"
```

---

# 15. equals()

Compares actual content.

```java
List<Integer> a =
        List.of(1,2,3);

List<Integer> b =
        List.of(1,2,3);

System.out.println(a.equals(b));
```

Output

```text
true
```

---

# Flow

```text
a=[1,2,3]
b=[1,2,3]

Compare values

Equal

true
```

---

# 16. hashCode()

Consistent with equals().

Rule:

```text
If equals() is true

hashCode() must be same
```

Important for:

- HashSet
- HashMap
- Hashtable

Interview favorite.

---

# Java 8+ Default Methods

Added without breaking old implementations.

---

# removeIf()

```java
list.removeIf(x -> x % 2 == 0);
```

Removes even numbers.

---

# stream()

```java
list.stream()
```

Creates sequential stream.

---

# parallelStream()

```java
list.parallelStream()
```

Uses multiple threads.

---

# Collection Method Summary

| Method | Purpose |
|----------|----------|
| size() | Number of elements |
| isEmpty() | Check empty |
| contains() | Search element |
| add() | Insert |
| remove() | Delete |
| clear() | Remove all |
| addAll() | Merge collections |
| containsAll() | Check subset |
| removeAll() | Difference |
| retainAll() | Intersection |
| toArray() | Convert to array |
| equals() | Compare contents |
| hashCode() | Hash representation |
| removeIf() | Conditional remove |
| stream() | Create stream |
| parallelStream() | Parallel processing |

---

# Frequently Asked Interview Questions

### Q1. Why is Collection an Interface?

To provide a common contract for all collection types.

---

### Q2. Why doesn't Map extend Collection?

Because Map stores key-value pairs, not individual objects.

---

### Q3. Difference between Collection and Collections?

Collection = Interface

Collections = Utility Class

---

### Q4. Which method is faster: contains() in ArrayList or HashSet?

HashSet

```text
HashSet    -> O(1)
ArrayList  -> O(n)
```

---

### Q5. Difference between removeAll() and retainAll()?

```text
removeAll()  → Difference

retainAll() → Intersection
```

---

### Q6. Why use isEmpty() instead of size()==0 ?

- Better readability
- May be optimized internally

---

# Memory Trick

```text
Collection Methods

A  -> add()
AA -> addAll()

R  -> remove()
RA -> removeAll()
RT -> retainAll()

C  -> contains()
CA -> containsAll()

S  -> size()
E  -> isEmpty()
TA -> toArray()
```

Remember:

"Add, Remove, Contains, Size"

Everything else is a variation of these operations.