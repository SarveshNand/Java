# Java Streams – Advanced Methods & Collectors

---

# 1. Stream Pipeline (Core Mental Model)

A Java Stream always works in **3 stages**:

```text
SOURCE → INTERMEDIATE OPERATIONS → TERMINAL OPERATION
```

---

## Flow Diagram

```text
Collection / Array
        ↓
     Stream()
        ↓
  filter / map / sorted
        ↓
   intermediate chain
        ↓
  terminal operation
        ↓
     RESULT
```

---

## Key Rule

```text
Intermediate operations are LAZY
Terminal operation triggers execution
```

---

# 2. Intermediate Operations

Intermediate operations:

```text
Transform OR Filter data
Return Stream
Are Lazy
```

---

# 2.1 filter()

## Purpose

Removes unwanted elements using a condition.

```java
stream.filter(x -> condition)
```

---

## Example

```java
List<Integer> list = List.of(1, 2, 3, 4, 5);

list.stream()
    .filter(x -> x % 2 == 0)
    .forEach(System.out::println);
```

---

## Flow

```text
1 ❌
2 ✔
3 ❌
4 ✔
5 ❌
```

---

# 2.2 map()

## Purpose

Transforms each element.

```text
T → R
```

---

## Example

```java
list.stream()
    .map(x -> x * 2)
    .toList();
```

---

## Flow

```text
2 → 4
3 → 6
4 → 8
```

---

# 2.3 flatMap()

## Purpose

Flattens nested structures.

---

## Problem Structure

```text
List<List<Integer>>
```

---

## Conversion

```text
[[1,2],[3,4]]
        ↓
   [1,2,3,4]
```

---

## Example

```java
listOfLists.stream()
    .flatMap(List::stream)
    .toList();
```

---

# 2.4 sorted()

## Purpose

Sort elements.

---

## Natural Sorting

```java
stream.sorted()
```

---

## Custom Sorting

```java
stream.sorted((a,b) -> b - a)
```

---

# 2.5 distinct()

## Purpose

Removes duplicates.

---

## Internal Idea

```text
Uses hashing + equals()
```

---

## Example

```java
1 1 2 2 3
↓
1 2 3
```

---

# 2.6 limit() & skip()

---

## limit(n)

```text
Keeps first n elements
```

---

## skip(n)

```text
Skips first n elements
```

---

## Example

```java
stream.skip(2).limit(3);
```

---

## Flow

```text
1 2 3 4 5 6
   ↓ skip(2)
3 4 5 6
   ↓ limit(3)
3 4 5
```

---

# 2.7 peek()

## Purpose

Debugging tool (non-terminal side effect)

---

## Example

```java
stream.peek(System.out::println)
      .map(x -> x * 2)
      .toList();
```

---

## Warning

```text
Do NOT use for business logic
```

---

# 3. Terminal Operations

Terminal operations:

```text
Execute pipeline
Consume stream
Close stream
```

---

# 3.1 forEach()

```java
stream.forEach(System.out::println);
```

---

# 3.2 toList()

```java
stream.toList();
```

* Java 16+
* Immutable list

---

# 3.3 count()

```java
long n = stream.count();
```

---

# 3.4 findFirst() / findAny()

## Behavior

```text
Returns Optional
Short-circuit operation
```

---

## Example

```java
stream.findFirst();
```

---

# 3.5 reduce()

## Purpose

Combine all elements into one result.

---

## Example (Sum)

```java
int sum =
stream.reduce(0, (a,b) -> a + b);
```

---

## Flow

```text
0 + 1 = 1
1 + 2 = 3
3 + 3 = 6
6 + 4 = 10
```

---

# 3.6 Match Operations

| Method    | Meaning      |
| --------- | ------------ |
| anyMatch  | at least one |
| allMatch  | all satisfy  |
| noneMatch | none satisfy |

---

## Example

```java
stream.anyMatch(x -> x > 10);
```

---

# 4. Collectors Framework (VERY IMPORTANT)

Used with:

```java
collect()
```

---

# 4.1 toList() vs Collectors.toList()

| Method              | Type      |
| ------------------- | --------- |
| toList()            | Immutable |
| Collectors.toList() | Mutable   |

---

# 4.2 toSet()

```java
Collectors.toSet()
```

Removes duplicates automatically.

---

# 4.3 toMap()

```java
Collectors.toMap(key, value)
```

---

## Example

```java
Collectors.toMap(
Employee::getId,
Employee::getName
);
```

---

# 4.4 groupingBy()

## Purpose

Group elements by property.

---

## Example

```java
Map<Integer, List<String>> map =
list.stream()
    .collect(Collectors.groupingBy(String::length));
```

---

## Output

```text
2 → [Aa]
3 → [BBb, EeE]
4 → [CcCC]
```

---

# 4.5 partitioningBy()

## Purpose

Splits into 2 groups only:

```text
true / false
```

---

## Example

```java
Collectors.partitioningBy(x -> x % 2 == 0);
```

---

## Output

```text
true  → even numbers
false → odd numbers
```

---

# 4.6 joining()

## Purpose

Converts stream to string.

---

## Example

```java
Collectors.joining(", ");
```

---

## Output

```text
A, B, C
```

---

# 5. Stateless vs Stateful Operations

---

## Stateless

```text
Each element processed independently
```

Examples:

* map()
* filter()

---

## Stateful

```text
Needs full dataset before processing
```

Examples:

* sorted()
* distinct()

---

## Diagram

```text
Stateless: 1 → process → output
Stateful:  wait for all → then process
```

---

# 6. Short-Circuiting Operations

## Definition

Stops processing early.

---

## Examples

```java
findFirst()
anyMatch()
limit()
```

---

## Flow

```text
1 ❌
2 ✔ → STOP
3 ❌ (not processed)
```

---

# 7. Optional Handling

## Why Optional?

Avoid NullPointerException

---

## Example

```java
Optional<Integer> result =
stream.findFirst();
```

---

## Safe Usage

```java
result.ifPresent(System.out::println);
```

---

# 8. Parallel Streams

## Purpose

Multi-threaded processing.

---

## Example

```java
stream.parallel()
      .forEach(System.out::println);
```

---

## Problem

```text
Order is NOT guaranteed
```

---

## Solution

```java
forEachOrdered()
```

---

# 9. Performance Insights

| Operation | Complexity     |
| --------- | -------------- |
| filter    | O(n)           |
| map       | O(n)           |
| distinct  | O(n)           |
| sorted    | O(n log n)     |
| findFirst | O(1) best case |
| reduce    | O(n)           |

---

# 10. Stream Mental Model

## Execution Flow

```text
SOURCE
  ↓
INTERMEDIATE (Lazy)
  ↓
TERMINAL (Triggers Execution)
  ↓
RESULT
```

---

## Vertical Processing

```text
Element 1 → full pipeline → output
Element 2 → full pipeline → output
```

---

# 11. Interview Cheat Sheet

```text
STREAM

- No storage
- Pipeline processing
- Lazy evaluation
- One-time use

INTERMEDIATE

filter()
map()
flatMap()
sorted()
distinct()
limit()
skip()

TERMINAL

forEach()
collect()
toList()
reduce()
count()
findFirst()

COLLECTORS

groupingBy()
partitioningBy()
toMap()
joining()

KEY CONCEPTS

Stateless vs Stateful
Short-Circuiting
Optional
Parallel Streams
```

---

# FINAL SUMMARY

Streams =

```text
Functional + Declarative + Pipeline-based + Lazy + Efficient
```
