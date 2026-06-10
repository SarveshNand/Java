### **1. Internal Storage of Negative Numbers (Two’s Complement)**
Computers only understand binary (0s and 1s) and do not have a native concept of a "minus sign". Java uses the **Two's Complement** method to represent negative integers in memory.

#### **A. The Three-Step Storage Process**
To store a negative number like **-42** in a `byte` (8-bit), the following steps are performed:
1.  **Find the Positive Binary:** Ignore the sign and find the binary for 42.
    *   42 in binary (8 bits) = `00101010`.
2.  **First Complement (One's Complement):** Invert all bits (0 becomes 1, 1 becomes 0).
    *   `00101010` → `11010101`.
3.  **Second Complement (Two's Complement):** Add **1** to the First Complement.
    *   `11010101 + 1` = `11010110`.
    *   **Memory Action:** This final value (`11010110`) is what is actually stored in the container for -42.

#### **B. Sign Detection (MSB and LSB)**
*   **MSB (Most Significant Bit):** The leftmost bit. If MSB is **1**, the number is negative; if it is **0**, it is positive.
*   **LSB (Least Significant Bit):** The rightmost bit, which has the lowest value significance.
*   **Retrieval:** When Java reads a memory location where MSB is 1, it knows the number is negative. To show the decimal value, it reverses the process: finds the 1's complement, adds 1, and attaches a negative sign.

#### **C. Why Use Two's Complement? (The Zero Case)**
Two's complement is used specifically to handle the **"Negative Zero"** problem.
*   In One's Complement, there would be two representations for zero: positive zero (`00000000`) and negative zero (`11111111`).
*   In Two's Complement, adding 1 to `11111111` results in a 9-bit number (`100000000`). Since a `byte` only holds 8 bits, the extra '1' is ignored, leaving exactly `00000000`. This ensures zero has only one unique representation.

---

### **2. Internal Storage of Floating-Point Numbers (IEEE 754)**
Java follows the **IEEE 754 Standard** for storing decimal numbers. A 32-bit `float` is divided into three parts:
*   **Sign Bit (1 bit):** 0 for positive, 1 for negative.
*   **Exponent (8 bits):** Stores the power to which 2 is raised, adjusted by a "Bias".
*   **Mantissa (23 bits):** Stores the actual digits (fractional part) of the number.

#### **A. Example: Storing 8.125f**
1.  **Convert to Binary:**
    *   Left side (8) = `1000`.
    *   Right side (0.125) = `001` (calculated by repeated multiplication by 2).
    *   Total Binary = `1000.001`.
2.  **Scientific Notation:** Move the decimal to create a $1.x$ format.
    *   `1000.001` becomes $1.000001 \times 2^3$.
3.  **Add Bias:** To avoid storing negative exponents, a bias of **127** is added to the exponent.
    *   Exponent ($3$) + Bias ($127$) = **130**.
    *   130 in binary (8 bits) = `10000010`.
4.  **Final Storage:**
    *   Sign: `0`
    *   Exponent: `10000010`
    *   Mantissa: `000001` (followed by zeros to fill 23 bits).

---

### **3. The Precision Problem (The 0.7f Case)**
Not all decimal numbers can be represented exactly in binary, leading to "precision loss".

*   **The Issue:** When converting **0.7** to binary, the pattern repeats infinitely (`0.101100110011...`).
*   **Truncation:** Because the Mantissa is limited to 23 bits, the computer must "cut off" (truncate) the infinite pattern.
*   **The Result:** When you retrieve 0.7f and use `printf` to see 20 decimal places, you get **0.69999998807907104492**.
*   **Java's Behavior:** By default, `System.out.println` rounds these values to show "0.7", hiding the internal inaccuracy.

---

### **4. Double vs. BigDecimal**
*   **Double (64-bit):** Uses 11 bits for the exponent and 52 bits for the mantissa. It uses a bias of **1023**. While more precise than `float`, it still provides estimated values for many decimals.
*   **BigDecimal:** A non-primitive type in Java that provides **exact values** without estimation, though it is discussed as a future topic in the source.

### **Summary Table: Internal Layout**
| Feature | Float (32-bit) | Double (64-bit) |
| :--- | :--- | :--- |
| **Sign Bit** | 1 bit | 1 bit |
| **Exponent** | 8 bits | 11 bits |
| **Mantissa** | 23 bits | 52 bits |
| **Bias** | 127 | 1023 |