
### **1. The Problem: Life Before OOP**
Before adopting the OOP paradigm, data was represented using **independent variables**, which created several logistical issues for developers:
*   **Scattered Data:** To represent a single entity (like a student named Aditya), developers had to create separate variables for name, age, roll number, and college. These variables are independent in the code, making it difficult to see that they belong to the same person.
*   **Scalability Issues:** To represent a second student (Rohit), a developer would need to create a new set of variables (`name2`, `age2`, etc.). This becomes unmanageable as the number of students grows.
*   **Function Complexity:** Passing a student’s information to a function (e.g., a `print` function) required passing every single independent variable as a parameter. Forgetting one parameter would result in incomplete data.
*   **Lack of Data Authority:** There is no single "owner" of the data. Since the variables are independent, any part of the code can access or modify them without a central authority or structure.

---

### **2. The OOP Paradigm: Mimicking the Real World**
OOP is a **programming paradigm** (a way of thinking about and writing code) that aims to solve these problems by **mimicking the real world**.
*   **The Concept of Objects:** In the real world, a student is a single entity (an object) with intrinsic properties. OOP allows us to create a single **block or container** in programming that holds all relevant characteristics (Name, Age, etc.) together.
*   **Selective Representation:** We do not need to mimic every aspect of a real-world object—only the parts relevant to the problem we are solving.
    *   **Example:** For a college portal, we care about a student’s name and roll number. We do not need to represent their role as a "son" or "daughter" unless the application requires it.
*   **Non-Physical Objects:** Classes can also represent complex, non-physical concepts like a **Bank Account** or a **Location** (Longitude/Latitude) that are too complicated for simple primitive data types.

---

### **3. Classes vs. Objects**
*   **Class (The Blueprint):** A class is an **abstract idea** or a "blueprint". It defines what an object will look like and what characteristics it will have, but it does not hold actual data or occupy space for a specific person yet.
*   **Object (The Instance):** An object is the **absolute, concrete entity** created based on the class blueprint (e.g., "Aditya" is an object of the "Student" class).

---

### **4. Memory Management: How Objects are Created**
In Java, creating an object is a multi-step process involving two types of memory: **Stack** and **Heap**.

#### **A. Declaration**
`Student s1;`
This creates a **reference variable** named `s1` in the **Stack memory**. At this stage, no actual object exists in the Heap.

#### **B. Definition (Instantiation)**
`s1 = new Student();`
*   **`new` Keyword:** This triggers **Dynamic Memory Allocation**, which happens at **Run-time**. It tells the JVM to allocate a chunk of space in the **Heap memory** to store the object’s data.
*   **Reference Variable Logic:** The `s1` variable in the Stack stores the **starting address** (e.g., `1001`) of the object in the Heap.
*   **Key Distinction:** `s1` is **not** the object itself; it is a **reference variable** that points to an unnamed object in the Heap.

---

### **5. Working with Objects**
#### **A. The Dot (`.`) Operator**
The dot operator is used to "link" the reference variable to the actual object in the Heap. It allows you to access or modify specific fields.
*   **Example (Assigning):** `s1.name = "Aditya";`.
*   **Example (Accessing):** `System.out.println(s1.name);`.

#### **B. Adding Behaviors (Methods)**
A real-world object doesn't just have characteristics (data); it also has **behaviors** (what it can do).
*   **Variables = Characteristics:** Stores data like `name` or `age`.
*   **Functions = Behaviors:** Represent actions like `markAttendance()` or `print()`.
*   **Digital vs. Real Behaviors:** Some behaviors are purely digital. While a real student doesn't have a "print" function, a **digital student** object can have one to make the code more efficient.

---

### **6. Code Example: Student Class**
The source illustrates how to define a class outside the `main` method and use it within the program:

```java
// The Blueprint (Class)
class Student {
    String name;
    int age;
    int rollNumber;

    // Behavior: Method to mark attendance
    void markAttendance() {
        System.out.println("Attendance marked by " + name);
    }
}

public class Demo {
    public static void main(String[] args) {
        // Creating the Object
        Student s1 = new Student(); 
        s1.name = "Aditya";
        s1.age = 28;

        // Calling Behavior
        s1.markAttendance(); // Output: Attendance marked by Aditya
    }
}
```
**

---

### **7. Naming Conventions**
Following Java standards ensures code is readable and professional:
*   **Classes:** Use **Pascal Case** (starts with a Capital letter), e.g., `Student`, `BankAccount`.
*   **Variables and Functions:** Use **Camel Case** (starts with a small letter, subsequent words capitalized), e.g., `firstName`, `markAttendance()`.

---

### **8. Java's Object-Oriented Nature**
Java is described as **"almost complete"** Object-Oriented Programming. This is because even the simplest code requires a class (e.g., `public class Demo`) and a function (`main`) to run. The `main` function serves as the entry point for the JVM to begin executing the object-oriented logic.