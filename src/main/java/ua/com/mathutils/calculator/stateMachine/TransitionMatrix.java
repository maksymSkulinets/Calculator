package ua.com.mathutils.calculator.stateMachine;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

/**
 * Representation of all correct finite state machine transitions
 * for each possible states.
 */
public class TransitionMatrix {

    private final Map<State, Set<State>> matrixContainer =
            new EnumMap<State, Set<State>>(State.class);

    public TransitionMatrix() {
        {
            matrixContainer.put(State.Start, EnumSet.of(State.Finish));
        }
    }

    public Set<State> getPossibleStates(State current) {
        return matrixContainer.get(current);
    }

    public State getStartState() {
        return State.Start;
    }

    public State getFinishState() {
        return State.Finish;
    }

}
