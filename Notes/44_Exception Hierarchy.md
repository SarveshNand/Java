# Java Exception Handling (Advanced)

---

# 1. Nested Try-Catch Blocks

## What is Nested Try-Catch?

A try-catch block inside another try-catch block.

Structure:

```java
try {

    try {

    }
    catch(Exception e){

    }

}
catch(Exception e){

}
```

---

# Why Use Nested Try-Catch?

Sometimes different operations require different handling.

Example:

```java
try {

    // Database Connection

    try {
        // File Reading
    }
    catch(IOException e){
        System.out.println("File Error");
    }

}
catch(SQLException e){
    System.out.println("Database Error");
}
```

Different failures need different solutions.

---

# Exception Search Process

Suppose:

```java
try {

    try {

        int x = 10 / 0;

    }
    catch(NullPointerException e){

    }

}
catch(Exception e){

}
```

---

# Flow Diagram

```text
Inner Try
    │
    ▼

ArithmeticException

    │
    ▼

Matching Catch Found?
    │
 ┌──┴───┐
 │      │
No     Yes
 │      │
 ▼      ▼

Outer Catch
        Handle
```

---

# Example

```java
try {

    try {

        int x = 10 / 0;

    }
    catch(NullPointerException e){

        System.out.println("Inner Catch");

    }

}
catch(ArithmeticException e){

    System.out.println("Outer Catch");

}
```

Output:

```text
Outer Catch
```

---

# Why?

Because:

```java
catch(NullPointerException e)
```

cannot handle:

```java
ArithmeticException
```

Therefore exception propagates outward.

---

# Real-Life Analogy

```text
Employee
   │
   ▼

Team Lead
   │
   ▼

Manager
   │
   ▼

Director
```

Problem occurs:

```text
Employee
```

asks:

```text
Team Lead
```

Can you solve it?

If NO:

```text
Manager
```

Can you solve it?

If NO:

```text
Director
```

This is exactly exception propagation.

---

# Best Practice

Avoid excessive nesting.

Bad:

```java
try{
    try{
        try{
            try{

            }
            catch(Exception e){}
        }
        catch(Exception e){}
    }
    catch(Exception e){}
}
catch(Exception e){}
```

This becomes difficult to maintain.

Prefer:

```java
Separate Methods
Meaningful Exception Handling
```

---

# 2. Java Exception Hierarchy

Every throwable object belongs to this hierarchy.

---

# Complete Hierarchy

```text
Object
  │
  ▼

Throwable
  │
  ├──────────────┐
  ▼              ▼

Exception      Error
  │
  │
  ├── RuntimeException
  │        │
  │        ├── ArithmeticException
  │        ├── NullPointerException
  │        ├── NumberFormatException
  │        ├── ClassCastException
  │        └── ArrayIndexOutOfBoundsException
  │
  └── Checked Exceptions
           │
           ├── IOException
           ├── SQLException
           ├── FileNotFoundException
           └── InterruptedException
```

---

# Throwable

Root class.

Anything that can be:

```java
throw
```

must inherit from:

```java
Throwable
```

---

# Interview Question

### Can we throw an object that doesn't extend Throwable?

No.

Invalid:

```java
throw new String("Error");
```

Compilation Error.

---

# 3. Error vs Exception

---

# Error

Serious JVM/System-level problem.

Examples:

```java
OutOfMemoryError
StackOverflowError
VirtualMachineError
```

---

# Example

Heap full:

```text
No Memory Available
```

JVM throws:

```java
OutOfMemoryError
```

---

# Stack Overflow

Infinite recursion:

```java
void test(){
    test();
}
```

Produces:

```java
StackOverflowError
```

---

# Exception

Recoverable application problem.

Examples:

```java
IOException
ArithmeticException
SQLException
```

Program may continue.

---

# Comparison

| Error            | Exception         |
| ---------------- | ----------------- |
| JVM/System Issue | Application Issue |
| Not Recoverable  | Recoverable       |
| Rarely Handled   | Commonly Handled  |
| Error Class      | Exception Class   |

---

# 4. Checked vs Unchecked Exceptions

Most important interview topic.

---

# Checked Exceptions

Compiler checks them.

Examples:

```java
IOException
SQLException
FileNotFoundException
InterruptedException
```

---

# Example

```java
FileReader fr =
    new FileReader("abc.txt");
```

Compiler says:

```text
Unhandled exception
```

Must:

```java
try-catch
```

or

```java
throws
```

---

# Checked Exception Flow

```text
Code
 │
 ▼

Compiler Checks
 │
 ▼

Handled?
 │      │
No     Yes
 │      │
 ▼      ▼

Compilation Error
```

---

# Unchecked Exceptions

Subclass of:

```java
RuntimeException
```

Examples:

```java
NullPointerException
ArithmeticException
ClassCastException
ArrayIndexOutOfBoundsException
```

Compiler ignores them.

---

# Why?

Because they usually indicate programming mistakes.

Example:

```java
String s = null;
s.length();
```

Programmer should fix code.

---

# Memory Trick

```text
Checked
=
Compiler Checks

Unchecked
=
Compiler Doesn't Check
```

---

# 5. Multiple Catch Blocks

One try can have many catches.

---

# Example

```java
try{

    String s = null;

    System.out.println(s.length());

}
catch(ArithmeticException e){

    System.out.println("Math Error");

}
catch(NullPointerException e){

    System.out.println("Null Error");

}
```

Output:

```text
Null Error
```

---

# Matching Process

```text
Exception Occurs
      │
      ▼

Catch 1 Match?
      │
   No ▼

Catch 2 Match?
      │
   Yes▼

Execute
```

---

# Important Rule

Only ONE catch executes.

Even if parent catches could also handle it.

---

# 6. Catch Ordering Rule

Most frequently asked interview question.

---

# Wrong

```java
try{

}
catch(Exception e){

}
catch(ArithmeticException e){

}
```

Compiler Error.

---

# Why?

Because:

```java
Exception
```

already catches:

```java
ArithmeticException
```

Child catch becomes unreachable.

---

# Correct

```java
try{

}
catch(ArithmeticException e){

}
catch(Exception e){

}
```

---

# Rule

```text
Child First

Parent Last
```

---

# Hierarchy Example

```text
Exception
   │
   ▼

RuntimeException
   │
   ▼

ArithmeticException
```

Order:

```java
catch(ArithmeticException e)

catch(RuntimeException e)

catch(Exception e)
```

---

# Memory Trick

```text
Specific → Generic

Child → Parent
```

---

# 7. Multi-Catch (Java 7)

Before Java 7:

```java
catch(IOException e){

}

catch(SQLException e){

}
```

---

# Java 7+

```java
catch(IOException | SQLException e){

}
```

---

# Diagram

```text
IOException
      │
      ├────► Same Catch
      │
SQLException
```

---

# Important Rule

Only sibling exceptions.

Valid:

```java
IOException | SQLException
```

---

Invalid:

```java
Exception | IOException
```

because:

```text
Parent + Child
```

causes ambiguity.

---

# 8. throw Keyword

Used to manually create and throw exceptions.

---

# Syntax

```java
throw new Exception("Error");
```

---

# Example

```java
int age = -5;

if(age < 0){

    throw new IllegalArgumentException(
        "Age cannot be negative"
    );
}
```

Output:

```text
IllegalArgumentException:
Age cannot be negative
```

---

# Use Cases

Business validation.

Examples:

```java
Invalid Age
Invalid Salary
Invalid Account
Insufficient Balance
```

---

# Flow

```text
Business Rule
      │
      ▼

Violation?
      │
   Yes▼

throw Exception
```

---

# Interview Question

### Can we throw checked exceptions manually?

Yes.

```java
throw new IOException();
```

---

# 9. throws Keyword

Used in method declaration.

---

# Syntax

```java
public void readFile()
        throws IOException
```

Meaning:

```text
I may generate IOException.
Caller must handle it.
```

---

# Example

```java
void readFile()
throws IOException {

    FileReader fr =
        new FileReader("test.txt");
}
```

---

# Flow Diagram

```text
Method
   │
   ▼

throws IOException
   │
   ▼

Caller Responsible
```

---

# throw vs throws

| throw          | throws                       |
| -------------- | ---------------------------- |
| Inside method  | Method signature             |
| Throws object  | Declares exception           |
| One object     | Multiple exceptions possible |
| Runtime action | Compile-time declaration     |

---

# Example Together

```java
void validate(int age)
throws Exception {

    if(age < 0){

        throw new Exception(
            "Invalid Age"
        );

    }
}
```

---

# Memory Trick

```text
throw
    →
    THROW Object

throws
    →
    THROWS Responsibility
```

---

# 10. Custom Exceptions

Why create custom exceptions?

Because generic exceptions are vague.

Bad:

```java
RuntimeException
```

Good:

```java
InsufficientBalanceException
```

---

# Example

```java
class InvalidAgeException
extends Exception {

    public InvalidAgeException(
            String msg){

        super(msg);

    }
}
```

---

# Usage

```java
if(age < 18){

    throw new InvalidAgeException(
        "Age must be 18+"
    );
}
```

---

# Real-World Examples

```java
UserNotFoundException

InvalidOtpException

PaymentFailedException

InsufficientBalanceException

ProductOutOfStockException
```

---

# Custom Exception Flow

```text
Business Rule
      │
      ▼

Violation
      │
      ▼

Custom Exception
      │
      ▼

Meaningful Error
```

---

# Checked or Unchecked?

Checked:

```java
extends Exception
```

Unchecked:

```java
extends RuntimeException
```

---

# Interview Tip

Business exceptions are often:

```java
RuntimeException
```

in Spring Boot applications.

---

# 11. Try-With-Resources

Introduced in Java 7.

---

# Problem Before Java 7

```java
FileReader fr = null;

try{

    fr = new FileReader("a.txt");

}
finally{

    if(fr != null){

        fr.close();

    }
}
```

Lots of boilerplate code.

---

# Solution

```java
try(
    FileReader fr =
        new FileReader("a.txt")
){

}
```

Resource closes automatically.

---

# Internal Flow

```text
Create Resource
      │
      ▼

Use Resource
      │
      ▼

Exception?
 │      │
No     Yes
 │      │
 ▼      ▼

Auto Close Resource
```

---

# Example

```java
try(
    BufferedReader br =
        new BufferedReader(
            new FileReader("test.txt")
        )
){

    System.out.println(
        br.readLine()
    );

}
catch(IOException e){

    e.printStackTrace();

}
```

---

# Why It Works?

Resources implement:

```java
AutoCloseable
```

or

```java
Closeable
```

---

# AutoCloseable Hierarchy

```text
AutoCloseable
      │
      ▼

Closeable
      │
      ▼

FileReader

BufferedReader

Scanner
```

---

# Benefits

✔ Cleaner Code

✔ No finally block needed

✔ Automatic cleanup

✔ Prevents memory leaks

✔ Recommended approach

---

# Quick Revision Sheet

```text
Nested Try
    -> Inner handled first

Throwable
    -> Root Class

Error
    -> JVM Problem

Exception
    -> Application Problem

Checked
    -> Compiler Checks

Unchecked
    -> RuntimeException

Multiple Catch
    -> One catch executes

Catch Order
    -> Child First

throw
    -> Throw Object

throws
    -> Declare Responsibility

Custom Exception
    -> Business-Specific Errors

Try-With-Resources
    -> Automatic Resource Cleanup
```

---

# Interview One-Liner

"Java Exception Handling is built on the Throwable hierarchy, where exceptions propagate through the call stack until a matching handler is found. Features such as multiple catches, throw/throws, custom exceptions, and try-with-resources provide robust mechanisms for creating maintainable, fault-tolerant, and resource-safe applications."
