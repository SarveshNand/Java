# Java Exception Handling

---

# 1. Why Exception Handling Exists?

In the real world, programs rarely run perfectly.

Things can go wrong due to:

* Invalid user input
* Missing files
* Database failures
* Network issues
* Mathematical errors
* Memory shortages

Example:

```java
int a = 10;
int b = 0;

System.out.println(a / b);
```

Output:

```text
Exception in thread "main"
java.lang.ArithmeticException: / by zero
```

Without exception handling:

```text
Program Crashes
Remaining Code Doesn't Execute
```

---

# Real-Life Analogy

Imagine an ATM.

Normal Flow:

```text
Insert Card
    ↓
Enter PIN
    ↓
Withdraw Money
```

Problem:

```text
ATM Out Of Cash
```

Without exception handling:

```text
Machine Crashes
```

With exception handling:

```text
Show Message:
"Cash unavailable. Try another ATM."
```

Program continues gracefully.

---

# 2. What is an Exception?

Definition:

> An Exception is an event that disrupts the normal flow of program execution.

---

# Normal Flow

```text
Statement 1
     ↓
Statement 2
     ↓
Statement 3
     ↓
Statement 4
```

---

# Exception Flow

```text
Statement 1
     ↓
Statement 2
     ↓
Exception Occurs
     ↓
Program Terminates
```

Unless handled.

---

# 3. Exception Hierarchy

Everything starts from:

```java
Object
```

Hierarchy:

```text
Object
  │
  ▼

Throwable
  │
  ├─────────────┐
  ▼             ▼

Exception      Error
```

---

# Complete Hierarchy

```text
Object
  │
  ▼
Throwable
  │
  ├───────────────┐
  ▼               ▼

Exception       Error
  │
  │
  ├── RuntimeException
  │       │
  │       ├── ArithmeticException
  │       ├── NullPointerException
  │       ├── ArrayIndexOutOfBoundsException
  │
  └── Checked Exceptions
          │
          ├── IOException
          ├── SQLException
          └── FileNotFoundException
```

---

# Key Interview Question

## Why Throwable?

Because Java treats every runtime problem as an object.

Both:

```java
Exception
```

and

```java
Error
```

inherit from:

```java
Throwable
```

---

# 4. Error vs Exception

---

## Exception

Recoverable problem.

Examples:

```java
ArithmeticException
IOException
SQLException
```

Program can continue.

---

## Error

Serious JVM/System issue.

Examples:

```java
OutOfMemoryError
StackOverflowError
VirtualMachineError
```

Usually not recoverable.

---

# Comparison Table

| Feature               | Exception     | Error            |
| --------------------- | ------------- | ---------------- |
| Recoverable           | Yes           | No               |
| Handled by Programmer | Yes           | Usually No       |
| Caused By             | Program Logic | JVM/System       |
| Application Continues | Possible      | Rarely           |
| Example               | IOException   | OutOfMemoryError |

---

# Interview Answer

### Can we catch Errors?

Technically:

```java
catch(Error e)
```

Yes.

Practically:

```text
Never Recommended
```

Because JVM itself is struggling.

---

# 5. JVM Internals

When exception occurs:

```java
int x = 10 / 0;
```

JVM performs several steps.

---

# Step 1: Create Exception Object

JVM internally creates:

```java
new ArithmeticException("/ by zero");
```

Diagram:

```text
Heap Memory

ArithmeticException Object
          │
          ▼

Message:
"/ by zero"
```

---

# Step 2: Throw Exception

JVM throws object.

```text
Exception Object
       │
       ▼
Current Method
```

---

# Step 3: Search for Handler

JVM searches:

```text
Current Method
     │
     ▼
Parent Method
     │
     ▼
Caller Method
     │
     ▼
main()
```

Looking for:

```java
catch(ArithmeticException e)
```

---

# Step 4: Default Handling

If no handler found:

```text
Print Stack Trace
Terminate Program
```

---

# JVM Flowchart

```text
Exception Occurs
        │
        ▼

Create Object
        │
        ▼

Throw Object
        │
        ▼

Handler Found?
   │         │
  Yes        No
   │         │
   ▼         ▼

Execute     JVM
Catch       Default Handler
   │         │
   ▼         ▼

Continue   Crash Program
```

---

# 6. Understanding Call Stack

Suppose:

```java
main()
   ↓
methodA()
   ↓
methodB()
```

Exception occurs inside:

```java
methodB()
```

---

# Call Stack Diagram

```text
TOP

methodB()

methodA()

main()

BOTTOM
```

---

# Exception Search

```text
methodB
   │
   ▼

methodA
   │
   ▼

main
   │
   ▼

JVM Default Handler
```

---

# Example

```java
void methodB(){
    int x = 10 / 0;
}

void methodA(){
    methodB();
}

public static void main(String[] args){
    methodA();
}
```

---

# Stack Trace

```text
ArithmeticException

at methodB(Line 10)

at methodA(Line 20)

at main(Line 30)
```

---

# Why Stack Trace Matters?

Provides:

```text
Class Name
Method Name
Line Number
```

for debugging.

---

# 7. try-catch Block

Core mechanism of exception handling.

Syntax:

```java
try {

}
catch(Exception e){

}
```

---

# Flow Diagram

```text
try Block
    │
    ▼

Exception?
 │      │
No     Yes
 │      │
 ▼      ▼

Continue
       Catch Block
```

---

# Example

```java
try{
    int x = 10 / 0;
}
catch(ArithmeticException e){
    System.out.println("Cannot divide by zero");
}
```

Output:

```text
Cannot divide by zero
```

Program continues.

---

# 8. Understanding catch()

Purpose:

```text
Handle Exception
Prevent Crash
```

---

# Exception Object

```java
catch(ArithmeticException e)
```

Variable:

```java
e
```

stores exception object.

---

# Useful Methods

---

## getMessage()

```java
e.getMessage();
```

Output:

```text
/ by zero
```

---

## printStackTrace()

```java
e.printStackTrace();
```

Output:

```text
Class
Method
Line Number
```

---

## toString()

```java
e.toString();
```

Output:

```text
java.lang.ArithmeticException: / by zero
```

---

# Interview Question

## Difference Between getMessage() and printStackTrace()?

| getMessage()  | printStackTrace() |
| ------------- | ----------------- |
| Only message  | Full trace        |
| Short         | Detailed          |
| User-friendly | Debugging         |

---

# 9. finally Block

Used for cleanup.

Syntax:

```java
try{

}
catch(Exception e){

}
finally{

}
```

---

# Important Rule

Finally executes:

✔ Exception occurs

✔ Exception doesn't occur

✔ Exception handled

✔ Method returns

---

# Flow Diagram

```text
try
 │
 ▼

Exception?
 │      │
No     Yes
 │      │
 ▼      ▼

Catch

   ▼
finally
```

---

# Example

```java
try{
    System.out.println("Try");
}
finally{
    System.out.println("Finally");
}
```

Output:

```text
Try
Finally
```

---

# Real World Use

```java
Database Connection

Open
  │
  ▼

Use
  │
  ▼

Close
```

Cleanup belongs in finally.

---

# 10. Multiple Catch Blocks

One try can have multiple catches.

Example:

```java
try{

}
catch(ArithmeticException e){

}
catch(NullPointerException e){

}
```

---

# Flow

```text
Exception Type
      │

Arithmetic?
      │
      ▼
Catch 1

NullPointer?
      │
      ▼
Catch 2
```

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

# Interview Question

## Can one try have multiple catches?

Yes.

Only the matching catch executes.

---

# 11. Multi-Catch (Java 7+)

Instead of:

```java
catch(IOException e){

}
catch(SQLException e){

}
```

Use:

```java
catch(IOException | SQLException e){

}
```

Cleaner syntax.

---

# 12. Exception Propagation

Exceptions move upward through method calls.

Example:

```java
main()
 ↓
A()
 ↓
B()
```

Exception generated in:

```java
B()
```

can be handled in:

```java
A()
```

or

```java
main()
```

---

# Diagram

```text
B()
 │
 ▼

A()
 │
 ▼

main()
 │
 ▼

JVM
```

---

# Example

```java
void B(){
    int x = 10/0;
}

void A(){
    try{
        B();
    }
    catch(ArithmeticException e){
        System.out.println("Handled");
    }
}
```

Output:

```text
Handled
```

---

# 13. Checked vs Unchecked Exceptions

Most Asked Interview Topic.

---

# Checked Exceptions

Checked at compile time.

Examples:

```java
IOException
SQLException
FileNotFoundException
```

Compiler forces handling.

---

Example:

```java
FileReader file =
    new FileReader("abc.txt");
```

Compiler error:

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

# Unchecked Exceptions

Occur at runtime.

Examples:

```java
NullPointerException
ArithmeticException
ArrayIndexOutOfBoundsException
```

Compiler doesn't force handling.

---

# Comparison

| Checked      | Unchecked        |
| ------------ | ---------------- |
| Compile Time | Runtime          |
| Must Handle  | Optional         |
| Exception    | RuntimeException |

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

# 14. Common Runtime Exceptions

---

## ArithmeticException

```java
10 / 0
```

---

## NullPointerException

```java
String s = null;
s.length();
```

---

## ArrayIndexOutOfBoundsException

```java
arr[100]
```

---

## NumberFormatException

```java
Integer.parseInt("ABC");
```

---

## ClassCastException

```java
Object obj = "Hello";

Integer i = (Integer)obj;
```

---

# 15. Benefits of Exception Handling

---

## Prevent Program Crash

Without handling:

```text
Application Stops
```

With handling:

```text
Application Continues
```

---

## Better User Experience

Bad:

```text
java.lang.NullPointerException
```

Good:

```text
Something went wrong.
Please try again.
```

---

## Easier Debugging

Stack trace shows:

```text
Class
Method
Line Number
```

---

## Resource Cleanup

Using:

```java
finally
```

or

```java
try-with-resources
```

---

# Best Practices

✔ Catch specific exceptions

```java
catch(IOException e)
```

Not:

```java
catch(Exception e)
```

unless necessary.

---

✔ Log exceptions

```java
e.printStackTrace();
```

or logging framework.

---

✔ Use meaningful messages

```java
throw new RuntimeException(
    "User not found"
);
```

---

✔ Cleanup resources

```java
finally
```

or

```java
try-with-resources
```

---

❌ Don't swallow exceptions

Bad:

```java
catch(Exception e){

}
```

---

❌ Don't use exceptions for normal flow

Bad:

```java
try{
    list.get(100);
}
catch(Exception e){
}
```

---

# Quick Revision Sheet

```text
Throwable
 │
 ├── Exception
 │     ├── Checked
 │     └── RuntimeException
 │
 └── Error

try
    Risky Code

catch
    Handle Exception

finally
    Cleanup Code

Checked
    Compile Time

Unchecked
    Runtime Time

Exception Propagation
    Moves Up Call Stack

Stack Trace
    Class → Method → Line
```

---

# Interview One-Liner

"Exception Handling in Java is a mechanism that allows applications to detect, propagate, and recover from abnormal conditions using try, catch, finally, throw, and throws, thereby preventing abrupt program termination and enabling graceful error recovery."
