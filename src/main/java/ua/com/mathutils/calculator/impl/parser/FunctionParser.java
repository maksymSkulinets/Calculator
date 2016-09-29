package ua.com.mathutils.calculator.impl.parser;

import org.apache.log4j.Logger;
import ua.com.mathutils.calculator.IncorrectExpressionException;
import ua.com.mathutils.calculator.impl.context.InputContext;
import ua.com.mathutils.calculator.impl.context.OutputContext;
import ua.com.mathutils.calculator.impl.function.Function;
import ua.com.mathutils.calculator.impl.function.FunctionContainer;

import java.util.Optional;
import java.util.Set;

/**
 * Parser implementation for parse functions.
 */
class FunctionParser implements Parser {

    private final Logger log = Logger.getLogger(FunctionParser.class);
    private final FunctionContainer functions = new FunctionContainer();

    @Override
    public Optional<EvaluationCommand> parse(InputContext input, OutputContext output) throws IncorrectExpressionException {

        if (input.hasMoreToParse() && isFunction(input, functions)) {
            if (log.isDebugEnabled()) {
                log.debug("Function parser is chosen.");
            }

            return Optional.of(new EvaluationCommand() {
                @Override
                public void execute(InputContext input, OutputContext output) throws IncorrectExpressionException {
                    final String remaining = input.getRemaining();
                    final String functionRepresentation = input.getRemaining();
                    Function function = null;

                    for (String current : functions.getAllRepresentations()) {
                        if (remaining.startsWith(current)) {
                            function = functions.getFunction(current).get();
                        }
                    }

                    if (log.isDebugEnabled()) {
                        log.debug("Function: " + functionRepresentation + " is parsed.");
                    }
                    output.openContext(function);
                    input.movePointer(function.getRepresentation().length());

                    if (input.getCurrentChar() != '(') {
                        final String message = "Opening bracket expected.Index: " + (input.getPointerIndex() + 1);
                        final IncorrectExpressionException exception =
                                new IncorrectExpressionException(message, input.getPointerIndex());
                        log.warn(message, exception);
                        throw exception;
                    }

                    output.getBracketsCounter().countBracket(input.getCurrentChar());
                    input.movePointer(1);
                }
            });

        }
        return Optional.empty();

    }

    private boolean isFunction(InputContext input, FunctionContainer functions) {
        final String remaining = input.getRemaining();
        final Set<String> representations = functions.getAllRepresentations();

        for (String current : representations) {
            if (remaining.startsWith(current)) {
                return true;
            }
        }
        return false;
    }
}
