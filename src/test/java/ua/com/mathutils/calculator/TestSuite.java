package ua.com.mathutils.calculator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ua.com.mathutils.calculator.impl.operator.BinaryOperator;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        NumberInputTest.class,
        BinaryOperatorsTest.class,
        FunctionalityTest.class})

public class TestSuite {
}
