package com.afl.challenge.test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.afl.challenge.iterator.DivisibleByCondition;

/**
 * Parameterized tests for {@link DivisibleByCondition}.
 */
@RunWith(Parameterized.class)
public class DivisibleByConditionTest {

    /**
     * The number to evaluate in this test.
     */
    private int numberToEvaluate;

    /**
     * The number to divide by in this test.
     */
    private int divideBy;

    /**
     * The expected result of this test.
     */
    private boolean expectedResult;

    /**
     * Constructs the parameterized test.
     * @param numberToEvaluate  the number to evaluate in this test.
     * @param divideBy  the number to divide by in this test.
     * @param expectedResult  the expected result of this test.
     */
    public DivisibleByConditionTest(int numberToEvaluate, int divideBy, boolean expectedResult) {
        this.numberToEvaluate = numberToEvaluate;
        this.divideBy = divideBy;
        this.expectedResult = expectedResult;
    }

    /**
     * Perform the test using the parameterized data and expected results.
     */
    @Test
    public void testEvaluate() {

        DivisibleByCondition conditionToTest = new DivisibleByCondition(divideBy);
        boolean result = conditionToTest.evaluate(numberToEvaluate);

        assertThat("For " + numberToEvaluate + " divided by " + divideBy, result, is(expectedResult));
    }

    /**
     * Parameterized test data.
     * @return  the test data to use.
     */
    @SuppressWarnings("rawtypes")
    @Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][] {
            {1, 1, true},
            {2, 1, true},
            {3, 1, true},

            {100, 2, true},
            {100, 5, true},
            {100, 3, false},
            {100, 7, false},
            {100, 25, true},
            {100, 100, true},
            {100, 200, false},

            {-100, 2, true},
            {-100, 5, true},
            {-100, 3, false},
            {-100, 7, false},
            {-100, 25, true},
            {-100, 100, true},
            {-100, 200, false},
        });
    }

}
