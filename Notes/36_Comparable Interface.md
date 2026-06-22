# Java Comparable, Custom Object Sorting & Collections Utility Class

---

# 1. Why Do We Need Comparable?

Java can naturally compare:

```java
10 < 20
```

```java
"Amit".compareTo("Rahul")
```

because primitive wrappers and Strings already know how to compare themselves.

---

# Natural Ordering Examples

## Integer

```java
10 < 20
```

Ascending Order:

```text
10 20 30 40 50
```

---

## String

```java
"Apple".compareTo("Banana")
```

Output:

```text
Negative Value
```

Because:

```text
Apple comes before Banana
```

(Dictionary Order)

---

# Problem with Custom Classes

Consider:

```java
class Student {
    String name;
    int marks;
}
```

Create Objects:

```java
Student s1 =
    new Student("Amit",90);

Student s2 =
    new Student("Rahul",80);
```

Question:

```text
Which student is greater?
```

Java doesn't know.

---

# Ambiguity

Should Java compare:

```text
Name?
```

OR

```text
Marks?
```

OR

```text
Age?
```

OR

```text
Roll Number?
```

No natural ordering exists.

---

# Result

Sorting fails.

```java
Collections.sort(studentList);
```

Compilation / Runtime error.

---

# TreeSet Problem

```java
TreeSet<Student> set =
       new TreeSet<>();
```

Fails because TreeSet requires:

```text
Comparison Logic
```

to place elements inside BST.

---

# Why TreeSet Needs Comparison?

TreeSet internally uses:

```text
Red Black Tree
```

---

# Visualization

```text
        50
       /  \
     30    80
```

To decide:

```text
Go Left?

or

Go Right?
```

Comparison is mandatory.

---

# Solution

Implement:

```java
Comparable<T>
```

---

# 2. Comparable Interface

Comparable defines:

```text
Natural Ordering
```

for a class.

---

# Interface Definition

```java
public interface Comparable<T> {

    int compareTo(T o);

}
```

---

# Important

Comparable is a:

```text
Functional Interface
```

because it contains:

```text
Exactly One Abstract Method
```

---

# Method

```java
compareTo()
```

---

# Comparison Flow

```text
Object A
    │
compareTo()
    │
Object B
```

Returns:

```text
Negative

Positive

or

Zero
```

---

# 3. compareTo() Return Values

---

# Negative Value

```java
return -1;
```

Meaning:

```text
Current Object Smaller
```

Place Before.

---

# Example

```java
10.compareTo(20)
```

Result:

```text
Negative
```

---

# Visualization

```text
10 20
▲
Before
```

---

# Positive Value

```java
return 1;
```

Meaning:

```text
Current Object Greater
```

Place After.

---

# Example

```java
20.compareTo(10)
```

Result:

```text
Positive
```

---

# Visualization

```text
10 20
   ▲
 After
```

---

# Zero

```java
return 0;
```

Meaning:

```text
Both Objects Equal
```

---

# Example

```java
10.compareTo(10)
```

Result:

```text
0
```

---

# Why int Instead of boolean?

Comparison has:

```text
Less Than

Equal To

Greater Than
```

Three possibilities.

Boolean provides only:

```text
True

False
```

Not enough.

---

# 4. Implementing Comparable

---

# Student Class

```java
public class Student
       implements Comparable<Student>
{
    String name;
    int marks;

    Student(String name,int marks)
    {
        this.name=name;
        this.marks=marks;
    }

    @Override
    public int compareTo(Student other)
    {
        return this.marks - other.marks;
    }
}
```

---

# Sorting Logic

```java
return this.marks -
       other.marks;
```

---

# Meaning

```text
Smaller Marks

↓

Comes First
```

---

# Example

```java
Amit  = 80

Rahul = 95
```

---

# Calculation

```java
80 - 95
```

Result:

```text
Negative
```

Amit comes first.

---

# Sorted Output

```text
Amit 80

Rahul 95
```

---

# 5. Descending Order

---

# Logic

```java
return other.marks
       - this.marks;
```

---

# Example

```java
80

95
```

---

# Calculation

```java
95 - 80
```

Positive.

95 comes first.

---

# Output

```text
Rahul 95

Amit 80
```

---

# Ascending vs Descending

| Order      | Logic                    |
| ---------- | ------------------------ |
| Ascending  | this.marks - other.marks |
| Descending | other.marks - this.marks |

---

# 6. Multi-Level Sorting

Interview Favorite.

---

# Requirement

Sort By:

```text
Marks
```

If marks equal:

```text
Sort By Name
```

---

# Example Data

```text
Rahul 90

Amit 90

Neha 95
```

---

# Desired Output

```text
Amit 90

Rahul 90

Neha 95
```

---

# Implementation

```java
@Override
public int compareTo(Student other)
{
    if(this.marks != other.marks)
    {
        return this.marks
             - other.marks;
    }

    return this.name
             .compareTo(other.name);
}
```

---

# Flowchart

```text
Compare Marks
      │
      ▼
Different?
      │
 ┌────┴────┐
 │         │
Yes       No
 │         │
 ▼         ▼
Marks    Compare Name
Result
```

---

# 7. compareTo() in TreeSet

Most Important Interview Concept.

---

# TreeSet Duplicate Check

Uses:

```java
compareTo()
```

NOT

```java
equals()
```

---

# Example

```java
Student s1 =
new Student("Amit",90);

Student s2 =
new Student("Rahul",90);
```

---

# compareTo()

```java
return this.marks
     - other.marks;
```

---

# Result

```text
90 - 90

= 0
```

---

# TreeSet Interpretation

```text
Same Object
```

---

# Storage

```text
Only One Student Stored
```

Second student discarded.

---

# Data Loss Issue

```text
Amit 90

Rahul 90
```

TreeSet stores only one.

---

# Why Dangerous?

Because:

```text
compareTo() == 0
```

means:

```text
Objects Considered Equal
```

inside TreeSet.

---

# Recommended Rule

If:

```java
a.compareTo(b) == 0
```

then ideally:

```java
a.equals(b)
```

should be:

```text
true
```

---

# Consistency Rule

```text
compareTo()

and

equals()

should agree
```

---

# 8. Comparable vs equals()

Interview Favorite.

---

# equals()

Checks:

```text
Logical Equality
```

---

# compareTo()

Checks:

```text
Ordering
```

---

# Example

```java
Student s1 =
new Student("Amit",90);

Student s2 =
new Student("Rahul",90);
```

---

# compareTo()

```text
0
```

---

# equals()

May return:

```text
false
```

Different names.

---

# This inconsistency causes bugs.

---

# 9. Collections Utility Class

Do not confuse:

```text
Collection
```

with

```text
Collections
```

---

# Collection

```text
Interface
```

Hierarchy:

```text
Collection

├── List
├── Set
└── Queue
```

---

# Collections

```text
Utility Class
```

Contains:

```text
Static Methods
```

---

# Example

```java
Collections.sort(list);
```

---

# 10. Collections.sort()

Most used method.

---

# Example

```java
List<Integer> list =
      List.of(30,10,20);
```

---

```java
Collections.sort(list);
```

Output:

```text
10 20 30
```

---

# For Custom Objects

Uses:

```java
compareTo()
```

---

# Flow

```text
Collections.sort()

      │

      ▼

compareTo()

      │

      ▼

Sorted Order
```

---

# 11. Collections.max()

Returns largest element.

---

```java
List<Integer> list =
    List.of(10,50,20);
```

---

```java
Collections.max(list);
```

Output:

```text
50
```

---

# 12. Collections.min()

Returns smallest element.

---

```java
Collections.min(list);
```

Output:

```text
10
```

---

# 13. Collections.reverse()

Reverses order.

---

Before

```text
10 20 30
```

---

After

```java
Collections.reverse(list);
```

Result

```text
30 20 10
```

---

# 14. Collections.shuffle()

Random ordering.

---

Before

```text
10 20 30 40
```

---

After

```java
Collections.shuffle(list);
```

Possible Output

```text
30 10 40 20
```

---

# Real World Use

```text
Card Games

Quiz Apps

Random Questions
```

---

# 15. Collections.binarySearch()

Searches efficiently.

---

# Requirement

List must already be sorted.

---

```java
List<Integer> list =
    List.of(10,20,30,40,50);
```

---

```java
Collections.binarySearch(
    list,
    30
);
```

Output

```text
2
```

Index of 30.

---

# Complexity

```text
O(log n)
```

---

# Binary Search Flow

```text
Middle Element

      │

Found?
      │

 ┌────┴────┐
 │         │
Yes       No
 │         │
 ▼         ▼
Return   Search Half
```

---

# 16. Collections.frequency()

Counts occurrences.

---

```java
List<Integer> list =
    List.of(
       10,20,10,10,30
    );
```

---

```java
Collections.frequency(
      list,
      10
);
```

Output

```text
3
```

---

# 17. Unmodifiable Collections

Read-only collections.

---

```java
List<Integer> list =
    List.of(1,2,3);
```

---

```java
List<Integer> safe =
    Collections
      .unmodifiableList(list);
```

---

# Modification Attempt

```java
safe.add(4);
```

Throws:

```text
UnsupportedOperationException
```

---

# Use Case

Protect internal data.

---

# Example

```text
Bank Account Data

Configuration Data

API Responses
```

---

# 18. Empty Collections

Instead of:

```java
return null;
```

Use:

```java
return Collections.emptyList();
```

---

# Why?

Avoid:

```text
NullPointerException
```

---

# Example

Bad

```java
List<Student> getStudents()
{
    return null;
}
```

---

Good

```java
List<Student> getStudents()
{
    return Collections.emptyList();
}
```

---

# Client Code

```java
for(Student s:list)
{
}
```

Works safely.

---

# Complete Collections Utility Methods

| Method             | Purpose               |
| ------------------ | --------------------- |
| sort()             | Sort Data             |
| max()              | Largest Element       |
| min()              | Smallest Element      |
| reverse()          | Reverse Order         |
| shuffle()          | Random Order          |
| binarySearch()     | O(log n) Search       |
| frequency()        | Count Occurrences     |
| unmodifiableList() | Read Only Collection  |
| emptyList()        | Safe Empty Collection |

---

# Comparable vs Comparator

| Feature             | Comparable        | Comparator      |
| ------------------- | ----------------- | --------------- |
| Package             | java.lang         | java.util       |
| Method              | compareTo()       | compare()       |
| Location            | Inside Class      | Outside Class   |
| Sorting Rules       | One Natural Order | Multiple Orders |
| Modification Needed | Yes               | No              |
| Interview Usage     | Natural Ordering  | Custom Ordering |

---

# Quick Revision Sheet

```text
COMPARABLE

Defines Natural Ordering

Method

compareTo()

RETURN VALUES

Negative

Current Smaller

Positive

Current Greater

Zero

Equal

TREESET

Uses compareTo()

Not equals()

COLLECTIONS CLASS

sort()

max()

min()

reverse()

shuffle()

binarySearch()

frequency()

UNMODIFIABLE

Read Only Collection

EMPTY COLLECTIONS

Prefer emptyList()

Instead Of null

COMPARABLE

One Natural Order

COMPARATOR

Multiple Custom Orders
```
