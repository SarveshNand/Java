
---

# 1. Introduction to Arrays

## What is an Array?

An array is a collection of elements of the **same data type** stored under a single variable name.

### Real-Life Problem

Suppose a class has 100 students.

Without arrays:

```java
int roll1 = 101;
int roll2 = 102;
int roll3 = 103;
...
int roll100 = 200;
```

Problems:

❌ Too many variables

❌ Difficult to manage

❌ Difficult to process using loops

---

## Solution: Array

```java
int[] rollNumbers = new int[100];
```

Now all roll numbers are stored under one variable.

---

# Why Arrays?

Arrays provide:

✅ Organized storage

✅ Fast access using index

✅ Easy traversal using loops

✅ Better memory management

---

# Array Memory Concept

Arrays occupy **contiguous memory locations**.

Example:

```java
int[] arr = new int[5];
```

Assume first location starts at 1000.

Since int = 4 bytes:

```text
Index     Address
-----     -------
0         1000
1         1004
2         1008
3         1012
4         1016
```

Visualization:

```text
+----+----+----+----+----+
| 10 | 20 | 30 | 40 | 50 |
+----+----+----+----+----+
  0    1    2    3    4
```

---

# Advantages of Arrays

1. Fast random access → O(1)
2. Easy traversal
3. Memory efficient
4. Useful for sorting/searching

---

# Limitations

1. Fixed size
2. Same datatype only
3. Insertion/deletion costly

---

# 2. 1D Array Declaration & Initialization

---

## Declaration

### Recommended Style

```java
int[] marks;
```

---

### Alternative Style

```java
int marks[];
```

Supported for C/C++ compatibility.

---

# Definition (Memory Allocation)

Using new keyword:

```java
int[] marks = new int[5];
```

---

## What Happens Internally?

```text
Stack Memory

marks
  |
  ▼

Heap Memory

+----+----+----+----+----+
| 0  | 0  | 0  | 0  | 0  |
+----+----+----+----+----+
```

Java automatically initializes values.

---

## Default Values

| Data Type | Default |
|------------|---------|
| int | 0 |
| double | 0.0 |
| float | 0.0 |
| boolean | false |
| char | '\u0000' |
| String | null |

---

# Direct Initialization

```java
int[] marks = {10,20,30,40,50};
```

Equivalent to:

```java
int[] marks = new int[]{
    10,20,30,40,50
};
```

---

# Array Creation Flowchart

```text
Declare Array
      |
      ▼
Allocate Memory
      |
      ▼
Assign Values
      |
      ▼
Use Array
```

---

# 3. Array Indexing

---

## Zero-Based Indexing

Java starts counting from 0.

```text
Array

+-----+-----+-----+-----+
|1001 |1002 |1003 |1004 |
+-----+-----+-----+-----+

Index

  0     1     2     3
```

---

## Assigning Values

```java
roll[0] = 1001;
roll[1] = 1002;
```

---

## Accessing Values

```java
System.out.println(roll[0]);
```

Output:

```text
1001
```

---

# Why Zero-Based Indexing?

Formula:

```text
Address = Base + (Index × Size)
```

For index 0:

```text
Base + (0 × Size)
= Base
```

Makes memory calculations efficient.

---

# 4. Array Traversal

Traversal = Visiting every element.

---

## Example

```java
int[] arr = {10,20,30,40,50};

for(int i=0;i<arr.length;i++){
    System.out.println(arr[i]);
}
```

---

## Visualization

```text
Iteration 1 → arr[0]
Iteration 2 → arr[1]
Iteration 3 → arr[2]
Iteration 4 → arr[3]
Iteration 5 → arr[4]
```

---

# Using length Property

```java
arr.length
```

Returns:

```text
5
```

---

## Why Use length?

Bad:

```java
for(int i=0;i<5;i++)
```

If size changes, code breaks.

Better:

```java
for(int i=0;i<arr.length;i++)
```

Automatically adapts.

---

# Enhanced For Loop

Also called:

```text
For-Each Loop
```

Syntax:

```java
for(int x : arr){
    System.out.println(x);
}
```

Output:

```text
10
20
30
40
50
```

---

# Comparison

| Loop | Access Index? |
|--------|--------|
| for | Yes |
| for-each | No |

---

# ArrayIndexOutOfBoundsException

---

## Example

```java
int[] arr = new int[3];

System.out.println(arr[3]);
```

Valid indexes:

```text
0
1
2
```

Index 3 doesn't exist.

---

## Memory View

```text
+----+----+----+
| 0  | 0  | 0  |
+----+----+----+

 0    1    2

Trying → arr[3]
```

Result:

```text
ArrayIndexOutOfBoundsException
```

---

# Interview Question

### Difference between length and length()?

Array:

```java
arr.length
```

String:

```java
str.length()
```

---

# 5. Multi-Dimensional Arrays (2D Arrays)

---

# What is a 2D Array?

An array containing arrays.

Visualized as a table or matrix.

---

## Example

```java
int[][] marks = new int[3][4];
```

Meaning:

```text
3 rows
4 columns
```

---

# Matrix Representation

```text
      Columns

       0  1  2  3
      ----------
0 |   0  0  0  0

1 |   0  0  0  0

2 |   0  0  0  0

Rows
```

---

# Actual Memory Structure

Important Interview Question

Java does NOT store 2D arrays as actual matrices.

Instead:

```text
marks
  |
  ▼

+-----+-----+-----+
|  *  |  *  |  *  |
+-----+-----+-----+
   |      |      |
   ▼      ▼      ▼

[ ]    [ ]    [ ]
```

A 2D array is actually:

```text
Array of Arrays
```

---

# Assigning Values

```java
marks[0][0] = 90;
marks[1][2] = 75;
```

---

# Traversing 2D Array

```java
for(int i=0;i<marks.length;i++){

    for(int j=0;j<marks[i].length;j++){

        System.out.print(marks[i][j]+" ");
    }

    System.out.println();
}
```

---

# Flowchart

```text
Row Loop
    |
    ▼
Column Loop
    |
    ▼
Print Element
    |
    ▼
Next Column
```

---

# Complexity

Rows = R

Columns = C

```text
Time Complexity = O(R × C)
```

---

# Enhanced For Loop in 2D Arrays

```java
for(int[] row : marks){

    for(int value : row){

        System.out.print(value+" ");
    }

    System.out.println();
}
```

---

# 6. Jagged Arrays

---

# What is a Jagged Array?

Rows can have different numbers of columns.

---

## Example

```java
int[][] arr = new int[3][];
```

Memory:

```text
Row 0 → ?
Row 1 → ?
Row 2 → ?
```

---

## Individual Allocation

```java
arr[0] = new int[1];
arr[1] = new int[2];
arr[2] = new int[3];
```

---

# Visualization

```text
Row 0

[ ]

Row 1

[ ][ ]

Row 2

[ ][ ][ ]
```

---

# Real-Life Example

Students with different subject counts.

```text
Student A → 2 subjects
Student B → 4 subjects
Student C → 3 subjects
```

Jagged arrays save memory.

---

# Traversal

```java
for(int i=0;i<arr.length;i++){

    for(int j=0;j<arr[i].length;j++){

        System.out.print(arr[i][j]+" ");
    }

    System.out.println();
}
```

---

# Interview Question

### Why are jagged arrays useful?

Because memory is allocated according to actual requirement.

---

# 7. Strings in Java

---

# What is a String?

A String is a sequence of characters.

```java
String name = "Aditya";
```

---

# Character vs String

| Character | String |
|------------|---------|
| 'A' | "A" |
| Single quotes | Double quotes |
| char | String |

---

# Memory Representation

```java
String name = "Java";
```

```text
J → a → v → a
```

---

# String Declaration

```java
String name = "Aditya";
```

---

## Using Constructor

```java
String name = new String("Aditya");
```

---

# String Concatenation

```java
String first = "Aditya";
String last = "Singh";

String full = first + " " + last;
```

Output:

```text
Aditya Singh
```

---

# Concatenation Diagram

```text
"Aditya"
     +
" Singh"
     |
     ▼

"Aditya Singh"
```

---

# Empty String

```java
String s = "";
```

Length:

```java
0
```

---

## Space String

```java
String s = " ";
```

Length:

```java
1
```

Contains one space character.

---

# Important String Methods

---

## length()

```java
String s = "Java";

System.out.println(s.length());
```

Output:

```text
4
```

---

## charAt()

```java
s.charAt(0);
```

Output:

```text
J
```

---

## toUpperCase()

```java
s.toUpperCase();
```

Output:

```text
JAVA
```

---

## toLowerCase()

```java
s.toLowerCase();
```

Output:

```text
java
```

---

## equals()

```java
s.equals("Java")
```

Returns:

```text
true
```

---

# String Immutability

Interview Favorite

```java
String s = "Java";

s = s + " Programming";
```

New string is created.

Old string remains unchanged.

```text
"Java"
      ↓

"Java Programming"
```

Strings are immutable.

---

# 8. Higher Dimensional Arrays

---

# 3D Arrays

```java
int[][][] cube = new int[2][3][4];
```

Meaning:

```text
2 Layers
3 Rows
4 Columns
```

---

# Visualization

```text
Layer 1

[Matrix]

Layer 2

[Matrix]
```

Like a cube.

---

# Memory Structure

```text
3D Array
    |
    ▼

2D Arrays
    |
    ▼

1D Arrays
    |
    ▼

Integers
```

---

# Traversal

```java
for(int i=0;i<cube.length;i++){

    for(int j=0;j<cube[i].length;j++){

        for(int k=0;k<cube[i][j].length;k++){

            System.out.print(cube[i][j][k]+" ");
        }
    }
}
```

---

# Complexity

For dimensions:

```text
L × R × C
```

Complexity:

```text
O(L × R × C)
```

---

# Common Interview Questions

### Q1. Why arrays are faster?

Because elements are stored in contiguous memory and can be accessed directly using index.

---

### Q2. What is zero-based indexing?

First element starts at index 0.

---

### Q3. Difference between array and ArrayList?

| Array | ArrayList |
|---------|---------|
| Fixed Size | Dynamic Size |
| Faster | Slightly Slower |
| Primitive Allowed | Objects Only |

---

### Q4. What is a jagged array?

A 2D array where each row has different column size.

---

### Q5. What is stored in a 2D array?

An array of references to other arrays.

---

### Q6. Why are Strings immutable?

Security, thread safety, and memory optimization.

---

### Q7. Difference between == and equals() for String?

```java
==
```

Checks reference.

```java
equals()
```

Checks content.

---

# Quick Revision Sheet

```text
ARRAY
-----
Same datatype collection
Contiguous memory
Zero-based indexing

1D ARRAY
--------
int[] arr = new int[5];

Index:
0 1 2 3 4

TRAVERSAL
---------
for loop
for-each loop

2D ARRAY
---------
Array of Arrays

int[][] arr

JAGGED ARRAY
------------
Rows fixed
Columns variable

STRING
------
Non-primitive datatype

String s="Java";

Methods:
length()
charAt()
equals()

STRINGS
-------
Immutable

3D ARRAY
---------
Array of 2D arrays

Complexity:
O(L×R×C)
```

---

# Memory Trick

```text
Array
=====
One Name
Many Values

1D
==
Line

2D
==
Table

3D
==
Cube

String
======
Array of Characters (Conceptually)

Array Length
============
.length

String Length
=============
.length()

String Comparison
=================
equals()

Indexing
========
Starts from 0
```

---
