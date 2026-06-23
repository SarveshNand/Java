
# Create flowchart and pseudocode for the following:

---

## 1) Input a year and find whether it is a leap year or not.

### Pseudocode

```
START
INPUT YEAR

IF (YEAR MOD 400 = 0) THEN
    PRINT "LEAP YEAR"
ELSE IF (YEAR MOD 100 = 0) THEN
    PRINT "NOT A LEAP YEAR"
ELSE IF (YEAR MOD 4 = 0) THEN
    PRINT "LEAP YEAR"
ELSE
    PRINT "NOT A LEAP YEAR"
END IF

STOP
```

### Flowchart

```
 ┌───────┐
 │ START │
 └───┬───┘
     │
     ▼
 ┌─────────────┐
 │ Input Year  │
 └─────┬───────┘
       │
       ▼
 ┌─────────────────┐
 │ Year % 400 = 0? │
 └───┬─────────┬───┘
    Yes       No
     │         │
     ▼         ▼
┌─────────┐  ┌─────────────────┐
│ Leap    │  │ Year % 100 = 0? │
│ Year    │  └───┬─────────┬───┘
└────┬────┘     Yes       No
     │           │         │
     │           ▼         ▼
     │      ┌─────────┐ ┌────────────┐
     │      │ Not     │ │ Year % 4=0?│
     │      │ Leap    │ └──┬─────┬───┘
     │      │ Year    │   Yes   No
     │      └────┬────┘    │     │
     │           │         ▼     ▼
     │           │   ┌────────┐ ┌─────────┐
     │           │   │ Leap   │ │ Not     │
     │           │   │ Year   │ │ Leap    │
     │           │   └────┬───┘ │ Year    │
     │           │        │     └────┬────┘
     └───────────┴────────┴──────────┘
                      │
                      ▼
                 ┌────────┐
                 │  STOP  │
                 └────────┘
```

## 2) Take two numbers and print the sum of both.

### Pseudocode

```
START
INPUT NUM1
INPUT NUM2

SUM = NUM1 + NUM2
PRINT SUM

STOP
```

### Flowchart

```
 ┌───────┐
 │ START │
 └───┬───┘
     │
     ▼
 ┌─────────────┐
 │ Input num1  │
 └─────┬───────┘
       │
       ▼
 ┌─────────────┐
 │ Input num2  │
 └─────┬───────┘
       │
       ▼
 ┌─────────────────┐
 │ sum = num1+num2 │
 └─────┬───────────┘
       │
       ▼
 ┌─────────────┐
 │ Print sum   │
 └─────┬───────┘
       │
       ▼
 ┌───────┐
 │ STOP  │
 └───────┘
```

## 3) Take a number as input and print the multiplication table for it.

### Pseudocode

```
START
INPUT NUM

FOR i <- 1 TO 10 DO
    PRINT NUM, " x ", i, " = ", NUM * i
END FOR

STOP
```

### Flowchart

```
 ┌───────┐
 │ START │
 └───┬───┘
     │
     ▼
 ┌─────────────┐
 │ Input num   │
 └─────┬───────┘
       │
       ▼
 ┌─────────────┐
 │ i ← 1       │
 └─────┬───────┘
       │
       ▼
 ┌─────────────┐
 │ i ≤ 10 ?    │
 └───┬─────┬───┘
    Yes    No
     │      │
     ▼      ▼
 ┌─────────────────────┐
 │ Print num×i=num*i   │
 └─────┬───────────────┘
       │
       ▼
 ┌─────────────┐
 │ i ← i + 1   │
 └─────┬───────┘
       │
       └───────────► (Back to i ≤ 10?)
               

            No
             │
             ▼
        ┌────────┐
        │ STOP   │
        └────────┘
```

## 4) Take 2 numbers as inputs and find their HCF and LCM.

### Pseudocode

```
START
INPUT NUM1
INPUT NUM2

a <- NUM1
b <- NUM2

WHILE b != 0 DO
    temp <- b
    b <- a MOD b
    a <- temp
END WHILE

HCF <- a
LCM <- (NUM1 x NUM2) / HCF

PRINT "HCF = ", HCF
PRINT "LCM = ", LCM

STOP
```

### Flowchart

```
 ┌───────┐
 │ START │
 └───┬───┘
     │
     ▼
 ┌─────────────────┐
 │ Input num1,num2 │
 └──────┬──────────┘
        │
        ▼
 ┌─────────────────┐
 │ a<-num1,b<-num2 │
 └──────┬──────────┘
        │
        ▼
 ┌─────────────┐
 │   b != 0 ?  │
 └───┬─────┬───┘
    Yes    No
     │      │
     ▼      ▼
 ┌─────────────┐   ┌─────────┐
 │ temp ← b    │   │ HCF ← a │
 │ b ← a MOD b │   └────┬────┘
 │ a ← temp    │        │
 └─────┬───────┘        ▼
       │          ┌─────────────────┐
       └────────► │ LCM=(num1×num2) │
                  │      / HCF      │
                  └──────┬──────────┘
                         │
                         ▼
                  ┌─────────────────┐
                  │ Print HCF, LCM  │
                  └──────┬──────────┘
                         │
                         ▼
                    ┌────────┐
                    │ STOP   │
                    └────────┘
```

## 5) Keep taking numbers as inputs till the user enters ‘x’, after that print sum of all.

### Pseudocode

```
START
SUM <- 0
INPUT value

WHILE value != 'x' DO
    SUM <- SUM + value
    INPUT value
END WHILE

PRINT "Sum = ", SUM
STOP
```

### Flowchart

```
 ┌───────┐
 │ START │
 └───┬───┘
     │
     ▼
 ┌─────────┐
 │ sum ← 0 │
 └────┬────┘
      │
      ▼
 ┌─────────────────┐
 │ Input value     │
 │ (number or 'x') │
 └────┬────────────┘
      │
      ▼
 ┌─────────────┐
 │ value='x'? │
 └───┬────┬───┘
    No    Yes
     │      │
     ▼      ▼
 ┌─────────────┐
 │ sum←sum+val │
 └────┬────────┘
      │
      ▼
 ┌─────────────────┐
 │ Input next value│
 └────┬────────────┘
      │
      └──────────► (Back to value='x'?)
     
                 Yes
                  │
                  ▼
           ┌─────────────┐
           │ Print sum   │
           └────┬────────┘
                │
                ▼
           ┌────────┐
           │ STOP   │
           └────────┘
```

---
