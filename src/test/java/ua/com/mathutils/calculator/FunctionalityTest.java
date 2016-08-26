package ua.com.mathutils.calculator;

import org.junit.Test;
import ua.com.mathutils.calculator.impl.MathematicsExpressionCalculatorImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FunctionalityTest {

    private final MathematicsExpressionCalculator calculator = new MathematicsExpressionCalculatorImpl();

    @Test
    public void testMultiplicityOperators() throws IncorrectExpressionException {
        final String input = "-120+10*2-22.55*2/5-2.98";
        final Double expected = -112.0;
        double delta = 0.0001;
        assertEquals("Multiplicity operators calculation is not correct.",
                expected, calculator.evaluate(input), delta);
    }

    @Test
    public void testIllegalSymbolInput() {
        final String input = "43.2+67X34";
        final String expected = "Illegal input: 43.2+67X34. Illegal symbol at position: 7";
        try {
            calculator.evaluate(input);
            fail("IncorrectExpressionException was not thrown.");
        } catch (IncorrectExpressionException e) {
            assertEquals("Such IncorrectExpressionException message is not expected.", expected, e.getMessage());
        }
    }

}
