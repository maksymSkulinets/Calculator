package ua.com.mathutils.calculator.impl.operator;

import org.apache.log4j.Logger;

/**
 * Implementation of {@link BinaryOperator} for multiplication operation.
 */
class Multiplication extends BinaryOperator {

    private final Logger log = Logger.getLogger(Subtraction.class);

    Multiplication() {
        super(Priority.MEDIUM);
    }

    static char getRepresentation() {
        return '*';
    }

    @Override
    public Double execute(Double leftOperand, Double rightOperand) {

        final double result = leftOperand * rightOperand;
        if (log.isDebugEnabled()) {
            log.debug("Binary operator execute: " + leftOperand + " * " + rightOperand + "= " + result);
        }
        return result;

    }
}
