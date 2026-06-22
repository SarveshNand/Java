# Java Optional Class

---

# 1. Why Optional Was Introduced?

Before Java 8, methods commonly returned `null` when data was unavailable.

Example:

```java
public String getName() {
    return null;
}
```

Usage:

```java
String name = getName();
System.out.println(name.length()); // NullPointerException
```

Result:

```java
Exception in thread "main"
java.lang.NullPointerException
```

---

## Problems with Null

### 1. NullPointerException (NPE)

Most common runtime exception in Java.

```java
String str = null;
str.length();
```

Output:

```java
NullPointerException
```

---

### 2. Ambiguous Meaning

When a method returns null:

```java
User user = getUser();
```

Questions:

- User not found?
- Database error?
- User deleted?
- Query failed?
- Data not loaded?

`null` gives no information.

---

### 3. Null Check Hell

Consider:

```java
if(user != null){
    if(user.getAddress() != null){
        if(user.getAddress().getCity() != null){
            System.out.println(user.getAddress().getCity());
        }
    }
}
```

This becomes ugly and difficult to maintain.

---

# Visualizing Null Check Hell

```text
User
 │
 ├── Address?
 │      │
 │      ├── City?
 │      │      │
 │      │      └── Print City
 │      │
 │      └── null
 │
 └── null
```

Every step requires checking for null.

---

# 2. What is Optional?

Optional is a container object introduced in Java 8.

It may:

- contain a value
- contain no value

Instead of returning:

```java
String
```

Return:

```java
Optional<String>
```

This tells callers:

> "A value may or may not exist. Handle both cases."

---

# Internal Representation

Conceptually:

```java
class Optional<T>{

    private final T value;

}
```

Possible states:

## Present

```text
Optional
   │
   ▼
"John"
```

---

## Empty

```text
Optional
   │
   ▼
 null
```

---

# 3. Creating Optional Objects

There are three major factory methods.

---

# A. Optional.empty()

Creates an empty Optional.

```java
Optional<String> name =
        Optional.empty();
```

Diagram:

```text
Optional
   │
   ▼
 Empty
```

---

# B. Optional.of()

Used when value is guaranteed.

```java
Optional<String> name =
        Optional.of("John");
```

Diagram:

```text
Optional
   │
   ▼
 "John"
```

---

## Important

```java
Optional.of(null);
```

Throws:

```java
NullPointerException
```

Because `of()` does not allow null.

---

# C. Optional.ofNullable()

Safest method.

```java
String value = fetchData();

Optional<String> name =
        Optional.ofNullable(value);
```

If value exists:

```text
Optional
   │
   ▼
 Value
```

If value is null:

```text
Optional
   │
   ▼
 Empty
```

---

# Creation Decision Flowchart

```text
Do you have a value?
         │
         ▼
       Yes
         │
         ▼
Can it be null?
     │       │
     │       │
    No      Yes
     │       │
     ▼       ▼
Optional.of()
     │
     ▼
Optional.ofNullable()

No Value?
     │
     ▼
Optional.empty()
```

---

# 4. Checking Presence

---

## isPresent()

Returns true if value exists.

```java
Optional<String> name =
        Optional.of("John");

if(name.isPresent()){
    System.out.println("Found");
}
```

Output:

```java
Found
```

---

## isEmpty() (Java 11+)

```java
if(name.isEmpty()){
    System.out.println("No value");
}
```

---

# Presence Flow

```text
Optional
   │
   ▼
Value Present?
   │      │
  Yes    No
   │      │
   ▼      ▼
 Process  Empty Logic
```

---

# 5. Retrieving Values

---

# A. get()

```java
Optional<String> name =
        Optional.of("John");

System.out.println(name.get());
```

Output:

```java
John
```

---

## Danger

```java
Optional<String> name =
        Optional.empty();

name.get();
```

Throws:

```java
NoSuchElementException
```

---

## Interview Question

### Why is get() discouraged?

Because:

```java
optional.get();
```

is almost equivalent to:

```java
object.method();
```

Both can fail at runtime.

Modern Java code avoids direct use of `get()`.

---

# 6. ifPresent()

Instead of:

```java
if(name != null){
    System.out.println(name);
}
```

Use:

```java
optional.ifPresent(
    value -> System.out.println(value)
);
```

---

Flow:

```text
Optional
    │
    ▼
Value Exists?
    │
 ┌──┴──┐
 │     │
Yes    No
 │     │
 ▼     ▼
Run    Skip
Lambda
```

---

Example:

```java
Optional.of("John")
        .ifPresent(System.out::println);
```

Output:

```java
John
```

---

# 7. Providing Default Values

---

# A. orElse()

```java
String result =
    optional.orElse("Default");
```

If value exists:

```java
Optional.of("John")
        .orElse("Default");
```

Output:

```java
John
```

If empty:

```java
Optional.empty()
        .orElse("Default");
```

Output:

```java
Default
```

---

# Important Interview Difference

## orElse()

Always executes.

Example:

```java
optional.orElse(expensiveMethod());
```

Even if optional contains value:

```text
expensiveMethod() executes
```

---

Diagram

```text
orElse()

Optional Present?
      │
      ▼
expensiveMethod()
      │
      ▼
Return Actual Value
```

Wasteful for expensive operations.

---

# B. orElseGet()

Lazy evaluation.

```java
optional.orElseGet(
    () -> expensiveMethod()
);
```

Now:

```text
Only execute expensiveMethod()
when Optional is empty
```

---

Flowchart

```text
Optional Present?
      │
 ┌────┴────┐
 │         │
Yes        No
 │         │
 ▼         ▼
Return   Execute
Value    Supplier
```

---

# Interview Question

## Difference Between orElse and orElseGet?

| orElse | orElseGet |
|----------|----------|
| Eager | Lazy |
| Always evaluates | Evaluates only if needed |
| Less efficient for expensive operations | More efficient |

---

# 8. Throwing Exceptions

---

# orElseThrow()

```java
User user =
    optional.orElseThrow();
```

If empty:

```java
NoSuchElementException
```

---

Custom Exception

```java
User user =
    optional.orElseThrow(
        () -> new RuntimeException("User not found")
    );
```

Output:

```java
RuntimeException: User not found
```

---

# 9. Transforming Values

Optional behaves like a mini-stream.

---

# map()

Transforms value.

Example:

```java
Optional<String> name =
        Optional.of("john");
```

Convert to uppercase:

```java
Optional<String> upper =
        name.map(String::toUpperCase);
```

Result:

```java
JOHN
```

---

Flow

```text
Optional("john")
        │
        ▼
 map(toUpperCase)
        │
        ▼
Optional("JOHN")
```

---

# map() Example

```java
Optional<Integer> length =
        Optional.of("John")
                .map(String::length);
```

Result:

```java
Optional[4]
```

---

# filter()

Keeps value only if condition matches.

```java
Optional<String> name =
    Optional.of("John")
            .filter(n -> n.length() > 3);
```

Result:

```java
Optional[John]
```

---

Example 2

```java
Optional.of("Tom")
        .filter(n -> n.length() > 5);
```

Result:

```java
Optional.empty
```

---

Flow

```text
Value
  │
  ▼
Predicate?
 │     │
True  False
 │      │
 ▼      ▼
Keep   Empty
```

---

# flatMap()

Used when function already returns Optional.

Without flatMap:

```java
Optional<Optional<String>>
```

Problem:

```text
Nested Optional
```

---

Example

```java
Optional<User> user;
```

Method:

```java
Optional<String> getEmail();
```

Bad:

```java
user.map(User::getEmail);
```

Result:

```java
Optional<Optional<String>>
```

---

Good:

```java
user.flatMap(User::getEmail);
```

Result:

```java
Optional<String>
```

---

Diagram

```text
map()

Optional<User>
      │
      ▼
Optional<Optional<String>>

flatMap()

Optional<User>
      │
      ▼
Optional<String>
```

---

# 10. Replacing Null Check Hell

Traditional:

```java
if(user != null){
    if(user.getAddress() != null){
        if(user.getAddress().getCity() != null){
            System.out.println(
                user.getAddress().getCity()
            );
        }
    }
}
```

---

Optional Way

```java
user.map(User::getAddress)
    .map(Address::getCity)
    .ifPresent(System.out::println);
```

---

Flow

```text
User
 │
 ▼
Address
 │
 ▼
City
 │
 ▼
Print

Any step null?
      │
      ▼
Chain Stops Safely
```

---

# 11. Optional with Streams

Suppose:

```java
List<User> users;
```

Email may be absent.

Method:

```java
Optional<String> getEmail()
```

---

Traditional Stream

```java
List<String> emails =
    users.stream()
         .map(User::getEmail)
         .filter(Optional::isPresent)
         .map(Optional::get)
         .toList();
```

---

Modern Java 9+

Use Optional.stream()

```java
List<String> emails =
    users.stream()
         .map(User::getEmail)
         .flatMap(Optional::stream)
         .toList();
```

Cleaner and preferred.

---

Flow

```text
Users
  │
  ▼
Optional Emails
  │
  ▼
Flatten
  │
  ▼
Real Emails
  │
  ▼
Collect
```

---

# 12. Real Interview Example

Repository Layer

```java
public Optional<User> findById(Long id){
    return Optional.ofNullable(
        database.get(id)
    );
}
```

Service Layer

```java
User user =
    repository.findById(id)
              .orElseThrow(
                  () -> new UserNotFoundException()
              );
```

This is very common in Spring Boot.

---

# 13. Best Practices

## ✔ Use Optional as Return Type

Good:

```java
Optional<User> findById(Long id)
```

---

## ❌ Don't Use Optional as Parameter

Bad:

```java
void save(Optional<User> user)
```

Use:

```java
void save(User user)
```

---

## ❌ Don't Use Optional Fields

Bad:

```java
class User{
    Optional<String> email;
}
```

Why?

- Extra memory
- Serialization issues
- Harder to use

Use:

```java
class User{
    String email;
}
```

---

## ❌ Don't Return Optional<List<T>>

Bad:

```java
Optional<List<User>>
```

Use:

```java
List<User>
```

Empty list already means no data.

---

# 14. Common Interview Questions

### Q1. Why Optional was introduced?

To reduce NullPointerException and make absence of value explicit.

---

### Q2. Difference between of() and ofNullable()?

```java
Optional.of(null);
```

Throws exception.

```java
Optional.ofNullable(null);
```

Returns empty Optional.

---

### Q3. Difference between map() and flatMap()?

map:

```java
Optional<Optional<T>>
```

possible.

flatMap:

```java
Optional<T>
```

flattens nested Optional.

---

### Q4. Difference between orElse() and orElseGet()?

orElse:

```java
Eager execution
```

orElseGet:

```java
Lazy execution
```

---

### Q5. Why avoid get()?

Because empty Optional causes:

```java
NoSuchElementException
```

---

### Q6. Can Optional contain null?

No.

If null is passed:

```java
Optional.ofNullable(null)
```

becomes:

```java
Optional.empty()
```

---

# Quick Revision Sheet

```text
Optional.empty()
    -> Empty Optional

Optional.of(value)
    -> Value must not be null

Optional.ofNullable(value)
    -> Safe creation

isPresent()
    -> Value exists?

ifPresent()
    -> Execute if value exists

orElse()
    -> Default value (Eager)

orElseGet()
    -> Default Supplier (Lazy)

orElseThrow()
    -> Throw exception

map()
    -> Transform value

filter()
    -> Apply condition

flatMap()
    -> Avoid nested Optional

Optional.stream()
    -> Stream integration
```

---

# Memory Trick

```text
of()
  = "Obviously Present"

ofNullable()
  = "Nullable Allowed"

map()
  = Transform

filter()
  = Keep or Remove

flatMap()
  = Flatten

orElse()
  = Immediate Backup

orElseGet()
  = Backup On Demand

orElseThrow()
  = Fail Fast
```

---

# Final Takeaway

Optional is not a replacement for every null in Java.

Its primary purpose is:

1. Explicitly represent absence of value.
2. Reduce NullPointerExceptions.
3. Eliminate null-check hell.
4. Encourage functional-style programming.
5. Make APIs safer and more expressive.

The most common real-world usage is:

```java
repository.findById(id)
          .map(User::getEmail)
          .filter(email -> email.endsWith("@company.com"))
          .orElseThrow();
```

This is concise, readable, and null-safe.