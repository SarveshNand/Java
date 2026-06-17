# Java Internal Representation of Numbers

## Two's Complement, IEEE 754 Floating Point, Precision Issues & BigDecimal

---

# Introduction

Computers understand only:

```text
0 and 1
```

Everything stored in memory:

```text
Numbers
Characters
Images
Videos
Programs
```

is ultimately converted into binary.

One important question is:

```text
How does Java store
negative numbers and decimal numbers?
```

The answer involves:

1. Two's Complement (Integers)
2. IEEE 754 Standard (Floating Point Numbers)

---

# Part 1: Internal Storage of Negative Numbers

---

# Problem Statement

Computers understand binary only.

Example:

```text
42  -> Easy

101010
```

But how do we store:

```text
-42 ?
```

There is no minus sign in memory.

---

# Solution: Two's Complement

Java stores negative integers using:

```text
Two's Complement Representation
```

---

# Why Two's Complement?

Benefits:

```text
✓ Easy Arithmetic

✓ Fast Hardware Implementation

✓ Single Representation of Zero

✓ Industry Standard
```

---

# Example: Store -42 in a byte

A byte contains:

```text
8 Bits
```

---

## Step 1: Convert Positive Number to Binary

Ignore the sign first.

```text
42
```

Binary:

```text
00101010
```

---

## Memory View

```text
Bit Position

0 0 1 0 1 0 1 0
```

---

## Step 2: Find One's Complement

Invert all bits.

Rule:

```text
0 -> 1

1 -> 0
```

---

Calculation:

```text
00101010
```

becomes

```text
11010101
```

---

## Visualization

```text
Original

0 0 1 0 1 0 1 0

Invert

1 1 0 1 0 1 0 1
```

---

## Step 3: Add 1

```text
11010101
+       1
---------
11010110
```

---

# Final Stored Value

```text
-42

Stored as:

11010110
```

---

# Memory Diagram

```text
Byte Memory

+------------------+
| 11010110         |
+------------------+

Represents -42
```

---

# How Java Detects Negative Numbers

Java checks:

```text
MSB
```

---

# MSB vs LSB

```text
11010110
^      ^
|      |
MSB    LSB
```

---

## MSB

Most Significant Bit

Leftmost bit.

---

## LSB

Least Significant Bit

Rightmost bit.

---

# Sign Rule

| MSB | Meaning  |
| --- | -------- |
| 0   | Positive |
| 1   | Negative |

---

Example

```text
00101010
```

MSB = 0

```text
Positive
```

---

Example

```text
11010110
```

MSB = 1

```text
Negative
```

---

# How Java Reads -42

Suppose memory contains:

```text
11010110
```

---

Step 1:

One's Complement

```text
00101001
```

---

Step 2:

Add 1

```text
00101010
```

---

Step 3:

Convert to Decimal

```text
42
```

---

Step 4:

Apply Negative Sign

```text
-42
```

---

# Why Not Use One's Complement?

Because of:

```text
Negative Zero Problem
```

---

# Positive Zero

```text
00000000
```

---

# Negative Zero (One's Complement)

Invert all bits.

```text
11111111
```

Now we have:

```text
+0

and

-0
```

Two representations.

Bad design.

---

# Two's Complement Fix

Add 1.

```text
11111111
+       1
---------
100000000
```

---

But byte has only:

```text
8 Bits
```

Extra bit discarded.

Result:

```text
00000000
```

Only one zero exists.

---

# Visualization

```text
11111111
+00000001
-----------
100000000

Discard Overflow

00000000
```

---

# Integer Storage Summary

```text
Positive Number

Decimal
   |
Binary
   |
Stored


Negative Number

Decimal
   |
Binary
   |
One's Complement
   |
Add 1
   |
Stored
```

---

# Part 2: Floating Point Numbers

---

# Problem

Integers are easy.

But how do we store:

```text
8.125

3.14

0.7
```

in binary?

---

# IEEE 754 Standard

Java follows:

```text
IEEE 754
```

for storing decimal values.

---

# Float Layout

A float uses:

```text
32 Bits
```

---

# Structure

```text
+------+----------+-----------------------+
| Sign | Exponent |       Mantissa        |
+------+----------+-----------------------+

 1 Bit   8 Bits        23 Bits
```

---

# Meaning

---

## Sign Bit

```text
0 -> Positive

1 -> Negative
```

---

## Exponent

Stores:

```text
Power of 2
```

---

## Mantissa

Stores:

```text
Actual Digits
```

---

# Example: Store 8.125f

---

## Step 1: Convert Integer Part

```text
8
```

Binary:

```text
1000
```

---

## Step 2: Convert Fraction Part

```text
0.125
```

Multiply repeatedly by 2.

---

Calculation:

```text
0.125 × 2 = 0.25  -> 0

0.25 × 2 = 0.5    -> 0

0.5 × 2 = 1.0     -> 1
```

Binary:

```text
001
```

---

# Combined Binary

```text
1000.001
```

---

# Step 3: Normalize

IEEE 754 stores numbers as:

```text
1.x × 2^n
```

---

Move decimal:

```text
1000.001

↓

1.000001 × 2³
```

---

# Normalization Diagram

```text
1000.001

Move Decimal 3 Places

1.000001 × 2³
```

---

# Step 4: Sign Bit

Number:

```text
8.125
```

Positive.

```text
Sign = 0
```

---

# Step 5: Exponent

Actual exponent:

```text
3
```

---

Float Bias:

```text
127
```

---

Stored exponent:

```text
3 + 127

= 130
```

---

Convert 130 to binary:

```text
10000010
```

---

# Step 6: Mantissa

Take digits after decimal.

```text
1.000001
```

Store:

```text
000001
```

Pad remaining bits with zeros.

---

# Final IEEE 754 Layout

```text
Sign

0

Exponent

10000010

Mantissa

00000100000000000000000
```

---

# Memory Diagram

```text
+---+----------+-----------------------+
| 0 |10000010  |00000100000000000000000|
+---+----------+-----------------------+
```

---

# Precision Problem

Most Important Floating Point Interview Topic.

---

# Why 0.7 Cannot Be Stored Exactly

Decimal:

```text
0.7
```

---

Binary Conversion:

```text
0.10110011001100110011...
```

---

Pattern never ends.

Infinite binary fraction.

---

# Problem

Float Mantissa:

```text
23 Bits Only
```

---

Computer must stop.

```text
0.10110011001100110011001...
```

Cut off remaining digits.

---

# Visualization

```text
Infinite

0.10110011001100110011...

             CUT
              |
              v
0.10110011001100110011001
```

---

# Result

Stored value becomes approximation.

Not exact.

---

# Example

```java
float f = 0.7f;
```

Internally:

```text
0.69999998807907104492
```

approximately.

---

# Why println Shows 0.7

Java automatically rounds output.

```java
System.out.println(f);
```

Output:

```text
0.7
```

---

But:

```java
System.out.printf("%.20f", f);
```

reveals actual stored value.

---

# Float vs Double

---

# Float

Memory:

```text
32 Bits
```

Layout:

```text
1 Sign
8 Exponent
23 Mantissa
```

Bias:

```text
127
```

---

# Double

Memory:

```text
64 Bits
```

Layout:

```text
1 Sign
11 Exponent
52 Mantissa
```

Bias:

```text
1023
```

---

# Double Structure

```text
+------+-----------+----------------------+
| Sign | Exponent  |      Mantissa        |
+------+-----------+----------------------+

 1 Bit   11 Bits       52 Bits
```

---

# Why Double Is More Accurate

More bits:

```text
52 Mantissa Bits
```

instead of:

```text
23 Mantissa Bits
```

---

Result:

```text
Less Precision Loss
```

---

# But Double Is Still Approximate

Example:

```java
double d = 0.1;
```

Internally:

```text
0.10000000000000000555...
```

approximately.

---

# BigDecimal

When exact values are required:

```text
Banking

Finance

Tax Calculation

Currency
```

Use:

```java
BigDecimal
```

---

# Why BigDecimal?

It stores:

```text
Exact Decimal Values
```

without floating-point approximation.

---

# Example

```java
BigDecimal amount =
    new BigDecimal("0.1");
```

---

# Floating Point Flowchart

```text
Decimal Number
        |
        v
Convert to Binary
        |
        v
Normalize
        |
        v
Sign Bit
Exponent
Mantissa
        |
        v
Store Using IEEE 754
```

---

# Float vs Double Summary

| Feature        | Float       | Double      |
| -------------- | ----------- | ----------- |
| Total Bits     | 32          | 64          |
| Sign Bit       | 1           | 1           |
| Exponent       | 8           | 11          |
| Mantissa       | 23          | 52          |
| Bias           | 127         | 1023        |
| Precision      | Lower       | Higher      |
| Industry Usage | Less Common | Most Common |

---

# Common Interview Questions

### Q1. How are negative numbers stored in Java?

```text
Using Two's Complement Representation
```

---

### Q2. What determines sign?

```text
MSB

0 -> Positive

1 -> Negative
```

---

### Q3. Why is Two's Complement used?

```text
Avoids Negative Zero

Simplifies Arithmetic
```

---

### Q4. What is IEEE 754?

```text
Standard for storing
floating point numbers.
```

---

### Q5. Why does 0.7 lose precision?

```text
Infinite binary representation
must be truncated.
```

---

### Q6. Why is double preferred?

```text
Higher precision

52-bit Mantissa
```

---

### Q7. When should BigDecimal be used?

```text
Financial Calculations

Currency Operations

Exact Decimal Requirements
```

---

# 60-Second Revision

```text
Negative Integers

1. Convert to Binary

2. One's Complement

3. Add 1

= Two's Complement


MSB

0 -> Positive

1 -> Negative


Float (32-bit)

1 Sign

8 Exponent

23 Mantissa

Bias = 127


Double (64-bit)

1 Sign

11 Exponent

52 Mantissa

Bias = 1023


0.7

Infinite Binary

=> Truncation

=> Precision Loss


Exact Decimal?

Use BigDecimal
```

# Interview One-Liner

"Java stores negative integers using Two's Complement representation, while floating-point numbers are stored according to the IEEE 754 standard using Sign, Exponent, and Mantissa fields; because many decimal values have infinite binary representations, floating-point types like float and double store approximations, whereas BigDecimal provides exact decimal precision."
