package ua.com.mathutils.calculator.impl.function;

import org.apache.log4j.Logger;

import java.util.Deque;

/**
 * Implementation of {@link Function} for math maximum function.
 */
class Maximum implements Function {

    private final Logger log = Logger.getLogger(Maximum.class);

    public String getRepresentation() {
        return "max";
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
            log.debug("Function maximum. Arguments: " + arguments);
        }

        if (arguments.size() == 1) {
            return arguments.removeLast();
        }

        while (arguments.size() != 1) {
            final Double leftArgument = arguments.removeLast();
            final Double rightArgument = arguments.removeLast();
            arguments.addLast(Math.max(leftArgument, rightArgument));
        }

        final Double result = arguments.removeLast();

        if (log.isDebugEnabled()) {
            log.debug("Result: " + result);
        }

        return result;

    }
}
