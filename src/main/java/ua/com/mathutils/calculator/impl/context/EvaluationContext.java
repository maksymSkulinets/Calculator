package ua.com.mathutils.calculator.impl.context;

import ua.com.mathutils.calculator.impl.operator.BinaryOperator;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Operator and operand stacks for keep parsing data.
 */
class EvaluationContext {

    private final Deque<Double> operands = new ArrayDeque<>();
    private final Deque<BinaryOperator> binaryOperators = new ArrayDeque<>();

    Deque<Double> getOperands() {
        return operands;
    }

    Deque<BinaryOperator> getBinaryOperators() {
        return binaryOperators;
    }
}
