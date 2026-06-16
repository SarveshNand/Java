
---

# 1. What are Nested Classes?

A Nested Class is simply:

```text
Class inside another class
```

## Basic Structure

```java
class Outer {

    class Inner {

    }
}
```

Here:

```text
Outer → Outer Class

Inner → Nested Class
```

---

# Why Do We Need Nested Classes?

Imagine:

```text
Car
 ├── Engine
 ├── GearBox
 └── Dashboard
```

The Engine is meaningful only inside a Car.

Instead of:

```java
class Engine {}
class Car {}
```

We can write:

```java
class Car {

    class Engine {

    }
}
```

This improves:

✅ Encapsulation

✅ Readability

✅ Logical Grouping

---

# Benefits of Nested Classes

## 1. Better Organization

Related classes stay together.

```text
Student
 └── Address
```

instead of

```text
Student.java
Address.java
```

---

## 2. Access to Private Members

Inner classes can access private data directly.

Example:

```java
class Outer {

    private int x = 10;

    class Inner {

        void show() {
            System.out.println(x);
        }
    }
}
```

Output:

```text
10
```

No getter required.

---

# Types of Nested Classes

```text
Nested Classes

├── Static Nested Class
│
└── Inner Class
     │
     ├── Regular Inner Class
     ├── Local Class
     └── Anonymous Class
```

---

# 2. Static Nested Class

## Definition

A nested class declared using:

```java
static class Inner
{
}
```

belongs to:

```text
Outer Class
NOT
Outer Object
```

---

# Architecture

```text
Outer Class
     │
     ▼
Static Nested Class
```

No object relationship exists.

---

## Example

```java
class Outer {

    static class Inner {

        void display() {
            System.out.println("Hello");
        }
    }
}
```

Instantiation:

```java
Outer.Inner obj =
        new Outer.Inner();
```

---

## Memory Diagram

```text
Outer Class
     │
     └────► Inner Class

No Outer Object Needed
```

---

# Why No Outer Object Required?

Because:

```text
Static Member
       │
Belongs To
       │
Class Level
```

Just like:

```java
Math.sqrt()
```

does not require:

```java
new Math()
```

---

# Static Nested Class Access Rules

## Can Access Static Members

```java
class Outer {

    static int x = 100;

    static class Inner {

        void show() {
            System.out.println(x);
        }
    }
}
```

Valid.

---

## Cannot Directly Access Instance Members

```java
class Outer {

    int x = 100;

    static class Inner {

        void show() {

            System.out.println(x);
        }
    }
}
```

Compilation Error.

---

## Why?

Because:

```text
Instance Variable
       │
Needs
       │
Outer Object
```

But static nested class has no outer object reference.

---

## Solution

```java
class Outer {

    int x = 100;

    static class Inner {

        void show(Outer obj) {

            System.out.println(obj.x);
        }
    }
}
```

---

# Real World Use Cases

## Builder Pattern

Example:

```java
User user =
    new User.Builder()
        .name("Rahul")
        .age(25)
        .build();
```

Builder is usually:

```java
static class Builder
```

---

## Helper Classes

```java
BankAccount
    └── InterestCalculator
```

---

# 3. Inner Class (Regular Non-Static)

## Definition

A nested class without static keyword.

```java
class Outer {

    class Inner {

    }
}
```

---

# Relationship

```text
Outer Object
      │
      ▼
Inner Object
```

Inner class belongs to an object.

---

# Instantiation Process

Step 1:

```java
Outer outer =
        new Outer();
```

Step 2:

```java
Outer.Inner inner =
        outer.new Inner();
```

---

# Flowchart

```text
Create Outer Object
         │
         ▼
outer = new Outer()
         │
         ▼
Create Inner Object
         │
         ▼
outer.new Inner()
```

---

# Memory Diagram

```text
Heap

Outer Object
     ▲
     │
Hidden Reference
     │
Inner Object
```

---

# Hidden Outer Reference

Internally Java creates something like:

```java
class Inner {

    Outer this$0;
}
```

Not visible to us.

---

# Why?

To allow inner class to access:

```text
Outer Variables
Outer Methods
Outer Private Members
```

---

# Example

```java
class Outer {

    private int x = 100;

    class Inner {

        void show() {
            System.out.println(x);
        }
    }
}
```

Output:

```text
100
```

Even though x is private.

---

# Variable Shadowing

## Problem

```java
class Outer {

    int x = 10;

    class Inner {

        int x = 20;

        void display() {

            System.out.println(x);
        }
    }
}
```

Output:

```text
20
```

Inner variable shadows outer variable.

---

## Access Outer Variable

```java
Outer.this.x
```

Example:

```java
void display() {

    System.out.println(x);
    System.out.println(Outer.this.x);
}
```

Output:

```text
20
10
```

---

# 4. Local Classes

## Definition

Class declared inside:

* Method
* Constructor
* Loop
* If Block

---

# Example

```java
class Outer {

    void show() {

        class Local {

            void display() {
                System.out.println("Hello");
            }
        }

        Local obj = new Local();
        obj.display();
    }
}
```

---

# Scope Diagram

```text
show()
{
      Local Class Exists
}
```

Outside method:

```java
Local obj;
```

Not allowed.

---

# Local Class Lifetime

```text
Method Starts
      │
      ▼
Local Class Created
      │
      ▼
Method Ends
```

Class visibility ends.

---

# Effectively Final Rule

Most Important Interview Topic

---

## Valid Example

```java
void display() {

    int x = 10;

    class Local {

        void show() {
            System.out.println(x);
        }
    }
}
```

Valid.

---

## Invalid Example

```java
void display() {

    int x = 10;

    x++;

    class Local {

        void show() {
            System.out.println(x);
        }
    }
}
```

Compilation Error.

---

# Why Does This Rule Exist?

Imagine:

```java
void test() {

    int x = 10;

    Local obj = new Local();

}
```

Method ends.

Stack memory disappears.

But Local object may still exist.

Java copies x inside object.

---

# JVM Concept

```text
Method Variable x
        │
        ▼
Copied Into
        │
        ▼
Local Class Object
```

If x changes later:

```text
Original x = 20

Copied x = 10
```

Confusion occurs.

Hence:

```text
Final
or
Effectively Final
```

Required.

---

# 5. Anonymous Classes

## Definition

Class without a name.

Created and instantiated simultaneously.

---

# Traditional Approach

```java
class Guest extends Person {

    @Override
    void introduce() {

        System.out.println("Guest");
    }
}
```

Then:

```java
Guest g = new Guest();
```

---

# Anonymous Class Approach

```java
Person p =
    new Person() {

        @Override
        void introduce() {

            System.out.println("Guest");
        }
    };
```

---

# Flow

```text
Create Class
      +
Create Object
      +
Override Method

In One Statement
```

---

# Memory Diagram

```text
Person Reference
       │
       ▼
Anonymous Object
```

No class name visible.

---

# Why Use Anonymous Classes?

Useful when:

```text
Need object only once
```

Example:

* Button click handlers
* Event listeners
* Temporary behavior changes

---

# Anonymous Class Restrictions

## Cannot Declare Constructor

Invalid:

```java
new Person() {

    Person() {

    }
};
```

Reason:

```text
No Class Name
```

Constructor name must match class name.

---

# Cannot Create Another Object

```java
new AnonymousClass();
```

Impossible.

No name exists.

---

# New Methods Can't Be Called

Example:

```java
Person p =
    new Person() {

        void test() {
            System.out.println("test");
        }
    };
```

Not allowed:

```java
p.test();
```

Compiler Error.

---

# Why?

Reference type:

```java
Person
```

Compiler only knows Person methods.

---

# Anonymous Class vs Lambda

Before Java 8:

```java
new Runnable() {

    public void run() {

    }
};
```

After Java 8:

```java
() -> {

}
```

Lambda is cleaner.

---

# Complete Nested Class Hierarchy

```text
Nested Classes

│
├── Static Nested
│     │
│     └── Class Level
│
└── Inner Classes
      │
      ├── Regular Inner
      │
      ├── Local Class
      │
      └── Anonymous Class
```

---

# Comparison Table

| Feature                    | Static Nested   | Inner           | Local | Anonymous      |
| -------------------------- | --------------- | --------------- | ----- | -------------- |
| Outer Object Needed        | No              | Yes             | Yes   | Yes            |
| Has Name                   | Yes             | Yes             | Yes   | No             |
| Can Access Private Members | Yes             | Yes             | Yes   | Yes            |
| Can Have Constructor       | Yes             | Yes             | Yes   | No             |
| Scope                      | Class           | Class           | Block | Expression     |
| Common Usage               | Builder Pattern | Object Coupling | Rare  | Event Handling |

---

# Interview Questions

## Q1. Difference between Static Nested and Inner Class?

### Static Nested

```text
Belongs to Class
```

### Inner Class

```text
Belongs to Object
```

---

## Q2. Can Static Nested Class Access Instance Variables?

No.

Needs outer object reference.

---

## Q3. Why Can Inner Class Access Private Members?

Because it is part of the same enclosing class scope.

---

## Q4. What Hidden Reference Exists in Inner Class?

```java
Outer this$0
```

Generated internally by JVM.

---

## Q5. What is Effectively Final?

Variable value never changes after initialization.

---

## Q6. Why Anonymous Classes Have No Constructor?

No class name exists.

Constructor requires class name.

---

## Q7. Anonymous Class vs Lambda?

```text
Anonymous Class
      │
Can extend class
Can implement interface

Lambda
      │
Only Functional Interface
```

---

# Final Revision Mind Map

```text
NESTED CLASSES

├── Static Nested
│     ├── No Outer Object
│     ├── Access Static Members
│     └── Builder Pattern
│
├── Inner Class
│     ├── Needs Outer Object
│     ├── Hidden Outer Reference
│     └── Access Private Members
│
├── Local Class
│     ├── Inside Method
│     ├── Block Scope
│     └── Effectively Final Rule
│
└── Anonymous Class
      ├── No Name
      ├── One-Time Use
      ├── No Constructor
      └── Replaced By Lambdas Often
```
