package ua.com.mathutils.calculator;

import org.junit.Test;
import ua.com.mathutils.calculator.impl.MathematicsExpressionCalculatorImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FunctionTest {
    private final MathematicsExpressionCalculator calculator = new MathematicsExpressionCalculatorImpl();
    private final double delta = 0.0001;

    @Test
    public void testMinimumFunction() throws IncorrectExpressionException {
        final String input = "min(-10;5;-5;-3.42)";
        final Double expected = -10.0;
        assertEquals("Minimum function calculation failed.", expected, calculator.evaluate(input), delta);
    }

    @Test
    public void testDeeplyNestedFunctions() throws IncorrectExpressionException {
        final String input = "min(42.2;min(37.9;36.6;38.8))";
        final Double expected = 36.6;
        assertEquals("Nested functions calculation failed.", expected, calculator.evaluate(input), delta);
    }

    @Test
    public void testIllegalFunctionInput() {
        final String input = "min34;42";
        final String expected = "Opening bracket expected.Index: 4";
        try {
            calculator.evaluate(input);
            fail("IncorrectExpressionException was not thrown.");
        } catch (IncorrectExpressionException e) {
            assertEquals("Such IncorrectExpressionException message is not expected.", expected, e.getMessage());
        }
    }

    @Test
    public void testIllegalNumberOfFunctionArguments() {
        final String input = "min()";
        final String expected = "Invalid number of functions arguments.Minimum number: 1 Actual: 0";
        try {
            calculator.evaluate(input);
            fail("IncorrectExpressionException was not thrown.");
        } catch (IncorrectExpressionException e) {
            assertEquals("Such IncorrectExpressionException message is not expected.", expected, e.getMessage());
        }
    }

    @Test
    public void testMaximumFunction() throws IncorrectExpressionException {
        final String input = "max(-10;5;-5;-3.42)";
        final Double expected = 5.0;
        assertEquals("Maximum function calculation failed.", expected, calculator.evaluate(input), delta);
    }

    @Test
    public void testPowerFunction() throws IncorrectExpressionException {
        final String input = "pow(2;3)";
        final Double expected = 8.0;
        assertEquals("Power function calculation failed.", expected, calculator.evaluate(input), delta);
    }

    @Test
    public void testPiFunction() throws IncorrectExpressionException {
        final String input = "pi()";
        final Double expected = 3.141592653589793;
        assertEquals("Pi function calculation failed.", expected, calculator.evaluate(input), delta);
    }

    @Test
    public void testNestedPowerFunction() throws IncorrectExpressionException {
        final String input = "pow(pow(2;3);4)";
        final Double expected = 4096.0;
        assertEquals("Nested power function calculation failed.", expected, calculator.evaluate(input), delta);
    }
}
