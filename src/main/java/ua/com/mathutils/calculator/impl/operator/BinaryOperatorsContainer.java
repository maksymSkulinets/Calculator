package ua.com.mathutils.calculator.impl.operator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BinaryOperatorsContainer {

    private final Map<Character, BinaryOperator> operatorsContainer = new HashMap<>();

    public BinaryOperatorsContainer() {
        operatorsContainer.put('+', new Addition());
        operatorsContainer.put('-', new Subtraction());
        operatorsContainer.put('*', new Multiplication());
        operatorsContainer.put('/', new Division());
    }

    public Optional<BinaryOperator> getOperator(Character representation) {
        final BinaryOperator operator = operatorsContainer.get(representation);
        if (operator == null) {
            return Optional.empty();
        }
        return Optional.of(operator);
    }
}
