package ua.com.mathutils.calculator.impl.function;

import org.apache.log4j.Logger;

import java.util.Deque;

/**
 * Implementation of {@link Function} for math power.
 */
class Power implements Function {

    private final Logger log = Logger.getLogger(Power.class);

    public String getRepresentation() {
        return "pow(";
    }

    @Override
    public int getMinimumQuantityOfArguments() {
        return 2;
    }

    @Override
    public int getMaximumQuantityOfArguments() {
        return 2;
    }

    @Override
    public Double execute(Deque<Double> arguments) {
        if (log.isDebugEnabled()) {
            log.debug("Function power. Arguments: " + arguments);
        }

        final Double rightArgument = arguments.removeLast();
        final Double leftArgument = arguments.removeLast();
        final Double result = Math.pow(leftArgument, rightArgument);

        if (log.isDebugEnabled()) {
            log.debug("Result: " + result);
        }

        return result;

    }
}
