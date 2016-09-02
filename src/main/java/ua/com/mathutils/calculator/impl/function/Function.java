package ua.com.mathutils.calculator.impl.function;

import ua.com.mathutils.calculator.IncorrectExpressionException;

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

    Double execute(Deque<Double> arguments);
}
