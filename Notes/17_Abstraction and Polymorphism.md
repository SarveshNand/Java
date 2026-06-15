
### **1. Understanding Abstraction**
**Abstraction** is defined as the process of **focusing on what something does while ignoring how it performs those actions**. In real life, humans use abstraction to process the complexity of the world by simplifying objects into their essential behaviors.

*   **Real-World Examples:**
    *   **The Car:** When driving, you focus on using the steering wheel, brakes, and accelerator. You do not need to understand internal combustion or how 30,000 internal parts work to operate the vehicle.
    *   **ATM Machine:** You interact with an ATM to deposit, withdraw, or check your balance. You do not need to understand its internal electronics or the mechanics of how it counts cash.
*   **Abstraction in Programming:** Object-oriented programming (OOP) simulates the **human perception or idea** of reality rather than exact physical reality. For example, a "Teacher" object in a program only needs to represent behaviors like teaching or taking attendance, not complex biological processes.

---

### **2. Abstraction in Java: Two Levels**
The source distinguishes between two implementation levels in Java:
1.  **Low-Level Abstraction:** Achieved through standard classes by **hiding implementation details**. When a developer calls a method like `car.start()`, they get the result without needing to see the code inside that specific class.
2.  **High-Level Abstraction:** Separates **"What"** from **"How"** using **Abstract Classes** and **Interfaces**.

#### **A. Abstract Classes**
An **Abstract Class** is a "partial blueprint" used to group a **family of similar objects**.
*   **Abstract Methods:** These methods have no body and are only declared (the "What"). Subclasses are forced to provide the implementation (the "How").
*   **Rules:**
    *   If a class has one or more abstract methods, the class itself **must be marked abstract**.
    *   You **cannot create an object** of an abstract class.
    *   Subclasses must implement all abstract methods unless the subclass is also abstract.

**Code Example: Abstract Class**
```java
// Abstract Class (The Generic Idea)
abstract class Car {
    // Normal Method (Shared Logic)
    void start() {
        System.out.println("Car started");
    }

    // Abstract Methods (What to do, but not How)
    abstract void accelerate();
    abstract void breakApply();
}

// Concrete Class (Specific Implementation)
class ElectricCar extends Car {
    @Override
    void accelerate() {
        System.out.println("Electric motor accelerating silently");
    }
    @Override
    void breakApply() {
        System.out.println("Applying regenerative braking");
    }
}
```
*[Source: 31, 36, 42-45]*

#### **B. Interfaces**
An **Interface** acts as a **"Contract"**. It defines **roles or capabilities** (like `Flyable` or `Runnable`) that unrelated objects can adopt.
*   **Pure Abstraction:** In an interface, all methods are abstract and public by default.
*   **Multiple Inheritance:** While a class can only inherit from one parent class, it can **implement multiple interfaces**.

**Code Example: Interface**
```java
// Interface (A Contract for Flying)
interface Flyable {
    void fly(); // Abstract by default
}

class Aeroplane implements Flyable {
    public void fly() {
        System.out.println("Aeroplane flying using jet engines");
    }
}

class Bird implements Flyable {
    public void fly() {
        System.out.println("Bird flying by flapping wings");
    }
}
```
*[Source: 48, 57, 58]*

---

### **3. Polymorphism: "Many Forms"**
**Polymorphism** allows a single command to behave differently based on the object or the parameters provided.

#### **A. Compile-Time (Static) Polymorphism**
This is implemented via **Method Overloading**.
*   **Mechanism:** Multiple methods have the same name but different parameters.
*   **Decision:** The compiler decides which version to call at **compile-time** based on the arguments passed.

**Example:** A `run()` method without arguments for normal speed, and `run(boolean isScared)` for faster speed.

#### **B. Runtime (Dynamic) Polymorphism**
This is implemented via **Method Overriding**.
*   **Mechanism:** A parent class reference points to a child class object.
*   **Decision:** The JVM decides which method to execute at **runtime** based on the actual object in memory.

**Code Example: Runtime Polymorphism**
```java
abstract class Animal {
    abstract void run();
}

class Dog extends Animal {
    void run() { System.out.println("Dog running on 4 legs"); }
}

class Human extends Animal {
    void run() { System.out.println("Human running on 2 legs"); }
}

public class Main {
    static void main(String[] args) {
        Animal a; 
        a = new Dog();
        a.run(); // Calls Dog's run() at Runtime

        a = new Human();
        a.run(); // Calls Human's run() at Runtime
    }
}
```
*[Source: 73-75]*

---

### **4. Critical Rules and Keyword Behavior**
The source highlights several exceptions and rules for keywords during polymorphism:
*   **Static Methods:** They **cannot be overridden** because they belong to the class, not the object.
*   **Private Methods:** These are hidden and **cannot be overridden** by child classes.
*   **Final Keyword:**
    *   **Final Methods:** Cannot be overridden.
    *   **Final Classes:** Cannot be inherited (no child classes can be created).
*   **Variables (Fields):** **Variables are not polymorphic**. The value accessed depends on the **reference type**, not the actual object in memory. To achieve polymorphism for data, you must use methods like Getters.

### **5. Abstraction vs. Encapsulation**
*   **Encapsulation:** Focuses on **Data Security** and hiding data using access modifiers (private).
*   **Abstraction:** Focuses on **Implementation Hiding**—hiding the "How" so the user can focus on the "What".