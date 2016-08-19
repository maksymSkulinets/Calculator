package ua.com.mathutils.calculator.impl;

import ua.com.mathutils.calculator.IncorrectExpressionException;
import ua.com.mathutils.calculator.MathematicsExpressionCalculator;
import ua.com.mathutils.calculator.impl.stateMachine.FiniteStateMachine;

public class MathematicsExpressionCalculatorImpl implements MathematicsExpressionCalculator {

    @Override
    public double evaluate(String expression) throws IncorrectExpressionException {
        final InputContext input = new InputContext(expression);
        final OutputContext output = new OutputContext();
        final FiniteStateMachine stateMachine = new FiniteStateMachine();
        stateMachine.run(input, output);
        return output.removeLastOperand();
    }
}
