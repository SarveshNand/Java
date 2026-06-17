
---

# What is the Object Class?

The **Object class** is the root (topmost) class in Java.

Every class in Java directly or indirectly inherits from `Object`.

```java
class Student {
}
```

Compiler internally converts it to:

```java
class Student extends Object {
}
```

---

# Object Class Hierarchy

```text
                Object
                   |
        ---------------------
        |                   |
      Human              Animal
        |
     Student
```

Here:

```text
Student -> Human -> Object
```

Student indirectly inherits Object.

---

# Why Did Java Create Object Class?

Imagine if every class had completely different methods.

```java
Student
Employee
Teacher
Car
Laptop
```

There would be no common behavior.

So Java introduced:

```text
Object Class
```

which provides common methods to all objects.

Examples:

```java
toString()
equals()
hashCode()
getClass()
clone()
```

---

# Universal Parent Concept

Since every class extends Object:

```java
Student s = new Student();
```

can be stored as:

```java
Object obj = new Student();
```

This is called:

```text
Upcasting
Runtime Polymorphism
```

---

# Memory Visualization

```java
Object obj = new Student();
```

Memory:

```text
Stack
-----
obj
 |
 |
 v

Heap
----------------
Student Object
----------------
```

Reference Type:

```java
Object
```

Actual Object:

```java
Student
```

---

# Core Methods of Object Class

```text
1. toString()
2. equals()
3. hashCode()
4. getClass()
5. clone()
6. finalize() (Deprecated)
```

---

# 1. toString() Method

## Definition

Returns string representation of an object.

Signature:

```java
public String toString()
```

---

# Default Behavior

```java
class Student{
}
```

```java
Student s = new Student();

System.out.println(s);
```

Output:

```text
Student@36baf30c
```

Format:

```text
ClassName@HexadecimalHashCode
```

---

# Internally What Happens?

```java
System.out.println(s);
```

Java converts it to:

```java
System.out.println(s.toString());
```

Flow:

```text
println(object)
       |
       v
object.toString()
       |
       v
String Returned
       |
       v
Displayed
```

---

# Why Override toString()?

Default output is not meaningful.

Instead of:

```text
Student@36baf30c
```

Print:

```text
Rahul, 22
```

---

# Example

```java
class Student {

    String name;
    int age;

    Student(String name,int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString(){
        return name + ", " + age;
    }
}
```

Usage:

```java
Student s =
    new Student("Rahul",22);

System.out.println(s);
```

Output:

```text
Rahul, 22
```

---

# Interview Question

### Q: Why Override toString()?

Answer:

```text
To provide meaningful information
about object data instead of
ClassName@HashCode.
```

---

# 2. equals() Method

## Definition

Used to compare two objects.

Signature:

```java
public boolean equals(Object obj)
```

---

# Default Behavior

Internally:

```java
return (this == obj);
```

It compares:

```text
Memory Addresses
```

NOT values.

---

# Example

```java
Student s1 =
    new Student("Rahul",22);

Student s2 =
    new Student("Rahul",22);
```

Memory:

```text
s1 -----> Object A

s2 -----> Object B
```

Different objects.

---

```java
System.out.println(
    s1.equals(s2)
);
```

Output:

```text
false
```

because:

```text
Address A != Address B
```

---

# Memory Diagram

```text
Heap

+----------------+
| Rahul,22       |
+----------------+
      ^
      |
      |
     s1


+----------------+
| Rahul,22       |
+----------------+
      ^
      |
      |
     s2
```

Same values.

Different objects.

equals() returns:

```text
false
```

---

# Value-Based Comparison

Most business applications need:

```text
Compare Data
NOT Addresses
```

So override equals().

---

# Standard equals() Flow

```text
equals(obj)
    |
    |
    +--> Same Reference?
    |          |
    |          +--> true
    |
    +--> obj == null ?
    |          |
    |          +--> false
    |
    +--> Same Class?
    |          |
    |          +--> false
    |
    +--> Compare Fields
               |
               +--> true/false
```

---

# Proper equals() Implementation

```java
@Override
public boolean equals(Object obj){

    if(this == obj)
        return true;

    if(obj == null)
        return false;

    if(getClass() != obj.getClass())
        return false;

    Student other =
        (Student)obj;

    return age == other.age
            &&
           name.equals(other.name);
}
```

---

# Interview Tip

Always remember:

```text
1. this == obj

2. obj == null

3. getClass()

4. Typecast

5. Compare Fields
```

---

# 3. hashCode() Method

## Definition

Returns an integer hash value.

Signature:

```java
public int hashCode()
```

Used heavily in:

```java
HashMap
HashSet
Hashtable
LinkedHashMap
ConcurrentHashMap
```

---

# Why hashCode Exists?

Searching becomes faster.

Without hash:

```text
Linear Search
O(n)
```

With hash:

```text
Bucket Search
Approx O(1)
```

---

# Hashing Diagram

```text
Object
   |
hashCode()
   |
   v

Hash Value
   |
   v

Bucket Location
```

---

# Example

```java
Student s =
    new Student("Rahul",22);

System.out.println(
    s.hashCode()
);
```

Output:

```text
1254786
```

(Some integer)

---

# Equals-HashCode Contract

Most important interview rule.

## Rule

If:

```java
obj1.equals(obj2)
```

returns

```text
true
```

then:

```java
obj1.hashCode()
==
obj2.hashCode()
```

must also be true.

---

# Correct Relationship

```text
equals() == true
       |
       v
hashCode() MUST be same
```

---

# Wrong Situation

```text
equals() == true

hashCode() different
```

Breaks:

```java
HashSet
HashMap
```

behavior.

---

# Modern hashCode()

```java
@Override
public int hashCode() {
    return Objects.hash(
            name,
            age
    );
}
```

Recommended.

---

# Traditional Formula

```java
int result = 17;

result =
    31 * result + age;

result =
    31 * result +
    name.hashCode();
```

Prime numbers reduce collisions.

---

# HashMap Visualization

```text
HashMap

Bucket 0
Bucket 1
Bucket 2
Bucket 3
Bucket 4
```

Object:

```java
hashCode() = 4
```

Stored in:

```text
Bucket 4
```

Fast retrieval.

---

# 4. getClass() Method

## Definition

Returns runtime class information.

Signature:

```java
public final Class<?> getClass()
```

---

# Important

It is:

```java
final
```

Cannot override.

---

# Example

```java
Student s =
    new Student();

System.out.println(
    s.getClass()
);
```

Output:

```text
class Student
```

---

# Memory Flow

```text
Object
   |
getClass()
   |
   v
Runtime Class Info
```

---

# getClass() vs instanceof

## instanceof

Checks:

```text
Current Class
OR
Child Class
```

Example:

```java
obj instanceof Human
```

returns true if object is Human or Student.

---

## getClass()

Checks:

```text
Exact Runtime Class
```

Example:

```java
obj.getClass() == Human.class
```

Only true if object is exactly Human.

---

# Interview Difference

| Feature             | instanceof | getClass() |
| ------------------- | ---------- | ---------- |
| Child Class Allowed | Yes        | No         |
| Exact Type Check    | No         | Yes        |
| Runtime Information | Limited    | Full       |

---

# 5. clone() Method

## Definition

Creates copy of an object.

Signature:

```java
protected Object clone()
```

---

# Why Clone?

Instead of:

```java
Create New Object
Copy Fields Manually
```

Use:

```java
clone()
```

---

# Requirement

Class must implement:

```java
Cloneable
```

---

# Cloneable Interface

```java
interface Cloneable{
}
```

No methods.

Called:

```text
Marker Interface
```

---

# Marker Interface

Purpose:

```text
Marks a class with special behavior.
```

Examples:

```java
Cloneable
Serializable
Remote
```

---

# Clone Example

```java
class Student
implements Cloneable{

    int age = 22;

    @Override
    protected Object clone()
            throws CloneNotSupportedException {

        return super.clone();
    }
}
```

Usage:

```java
Student s1 =
    new Student();

Student s2 =
    (Student)s1.clone();
```

---

# Clone Memory Diagram

```text
Before

s1 -----> Object A


After

s1 -----> Object A

s2 -----> Object B
```

---

# Default Clone Type

```text
Shallow Copy
```

---

# Shallow Copy

Copies:

```text
Primitive Values
References
```

NOT nested objects.

---

# Deep Copy

Copies:

```text
Entire Object Graph
```

including nested objects.

---

# Interview Question

### clone() gives deep copy?

Answer:

```text
No.

By default clone() performs
shallow copy.
```

---

# 6. finalize() Method

## Definition

Method called before garbage collection.

Signature:

```java
protected void finalize()
```

---

# Old Flow

```text
Object Becomes Unreachable
          |
          v
finalize()
          |
          v
Garbage Collection
```

---

# Problem

Garbage Collector decides:

```text
When?
Whether?
How?
```

Not predictable.

---

# Current Status

```text
Deprecated
```

Avoid using.

---

# Objects vs Primitives

## Primitive Types

```java
int
long
float
double
char
byte
short
boolean
```

Not objects.

Do not inherit Object.

---

# Non-Primitive Types

```java
Array
Class Object
String
Collections
Wrapper Classes
```

All inherit Object.

---

# Wrapper Classes

Primitive:

```java
int age = 10;
```

Wrapper:

```java
Integer age = 10;
```

Wrapper classes are objects.

Inheritance:

```text
Integer
   |
 Number
   |
 Object
```

---

# Object Class Methods Summary

| Method     | Return Type | Default Behavior     | Override?  |
| ---------- | ----------- | -------------------- | ---------- |
| toString() | String      | ClassName@HashCode   | Yes        |
| equals()   | boolean     | Reference Comparison | Yes        |
| hashCode() | int         | Integer Hash         | Yes        |
| getClass() | Class       | Runtime Class        | No         |
| clone()    | Object      | Shallow Copy         | Yes        |
| finalize() | void        | Before GC            | Deprecated |

---

# Most Asked Interview Questions

### Q1. Which class is parent of every Java class?

```text
Object Class
```

---

### Q2. Can Object reference hold any object?

```java
Object obj = new Student();
```

Yes.

---

### Q3. What does println(object) call internally?

```java
object.toString()
```

---

### Q4. Difference between == and equals()?

```text
==      -> Address Comparison

equals  -> Logical Comparison
           (when overridden)
```

---

### Q5. If equals() returns true, what must happen?

```text
hashCode() must also be same.
```

---

### Q6. Can getClass() be overridden?

```text
No

It is final.
```

---

### Q7. Is clone() deep copy?

```text
No

Default clone() = Shallow Copy
```

---

### Q8. Why is finalize() avoided?

```text
Deprecated
Unpredictable
Performance Issues
```

---

# Quick Revision (1 Minute)

```text
Object Class

✓ Root class of Java

✓ Every class inherits Object

Core Methods

✓ toString()

✓ equals()

✓ hashCode()

✓ getClass()

✓ clone()

✓ finalize() (deprecated)

Important Rules

✓ equals true => hashCode same

✓ println(obj) => obj.toString()

✓ clone() => shallow copy

✓ getClass() => exact runtime class

✓ Object reference can store any object
```

# Interview One-Liner

"Object is the root class of Java. Every class directly or indirectly inherits from it and automatically gets common methods like toString(), equals(), hashCode(), getClass(), and clone(), which provide universal object behavior across the Java platform."
