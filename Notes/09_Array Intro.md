
### **1. Introduction to Arrays**
Arrays are a fundamental concept in programming used to store a **collection of data of a particular type** under a single name.

*   **The Problem:** Storing data for 100 students using individual variables (e.g., `int roll1, roll2...`) is unoptimized and difficult to manage.
*   **The Solution:** An array allows you to allocate a **contiguous chunk of memory** (memory located side-by-side) and divide it into sections to store multiple values.
*   **Contiguous Memory:** If the first memory location is 1001, the next will follow immediately after the space for that data type is accounted for (e.g., 32 bits for an integer).

---

### **2. 1D Array: Declaration and Definition**
Java requires you to tell the compiler the data type and the size of the array so it knows how much memory to occupy.

#### **A. Syntax for Declaration**
To declare an array, you specify the data type followed by square brackets `[]`.
*   **Standard:** `int[] rollNumbers;`
*   **Legacy/Alternative:** `int rollNumbers[];` (supported for compatibility with C++).

#### **B. Syntax for Definition (Initialization)**
You use the `new` keyword to allocate memory in the **heap**.
*   **Syntax:** `rollNumbers = new int;` (where `3` is the size).
*   **Combined:** `int[] rollNumbers = new int;`.
*   **Direct Initialization:** If values are known beforehand, you can use curly braces: `int[] rollNumbers = {1001, 1002, 1003};`.

---

### **3. Array Operations: Indexing and Traversal**
#### **A. Indexing**
Internally, Java uses **zero-based indexing**. The first container is at index 0, the second at index 1, and so on.
*   **Assigning Values:** `rollNumbers = 1001;`.
*   **Retrieving Values:** `System.out.println(rollNumbers);`.

#### **B. The `length` Property**
Every array has a built-in property called `.length` that returns the size of the array.
*   **Example:** `rollNumbers.length` for a three-element array returns `3`.

#### **C. Using Loops for Traversal**
Manual assignment and retrieval become tedious for large arrays. **Loops** are used to automate these processes.
*   **Filling an array:**
    ```java
    for (int i = 0; i < rollNumbers.length; i++) {
        rollNumbers[i] = 1000 + i; // Logic to fill data
    }
    ```
*   **Printing an array:**
    ```java
    for (int i = 0; i < rollNumbers.length; i++) {
        System.out.println(rollNumbers[i]);
    }
    ```

#### **D. Exceptions**
If you attempt to access an index that does not exist (e.g., index 3 in a 3-size array which only has indices 0, 1, 2), Java throws an **`ArrayIndexOutOfBoundsException`**.

---

### **4. Multi-Dimensional Arrays (2D Arrays)**
A 2D array is technically an **"array of arrays"**. It is used when data is multi-dimensional, such as storing marks for multiple students across multiple subjects.

#### **A. Conceptual vs. Logical Representation**
*   **Conceptual:** We visualize it as a **matrix** with rows and columns (e.g., a 3x3 table).
*   **Logical (Actual Memory):** Computer memory has no concept of rows or columns. It creates a main array where each element points to another array.

#### **B. Syntax and Declaration**
*   **Syntax:** `int[][] marks = new int;` (3 rows and 3 columns).
*   **Accessing Values:** `marks[row][column]` (e.g., `marks = 30;` refers to the first row, second column).

#### **C. Traversal with Nested Loops**
To print or fill a 2D array, you must use **nested loops**. The outer loop iterates through rows, and the inner loop iterates through columns within that row.
```java
for (int i = 0; i < marks.length; i++) { // Iterates through rows
    for (int j = 0; j < marks[i].length; j++) { // Iterates through columns in current row
        System.out.print(marks[i][j] + " ");
    }
    System.out.println(); // New line after each row
}
```

---

### **5. Jagged (Ragged) Arrays**
In Java, the number of columns in each row does not have to be the same.
*   **Requirement:** You must define the number of rows, but the columns are optional during initial declaration.
*   **Example:**
    ```java
    int[][] marks = new int[]; // 3 rows, columns undefined
    marks = new int; // First row has 1 column
    marks = new int; // Second row has 2 columns
    marks = new int; // Third row has 3 columns
    ```
This is useful when different entities have different amounts of data (e.g., students taking different numbers of subjects).

---

### **6. Introduction to Strings**
Strings are **non-primitive data types** used to store sequences of characters.

*   **Declaration:** `String name = "Aditya";`.
*   **Literal Syntax:** Strings must always be enclosed in **double quotes** (`""`), whereas characters use single quotes (`''`).
*   **Concatenation:** You can join two strings using the **`+` operator**.
    *   **Example:** `String fullName = firstName + " " + lastName;`.
*   **Empty String:** A string with no characters `""` or just a space `" "` is still a valid string object.

### **7. Higher Dimensions (3D Arrays)**
You can declare n-dimensional arrays (e.g., `int[][][] array`). A 3D array can be visualized as a **cube** or a stack of 2D matrices.
*   **Logical View:** A main array pointing to 2D arrays, which in turn point to 1D arrays of integers.
*   **Usage:** While possible, dimensions higher than 2D or 3D are rare because they become very complex to manage.