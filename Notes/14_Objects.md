
### **1. Object Memory Allocation: Stack and Heap**
When you create an object (e.g., `Student s1 = new Student();`), Java manages memory across two regions:
*   **Heap Memory:** This is where the actual **object** is stored. When the `new` keyword is used, space is dynamically allocated in the Heap for all fields defined in the class (e.g., `name`, `age`, `rollNumber`).
*   **Stack Memory:** This stores the **reference variable** (e.g., `s1`). The reference variable holds the memory address (pointer) of the object located in the Heap.

---

### **2. Memory Sizing in Java**
#### **A. Reference Variable Size**
The size of a reference variable in the Stack depends on the JVM and the underlying architecture:
*   **Default:** In a 64-bit JVM using compressed pointers, a reference variable typically takes **4 bytes**.
*   **Alternative:** Some 64-bit JVMs may use **8 bytes**.

#### **B. Object Size Calculation**
The total size of an object in the Heap is the sum of three components: **Object Header**, **Exact Fields**, and **Padding**.

1.  **Object Header (Metadata):** Stores "data about the data" (metadata) that Java needs to manage the object. It consists of:
    *   **Mark Words (8 bytes):** Stores information about locking mechanisms, synchronization, and garbage collection.
    *   **Class Pointer (4 or 8 bytes):** A reference that points to the object's class definition. Most JVMs use 4 bytes.
    *   *Typical Header Total:* **12 bytes**.

2.  **Fields (Exact Data):** The size of the actual variables stored in the object.
    *   `int`, `float`, and **Reference types** (like `String` or other objects) take 4 bytes each.
    *   `double` and `long` take 8 bytes.
    *   `byte` takes 1 byte.

3.  **Padding (Alignment):** Modern CPUs process data in **8-byte chunks** for efficiency. Java ensures every object's total size is a **multiple of 8 bytes**. If the sum of the header and fields is not a multiple of 8, "padding" bytes are added to reach the next multiple.

#### **Example 1: Student Object**
*   **Fields:** `String name` (4B), `int age` (4B), `int rollNumber` (4B), `String college` (4B) = **16 bytes**.
*   **Header:** 12 bytes.
*   **Subtotal:** 12 + 16 = 28 bytes.
*   **Padding:** To reach the next multiple of 8 (which is 32), **4 bytes** of padding are added.
*   **Total Size:** **32 bytes**.

#### **Example 2: Person Object**
*   **Field:** `byte age` (1 byte).
*   **Header:** 12 bytes.
*   **Subtotal:** 12 + 1 = 13 bytes.
*   **Padding:** To reach the next multiple of 8 (which is 16), **3 bytes** of padding are added.
*   **Total Size:** **16 bytes**.

---

### **3. Call by Value vs. Call by Reference**
A common misconception is that Java uses both mechanisms. Internally, **Java is strictly "Call by Value"** for both primitives and objects.

#### **A. Primitives (Standard Call by Value)**
When a primitive (like `int x = 4`) is passed to a method, a **copy of the value** is created in a new local variable within that method's stack frame.
*   **Effect:** Changes made to the variable inside the method do not affect the original variable in the `main` method because they are entirely different containers in memory.

#### **B. Objects (The "Call by Reference" Illusion)**
When an object reference (e.g., `r1`) is passed to a method, the **value of the reference (the memory address)** is copied into a new local reference variable (e.g., `r`).
*   **Effect:** Because both `r1` and `r` now hold the same memory address, they both point to the **same object in the Heap**.
*   **Result:** If the method modifies the object's fields (e.g., `r.x = 10`), the change is visible through the original reference `r1`. This provides the *effect* of call by reference, but technically it is the address value that was copied.

---

### **4. Object Copying Strategies**
Java allows you to copy data from one object to another using two main strategies.

#### **A. Shallow Copy**
A shallow copy occurs when you assign one reference variable to another without creating a new object.
*   **Example:** `Random r3 = r1;`.
*   **Mechanism:** `r3` simply copies the memory address stored in `r1`. No new space is allocated in the Heap.
*   **Behavior:** Both variables point to the **same object**. Changes made through `r3` will reflect in `r1` and vice-versa.

#### **B. Deep Copy**
A deep copy occurs when you create a **completely new object** in the Heap and manually copy the values from the original object into the new one. This is often done using a **Copy Constructor**.
*   **Example:** `Random r2 = new Random(r1);`.
*   **Mechanism:** The `new` keyword allocates a new, independent space in the Heap. The constructor then takes values from `r1` and assigns them to `r2`.
*   **Behavior:** The objects are **independent**. Changing a value in `r2` does not affect `r1` because they occupy different memory locations.

### **Summary Table: Reference vs. Object**
| Feature | Reference Variable | Actual Object |
| :--- | :--- | :--- |
| **Location** | Stack Memory | Heap Memory |
| **Size** | 4 or 8 bytes | Header + Fields + Padding |
| **Role** | Stores the Address | Stores the Data/Fields |
| **Copying** | Copying address = Shallow | Copying data to new object = Deep |