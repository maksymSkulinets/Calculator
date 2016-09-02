package ua.com.mathutils.calculator.impl.parser;

import org.apache.log4j.Logger;
import ua.com.mathutils.calculator.IncorrectExpressionException;
import ua.com.mathutils.calculator.impl.context.InputContext;
import ua.com.mathutils.calculator.impl.context.OutputContext;
import ua.com.mathutils.calculator.impl.function.Function;
import ua.com.mathutils.calculator.impl.operator.BinaryOperator;

import java.util.Deque;
import java.util.Optional;

/**
 * Parser implementation for parse closing brackets.
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
                public void execute(InputContext input, OutputContext output) throws IncorrectExpressionException {
                    final Character bracketRepresentation = input.getCurrentChar();

                    if (log.isDebugEnabled()) {
                        log.debug("Bracket : " + bracketRepresentation + " is parsed.");
                    }

                    if (output.getCurrentContext().getFunction().isPresent()) {
                        executeFunction(output);
                    } else {
                        executeRemainingOperators(output);
                    }
                    output.getBracketsCounter().countBracket(bracketRepresentation);
                    output.closeContext();
                    input.movePointer(1);
                }
            });
        }

        return Optional.empty();
    }

    private void executeFunction(OutputContext output) throws IncorrectExpressionException {
        final int argumentsNumber = output.getOperands().size();

        if (log.isDebugEnabled()) {
            log.debug("Number of function arguments inside current context: "
                    + argumentsNumber);
        }

        final Function function = output.getCurrentContext().getFunction().get();

        if (argumentsNumber < function.getMinimumQuantityOfArguments()) {

            final String message = "Invalid number of functions arguments." +
                    "Minimum number: " + function.getMinimumQuantityOfArguments() + " " +
                    "Actual: " + argumentsNumber;
            final IncorrectExpressionException exception = new IncorrectExpressionException(message);
            log.warn(exception);
            throw exception;
        }

        if (argumentsNumber > function.getMaximumQuantityOfArguments()) {

            final String message = "Invalid number of functions arguments. " +
                    "Maximum number: " + function.getMaximumQuantityOfArguments() + " " +
                    "Actual: " + argumentsNumber;
            final IncorrectExpressionException exception = new IncorrectExpressionException(message);
            log.warn(exception);
            throw exception;
        }

        final Double functionResult = function.execute(output.getOperands());
        output.getOperands().addLast(functionResult);
    }

    private void executeRemainingOperators(OutputContext output) {
        final Deque<Double> operands = output.getOperands();
        final Deque<BinaryOperator> operators = output.getOperators();

        if (log.isDebugEnabled()) {
            log.debug("Number of remaining operators inside current context: "
                    + operators.size());
        }

        while (!operators.isEmpty()) {
            final Double rightOperand = operands.removeLast();
            final Double leftOperand = operands.removeLast();
            final Double result = operators.removeLast().execute(leftOperand, rightOperand);
            operands.add(result);
        }
    }

    private boolean isClosingBracket(Character currentChar) {
        return (currentChar == ')');
    }
}
