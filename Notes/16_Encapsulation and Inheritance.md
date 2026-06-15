
---

### **1. Encapsulation: The First Pillar of OOP**
**Encapsulation** is the process of wrapping data (variables) and behaviors (methods) together into a single unit, similar to how different medicines are enclosed within a single **capsule**.

#### **A. Two Core Principles of Encapsulation**
1.  **Grouping Data and Behavior:** An object’s data and its behaviors are intrinsic properties that must stay together within a class.
2.  **Restricting Access:** Developers should not provide **unrestricted access** to data from outside the class.

#### **B. The "Bank Account" Example**
If a `balance` variable in a `BankAccount` class is public, any user could directly set their balance to a million dollars (e.g., `BA.balance = 1000000;`), which is logically wrong.
*   **The Solution:** Make the `balance` variable **private** and provide access only through specific behaviors like **`deposit()`** or **`withdraw()`**.
*   **Benefits of This Approach:** This allows the developer to add **validations** (e.g., checking if an ATM note is real or if the account has enough funds before withdrawing) rather than allowing direct, unmonitored changes to the data.

---

### **2. Access Modifiers**
Access modifiers control **who has access** to a variable, method, constructor, or class. Java provides four types:

| Modifier | Access Level |
| :--- | :--- |
| **Private** | Most restricted; accessible **only within the same class**. |
| **Default** | (No keyword used) Accessible to all classes in the **same package**. |
| **Protected** | Accessible in the **same package** and by **child (inherited) classes** even in different packages. |
| **Public** | Least restricted; accessible from **anywhere in the code base**. |

**Root-Level Class Restriction:** A standard root-level class can only be **Public** or **Default**. It cannot be **Private** or **Protected** because it would lack a context (it's not "private" to anything higher).

---

### **3. Java Packages**
A **package** is essentially a folder used to group similar classes and interfaces together.

*   **Syntax:** Use the `package` keyword at the very top of the file (e.g., `package college;`).
*   **Importing:** To use a class from another package, use the `import` keyword followed by the package and class name (e.g., `import school.Student;`).
*   **Inbuilt Packages:** Java provides several pre-written packages like `java.util` (for collections), `java.lang` (for core strings), and `java.io` (for input/output).
*   **Internal Logic:** When a file is compiled into **bytecode (.class)**, the JVM loads the specific bytecode of the imported classes from their respective packages.

---

### **4. Inheritance: The "Is-A" Relationship**
**Inheritance** allows one class to acquire the properties and behaviors of another, representing a real-world **"Is-A" relationship**.

*   **Example:** A **Car** "is-a" **Vehicle**. A **Medical Student** "is-a" **Student**.
*   **Keywords:** The keyword **`extends`** is used to create this link (e.g., `class Car extends Vehicle`).
*   **Hierarchy:** The original class is the **Parent (Super)** class, and the inheriting class is the **Child (Sub)** class.
*   **Advantage - Code Reusability:** If a `Vehicle` class has a `start()` method, every child class (Car, Bike, Truck) automatically gets that method without needing to rewrite it.

#### **Types of Inheritance**
1.  **Simple:** One parent and one child.
2.  **Multi-level:** A chain of inheritance (e.g., Student -> Engineering Student -> CSE Student).
3.  **Hierarchical:** One parent has multiple child classes (e.g., Student has children Engineering Student and Medical Student).
4.  **Multiple (NOT supported for classes):** Java does not allow one class to inherit from two parents simultaneously (e.g., `class C extends A, B`) to avoid the **Diamond Problem**.

**The Diamond Problem:** If Parent A and Parent B both have a method called `show()`, and Child C inherits from both, the compiler wouldn't know which version of `show()` to execute, leading to runtime ambiguity.

---

### **5. The `super` Keyword**
While the `this` keyword refers to the current object, the **`super`** keyword refers to the **parent object**. It has three primary uses:

1.  **Access Parent Variables:** Useful if both the parent and child have a variable with the same name (e.g., `super.x` refers to the parent’s `x`).
2.  **Call Parent Methods:** Allows a child to invoke a parent's version of a method.
3.  **Call Parent Constructor:** Used inside a child constructor to initialize parent fields (e.g., `super(name, age);`).
    *   **Rule:** The call to `super()` **must be the first statement** in the child constructor.

---

### **6. Getters and Setters**
In professional development, encapsulation is implemented by making fields private and using **Getters** and **Setters**.
*   **Getter:** A public method that returns a private variable's value (e.g., `getName()`).
*   **Setter:** A public method that updates a private variable's value after performing **validations** (e.g., `setName()`).
*   **Example Validation:** A `setAge()` method can check if the provided age is between 0 and 150 before assigning it, preventing invalid data from entering the object.