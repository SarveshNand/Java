# Java Type Conversion, Type Casting & Type Promotion

## Complete Interview Notes with Memory Diagrams and Flowcharts

---

# Introduction

In Java, different data types have different memory sizes.

| Data Type | Size              |
| --------- | ----------------- |
| byte      | 1 Byte (8 bits)   |
| short     | 2 Bytes (16 bits) |
| char      | 2 Bytes (16 bits) |
| int       | 4 Bytes (32 bits) |
| long      | 8 Bytes (64 bits) |
| float     | 4 Bytes (32 bits) |
| double    | 8 Bytes (64 bits) |

---

# Why Type Conversion is Needed

Suppose:

```java
byte b = 10;
int i = b;
```

Question:

```text
How can an 8-bit value
be stored inside a 32-bit variable?
```

Java performs:

```text
Type Conversion
```

---

# Types of Conversion

```text
Type Conversion
      |
      +-------------------+
      |                   |
      v                   v

Implicit            Explicit
(Widening)          (Narrowing)
```

---

# 1. Implicit Conversion (Widening Conversion)

---

## Definition

When a smaller data type is converted into a larger data type automatically.

```text
Small Container
        ↓
Large Container
```

---

## Why Safe?

Because larger memory can easily accommodate smaller values.

Example:

```java
byte b = 24;
int i = b;
```

---

# Memory Diagram

```text
byte b = 24

8 Bits

00011000
```

---

Stored into int:

```text
32 Bits

00000000 00000000 00000000 00011000
```

No data loss.

---

# Flowchart

```text
byte
  |
  v
short
  |
  v
int
  |
  v
long
  |
  v
float
  |
  v
double
```

Automatic conversion allowed in this direction.

---

# Examples

## Byte → Int

```java
byte b = 50;
int i = b;
```

---

## Short → Long

```java
short s = 100;
long l = s;
```

---

## Int → Double

```java
int x = 25;
double d = x;
```

Output:

```text
25.0
```

---

# Interview Point

### Why is it called Widening?

Because destination container is wider.

```text
8 Bits
  ↓
32 Bits
```

---

# 2. Explicit Conversion (Narrowing Conversion)

---

## Definition

When a larger data type is converted into a smaller data type manually.

Java does NOT allow this automatically.

---

# Why?

Because data loss may occur.

Example:

```java
int i = 300;
byte b = (byte)i;
```

---

# Syntax

```java
(TargetType) value
```

Example:

```java
byte b = (byte)i;
```

---

# Memory Analysis

Integer:

```java
int i = 300;
```

Binary:

```text
00000000 00000000 00000001 00101100
```

---

Byte stores only:

```text
8 Bits
```

Java keeps only last 8 bits.

```text
00101100
```

---

Decimal value:

```text
44
```

---

# Result

```java
System.out.println(b);
```

Output:

```text
44
```

---

# Visualization

```text
300

00000000 00000000 00000001 00101100

Keep Last 8 Bits

00101100

↓

44
```

---

# Important Formula

For Narrowing:

```text
Result

=
Original Value % Range
```

---

For byte:

```text
Range = 256
```

---

Example

```text
300 % 256

= 44
```

---

Therefore:

```java
(byte)300
```

becomes:

```text
44
```

---

# Another Example

```java
int x = 500;
byte b = (byte)x;
```

Calculation:

```text
500 % 256

= 244
```

Binary corresponds to:

```text
-12
```

Output:

```text
-12
```

---

# Widening vs Narrowing

| Feature          | Widening      | Narrowing     |
| ---------------- | ------------- | ------------- |
| Automatic        | Yes           | No            |
| Data Loss        | No            | Possible      |
| Casting Required | No            | Yes           |
| Direction        | Small → Large | Large → Small |

---

# Character to Integer Conversion

---

# Internal Storage of Character

Java stores characters using:

```text
Unicode
```

---

Example

```java
char c = 'A';
```

Unicode value:

```text
65
```

---

Conversion

```java
int i = c;
```

Output:

```text
65
```

---

# Memory Diagram

```text
'A'

↓

Unicode

65

↓

Binary

0000000001000001
```

---

# Example

```java
char c = 'B';
int i = c;

System.out.println(i);
```

Output:

```text
66
```

---

# Character Conversion Flow

```text
Character
      |
Unicode Value
      |
Integer
```

---

# Float to Int Conversion

---

## Problem

```java
float f = 16.25f;
```

Can int store decimals?

```text
No
```

---

# Solution

Use Explicit Casting

```java
int i = (int)f;
```

---

# Result

```text
16
```

---

# Important Rule

Java removes decimal portion.

```text
16.25 → 16

99.99 → 99

7.75 → 7
```

---

# Visualization

```text
16.25

Integer Part -> 16

Fraction Part -> .25

Discarded
```

---

# Truncation vs Rounding

---

## Truncation

```java
(int)16.99
```

Result:

```text
16
```

---

## Rounding

```java
Math.round(16.99f)
```

Result:

```text
17
```

---

# Boolean Conversion

---

# Special Rule

Boolean cannot convert to any other type.

---

Invalid:

```java
boolean flag = true;

int x = (int)flag;
```

---

Compiler Error

```text
Incompatible Types
```

---

# Interview Question

### Can boolean be converted to int?

Answer:

```text
No

Java does not allow
boolean conversion
to any numeric type.
```

---

# Type Promotion

One of the most important interview topics.

---

# Definition

During calculations Java automatically promotes smaller data types to larger ones.

---

# Why?

To avoid overflow during intermediate calculations.

---

# Rule 1

## byte, short and char become int

---

Example

```java
byte a = 10;
byte b = 20;

int result = a + b;
```

---

Internally

```text
byte
  ↓
int

10 + 20
```

Result:

```text
30 (int)
```

---

# Byte Calculation Trap

---

Code

```java
byte b = 50;

b = b * 2;
```

Error!

---

# Why?

Java performs:

```text
byte
 ↓
int

50 * 2

= 100 (int)
```

---

Now:

```text
int → byte
```

requires casting.

---

# Correct Version

```java
byte b = 50;

b = (byte)(b * 2);
```

---

# Visualization

```text
50
 |
byte
 |
Promoted
 |
int
 |
100
 |
Cast
 |
byte
```

---

# Rule 2

## If one operand is long

Entire expression becomes long.

---

Example

```java
int a = 10;
long b = 20;

long result = a + b;
```

---

Promotion

```text
int
  ↓
long

long + long
```

---

# Rule 3

## If one operand is float

Entire expression becomes float.

---

Example

```java
int a = 10;
float b = 5.5f;

float result = a + b;
```

---

Promotion

```text
int
 ↓
float

float + float
```

---

# Rule 4

## If one operand is double

Entire expression becomes double.

---

Example

```java
float f = 5.5f;
double d = 10.5;

double result = f + d;
```

---

Promotion

```text
float
  ↓
double

double + double
```

---

# Complete Promotion Hierarchy

```text
byte
short
char
     ↓
     int
      ↓
     long
      ↓
     float
      ↓
     double
```

---

# Complex Expression Analysis

Given:

```java
float f;
byte b;
int i;
char c;
double d;
short s;
```

Expression:

```java
result =
(f * b)
+
(i / c)
-
(d * s);
```

---

# Step 1

```java
f * b
```

Promotion:

```text
byte → float
```

Result:

```text
float
```

---

# Step 2

```java
i / c
```

Promotion:

```text
char → int
```

Result:

```text
int
```

---

# Step 3

```java
d * s
```

Promotion:

```text
short → double
```

Result:

```text
double
```

---

# Final Evaluation

```text
float
+
int
-
double
```

---

Promotion:

```text
float
  ↓
double

int
 ↓
double
```

---

Final Type:

```text
double
```

---

# Expression Flowchart

```text
float
     \
      \
       +------> double
      /
int
     \
      \
       +------> double
      /
double
```

---

# Most Asked Interview Questions

---

## Q1. What is Widening Conversion?

```text
Automatic conversion

Small Type → Large Type
```

Example:

```java
byte → int
```

---

## Q2. What is Narrowing Conversion?

```text
Manual conversion

Large Type → Small Type
```

Example:

```java
int → byte
```

---

## Q3. Why is Casting Needed?

```text
To acknowledge possible data loss.
```

---

## Q4. Why does byte + byte return int?

```text
Java promotes byte
to int before arithmetic.
```

---

## Q5. Can boolean be converted into int?

```text
No
```

---

## Q6. What happens when float converts to int?

```text
Decimal portion is truncated.
```

---

## Q7. What is the promotion hierarchy?

```text
byte
short
char
  ↓
 int
  ↓
long
  ↓
float
  ↓
double
```

---

# 60-Second Revision

```text
Widening

byte → short → int → long → float → double

Automatic
No Data Loss


Narrowing

double → float → long → int → short → byte

Manual Casting
Possible Data Loss


char → int

Uses Unicode Value


float → int

Decimal Part Removed


boolean

Cannot Convert


Type Promotion

byte
short
char

become int


Hierarchy

int
 ↓
long
 ↓
float
 ↓
double
```

# Interview One-Liner

"Java automatically performs widening conversions when moving from a smaller type to a larger type, but narrowing conversions require explicit casting because data loss may occur. During arithmetic operations, byte, short, and char are automatically promoted to int, and the entire expression is promoted to the highest data type present according to Java's type promotion rules."
