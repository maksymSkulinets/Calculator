package ua.com.mathutils.calculator.impl.stateMachine;

/**
 * Enumeration of all correct states of finite state machine.
 */
public enum State {
    START,
    NUMBER,
    BINARY_OPERATOR,
    OPENING_BRACKET,
    CLOSING_BRACKET,
    FUNCTION,
    FUNCTIONS_SEPARATOR,
    FINISH
}
