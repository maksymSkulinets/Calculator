package ua.com.mathutils.calculator.stateMachine;

import ua.com.mathutils.calculator.InputContext;
import ua.com.mathutils.calculator.OutputContext;

import java.util.Set;

/**
 * Representation of calculator engine.
 */
public class FiniteStateMachine {

    private TransitionMatrix transitionMatrix = new TransitionMatrix();
    private State current = transitionMatrix.getStartState();

    /**
     * Move through all states according to input data.
     *
     * @param input  input of mathematics expression
     * @param output holder of interim output result
     */
    public void run(InputContext input, OutputContext output) {
        while (getCurrentState() != transitionMatrix.getFinishState()) {
            current = nextState(getCurrentState(), input, output);
        }
    }

    /**
     * Move finite state machine to next state.
     *
     * @param current current state
     * @param input   input of mathematics expression
     * @param output  holder of interim output result
     * @return accepted state or null if there no possible states
     */
    private State nextState(State current, InputContext input, OutputContext output) {
        Set<State> possibleStates = transitionMatrix.getPossibleStates(current);
        for (State next : possibleStates) {
            return next;
        }
        throw new IllegalStateException(
                "There are no accepted states for next state: " + current);

    }

    private State getCurrentState() {
        return current;
    }
}
