
---

### **Part 1: Flow of Control in Java**
Flow of control refers to the order in which individual statements or instructions of a program are executed.
*   **Sequential Flow:** By default, Java executes code line-by-line from top to bottom.
*   **Alternate Flows:** Certain keywords can break this normal flow into three categories:
    1.  **Selection:** Making choices (e.g., `if`, `switch`).
    2.  **Iteration:** Repeating code (Loops).
    3.  **Jumps:** Moving to a different part of the program (e.g., `break`).

---

### **Part 2: Selection (Conditional) Statements**
Selection statements allow the program to take different paths based on factors or conditions.

#### **1. The `if` Statement**
The most basic selection statement. It executes a block of code **only if** a specific boolean expression is true.
*   **Syntax:** `if (expression) { // code block }`.
*   **Requirement:** The expression must evaluate to a **boolean** (`true` or `false`).
*   **Example:**
    ```java
    boolean b = true;
    if (b == true) { // If b is true, this block runs
        // Do something
    }
    ```

#### **2. The `if-else` Statement**
Provides exactly two choices: "If this is true, do A; otherwise, do B".
*   **Example:** To check if a number is even or odd using the modulo operator (`%`):
    ```java
    if (i % 2 == 0) {
        System.out.println("i is even");
    } else {
        System.out.println("i is odd");
    }
    ```

#### **3. Curly Braces (`{}`) and Best Practices**
*   **Optional for Single Lines:** If the `if` or `else` block contains only one statement, curly braces are optional.
*   **Best Practice:** Always use curly braces. It improves readability and prevents errors if more lines are added later.

#### **4. Nested `if` Statements**
An `if` statement placed inside another `if` block.
*   **Rule:** An `else` block always belongs to its most recent `if` statement.
*   **Limit:** It is a good practice to avoid nesting deeper than 2 levels to maintain code readability.
*   **Alternative:** Complex nested conditions can often be replaced by using **logical operators** (`&&`, `||`) in a single `if` statement.

#### **5. The `if-else-if` Ladder**
Used when there are multiple conditions to test. As soon as one condition is true, its block is executed, and the rest of the ladder is **skipped**.
*   **Example (Age Categorisation):**
    ```java
    if (age > 80) { System.out.println("Very old"); }
    else if (age > 60) { System.out.println("Old"); }
    else if (age > 40) { System.out.println("Becoming old"); }
    ```
*   **Key Behavior:** If you use independent `if` statements instead of a ladder, multiple blocks might execute if more than one condition is true (e.g., an age of 50 is both >40 and >20).

---

### **Part 3: The `switch` Statement**
The `switch` statement is a more optimized selection statement for multi-way branching.

#### **1. Syntax and Components**
*   **`switch(expression)`:** The expression to test.
*   **`case x:`:** A potential value to match against the expression.
*   **`break;`:** Essential to prevent **"Fall-through."** Without `break`, Java will execute the current case **and all subsequent cases**, even if their conditions are false.
*   **`default:`:** Executes if none of the cases match (similar to the final `else` in a ladder).

#### **2. Limitations of `switch`**
*   **Equality Only:** `switch` can only test for exact equality. It cannot test ranges (like `i > 10`).
*   **Data Types:** Historically, it only allowed `byte`, `short`, `int`, and `char`.
*   **Enhancements:** Since JDK 7, `String` is supported. Since JDK 14, further enhancements were added.
*   **Unique Cases:** Case values must be unique; duplicate cases result in a compile-time error.

#### **3. Internal Optimization (Jump Tables)**
The `switch` statement is often faster than an `if-else-if` ladder because the compiler creates **Jump Tables**.
*   **Efficiency:** While a ladder is $O(n)$ (checks each line one by one), a switch can be $O(1)$ (jumps directly to the correct case).
*   **TableSwitch:** Used for **dense values** (e.g., cases 1, 2, 3). It uses an array-like structure for random access.
*   **LookupSwitch:** Used for **sparse values** (e.g., cases 1, 1000, 100000). It uses **Binary Search** ($O(\log n)$) to find the case.

---

### **Part 4: Type Conversion & Casting**
Type conversion occurs when a value of one data type is assigned to a variable of another type.

#### **1. Implicit Conversion (Widening)**
Happens automatically when the destination type is **wider** than the source type.
*   **Rule:** `byte` → `short` → `int` → `long` → `float` → `double`.
*   **Example:** `int i = b;` where `b` is a `byte`. This works because a 32-bit integer can safely hold an 8-bit byte.
*   **Character to Int:** A `char` (16-bit) can be implicitly converted to an `int` (32-bit) because characters are stored internally as **Unicode** numbers (e.g., 'A' = 97).

#### **2. Explicit Conversion (Narrowing/Casting)**
Required when the destination type is **smaller** than the source type. It must be done manually because it can lead to **data loss**.
*   **Syntax:** `byte b = (byte) i;`.
*   **Logic (Modulo Arithmetic):** If an `int` value (e.g., 300) is cast to a `byte`, the result is the remainder of the value divided by the range of the type.
    *   *Calculation:* `300 % 256 (byte range) = 44`.
*   **Truncation:** Converting a `float` or `double` to an `int` results in **truncating** (deleting) the decimal part entirely (e.g., `15.67` becomes `15`).
*   **Incompatibility:** Conversion between **boolean** and any other data type is **impossible** in Java.

---

### **Part 5: Automatic Type Promotion in Expressions**
When performing mathematical operations, Java automatically promotes operands to a common type to avoid overflow.

#### **1. The Rules of Promotion**
1.  **Small types:** `byte`, `short`, and `char` are promoted to `int` during calculation.
2.  **Long rule:** If one operand is `long`, the entire expression is promoted to `long`.
3.  **Float rule:** If one operand is `float`, the entire expression becomes `float`.
4.  **Double rule:** If any operand is `double`, the final result is `double`.

#### **2. The "Byte Multiplication Trap"**
If you multiply two bytes, the result is automatically promoted to an **int**. You cannot store this result back in a byte without explicit casting.
*   **Error Code:** `byte b = 50; b = b * 2;` (This fails because `b * 2` is an `int`).
*   **Correct Code:** `b = (byte)(b * 2);`.