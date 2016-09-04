package ua.com.mathutils.calculator.impl.function;

import org.apache.log4j.Logger;

import java.util.Deque;

/**
 * Implementation of {@link Function} for math minimum.
 */
class Minimum implements Function {

    private final Logger log = Logger.getLogger(Minimum.class);

    public String getRepresentation() {
        return "min(";
    }

    @Override
    public int getMinimumQuantityOfArguments() {
        return 1;
    }

    @Override
    public int getMaximumQuantityOfArguments() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Double execute(Deque<Double> arguments) {
        if (log.isDebugEnabled()) {
            log.debug("Function minimum. Arguments: " + arguments);
        }

        if (arguments.size() == 1) {
            return arguments.removeLast();
        }

        while (arguments.size() != 1) {
            final Double leftArgument = arguments.removeLast();
            final Double rightArgument = arguments.removeLast();
            arguments.addLast(Math.min(leftArgument, rightArgument));
        }

        final Double result = arguments.removeLast();

        if (log.isDebugEnabled()) {
            log.debug("Result: " + result);
        }

        return result;
    }
}