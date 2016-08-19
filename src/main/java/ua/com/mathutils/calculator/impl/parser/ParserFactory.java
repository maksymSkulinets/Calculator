package ua.com.mathutils.calculator.impl.parser;

import ua.com.mathutils.calculator.impl.stateMachine.State;

import java.util.HashMap;
import java.util.Map;

import static ua.com.mathutils.calculator.impl.stateMachine.State.FINISH;
import static ua.com.mathutils.calculator.impl.stateMachine.State.NUMBER;

public class ParserFactory {

    private final Map<State, Parser> parserContainer = new HashMap<>();

    public ParserFactory() {
        {
            parserContainer.put(NUMBER, new NumberParser());
            parserContainer.put(FINISH, new FinishParser());
        }
    }

    public Parser getParser(State state) {
        return parserContainer.get(state);
    }
}
