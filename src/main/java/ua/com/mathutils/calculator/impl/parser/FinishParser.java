package ua.com.mathutils.calculator.impl.parser;

import org.apache.log4j.Logger;
import ua.com.mathutils.calculator.impl.context.InputContext;
import ua.com.mathutils.calculator.impl.context.OutputContext;
import ua.com.mathutils.calculator.impl.operator.BinaryOperator;

import java.util.Deque;
import java.util.Optional;

/**
 * Finish parser.Evaluates output context to result.
 */
class FinishParser implements Parser {

    private final Logger log = Logger.getLogger(FinishParser.class);

    @Override
    public Optional<EvaluationCommand> parse(InputContext input, OutputContext output) {

        if (!input.hasMoreToParse()) {

            if (log.isDebugEnabled()) {
                log.debug("Finish parser is chosen.");
            }

            return Optional.of(new EvaluationCommand() {
                @Override
                public void execute(InputContext input, OutputContext output) {
                    final Deque<BinaryOperator> operators = output.getOperators();
                    final Deque<Double> operands = output.getOperands();
                    executeRemainingOperators(operators, operands);
                }
            });
        }

        return Optional.empty();
    }

    private void executeRemainingOperators(Deque<BinaryOperator> operators, Deque<Double> operands) {
        while (!operators.isEmpty()) {
            if (log.isDebugEnabled()) {
                log.debug("Number of remaining operators: " + operators.size());
            }
            final Double rightOperand = operands.removeLast();
            final Double leftOperand = operands.removeLast();
            final Double result = operators.removeLast().execute(leftOperand, rightOperand);
            operands.add(result);
        }
    }
}
