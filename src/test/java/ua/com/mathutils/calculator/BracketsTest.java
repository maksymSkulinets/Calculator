package ua.com.mathutils.calculator;

import org.junit.Test;
import ua.com.mathutils.calculator.impl.MathematicsExpressionCalculatorImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BracketsTest {

    private final MathematicsExpressionCalculator calculator = new MathematicsExpressionCalculatorImpl();
    private final double delta = 0.0001;

    @Test
    public void testOnePairOfBrackets() throws IncorrectExpressionException {
        final String input = "1.5+(2+3.5)";
        final Double expected = 7.0;
        assertEquals("Expression with brackets does not work correctly.",
                expected, calculator.evaluate(input), delta);
    }

    @Test
    public void testDeeplyNestingBrackets() throws IncorrectExpressionException {
        final String input = "(1.5)+(2+3.5*(2+(2/2)))";
        final Double expected = 14.0;
        assertEquals("Expression with deeply nested brackets does not work correctly.",
                expected, calculator.evaluate(input), delta);
    }

    @Test
    public void testOpeningBracketsQuantityAboveClosing() {
        final String input = "(2+(4-3)";
        final String expected = "Different quantity of opening and closing brackets.";
        try {
            calculator.evaluate(input);
            fail("IncorrectExpressionException was not thrown.");
        } catch (IncorrectExpressionException e) {
            assertEquals("Such IncorrectExpressionException message is not expected.", expected, e.getMessage());
        }
    }

    @Test
    public void testClosingBracketsQuantityAboveOpening() {
        final String input = "2+(4-3))";
        final String expected = "Different quantity of opening and closing brackets.";
        try {
            calculator.evaluate(input);
            fail("IncorrectExpressionException was not thrown.");
        } catch (IncorrectExpressionException e) {
            assertEquals("Such IncorrectExpressionException message is not expected.", expected, e.getMessage());
        }
    }
}
