package ua.com.mathutils.calculator.impl.function;

/**
 * Interface of mathematics function.
 */
public interface Function {

    /*
     * @return minimum quantity of valid arguments.
     */
    int getMinimumQuantityOfArguments();

    /**
     * @return maximum quantity of valid arguments.
     */
    int getMaximumQuantityOfArguments();

    Double execute(Double leftArgument, Double rightArgument);
}
