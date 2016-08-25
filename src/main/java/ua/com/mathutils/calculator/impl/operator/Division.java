package ua.com.mathutils.calculator.impl.operator;

import org.apache.log4j.Logger;

public class Division extends BinaryOperator {
    private Logger log = Logger.getLogger(Subtraction.class);

    Division() {
        super(Priority.MEDIUM);
    }

    @Override
    public char getRepresentation() {
        return '/';
    }

    @Override
    public Double execute(Double leftOperand, Double rightOperand) {

        final double result = leftOperand / rightOperand;
        if (log.isDebugEnabled()) {
            log.debug(leftOperand + " / " + rightOperand + "= " + result);
        }
        return result;

    }
}
