
---

# 1. Why Enums Were Introduced?

Before Java 5, developers used `int` constants or `String` constants to represent fixed values.

## Example Using int Constants

```java
class PaymentStatus {
    public static final int SUCCESS = 1;
    public static final int FAILED = 2;
    public static final int PENDING = 3;
}
```

Usage:

```java
int status = 100; // Valid Compilation ❌
```

Compiler allows this because `100` is a valid integer.

---

## Problems with int Constants

### 1. No Type Safety

```java
int status = 100; // No compiler error
```

Expected:

```java
SUCCESS
FAILED
PENDING
```

But any integer can be assigned.

---

### 2. Poor Readability

```java
if(status == 2)
```

Question:

What is 2?

- Failed?
- Pending?
- Success?

Developer has to search the constant definition.

---

### 3. Logical Errors

```java
class UserRole {
    public static final int ADMIN = 1;
}

class PaymentStatus {
    public static final int SUCCESS = 1;
}
```

```java
if(UserRole.ADMIN == PaymentStatus.SUCCESS)
```

Output:

```java
true
```

Although logically they are completely unrelated.

---

### 4. String Constant Problems

```java
String status = "Success";
```

Later:

```java
if(status.equals("SUCCESS"))
```

Output:

```java
false
```

Case mismatch.

Other issues:

- Typo prone
- Runtime errors
- Slower comparison

---

# Solution → ENUMS

Enums provide:

✅ Type Safety

✅ Readability

✅ Grouping

✅ Compile-time checking

---

# 2. What is an Enum?

Enum = Enumeration

A special Java type representing a fixed set of constants.

---

## Basic Syntax

```java
enum PaymentStatus {
    SUCCESS,
    FAILED,
    PENDING
}
```

Usage:

```java
PaymentStatus status = PaymentStatus.SUCCESS;
```

Valid:

```java
status = PaymentStatus.FAILED;
```

Invalid:

```java
status = 100;
```

Compiler Error:

```java
Type mismatch
```

---

# Enum Flow Diagram

```text
          PaymentStatus
                 |
      -----------------------
      |          |          |
   SUCCESS     FAILED    PENDING
```

Only these values can exist.

---

# 3. Internal Working of Enum

Many beginners think enum is just a collection of constants.

Actually:

## Enum is a Special Class

When compiler sees:

```java
enum Direction {
    NORTH,
    SOUTH
}
```

It roughly converts it into:

```java
final class Direction extends Enum<Direction> {

    public static final Direction NORTH =
        new Direction("NORTH",0);

    public static final Direction SOUTH =
        new Direction("SOUTH",1);

    private Direction(String name,int ordinal){
        super(name,ordinal);
    }
}
```

---

# Internal Architecture Diagram

```text
                 java.lang.Enum
                        ▲
                        |
                        |
                  Direction
                        |
          -------------------------
          |                       |
       NORTH                   SOUTH
      Object                  Object
```

Every constant is actually an object.

---

# Important Interview Point

Every Enum automatically extends:

```java
java.lang.Enum
```

Therefore:

```java
enum Direction {}
```

Actually becomes:

```java
class Direction extends Enum<Direction>
```

---

# Can Enum Extend Another Class?

❌ No

```java
enum Direction extends Vehicle
```

Compilation Error

Reason:

Java doesn't support multiple inheritance.

Enum already extends:

```java
java.lang.Enum
```

---

# Can Enum Implement Interface?

✅ Yes

```java
interface Moveable {
    void move();
}

enum Direction implements Moveable {
    NORTH,
    SOUTH;

    public void move() {
        System.out.println("Moving");
    }
}
```

---

# 4. Memory Representation

Example:

```java
Direction d1 = Direction.NORTH;
Direction d2 = Direction.NORTH;
```

Memory:

```text
Stack Memory

d1 ----------\
              \
               \
                ▼

Heap Memory

+------------------+
| NORTH Object     |
+------------------+

                ▲
               /
              /
d2 ----------/
```

Both references point to same object.

---

# Why == Works for Enum?

Since only one object exists for each constant.

```java
Direction d1 = Direction.NORTH;
Direction d2 = Direction.NORTH;

System.out.println(d1 == d2);
```

Output:

```java
true
```

Because:

```text
Same Memory Address
```

---

# Enum Singleton Nature

Each enum constant is created exactly once.

```java
NORTH
SOUTH
EAST
WEST
```

Only one object per constant.

Hence:

```text
Enum Constants = Singleton Objects
```

---

# 5. Enum Constructor

Example:

```java
enum Direction {
    NORTH,
    SOUTH
}
```

Compiler internally generates:

```java
private Direction() {}
```

---

## Why Private?

To stop object creation.

If constructor were public:

```java
new Direction();
```

would be possible.

Java doesn't allow this.

---

# Interview Question

## Can We Create Enum Object Using new?

```java
Direction d = new Direction();
```

❌ No

Compilation Error

Reason:

Constructor is private.

---

# 6. Enum with Fields

Real-world example:

Directions have degrees.

| Direction | Degree |
|------------|---------|
| NORTH | 0 |
| EAST | 90 |
| SOUTH | 180 |
| WEST | 270 |

---

## Code

```java
enum Direction {

    NORTH(0),
    EAST(90),
    SOUTH(180),
    WEST(270);

    private final int degree;

    Direction(int degree){
        this.degree = degree;
    }

    public int getDegree(){
        return degree;
    }
}
```

Usage:

```java
System.out.println(Direction.EAST.getDegree());
```

Output:

```java
90
```

---

# Object Creation Flow

```text
NORTH(0)
   |
   ▼
Direction(0)
   |
degree = 0

EAST(90)
   |
   ▼
Direction(90)
   |
degree = 90
```

---

# 7. Enum with Methods

Enums can contain methods.

```java
enum PaymentStatus {

    SUCCESS,
    FAILED,
    PENDING;

    public boolean isCompleted() {
        return this == SUCCESS;
    }
}
```

Usage:

```java
System.out.println(
    PaymentStatus.SUCCESS.isCompleted()
);
```

Output:

```java
true
```

---

# 8. Enum with Abstract Methods

Each constant can behave differently.

---

## Example

```java
enum Direction {

    NORTH {
        void move() {
            System.out.println("Move Up");
        }
    },

    SOUTH {
        void move() {
            System.out.println("Move Down");
        }
    };

    abstract void move();
}
```

Usage:

```java
Direction.NORTH.move();
```

Output:

```java
Move Up
```

---

# Polymorphism Diagram

```text
           move()
              ▲
              |
      ------------------
      |                |
    NORTH           SOUTH
      |                |
 Move Up         Move Down
```

---

# Why Use This?

Avoids large switch statements.

Instead of:

```java
switch(direction)
```

Each constant knows its own behavior.

---

# 9. Built-in Methods

---

## values()

Returns all enum constants.

```java
Direction.values();
```

Output:

```java
[NORTH,EAST,SOUTH,WEST]
```

Example:

```java
for(Direction d : Direction.values()) {
    System.out.println(d);
}
```

Output:

```java
NORTH
EAST
SOUTH
WEST
```

---

# How values() Works Internally

Compiler creates:

```java
private static final Direction[] VALUES
```

Then:

```java
public static Direction[] values() {
    return VALUES.clone();
}
```

---

# Why clone()?

Without clone:

```java
Direction.values()[0] = null;
```

could corrupt original array.

Clone protects data.

---

# valueOf()

Converts String → Enum

```java
Direction d =
    Direction.valueOf("NORTH");
```

Output:

```java
NORTH
```

---

## Case Sensitive

```java
Direction.valueOf("north");
```

Throws:

```java
IllegalArgumentException
```

---

# name()

Returns exact constant name.

```java
Direction.NORTH.name();
```

Output:

```java
NORTH
```

---

# ordinal()

Returns position.

```java
Direction.NORTH.ordinal();
```

Output:

```java
0
```

```java
Direction.SOUTH.ordinal();
```

Output:

```java
2
```

---

# Ordinal Diagram

```text
0 → NORTH
1 → EAST
2 → SOUTH
3 → WEST
```

---

# Interview Warning

Avoid using:

```java
ordinal()
```

for business logic.

Reason:

Changing order changes values.

```java
NORTH,
WEST,
EAST,
SOUTH
```

Now ordinals change.

Can break application.

---

# 10. Enum in Switch Statement

Very common interview question.

```java
switch(status){

    case SUCCESS:
        System.out.println("Paid");
        break;

    case FAILED:
        System.out.println("Retry");
        break;

    case PENDING:
        System.out.println("Wait");
        break;
}
```

Cleaner than integers.

---

# 11. Enum Comparison

Recommended:

```java
status == PaymentStatus.SUCCESS
```

instead of

```java
status.equals(...)
```

Reason:

Enum constants are singleton objects.

---

# Comparison Flow

```text
SUCCESS Object
      ▲
      |
status |
      |
      ▼

PaymentStatus.SUCCESS

Same Object
=> true
```

---

# 12. Real World Use Cases

---

## Order Status

```java
enum OrderStatus {
    PLACED,
    PACKED,
    SHIPPED,
    DELIVERED,
    CANCELLED
}
```

---

## User Roles

```java
enum UserRole {
    ADMIN,
    CUSTOMER,
    MANAGER
}
```

---

## Days of Week

```java
enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
```

---

## Traffic Signal

```java
enum Signal {
    RED,
    YELLOW,
    GREEN
}
```

---

# 13. Enum vs Constants

| Feature | int/String Constants | Enum |
|----------|----------|---------|
| Type Safety | ❌ | ✅ |
| Readability | ❌ | ✅ |
| Compile Time Validation | ❌ | ✅ |
| Grouping | ❌ | ✅ |
| Methods | ❌ | ✅ |
| Fields | ❌ | ✅ |
| Singleton Objects | ❌ | ✅ |

---

# 14. Frequently Asked Interview Questions

### Q1. Is Enum a class?

✅ Yes

Special type of class.

---

### Q2. Can Enum have constructors?

✅ Yes

But only private.

---

### Q3. Can Enum extend another class?

❌ No

Already extends `java.lang.Enum`.

---

### Q4. Can Enum implement interfaces?

✅ Yes

---

### Q5. Why is Enum type-safe?

Because compiler restricts values to predefined constants.

---

### Q6. Why can we use == with Enum?

Because each constant is a singleton object.

---

### Q7. Where are Enum objects stored?

Heap Memory.

---

### Q8. Can Enum have methods?

✅ Yes

---

### Q9. Can Enum be abstract?

❌ No

But can contain abstract methods.

---

### Q10. Who creates Enum objects?

JVM during class loading.

---

# Quick Revision Sheet

```text
ENUM

✔ Introduced in Java 5
✔ Special class
✔ Extends java.lang.Enum
✔ Constants are Objects
✔ Constructor is private
✔ Cannot use new
✔ Type Safe
✔ Can have fields
✔ Can have methods
✔ Can implement interfaces
✔ Cannot extend classes
✔ values()
✔ valueOf()
✔ name()
✔ ordinal()
✔ Singleton nature
✔ Use == for comparison
✔ Common in status/roles/days
```

---

# 30-Second Interview Answer

"An Enum in Java is a special class used to represent a fixed set of constants. Internally every enum constant is a public static final singleton object of the enum type. Enums provide type safety, readability, compile-time validation, and can contain fields, constructors, methods, and even abstract methods. Every enum implicitly extends java.lang.Enum, which is why it cannot extend another class but can implement interfaces."