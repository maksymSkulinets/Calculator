package ua.com.mathutils.calculator.impl.operator;

import org.apache.log4j.Logger;

class Subtraction extends BinaryOperator {

    private Logger log = Logger.getLogger(Subtraction.class);

    Subtraction() {
        super(Priority.LOW);
    }

    @Override
    public char getRepresentation() {
        return '-';
    }

    @Override
    public Double execute(Double leftOperand, Double rightOperand) {

        final double result = leftOperand - rightOperand;
        if (log.isDebugEnabled()) {
            log.debug("Binary operator execute: " + leftOperand + " - " + rightOperand + "= " + result);
        }
        return result;

    }
}
