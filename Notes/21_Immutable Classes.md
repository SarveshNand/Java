# Definition

An **Immutable Class** is a class whose object state **cannot be changed after it is created**.

Once an object is initialized:

✅ Values cannot be modified  
✅ Internal state remains constant  
✅ Thread-safe by design  
✅ No synchronization required


# Real-Life Example

Think of an **Aadhaar Number**.

Once issued:

- You can read it.
- You can use it.
- You cannot modify it.

Immutable objects behave similarly.

```java
String name = "Rahul";
```

After creation, the String object itself never changes.

```java
name = "Amit";
```

A new String object is created.

---

# Why Do We Need Immutable Classes?

## Problem in Multi-Threading

Suppose multiple threads access the same object.

### Mutable Object

```text
Thread-1 -----> Change age to 25
                    |
                    |
Shared Object ------|
                    |
                    |
Thread-2 -----> Change age to 30
```

Result:

```text
Race Condition
Inconsistent Data
Unexpected Results
```

---

### Immutable Object

```text
Thread-1 -----> Read Object
                    |
                    |
Immutable Object ---|
                    |
                    |
Thread-2 -----> Read Object
```

Nobody can modify it.

Result:

```text
Safe
Predictable
Thread-Safe
```

---

# Characteristics of Immutable Class

An immutable object:

- Cannot change state after creation
- Has no setters
- Fields are final
- Fields are private
- Class is usually final
- Uses defensive copying for mutable references

---

# Rules to Create an Immutable Class

## Rule 1: Make Class Final

### Why?

Prevents inheritance.

Without final:

```java
class Student {
}
```

Someone can extend it:

```java
class HackerStudent extends Student {
}
```

They may add methods that modify state.

### Correct

```java
public final class Student {
}
```

---

## Rule 2: Make Variables Private

### Why?

Hide direct access.

Wrong:

```java
public int age;
```

Anyone can change it.

```java
student.age = 50;
```

Correct:

```java
private int age;
```

---

## Rule 3: Make Variables Final

### Why?

Can be assigned only once.

```java
private final int age;
```

After constructor:

❌ Cannot reassign

```java
age = 40;
```

Compiler Error

---

## Rule 4: Initialize Through Constructor

```java
public Student(int age,String name){
    this.age=age;
    this.name=name;
}
```

Object receives all values during creation.

---

## Rule 5: No Setter Methods

Wrong:

```java
public void setAge(int age){
    this.age=age;
}
```

This makes class mutable.

Correct:

```java
No setters
```

---

## Rule 6: Provide Only Getters

```java
public int getAge(){
    return age;
}
```

Reading data is safe.

---

# Basic Immutable Class

```java
public final class Student {

    private final int age;
    private final String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
```

---

# Creation Flow

```text
Object Creation
      |
      v
Constructor Called
      |
      v
Variables Initialized
      |
      v
Object Ready
      |
      v
No Modification Allowed
```

---

# Interview Question

## Is This Class Immutable?

```java
public final class Student {

    private final String name;

    public Student(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
}
```

### Answer

YES

Because:

- Class is final
- Variable is private
- Variable is final
- No setter

---

# Challenge: Reference Variables

Primitive variables are easy.

```java
private final int age;
```

But what about:

```java
private final College college;
```

Now things become tricky.

---

# Important Concept

## final Reference ≠ Immutable Object

```java
private final College college;
```

What is final here?

```text
college reference
```

What is NOT final?

```text
Object data inside College
```

Example:

```java
college.setName("ABC");
```

Still possible.

---

# Memory Diagram

## Case 1: Shallow Copy

```java
Student s1 = new Student(college);
```

Constructor:

```java
this.college = college;
```

Memory:

```text
Heap

+------------------+
| College Object   |
| Name = XYZ       |
+------------------+
       ^
       |
       |
 college
       |
       |
this.college
```

Both point to SAME object.

---

Now:

```java
college.setName("IIT");
```

Memory:

```text
Heap

+------------------+
| College Object   |
| Name = IIT       |
+------------------+
```

Student object changed indirectly.

Not immutable.

---

# Why Shallow Copy Fails

Because:

```text
Reference copied
Object NOT copied
```

Flow:

```text
Original Object
      |
      v
Reference Passed
      |
      v
Same Reference Stored
      |
      v
External Modification Possible
      |
      v
Immutability Broken
```

---

# Solution: Defensive Copying

Also called:

```text
Deep Copy
Protective Copy
Defensive Copy
```

Idea:

```text
Never trust external references
Create your own copy
```

---

# Deep Copy in Constructor

Instead of:

```java
this.college = college;
```

Use:

```java
this.college =
    new College(
        college.getName(),
        college.getAddress()
    );
```

---

# Memory Diagram

## Deep Copy Constructor

```text
External College
      |
      v

+----------------+
| Name = XYZ     |
+----------------+

      |
      | Copy Data
      v

+----------------+
| Name = XYZ     |
+----------------+

Student Own Copy
```

Now:

```java
college.setName("IIT");
```

Only external object changes.

Student remains safe.

---

# Getter Problem

Many developers protect constructor but forget getter.

Wrong:

```java
public College getCollege(){
    return college;
}
```

Danger:

```java
College c = student.getCollege();

c.setName("MIT");
```

Internal object modified.

---

# Getter Memory Diagram

```text
Student
   |
   v

+------------------+
| College Object   |
+------------------+
         ^
         |
         |
Returned Reference
```

Same object exposed.

Immutability broken.

---

# Defensive Copy in Getter

Correct:

```java
public College getCollege(){

    return new College(
        college.getName(),
        college.getAddress()
    );
}
```

---

# Safe Getter Flow

```text
Internal Object
      |
      v
Create New Copy
      |
      v
Return Copy
      |
      v
Caller Modifies Copy
      |
      v
Original Object Safe
```

---

# Complete Immutable Class with Mutable Reference

## College Class (Mutable)

```java
public class College {

    private String name;
    private String address;

    public College(String name,String address){
        this.name=name;
        this.address=address;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setAddress(String address){
        this.address=address;
    }
}
```

---

## Immutable Student Class

```java
public final class Student {

    private final int age;
    private final String name;
    private final College college;

    public Student(
            int age,
            String name,
            College college) {

        this.age = age;
        this.name = name;

        this.college =
            new College(
                college.getName(),
                college.getAddress()
            );
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public College getCollege() {

        return new College(
            college.getName(),
            college.getAddress()
        );
    }
}
```

---

# Execution Example

```java
College c1 =
    new College(
        "ABC College",
        "Delhi"
    );

Student s1 =
    new Student(
        22,
        "Rahul",
        c1
    );
```

---

### Change Original Object

```java
c1.setName("XYZ College");
```

Student still contains:

```text
ABC College
```

Because deep copy exists.

---

### Change Getter Object

```java
College temp =
    s1.getCollege();

temp.setName("MIT");
```

Student still contains:

```text
ABC College
```

Because getter returned copy.

---

# Deep Copy vs Shallow Copy

| Feature | Shallow Copy | Deep Copy |
|----------|-------------|------------|
| Object Created | No | Yes |
| Reference Copied | Yes | No |
| Memory Address | Same | Different |
| External Changes Affect Original | Yes | No |
| Suitable for Immutable Class | No | Yes |
| Performance | Faster | Slightly Slower |
| Safety | Low | High |

---

# Visualization

## Shallow Copy

```text
A --------+
          |
          v
     +---------+
     | Object  |
     +---------+
          ^
          |
B --------+
```

Same object.

---

## Deep Copy

```text
A -----> Object-1

B -----> Object-2
```

Different objects.

---

# Immutable Objects in Java Library

Popular examples:

```java
String
Integer
Long
Double
Boolean
BigInteger
BigDecimal
LocalDate
LocalTime
LocalDateTime
UUID
```

---

# Advantages of Immutable Classes

## 1. Thread Safe

No synchronization needed.

```text
Multiple Threads
      |
      v
Read Only Object
      |
      v
Safe
```

---

## 2. Easier Debugging

State never changes.

---

## 3. Secure

Data cannot be tampered with.

---

## 4. Cache Friendly

Objects can be reused safely.

---

## 5. Reliable Hashing

Useful in:

```java
HashMap
HashSet
ConcurrentHashMap
```

---

# Disadvantages

## More Objects Created

Every modification requires a new object.

```java
String s = "A";
s = s + "B";
```

New object created.

---

## Higher Memory Usage

Extra copies consume memory.

---

# Most Asked Interview Questions

### Q1. What is an Immutable Class?

A class whose object state cannot be modified after creation.

---

### Q2. Why is String Immutable?

Security, caching, thread safety, and performance reasons.

---

### Q3. Is final Class Automatically Immutable?

No.

```java
final class Student {
    int age;
}
```

Still mutable.

---

### Q4. Is final Variable Immutable?

No.

```java
final College college;
```

Reference is fixed.

Object data can still change.

---

### Q5. What Breaks Immutability Most Often?

Returning mutable references from getters.

---

### Q6. What is Defensive Copying?

Creating a new object instead of exposing internal mutable objects.

---

### Q7. Difference Between final and Immutable?

| final | Immutable |
|---------|-----------|
| Prevents reassignment | Prevents state change |
| Language keyword | Design concept |
| Reference fixed | Object fixed |

---

# Quick Revision (30 Seconds)

```text
Immutable Class Checklist

✓ Class final

✓ Fields private

✓ Fields final

✓ Constructor initialization

✓ No setters

✓ Only getters

✓ Defensive copy in constructor

✓ Defensive copy in getter

✓ Never expose mutable references
```

# Interview One-Liner

"An immutable class is a class whose state cannot be modified after object creation. To create one, make the class final, fields private and final, initialize them through the constructor, avoid setters, and use defensive copying for mutable reference objects."