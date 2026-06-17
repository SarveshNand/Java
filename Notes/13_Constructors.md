# Java Constructors & this Keyword

---

# Table of Contents

1. Instance Variables vs Local Variables
2. Default Values in Java
3. What is a Constructor?
4. Constructor Rules
5. Default Constructor
6. User Defined Constructor
7. Parameterized Constructor
8. Why Constructors are Needed
9. Constructor Internals
10. The `this` Keyword
11. Variable Shadowing Problem
12. Constructor Overloading
13. Constructor Chaining
14. Object Creation Internals
15. Memory Diagrams
16. Common Mistakes
17. Interview Questions
18. Quick Revision Sheet

---

# 1. Instance Variables vs Local Variables

Before understanding constructors, understand where variables live.

---

# Instance Variables

Declared inside a class but outside methods.

```java
class Student
{
    String name;
    int age;
}
```

---

These belong to:

```text
Object
```

---

Memory Location:

```text
Heap Memory
```

---

Visualization

```text
Student Object

+-------------+
| name        |
| age         |
+-------------+
```

---

# Local Variables

Declared inside methods.

```java
void display()
{
    int x = 10;
}
```

---

Memory Location:

```text
Stack Memory
```

---

Visualization

```text
Stack Frame

+------+
| x=10 |
+------+
```

---

# Major Difference

| Feature | Instance Variable | Local Variable |
|-----------|-----------|-----------|
| Location | Heap | Stack |
| Default Value | Yes | No |
| Lifetime | Object Lifetime | Method Lifetime |
| Scope | Entire Object | Inside Method |

---

# Interview Question

Which variables get default values?

✅ Instance Variables

❌ Local Variables

---

# Example

```java
class Test
{
    int x;

    void show()
    {
        int y;

        System.out.println(x);
        System.out.println(y);
    }
}
```

Output:

```text
Compile Error
```

Because:

```java
y
```

is uninitialized.

---

# 2. Default Values in Java

When an object is created, JVM automatically initializes fields.

---

# Integer Types

```java
int x;
```

Default:

```text
0
```

---

# Floating Point

```java
double d;
```

Default:

```text
0.0
```

---

# Boolean

```java
boolean flag;
```

Default:

```text
false
```

---

# Character

```java
char ch;
```

Default:

```text
'\u0000'
```

(NUL Character)

---

# Objects & Strings

```java
String name;
```

Default:

```text
null
```

---

# What is null?

Represents:

```text
No Object
No Address
Nothing
```

---

Visualization

```text
name

↓

null
```

No object exists.

---

# 3. What is a Constructor?

---

# Definition

A constructor is a special member of a class used to:

```text
Create
Initialize
Prepare
```

an object.

---

Think:

```text
Constructor
=
Object Setup Function
```

---

# Real Life Example

When a new student joins college:

```text
Name
Age
Roll Number
```

must be assigned.

Constructor performs this setup.

---

# Flowchart

```text
Object Created
      |
      ▼
Constructor Called
      |
      ▼
Variables Initialized
      |
      ▼
Object Ready
```

---

# 4. Constructor Rules

---

# Rule 1

Constructor name must be same as class name.

---

Correct

```java
class Student
{
    Student()
    {
    }
}
```

---

Wrong

```java
class Student
{
    Demo()
    {
    }
}
```

---

# Rule 2

No Return Type

---

Wrong

```java
void Student()
{
}
```

---

Wrong

```java
int Student()
{
}
```

---

Correct

```java
Student()
{
}
```

---

# Rule 3

Called Automatically

You never call it directly.

JVM calls it.

---

# Rule 4

Used for Initialization

Example:

```java
name="Unknown";
age=18;
```

---

# 5. Default Constructor

---

If you do not write any constructor:

```java
class Student
{
    String name;
}
```

Java automatically creates:

```java
Student()
{
}
```

behind the scenes.

---

This is called:

```text
Default Constructor
```

---

# Internal Version

Compiler behaves as if:

```java
Student()
{
    super();
}
```

exists.

---

# Example

```java
Student s1 = new Student();
```

Output values:

```text
name = null
```

because JVM assigns default values.

---

# Important Rule

As soon as you write:

```java
Student(int age)
{
}
```

Java removes:

```text
Automatic Default Constructor
```

---

# Interview Question

Why does this fail?

```java
Student s1 = new Student();
```

when only:

```java
Student(int age)
{
}
```

exists?

Answer:

```text
Default constructor no longer exists.
```

---

# 6. User Defined Constructor

---

Example

```java
class Student
{
    Student()
    {
        System.out.println("Object Created");
    }
}
```

---

Execution

```java
Student s1 = new Student();
```

Output

```text
Object Created
```

---

# Flow

```text
new Student()
      |
      ▼
Allocate Memory
      |
      ▼
Call Constructor
      |
      ▼
Execute Constructor Body
```

---

# 7. Parameterized Constructor

---

# Problem

Without constructor:

```java
Student s1 = new Student();

s1.name="Aditya";
s1.age=20;
```

Repeated many times.

---

# Better Approach

```java
Student(String n,int a)
{
    name=n;
    age=a;
}
```

---

Object Creation

```java
Student s1 =
new Student("Aditya",20);
```

---

Visualization

```text
Arguments

"Aditya"
20

      ↓

Constructor

name=n
age=a
```

---

# Example

```java
class Student
{
    String name;
    int age;

    Student(String n,int a)
    {
        name=n;
        age=a;
    }
}
```

---

Output

```java
Student s1 =
new Student("Aditya",20);
```

Object:

```text
name = Aditya
age = 20
```

---

# 8. Why Constructors Matter

Without constructor:

```java
Student s1 = new Student();

s1.name="A";
s1.age=20;
```

---

With constructor:

```java
Student s1 =
new Student("A",20);
```

---

Advantages

✅ Cleaner Code

✅ Less Repetition

✅ Better Readability

✅ Object Always Initialized

---

# 9. Constructor Internals

---

Statement

```java
Student s1 =
new Student("Aditya",20);
```

actually performs:

---

Step 1

Create Reference Variable

```text
s1
```

---

Step 2

Allocate Heap Memory

```text
new
```

---

Step 3

Call Constructor

```text
Student(...)
```

---

Step 4

Store Returned Address

```text
s1 = address
```

---

# Internal Flowchart

```text
new Student()
      |
      ▼
Allocate Heap Memory
      |
      ▼
Assign Default Values
      |
      ▼
Execute Constructor
      |
      ▼
Return Address
      |
      ▼
Store in Reference Variable
```

---

# 10. The this Keyword

Most Important Constructor Topic

---

# Definition

`this`

refers to:

```text
Current Object
```

---

Example

```java
Student s1 =
new Student();
```

Inside constructor:

```java
this
```

means:

```text
s1 object
```

---

Visualization

```text
this
  |
  ▼

Current Object
```

---

# 11. Variable Shadowing Problem

---

Example

```java
class Student
{
    String name;

    Student(String name)
    {
        name = name;
    }
}
```

---

Looks correct?

❌ No

---

Reason

Parameter:

```java
name
```

hides instance variable:

```java
name
```

---

Compiler sees:

```java
parameter = parameter;
```

---

Object field remains:

```text
null
```

---

# Solution

```java
this.name = name;
```

---

Meaning

```text
this.name
```

↓

Instance Variable

---

```text
name
```

↓

Parameter

---

Visualization

```text
Current Object Name
         ▲
         |
this.name=name
         |
         ▼
 Constructor Parameter
```

---

# Example

```java
class Student
{
    String name;

    Student(String name)
    {
        this.name=name;
    }
}
```

---

Now works correctly.

---

# Professional Standard

Always prefer:

```java
this.field = field;
```

---

# 12. Constructor Overloading

Just like methods.

---

Example

```java
Student()
{
}
```

```java
Student(String name)
{
}
```

```java
Student(String name,int age)
{
}
```

---

Allowed because:

```text
Different Parameters
```

---

Benefits

Different ways to create objects.

---

Examples

```java
new Student();
```

```java
new Student("Aditya");
```

```java
new Student("Aditya",20);
```

---

# 13. Constructor Chaining

---

# Definition

Calling one constructor from another constructor.

---

Keyword Used

```java
this(...)
```

---

Example

```java
Student()
{
    this("Unknown");
}
```

---

```java
Student(String name)
{
    this(name,18);
}
```

---

```java
Student(String name,int age)
{
    this.name=name;
    this.age=age;
}
```

---

# Flow

```text
Student()

      |
      ▼

Student(String)

      |
      ▼

Student(String,int)
```

---

# Execution Order

```text
Largest Constructor Executes First
```

then returns upward.

---

# Visualization

```text
Constructor A
      |
      ▼
Constructor B
      |
      ▼
Constructor C
```

Then:

```text
C finishes
↑
B finishes
↑
A finishes
```

---

# Important Rule

Must be first statement.

---

Correct

```java
Student()
{
    this("A");
}
```

---

Wrong

```java
Student()
{
    System.out.println("Hello");

    this("A");
}
```

Compile Error.

---

# Why Chaining?

Without Chaining

```java
Repeated Initialization
Repeated Code
```

---

With Chaining

```java
Single Initialization Logic
```

Cleaner and maintainable.

---

# 14. Memory Diagram

---

Example

```java
Student s1 =
new Student("Aditya",20);
```

---

Stack

```text
+------------+
| s1=1000    |
+------------+
```

---

Heap

```text
Address 1000

+------------------+
| name = Aditya    |
| age  = 20        |
+------------------+
```

---

Inside Constructor

```text
this
 |
 ▼

Current Object
```

---

# 15. Common Mistakes

---

# Mistake 1

Adding return type

```java
void Student()
{
}
```

Not a constructor.

It becomes a method.

---

# Mistake 2

Wrong name

```java
Demo()
{
}
```

inside Student class.

Not constructor.

---

# Mistake 3

Forgetting this

```java
name=name;
```

No assignment occurs.

---

# Mistake 4

Calling constructor manually

```java
s1.Student();
```

Illegal.

---

# Mistake 5

Using this() not first

Compile Error.

---

# 16. Runtime Memory Issue

---

What if heap is full?

```java
new Student();
```

cannot allocate memory.

---

JVM throws:

```text
OutOfMemoryError
```

---

Important:

```text
Error
```

not normal exception.

---

# 17. Interview Questions

---

## Q1. What is a constructor?

Special member used to initialize objects.

---

## Q2. Can constructors return values?

No.

Not even void.

---

## Q3. When is constructor called?

Automatically during object creation.

---

## Q4. Can constructor be overloaded?

Yes.

---

## Q5. Can constructor be inherited?

No.

---

## Q6. What is this?

Reference to current object.

---

## Q7. Why use this?

Resolve variable shadowing and access current object.

---

## Q8. Can we call constructor manually?

No.

---

## Q9. Difference between constructor and method?

| Constructor | Method |
|------------|---------|
| Same name as class | Any valid name |
| No return type | Has return type/void |
| Auto-called | Manually called |
| Initializes object | Performs operations |

---

## Q10. What happens if no constructor exists?

Compiler provides default constructor.

---

# Quick Revision Sheet

```text
INSTANCE VARIABLE
=================
Stored in Object

LOCAL VARIABLE
==============
Stored in Stack

DEFAULT VALUES
==============
int      -> 0
double   -> 0.0
boolean  -> false
String   -> null

CONSTRUCTOR
===========
Special member

RULES
=====
Same Name As Class
No Return Type
Auto Called

DEFAULT CONSTRUCTOR
===================
Compiler Provides

PARAMETERIZED
=============
Accepts Inputs

THIS
====
Current Object

this.x=x
========
Field = Parameter

OVERLOADING
===========
Multiple Constructors

CHAINING
========
this()

FIRST STATEMENT ONLY
```

---

# Memory Trick

```text
CLASS
=====
Blueprint

OBJECT
======
Real Entity

CONSTRUCTOR
===========
Setup Function

THIS
====
Current Object

DEFAULT
=======
Compiler Gives

PARAMETERIZED
=============
Developer Gives

CHAINING
========
One Constructor
Calls Another
```

---

# Constructor Formula

```text
new Student(...)
        |
        ▼
Allocate Memory
        |
        ▼
Default Initialization
        |
        ▼
Constructor Executes
        |
        ▼
Object Ready
```

---
