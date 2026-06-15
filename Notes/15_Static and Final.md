
### **1. The `static` Keyword**
The `static` keyword is used to manage memory efficiently by shifting variables and methods from the **object level** to the **class level**.

#### **A. Static Variables (Class Variables)**
*   **Concept:** A static variable is shared by all instances of a class. Instead of each object having its own copy, there is only **one copy** stored in a common memory area.
*   **The Problem it Solves (Memory Optimization):** If 1,000 student objects belong to "IIT Guwahati," storing that string in every object wastes 4,000 bytes (4 bytes per reference). By making it `static`, only **4 bytes** are used for the entire application.
*   **Syntax & Access:**
    *   **Declaration:** `static String college = "IIT Guwahati";`.
    *   **Access:** While you can use an object reference (`s1.college`), the professional standard is using the **Class Name** (`Student.college`).
*   **Global Change:** Because the variable is shared, if one object changes a static variable (e.g., `s1.college = "IIT Delhi"`), it changes for **every other object** in the system.
*   **Storage:** Static variables are **not stored in the Heap** with objects; they reside in a specific class-level memory area.

#### **B. Static Methods**
*   **Concept:** Methods marked `static` belong to the class rather than a specific object. They are often used for utility functions that don't require data from a specific instance.
*   **Rules for Static Methods:**
    1.  **Call Restriction:** A static method can **only call other static methods** directly. It cannot call a non-static method because the JVM wouldn't know which object's method to execute if no object was created.
    2.  **Variable Restriction:** A static method can **only access static variables**. It cannot use instance variables (like `name` or `age`) because those variables don't exist until an object is instantiated.
    3.  **No `this` Keyword:** Static methods **do not have access to the `this` keyword**. Since `this` refers to the "current object" and static methods are class-level, there is no "current object" context.

#### **C. Static Blocks**
*   **Purpose:** A `static { ... }` block is used to **initialize static variables**, similar to how a constructor initializes instance variables.
*   **Execution Timing:** Static blocks run **exactly once** when the class is first loaded into memory by the JVM, which happens **before any objects are created**.

#### **D. Limitations of Static**
*   **Parameters:** Method parameters **cannot be static** because they are local variables stored in the Stack, not class-level properties.
*   **Classes:** A **root-level class cannot be static**. However, a **nested class** (a class inside another class) can be marked as static.

---

### **2. The `final` Keyword**
The `final` keyword is used to represent **constants**—values that, once assigned, cannot be changed.

#### **A. Final Variables**
*   **Concept:** Marking a variable `final` locks its value. For example, `final double PI = 3.14;` ensures that no part of the code can accidentally change the value of PI to something else.
*   **Naming Conventions:** Professional Java developers use **ALL UPPERCASE** for final variables. If the name has multiple words, they are separated by underscores (e.g., `PI_VALUE`).
*   **Initialization:**
    *   It can be initialized during declaration.
    *   It can be initialized inside a **constructor**, but once the constructor finishes, the value is locked.
    *   **The "One-Time Assignment" Rule:** Java allows you to declare a final variable and assign it a value later in a separate line, but **only once**. Any subsequent attempt to reassign it will cause a compile-time error.

#### **B. Final in Other Contexts**
*   **Parameters:** You can mark method parameters as `final` (e.g., `void print(final String name)`). This prevents the code inside the method from changing the value of that input variable.
*   **Methods and Classes:** `final` can also be applied to methods (to prevent overriding) and classes (to prevent inheritance), which are advanced topics related to Polymorphism and Inheritance.

---

### **3. Deep Dive into the `main` Method**
The signature `public static void main(String[] args)` can now be fully understood through these keywords.

*   **Why is `main` static?**
    The JVM needs to run the `main` method to start the program. If `main` were not static, the JVM would have to create an object of the class first. Since the JVM cannot know how to construct your specific object, `main` is made `static` so it can be called directly using the class name (e.g., `Demo4.main()`).

*   **What is `String[] args`?**
    This is an array of strings used for **Command-Line Arguments**.
    *   **Usage:** When running a program from a terminal (e.g., `java Demo5 Aditya Rohit`), the strings "Aditya" and "Rohit" are automatically stored in the `args` array.
    *   **Historical Context:** This was traditionally used to pass configurations, such as input/output file paths, directly into the program at startup.

---

### **4. Combining Static and Final**
It is very common to see **`static final`** used together for mathematical or configuration constants (e.g., `static final double PI = 3.14;`).
*   **Static:** Ensures the constant is shared by all objects to save memory.
*   **Final:** Ensures the constant's value can never be modified.
*   **Initialization:** These are best initialized either at declaration or inside a **static block**.