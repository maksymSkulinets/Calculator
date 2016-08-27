package ua.com.mathutils.calculator.impl.context;

/**
 * Hold number of brackets.
 */
public class BracketsCounter {
    private int value;

    BracketsCounter() {
        value = 0;
    }

    /**
     * Count number of brackets.If symbol '(' is parsed value increments.
     * If symbol ')' is parsed value decrements.
     *
     * @param symbol char representation of bracket.
     */
    public void countBracket(char symbol) {
        if (symbol == '(') {
            value++;
        }
        if (symbol == ')') {
            value--;
        }
    }

    public int getValue() {
        return value;
    }
}
