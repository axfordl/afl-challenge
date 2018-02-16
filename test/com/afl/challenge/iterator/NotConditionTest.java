package com.afl.challenge.iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

/**
 * Unit tests for {@link NotCondition}.
 */
public class NotConditionTest {

    /**
     * Tests inverting false -> true.
     */
    @Test
    public void testEvaluateTrue() {
        int numberToEvaluate = 5;
        Condition falseCondition = createCondition(false, numberToEvaluate);
        NotCondition notCondition = new NotCondition(falseCondition);
        assertThat(notCondition.evaluate(numberToEvaluate), is(true));
    }

    /**
     * Tests inverting true -> false.
     */
    @Test
    public void testEvaluateFalse() {
        int numberToEvaluate = 5;
        Condition trueCondition = createCondition(true, numberToEvaluate);
        NotCondition notCondition = new NotCondition(trueCondition);
        assertThat(notCondition.evaluate(numberToEvaluate), is(false));
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

}
