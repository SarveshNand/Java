# Java Abstraction and Polymorphism Notes

---

# Table of Contents

1. Understanding Abstraction
2. Real-World Examples
3. Abstraction in Programming
4. Levels of Abstraction in Java
5. Abstract Classes
6. Abstract Methods
7. Interfaces
8. Interface vs Abstract Class
9. Polymorphism
10. Compile-Time Polymorphism
11. Runtime Polymorphism
12. Method Overriding Rules
13. Keyword Behavior in Polymorphism
14. Abstraction vs Encapsulation
15. Interview Questions
16. Quick Revision Sheet

---

# 1. Understanding Abstraction

## Definition

**Abstraction** means:

> Showing only the essential information and hiding unnecessary implementation details.

It focuses on:

```text
WHAT something does
```

instead of:

```text
HOW something does it
```

---

# Real-Life Examples

---

# Example 1: Car

When driving a car, we use:

```text
Steering
Brake
Accelerator
Gear
```

We do not need to know:

```text
Engine design
Fuel injection
Thousands of internal components
```

---

## Abstraction View

```text
          User

            |
            |

   +----------------+
   |     Car        |
   +----------------+

   start()
   brake()
   accelerate()

            |
            |

 Hidden Internal Logic
 Engine
 Transmission
 Sensors
```

---

# Example 2: ATM Machine

User sees:

```text
Withdraw
Deposit
Check Balance
```

Hidden:

```text
Database connection
Cash counting mechanism
Bank verification
Security logic
```

---

# Abstraction in Programming

OOP does not represent every detail of real life.

It represents only the required features.

Example:

A Student object:

```java
class Student {

    String name;
    int rollNumber;

    void attendClass(){

    }
}
```

We don't represent:

```text
Student breathing
Student walking
Student thinking
```

because the application does not need it.

---

# 2. Levels of Abstraction in Java

Java provides two levels:

---

# Level 1: Low-Level Abstraction

Achieved by hiding implementation details.

Example:

```java
car.start();
```

User only knows:

```text
Car starts
```

They don't see:

```text
Engine ignition logic
Fuel system
Battery logic
```

---

# Level 2: High-Level Abstraction

Separates:

```text
WHAT
```

from:

```text
HOW
```

Using:

1. Abstract Classes
2. Interfaces

---

# 3. Abstract Classes

## Definition

An abstract class is a partial blueprint.

It contains:

* Abstract methods
* Normal methods

---

## Syntax

```java
abstract class ClassName {

}
```

---

# Abstract Method

A method without body.

Example:

```java
abstract void accelerate();
```

Only tells:

```text
WHAT should happen
```

Child decides:

```text
HOW it happens
```

---

# Rules of Abstract Class

## Rule 1

If a class contains abstract methods:

```java
abstract void run();
```

Then class must be:

```java
abstract class Animal
```

---

## Rule 2

Object creation is not allowed.

Invalid:

```java
Animal a = new Animal();
```

Reason:

Abstract class is incomplete.

---

## Rule 3

Child must implement abstract methods.

---

# Abstract Class Example

```java
abstract class Car {


    void start(){

        System.out.println("Car Started");

    }


    abstract void accelerate();

    abstract void brake();

}
```

---

Child Class:

```java
class ElectricCar extends Car {


    void accelerate(){

        System.out.println("Electric motor acceleration");

    }


    void brake(){

        System.out.println("Regenerative braking");

    }

}
```

---

# Execution Flow

```text
          Car
           |
           |
   ----------------
   |              |
start()      abstract methods

           |
           |

     ElectricCar

implements:

accelerate()
brake()
```

---

# 4. Interfaces

## Definition

An interface is a contract.

It defines:

```text
What capability an object must have
```

---

Examples:

```text
Flyable
Runnable
Payable
Printable
```

---

# Interface Syntax

```java
interface Flyable {

    void fly();

}
```

---

# Implementation

```java
class Aeroplane implements Flyable {


    public void fly(){

        System.out.println("Flying using engine");

    }

}
```

---

Another Implementation:

```java
class Bird implements Flyable {


    public void fly(){

        System.out.println("Flying using wings");

    }

}
```

---

# Interface Flow

```text
          Flyable

             |
     -----------------

     |               |

Aeroplane          Bird

fly()              fly()
```

Same capability.

Different implementation.

---

# 5. Abstract Class vs Interface

| Abstract Class          | Interface                    |
| ----------------------- | ---------------------------- |
| Partial abstraction     | Full abstraction             |
| Can have normal methods | Mostly abstract methods      |
| Uses `extends`          | Uses `implements`            |
| One parent class        | Multiple interfaces possible |
| Has constructors        | No constructors              |

---

# Multiple Inheritance

Java does not allow:

```java
class C extends A,B
```

But allows:

```java
class C implements A,B
```

with interfaces.

---

# 6. Polymorphism

## Definition

Polymorphism means:

```text
Many Forms
```

One action behaves differently depending on situation.

---

Example:

```text
run()

Human:
Running on two legs

Dog:
Running on four legs
```

Same method.

Different behavior.

---

# Types of Polymorphism

Java supports:

1. Compile-Time Polymorphism
2. Runtime Polymorphism

---

# 7. Compile-Time Polymorphism

Also called:

```text
Static Polymorphism
```

Achieved using:

```text
Method Overloading
```

---

# Method Overloading

Same method name:

Different parameters.

---

Example:

```java
class Runner {


    void run(){

        System.out.println("Normal speed");

    }


    void run(boolean scared){

        System.out.println("Fast speed");

    }

}
```

---

Compiler decides:

```text
run()
     |
     |
compile time decision


run(true)
     |
     |
compile time decision
```

---

# 8. Runtime Polymorphism

Also called:

```text
Dynamic Polymorphism
```

Achieved using:

```text
Method Overriding
```

---

# Example

Parent:

```java
abstract class Animal {

    abstract void run();

}
```

---

Child 1:

```java
class Dog extends Animal {


    void run(){

        System.out.println("Dog running");

    }

}
```

---

Child 2:

```java
class Human extends Animal {


    void run(){

        System.out.println("Human running");

    }

}
```

---

# Runtime Flow

```java
Animal a;

a = new Dog();

a.run();
```

Output:

```text
Dog running
```

---

Then:

```java
a = new Human();

a.run();
```

Output:

```text
Human running
```

---

# Memory View

```text
Reference Type

Animal
   |
   |
   ↓

Actual Object

Dog
or
Human
```

JVM checks actual object at runtime.

---

# 9. Method Overriding Rules

For overriding:

## Same Method Name

```java
run()
```

## Same Parameters

```java
run(int x)
```

## Parent-Child Relationship Required

---

# 10. Keyword Behavior in Polymorphism

---

# Static Methods

Static methods cannot be overridden.

Reason:

Static belongs to:

```text
Class
```

not:

```text
Object
```

---

Example:

```java
static void show()
```

belongs to class.

---

# Private Methods

Private methods cannot be overridden.

Reason:

They are not visible outside the class.

---

# Final Methods

Example:

```java
final void display()
```

Cannot be overridden.

---

# Final Classes

Example:

```java
final class Animal
```

Cannot be inherited.

---

# Variables and Polymorphism

Important interview point:

> Variables are not polymorphic.

Example:

```java
class Parent {

    int x = 10;

}


class Child extends Parent {

    int x = 20;

}
```

```java
Parent p = new Child();

System.out.println(p.x);
```

Output:

```text
10
```

Why?

Because variables depend on:

```text
Reference Type
```

not object type.

---

# For Data Polymorphism

Use methods:

```java
getX()
```

because methods support runtime binding.

---

# 11. Abstraction vs Encapsulation

| Encapsulation         | Abstraction                      |
| --------------------- | -------------------------------- |
| Data hiding           | Implementation hiding            |
| Uses access modifiers | Uses abstract classes/interfaces |
| Protects data         | Hides complexity                 |
| Focus on security     | Focus on simplicity              |

---

# Example Difference

## Encapsulation

```java
private balance;
```

Protects data.

---

## Abstraction

```java
withdraw();
```

User doesn't know internal banking logic.

---

# Interview Questions

---

## Q1. What is Abstraction?

Hiding implementation details and showing only required functionality.

---

## Q2. Why Use Abstract Classes?

To create a common blueprint for related classes.

---

## Q3. Can We Create Object of Abstract Class?

No.

---

## Q4. What is an Interface?

A contract that defines capabilities.

---

## Q5. Difference Between Overloading and Overriding?

| Overloading          | Overriding      |
| -------------------- | --------------- |
| Same class           | Parent-child    |
| Compile time         | Runtime         |
| Different parameters | Same parameters |

---

## Q6. Why Java Does Not Support Multiple Class Inheritance?

Because of Diamond Problem.

---

## Q7. Can Static Methods Be Overridden?

No.

---

## Q8. Can Private Methods Be Overridden?

No.

---

## Q9. Can Final Methods Be Overridden?

No.

---

# Quick Revision Sheet

```text
ABSTRACTION
============
Focus on WHAT

Hide HOW


ABSTRACT CLASS
==============
Partial Blueprint

Can Have:
- Normal Methods
- Abstract Methods


INTERFACE
=========
Contract

Defines Capability


POLYMORPHISM
============
Many Forms


COMPILE TIME
============
Method Overloading


RUNTIME
=======
Method Overriding


STATIC METHOD
=============
Cannot Override


PRIVATE METHOD
==============
Cannot Override


FINAL METHOD
=============
Cannot Override


FINAL CLASS
============
Cannot Inherit


ENCAPSULATION
=============
Data Security


ABSTRACTION
============
Implementation Hiding
```

---

# Complete OOP Pillars Flow

```text
            OOP

             |
 ------------------------------------------------

 Encapsulation
      |
 Protect Data


 Abstraction
      |
 Hide Complexity


 Inheritance
      |
 Reuse Code


 Polymorphism
      |
 Many Behaviors
```

---
