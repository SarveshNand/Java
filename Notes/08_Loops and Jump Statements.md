
---

# 1. Iteration Statements (Loops)

## What is Iteration?

Iteration means repeatedly executing a block of code until a condition becomes false.

### Real-Life Example

Imagine filling water bottles in a factory:

```
While bottles remain:
    Fill bottle
    Move to next bottle
```

This repetitive process is exactly what loops do.

---

# Types of Loops in Java

```
                 Loops
                   |
      --------------------------------
      |              |              |
    while         do-while         for
      |              |              |
 Entry Controlled Exit Controlled Entry Controlled
```

---

# A. while Loop

## Definition

A `while` loop checks the condition BEFORE executing the loop body.

### Syntax

```java
while(condition){
    // code
}
```

---

## Flowchart

```text
        ┌─────────────┐
        │ Start       │
        └──────┬──────┘
               │
               ▼
        ┌─────────────┐
        │ Condition ? │
        └──────┬──────┘
          True │ False
               │
               ▼
        ┌─────────────┐
        │ Loop Body   │
        └──────┬──────┘
               │
               └─────────────► Back to Condition

False ─────────────► End
```

---

## Example 1: Print 1 to 5

```java
int i = 1;

while(i <= 5){
    System.out.println(i);
    i++;
}
```

### Output

```text
1
2
3
4
5
```

---

## Execution Trace

| i | Condition | Output |
|---|---|---|
|1|1<=5 ✓|1|
|2|2<=5 ✓|2|
|3|3<=5 ✓|3|
|4|4<=5 ✓|4|
|5|5<=5 ✓|5|
|6|6<=5 ✗|Stop|

---

## Reverse Loop

```java
int i = 5;

while(i >= 1){
    System.out.println(i);
    i--;
}
```

Output:

```text
5
4
3
2
1
```

---

## Infinite Loop

```java
while(true){
    System.out.println("Hello");
}
```

Since condition never becomes false, loop never ends.

---

## Interview Question

### Q: When should we use while loop?

**Answer:**

Use `while` when the number of iterations is unknown beforehand.

Example:

```java
while(userInput != password){
    takeInput();
}
```

---

# B. do-while Loop

## Definition

A do-while loop executes first and checks condition later.

Therefore:

> It always executes at least one time.

---

## Syntax

```java
do{
    // code
}
while(condition);
```

---

## Flowchart

```text
        ┌───────────┐
        │ Start     │
        └─────┬─────┘
              │
              ▼
        ┌───────────┐
        │ Loop Body │
        └─────┬─────┘
              │
              ▼
        ┌───────────┐
        │Condition? │
        └─────┬─────┘
        True  │ False
              │
              ▼
         Back to Body

False ─────► End
```

---

## Example

```java
int i = 10;

do{
    System.out.println(i);
}while(i < 5);
```

### Output

```text
10
```

Even though condition is false, loop runs once.

---

## Why Menu Programs Use do-while?

Example:

```java
int choice;

do{
    System.out.println("1.Play");
    System.out.println("2.Save");
    System.out.println("3.Exit");

    choice = scanner.nextInt();

}while(choice != 3);
```

### Logic

```
Show menu
     ↓
Take choice
     ↓
Exit?
     ↓
No → Show menu again
```

---

## Interview Question

### Q: Difference between while and do-while?

| while | do-while |
|---------|---------|
|Condition checked first|Body executes first|
|May execute 0 times|Executes at least 1 time|
|Entry controlled|Exit controlled|

---

# C. for Loop

## Definition

A for loop combines:

1. Initialization
2. Condition
3. Update

in one statement.

---

## Syntax

```java
for(initialization; condition; update){
    // code
}
```

---

## Flowchart

```text
      Start
        |
        ▼
 Initialization
        |
        ▼
   Condition?
    /      \
 True      False
  |           |
  ▼           ▼
Body         End
  |
  ▼
Update
  |
  └────► Condition
```

---

## Example

```java
for(int i=1;i<=5;i++){
    System.out.println(i);
}
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

## Internal Working

```java
int i=1;

while(i<=5){
    System.out.println(i);
    i++;
}
```

A for loop internally behaves similarly.

---

## Interview Favorite

### for(;;)

```java
for(;;){
    System.out.println("Infinite");
}
```

Equivalent to:

```java
while(true)
```

---

## Multiple Variables

```java
for(int i=1,j=10;i<=5;i++,j--){
    System.out.println(i+" "+j);
}
```

Output

```text
1 10
2 9
3 8
4 7
5 6
```

---

## Common Mistake

Wrong:

```java
for(int i=1,j=1; i<10, j<20; i++)
```

Invalid in Java.

Correct:

```java
for(int i=1,j=1; i<10 && j<20; i++)
```

---

# Comparison of Loops

| Feature | while | do-while | for |
|----------|---------|---------|---------|
|Condition Position|Before|After|Before|
|Minimum Execution|0|1|0|
|Best For|Unknown iterations|Menu systems|Known iterations|
|Popularity|Medium|Low|Highest|

---

# 2. Nested Loops

## Definition

A loop inside another loop.

```java
for(...){
    for(...){
        ...
    }
}
```

---

# Visualization

```text
Outer Loop
 ├── Inner Loop
 ├── Inner Loop
 ├── Inner Loop
 └── ...
```

For every iteration of outer loop, inner loop completes entirely.

---

# Example

```java
for(int i=1;i<=3;i++){

    for(int j=1;j<=2;j++){
        System.out.println(i+" "+j);
    }

}
```

Output

```text
1 1
1 2
2 1
2 2
3 1
3 2
```

---

# Execution Diagram

```text
i=1
  j=1
  j=2

i=2
  j=1
  j=2

i=3
  j=1
  j=2
```

---

# Pattern Printing

## Triangle

```java
for(int i=1;i<=5;i++){

    for(int j=1;j<=i;j++){
        System.out.print("*");
    }

    System.out.println();
}
```

Output

```text
*
**
***
****
*****
```

---

# Complexity

Outer Loop = n

Inner Loop = m

Total Work:

```text
n × m
```

Example:

```java
for(i=0;i<n;i++)
    for(j=0;j<n;j++)
```

Complexity:

```text
O(n²)
```

---

# Interview Question

### Why are nested loops expensive?

Because inner loop executes fully for every iteration of outer loop.

---

# 3. Jump Statements

```
Jump Statements
      |
  -------------
  |           |
break      continue
```

---

# A. break Statement

## Purpose

Immediately exits the loop.

---

## Flowchart

```text
Loop Start
    |
    ▼
Condition?
    |
    ▼
break encountered?
    |
 Yes
    |
    ▼
Exit Loop
```

---

## Example

```java
for(int i=1;i<=10;i++){

    if(i==5)
        break;

    System.out.println(i);
}
```

Output

```text
1
2
3
4
```

---

## Prime Number Example

```java
int n=12;

for(int i=2;i<n;i++){

    if(n%i==0){
        System.out.println("Not Prime");
        break;
    }

}
```

No need to check remaining divisors.

---

# B. continue Statement

## Purpose

Skip current iteration.

---

## Flowchart

```text
Iteration Start
       |
       ▼
Condition?
       |
       ▼
continue?
       |
     Yes
       |
       ▼
Next Iteration
```

---

## Example

```java
for(int i=1;i<=10;i++){

    if(i%2==0)
        continue;

    System.out.println(i);
}
```

Output

```text
1
3
5
7
9
```

---

# Difference Between break and continue

| break | continue |
|---------|---------|
|Exits loop|Skips current iteration|
|Control goes outside loop|Control goes to next iteration|

---

# C. Labels

---

## Problem

```java
for(...)
{
    for(...)
    {
        break;
    }
}
```

Only inner loop exits.

---

## Solution

```java
outer:

for(int i=1;i<=3;i++){

    for(int j=1;j<=3;j++){

        if(j==2)
            break outer;
    }
}
```

---

## Diagram

```text
Outer Loop
    |
    └── Inner Loop
           |
           └── break outer
                    |
                    ▼
                  End
```

---

# Named Blocks

```java
block1:
{
    System.out.println("A");

    if(true)
        break block1;

    System.out.println("B");
}
```

Output

```text
A
```

---

# 4. Type Conversion & Type Promotion

---

# Data Type Hierarchy

```text
byte
  ↓
short
  ↓
int
  ↓
long
  ↓
float
  ↓
double
```

Moving downward = Safe

Moving upward = Casting Required

---

# A. Type Conversion

## Implicit Conversion (Widening)

Automatic conversion.

```java
byte b = 10;

int x = b;
```

Diagram:

```text
byte (8 bit)
      ↓
int (32 bit)
```

Safe because larger container exists.

---

# Explicit Conversion (Casting)

```java
int x = 100;

byte b = (byte)x;
```

Manual conversion required.

---

# 300 Example

```java
int x = 300;

byte b = (byte)x;
```

---

## Binary Explanation

```text
300 = 00000000 00000000 00000001 00101100
```

byte keeps only last 8 bits

```text
00101100
```

Decimal:

```text
44
```

Output:

```java
44
```

---

# Shortcut Formula

For byte:

```text
Result = Value % 256
```

Example:

```text
300 % 256 = 44
```

---

# Float to Int

```java
float f = 15.67f;

int x = (int)f;
```

Output

```text
15
```

Decimal part removed.

---

# Boolean Restriction

Invalid:

```java
boolean b = true;

int x = (int)b;
```

Compile-time error.

Java never allows boolean conversion.

---

# B. Automatic Type Promotion

---

## Rule 1

byte, short and char become int during calculations.

```java
byte a=10;
byte b=20;

byte c=a+b; // Error
```

Reason:

```text
a+b becomes int
```

---

## Correct

```java
byte c=(byte)(a+b);
```

---

# Promotion Flow

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

Highest type dominates.

---

## Example

```java
int a=10;
double b=20.5;

double c=a+b;
```

Result type:

```text
double
```

---

## Example

```java
int a=10;
long b=20;

long c=a+b;
```

Result:

```text
long
```

---

# Interview Traps

## Trap 1

```java
byte b = 50;

b = b * 2;
```

Error.

Because:

```text
b*2 → int
```

Correct:

```java
b = (byte)(b*2);
```

---

## Trap 2

```java
char c='A';

c++;
```

Valid.

Output:

```text
B
```

---

## Trap 3

```java
char c='A';

int x=c;
```

Output:

```text
65
```

ASCII/Unicode value stored.

---

# Frequently Asked Interview Questions

### 1. Difference between while and do-while?

- while → checks before execution
- do-while → executes at least once

---

### 2. Which loop is most used in production?

`for` loop

Because initialization, condition and update are together.

---

### 3. What creates an infinite loop?

```java
while(true)
```

or

```java
for(;;)
```

---

### 4. Complexity of nested loops?

```text
O(n × m)
```

If both loops run n times:

```text
O(n²)
```

---

### 5. Difference between break and continue?

- break → exits loop completely
- continue → skips current iteration

---

### 6. Why does byte + byte become int?

Java promotes smaller types to int for arithmetic operations.

---

### 7. Can boolean be converted to int?

No.

Java completely prohibits boolean conversion.

---

# Quick Revision Sheet

```text
while
------
Condition first
0 or more executions

do-while
---------
Condition later
At least 1 execution

for
---
Initialization
Condition
Update

Nested Loop
-----------
Outer × Inner
O(n²)

break
-----
Exit loop

continue
--------
Skip iteration

Implicit Conversion
-------------------
Small → Large

Explicit Conversion
-------------------
Large → Small

Promotion
---------
byte/short/char → int

Hierarchy
---------
byte → short → int → long → float → double
```

# Memory Trick

```text
while      → CHECK then RUN
do-while   → RUN then CHECK
for        → ALL-IN-ONE LOOP

break      → EXIT
continue   → SKIP

Widening   → Automatic
Narrowing  → Casting

Small Types Arithmetic
(byte/short/char)
        ↓
       int
```

---
