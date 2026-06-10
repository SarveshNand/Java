### **1. The Java Hierarchy (Concentric Circles)**
The relationship between Java’s core components can be visualized as three concentric circles, where each outer layer contains the inner one plus additional tools:
*   **JVM (Java Virtual Machine):** The innermost core; it runs the code.
*   **JRE (Java Runtime Environment):** JVM + Class Libraries; it provides the environment to run applications.
*   **JDK (Java Development Kit):** JRE + Development Tools (Compiler, Debugger); the complete package for writing and running code.

![JDK, JRE and JVM in Java](https://miro.medium.com/v2/1*4cEBbZkbUMzLMikxcG52tA.png)

---

### **2. JVM: The Heart of Java**
The **JVM (Java Virtual Machine)** is a "virtual computer" or environment where Java Bytecode is executed. Its primary job is to translate platform-independent code into platform-specific machine code.

#### **A. Key Functions of JVM**:
1.  **Code Conversion:** Translates Bytecode into Machine Code (0s and 1s).
2.  **Security (Sandbox Model):** Provides a restricted, safe environment for code execution. It monitors the Bytecode to ensure it doesn't request unauthorized access to the system (like deleting files or installing viruses).
3.  **Garbage Collection:** Automatically manages memory by clearing unused data.

#### **B. How JVM Works: The Hybrid Model (Compiler + Interpreter)**
Java is neither purely a compiled language (like C++) nor purely an interpreted language (like Python); it is **both**.

*   **Interpreter:** Converts Bytecode to Machine Code **line-by-line**.
    *   *Advantage:* Starts the program quickly.
    *   *Disadvantage:* Slower for code that runs repeatedly.
*   **JIT (Just-In-Time) Compiler:** A highly optimized compiler that works alongside the interpreter.
    *   *Function:* It identifies **frequent code** (code used often) and compiles it into machine code all at once for faster execution.
*   **Why both?** In the 1990s, hardware and RAM were limited, so Java used only an interpreter to save resources. In modern Java, the hybrid model uses the speed of JIT for heavy tasks while the interpreter handles the rest, making Java's performance nearly as fast as C++.

---

### **3. JRE: The Runtime Environment**
If you only want to **run** a Java program, you need the **JRE**.
*   **JRE = JVM + Class Libraries**.
*   **Class Libraries:** These are internal Java files containing pre-written code for common tasks, such as printing text to the console or reading files. For example, when you use a command to "print," the logic for how that happens on your screen comes from these libraries.

---

### **4. JDK: The Developer's Kit**
If you want to **write (develop)** Java programs, you must install the **JDK**.
*   **JDK = JRE + Development Tools**.
*   **Key Tools included:**
    *   **Compiler (`javac`):** Converts your Source Code (`.java`) into Bytecode (`.class`).
    *   **Debugger:** Helps you find errors by running code line-by-line.
    *   **JavaDocs:** Tools for creating documentation.

---

### **5. The Three Editions of Java**
Java is categorized based on its application area:
1.  **JSE (Java Standard Edition):** Also known as **Core Java**. It covers fundamental concepts like OOPs (Object-Oriented Programming), classes, and methods.
2.  **JEE (Java Enterprise Edition):** Now called **Jakarta EE**. It includes extra libraries for building large-scale web applications and websites (e.g., Spring Boot).
3.  **JME (Java Micro Edition):** A lightweight version used for early mobile phone apps. It is now largely **obsolete**, having been replaced by Android (which uses Java/Kotlin).

---

### **6. Practical Example: Executing a Program**
To run a Java program, you follow a specific workflow using the terminal or an IDE like VS Code.

#### **Step 1: Write the Source Code**
Create a file ending in `.java`.
*   *Example File:* `Demo.java`.
*   *Example Code:* `System.out.println("Hello World");`.

#### **Step 2: Compile (Create Bytecode)**
Use the Java Compiler command in the terminal:
*   **Command:** `javac Demo.java`
*   **Result:** A new file named `Demo.class` is created. This file contains **Bytecode**, which is the intermediate, platform-independent code.

#### **Step 3: Run (Execute via JVM)**
Use the Java runner command:
*   **Command:** `java Demo` (Note: You do not add the extension here).
*   **Internal Action:** The JRE/JVM takes the `Demo.class` file, uses the interpreter and JIT to turn it into machine code, and the CPU provides the output.
*   **Output:** `Hello World`.

**Important Note:** While the Bytecode (`.class` file) is the same on all computers, the **JVM itself is platform-specific** (you need a Windows JVM for Windows and a Mac JVM for Mac) to ensure it can talk to that specific hardware.