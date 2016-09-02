package ua.com.mathutils.calculator.impl.operator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Contain all available operators.
 */
public class BinaryOperatorsContainer {

    private final Map<Character, BinaryOperator> operatorsContainer = new HashMap<>();

    public BinaryOperatorsContainer() {
        operatorsContainer.put(Addition.getRepresentation(), new Addition());
        operatorsContainer.put(Subtraction.getRepresentation(), new Subtraction());
        operatorsContainer.put(Multiplication.getRepresentation(), new Multiplication());
        operatorsContainer.put(Division.getRepresentation(), new Division());
    }

    public Optional<BinaryOperator> getOperator(Character representation) {
        final BinaryOperator operator = operatorsContainer.get(representation);
        if (operator == null) {
            return Optional.empty();
        }
        return Optional.of(operator);
    }
}
