package ua.com.mathutils.calculator;

import org.junit.Test;
import ua.com.mathutils.calculator.impl.MathematicsExpressionCalculatorImpl;

import static org.junit.Assert.assertEquals;

public class BinaryOperatorsTest {

    @Test
    public void testAdditionalOperator() throws IncorrectExpressionException {
        final MathematicsExpressionCalculator calculator = new MathematicsExpressionCalculatorImpl();
        final String input = "-100.27+50.27+20";
        final Double expected = -30.0;
        final Double actual = calculator.evaluate(input);
        assertEquals("Expected and actual results are not equals", expected, actual,0.0001);
    }

    @Test
    public void testSubtractionOperator() throws IncorrectExpressionException {
        final MathematicsExpressionCalculator calculator = new MathematicsExpressionCalculatorImpl();
        final String input = "-60.27-30.73-9";
        final Double expected = -100.0;
        final Double actual = calculator.evaluate(input);
        assertEquals("Expected and actual results are not equals", expected, actual,0.0001);
    }

    @Test
    public void testMultiplicationOperator() throws IncorrectExpressionException {
        final MathematicsExpressionCalculator calculator = new MathematicsExpressionCalculatorImpl();
        final String input = "-2*3*4*5";
        final Double expected = -120.0;
        final Double actual = calculator.evaluate(input);
        assertEquals("Expected and actual results are not equals", expected, actual,0.0001);
    }

    @Test
    public void testDivisionOperator() throws IncorrectExpressionException {
        final MathematicsExpressionCalculator calculator = new MathematicsExpressionCalculatorImpl();
        final String input = "-55.5/5/2";
        final Double expected = -5.55;
        final Double actual = calculator.evaluate(input);
        assertEquals("Expected and actual results are not equals", expected, actual,0.0001);
    }
}
