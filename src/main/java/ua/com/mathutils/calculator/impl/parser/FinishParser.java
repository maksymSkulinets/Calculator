package ua.com.mathutils.calculator.impl.parser;

import org.apache.log4j.Logger;
import ua.com.mathutils.calculator.impl.context.InputContext;
import ua.com.mathutils.calculator.impl.context.OutputContext;

import java.util.Optional;

/**
 * Finish parser evaluate output context to result.
 */
class FinishParser implements Parser {

    private final Logger log = Logger.getLogger(FinishParser.class);

    @Override

    public Optional<EvaluationCommand> parse(InputContext input, OutputContext output) {

        if (!input.hasMoreToParse()) {

            if (log.isDebugEnabled()){
                log.debug("Finish parser is chosen.");
            }

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
