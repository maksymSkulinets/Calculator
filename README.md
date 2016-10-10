# Calculator of mathematics expression (server side part).

## Mathematic expression calculator uses shunting-yard algorithm and implements finite state machine.

### Technologies:
*  Java 8.
*  Gradle.
*  Log4j.
*  JUnit.

### Functionallity:
1. Support positive and negative numbers.
1. Support integer and fractional numbers.
1. Support mathematic operators (+,-,*,/)
1. Support deeply nesting brackets.
1. Support mathematic functions.

### Functions:
    Functions argument separate by ";" - symbol and have diferent quantity of arguments.

### Functions representation:
1. Maximum - max(21;31;123). Maxinum function can have from 1 to maximum long value of arguments.
1. Minimum - min(121;-31;123;343). Minimum function can have from 1 to maximum long value of arguments.
1. Power - Pow(2;4). Power have only 2 arguments.
1. Pi - Pi(). Have not arguments. Return value of pi- number.

### Examples of corect input sequences:
    "44-22+11"
    "min(21;max(11;343;1);123)"
    "-12*((3*pi()-0.55)+47.22-(((0.22/0.1)))"

### If use not valid input you will have custom exception with message - reason.

## ENJOY!!

    
