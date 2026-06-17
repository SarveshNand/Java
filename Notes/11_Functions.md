# Java Functions (Methods) & Recursion

---

# Table of Contents

1. What is a Function?
2. Why Functions?
3. Function Syntax
4. Function Components
5. Function Calling
6. Parameters vs Arguments
7. Four Types of Functions
8. Function Memory Model
9. Function Chaining
10. Variable Scope
11. Function Overloading
12. Recursion
13. Call Stack Internals
14. Recursion Tree
15. Fibonacci Recursion
16. Recursion vs Iteration
17. Common Interview Questions
18. Quick Revision Sheet

---

# 1. What is a Function?

A function is:

```text
A reusable block of code
designed to perform a specific task.
```

---

## Real Life Example

Imagine a calculator.

Instead of writing:

```java
a+b
```

again and again,

we create:

```java
sum()
```

and reuse it.

---

## Analogy

Think of a function as a machine.

```text
Input
  |
  ▼
Processing
  |
  ▼
Output
```

Example:

```text
2,3
 ↓
sum()
 ↓
5
```

---

# 2. Why Functions?

Without Functions:

```java
a+b
print
a+b
print
a+b
print
```

Code becomes:

❌ Repetitive

❌ Hard to maintain

❌ Error-prone

---

With Functions:

```java
sum();
sum();
sum();
```

Advantages:

✅ Reusability

✅ Readability

✅ Modularity

✅ Easier Testing

✅ Easier Debugging

---

# 3. Function Syntax

---

## General Syntax

```java
static ReturnType functionName(parameters)
{
    // code
}
```

---

## Example

```java
static int sum(int a,int b)
{
    return a+b;
}
```

---

# Structure Diagram

```text
static int sum(int a,int b)
│      │      │
│      │      └── Parameters
│      │
│      └──────── Function Name
│
└────────────── Return Type
```

---

# 4. Components of a Function

---

## Return Type

Specifies what the function returns.

Examples:

```java
int
double
String
boolean
```

---

### Example

```java
static int square(int n)
{
    return n*n;
}
```

Returns:

```text
int
```

---

## void Return Type

When nothing is returned.

```java
static void greet()
{
    System.out.println("Hello");
}
```

---

## Function Name

Identifier used to call the function.

Examples:

```java
sum()
multiply()
calculateInterest()
```

Use meaningful names.

---

## Parameters

Inputs accepted by function.

```java
static int sum(int a,int b)
```

Parameters:

```text
a
b
```

---

## Return Statement

Used to send value back.

```java
return a+b;
```

---

Important:

```text
return immediately ends function execution.
```

---

# Flowchart of Function Execution

```text
Function Called
      |
      ▼
Receive Inputs
      |
      ▼
Execute Code
      |
      ▼
Return Result
      |
      ▼
Function Ends
```

---

# 5. Calling a Function

---

## Function Definition

```java
static int sum(int a,int b)
{
    return a+b;
}
```

---

## Function Call

```java
int result = sum(5,10);
```

Output:

```text
15
```

---

# Control Flow

```text
main()
   |
   ▼
sum(5,10)
   |
   ▼
returns 15
   |
   ▼
main()
```

---

# 6. Parameters vs Arguments

Interview Favorite

---

## Parameters

Variables written in function definition.

```java
static int sum(int a,int b)
```

Parameters:

```text
a
b
```

---

## Arguments

Actual values passed during call.

```java
sum(10,20)
```

Arguments:

```text
10
20
```

---

# Memory Diagram

Call:

```java
sum(10,20)
```

Inside Function:

```text
Argument 10 → Parameter a

Argument 20 → Parameter b
```

---

# Easy Memory Trick

```text
Parameter = Placeholder

Argument = Actual Value
```

---

# 7. Four Types of Functions

---

# Type 1

## No Input, No Output

```java
static void greet()
{
    System.out.println("Hello");
}
```

Diagram:

```text
Input  → None
Output → None
```

---

# Type 2

## Input, No Output

```java
static void greet(String name)
{
    System.out.println(name);
}
```

Diagram:

```text
Input  → Yes
Output → No
```

---

# Type 3

## No Input, Output

```java
static int getNumber()
{
    return 100;
}
```

Diagram:

```text
Input  → No
Output → Yes
```

---

# Type 4

## Input and Output

```java
static int sum(int a,int b)
{
    return a+b;
}
```

Diagram:

```text
Input  → Yes
Output → Yes
```

---

# Summary Table

| Type | Input | Output |
|--------|--------|--------|
| Type 1 | No | No |
| Type 2 | Yes | No |
| Type 3 | No | Yes |
| Type 4 | Yes | Yes |

---

# 8. Function Memory Model

---

## Example

```java
static int sum(int a,int b)
{
    return a+b;
}
```

Call:

```java
sum(5,10);
```

---

# Stack Memory

```text
STACK

+------------------+
| b = 10           |
+------------------+
| a = 5            |
+------------------+
| sum() Frame      |
+------------------+
```

When function ends:

```text
Frame removed
Memory released
```

---

# Interview Question

Why are local variables destroyed?

Because their stack frame is removed.

---

# 9. Function Chaining

---

# Definition

One function calls another function.

---

Example:

```java
main()
{
    A();
}
```

```java
A()
{
    B();
}
```

```java
B()
{
    C();
}
```

---

# Flow

```text
main()
  |
  ▼
A()
  |
  ▼
B()
  |
  ▼
C()
```

---

# Return Flow

```text
C returns
   ↑
B returns
   ↑
A returns
   ↑
main continues
```

---

# Stack Visualization

```text
TOP

C()

B()

A()

main()

BOTTOM
```

---

# 10. Variable Scope

Scope = Where variable can be accessed.

---

# Local Scope

```java
void demo()
{
    int x=10;
}
```

Accessible only inside function.

---

Invalid:

```java
System.out.println(x);
```

outside function.

---

# Block Scope

```java
if(true)
{
    int a=5;
}
```

Only inside block.

---

# Example

```java
{
   int x=10;
}
```

Outside:

```java
x
```

Error.

---

# Scope Diagram

```text
Function
 ├── Variable A
 ├── Loop
 │    └── Variable B
 └── If Block
      └── Variable C
```

---

# Global Scope

```java
class Demo
{
    static int x=100;
}
```

Accessible throughout class.

---

# Memory

```text
Class Area

x = 100
```

Lives longer than local variables.

---

# 11. Function Overloading

---

# Definition

Multiple functions with:

```text
Same Name
Different Parameters
```

---

# Example 1

```java
static int sum(int a,int b)
```

```java
static int sum(int a,int b,int c)
```

---

# Example 2

```java
sum(int,int)
```

```java
sum(double,double)
```

---

# Example 3

```java
show(String,int)
```

```java
show(int,String)
```

---

# Valid Overloading Rules

✅ Change number of parameters

✅ Change datatype

✅ Change order

---

# Invalid

```java
int sum(int a,int b)
```

```java
double sum(int a,int b)
```

Compiler Error.

---

Why?

Call:

```java
sum(5,10)
```

Compiler can't decide.

---

# Overloading Resolution

```text
Function Call
      |
      ▼
Compiler checks
parameter list
      |
      ▼
Best match selected
```

---

# 12. Recursion

One of the most important interview topics.

---

# Definition

A function calling itself.

---

Example:

```java
void fun()
{
    fun();
}
```

---

Problem:

```text
Infinite Recursion
```

Leads to:

```text
StackOverflowError
```

---

# Base Case

A condition that stops recursion.

Without base case:

❌ Infinite calls

❌ Program crash

---

# Structure

```text
Recursion
    |
    ├── Base Case
    |
    └── Recursive Call
```

---

# General Template

```java
void solve(int n)
{
    if(n==0)
        return;

    solve(n-1);
}
```

---

# Flowchart

```text
Function Called
      |
      ▼
Base Case?
   /     \
 Yes      No
 |         |
Return   Recursive Call
            |
            ▼
         Function Again
```

---

# 13. Recursion Example: Print 1 to N

---

## Code

```java
static void print(int n)
{
    if(n==0)
        return;

    print(n-1);

    System.out.println(n);
}
```

---

Call:

```java
print(5);
```

---

# Recursive Calls

```text
print(5)
 ↓
print(4)
 ↓
print(3)
 ↓
print(2)
 ↓
print(1)
 ↓
print(0)
```

Base case reached.

---

# Return Phase

```text
print(0)
 ↑
print(1)
 ↑
print(2)
 ↑
print(3)
 ↑
print(4)
 ↑
print(5)
```

Output:

```text
1
2
3
4
5
```

---

# Stack Visualization

```text
TOP

print(0)

print(1)

print(2)

print(3)

print(4)

print(5)
```

Then frames pop one by one.

---

# 14. Factorial Using Recursion

---

Mathematical Formula

```text
n! = n × (n-1)!
```

---

Code

```java
static int fact(int n)
{
    if(n==0)
        return 1;

    return n*fact(n-1);
}
```

---

Call Tree

```text
fact(4)

4 × fact(3)

      3 × fact(2)

            2 × fact(1)

                  1 × fact(0)

                        1
```

Output:

```text
24
```

---

# Complexity

```text
Time  = O(n)

Space = O(n)
```

---

# 15. Fibonacci Recursion

---

Formula

```text
Fib(n)

=
Fib(n-1)
+
Fib(n-2)
```

---

Code

```java
static int fib(int n)
{
    if(n<=1)
        return n;

    return fib(n-1)+fib(n-2);
}
```

---

# Fibonacci Tree

```text
fib(5)

          5
       /     \
      4       3
     / \     / \
    3   2   2   1
   / \
  2   1
```

---

# Observation

Many repeated calculations.

Example:

```text
fib(3)
```

computed multiple times.

---

# Complexity

```text
Time = O(2^n)
```

Very inefficient.

---

# Better Solution

Use:

```text
Dynamic Programming
```

or

```text
Iteration
```

---

# 16. Recursion vs Iteration

| Feature | Recursion | Loop |
|----------|----------|----------|
| Uses Stack | Yes | No |
| Memory | More | Less |
| Readability | Better | Moderate |
| Performance | Slower | Faster |
| Risk | Stack Overflow | No |

---

# Common Interview Questions

---

## Q1. Difference between parameter and argument?

Parameter:

```java
int a
```

Argument:

```java
sum(5)
```

---

## Q2. Can functions be overloaded by return type?

No.

Parameter list must change.

---

## Q3. What happens after return?

Function immediately terminates.

---

## Q4. What is recursion?

Function calling itself.

---

## Q5. What is base case?

Condition that stops recursion.

---

## Q6. What causes StackOverflowError?

Infinite recursion.

---

## Q7. Where are local variables stored?

Stack memory.

---

## Q8. Why is recursion expensive?

Every call creates a new stack frame.

---

# Quick Revision Sheet

```text
FUNCTION
========
Reusable block of code

SYNTAX
======
ReturnType name(parameters)

PARAMETER
=========
Placeholder

ARGUMENT
========
Actual value

OVERLOADING
===========
Same Name
Different Parameters

SCOPE
=====
Local
Global

RECURSION
=========
Function calls itself

BASE CASE
=========
Stops recursion

STACK
=====
Every function call
creates a new frame

FACTORIAL
=========
n × fact(n-1)

FIBONACCI
=========
fib(n-1)+fib(n-2)
```

---

# Memory Trick

```text
FUNCTION
========
Write Once
Use Many Times

PARAMETER
=========
Receives Data

ARGUMENT
========
Sends Data

OVERLOADING
===========
Same Name
Different Inputs

RECURSION
=========
Function Calls Itself

BASE CASE
=========
Exit Condition

NO BASE CASE
============
StackOverflowError
```

---
