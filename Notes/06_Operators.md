# Java Operators

---

# Introduction

Operators are special symbols used to perform operations on variables and values.

Example:

```java
int a = 10;
int b = 20;

int sum = a + b;
```

Here:

```text
+
```

is an operator.


# Types of Operators in Java

```text
Operators
    |
    +--------------------------------------+
    |          |          |               |
    v          v          v               v

Arithmetic  Relational  Logical      Bitwise
    |
    +-------------------------+
    |                         |
    v                         v

Assignment               Ternary
```

---

# 1. Arithmetic Operators

Used for mathematical calculations.

---

## Addition (+)

```java
int a = 10;
int b = 20;

System.out.println(a + b);
```

Output:

```text
30
```

---

## Subtraction (-)

```java
System.out.println(20 - 5);
```

Output:

```text
15
```

---

## Multiplication (*)

```java
System.out.println(5 * 4);
```

Output:

```text
20
```

---

## Division (/)

```java
System.out.println(20 / 5);
```

Output:

```text
4
```

---

### Integer Division

```java
System.out.println(7 / 2);
```

Output:

```text
3
```

Why?

```text
7 / 2 = 3.5

Decimal part discarded.
```

---

## Modulo (%)

Returns remainder.

```java
System.out.println(10 % 3);
```

Output:

```text
1
```

---

### Memory Visualization

```text
10 ÷ 3

3 × 3 = 9

10 - 9 = 1

Remainder = 1
```

---

### Common Uses

```text
Even/Odd Check

Digit Extraction

Circular Indexing
```

---

## Even Number Check

```java
if(num % 2 == 0)
```

Example:

```java
10 % 2 = 0
```

Even.

---

# Compound Assignment Operators

---

Instead of:

```java
a = a + 5;
```

Use:

```java
a += 5;
```

---

## Examples

### +=

```java
a += 10;
```

Equivalent:

```java
a = a + 10;
```

---

### -=

```java
a -= 5;
```

Equivalent:

```java
a = a - 5;
```

---

### *=

```java
a *= 2;
```

Equivalent:

```java
a = a * 2;
```

---

### /=

```java
a /= 2;
```

Equivalent:

```java
a = a / 2;
```

---

### %=

```java
a %= 2;
```

Equivalent:

```java
a = a % 2;
```

---

# Increment Operator (++)

Adds 1 to variable.

---

## Example

```java
int a = 5;

a++;
```

Equivalent:

```java
a = a + 1;
```

Result:

```text
6
```

---

# Decrement Operator (--)

Subtracts 1 from variable.

```java
a--;
```

Equivalent:

```java
a = a - 1;
```

---

# Prefix vs Postfix

Most Asked Interview Question.

---

# Postfix Increment

Syntax:

```java
x++;
```

Rule:

```text
Use First
Increment Later
```

---

## Example

```java
int j = 9;

int k = j++;
```

---

### Execution

Step 1:

```text
k = 9
```

Step 2:

```text
j = 10
```

---

Final Values

```text
j = 10
k = 9
```

---

### Memory Diagram

```text
Before

j = 9

After Assignment

k = 9

Then Increment

j = 10
```

---

# Prefix Increment

Syntax:

```java
++x
```

Rule:

```text
Increment First
Use Later
```

---

## Example

```java
int j = 10;

int l = ++j;
```

---

### Execution

Step 1

```text
j = 11
```

Step 2

```text
l = 11
```

---

Final Values

```text
j = 11
l = 11
```

---

# Prefix vs Postfix Summary

| Feature        | Prefix (++i) | Postfix (i++) |
| -------------- | ------------ | ------------- |
| Increment      | First        | Later         |
| Value Used     | New Value    | Old Value     |
| Example Result | 11           | 10            |

---

# Relational Operators

Used to compare values.

Result is always:

```text
true

or

false
```

---

## Equal To (==)

```java
10 == 10
```

Output:

```text
true
```

---

## Not Equal To (!=)

```java
10 != 20
```

Output:

```text
true
```

---

## Greater Than (>)

```java
20 > 10
```

Output:

```text
true
```

---

## Less Than (<)

```java
5 < 10
```

Output:

```text
true
```

---

## Greater Than Equal (>=)

```java
10 >= 10
```

Output:

```text
true
```

---

## Less Than Equal (<=)

```java
5 <= 10
```

Output:

```text
true
```

---

# Assignment (=) vs Equality (==)

---

Assignment:

```java
a = b;
```

Meaning:

```text
Copy value of b into a
```

---

Comparison:

```java
a == b
```

Meaning:

```text
Are both values equal?
```

---

# Bitwise Operators

Operate directly on bits.

```text
0 and 1
```

---

# Bitwise AND (&)

Truth Table

| A | B | A&B |
| - | - | --- |
| 0 | 0 | 0   |
| 0 | 1 | 0   |
| 1 | 0 | 0   |
| 1 | 1 | 1   |

---

## Example

```java
5 & 3
```

Binary:

```text
5 = 101
3 = 011
---------
    001
```

Result:

```text
1
```

---

# Bitwise OR (|)

Truth Table

| A | B | A|B |
| - | - | --- |
| 0 | 0 | 0   |
| 0 | 1 | 1   |
| 1 | 0 | 1   |
| 1 | 1 | 1   |

---

Example:

```java
5 | 3
```

```text
101
011
---
111
```

Result:

```text
7
```

---

# Bitwise XOR (^)

Rule:

```text
Same Bits → 0

Different Bits → 1
```

---

Truth Table

| A | B | A^B |
| - | - | --- |
| 0 | 0 | 0   |
| 0 | 1 | 1   |
| 1 | 0 | 1   |
| 1 | 1 | 0   |

---

Example

```java
5 ^ 3
```

```text
101
011
---
110
```

Result:

```text
6
```

---

# Bitwise NOT (~)

Flips bits.

```text
0 → 1

1 → 0
```

---

Example

```java
~5
```

Binary:

```text
00000101
```

Invert:

```text
11111010
```

Result:

```text
-6
```

(Two's Complement Rule)

---

# Shift Operators

---

# Left Shift (<<)

Moves bits left.

Every shift:

```text
× 2
```

---

Example

```java
8 << 1
```

Binary:

```text
00001000
```

Shift:

```text
00010000
```

Result:

```text
16
```

---

# Formula

```text
n << k

=

n × 2^k
```

---

Example

```java
5 << 2
```

```text
5 × 4

= 20
```

---

# Right Shift (>>)

Moves bits right.

Every shift:

```text
÷ 2
```

---

Example

```java
8 >> 1
```

```text
1000

↓

0100
```

Result:

```text
4
```

---

# Formula

```text
n >> k

=

n / 2^k
```

---

# Signed Right Shift

```java
>>
```

Preserves sign bit.

---

Example

```text
Negative Number

11111000

↓

11111100
```

Leading 1 preserved.

---

# Unsigned Right Shift

```java
>>>
```

Always inserts:

```text
0
```

---

Example

```text
11111000

↓

01111100
```

---

# Shift Rules

---

## Rule 1

byte and short become int.

```java
byte b = 10;

b << 2
```

Internally:

```text
byte → int
```

---

## Rule 2

Modulo 32 Rule

For int:

```text
Shift Count

0 - 31
```

---

Example

```java
5 << 32
```

Internally:

```text
32 % 32

= 0
```

Result:

```text
5
```

---

# Logical Operators

Used with boolean values.

---

# Logical AND (&&)

Both conditions must be true.

---

Truth Table

| A | B | Result |
| - | - | ------ |
| T | T | T      |
| T | F | F      |
| F | T | F      |
| F | F | F      |

---

Example

```java
(10 > 5) && (20 > 15)
```

Output:

```text
true
```

---

# Logical OR (||)

At least one must be true.

---

Truth Table

| A | B | Result |
| - | - | ------ |
| T | T | T      |
| T | F | T      |
| F | T | T      |
| F | F | F      |

---

Example

```java
(10 > 5) || (20 < 10)
```

Output:

```text
true
```

---

# Short Circuiting

---

## AND (&&)

If first condition is false:

```text
Stop Evaluation
```

---

Example

```java
false && anything
```

Result:

```text
false
```

Second part never checked.

---

## OR (||)

If first condition is true:

```text
Stop Evaluation
```

---

Example

```java
true || anything
```

Result:

```text
true
```

---

# Single & and |

Forces evaluation of both sides.

Example:

```java
a & b
```

Both conditions executed.

No short circuiting.

---

# Assignment Operators

---

## Basic Assignment

```java
int x = 10;
```

---

## Chained Assignment

```java
int a, b, c;

a = b = c = 10;
```

---

Evaluation

```text
Right → Left
```

---

Flow

```text
10
 |
 c
 |
 b
 |
 a
```

---

# Ternary Operator

Only operator with three operands.

---

Syntax

```java
condition ? value1 : value2
```

---

Equivalent

```java
if(condition)
    value1;
else
    value2;
```

---

Example

```java
int max =
(a > b) ? a : b;
```

---

Visualization

```text
Condition
    |
 True ----- False
   |           |
   v           v

value1      value2
```

---

# Operator Precedence

When multiple operators appear together.

---

## Highest to Lowest

| Priority | Operators          |
| -------- | ------------------ |
| 1        | Postfix (++ --)    |
| 2        | Prefix (++ -- ! ~) |
| 3        | * / %              |
| 4        | + -                |
| 5        | << >> >>>          |
| 6        | < > <= >=          |
| 7        | == !=              |
| 8        | &                  |
| 9        | ^                  |
| 10       | |                  |
| 11       | &&                 |
| 12       | ||                 |
| 13       | ?:                 |
| 14       | = += -= *= /= %=   |

---

# Example

```java
int result =
10 + 5 * 2;
```

---

Evaluation

```text
5 * 2 = 10

10 + 10 = 20
```

Output:

```text
20
```

---

# Best Practice

Never depend completely on precedence.

Use brackets.

---

Bad

```java
a + b * c - d
```

---

Good

```java
a + (b * c) - d
```

---

# 60-Second Revision

```text
Arithmetic

+ - * / %


Increment

i++

Use First

Increment Later


++i

Increment First

Use Later


Relational

== != > < >= <=


Logical

&&

||

Short Circuiting


Bitwise

&
|
^
~


Shift

<<  Multiply by 2

>>  Divide by 2

>>> Unsigned Shift


Ternary

condition ? true : false


Assignment

=

+=

-=

*=

/=

%=


Best Practice

Use Parentheses
Instead of Memorizing
Precedence
```

# Interview One-Liner

"Java operators are classified into arithmetic, relational, logical, bitwise, assignment, shift, and ternary operators. Arithmetic operators perform calculations, relational operators return boolean results, logical operators support short-circuit evaluation, bitwise operators manipulate binary data directly, and operator precedence determines the order of evaluation unless overridden using parentheses."
