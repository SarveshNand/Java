
---

# 1. What is an Interface?

An **Interface** in Java is a blueprint of behavior.

It tells a class:

✅ **What it should do**

❌ **How it should do it**

Think of an interface as a **contract**.

If a class signs that contract, it must provide implementation for all methods declared inside the interface.

---

## Real Life Example

### Interface = Driving License Rules

The government says:

* Stop at red light
* Follow speed limits
* Wear seat belt

But it doesn't tell:

* Which car to drive
* Which route to take

Different drivers follow the same rules differently.

Similarly:

```java
interface Car {
    void drive();
}
```

Different cars implement `drive()` differently.

```java
class Thar implements Car {
    public void drive() {
        System.out.println("Driving on rough terrain");
    }
}

class BMW implements Car {
    public void drive() {
        System.out.println("Driving at high speed");
    }
}
```

---

# 2. Why Do We Need Interfaces?

Interfaces provide:

* Abstraction
* Loose Coupling
* Multiple Inheritance
* Polymorphism
* Standardized Design

---

## Without Interface

```java
class Laptop {
    void code() {
        System.out.println("Coding");
    }
}
```

You can only work with Laptop objects.

---

## With Interface

```java
interface Computer {
    void code();
}
```

Now many classes can implement it.

```java
class Laptop implements Computer {
    public void code() {
        System.out.println("Coding using laptop");
    }
}

class Desktop implements Computer {
    public void code() {
        System.out.println("Coding using desktop");
    }
}
```

Usage:

```java
Computer obj = new Laptop();
obj.code();

obj = new Desktop();
obj.code();
```

Output:

```
Coding using laptop
Coding using desktop
```

This is **Polymorphism**.

---

# 3. Interface Flow Diagram

```text
            Interface
          +------------+
          |  Computer  |
          +------------+
          | + code()   |
          +------------+
                 ^
                 |
     -------------------------
     |                       |
     | implements            | implements
     |                       |
+------------+      +-------------+
|  Laptop    |      |   Desktop   |
+------------+      +-------------+
| code()     |      | code()      |
+------------+      +-------------+
```

---

# 4. Interface Syntax

```java
interface Vehicle {
    void start();
}
```

Implementation:

```java
class Bike implements Vehicle {

    @Override
    public void start() {
        System.out.println("Bike Started");
    }
}
```

---

# 5. Rules of Interface Methods

Every interface method is automatically:

```java
public abstract
```

Even if not written.

Example:

```java
interface Test {
    void show();
}
```

Compiler converts it to:

```java
interface Test {
    public abstract void show();
}
```

---

## Important Interview Rule

### Wrong

```java
class Demo implements Test {

    void show() {
        System.out.println("Hello");
    }
}
```

Compile Error ❌

Reason:

Cannot reduce visibility.

---

### Correct

```java
class Demo implements Test {

    public void show() {
        System.out.println("Hello");
    }
}
```

---

# 6. Interface Variables

Every variable inside interface is automatically:

```java
public static final
```

Meaning:

* Public
* Shared
* Constant

---

## Example

```java
interface MathConstants {

    int VALUE = 100;
}
```

Compiler converts:

```java
interface MathConstants {

    public static final int VALUE = 100;
}
```

---

Usage:

```java
System.out.println(MathConstants.VALUE);
```

Output:

```
100
```

---

## Modification Attempt

```java
MathConstants.VALUE = 200;
```

Compile Error ❌

Because it is final.

---

# 7. Interface Memory Representation

```text
Interface

+-------------------+
| PI = 3.14         |
| MAX = 100         |
+-------------------+

       Shared

     /    |    \
    /     |     \
 Obj1   Obj2   Obj3
```

Only one copy exists because variables are static.

---

# 8. Multiple Interface Implementation

Java classes cannot extend multiple classes.

### Not Allowed

```java
class A {}
class B {}

class C extends A, B {}
```

Compile Error ❌

---

## Why?

Diamond Problem

```text
      A
     / \
    B   C
     \ /
      D
```

If both B and C contain same method:

```java
show()
```

Which one should D inherit?

Ambiguity occurs.

---

# 9. Multiple Inheritance Using Interfaces

Allowed because interfaces traditionally contain declarations only.

```java
interface Camera {
    void click();
}

interface MusicPlayer {
    void playMusic();
}

class Phone implements Camera, MusicPlayer {

    public void click() {
        System.out.println("Photo Clicked");
    }

    public void playMusic() {
        System.out.println("Music Playing");
    }
}
```

---

Diagram:

```text
      Camera
         ^
         |
         |
         |
      Phone
         |
         |
         v
    MusicPlayer
```

Phone can do both tasks.

---

# 10. Interface Inheriting Interface

Interfaces use:

```java
extends
```

not

```java
implements
```

---

Example

```java
interface Animal {
    void eat();
}

interface Dog extends Animal {
    void bark();
}
```

Implementation:

```java
class Labrador implements Dog {

    public void eat() {
        System.out.println("Eating");
    }

    public void bark() {
        System.out.println("Barking");
    }
}
```

---

Flow:

```text
Animal
   ^
   |
extends
   |
 Dog
   ^
   |
implements
   |
Labrador
```

---

# 11. Java 8 - Default Methods

Before Java 8:

```java
interface A {
    void show();
}
```

Only abstract methods allowed.

---

Java 8 introduced:

```java
default
```

methods.

---

Example

```java
interface Car {

    default void fuelType() {
        System.out.println("Petrol");
    }
}
```

Implementation:

```java
class Thar implements Car {
}
```

Usage:

```java
Thar t = new Thar();
t.fuelType();
```

Output:

```
Petrol
```

---

## Why Default Methods?

Imagine:

```java
interface Vehicle {
    void start();
}
```

1000 classes implement it.

Now you add:

```java
void stop();
```

All 1000 classes break.

---

Solution:

```java
default void stop() {
    System.out.println("Stopping");
}
```

No existing code breaks.

---

# 12. Java 8 Static Methods

Static methods belong to interface itself.

```java
interface Calculator {

    static int add(int a, int b) {
        return a + b;
    }
}
```

Usage:

```java
int result = Calculator.add(10,20);
```

Output:

```
30
```

---

Diagram

```text
Calculator Interface
        |
        |
        +---- add()
              |
              |
      Calculator.add()
```

No object required.

---

# 13. Java 9 Private Methods

Purpose:

Avoid duplicate code in default methods.

---

Example

```java
interface Logger {

    default void info() {
        common();
    }

    default void warning() {
        common();
    }

    private void common() {
        System.out.println("Logging...");
    }
}
```

---

Benefits:

* Cleaner code
* Reusability
* Hidden helper methods

---

# 14. Default Method Conflict (Diamond Problem)

## Scenario

```java
interface A {

    default void show() {
        System.out.println("A");
    }
}

interface B {

    default void show() {
        System.out.println("B");
    }
}
```

---

Now:

```java
class C implements A, B {

}
```

Compile Error ❌

Because compiler doesn't know which show() to use.

---

## Solution

Override it.

```java
class C implements A, B {

    public void show() {
        System.out.println("Resolved");
    }
}
```

---

# 15. Calling Specific Interface Method

```java
class C implements A, B {

    public void show() {

        A.super.show();

        B.super.show();
    }
}
```

Output:

```
A
B
```

---

Flow Diagram

```text
         A(show)
          \
           \
            \
             C
            /
           /
          /
         B(show)

Ambiguity

=> Override Required
```

---

# 16. Class vs Interface Priority Rule

Suppose:

```java
class Parent {

    public void show() {
        System.out.println("Parent");
    }
}
```

```java
interface Test {

    default void show() {
        System.out.println("Interface");
    }
}
```

```java
class Child extends Parent
             implements Test {
}
```

---

Usage:

```java
Child c = new Child();
c.show();
```

Output:

```
Parent
```

---

## Rule

```text
Class Method
      >
Default Interface Method
```

Class wins.

---

# 17. Functional Interfaces

A Functional Interface contains exactly:

```text
ONE ABSTRACT METHOD
```

---

Example

```java
@FunctionalInterface
interface Calculator {

    int calculate(int a, int b);
}
```

Valid ✔

---

Invalid ❌

```java
@FunctionalInterface
interface Test {

    void show();

    void print();
}
```

Two abstract methods.

---

# 18. Why Functional Interfaces?

They enable Lambda Expressions.

---

Traditional

```java
Calculator obj = new Calculator() {

    public int calculate(int a, int b) {
        return a + b;
    }
};
```

---

Lambda

```java
Calculator obj =
    (a,b) -> a+b;
```

Usage:

```java
System.out.println(
    obj.calculate(10,20)
);
```

Output:

```
30
```

---

## Popular Functional Interfaces

```java
Runnable
Callable
Comparable
Predicate
Function
Consumer
Supplier
```

Interview Favorite ⭐

---

# 19. Marker Interfaces

Marker Interface = Empty Interface

```java
interface Demo {
}
```

Contains:

* No methods
* No variables

---

Purpose:

Used to mark a class.

---

Example

```java
class Student
implements Serializable {
}
```

JVM understands:

```text
This object can be serialized.
```

---

Popular Marker Interfaces

```java
Serializable
Cloneable
Remote
```

---

# 20. Complete Interface Hierarchy

```text
                    Interface
                        |
        --------------------------------
        |              |              |
        |              |              |
    Normal        Functional      Marker
    Interface     Interface      Interface
        |              |              |
     Multiple      Lambda       Metadata
     Inheritance   Support      Support
```

---

# 21. Interface vs Abstract Class

| Feature            | Interface                          | Abstract Class    |
| ------------------ | ---------------------------------- | ----------------- |
| Purpose            | Can-Do Relationship                | Is-A Relationship |
| Inheritance        | Multiple                           | Single            |
| Constructor        | No                                 | Yes               |
| Instance Variables | No                                 | Yes               |
| Constants          | Yes                                | Yes               |
| Method Type        | Abstract, Default, Static, Private | Any               |
| Object Creation    | No                                 | No                |
| Fields             | public static final only           | Any type          |
| Flexibility        | High                               | Moderate          |

---

# 22. When to Use Interface?

Use Interface when:

✅ Multiple classes share behavior

✅ Multiple inheritance is required

✅ Loose coupling is needed

✅ Framework/API design

✅ Lambda expressions

---

Use Abstract Class when:

✅ Common state exists

✅ Shared implementation needed

✅ Constructors required

✅ Strong parent-child relationship exists

---

# 23. Internal JVM View

Source Code:

```java
interface Car {
    void drive();
}
```

Compilation:

```text
Car.java
    |
 javac
    |
    v
Car.class
```

Internally JVM stores:

```text
ACC_PUBLIC
ACC_ABSTRACT
ACC_INTERFACE
```

Flags identify it as an interface.

---

# 24. Interview Quick Revision Sheet

### Interface Keywords

```java
interface
implements
extends
default
static
private
```

---

### Method Types

```text
Abstract Method
Default Method
Static Method
Private Method
```

---

### Variable Type

```text
public static final
```

---

### Supports

```text
Abstraction
Polymorphism
Multiple Inheritance
Loose Coupling
Functional Programming
```

---

### Java Versions

| Feature              | Version |
| -------------------- | ------- |
| Default Methods      | Java 8  |
| Static Methods       | Java 8  |
| Functional Interface | Java 8  |
| Lambda Expressions   | Java 8  |
| Private Methods      | Java 9  |

---

# 25. Most Asked Interview Questions

### Q1. Can Interface Have Constructors?

**No**

Interfaces cannot have constructors because objects of interfaces cannot be created.

---

### Q2. Can Interface Have Variables?

**Yes**

All variables become:

```java
public static final
```

---

### Q3. Can Interface Extend Multiple Interfaces?

**Yes**

```java
interface C extends A, B
{
}
```

---

### Q4. Can a Class Implement Multiple Interfaces?

**Yes**

```java
class Test implements A,B,C
{
}
```

---

### Q5. Why Are Interfaces Used?

* Abstraction
* Loose Coupling
* Multiple Inheritance
* Polymorphism
* API Design

---

### Q6. Difference Between extends and implements?

```java
class B extends A
```

Inheritance between classes.

```java
class B implements A
```

Class implementing interface.

---

### Q7. Can We Create Object of Interface?

```java
Car c = new Car();
```

❌ No

But:

```java
Car c = new Thar();
```

✔ Yes (Reference Variable)

---

### Q8. What Happens If Two Interfaces Have Same Default Method?

Must override in implementing class.

---

### Q9. Which Has Higher Priority?

```text
Class Method
     >
Interface Default Method
```

---

### Q10. What is a Functional Interface?

Interface with exactly one abstract method.

---

# Final Memory Trick

```text
INTERFACE

I  -> Implements Abstraction
N  -> No Constructors
T  -> Types of Methods
E  -> Extends Other Interfaces
R  -> Reusable Contract
F  -> Functional Interfaces
A  -> API Design
C  -> Constants Only Variables
E  -> Enables Multiple Inheritance
```

## One-Line Definition for Interviews

> "An Interface in Java is a blueprint of behavior that provides abstraction, supports multiple inheritance, and defines a contract that implementing classes must follow."
