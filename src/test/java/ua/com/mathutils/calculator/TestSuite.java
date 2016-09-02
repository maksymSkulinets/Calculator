package ua.com.mathutils.calculator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        NumberInputTest.class,
        BinaryOperatorsTest.class,
        FunctionalityTest.class,
        BracketsTest.class,
        FunctionTest.class
})

public class TestSuite {
}
