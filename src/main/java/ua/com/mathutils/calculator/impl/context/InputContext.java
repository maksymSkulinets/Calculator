package ua.com.mathutils.calculator.impl.context;

import org.apache.log4j.Logger;
import ua.com.mathutils.calculator.IncorrectExpressionException;

/**
 * Input data wrapper.Hold input expression.
 */
public class InputContext {

    private final Logger log = Logger.getLogger(InputContext.class);
    private final String expression;
    private int pointer;

    public InputContext(String expression) throws IncorrectExpressionException {
        if (log.isInfoEnabled()) {
            log.info("Input expression: " + expression);
        }

        if (expression.trim().isEmpty()) {
            final String message = "Input expression should be not empty.";
            log.warn("IncorrectExpressionException thrown.Message: " + message);
            throw new IncorrectExpressionException(message);
        }

        this.expression = expression;
        this.pointer = 0;
    }

    public int getPointerIndex() {
        return pointer;
    }

    public String getRemaining() {
        return expression.substring(pointer);
    }

    public boolean hasMoreToParse() {
        return pointer != expression.length();
    }

    public String getExpression() {
        return expression;
    }

    public void movePointer(int end) {
        pointer += end;
        if (log.isDebugEnabled()) {
            log.debug("Number of parsed input sequence symbols: " + pointer);
        }
    }
}
