package ua.com.mathutils.calculator.impl.parser;

import ua.com.mathutils.calculator.impl.context.InputContext;
import ua.com.mathutils.calculator.impl.context.OutputContext;

/**
 * Evaluation command to evaluate input sequence and convert to output.
 */
public interface EvaluationCommand {
    /**
     * Convert part of input sequence to output context.
     *
     * @param input  input wrapper of mathematics expression
     * @param output holder of interim output result
     */
    void execute(InputContext input, OutputContext output);
}
