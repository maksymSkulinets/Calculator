package ua.com.mathutils.calculator.impl;

import org.apache.log4j.Logger;
import ua.com.mathutils.calculator.IncorrectExpressionException;
import ua.com.mathutils.calculator.MathematicsExpressionCalculator;
import ua.com.mathutils.calculator.impl.context.InputContext;
import ua.com.mathutils.calculator.impl.context.OutputContext;
import ua.com.mathutils.calculator.impl.stateMachine.FiniteStateMachine;

public class MathematicsExpressionCalculatorImpl implements MathematicsExpressionCalculator {

    private final Logger log = Logger.getLogger(MathematicsExpressionCalculatorImpl.class);

    @Override
    public double evaluate(String expression) throws IncorrectExpressionException {
        final InputContext input = new InputContext(expression);
        final OutputContext output = new OutputContext();
        final FiniteStateMachine stateMachine = new FiniteStateMachine();
        stateMachine.run(input, output);
        final Double result = output.removeLastOperand();

        if (log.isInfoEnabled()) {
            log.info("Output result: " + result);
        }

        return result;
    }
}
