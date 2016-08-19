package ua.com.mathutils.calculator.impl.stateMachine;

import org.apache.log4j.Logger;
import ua.com.mathutils.calculator.IncorrectExpressionException;
import ua.com.mathutils.calculator.impl.context.InputContext;
import ua.com.mathutils.calculator.impl.context.OutputContext;
import ua.com.mathutils.calculator.impl.parser.EvaluationCommand;
import ua.com.mathutils.calculator.impl.parser.Parser;
import ua.com.mathutils.calculator.impl.parser.ParserFactory;

import java.util.Optional;
import java.util.Set;

/**
 * Representation of calculator engine.
 */
public class FiniteStateMachine {

    private Logger log = Logger.getLogger(FiniteStateMachine.class);
    private TransitionMatrix transitionMatrix = new TransitionMatrix();
    private State current = transitionMatrix.getStartState();
    private ParserFactory parserFactory = new ParserFactory();

    /**
     * Move through all states according to input data.
     *
     * @param input  input of mathematics expression
     * @param output holder of interim output result
     */
    public void run(InputContext input, OutputContext output) throws IncorrectExpressionException {
        if (log.isInfoEnabled()) {
            log.info("Run method processing started.");
        }

        while (getCurrentState() != transitionMatrix.getFinishState()) {
            current = nextState(getCurrentState(), input, output);
        }

        if (log.isInfoEnabled()) {
            log.info("Run method processing finished.");
        }
    }

    /**
     * Move finite state machine to next state.
     *
     * @param current current state
     * @param input   input wrapper of mathematics expression
     * @param output  holder of interim output result
     * @return accepted state or null if there no possible states
     */
    private State nextState(State current, InputContext input, OutputContext output) throws IncorrectExpressionException {
        if (log.isInfoEnabled()) {
            log.info("Current state: " + current);
        }

        Set<State> possibleStates = transitionMatrix.getPossibleStates(current);
        if (possibleStates.isEmpty()) {
            throw new IllegalStateException(
                    "There are no possible transitions for current state: " + current);

        }
        for (State next : possibleStates) {
            final Parser parser = parserFactory.getParser(next);
            final Optional<EvaluationCommand> command = parser.parse(input, output);
            if (command.isPresent()) {
                command.get().execute(input, output);

                if (log.isInfoEnabled()) {
                    log.info("Accepted state: " + next);
                }

                return next;
            }

        }
        final String message = "Illegal input: " + input.getExpression()
                + "Illegal symbol at position: " + input.getPointerIndex();
        throw new IncorrectExpressionException(message, input.getPointerIndex());
    }


    private State getCurrentState() {
        return current;
    }
}
