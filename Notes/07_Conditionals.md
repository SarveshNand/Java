# Java Flow of Control, Conditionals, Switch, Type Conversion & Promotion

---

# Part 1: Flow of Control in Java

Flow of control defines the **order of execution** of statements in a program.

---

## 1. Sequential Flow (Default)

Java executes code **top to bottom**.

```text id="seq1"
Line 1
  ↓
Line 2
  ↓
Line 3
```

Example:

```java id="seq2"
System.out.println("A");
System.out.println("B");
System.out.println("C");
```

Output:

```text id="seq3"
A
B
C
```

---

## 2. Non-Sequential Flow

Java modifies flow using control statements:

```text id="ctrl1"
Flow Control
   |
   +-------------------+
   |        |          |
   v        v          v
Selection  Loop     Jump
(if/switch) (for/while) (break/continue)
```

---

# Part 2: Selection Statements (Conditionals)

Selection statements decide **which block executes**.

---

# 1. if Statement

---

## Syntax

```java id="if1"
if(condition) {
    // code
}
```

---

## Rule

```text id="if2"
Condition must return boolean
```

---

## Example

```java id="if3"
int age = 18;

if(age >= 18) {
    System.out.println("Eligible to vote");
}
```

---

## Flow Diagram

```text id="if4"
Condition
   |
   v
 true → Execute block
 false → Skip block
```

---

# 2. if-else Statement

---

## Syntax

```java id="ifelse1"
if(condition) {
    // true block
} else {
    // false block
}
```

---

## Example: Even/Odd

```java id="ifelse2"
int i = 7;

if(i % 2 == 0) {
    System.out.println("Even");
} else {
    System.out.println("Odd");
}
```

---

## Flow Diagram

```text id="ifelse3"
Condition
   |
  / \
 T   F
 |   |
 A   B
```

---

# 3. Curly Braces Rule

---

## Single Statement Allowed

```java id="brace1"
if(true)
    System.out.println("Hello");
```

---

## But Best Practice

```java id="brace2"
if(true) {
    System.out.println("Hello");
}
```

---

## Why?

```text id="brace3"
Avoid bugs when adding new lines later
```

---

# 4. Nested if

---

## Example

```java id="nested1"
int age = 20;

if(age > 10) {
    if(age > 18) {
        System.out.println("Adult");
    }
}
```

---

## Rule

```text id="nested2"
else belongs to nearest if
```

---

## Flow

```text id="nested3"
if → if → execute
```

---

## Best Practice

Avoid deep nesting (>2 levels)

Use:

```text id="nested4"
Logical operators (&&, ||)
```

---

# 5. if-else-if Ladder

---

## Syntax

```java id="ladder1"
if(cond1) {}
else if(cond2) {}
else if(cond3) {}
else {}
```

---

## Example: Age Category

```java id="ladder2"
int age = 50;

if(age > 80) {
    System.out.println("Very Old");
}
else if(age > 60) {
    System.out.println("Old");
}
else if(age > 40) {
    System.out.println("Middle aged");
}
```

---

## Flow Diagram

```text id="ladder3"
cond1 → true → stop
   ↓ false
cond2 → true → stop
   ↓ false
cond3 → true → stop
   ↓
default
```

---

## Key Feature

```text id="ladder4"
Only ONE block executes
```

---

# Part 3: switch Statement

---

# 1. Syntax

```java id="switch1"
switch(expression) {

    case value1:
        break;

    case value2:
        break;

    default:
}
```

---

# 2. Flow Diagram

```text id="switch2"
Expression
    ↓
Match Case
    ↓
Execute Block
    ↓
break → Exit
```

---

# 3. Example

```java id="switch3"
int day = 2;

switch(day) {
    case 1:
        System.out.println("Mon");
        break;

    case 2:
        System.out.println("Tue");
        break;

    default:
        System.out.println("Invalid");
}
```

---

## Output

```text id="switch4"
Tue
```

---

# 4. Fall-through Problem

---

## Without break

```java id="switch5"
int x = 1;

switch(x) {
    case 1:
        System.out.println("A");
    case 2:
        System.out.println("B");
}
```

---

## Output

```text id="switch6"
A
B
```

---

## Reason

```text id="switch7"
No break → execution continues
```

---

# 5. switch vs if-else

| Feature        | if-else    | switch       |
| -------------- | ---------- | ------------ |
| Range check    | Yes        | No           |
| Equality check | Yes        | Yes          |
| Speed          | Slower     | Faster       |
| Best use       | Conditions | Fixed values |

---

# 6. Internal Optimization

---

## Switch Uses Jump Table

```text id="opt1"
O(1) direct jump
```

---

## if-else ladder

```text id="opt2"
O(n) sequential checks
```

---

## Representation

```text id="opt3"
switch → index table → jump

if-else → check line by line
```

---

# Part 4: Type Conversion & Casting

---

# 1. Widening Conversion (Implicit)

---

## Definition

Small → Large automatically

```text id="conv1"
byte → short → int → long → float → double
```

---

## Example

```java id="conv2"
byte b = 10;
int i = b;
```

---

## Why safe?

```text id="conv3"
No data loss
```

---

## char → int

```java id="conv4"
char c = 'A';
int i = c;
```

Output:

```text id="conv5"
65
```

---

# 2. Narrowing Conversion (Explicit)

---

## Definition

Large → Small manually

```text id="conv6"
Requires casting
```

---

## Example

```java id="conv7"
int i = 300;
byte b = (byte)i;
```

---

## Result Logic

```text id="conv8"
300 % 256 = 44
```

---

## Memory View

```text id="conv9"
300 → binary → last 8 bits → 44
```

---

# Float to Int (Truncation)

```java id="conv10"
float f = 15.67f;
int i = (int)f;
```

---

## Output

```text id="conv11"
15
```

---

## Rule

```text id="conv12"
Decimal part removed (NOT rounded)
```

---

# Boolean Rule

```text id="conv13"
boolean → cannot convert to any type
```

---

# Part 5: Type Promotion

---

# 1. Definition

During expressions, Java converts smaller types into larger ones automatically.

---

# 2. Promotion Rules

```text id="promo1"
byte, short, char → int
int → long → float → double
```

---

# 3. Example

```java id="promo2"
byte a = 10;
byte b = 20;

int result = a + b;
```

---

## Why int?

```text id="promo3"
Java promotes operands to int
```

---

# 4. Byte Trap

```java id="promo4"
byte b = 50;

b = b * 2;
```

---

## Problem

```text id="promo5"
b * 2 → int
int → byte (error)
```

---

## Solution

```java id="promo6"
b = (byte)(b * 2);
```

---

# 5. Promotion Hierarchy

```text id="promo7"
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

# 6. Complex Expression Rule

---

Example:

```text id="promo8"
(f * b) + (i / c) - (d * s)
```

---

## Step-by-step

```text id="promo9"
f * b → float
i / c → int
d * s → double
```

---

## Final Type

```text id="promo10"
double (highest type wins)
```

---

# 60-Second Revision Sheet

```text id="rev1"
Flow Control
- Sequential
- Selection
- Loop
- Jump


Selection
- if
- if-else
- ladder
- switch


switch
- faster than if-else
- uses jump table
- needs break


Type Conversion
- Widening (auto)
- Narrowing (cast)


Promotion
byte, short, char → int
others → highest type


Rules
- no boolean conversion
- char → int uses Unicode
- float → int truncates decimals
```

---

# Interview One-Liner

"Java flow control consists of sequential execution, selection statements like if and switch, loops, and jump statements. Selection allows decision-making using boolean conditions, while switch provides optimized multi-way branching using jump tables. Type conversion in Java is either widening (automatic) or narrowing (explicit), and during expressions Java performs type promotion where smaller types like byte, short, and char are promoted to int and the final result is determined by the highest data type in the expression."
