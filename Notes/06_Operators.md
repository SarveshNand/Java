### **1. Arithmetic Operators**
Arithmetic operators are used to perform mathematical calculations.

*   **Basic Operators:** `+` (Addition), `-` (Subtraction), `*` (Multiplication), `/` (Division), and `%` (Modulo).
    *   **Modulo (`%`):** Returns the **remainder** of a division. For example, `10 % 3` results in `1`, while `10 % 5` results in `0`.
*   **Compound Assignment Operators:** These combine an arithmetic operator with an assignment to save space.
    *   **Syntax:** `h += 2;` is equivalent to `h = h + 2;`.
    *   **Others:** `-=`, `*=`, `/=`, `%=`.
*   **Increment and Decrement (Unary):** Used to increase or decrease a value by exactly 1.
    *   **Increment (`++`):** `i++` is the same as `i = i + 1`.
    *   **Decrement (`--`):** `i--` is the same as `i = i - 1`.

#### **Prefix vs. Postfix Increment/Decrement**
There is a critical difference in how Java processes the order of operation:
*   **Postfix (`j++`):** The current value is used/assigned **first**, and the increment happens **afterward**.
    *   *Example:* If `j = 9` and you write `k = j++;`, then `k` becomes `9` and `j` becomes `10`.
*   **Prefix (`++j`):** The value is incremented **first**, and the new value is then assigned/used.
    *   *Example:* If `j = 10` and you write `l = ++j;`, both `l` and `j` become `11`.

---

### **2. Relational Operators**
These compare two values and always return a **boolean** (`true` or `false`).

*   **Operators:** `==` (Equal to), `!=` (Not equal to), `<` (Less than), `>` (Greater than), `<=` (Less than or equal to), `>=` (Greater than or equal to).
*   **Assignment (`=`) vs. Relational (`==`):**
    *   `a = b` assigns the value of `b` to `a`.
    *   `a == b` asks the compiler: "Is `a` equal to `b`?".

---

### **3. Bitwise Operators**
These operate at the **bit level** (0s and 1s) inside the computer's memory.

*   **Bitwise AND (`&`):** Result is `1` only if both bits are `1`.
*   **Bitwise OR (`|`):** Result is `1` if at least one bit is `1`.
*   **Bitwise XOR (`^`):** Result is `1` only if there is an **odd number of 1s** (e.g., `1 ^ 0 = 1`, but `1 ^ 1 = 0`).
*   **Bitwise NOT (`~`):** Reverses the bits (0 becomes 1, 1 becomes 0).

#### **Shift Operators**
*   **Left Shift (`<<`):** Moves bits to the left and fills the empty spots with 0s. This effectively **multiplies** the number by 2 for every shift position.
    *   *Example:* `8 << 1` becomes `16`.
*   **Right Shift (`>>`):** Moves bits to the right. To maintain the sign of the number, it fills the empty spots with the original **sign bit** (0 for positive, 1 for negative). This effectively **divides** the number by 2.
*   **Unsigned Right Shift (`>>>`):** Moves bits to the right but **always fills with 0**, regardless of whether the number was positive or negative.

**Internal Rules for Shifting:**
1.  **Type Promotion:** Java only performs shifts on `int` and `long`. If you shift a `byte` or `short`, it is automatically promoted to an `int` first.
2.  **Modulo 32 Rule:** For an `int`, you can only shift between 0 and 31 times. If you try to shift 32 times, Java performs `32 % 32 = 0`, meaning the number remains unchanged.

---

### **4. Logical Operators**
Used to combine multiple boolean expressions.

*   **Logical AND (`&&`):** Returns `true` only if both expressions are true.
*   **Logical OR (`||`):** Returns `true` if at least one expression is true.
*   **Short-Circuiting:**
    *   In `&&`, if the first condition is `false`, Java skips checking the second condition because the result will be false regardless.
    *   In `||`, if the first condition is `true`, Java skips checking the second because the result will be true regardless.
*   **Pro Tip:** Using single `&` or `|` on boolean expressions forces Java to evaluate **both** sides without short-circuiting.

---

### **5. Assignment and Ternary Operators**
*   **Chained Assignment:** You can assign one value to multiple variables at once: `int a = b = c = 10;`. This evaluates from **right to left**.
*   **Ternary Operator:** The only operator that takes **three operands**. It acts as a shortcut for `if-else` (Syntax: `condition ? value_if_true : value_if_false`).

---

### **6. Operator Precedence**
When multiple operators appear in one line, Java follows a specific order (Precedence Table):
1.  **Postfix** (`i++`, `i--`)
2.  **Prefix/Unary** (`++i`, `--i`, `~`, `!`)
3.  **Multiplicative** (`*`, `/`, `%`)
4.  **Additive** (`+`, `-`)
5.  **Shift** (`<<`, `>>`, `>>>`)
6.  **Relational** (`<`, `>`, `<=`, `>=`)
7.  **Bitwise** (`&`, `^`, `|`)
8.  **Logical** (`&&`, `||`)
9.  **Assignment** (`=`, `+=`, etc.)

**Best Practice:** Do not rely on memory for precedence. Always use **brackets `()`** to clearly define the order of operations and ensure your code is readable.