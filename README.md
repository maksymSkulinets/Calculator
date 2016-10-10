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
1. Support deeply nested brackets.
1. Support mathematic functions(Max,Min,Pow,PI).

### Functions:
   ';' symbol is used as a delimiter for function arguments.

### Functions representation:
1. Maximum - max(21;31;123). Maxinum function can have from 1 to 19 quantity of arguments.
1. Minimum - min(121;-31;123;343). Minimum function can have from 1 to 19 quantity of arguments.
1. Power - pow(2;4). Power have only 2 arguments.
1. PI - pi(). Have not arguments. Return value of pifagor number.

### Examples of corect input sequences:
    "44-22+11"
    "min(21;max(11;343;1);123)"
    "-12*((3*pi()-0.55)+47.22-(((0.22/0.1)))"

### If use not valid input you will have custom exception with message - reason.
### Examples of exception messages:
    Input: "43.2+67@34" Message: "Illegal input symbol: @.Index= 7"
    Input: "min()"      Message: "Invalid number of functions arguments.Minimum number: 1 Actual: 0"
    Input: "(2+(4-3)"   Message: "Different quantity of opening and closing brackets."
    
## ENJOY IT!!

    
