package ua.com.mathutils.calculator.impl.parser;

import ua.com.mathutils.calculator.impl.context.InputContext;
import ua.com.mathutils.calculator.impl.context.OutputContext;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Number parser.
 */
class NumberParser implements Parser {

    @Override
    public Optional<EvaluationCommand> parse(InputContext input, OutputContext output) {

        final String numberPattern = "-?\\d+(\\.\\d+)*";
        final Matcher matcher = Pattern.compile(numberPattern).matcher(input.getRemaining());

        if (input.hasMoreToParse() && isNumber(matcher)) {

            return Optional.of(new EvaluationCommand() {
                @Override
                public void execute(InputContext input, OutputContext output) {
                    final int end = matcher.end();
                    final Double newNumber = Double.valueOf(input.getRemaining().substring(0, end));
                    output.put(newNumber);
                    input.movePointer(end);
                }
            });
        }

        return Optional.empty();
    }

    private boolean isNumber(Matcher numberMatcher) {
        return numberMatcher.matches();
    }
}
