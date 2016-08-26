package ua.com.mathutils.calculator;

import org.junit.Test;
import ua.com.mathutils.calculator.impl.MathematicsExpressionCalculatorImpl;

import static org.junit.Assert.assertEquals;

public class NumberInputTest {

    private final MathematicsExpressionCalculator calculator = new MathematicsExpressionCalculatorImpl();
    private final double delta = 0.0001;

    @Test
    public void testPositiveNumberInput() throws IncorrectExpressionException {
        final String input = "342";
        final Double expected = 342.0;
        assertEquals("Positive number input failed.", expected, calculator.evaluate(input), delta);
    }

    @Test
    public void testFractionalNumberInput() throws IncorrectExpressionException {
        final String input = "42.55";
        final Double expected = 42.55;
        assertEquals("Fractional number input failed.", expected, calculator.evaluate(input), delta);
    }

    @Test
    public void testFractionalNegativeInput() throws IncorrectExpressionException {
        final String input = "-42.55";
        final Double expected = -42.55;
        assertEquals("Fractional negative number input failed.", expected, calculator.evaluate(input), delta);
    }

}
