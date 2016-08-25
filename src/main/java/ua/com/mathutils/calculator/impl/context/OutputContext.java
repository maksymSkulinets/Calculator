package ua.com.mathutils.calculator.impl.context;


import ua.com.mathutils.calculator.impl.operator.BinaryOperator;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Output data wrapper.
 */
public class OutputContext {

    private final Deque<Double> operands = new ArrayDeque<>();
    private final Deque<BinaryOperator> binaryOperators = new ArrayDeque<>();

    public Double removeLastOperand() {
        return operands.removeLast();
    }

    public void put(Double operand) {
        operands.addLast(operand);
    }

    public void put(BinaryOperator binaryOperator) {
        binaryOperators.addLast(binaryOperator);
    }

    public Deque<BinaryOperator> getOperators() {
        return binaryOperators;
    }

    public Deque<Double> getOperands() {
        return operands;
    }
}
