### **1. Iteration Statements (Loops)**
In Java, iteration statements—commonly called **loops**—allow a specific part of code to be executed repeatedly for a predefined number of times or until a condition is met. Java divides loops into three main types: **`while`**, **`do-while`**, and **`for`**.

#### **A. The `while` Loop**
The `while` loop checks a boolean condition **before** entering the loop body.
*   **Syntax:** `while (expression) { // do something }`.
*   **Execution Flow:** If the expression evaluates to `true`, the code block executes. The control flow then returns to the expression to check again. This repeats until the condition becomes `false`.
*   **Infinite Loops:** If the condition never becomes false, the loop runs forever, potentially crashing the system by exhausting memory.
*   **Reverse Looping:** Loops can count backward by starting with a high value and using the decrement operator (`--`).
*   **Combined Operators:** Java allows incrementing/decrementing directly within the loop condition (e.g., `while (i++ < 10)`). However, this can change the output range (e.g., printing 2–11 instead of 1–10) because the comparison happens before the value is used in the body.

#### **B. The `do-while` Loop**
This is a variant of the `while` loop that checks the condition **after** executing the code block.
*   **Syntax:** `do { // do something } while (expression);`.
*   **Key Difference:** Unlike the `while` loop, which may never run if the initial condition is false, the `do-while` loop **always executes at least once**.
*   **Practical Example (Menu Selection):** It is the ideal choice for creating menu-driven programs (like a game menu). The program first shows the options (Play, Save, Exit) to the user and *then* checks their input to decide whether to loop or exit.

#### **C. The `for` Loop**
The `for` loop is the most frequently used loop in production because it consolidates initialization, condition, and increment/decrement into one line.
*   **Standard Syntax:** `for (initialization; condition; increment/decrement) { // body }`.
*   **Internal Execution Steps:**
    1.  **Initialization:** Happens once when entering the loop.
    2.  **Condition Check:** If `true`, the body executes; if `false`, the loop terminates.
    3.  **Body Execution:** The code inside the curly braces runs.
    4.  **Increment/Decrement:** The variable is updated, and the flow returns to Step 2.
*   **Optional Parts:** All three parts of the `for` loop are optional. A `for ( ; ; )` statement creates a valid infinite loop.
*   **Comma-Separated Variation:** You can manage multiple variables in a single loop by separating them with commas (e.g., `for (int i=1, j=1; i<=10; i++, j+=2)`). However, multiple conditions must be joined using logical operators (`&&`, `||`) rather than commas.
*   **Data Type Choice:** Developers almost always use `int` for loop counters. Even if a `byte` or `short` is used, Java internally promotes it to an `int` for calculations, so using `int` directly is more efficient.

---

### **2. Nested Loops and Complexity**
A **nested loop** is a loop placed inside the body of another loop.
*   **Execution Logic:** For every single iteration of the outer loop, the inner loop completes its **entire** cycle.
*   **Complexity:** If an outer loop runs $n$ times and an inner loop runs $m$ times, the total iterations are $n \times m$. In cases where both run $n$ times, the time complexity is $O(n^2)$.
*   **Example (Pattern Printing):** Nested loops are used to print geometric patterns. For a right-angled triangle of stars, the outer loop handles the number of lines (rows), while the inner loop handles the number of stars per line (columns), with its limit tied to the outer loop's current value.

---

### **3. Jump Statements: `break` and `continue`**
Jump statements provide finer control over loop execution.

#### **A. `break`**
The `break` statement immediately terminates the loop and moves the control flow to the first line after the loop block.
*   **Use Case (Prime Numbers):** When checking if a number is prime, you loop through divisors. As soon as you find one divisor, you know the number is not prime; you use `break` to exit early because further checking is unnecessary.

#### **B. `continue`**
The `continue` statement skips the remaining code in the **current iteration** and jumps directly to the next iteration.
*   **Example (Odd Numbers):** If you want to print only odd numbers from 1 to 10, you can check if a number is even. If it is, the `continue` statement skips the print command and moves to the next number.

#### **C. Labels and Code Blocks**
*   **Labels:** In nested loops, a simple `break` only exits the innermost loop. Java allows you to **label** loops (e.g., `outer: for(...)`). You can then use `break outer;` to exit multiple levels of nesting at once.
*   **Named Code Blocks:** You can create standalone code blocks using curly braces and label them even without a loop. `break` can then be used to jump out of those specific blocks.

---

### **4. Type Conversion and Promotion**
Java handles data movement between types through conversion and promotion.

#### **A. Implicit vs. Explicit Conversion**
1.  **Implicit (Widening):** Occurs automatically when moving from a narrower type to a wider type (e.g., `byte` to `int`). This is safe because a larger container can always hold a smaller one.
2.  **Explicit (Narrowing/Casting):** Required when moving from a wider type to a narrower one (e.g., `int` to `byte`). This requires manual syntax: `(targetType) variable;`.
    *   **Internal Logic (The 300 Example):** If you cast `int 300` to a `byte`, Java takes the 32-bit binary and keeps only the last 8 bits. The decimal result becomes **44**.
    *   **Modulo Rule:** The resulting value can be predicted using modulo: `Value % Range`. For a `byte` (range 256), $300 \pmod{256} = 44$.
3.  **Truncation:** When casting `float` or `double` to `int`, the decimal part is entirely discarded (e.g., `15.67` becomes `15`).
4.  **Boolean Restriction:** In Java, it is **impossible** to convert or cast a `boolean` to any other data type; such attempts cause a compile-time error.

#### **B. Automatic Type Promotion**
In mathematical expressions, Java promotes operands to prevent intermediate overflow.
*   **Small Types:** `byte`, `short`, and `char` are promoted to `int` during calculation.
*   **Promotion Ladder:** If an expression contains mixed types, the entire result is promoted to the **largest** type present (following the order: `int` → `long` → `float` → `double`).
*   **Calculation Trap:** Multiplying two `byte` variables results in an `int`. Therefore, assigning that result back to a `byte` requires explicit casting: `b = (byte)(b * 2);`.