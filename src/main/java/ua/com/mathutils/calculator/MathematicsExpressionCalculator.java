package ua.com.mathutils.calculator;

/**
 * Public API of mathematics expression calculator.
 */
public interface MathematicsExpressionCalculator {

    /**
     * Evaluates given string like math expression.
     *
     * @param expression mathematics expression
     * @return evaluated result
     * @throws IncorrectExpressionException throws if expression is not valid
     */
    double evaluate(String expression) throws IncorrectExpressionException;
}