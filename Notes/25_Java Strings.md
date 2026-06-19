
---

# 1. What is a String?

A **String** is a sequence of characters.

```java
String name = "Rahul";
```

Conceptually:

```
R  a  h  u  l
|  |  |  |  |
v  v  v  v  v
Character Sequence
```

---

## Definition

A String in Java is an object of the `java.lang.String` class.

```java
String s = "Hello";
```

Internally:

```
s
│
▼
String Object
┌─────────┐
│ "Hello" │
└─────────┘
```

---

## Why Java Provides String Class?

Imagine using only character arrays.

```java
char[] arr = {'H','e','l','l','o'};
```

Problems:

- No direct comparison
- No concatenation
- No substring support
- No searching support

Example:

```java
String s = "Hello";

s.length();
s.substring(1);
s.equals("Hello");
```

These features come from the String class.

---

# 2. String is Non-Primitive

Primitive Types:

```java
int
float
char
boolean
```

Non-Primitive Types:

```java
String
Array
Class Objects
```

Because String is a class:

```java
String s = "Java";
```

You can call methods:

```java
s.length();
s.toUpperCase();
s.charAt(0);
```

---

# 3. Ways to Create Strings

There are two ways.

---

## Method 1: String Literal

```java
String s1 = "Java";
```

Uses String Pool.

---

### Memory Diagram

```text
String Pool
┌────────────┐
│  "Java"    │
└────────────┘
      ▲
      │
      s1
```

---

## Method 2: Using new Keyword

```java
String s2 = new String("Java");
```

Creates a new object in Heap.

---

### Memory Diagram

```text
String Pool

┌────────────┐
│ "Java"     │
└────────────┘

Heap

┌────────────┐
│ "Java"     │
└────────────┘
      ▲
      │
      s2
```

---

# 4. String Pool (Most Important Interview Topic)

---

## What is String Pool?

A special memory area inside Heap that stores String literals.

Purpose:

- Avoid duplicate objects
- Save memory
- Improve performance

---

## Example

```java
String s1 = "Java";
String s2 = "Java";
String s3 = "Java";
```

Memory:

```text
String Pool

┌────────────┐
│  "Java"    │
└────────────┘
   ▲  ▲  ▲
   │  │  │
  s1 s2 s3
```

Only ONE object created.

---

## Without String Pool

If pool didn't exist:

```text
Heap

┌──────────┐
│ "Java"   │
└──────────┘

┌──────────┐
│ "Java"   │
└──────────┘

┌──────────┐
│ "Java"   │
└──────────┘
```

Huge memory waste.

---

# 5. == vs equals()

Very common interview question.

---

## == Operator

Compares references.

```java
String s1 = "Java";
String s2 = "Java";

System.out.println(s1 == s2);
```

Output:

```java
true
```

Because both point to same object.

---

### Diagram

```text
String Pool

┌──────────┐
│ "Java"   │
└──────────┘
 ▲      ▲
 │      │
s1     s2
```

---

## equals()

Compares content.

```java
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1.equals(s2));
```

Output:

```java
true
```

Contents are same.

---

### Interview Table

| Operator | Compares |
|-----------|----------|
| == | Address/Reference |
| equals() | Actual Content |

---

# 6. Immutability

## What is Immutable?

Once created, a String object cannot be changed.

---

### Example

```java
String s = "Hello";

s.concat(" World");

System.out.println(s);
```

Output:

```java
Hello
```

Not:

```java
Hello World
```

---

## Why?

Because concat creates a NEW object.

---

### Internal Working

Step 1

```java
String s = "Hello";
```

```text
Pool

┌──────────┐
│ "Hello"  │
└──────────┘
     ▲
     │
     s
```

---

Step 2

```java
s.concat(" World");
```

Creates:

```text
Heap

┌─────────────────┐
│ "Hello World"   │
└─────────────────┘
```

But no reference stores it.

Garbage Collector removes it later.

---

Step 3

```java
s = s.concat(" World");
```

Now:

```text
Pool
┌──────────┐
│ "Hello"  │
└──────────┘

Heap
┌─────────────────┐
│ "Hello World"   │
└─────────────────┘
          ▲
          │
          s
```

Output:

```java
Hello World
```

---

# 7. Why String is Immutable?

Interview Favorite.

---

## Reason 1: Security

Database URL

```java
String url =
"jdbc:mysql://localhost:3306";
```

If mutable:

```java
url = "malicious_server";
```

Security risk.

---

## Reason 2: Thread Safety

Multiple threads can safely share String objects.

```java
String message = "Welcome";
```

No synchronization required.

---

## Reason 3: HashMap Performance

Hash codes can be cached.

```java
HashMap<String,Integer>
```

Very fast lookups.

---

## Reason 4: String Pool

Pool works only because strings cannot change.

Imagine:

```java
String s1 = "Java";
String s2 = "Java";
```

If s1 changed:

```java
s1 = "Python";
```

Pool consistency would break.

---

# 8. Compile-Time vs Run-Time String Creation

Very Important.

---

## Compile-Time Constant

```java
String s1 = "JA" + "VA";
```

Compiler converts to:

```java
String s1 = "JAVA";
```

Stored in Pool.

---

### Flow

```text
Compiler
   │
   ▼
"JA" + "VA"
   │
   ▼
"JAVA"
   │
   ▼
String Pool
```

---

## Run-Time Concatenation

```java
String s1 = "JA";

String s2 = s1 + "VA";
```

Value known only during execution.

Stored in Heap.

---

### Flow

```text
Program Running
      │
      ▼
s1 + "VA"
      │
      ▼
New Object
      │
      ▼
Heap
```

---

# 9. intern() Method

Interview Favorite.

---

Example:

```java
String s1 = new String("Java");

String s2 = s1.intern();

String s3 = "Java";
```

```java
System.out.println(s2 == s3);
```

Output:

```java
true
```

---

### What intern() Does?

Returns reference from String Pool.

```text
Heap
┌──────────┐
│ "Java"   │
└──────────┘
     ▲
     │
    s1

Pool
┌──────────┐
│ "Java"   │
└──────────┘
 ▲      ▲
 │      │
s2     s3
```

---

# 10. Internal Architecture of String (Java 9+)

Before Java 9:

```java
char[] value;
```

Each char:

```text
2 bytes
```

---

## Java 9+

Uses:

```java
byte[] value;
byte coder;
int hash;
```

---

### Structure

```text
String Object

┌─────────────────────┐
│ byte[] value        │
├─────────────────────┤
│ byte coder          │
├─────────────────────┤
│ int hash            │
└─────────────────────┘
```

---

# 11. Compact Strings (Java 9 Feature)

---

## Old System

```java
"HELLO"
```

5 characters

```
5 × 2 bytes = 10 bytes
```

---

## New System

```java
"HELLO"
```

Uses Latin-1

```
5 × 1 byte = 5 bytes
```

Memory saved:

```text
50%
```

---

# 12. coder Field

Determines encoding.

---

## coder = 0

Latin-1

```java
HELLO
JAVA
ABC123
```

Uses:

```text
1 byte per character
```

---

## coder = 1

UTF-16

Examples:

```java
हेलो
नमस्ते
你好
```

Uses:

```text
2 bytes per character
```

---

### Flowchart

```text
Character Stored
       │
       ▼
Can fit in Latin-1?
       │
   ┌───┴───┐
   │       │
 Yes      No
   │       │
   ▼       ▼
coder=0  coder=1
Latin1   UTF16
```

---

# 13. Hash Code Caching

Every String has:

```java
int hash;
```

---

## First Call

```java
s.hashCode();
```

Java calculates hash.

Stores it.

```text
hash = 123456
```

---

## Second Call

```java
s.hashCode();
```

Uses cached value.

No recalculation.

---

### Flow

```text
hashCode()
     │
     ▼
Already Cached?
     │
 ┌───┴───┐
 │       │
No      Yes
 │       │
 ▼       ▼
Calculate Return
Store
```

---

# 14. Memory Comparison

---

## Literals

```java
String s1 = "Java";
String s2 = "Java";
```

Objects Created:

```text
1
```

---

## new Keyword

```java
String s1 = new String("Java");
String s2 = new String("Java");
```

Objects Created:

```text
3 Objects

1 in Pool
2 in Heap
```

---

# 15. Frequently Asked Interview Questions

---

### Q1: Why is String immutable?

Answer:

- Security
- Thread Safety
- HashMap Optimization
- String Pool Support

---

### Q2: Difference between == and equals()?

```java
==        -> Reference Comparison

equals()  -> Content Comparison
```

---

### Q3: Where is String Pool stored?

Modern JVM:

```text
Heap Memory
```

Special area inside heap.

---

### Q4: What does intern() do?

Returns pooled reference.

---

### Q5: Why use String instead of char[]?

String provides:

- length()
- equals()
- substring()
- compareTo()
- contains()

and many optimized operations.

---

### Q6: How many objects are created?

```java
String s = new String("Java");
```

Answer:

```text
2 Objects

1 -> Pool ("Java")
1 -> Heap (new String)
```

(assuming "Java" was not already in pool)

---

# Quick Revision Sheet

```text
String = Immutable Object

Stored as:
java.lang.String

Creation:
1. Literal
2. new String()

Literal -> String Pool
new -> Heap

==       -> Reference
equals() -> Content

String Pool:
- Saves Memory
- Reuses Literals

Immutable Because:
- Security
- Thread Safety
- Hash Caching
- Pool Support

Java 9+:
byte[] value
byte coder
int hash

coder=0 -> Latin1
coder=1 -> UTF16

intern()
→ Returns pooled reference
```

---

# One-Line Interview Summary

"Java String is an immutable object of `java.lang.String`, optimized through String Pooling, Compact Strings (`byte[]`), and cached hash codes, providing memory efficiency, security, and high performance."