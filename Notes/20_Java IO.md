
---

# 1. Introduction to Java I/O

## What is I/O?

I/O stands for:

```text
Input / Output
```

A Java program rarely works alone.

It constantly exchanges data with:

* Keyboard
* Screen
* Files
* Network
* Memory

---

# Real World Analogy

```text
Human Body

Eyes/Ears  → Input
Brain      → Processing
Mouth      → Output
```

Similarly:

```text
Keyboard/File/API
        │
        ▼
Java Program
        │
        ▼
Screen/File/API
```

---

# Types of I/O in Java

```text
Java I/O

├── Console I/O
│      ├── Keyboard
│      └── Console
│
├── File I/O
│      ├── Read File
│      └── Write File
│
├── Network I/O
│      ├── API Calls
│      └── Socket Communication
│
└── Memory I/O
       ├── Buffer
       └── Byte Array Streams
```

---

# 2. Understanding System.out.println()

One of the most used Java statements:

```java
System.out.println("Hello");
```

Looks simple.

Internally, a lot happens.

---

# Architecture Breakdown

```text
System.out.println("Hello")

      │
      ▼

System
      │
      ▼

out
      │
      ▼

println()
```

---

# Internal Structure

```text
java.lang.System
        │
        ▼
 static final PrintStream out
        │
        ▼
 println()
```

---

# Actual Simplified Representation

```java
public final class System {

    public static final PrintStream out;

}
```

---

# Breakdown of Components

## System

A class from:

```java
java.lang
```

Automatically imported.

Therefore:

```java
System.out.println();
```

works without import.

---

## out

A variable inside System class.

```java
public static final PrintStream out;
```

---

### Why Static?

Because:

```java
System.out
```

works without:

```java
new System()
```

---

## Why Final?

Prevent reassignment:

Invalid:

```java
System.out = null;
```

---

## PrintStream

Datatype of out.

```text
System
   │
   ▼
PrintStream out
```

Contains methods:

```java
print()
println()
printf()
format()
```

---

## println()

Prints data and moves cursor to next line.

Example:

```java
System.out.println("Java");
System.out.println("Python");
```

Output:

```text
Java
Python
```

---

# JVM Execution Flow

```text
System.out.println("Hello")

       │
       ▼

JVM loads System Class

       │
       ▼

Accesses static variable out

       │
       ▼

out references PrintStream object

       │
       ▼

println("Hello")

       │
       ▼

OS Console
```

---

# 3. System.out vs System.err

Java provides two output streams.

---

# System.out

Used for:

```text
Normal Output
Business Logic
User Messages
```

Example:

```java
System.out.println("User Created");
```

---

# System.err

Used for:

```text
Errors
Warnings
Exceptions
```

Example:

```java
System.err.println("Database Connection Failed");
```

---

# Architecture

```text
System

├── out
│     │
│     ▼
│   Normal Output
│
└── err
      │
      ▼
    Error Output
```

---

# Why Separate Them?

Large applications may route logs differently.

```text
System.out
      │
      ▼
application.log

System.err
      │
      ▼
error.log
```

---

# Interview Question

### Do System.out and System.err print to different consoles?

No.

By default:

```text
Both Print To Console
```

But they are different streams.

---

# 4. What is a Stream?

Most Important Concept in Java I/O.

---

# Definition

A stream is:

```text
Continuous Flow Of Data
```

---

# Water Pipe Analogy

```text
Water Tank
     │
     ▼
 Pipe
     │
     ▼
 Bucket
```

Java:

```text
Source
    │
    ▼
 Stream
    │
    ▼
 Destination
```

---

# Stream Direction

## Input Stream

Data enters program.

```text
Keyboard
     │
     ▼
Java Program
```

---

## Output Stream

Data leaves program.

```text
Java Program
     │
     ▼
Console
```

---

# Complete View

```text
Keyboard
    │
    ▼
Input Stream
    │
    ▼
Program
    │
    ▼
Output Stream
    │
    ▼
Console
```

---

# 5. Byte Streams

Everything in computer memory eventually becomes:

```text
0 and 1
```

Java handles raw data as bytes.

---

# Parent Classes

```text
InputStream
      │
      ▼
Byte Input

OutputStream
      │
      ▼
Byte Output
```

---

# Hierarchy

```text
Object

├── InputStream
│
└── OutputStream
```

---

# 6. System.in

Used for input.

```java
System.in
```

---

# Internal Representation

```java
public static final InputStream in;
```

---

# Architecture

```text
Keyboard
     │
     ▼
System.in
     │
     ▼
InputStream
```

---

# Default Source

```text
Keyboard
```

By default.

---

# 7. System.in.read()

Lowest level input operation.

---

# Example

```java
int value = System.in.read();
```

---

# What Does It Return?

Returns ASCII value.

Input:

```text
A
```

Output:

```text
65
```

---

# Why?

Internally:

```text
'A'
 │
 ▼
ASCII Conversion
 │
 ▼
65
```

---

# Example

```java
int x = System.in.read();

System.out.println(x);
```

Input:

```text
A
```

Output:

```text
65
```

---

# Reading a Word Problem

Input:

```text
Aditya
```

Need:

```text
A
d
i
t
y
a
```

read individually.

Very inefficient.

---

# Flow

```text
Keyboard
     │
     ▼
read()
     │
     ▼
One Byte Only
```

---

# Drawback

```text
Character By Character Reading

Slow
Tedious
Manual Conversion Required
```

---

# 8. BufferedReader

Introduced for efficient reading.

---

# Why BufferedReader?

Without buffer:

```text
Program
    │
    ▼
OS Buffer
    │
    ▼
Keyboard
```

Every character requires OS access.

Expensive operation.

---

# Buffered Solution

```text
Keyboard
    │
    ▼
OS Buffer
    │
    ▼
BufferedReader Buffer
    │
    ▼
Program
```

Reads large chunk at once.

---

# Performance Benefit

```text
Without Buffer

Read Character
      │
      ▼
OS Access

Repeated Thousands Times
```

---

```text
With Buffer

Read Large Chunk Once

Read From RAM
```

Much faster.

---

# BufferedReader Hierarchy

```text
Object
   │
   ▼
Reader
   │
   ▼
BufferedReader
```

---

# Why Can't BufferedReader Directly Use System.in?

Because:

```text
System.in
     │
     ▼
Byte Stream

BufferedReader
     │
     ▼
Character Stream
```

Mismatch.

---

# InputStreamReader (Adapter Pattern)

Acts as translator.

```text
System.in
(Byte Stream)

      │
      ▼

InputStreamReader

      │
      ▼

Character Stream

      │
      ▼

BufferedReader
```

---

# Complete Creation

```java
BufferedReader br =
        new BufferedReader(
                new InputStreamReader(System.in)
        );
```

---

# Memory Flow

```text
Keyboard

   │

   ▼

System.in

   │

   ▼

InputStreamReader

   │

   ▼

BufferedReader

   │

   ▼

String
```

---

# Reading Data

```java
String name = br.readLine();
```

Reads complete line.

Input:

```text
Aditya Sharma
```

Output:

```text
Aditya Sharma
```

---

# BufferedReader Limitation

Only returns:

```text
String
```

Need manual conversion.

Example:

```java
int age =
Integer.parseInt(br.readLine());
```

---

# 9. Scanner Class

Introduced in:

```text
Java 1.5
```

Package:

```java
java.util.Scanner
```

---

# Why Scanner Was Created

BufferedReader:

```text
Read String
Manually Convert
```

Scanner:

```text
Read Int
Read Double
Read Boolean
Read String
```

Directly.

---

# Scanner Architecture

```text
Keyboard
    │
    ▼
System.in
    │
    ▼
Scanner
    │
    ▼
Primitive Types
```

---

# Creation

```java
Scanner sc =
    new Scanner(System.in);
```

---

# Direct Integer Input

```java
int age = sc.nextInt();
```

No parsing required.

---

# Direct Double Input

```java
double salary =
        sc.nextDouble();
```

---

# Direct Boolean Input

```java
boolean active =
        sc.nextBoolean();
```

---

# Common Methods

| Method        | Reads       |
| ------------- | ----------- |
| nextInt()     | int         |
| nextLong()    | long        |
| nextFloat()   | float       |
| nextDouble()  | double      |
| nextBoolean() | boolean     |
| next()        | single word |
| nextLine()    | entire line |

---

# Scanner Tokenization

Input:

```text
John Doe 25
```

Scanner sees:

```text
Token 1 → John

Token 2 → Doe

Token 3 → 25
```

Default delimiter:

```text
Whitespace
```

---

# Most Common Interview Problem

## nextInt() + nextLine()

Example:

```java
int age = sc.nextInt();

String name = sc.nextLine();
```

Input:

```text
25
John
```

Output:

```text
name = ""
```

---

# Why?

After nextInt():

```text
25\n
   ▲
   │
Newline Left Behind
```

nextLine() reads that newline.

---

# Solution

```java
int age = sc.nextInt();

sc.nextLine();

String name = sc.nextLine();
```

---

# Flow Diagram

```text
nextInt()

Consumes:

25

Leaves:

\n

nextLine()

Consumes:

\n
```

---

# 10. BufferedReader vs Scanner

## Internal Processing

BufferedReader:

```text
Read Characters
Return String
```

Scanner:

```text
Read Characters
Tokenize
Regex Match
Type Conversion
Return Value
```

More work.

---

# Performance Comparison

```text
BufferedReader
       │
       ▼
Faster
```

```text
Scanner
       │
       ▼
Slower
```

---

# Why Scanner Is Slower?

Internally performs:

```text
Tokenization

Regex Matching

Validation

Type Conversion
```

Extra overhead.

---

# Competitive Programming Choice

Usually:

```text
BufferedReader
```

Because speed matters.

---

# Enterprise Application Choice

Usually:

```text
Scanner
```

Because readability matters.

---

# Comparison Table

| Feature                 | BufferedReader | Scanner |
| ----------------------- | -------------- | ------- |
| Speed                   | Faster         | Slower  |
| Reads Strings           | Yes            | Yes     |
| Reads Primitive Types   | No             | Yes     |
| Automatic Parsing       | No             | Yes     |
| Buffer Size             | Larger         | Smaller |
| Competitive Programming | Preferred      | Rare    |
| Ease of Use             | Moderate       | Easy    |

---

# Complete Input Architecture

```text
Keyboard

    │

    ▼

System.in

    │

    ├────────────► Scanner

    │                  │

    │                  ▼

    │           int,double,String

    │

    ▼

InputStreamReader

    │

    ▼

BufferedReader

    │

    ▼

String
```

---

# Interview Questions

## Q1. What is System.out?

```java
public static final PrintStream out;
```

inside System class.

---

## Q2. What is System.in?

```java
public static final InputStream in;
```

inside System class.

---

## Q3. Why is System.out static?

To access it without creating a System object.

---

## Q4. Difference between print() and println()?

```text
print()   → No New Line

println() → New Line
```

---

## Q5. Why is BufferedReader faster?

Reads data in large chunks using an internal buffer.

---

## Q6. Why is InputStreamReader needed?

Converts:

```text
Byte Stream
      │
      ▼
Character Stream
```

---

## Q7. Why is Scanner slower?

Performs tokenization, parsing and regex matching.

---

## Q8. Which is preferred in competitive programming?

```text
BufferedReader
```

---

## Q9. Which is easier for beginners?

```text
Scanner
```

---

## Q10. Difference between next() and nextLine()?

```text
next()
     │
Single Word

nextLine()
     │
Entire Line
```

---

# Final Revision Mind Map

```text
JAVA I/O

├── Streams
│     ├── InputStream
│     └── OutputStream
│
├── System Class
│     ├── out
│     ├── err
│     └── in
│
├── System.out.println()
│     ├── System
│     ├── PrintStream
│     └── println()
│
├── System.in.read()
│     ├── Byte Based
│     ├── ASCII Return
│     └── Slow
│
├── BufferedReader
│     ├── Fast
│     ├── Character Stream
│     ├── Buffer
│     └── readLine()
│
├── InputStreamReader
│     └── Adapter
│
└── Scanner
      ├── nextInt()
      ├── nextDouble()
      ├── nextLine()
      ├── Tokenization
      └── Easy To Use
```
