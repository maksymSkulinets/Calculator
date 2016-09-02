package ua.com.mathutils.calculator.impl.function;

import java.util.Deque;

/**
 * Implementation of {@link Function} for math pi function.
 */
public class PiFunction implements Function {
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
