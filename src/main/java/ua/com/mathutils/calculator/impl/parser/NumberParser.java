package ua.com.mathutils.calculator.impl.parser;

import org.apache.log4j.Logger;
import ua.com.mathutils.calculator.impl.context.InputContext;
import ua.com.mathutils.calculator.impl.context.OutputContext;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.isDigit;

/**
 * Parser implementation for parse numbers.
 */
class NumberParser implements Parser {

    private final Logger log = Logger.getLogger(NumberParser.class);

    @Override
    public Optional<EvaluationCommand> parse(InputContext input, OutputContext output) {

        final Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)*");

        if (input.hasMoreToParse() && isNumber(input)) {

            if (log.isDebugEnabled()) {
                log.debug("Number parser is chosen.");
            }

            return Optional.of(new EvaluationCommand() {
                @Override
                public void execute(InputContext input, OutputContext output) {

                    final Matcher matcher = pattern.matcher(input.getRemaining());
                    matcher.find();
                    final Double newNumber = Double.valueOf(matcher.group());

                    if (log.isDebugEnabled()) {
                        log.debug("Number: " + newNumber + " is parsed.");
                    }

                    output.put(newNumber);
                    input.movePointer(matcher.end());
                }
            });
        }

        return Optional.empty();
    }

    private boolean isNumber(InputContext input) {
        final Character currentChar = input.getCurrentChar();
        return (isDigit(currentChar) || currentChar == '-');

    }
}
