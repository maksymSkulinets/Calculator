package ua.com.mathutils.calculator.impl.parser;

import org.apache.log4j.Logger;
import ua.com.mathutils.calculator.impl.context.InputContext;
import ua.com.mathutils.calculator.impl.context.OutputContext;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Number parser.
 */
class NumberParser implements Parser {

    private final Logger log = Logger.getLogger(NumberParser.class);

    @Override
    public Optional<EvaluationCommand> parse(InputContext input, OutputContext output) {

        final String numberPattern = "-?\\d+(\\.\\d+)*";
        final Matcher matcher = Pattern.compile(numberPattern).matcher(input.getRemaining());

        if (input.hasMoreToParse() && isNumber(matcher)) {
            if (log.isDebugEnabled()) {
                log.debug("Number parser is chosen.");
            }

                return Optional.of(new EvaluationCommand() {
                    @Override
                    public void execute(InputContext input, OutputContext output) {
                        final int pointerDisplacement = matcher.end();
                        final Double newNumber = Double.valueOf(input.getRemaining().substring(0, pointerDisplacement));

                        if (log.isDebugEnabled()) {
                            log.debug("Number: " + newNumber + " -is parsed.");
                        }

                        output.put(newNumber);
                        input.movePointer(pointerDisplacement);
                    }
                });
        }

        return Optional.empty();
    }

    private boolean isNumber(Matcher numberMatcher) {
        return numberMatcher.matches();
    }
}
