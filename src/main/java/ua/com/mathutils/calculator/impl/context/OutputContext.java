package ua.com.mathutils.calculator.impl.context;


import ua.com.mathutils.calculator.impl.operator.BinaryOperator;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Output data wrapper.
 */
public class OutputContext {

    private final Deque<EvaluationContext> contexts = new ArrayDeque<>();
    private EvaluationContext currentContext;

    public OutputContext() {
        currentContext = new EvaluationContext();
        contexts.addLast(currentContext);
    }

    public Double removeLastOperand() {
        return currentContext.getOperands().removeLast();
    }

    public void put(Double operand) {
        currentContext.getOperands().addLast(operand);
    }

    public void put(BinaryOperator binaryOperator) {
        currentContext.getBinaryOperators().addLast(binaryOperator);
    }

    public Deque<BinaryOperator> getOperators() {
        return currentContext.getBinaryOperators();
    }

    public Deque<Double> getOperands() {
        return currentContext.getOperands();
    }

    public void openContext() {
        currentContext = new EvaluationContext();
        contexts.addLast(currentContext);
    }

    public void closeContext() {
        final Double contextResult = currentContext.getOperands().getLast();
        contexts.removeLast();
        currentContext = contexts.getLast();
        currentContext.getOperands().addLast(contextResult);
    }
}
