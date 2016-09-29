package ua.com.mathutils.calculator.impl.function;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Contain all available functions.
 */
public class FunctionContainer {
    private final Map<String, Function> functions = new HashMap<>();

    public FunctionContainer() {
        functions.put("min", new Minimum());
        functions.put("max", new Maximum());
        functions.put("pow", new Power());
        functions.put("pi", new PiFunction());
    }

    public Optional<Function> getFunction(String representation) {
        final Function function = functions.get(representation);
        if (function == null) {
            return Optional.empty();
        }
        return Optional.of(function);
    }

    public Set<String> getAllRepresentations() {
        return functions.keySet();
    }
}
