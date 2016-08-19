package ua.com.mathutils.calculator;

import org.junit.Test;
import ua.com.mathutils.calculator.impl.MathematicsExpressionCalculatorImpl;

import static org.junit.Assert.assertEquals;

public class SingleInputTests {

    @Test
    public void testNumberInput() throws IncorrectExpressionException {
        final MathematicsExpressionCalculator calculator = new MathematicsExpressionCalculatorImpl();
        final String input = "-123.45";
        final Double expected = -123.45;
        final Double actual = calculator.evaluate(input);
        assertEquals("Expected and actual results are not equals", expected, actual);
    }
}
