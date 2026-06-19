# Java Strings, StringBuilder & StringBuffer

---

# 1. Introduction to Strings

A **String** in Java is a sequence of characters.

```java
String name = "Aditya";
```

Internally:

```text
String
   |
   +--> 'A' 'd' 'i' 't' 'y' 'a'
```

### Important Property

✅ String objects are **Immutable**

Once created, their content cannot be changed.

```java
String s = "Hello";
s = s + " World";
```

Many beginners think the original string changes.

Actual process:

```text
Before:

s
 |
 v
"Hello"

After:

s
 |
 v
"Hello World"

Old Object:
"Hello"  --> Eligible for Garbage Collection
```

A completely new String object is created.

---

# 2. String Memory Architecture

## String Literal

```java
String s1 = "Java";
String s2 = "Java";
```

Memory:

```text
String Pool

+--------+
| "Java" |
+--------+
    ^
    |
s1  |
    |
s2--+
```

Only one object exists.

### Why?

Java stores literals in the **String Constant Pool (SCP)** to save memory.

---

## Using new Keyword

```java
String s1 = new String("Java");
String s2 = new String("Java");
```

Memory:

```text
Heap

s1 ---> "Java"

s2 ---> "Java"

String Pool
    |
    ---> "Java"
```

Now three objects exist:

* One in String Pool
* Two in Heap

### Interview Question

```java
String s1 = "Java";
String s2 = "Java";

System.out.println(s1 == s2);
```

Output:

```java
true
```

Because both references point to the same pooled object.

---

```java
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);
```

Output:

```java
false
```

Different Heap objects.

---

```java
System.out.println(s1.equals(s2));
```

Output:

```java
true
```

Because `equals()` compares values.

---

# 3. String Constructors

---

## A. Empty String Constructor

```java
String s = new String();
```

Result:

```text
""
```

Length:

```java
0
```

Memory:

```text
Heap
 |
 v
""
```

---

## B. From String Literal

```java
String s = new String("Hello");
```

Flow:

```text
Step 1:
"Hello" created in String Pool

Step 2:
new String()
creates another object in Heap

Pool --> "Hello"

Heap --> "Hello"
```

---

## C. From Character Array

```java
char[] arr = {'A','d','i','t','y','a'};

String s = new String(arr);
```

Output:

```java
Aditya
```

Diagram:

```text
arr

+---+---+---+---+---+---+
| A | d | i | t | y | a |
+---+---+---+---+---+---+

         |
         V

      "Aditya"
```

---

## D. From Character Sub-array

Syntax:

```java
new String(charArray, offset, count)
```

Parameters:

| Parameter | Meaning              |
| --------- | -------------------- |
| offset    | Starting index       |
| count     | Number of characters |

Example:

```java
char[] arr = {'A','d','i','t','y','a'};

String s = new String(arr,0,4);
```

Visualization:

```text
Index:

0 1 2 3 4 5
A d i t y a
^-------^

Count = 4

A d i t
```

Output:

```java
Adit
```

---

## E. From Byte Array

```java
byte[] b = {97,98,99};

String s = new String(b);
```

ASCII Conversion:

```text
97 -> a
98 -> b
99 -> c
```

Output:

```java
abc
```

---

## F. From StringBuilder

```java
StringBuilder sb = new StringBuilder("Java");

String s = new String(sb);
```

Output:

```java
Java
```

---

## G. From StringBuffer

```java
StringBuffer sb = new StringBuffer("Java");

String s = new String(sb);
```

Output:

```java
Java
```

---

# 4. Essential String Methods

---

# A. Length and Emptiness

## length()

```java
String s = "Aditya";

System.out.println(s.length());
```

Output:

```java
6
```

### Interview Tip

Arrays:

```java
arr.length
```

Strings:

```java
str.length()
```

---

## isEmpty()

Checks:

```text
length == 0 ?
```

Example:

```java
String s = "";

System.out.println(s.isEmpty());
```

Output:

```java
true
```

---

## isBlank() (Java 11+)

Checks:

```text
Empty OR only whitespace
```

Example:

```java
String s = "   ";

System.out.println(s.isBlank());
```

Output:

```java
true
```

Comparison:

| String | isEmpty() | isBlank() |
| ------ | --------- | --------- |
| ""     | true      | true      |
| " "    | false     | true      |
| "Java" | false     | false     |

---

# B. Comparison Methods

---

## equals()

```java
String s1 = "Java";
String s2 = "Java";

System.out.println(s1.equals(s2));
```

Output:

```java
true
```

Value comparison.

---

## equalsIgnoreCase()

```java
"JAVA".equalsIgnoreCase("java")
```

Output:

```java
true
```

---

## compareTo()

Lexicographical comparison.

```java
"Apple".compareTo("Banana")
```

Comparison:

```text
A vs B

A < B
```

Output:

```java
Negative Number
```

---

### Flowchart

```text
compareTo()

          Start
             |
             V
 Compare Character by Character
             |
             |
     Equal? ---- No
       |          |
      Yes         V
       |    Return Difference
       V
 Compare Next Character
       |
       V
All Equal?
       |
      Yes
       |
       V
Return 0
```

---

# C. Searching Methods

---

## contains()

```java
String s = "Java Programming";

System.out.println(
    s.contains("Program")
);
```

Output:

```java
true
```

---

## indexOf()

```java
String s = "Java";
```

```text
J a v a
0 1 2 3
```

```java
s.indexOf('a');
```

Output:

```java
1
```

---

## lastIndexOf()

```java
s.lastIndexOf('a');
```

Output:

```java
3
```

---

# D. Extraction Methods

---

## substring()

Syntax:

```java
substring(start,end)
```

Rule:

```text
Start = Inclusive
End   = Exclusive
```

Example:

```java
String s = "Programming";

System.out.println(
    s.substring(0,7)
);
```

Visualization:

```text
P r o g r a m m i n g
0 1 2 3 4 5 6 7

Take:
0 to 6

Result:
Program
```

Output:

```java
Program
```

---

# E. Whitespace Methods

---

## trim()

Removes leading and trailing spaces.

```java
String s = "   Java   ";

System.out.println(s.trim());
```

Output:

```java
Java
```

---

## strip()

Modern Unicode-friendly version.

```java
String s = "   Java   ";

System.out.println(s.strip());
```

Output:

```java
Java
```

### Interview Answer

Prefer:

```java
strip()
```

Because it handles Unicode whitespace correctly.

---

# F. Replace Methods

```java
String s = "Java Java";

System.out.println(
    s.replace("Java","Python")
);
```

Output:

```java
Python Python
```

---

# G. split()

```java
String s = "Java-Python-C++";

String[] arr = s.split("-");
```

Result:

```text
Java
Python
C++
```

Flow:

```text
Java-Python-C++

      split("-")

          |
          V

+------+--------+------+
| Java | Python | C++  |
+------+--------+------+
```

---

# H. join()

```java
String result =
String.join("-",
            "Java",
            "Python",
            "C++");
```

Output:

```java
Java-Python-C++
```

---

# I. String.format()

Without format:

```java
String msg =
"Name: " + name +
", Age: " + age;
```

With format:

```java
String msg =
String.format(
"Name: %s, Age: %d",
name,
age
);
```

Output:

```java
Name: Aditya, Age: 22
```

---

# 5. Why StringBuilder?

Problem with String:

```java
String s = "Java";

s += " Programming";
s += " Language";
```

Every operation creates a new object.

```text
Java
  |
  V

Java Programming
  |
  V

Java Programming Language
```

Many temporary objects.

Memory Waste ❌

Performance Loss ❌

---

# 6. StringBuilder Architecture

```java
StringBuilder sb =
new StringBuilder();
```

Internal Structure:

```text
Capacity = 16

+---+---+---+---+---+---+
|   |   |   |   |   |   |
+---+---+---+---+---+---+
```

Empty buffer allocated.

---

## Default Capacity

```java
StringBuilder sb =
new StringBuilder();
```

Capacity:

```java
16
```

---

## Capacity with Initial String

```java
StringBuilder sb =
new StringBuilder("Java");
```

Calculation:

```text
16 + length("Java")

16 + 4

= 20
```

---

# Capacity Growth Formula

When full:

```text
New Capacity

= (Old Capacity × 2) + 2
```

Example:

```text
16

(16×2)+2

34
```

Next:

```text
34

(34×2)+2

70
```

Flow:

```text
16
 |
 V
34
 |
 V
70
 |
 V
142
```

---

# 7. StringBuilder Methods

---

## append()

```java
StringBuilder sb =
new StringBuilder("Java");

sb.append(" Programming");
```

Before:

```text
Java
```

After:

```text
Java Programming
```

---

## insert()

```java
sb.insert(4," Language");
```

Result:

```text
Java Language Programming
```

Visualization:

```text
JavaProgramming
    ^
 Insert Here
```

---

## delete()

```java
sb.delete(4,12);
```

Before:

```text
Java Language Programming
```

After:

```text
Java Programming
```

---

## reverse()

```java
sb.reverse();
```

```text
Java
```

↓

```text
avaJ
```

---

## setCharAt()

```java
StringBuilder sb =
new StringBuilder("Java");

sb.setCharAt(0,'K');
```

Result:

```java
Kava
```

---

## trimToSize()

Before:

```text
Length   = 10
Capacity = 34
```

After:

```text
Length   = 10
Capacity = 10
```

Unused memory removed.

---

# 8. StringBuffer

StringBuffer works exactly like StringBuilder.

Difference:

```text
StringBuilder
      |
      | Not Synchronized
      |
      V
 Faster
```

```text
StringBuffer
      |
      | Synchronized
      |
      V
 Thread Safe
```

---

# Thread Safety Example

Suppose two threads modify:

```java
StringBuffer sb =
new StringBuffer("Java");
```

Thread-1:

```java
append("A")
```

Thread-2:

```java
append("B")
```

Synchronization ensures:

```text
JavaAB
```

or

```text
JavaBA
```

No corruption occurs.

---

# 9. equals() Interview Trap

## String

```java
String s1 = "Java";
String s2 = "Java";

System.out.println(
s1.equals(s2)
);
```

Output:

```java
true
```

Because String overrides equals().

---

## StringBuilder

```java
StringBuilder sb1 =
new StringBuilder("Java");

StringBuilder sb2 =
new StringBuilder("Java");

System.out.println(
sb1.equals(sb2)
);
```

Output:

```java
false
```

Reason:

```text
Object.equals()

Reference Comparison
```

Memory:

```text
sb1 ----> Java

sb2 ----> Java
```

Different addresses.

---

### Correct Way

```java
sb1.toString()
   .equals(
sb2.toString()
   );
```

Output:

```java
true
```

---

# 10. Interview Quick Revision

## String

```text
✓ Immutable
✓ Stored in SCP
✓ Thread Safe
✓ Value comparison using equals()
✓ Slow for modifications
```

---

## StringBuilder

```text
✓ Mutable
✓ Fastest
✓ Not Thread Safe
✓ append()
✓ insert()
✓ delete()
✓ reverse()
✓ setCharAt()
✓ trimToSize()
✓ equals() compares references
```

---

## StringBuffer

```text
✓ Mutable
✓ Thread Safe
✓ Synchronized
✓ Slower than StringBuilder
✓ Used in multi-threaded environment
```

---

# Final Comparison Table

| Feature         | String           | StringBuilder          | StringBuffer                 |
| --------------- | ---------------- | ---------------------- | ---------------------------- |
| Mutability      | Immutable        | Mutable                | Mutable                      |
| Memory Usage    | More             | Less                   | Less                         |
| Thread Safety   | Safe             | No                     | Yes                          |
| Synchronization | Not Needed       | No                     | Yes                          |
| Performance     | Slow             | Fastest                | Slower                       |
| Storage         | SCP + Heap       | Heap                   | Heap                         |
| equals()        | Value Comparison | Reference Comparison   | Reference Comparison         |
| Best Use Case   | Fixed Text       | Frequent Modifications | Multi-threaded Modifications |

---

# One-Line Interview Answers

### Why is String immutable?

```text
Security, thread safety, caching, and String Pool optimization.
```

### Difference between == and equals()?

```text
== compares references.
equals() compares values.
```

### Why StringBuilder is faster?

```text
Because it modifies the same object instead of creating new objects.
```

### Why StringBuffer is slower?

```text
Because all major methods are synchronized.
```

### Capacity formula of StringBuilder?

```text
New Capacity = (Old Capacity × 2) + 2
```

### Default StringBuilder capacity?

```text
16 characters
```

### Can StringBuilder be stored in String Pool?

```text
No.
Only String literals are stored in the String Constant Pool.
```
