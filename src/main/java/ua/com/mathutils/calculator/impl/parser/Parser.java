package ua.com.mathutils.calculator.impl.parser;

import ua.com.mathutils.calculator.IncorrectExpressionException;
import ua.com.mathutils.calculator.impl.context.InputContext;
import ua.com.mathutils.calculator.impl.context.OutputContext;

import java.util.Optional;

/**
 * Interface of input expression parser.
 */
public interface Parser {
    /**
     * Parse input expression and put parsed lexemes into output context
     *
     * @param input  input wrapper of mathematics expression
     * @param output holder of interim output result
     */
    Optional<EvaluationCommand> parse(InputContext input, OutputContext output)
            throws IncorrectExpressionException;
}
