
---

# Introduction

Every program ultimately works with **data**.

Examples:

```text
Calculator → Numbers

Banking App → Account Balance

Instagram → Usernames

Amazon → Product Prices
```

To work with data, we need a place to store it.

That place is called a:

```text
Variable
```

---

# Real Life Analogy

Imagine a kitchen.

You have containers:

```text
Container A → Sugar

Container B → Salt

Container C → Rice
```

Each container:

```text
Has a Name
Stores a Value
```

Variables work exactly the same way.

---

# Variable

## Definition

A variable is a named memory location used to store data.

---

# Memory Visualization

```java
int age = 25;
```

Memory:

```text
RAM

+-----------+
| age = 25  |
+-----------+
```

---

# Technical Definition

```text
Variable
=
Container in Memory
that stores data
```

---

# Why Variables Are Needed?

Without variables:

```java
System.out.println(10 + 20);
```

works for fixed values only.

---

Suppose user enters:

```text
10
20
```

We must store them somewhere.

```java
int firstNumber = 10;
int secondNumber = 20;
```

Now we can perform operations.

---

# Three Important Terms

Students often confuse:

```text
Variable
Identifier
Literal
```

Let's understand them separately.

---

# Variable vs Identifier vs Literal

Example:

```java
int age = 25;
```

---

## Variable

Entire storage unit.

```text
age
```

represents memory.

---

## Identifier

Name of variable.

```text
age
```

is identifier.

---

## Literal

Actual value stored.

```text
25
```

is literal.

---

# Visualization

```java
int age = 25;
```

```text
Identifier
    |
    v
  age
    |
    v
+---------+
|   25    |
+---------+
     ^
     |
 Literal
```

---

# Real Life Example

```text
Container Name → SugarBox

Stored Value → Sugar
```

Similarly:

```java
int marks = 95;
```

```text
marks → Identifier

95 → Literal

Entire Memory Slot → Variable
```

---

# Variable Declaration Syntax

General syntax:

```java
DataType VariableName = Value;
```

Example:

```java
int age = 25;
```

---

# Breakdown

```java
int age = 25;
```

```text
int  -> Data Type

age  -> Identifier

25   -> Literal

=    -> Assignment Operator

;    -> Statement Terminator
```

---

# Why Semicolon?

Semicolon tells compiler:

```text
Statement Ends Here
```

Example:

```java
int age = 25;
```

Without:

```java
int age = 25
```

Compiler Error.

---

# Declaration vs Initialization

Important Interview Topic.

---

## Declaration

Creating variable.

```java
int age;
```

Meaning:

```text
Reserve Memory
```

but no value yet.

---

Memory:

```text
+--------+
| age=?  |
+--------+
```

---

## Initialization

Assigning value.

```java
age = 25;
```

Memory:

```text
+--------+
| age=25 |
+--------+
```

---

## Combined Form

Most common.

```java
int age = 25;
```

---

# Variable Lifecycle

```text
Declare Variable
       |
       v
Memory Allocated
       |
       v
Assign Value
       |
       v
Use Variable
       |
       v
Program Ends
```

---

# Java is Statically Typed

Important Interview Question.

Java requires:

```text
Type Known Before Execution
```

Example:

```java
int age = 25;
```

Compiler already knows:

```text
age stores integer
```

---

# Why Static Typing?

Advantages:

```text
Better Performance

Compile-Time Checking

Fewer Runtime Errors
```

---

# Data Types in Java

Two major categories:

```text
Data Types
     |
     +---- Primitive
     |
     +---- Non Primitive
```

---

# Primitive Data Types

Built-in data types provided by Java.

There are 8 primitive types:

```text
byte
short
int
long

float
double

char

boolean
```

---

# Primitive Data Type Tree

```text
Primitive Types
      |
      +---- Integer
      |
      |      byte
      |      short
      |      int
      |      long
      |
      +---- Floating Point
      |
      |      float
      |      double
      |
      +---- Character
      |
      |      char
      |
      +---- Logical
             boolean
```

---

# Integer Types

Used to store whole numbers.

Examples:

```text
10
20
300
-50
```

---

# Memory Size Hierarchy

```text
byte  < short < int < long
```

---

# byte

Size:

```text
8 bits
1 byte
```

Range:

```text
-128 to 127
```

Example:

```java
byte age = 25;
```

Memory:

```text
00011001
```

---

# Why Only 127?

Because:

```text
1 bit = Sign

7 bits = Value
```

---

# byte Visualization

```text
8 Bits

S V V V V V V V

S = Sign Bit
```

---

# short

Size:

```text
16 bits
```

Range:

```text
-32,768
to
32,767
```

Example:

```java
short marks = 30000;
```

---

# int

Most commonly used integer type.

Size:

```text
32 bits
```

Range:

```text
-2^31
to
2^31 - 1
```

Approx:

```text
-2.1 Billion
to
+2.1 Billion
```

---

Example:

```java
int salary = 50000;
```

---

# long

Used for huge values.

Size:

```text
64 bits
```

Range:

```text
Very Large Numbers
```

Example:

```java
long population = 8000000000L;
```

---

# Why L Suffix?

Without L:

```java
long x = 8000000000;
```

Compiler treats it as int.

Error occurs.

Correct:

```java
long x = 8000000000L;
```

---

# Readability Feature

Java allows underscores.

```java
long money =
        1_00_00_00_000L;
```

Compiler sees:

```text
1000000000
```

Humans read easier.

---

# Floating Point Types

Store decimal values.

Examples:

```text
10.5
15.75
3.14159
```

---

# float

Size:

```text
32 bits
```

Precision:

```text
Single Precision
```

Example:

```java
float price = 99.99f;
```

---

# Why f Required?

Java defaults decimals to:

```text
double
```

So:

```java
float x = 10.5;
```

Error.

Correct:

```java
float x = 10.5f;
```

---

# double

Industry standard.

Size:

```text
64 bits
```

Precision:

```text
Double Precision
```

Example:

```java
double pi = 3.14159265359;
```

---

# Why double Preferred?

Modern CPUs are optimized for:

```text
64-bit arithmetic
```

Therefore:

```text
double is usually preferred
```

---

# Scientific Notation

Useful for huge values.

Example:

```java
double avogadro = 6.022e23;
```

Meaning:

```text
6.022 × 10^23
```

---

# Character Type

Stores single character.

---

Example

```java
char grade = 'A';
```

---

# Important Rule

Use:

```text
Single Quotes
```

Correct:

```java
char ch = 'A';
```

Wrong:

```java
char ch = "A";
```

Compiler Error.

---

# Why Single Quotes?

Because:

```text
'A' = Character

"A" = String
```

Different types.

---

# Character Memory Representation

Java stores characters internally as numbers.

Example:

```java
char ch = 'A';
```

Actually stored as:

```text
65
```

Unicode value.

---

# ASCII vs Unicode

Older Languages:

```text
ASCII
```

Supported mostly English.

---

Java Uses:

```text
Unicode
```

Supports:

```text
English

Hindi

Chinese

Japanese

Arabic

Thousands More
```

---

# Unicode Visualization

```text
Character
     |
     v
Unicode Number
     |
     v
Binary
     |
     v
Memory
```

---

# Example

```java
char c = 'A';
```

Unicode:

```text
65
```

Binary:

```text
0000000001000001
```

Stored in memory.

---

# Boolean

Represents logical values.

Only two values exist:

```java
true
false
```

---

Example

```java
boolean isLoggedIn = true;
```

---

# Important Rule

Java does NOT allow:

```java
boolean flag = 1;
```

or

```java
boolean flag = 0;
```

Unlike C/C++.

---

Correct:

```java
boolean flag = true;
```

---

# Number Systems in Java

Humans use:

```text
Decimal (Base 10)
```

Computers use:

```text
Binary (Base 2)
```

Java supports multiple representations.

---

# Decimal

Default.

```java
int x = 10;
```

---

# Binary

Prefix:

```text
0b
```

Example:

```java
int x = 0b101;
```

Calculation:

```text
1×2² + 0×2¹ + 1×2⁰

4 + 0 + 1

= 5
```

---

# Binary Conversion Diagram

```text
0b101

1   0   1
|   |   |
4   2   1

4+0+1=5
```

---

# Octal

Prefix:

```text
0
```

Example:

```java
int x = 010;
```

Value:

```text
8
```

because:

```text
1×8¹ + 0×8⁰
```

---

# Hexadecimal

Prefix:

```text
0x
```

Example:

```java
int x = 0xF;
```

Value:

```text
15
```

---

# Hexadecimal Table

| Hex | Decimal |
| --- | ------- |
| A   | 10      |
| B   | 11      |
| C   | 12      |
| D   | 13      |
| E   | 14      |
| F   | 15      |

---

# Example

```java
int color = 0xFF;
```

Calculation:

```text
15×16 + 15

240 + 15

255
```

---

# Keywords

Java reserves special words.

Examples:

```java
class
public
private
static
void
int
if
else
return
```

---

# Why Keywords Exist?

Compiler uses them for specific meanings.

Example:

```java
public class Demo
```

Compiler knows:

```text
class -> Create Class
```

---

# Important Rule

Keywords cannot be identifiers.

Wrong:

```java
int class = 10;
```

Compiler Error.

---

# Valid Identifier Rules

---

## Rule 1

Can contain:

```text
Letters

Digits

_

$
```

---

Valid:

```java
studentAge

student_age

studentAge1

$salary
```

---

## Rule 2

Cannot start with digit.

Wrong:

```java
1student
```

Correct:

```java
student1
```

---

## Rule 3

Cannot use keywords.

Wrong:

```java
int public = 10;
```

---

# Naming Convention

Bad:

```java
int x;
int y;
```

Good:

```java
int firstNumber;
int secondNumber;
```

---

# Why Meaningful Names?

Imagine:

```java
int x = 50000;
```

After 6 months:

```text
What is x?
```

Nobody knows.

---

Better:

```java
int monthlySalary = 50000;
```

Self-explanatory.

---

# Comments

Comments are notes for developers.

Compiler ignores them.

---

# Single-Line Comment

```java
// This is comment
```

Example:

```java
// Store user age
int age = 25;
```

---

# Multi-Line Comment

```java
/*
 This is
 multi-line
 comment
*/
```

---

# Comment Visualization

```text
Source Code
     |
     v
Compiler
     |
     +---- Ignore Comments
     |
     v
Bytecode
```

---

# Why Comments Matter?

Used for:

```text
Documentation

Explanation

Maintenance

Team Collaboration
```

---

# Primitive Data Types Summary

| Type    | Size          | Example      |
| ------- | ------------- | ------------ |
| byte    | 8 bits        | 10           |
| short   | 16 bits       | 1000         |
| int     | 32 bits       | 100000       |
| long    | 64 bits       | 10000000000L |
| float   | 32 bits       | 10.5f        |
| double  | 64 bits       | 10.5         |
| char    | 16 bits       | 'A'          |
| boolean | JVM Dependent | true         |

---

# Common Interview Questions

### Q1. Difference between variable and identifier?

```text
Variable → Memory Location

Identifier → Name of Variable
```

---

### Q2. Why is Java called statically typed?

```text
Because variable types
are checked at compile time.
```

---

### Q3. Why is f required in float?

```text
Because decimal literals
are treated as double by default.
```

---

### Q4. Difference between char and String?

```text
char   -> Single Character

String -> Collection of Characters
```

---

### Q5. Can boolean store 0 or 1?

```text
No
```

Only:

```java
true
false
```

---

### Q6. What is Unicode?

```text
Universal Character Encoding
System supporting almost all
languages.
```

---

### Q7. Can we use keywords as identifiers?

```text
No
```

---

# 30-Second Revision

```text
Variable = Memory Container

Identifier = Variable Name

Literal = Stored Value


Syntax:

DataType name = value;


Primitive Types:

byte

short

int

long

float

double

char

boolean


Number Systems:

0b -> Binary

0  -> Octal

0x -> Hexadecimal


Rules:

✓ Use meaningful identifiers

✓ Keywords not allowed

✓ float needs f

✓ long may need L

✓ char uses single quotes

✓ boolean uses true/false

✓ Statements end with ;
```

# Interview One-Liner

"A variable is a named memory location used to store data, where the identifier represents the variable name, the literal represents the stored value, and the data type defines what kind of value can be stored and how much memory is allocated."
