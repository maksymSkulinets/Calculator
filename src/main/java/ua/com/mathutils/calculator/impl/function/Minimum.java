package ua.com.mathutils.calculator.impl.function;

import org.apache.log4j.Logger;

class Minimum implements Function {

    private Logger log = Logger.getLogger(Minimum.class);

    @Override
    public int getMinimumQuantityOfArguments() {
        return 1;
    }

    @Override
    public int getMaximumQuantityOfArguments() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Double execute(Double leftArgument, Double rightArgument) {
        final double result = Math.min(leftArgument, rightArgument);
        if (log.isDebugEnabled()) {
            log.debug("Function minimum execute.Arguments: " + leftArgument + " ; " + rightArgument +
                    ". Result: " + result);
        }
        return result;
    }
}
