package ua.com.mathutils.calculator.impl.parser;

import ua.com.mathutils.calculator.impl.stateMachine.State;

import java.util.HashMap;
import java.util.Map;

import static ua.com.mathutils.calculator.impl.stateMachine.State.*;

public class ParserFactory {

    private final Map<State, Parser> parserContainer = new HashMap<>();

    public ParserFactory() {
        parserContainer.put(NUMBER, new NumberParser());
        parserContainer.put(BINARY_OPERATOR, new BinaryOperatorParser());
        parserContainer.put(FINISH, new FinishParser());
        parserContainer.put(OPENING_BRACKET, new OpeningBracketParser());
        parserContainer.put(CLOSING_BRACKET, new ClosingBracketParser());
        parserContainer.put(FUNCTIONS_SEPARATOR, new FunctionsSeparatorParser());
        parserContainer.put(FUNCTION, new FunctionParser());
    }

    public Parser getParser(State state) {
        return parserContainer.get(state);
    }
}
