package ua.com.mathutils.calculator.impl.parser;

import ua.com.mathutils.calculator.impl.InputContext;
import ua.com.mathutils.calculator.impl.OutputContext;

import java.util.Optional;

/**
 * Finish parser evaluate output context to result.
 */
class FinishParser implements Parser {
    @Override
    public Optional<EvaluationCommand> parse(InputContext input, OutputContext output) {

        if (!input.hasMoreToParse()) {

            return Optional.of(new EvaluationCommand() {
                @Override
                public void execute(InputContext input, OutputContext output) {
                    /*TODO if stack not empty -> remove all operands from stack*/
                }
            });
        }

        return null;
    }
}
