package ua.com.mathutils.calculator.impl;

import ua.com.mathutils.calculator.IncorrectExpressionException;

/**
 * Input data wrapper.Hold input expression.
 */
public class InputContext {
    private final String expression;
    private int pointer;

    InputContext(String expression) throws IncorrectExpressionException {
        if (expression.trim().isEmpty()) {
            throw new IncorrectExpressionException("Input expression should be not empty.");
        }
        this.expression = expression;
        this.pointer = 0;
    }

    public int getPointerIndex() {
        return pointer;
    }

    public String getRemaining() {
        return expression.substring(pointer);
    }

    public boolean hasMoreToParse() {
        return pointer != expression.length();
    }

    public String getExpression() {
        return expression;
    }

    public void movePointer(int end) {
        pointer += end;
    }
}
