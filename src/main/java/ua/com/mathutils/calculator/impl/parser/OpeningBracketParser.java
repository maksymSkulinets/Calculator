package ua.com.mathutils.calculator.impl.parser;

import org.apache.log4j.Logger;
import ua.com.mathutils.calculator.impl.context.InputContext;
import ua.com.mathutils.calculator.impl.context.OutputContext;

import java.util.Optional;

/**
 * Parser implementation for parse opening brackets.
 */
class OpeningBracketParser implements Parser {

    private final Logger log = Logger.getLogger(OpeningBracketParser.class);

    @Override
    public Optional<EvaluationCommand> parse(InputContext input, OutputContext output) {

        if (input.hasMoreToParse() && isOpeningBracket(input.getCurrentChar())) {

            if (log.isDebugEnabled()) {
                log.debug("Opening bracket parser is chosen.");
            }

            return Optional.of(new EvaluationCommand() {

                @Override
                public void execute(InputContext input, OutputContext output) {
                    final Character currentChar = input.getCurrentChar();

                    if (log.isDebugEnabled()) {
                        log.debug("Bracket : " + currentChar + " is parsed.");
                    }

                    output.getBracketsCounter().countBracket(currentChar);
                    input.movePointer(1);
                    output.openContext();
                }
            });
        }

        return Optional.empty();
    }


    private boolean isOpeningBracket(Character currentChar) {
        return (currentChar == '(');
    }
}
