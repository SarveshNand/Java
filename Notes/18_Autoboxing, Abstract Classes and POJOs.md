
---

# 1. Java Source File Architecture

## One Public Class Rule

Java allows multiple classes in a single source file, but:

✅ Only **one class can be public**

✅ The public class name must exactly match the filename

### Example

```java
// File Name: Demo.java

public class Demo {

    public static void main(String[] args) {
        System.out.println("Program Started");
    }
}

class Student {

}

class Employee {

}
```

Valid because:

```text
Filename  : Demo.java
Public Class : Demo
```

---

## Why Does Java Enforce This Rule?

### JVM Execution Flow

```text
User Runs Program
        │
        ▼
java Demo
        │
        ▼
JVM Searches Demo.class
        │
        ▼
Loads Demo Class
        │
        ▼
Looks for:

public static void main(String[] args)

        │
        ▼
Executes Program
```

---

## What If Multiple Public Classes Were Allowed?

Example:

```java
public class A {
    public static void main(String[] args){}
}

public class B {
    public static void main(String[] args){}
}
```

Problem:

```text
File Name = ?

A.java ?
B.java ?

Which class should JVM load first?

Ambiguity occurs.
```

Therefore Java restricts:

```text
1 File
   │
   └── 1 Public Class
```

---

## Interview Question

### Can a Java file contain multiple classes?

Yes.

Example:

```java
class A{}
class B{}
class C{}
```

Valid.

---

### Can a Java file contain multiple public classes?

No.

Compiler Error.

---

### Can a file have no public class?

Yes.

```java
class A{}
class B{}
```

Valid.

---

# 2. JVM Memory Model

Understanding Wrapper Classes becomes easy once memory is understood.

---

## Primitive Storage

```java
int x = 10;
```

Memory:

```text
Stack Memory

x
│
└── 10
```

Value stored directly.

---

## Object Storage

```java
Integer obj = new Integer(10);
```

Memory:

```text
Stack                 Heap

obj ───────────────► Integer Object
                          │
                          └── 10
```

Stack stores reference.

Heap stores actual object.

---

# 3. Wrapper Classes

## Why Wrapper Classes Exist

Collections can store only objects.

Example:

```java
ArrayList<int> list; // Invalid
```

Need:

```java
ArrayList<Integer> list;
```

Therefore Java provides wrappers.

---

## Primitive → Wrapper Mapping

| Primitive | Wrapper   |
| --------- | --------- |
| byte      | Byte      |
| short     | Short     |
| int       | Integer   |
| long      | Long      |
| float     | Float     |
| double    | Double    |
| char      | Character |
| boolean   | Boolean   |

---

## Memory Diagram

```text
Primitive

int x = 10

Stack
 └── 10
```

```text
Wrapper

Integer x = 10

Stack
  │
  ▼
Heap
 └── Integer Object(10)
```

---

# 4. Autoboxing

## Definition

Automatic conversion:

```text
Primitive
     │
     ▼
Wrapper Object
```

---

## Example

```java
int x = 100;

Integer y = x;
```

Compiler converts internally:

```java
Integer y = Integer.valueOf(x);
```

---

## Flowchart

```text
int x = 100
       │
       ▼
Compiler detects assignment
       │
       ▼
Integer.valueOf(100)
       │
       ▼
Integer Object Created
```

---

## Method Example

```java
void display(Integer n)
{
    System.out.println(n);
}

display(10);
```

Internally:

```java
display(Integer.valueOf(10));
```

---

# 5. Unboxing

## Definition

Wrapper Object → Primitive

---

## Example

```java
Integer a = 50;

int b = a;
```

Internally:

```java
int b = a.intValue();
```

---

## Flowchart

```text
Integer Object
      │
      ▼
intValue()
      │
      ▼
Primitive int
```

---

# 6. Complete Boxing-Unboxing Lifecycle

```text
Primitive Value

int x = 10

      │
      ▼
Autoboxing

Integer.valueOf(10)

      │
      ▼
Wrapper Object

Integer obj

      │
      ▼
Unboxing

obj.intValue()

      │
      ▼
Primitive int
```

---

# 7. Wrapper Classes in Arithmetic

Example:

```java
Integer a = 10;
Integer b = 20;

Integer c = a + b;
```

What happens internally?

```text
a.intValue()
+
b.intValue()

= 30

Integer.valueOf(30)
```

Flow:

```text
Integer
   │
   ▼
Unboxing

int + int

   │
   ▼
Result int

   │
   ▼
Autoboxing

Integer
```

---

# 8. Integer Cache Mechanism

Very important interview topic.

---

## Why Cache Exists

Creating objects repeatedly wastes memory.

Java stores commonly used integers.

Range:

```text
-128 to 127
```

---

## Example

```java
Integer a = 100;
Integer b = 100;

System.out.println(a == b);
```

Output:

```text
true
```

---

## Memory Diagram

```text
Integer Cache

100 Object
     ▲
     │
 a ──┘
 b ──┘
```

Both references point to same object.

---

## Example Outside Cache

```java
Integer a = 200;
Integer b = 200;

System.out.println(a == b);
```

Output:

```text
false
```

---

## Memory Diagram

```text
a ───► Integer(200)

b ───► Integer(200)
```

Different objects.

Different references.

---

# 9. == vs equals()

## == Operator

Compares:

```text
Memory Addresses
```

---

### Example

```java
Integer a = 200;
Integer b = 200;

System.out.println(a == b);
```

Output:

```text
false
```

---

## equals()

Compares:

```text
Actual Values
```

---

### Example

```java
Integer a = 200;
Integer b = 200;

System.out.println(a.equals(b));
```

Output:

```text
true
```

---

## Interview Rule

```text
Primitive → use ==

Objects → use equals()
```

---

# 10. Abstract Class

## Definition

A class that cannot be instantiated.

Used as a blueprint.

---

## Example

```java
abstract class Animal {

    abstract void sound();
}
```

Invalid:

```java
Animal a = new Animal();
```

Compiler Error.

---

## Why Abstract Classes Exist

Imagine:

```text
Animal
 ├── Dog
 ├── Cat
 └── Lion
```

Every animal has sound.

But sound differs.

Therefore parent provides contract.

---

# 11. Abstract Class Architecture

```text
           Animal
         (Abstract)
              │
    ┌─────────┼─────────┐
    ▼         ▼         ▼
   Dog       Cat      Lion
```

---

# 12. Abstract Method

Method without implementation.

```java
abstract void sound();
```

No body.

---

## Child Must Implement

```java
class Dog extends Animal {

    void sound() {
        System.out.println("Bark");
    }
}
```

---

# 13. Constructor in Abstract Class

Allowed.

Example:

```java
abstract class Animal {

    Animal() {
        System.out.println("Animal Constructor");
    }
}
```

---

## Execution Flow

```java
Dog d = new Dog();
```

Flow:

```text
Dog Object Creation
        │
        ▼
Animal Constructor
        │
        ▼
Dog Constructor
```

---

# 14. Can Abstract Class Be Final?

No.

Invalid:

```java
final abstract class Test
{
}
```

Reason:

```text
abstract → must inherit

final → cannot inherit
```

Contradiction.

---

# 15. Static Members in Abstract Class

Allowed.

```java
abstract class Test {

    static int count = 0;

    static void show() {
        System.out.println("Hello");
    }
}
```

Access:

```java
Test.show();
```

---

# 16. Private Methods in Abstract Class

Allowed.

```java
abstract class Test {

    private void helper() {

    }
}
```

---

## Can Private Method Be Abstract?

No.

Invalid:

```java
private abstract void test();
```

Reason:

```text
private → invisible to child

abstract → child must override
```

Impossible.

---

# 17. Final Methods in Abstract Class

Allowed.

```java
abstract class Test {

    final void display() {
        System.out.println("Fixed Logic");
    }
}
```

Child cannot override.

---

# 18. Abstract Class Without Abstract Method

Allowed.

Example:

```java
abstract class Utility {

    void display() {
        System.out.println("Hello");
    }
}
```

Purpose:

```text
Prevent Object Creation
```

---

# 19. POJO (Plain Old Java Object)

## Definition

Simple Java object used to represent data.

No framework dependency.

---

## Structure

```text
POJO

Fields
 +
Constructors
 +
Getters
 +
Setters
```

---

## Example

```java
public class Student {

    private int id;
    private String name;

    public Student() {

    }

    public Student(int id,String name) {
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }
}
```

---

# 20. POJO Memory Representation

```text
Student s

      │
      ▼

 ------------------
| id   = 101       |
| name = Rahul     |
 ------------------
```

---

# 21. Types of POJO Models

## Anemic Model

Contains only data.

```java
class Student {

    private String name;

    getter/setter
}
```

---

## Rich Domain Model

Contains data + business logic.

```java
class Student {

    private int attendance;

    void markAttendance() {
        attendance++;
    }
}
```

---

# 22. Interview Comparison Table

| Feature             | Primitive | Wrapper |
| ------------------- | --------- | ------- |
| Object              | No        | Yes     |
| Heap Memory         | No        | Yes     |
| Collections Support | No        | Yes     |
| Methods Available   | No        | Yes     |
| Faster              | Yes       | No      |

---

# 23. Abstract Class vs Interface

| Feature              | Abstract Class | Interface     |
| -------------------- | -------------- | ------------- |
| Constructor          | Yes            | No            |
| Instance Variables   | Yes            | No            |
| Multiple Inheritance | No             | Yes           |
| Abstract Methods     | Yes            | Yes           |
| Concrete Methods     | Yes            | Yes (Java 8+) |

---

# 24. Most Asked Interview Questions

### Q1. Why wrapper classes?

To treat primitive values as objects.

---

### Q2. What is autoboxing?

Automatic conversion:

```text
int → Integer
```

---

### Q3. What is unboxing?

Automatic conversion:

```text
Integer → int
```

---

### Q4. Why is Integer cache used?

To reduce memory consumption and improve performance.

---

### Q5. Integer cache range?

```text
-128 to 127
```

---

### Q6. Difference between == and equals()?

```text
==       → Reference Comparison

equals() → Value Comparison
```

---

### Q7. Can abstract class have constructor?

Yes.

---

### Q8. Can abstract class be final?

No.

---

### Q9. Can abstract class contain static methods?

Yes.

---

### Q10. Can abstract class have no abstract methods?

Yes.

---

# Final Revision Mind Map

```text
JAVA

├── Class Architecture
│     ├── One Public Class
│     ├── Filename Match
│     └── JVM Entry Point
│
├── Wrapper Classes
│     ├── Integer
│     ├── Double
│     ├── Character
│     ├── Boolean
│     └── Collections Support
│
├── Autoboxing
│     └── valueOf()
│
├── Unboxing
│     └── intValue()
│
├── Integer Cache
│     ├── -128
│     └── 127
│
├── Comparison
│     ├── ==
│     └── equals()
│
├── Abstract Class
│     ├── Constructor
│     ├── Static
│     ├── Final Method
│     ├── Private Method
│     └── Cannot Instantiate
│
└── POJO
      ├── Fields
      ├── Constructor
      ├── Getter
      ├── Setter
      └── Business Logic(Optional)
```