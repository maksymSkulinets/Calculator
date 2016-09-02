package ua.com.mathutils.calculator.impl.function;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FunctionContainer {
    private final Map<String, Function> functions = new HashMap<>();

    public FunctionContainer() {
        functions.put("min(", new Minimum());
    }

    public Optional<Function> getFunction(String representation) {
        final Function function = functions.get(representation);
        if (function == null) {
            return Optional.empty();
        }
        return Optional.of(function);
    }
}
