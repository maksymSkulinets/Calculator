package ua.com.mathutils.calculator.impl.operator;

/**
 * Binary operator abstract instance with priority comparison.
 */
public abstract class BinaryOperator implements Comparable<BinaryOperator> {

    private final Priority priority;

    BinaryOperator(Priority priority) {
        this.priority = priority;
    }

    public abstract Double execute(Double leftOperand, Double rightOperand);

    @Override
    public int compareTo(BinaryOperator that) {
        return this.priority.compareTo(that.priority);
    }

}
