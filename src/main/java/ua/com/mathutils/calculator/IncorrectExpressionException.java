package ua.com.mathutils.calculator;

/**
 * Custom exception throws if mathematics expression is not valid.
 */
public class IncorrectExpressionException extends Exception {
    private int position;

    public IncorrectExpressionException(String message) {
        super(message);
    }

    public IncorrectExpressionException(String message, int position) {
        super(message);
        this.position = position;
    }
}
