package ua.com.mathutils.calculator.impl.stateMachine;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

import static ua.com.mathutils.calculator.impl.stateMachine.State.*;

/**
 * Representation of all correct finite state machine transitions
 * for each possible states.
 */
class TransitionMatrix {

    private final Map<State, Set<State>> matrixContainer =
            new EnumMap<State, Set<State>>(State.class);

    TransitionMatrix() {
        {
            matrixContainer.put(START, EnumSet.of(NUMBER));
            matrixContainer.put(NUMBER, EnumSet.of(FINISH));
        }
    }

    Set<State> getPossibleStates(State current) {
        return matrixContainer.get(current);
    }

    State getStartState() {
        return START;
    }

    State getFinishState() {
        return FINISH;
    }

}
