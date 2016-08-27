package ua.com.mathutils.calculator.impl.parser;

import org.apache.log4j.Logger;
import ua.com.mathutils.calculator.IncorrectExpressionException;
import ua.com.mathutils.calculator.impl.context.InputContext;
import ua.com.mathutils.calculator.impl.context.OutputContext;
import ua.com.mathutils.calculator.impl.operator.BinaryOperator;

import java.util.Deque;
import java.util.Optional;

/**
 * Closing bracket parser.
 */
class ClosingBracketParser implements Parser {

    private final Logger log = Logger.getLogger(ClosingBracketParser.class);

    @Override
    public Optional<EvaluationCommand> parse(InputContext input, OutputContext output)
            throws IncorrectExpressionException {

        if (input.hasMoreToParse() && isClosingBracket(input.getCurrentChar())) {

            if (log.isDebugEnabled()) {
                log.debug("Closing bracket parser is chosen.");
            }

            if (output.getBracketsCounter().getValue() == 0) {
                final String message = "Different quantity of opening and closing brackets.";
                final IncorrectExpressionException exception = new IncorrectExpressionException(message);
                log.warn(exception);
                throw exception;
            }

            return Optional.of(new EvaluationCommand() {
                @Override
                public void execute(InputContext input, OutputContext output) {
                    final Character currentChar = input.getCurrentChar();

                    if (log.isDebugEnabled()) {
                        log.debug("Bracket : " + currentChar + " is parsed.");
                    }

                    output.getBracketsCounter().countBracket(currentChar);
                    executeRemainingOperators(output.getOperators(), output.getOperands());
                    output.closeContext();
                    input.movePointer(1);
                }
            });
        }

        return Optional.empty();
    }

    private boolean isClosingBracket(Character currentChar) {
        return (currentChar == ')');
    }

    private void executeRemainingOperators(Deque<BinaryOperator> operators, Deque<Double> operands) {
        while (!operators.isEmpty()) {
            if (log.isDebugEnabled()) {
                log.debug("Number of remaining operators inside brackets: " + operators.size());
            }
            final Double rightOperand = operands.removeLast();
            final Double leftOperand = operands.removeLast();
            final Double result = operators.removeLast().execute(leftOperand, rightOperand);
            operands.add(result);
        }
    }
}
