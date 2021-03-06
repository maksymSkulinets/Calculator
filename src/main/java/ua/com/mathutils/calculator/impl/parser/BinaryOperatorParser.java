package ua.com.mathutils.calculator.impl.parser;

import org.apache.log4j.Logger;
import ua.com.mathutils.calculator.impl.context.InputContext;
import ua.com.mathutils.calculator.impl.context.OutputContext;
import ua.com.mathutils.calculator.impl.operator.BinaryOperator;
import ua.com.mathutils.calculator.impl.operator.BinaryOperatorsContainer;

import java.util.Deque;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parser implementation for parse binary operator.
 */
class BinaryOperatorParser implements Parser {

    private final Logger log = Logger.getLogger(BinaryOperatorParser.class);
    private final BinaryOperatorsContainer operatorsContainer = new BinaryOperatorsContainer();

    @Override
    public Optional<EvaluationCommand> parse(InputContext input, OutputContext output) {

        if (input.hasMoreToParse() && isOperator(input,operatorsContainer)) {
            if (log.isDebugEnabled()) {
                log.debug("Binary operator parser is chosen.");
            }

            return Optional.of(new EvaluationCommand() {

                @Override
                public void execute(InputContext input, OutputContext output) {
                    final Character operatorRepresentation = input.getCurrentChar();
                    final BinaryOperator newOperator = operatorsContainer.getOperator(operatorRepresentation).get();

                    if (log.isDebugEnabled()) {
                        log.debug("Binary operator: " + operatorRepresentation + " is parsed.");
                    }

                    input.movePointer(1);

                    final Deque<BinaryOperator> operators = output.getOperators();
                    final Deque<Double> operands = output.getOperands();

                    while (!operators.isEmpty() && newOperator.compareTo(getPreviousOperator(output)) <= 0) {
                        executeLastOperator(operators, operands);
                    }

                    if (operators.isEmpty() || newOperator.compareTo(getPreviousOperator(output)) > 0) {
                        operators.addLast(newOperator);
                    }


                }
            });
        }
        return Optional.empty();
    }


    private void executeLastOperator(Deque<BinaryOperator> binaryOperators, Deque<Double> operands) {
        final BinaryOperator operator = binaryOperators.removeLast();
        final Double rightOperator = operands.removeLast();
        final Double leftOperator = operands.removeLast();
        operands.addLast(operator.execute(leftOperator, rightOperator));
    }

    private BinaryOperator getPreviousOperator(OutputContext output) {
        return output.getOperators().getLast();
    }

    private boolean isOperator(InputContext input, BinaryOperatorsContainer operatorsContainer) {
        final Character currentChar = input.getCurrentChar();
        return (operatorsContainer.getOperator(currentChar).isPresent());
    }
}
