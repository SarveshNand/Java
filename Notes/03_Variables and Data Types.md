### **1. Core Concepts: Variables, Identifiers, and Literals**
A program's primary goal is to perform actions like printing to a screen or calculating values, which often requires storing data in memory.
*   **Variable:** Think of a variable as a **container** in the computer's memory (RAM) that holds a value. For example, in a calculator app, you would need containers to store the two numbers you wish to add.
*   **Identifier:** This is the **name** given to the container/variable to identify it. While you can use simple names like `x` or `y`, it is a best practice in computer science to use **descriptive names** like `firstNumber` or `secondNumber` to make the code understandable.
*   **Literal:** This is the **actual value** stored inside the container (e.g., the number `12` in a variable named `B`).

### **2. Variable Syntax and Declaration**
Java is a **statically typed** language, meaning you must declare the type of data a variable will hold before the program is compiled.

**The Standard Syntax:**
`Data_Type Identifier = Value;`
*   **Example:** `int firstNumber = 10;`
*   **Note:** Every line of code in Java must end with a **semicolon (`;`)** to indicate the end of the statement.

**Declaration vs. Definition:**
*   **Declaration:** Telling the compiler a variable exists (e.g., `int x;`). This allocates memory (e.g., 32 bits for an integer) but doesn't assign a value yet.
*   **Definition (Initialization):** Giving the variable a specific value (e.g., `x = 5;`). Often, these two steps are done simultaneously.

---

### **3. Primitive Data Types**
Java categorizes data into two main types: **Primitive** and **Non-Primitive**. The sources focus on the four primary categories of Primitive data types:

#### **A. Integers**
These store whole numbers. Java provides four types based on the **range** (size) of the number:
1.  **byte:** 8-bit size. Range: -128 to 127.
2.  **short:** 16-bit size. Range: -32,768 to 32,767.
3.  **int:** 32-bit size. Standard for most whole numbers.
4.  **long:** 64-bit size. Used for massive numbers in the quadrillions.
*   **Pro Tip:** For large numbers, you can use **underscores** to improve readability (e.g., `long money = 12_34_56_789L;`). The compiler ignores these underscores.

#### **B. Real Numbers (Floating Point)**
These store numbers with decimals.
1.  **float:** 32-bit size. Known as "single precision." You **must** add an `f` suffix (e.g., `10.54f`) because Java defaults to `double` for decimals.
2.  **double:** 64-bit size. Known as "double precision." This is the industry standard for production and scientific calculations because modern processors are optimized for it.
*   **Scientific Notation:** You can represent large decimals using an exponent (e.g., Avogadro's constant: `double d = 6.022e23;`).

#### **C. Characters (char)**
*   **Definition:** Stores a single character (e.g., `'a'`, `'B'`, or symbols).
*   **Syntax:** Must be enclosed in **single quotes** (e.g., `char letter = 'a';`) to distinguish them from identifiers.
*   **Unicode vs. ASCII:** Unlike older languages that used 8-bit ASCII, Java uses **16-bit Unicode**. This allows Java to represent characters from every language in the world, not just English. Internally, Java converts characters to integers (Unicode values) before storing them as binary.

#### **D. Boolean**
*   **Values:** Can only be `true` or `false`.
*   **Note:** Unlike C++, you cannot use `0` for false or `1` for true in Java; it only accepts the literal words `true` or `false`.

---

### **4. Advanced Number Systems**
While you usually write numbers in Decimal (Base 10), Java allows you to store integers using other systems by using specific prefixes:
*   **Binary (Base 2):** Prefix with `0b` (e.g., `int b = 0b101;` which is 5).
*   **Octal (Base 8):** Prefix with `0` (e.g., `int o = 05;`).
*   **Hexadecimal (Base 16):** Prefix with `0x`. Uses numbers 0-9 and letters A-F for values 10-15 (e.g., `0xf` is 15).

---

### **5. Keywords and Identifiers**
*   **Keywords:** These are **68 reserved words** that have a special meaning to Java (e.g., `public`, `class`, `static`, `void`, `int`).
*   **Rule:** You **cannot** use keywords as names for your variables (identifiers) because it would confuse the compiler.
*   **Interesting Fact:** Some keywords like `goto` and `const` are reserved but never actually used by Java.

---

### **6. Comments**
Comments are notes for developers that the compiler completely ignores.
*   **Single-line:** Starts with `//`.
*   **Multi-line:** Encased between `/*` and `*/`.