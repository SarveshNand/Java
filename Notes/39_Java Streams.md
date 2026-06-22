# Java Streams API

---

# 1. What is a Stream?

A **Stream** is a sequence of elements that supports functional-style operations to process data.

> A Stream does **not store data**.
>
> It processes data from a source such as:
>
> * List
> * Set
> * Queue
> * Array
> * File
> * Infinite Generator

---

# Traditional Collection vs Stream

## Collection

```text
Stores Data
```

Example:

```java
List<Integer> list = List.of(1,2,3);
```

---

## Stream

```text
Processes Data
```

Example:

```java
list.stream()
    .filter(x -> x > 1)
    .forEach(System.out::println);
```

---

# Real World Analogy

Imagine a water pipeline:

```text
Water Source
     │
     ▼
 Filter
     │
     ▼
 Transform
     │
     ▼
 Output Tank
```

Streams work exactly like this.

```text
Source
  ↓
Filter
  ↓
Map
  ↓
Sort
  ↓
Collect
```

---

# Why Streams Were Introduced?

Before Java 8:

```java
List<String> result = new ArrayList<>();

for(Employee e : employees){

    if(e.getSalary() > 50000){
        result.add(e.getName());
    }
}

Collections.sort(result);
```

---

Problems:

```text
More Code

Manual Loops

Less Readable

Hard Maintenance
```

---

After Java 8:

```java
List<String> result =
employees.stream()
         .filter(e -> e.getSalary() > 50000)
         .map(Employee::getName)
         .sorted()
         .toList();
```

---

Benefits:

```text
Less Code

Readable

Declarative

Parallel Processing Ready
```

---

# Imperative vs Declarative

## Imperative

Focus on:

```text
HOW
```

Example:

```java
for(int i=0;i<list.size();i++){
    System.out.println(list.get(i));
}
```

---

## Declarative

Focus on:

```text
WHAT
```

Example:

```java
list.forEach(System.out::println);
```

---

# Stream Architecture

Every Stream consists of:

```text
Source
   ↓
Intermediate Operations
   ↓
Terminal Operation
```

---

# Complete Pipeline Diagram

```text
List
 │
 ▼
stream()
 │
 ▼
filter()
 │
 ▼
map()
 │
 ▼
sorted()
 │
 ▼
collect()
```

---

# Stream Pipeline Components

| Component    | Purpose         |
| ------------ | --------------- |
| Source       | Creates Stream  |
| Intermediate | Transform Data  |
| Terminal     | Produces Result |

---

# 2. Sources of Streams

---

# Collection Stream

```java
List<Integer> list =
        List.of(1,2,3);

Stream<Integer> stream =
        list.stream();
```

---

# Parallel Stream

```java
list.parallelStream();
```

Uses:

```text
Multiple CPU Cores
```

---

# Array Stream

```java
int[] arr = {1,2,3,4};

Arrays.stream(arr);
```

---

# Stream.of()

```java
Stream<Integer> stream =
        Stream.of(1,2,3,4,5);
```

---

# Infinite Streams

---

## Stream.iterate()

```java
Stream.iterate(
    1,
    n -> n + 1
);
```

Flow:

```text
1
↓
2
↓
3
↓
4
↓
...
```

---

## Stream.generate()

```java
Stream.generate(
    () -> Math.random()
);
```

Flow:

```text
Supplier
   ↓
Random Values
   ↓
Infinite Stream
```

---

# Important

Infinite streams must use:

```java
limit()
```

Example:

```java
Stream.iterate(1,n->n+1)
      .limit(5)
      .forEach(System.out::println);
```

Output

```text
1
2
3
4
5
```

---

# 3. Intermediate Operations

Intermediate operations:

```text
Lazy
```

and

```text
Return Stream
```

allowing method chaining.

---

# Intermediate Pipeline

```text
Data
 ↓
filter
 ↓
map
 ↓
sorted
 ↓
distinct
 ↓
Terminal
```

---

# filter()

Filters elements using Predicate.

---

Example

```java
List<Integer> result =
list.stream()
    .filter(x -> x % 2 == 0)
    .toList();
```

---

Input

```text
1 2 3 4 5 6
```

Output

```text
2 4 6
```

---

Flow

```text
1 ❌
2 ✔
3 ❌
4 ✔
5 ❌
6 ✔
```

---

# map()

Transforms data.

---

Example

```java
list.stream()
    .map(x -> x*x)
    .toList();
```

---

Input

```text
1 2 3 4
```

Output

```text
1 4 9 16
```

---

Flow

```text
1 → 1

2 → 4

3 → 9

4 → 16
```

---

# map() Real Example

```java
employees.stream()
         .map(Employee::getName)
         .toList();
```

Extracts:

```text
Employee → Name
```

---

# sorted()

Natural Order

```java
list.stream()
    .sorted()
    .toList();
```

---

Output

```text
1 2 3 4 5
```

---

# Custom Sorting

```java
list.stream()
    .sorted((a,b)->b-a)
    .toList();
```

---

Output

```text
5 4 3 2 1
```

---

# distinct()

Removes duplicates.

```java
list.stream()
    .distinct()
    .toList();
```

---

Input

```text
1 1 2 2 3 3
```

Output

```text
1 2 3
```

---

# limit()

Keeps first N elements.

```java
stream.limit(5);
```

---

Input

```text
1 2 3 4 5 6 7 8
```

Output

```text
1 2 3 4 5
```

---

# skip()

Skips first N elements.

```java
stream.skip(3);
```

---

Input

```text
1 2 3 4 5 6
```

Output

```text
4 5 6
```

---

# 4. Terminal Operations

Terminal operations:

```text
Execute Pipeline
```

and

```text
Kill Stream
```

---

# Terminal Operations Overview

```text
forEach()

count()

findFirst()

toList()

collect()

reduce()
```

---

# forEach()

```java
list.stream()
    .forEach(System.out::println);
```

Output:

```text
Prints Elements
```

---

# count()

```java
long count =
list.stream()
    .count();
```

---

# findFirst()

```java
Optional<Integer> result =
list.stream()
    .findFirst();
```

---

# toList()

```java
List<Integer> result =
list.stream()
    .toList();
```

---

# collect()

Most powerful terminal operation.

```java
Collectors.toList()
```

```java
Collectors.toSet()
```

```java
Collectors.toMap()
```

---

Example

```java
List<String> names =
employees.stream()
         .map(Employee::getName)
         .collect(Collectors.toList());
```

---

# reduce()

Combines all values into one.

---

Example

```java
int sum =
list.stream()
    .reduce(0,
            (a,b)->a+b);
```

---

Flow

```text
0+1=1

1+2=3

3+3=6

6+4=10
```

Output

```text
10
```

---

# 5. Lazy Evaluation

Most Important Interview Topic

---

Example

```java
list.stream()
    .filter(x -> {
        System.out.println(x);
        return x%2==0;
    });
```

Output:

```text
Nothing
```

Why?

Because no terminal operation exists.

---

Now:

```java
list.stream()
    .filter(x -> {
        System.out.println(x);
        return x%2==0;
    })
    .count();
```

Output:

```text
Execution Happens
```

---

# Rule

```text
Intermediate Operations

DO NOTHING

Until

Terminal Operation Appears
```

---

# 6. Vertical Processing

Traditional loops:

```text
Horizontal Processing
```

Streams:

```text
Vertical Processing
```

---

# Example

```java
list.stream()
    .filter(x -> x%2==0)
    .map(x -> x*x)
    .findFirst();
```

Input

```text
1 2 3 4 5
```

---

Processing

```text
1
 ↓
Filter ❌
Stop

2
 ↓
Filter ✔
 ↓
Map → 4
 ↓
findFirst()
 ↓
Return 4
```

Remaining elements:

```text
Never Processed
```

---

# Benefit

```text
Less CPU

Less Memory

Faster Execution
```

---

# 7. Short Circuiting

Operations that stop processing early.

---

Examples

```java
findFirst()
```

```java
findAny()
```

```java
anyMatch()
```

```java
noneMatch()
```

```java
allMatch()
```

---

Example

```java
boolean exists =
list.stream()
    .anyMatch(x -> x == 10);
```

Once 10 is found:

```text
Stream Stops
```

---

# 8. One-Time Use Streams

Stream can only be consumed once.

---

Wrong

```java
Stream<Integer> stream =
list.stream();

stream.count();

stream.forEach(System.out::println);
```

Output

```text
IllegalStateException
```

---

Correct

```java
list.stream().count();

list.stream().forEach(
System.out::println
);
```

---

# Why?

Terminal operation closes stream.

```text
Stream → Consumed → Dead
```

---

# 9. Primitive Streams

Avoid:

```java
Auto Boxing

Unboxing
```

---

# Problem

```java
Stream<Integer>
```

Internally

```text
int

↓

Integer

↓

Operation

↓

Integer

↓

int
```

---

# Primitive Alternatives

```java
IntStream
LongStream
DoubleStream
```

---

# Example

```java
IntStream.range(1,6)
         .forEach(System.out::println);
```

Output

```text
1
2
3
4
5
```

---

# mapToInt()

Object → Primitive

```java
employees.stream()
         .mapToInt(
           Employee::getSalary
         );
```

---

# boxed()

Primitive → Object

```java
IntStream.range(1,5)
         .boxed();
```

---

# Stream Type Hierarchy

```text
Stream<T>

│
├── IntStream

├── LongStream

└── DoubleStream
```

---

# 10. Complete Example

Employee Example

---

```java
List<String> result =
employees.stream()

.filter(
e -> e.getSalary() > 50000
)

.map(
Employee::getName
)

.sorted()

.toList();
```

---

Flow Diagram

```text
Employees

   │

   ▼

Salary > 50000

   │

   ▼

Extract Name

   │

   ▼

Sort

   │

   ▼

Collect

   │

   ▼

List<String>
```

---

# Complexity Insights

| Operation   | Complexity     |
| ----------- | -------------- |
| filter()    | O(n)           |
| map()       | O(n)           |
| distinct()  | O(n)           |
| sorted()    | O(n log n)     |
| count()     | O(n)           |
| findFirst() | O(1) Best Case |
| reduce()    | O(n)           |

---

# Stream Lifecycle

```text
Source

  │

  ▼

Intermediate Operations

  │

  ▼

Terminal Operation

  │

  ▼

Result

  │

  ▼

Stream Dead
```

---

# Interview Questions

## Q1: What is a Stream?

A sequence of elements supporting functional-style operations for processing data.

---

## Q2: Does Stream Store Data?

No.

It only processes data.

---

## Q3: Why are Streams Faster?

Because of:

```text
Lazy Evaluation

Vertical Processing

Short Circuiting

Parallel Processing
```

---

## Q4: Difference Between Collection and Stream?

| Collection    | Stream                         |
| ------------- | ------------------------------ |
| Stores Data   | Processes Data                 |
| Reusable      | One-Time Use                   |
| Eager         | Lazy                           |
| Supports CRUD | Supports Functional Operations |

---

## Q5: Why Are Streams Declarative?

Because they describe:

```text
WHAT TO DO

instead of

HOW TO DO
```

---

# Final Revision Cheat Sheet

```text
STREAM

Process Data

NOT Store Data

PIPELINE

Source
 ↓
Intermediate
 ↓
Terminal

SOURCE

stream()
parallelStream()
Arrays.stream()
Stream.of()

INTERMEDIATE

filter()
map()
sorted()
distinct()
limit()
skip()

TERMINAL

forEach()
count()
findFirst()
collect()
toList()
reduce()

KEY FEATURES

Lazy Evaluation

Vertical Processing

Short Circuiting

One-Time Use

PRIMITIVE STREAMS

IntStream
LongStream
DoubleStream

CONVERSIONS

mapToInt()

boxed()

BENEFITS

Readable

Less Code

Functional Style

Parallel Friendly
```
