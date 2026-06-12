
### **1. Introduction to Functions**
A function is a **block of code** designed to perform a specific task. The primary philosophy behind functions is **Code Reusability**—allowing developers to write a piece of logic once and call it multiple times instead of repeating the same lines of code throughout a program.

*   **Example Scenario:** If you need to add two numbers, print the result, and do this ten times at different points in your code, writing the addition logic every time is inefficient. Instead, you create a `sum` function and "call" it whenever needed.

---

### **2. Function Syntax and Components**
In Java, a function (often called a "method" in Object-Oriented Programming) has a specific structure.

#### **A. The Standard Syntax**
`static Return_Type Function_Name (Parameters) { // Body of function }`

*   **Return Type:** The data type of the value the function sends back to the caller (e.g., `int`, `double`, `String`). If the function doesn't return anything, the keyword **`void`** is used.
*   **Function Name:** A descriptive name used to identify and call the function (e.g., `sum`, `multiply`).
*   **Parameters:** The inputs the function expects to work with, defined by their data type and a variable name (e.g., `int a, int b`).
*   **Return Statement:** The `return` keyword is used to send the output back to the caller. Once a `return` is executed, the function terminates.
*   **Static Keyword:** In the early stages of Java learning, this is used as a "black box" requirement to allow the main method to call the function without creating an object.

---

### **3. Calling a Function: Parameters vs. Arguments**
*   **Calling a Function:** You invoke a function by writing its name followed by parentheses containing the required values.
*   **Parameters:** These are the variables defined in the function's declaration (e.g., `int a, int b` in the `sum` function).
*   **Arguments:** These are the **actual values** or variables passed to the function during the call (e.g., `sum(4, 5)`—here 4 and 5 are arguments).
    *   *Internal Logic:* When a function is called, arguments are assigned to the parameters (e.g., the value of argument `i` is assigned to parameter `a`).

---

### **4. Four Types of Functions**
Functions are categorised based on whether they take inputs and whether they provide outputs.

1.  **No Input, No Output:** Uses `void` and empty brackets.
    *   *Example:* `static void greet() { System.out.println("Hello"); }`.
2.  **Input, No Output:** Takes parameters but uses `void`.
    *   *Example:* `static void sayHello(String name) { System.out.println("Hello " + name); }`.
3.  **No Input, but Output:** Provides a return value without needing external input.
    *   *Example:* `static int getNumber() { return 10; }`.
4.  **Both Input and Output:** Takes parameters and returns a calculated result.
    *   *Example:* `static int sum(int a, int b) { return a + b; }`.

---

### **5. Function Overloading**
Function overloading allows a class to have **multiple functions with the same name**, provided their "signatures" (parameter lists) are different.

**Rules for Overloading:**
1.  **Change in Number of Parameters:** One `sum` takes two integers, while another `sum` takes three.
2.  **Change in Data Types of Parameters:** One `sum` takes `int`, another takes `double`.
3.  **Change in Order of Parameters:** One function takes `(String, int)`, while another takes `(int, String)`.

**Crucial Rule:** You **cannot** overload a function based **only on its return type**. The compiler will be confused if it doesn't know which function to call based solely on the arguments provided.

---

### **6. Function Chaining**
Function chaining occurs when one function calls another, which may call a third, and so on.
*   **Execution Flow:** The JVM executes line-by-line. If Function A calls Function B, the control jumps to B. Once B finishes (returns), control returns to the exact spot in A where it left off to continue execution.
*   **The "Main" Method:** In Java, the `public static void main` method is the entry point. The JVM calls `main`, and `main` typically orchestrates the calls to all other functions.

---

### **7. Scope of Variables**
The "scope" refers to the visibility and lifetime of a variable.

*   **Local Scope:** Variables declared inside a block of curly braces `{}` (like a function, `if` statement, or loop) are only accessible within those braces. Once the block finishes execution, the variable is destroyed from memory.
*   **Global Scope:** Variables declared outside of methods (typically at the class level with the `static` keyword) are accessible throughout the entire file. They remain in memory as long as the class is active.

---

### **8. Recursion**
Recursion is a process where a **function calls itself** to solve a problem.

#### **A. Key Components of Recursion**
1.  **Recursive Call:** The statement where the function calls itself with a modified parameter (usually moving toward a solution).
2.  **Base Case:** A mandatory condition that stops the recursion. Without a base case, the function would call itself infinitely and crash the program.

#### **B. Example: Printing 1 to N**
To print numbers from 1 to 5 using recursion:
*   The function calls itself with `n-1` (e.g., `printNum(5)` calls `printNum(4)`...).
*   This creates a "chain" or stack of calls down to the base case (`n == 0`).
*   Once the base case is reached, the functions start returning in reverse order, executing their print statements as they "climb back up" the chain.

#### **C. Example: Fibonacci Sequence**
Recursion is highly effective for problems that can be defined mathematically in terms of themselves, such as Fibonacci: `Fib(n) = Fib(n-1) + Fib(n-2)`. By defining base cases (for `n=0` or `n=1`), recursion can automatically calculate complex sequences by branching into a "tree" of calls.