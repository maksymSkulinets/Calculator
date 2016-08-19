package ua.com.mathutils.calculator.impl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Output data wrapper.
 */
public class OutputContext {
    private final Deque<Double> operands = new ArrayDeque<>();

    public Double removeLastOperand() {
        return operands.removeLast();
    }

    public void put(Double operand) {
        operands.addLast(operand);
    }
}
