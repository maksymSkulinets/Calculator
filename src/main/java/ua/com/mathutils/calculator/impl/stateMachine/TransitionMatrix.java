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
            new EnumMap<>(State.class);

    TransitionMatrix() {
        matrixContainer.put(START, EnumSet.of(NUMBER, OPENING_BRACKET,FUNCTION));
        matrixContainer.put(BINARY_OPERATOR, EnumSet.of(NUMBER, OPENING_BRACKET,FUNCTION));
        matrixContainer.put(NUMBER, EnumSet.of(FINISH, BINARY_OPERATOR, CLOSING_BRACKET, FUNCTIONS_SEPARATOR));
        matrixContainer.put(OPENING_BRACKET, EnumSet.of(NUMBER, OPENING_BRACKET));
        matrixContainer.put(CLOSING_BRACKET, EnumSet.of(BINARY_OPERATOR, FINISH, CLOSING_BRACKET));
        matrixContainer.put(FUNCTION, EnumSet.of(NUMBER));
        matrixContainer.put(FUNCTIONS_SEPARATOR, EnumSet.of(NUMBER,FUNCTION));
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
