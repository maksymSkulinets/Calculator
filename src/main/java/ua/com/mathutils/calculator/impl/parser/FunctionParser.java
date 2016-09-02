package ua.com.mathutils.calculator.impl.parser;

import org.apache.log4j.Logger;
import ua.com.mathutils.calculator.IncorrectExpressionException;
import ua.com.mathutils.calculator.impl.context.InputContext;
import ua.com.mathutils.calculator.impl.context.OutputContext;
import ua.com.mathutils.calculator.impl.function.Function;
import ua.com.mathutils.calculator.impl.function.FunctionContainer;

import java.util.Optional;

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
                public void execute(InputContext input, OutputContext output) {
                    final String functionRepresentation = input.getRemaining().substring(0, 4);
                    final Function function = functions.getFunction(functionRepresentation.substring(0, 4)).get();

                    if (log.isDebugEnabled()) {
                        log.debug("Function: " + functionRepresentation + " is parsed.");
                    }
                    output.openContext(function);
                    output.getBracketsCounter().countBracket('(');
                    input.movePointer(4);
                }
            });

        }
        return Optional.empty();

    }

    private boolean isFunction(InputContext input, FunctionContainer functions) {
        final String remaining = input.getRemaining();
        if (remaining.length() < 4) {
            return false;
        }

        final Optional<Function> function = functions.getFunction(remaining.substring(0, 4));
        return function.isPresent();
    }
}
