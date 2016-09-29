package ua.com.mathutils.calculator.impl.function;

import java.util.Deque;

/**
 * Implementation of {@link Function} for math pi function.
 */
class PiFunction implements Function {

    public String getRepresentation() {
        return "pi";
    }

    @Override
    public int getMinimumQuantityOfArguments() {
        return 0;
    }

    @Override
    public int getMaximumQuantityOfArguments() {
        return 0;
    }

    @Override
    public Double execute(Deque<Double> arguments) {
        return Math.PI;
    }
}
