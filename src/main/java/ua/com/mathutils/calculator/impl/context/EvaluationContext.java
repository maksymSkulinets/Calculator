package ua.com.mathutils.calculator.impl.context;

import ua.com.mathutils.calculator.impl.function.Function;
import ua.com.mathutils.calculator.impl.operator.BinaryOperator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

/**
 * Operator and operand stacks for keep parsing data.
 */
public class EvaluationContext {

    private final Deque<Double> operands = new ArrayDeque<>();
    private final Deque<BinaryOperator> operators = new ArrayDeque<>();
    private Optional<Function> function;

    EvaluationContext(Function function) {
        this.function = Optional.of(function);
    }

    EvaluationContext() {
        function = Optional.empty();
    }

    public Optional<Function> getFunction() {
        return this.function;
    }

    public Deque<Double> getOperands() {
        return operands;
    }

    Deque<BinaryOperator> getOperators() {
        return operators;
    }
}
