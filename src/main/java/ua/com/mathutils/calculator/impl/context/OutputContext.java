package ua.com.mathutils.calculator.impl.context;


import ua.com.mathutils.calculator.impl.function.Function;
import ua.com.mathutils.calculator.impl.operator.BinaryOperator;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Output data wrapper.
 */
public class OutputContext {

    private final Deque<EvaluationContext> contexts = new ArrayDeque<>();
    private EvaluationContext currentContext;
    private BracketsCounter bracketsCounter;

    public OutputContext() {
        currentContext = new EvaluationContext();
        contexts.addLast(currentContext);
        bracketsCounter = new BracketsCounter();
    }

    public Deque<BinaryOperator> getOperators() {
        return currentContext.getOperators();
    }

    public Deque<Double> getOperands() {
        return currentContext.getOperands();
    }

    public void openContext() {
        currentContext = new EvaluationContext();
        contexts.addLast(currentContext);
    }

    public void openContext(Function function) {
        currentContext = new EvaluationContext(function);
        contexts.addLast(currentContext);
    }

    public void closeContext() {
        final Double contextResult = currentContext.getOperands().getLast();
        contexts.removeLast();
        currentContext = contexts.getLast();
        currentContext.getOperands().addLast(contextResult);
    }

    public EvaluationContext getCurrentContext() {
        return currentContext;
    }

    public BracketsCounter getBracketsCounter() {
        return bracketsCounter;
    }
}
