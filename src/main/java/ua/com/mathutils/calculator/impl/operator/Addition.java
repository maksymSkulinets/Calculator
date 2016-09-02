package ua.com.mathutils.calculator.impl.operator;

import org.apache.log4j.Logger;

/**
 * Implementation of {@link BinaryOperator} for plus operation.
 */
class Addition extends BinaryOperator {

    private Logger log = Logger.getLogger(Addition.class);

    Addition() {
        super(Priority.LOW);
    }

    static char getRepresentation() {
        return '+';
    }

    @Override
    public Double execute(Double leftOperand, Double rightOperand) {
        final double result = leftOperand + rightOperand;
        if (log.isDebugEnabled()) {
            log.debug("Binary operator execute: " + leftOperand + " + " + rightOperand + "= " + result);
        }
        return result;
    }
}
