package ua.com.mathutils.calculator.impl.function;

import java.util.Deque;

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

    String getRepresentation();

    Double execute(Deque<Double> arguments);
}
