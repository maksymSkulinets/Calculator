package ua.com.mathutils.calculator;

import org.junit.Test;
import ua.com.mathutils.calculator.impl.MathematicsExpressionCalculatorImpl;

import static org.junit.Assert.assertEquals;

public class BinaryOperatorsTest {

    private final MathematicsExpressionCalculator calculator = new MathematicsExpressionCalculatorImpl();
    private final double delta = 0.0001;

    @Test
    public void testAdditionalOperator() throws IncorrectExpressionException {
        final String input = "-100.27+50.27+20";
        final Double expected = -30.0;
        assertEquals("Addition operator calculation failed.", expected, calculator.evaluate(input), delta);
    }

    @Test
    public void testSubtractionOperator() throws IncorrectExpressionException {
        final MathematicsExpressionCalculator calculator = new MathematicsExpressionCalculatorImpl();
        final String input = "-60.27-30.73-9";
        final Double expected = -100.0;
        assertEquals("Subtraction operator calculation failed.", expected, calculator.evaluate(input), delta);
    }

    @Test
    public void testMultiplicationOperator() throws IncorrectExpressionException {
        final String input = "-2*3*4*5";
        final Double expected = -120.0;
        assertEquals("Multiplication operator calculation failed.", expected, calculator.evaluate(input), delta);
    }

    @Test
    public void testDivisionOperator() throws IncorrectExpressionException {
        final String input = "-55.5/5/2";
        final Double expected = -5.55;
        assertEquals("Division operator calculation failed.", expected, calculator.evaluate(input), delta);
    }

}
