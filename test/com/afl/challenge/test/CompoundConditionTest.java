package com.afl.challenge.test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.afl.challenge.iterator.CompoundCondition;
import com.afl.challenge.iterator.Condition;

/**
 * Parameterized tests for {@link CompoundCondition}.
 */
@RunWith(Parameterized.class)
public class CompoundConditionTest {

    /**
     * The number to evaluate in this test.
     */
    private int numberToEvaluate;

    /**
     * The results of the constituent conditions for this test.
     */
    private List<Boolean> constituentResults;

    /**
     * The expected result of this test.
     */
    private boolean expectedResult;

    /**
     * Constructs the parameterized test.
     * @param numberToEvaluate  the number to evaluate in this test.
     * @param constituentResults  the results of the constituent conditions for this test.
     * @param expectedResult  the expected result of this test.
     */
    public CompoundConditionTest(int numberToEvaluate, List<Boolean> constituentResults, boolean expectedResult) {
        this.numberToEvaluate = numberToEvaluate;
        this.constituentResults = constituentResults;
        this.expectedResult = expectedResult;
    }

    /**
     * Perform the test using the parameterized data and expected results.
     */
    @Test
    public void testEvaluate() {

        List<Condition> conditions = new ArrayList<Condition>();
        for (Boolean constituentResult : constituentResults) {
            conditions.add(createCondition(constituentResult, numberToEvaluate));
        }
        Condition[] conditionArray = new Condition[conditions.size()];
        conditions.toArray(conditionArray);

        CompoundCondition conditionToTest = new CompoundCondition(conditionArray);
        boolean result = conditionToTest.evaluate(numberToEvaluate);

        assertThat("For compound results " + constituentResults, result, is(expectedResult));
    }

    /**
     * Helper method which creates a condition which evaluates to a known state.
     * @param evaluatesTo  the result we want the condition to have.
     * @param number  the number which should cause this result.
     * @return  a condition satisfying these constraints.
     */
    private Condition createCondition(boolean evaluatesTo, int number) {
        Condition mockCondition = mock(Condition.class);
        when(mockCondition.evaluate(number)).thenReturn(evaluatesTo);
        return mockCondition;
    }

    /**
     * Parameterized test data.
     * @return  the test data to use.
     */
    @SuppressWarnings("rawtypes")
    @Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][] {
            {1, Arrays.asList(true, true, true), true},
            {1, Arrays.asList(true, false, true), false},
            {1, Arrays.asList(true, false, false), false},
            {1, Arrays.asList(false, false, false), false}
        });
    }

}