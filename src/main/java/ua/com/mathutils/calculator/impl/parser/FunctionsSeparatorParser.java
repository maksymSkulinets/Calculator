package ua.com.mathutils.calculator.impl.parser;

import org.apache.log4j.Logger;
import ua.com.mathutils.calculator.IncorrectExpressionException;
import ua.com.mathutils.calculator.impl.context.InputContext;
import ua.com.mathutils.calculator.impl.context.OutputContext;
import ua.com.mathutils.calculator.impl.function.FunctionSeparator;

import java.util.Optional;

public class FunctionsSeparatorParser implements Parser {

    private final Logger log = Logger.getLogger(FunctionsSeparatorParser.class);
    private final FunctionSeparator separator = new FunctionSeparator();

    @Override
    public Optional<EvaluationCommand> parse(InputContext input, OutputContext output) throws IncorrectExpressionException {

        if (input.hasMoreToParse() && isSeparator(input, separator)) {
            if (log.isDebugEnabled()) {
                log.debug("Functions separator parser is chosen.");
            }

            return Optional.of(new EvaluationCommand() {

                @Override
                public void execute(InputContext input, OutputContext output) {
                    final Character currentChar = input.getCurrentChar();
                    input.movePointer(1);

                    if (log.isDebugEnabled()) {
                        log.debug("Function separator: " + currentChar + " is parsed.");
                    }
                }
            });
        }

        return Optional.empty();
    }

    private boolean isSeparator(InputContext input, FunctionSeparator separator) {
        final Character currentChar = input.getCurrentChar();
        return currentChar == separator.getRepresentation();
    }
}
