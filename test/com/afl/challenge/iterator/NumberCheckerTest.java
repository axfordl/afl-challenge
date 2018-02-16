package com.afl.challenge.iterator;

import static com.afl.challenge.iterator.CompoundCondition.compoundCondition;
import static com.afl.challenge.iterator.DivisibleByCondition.divisibleBy;
import static com.afl.challenge.iterator.NotCondition.not;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Unit tests for {@link NumberChecker}.
 *
 */
public class NumberCheckerTest {

    /**
     * Test against an empty number checker.
     */
    @Test
    public void testEmptyChecker() {

        NumberChecker numberChecker = new NumberChecker();
        String result = numberChecker.checkNumber(5);

        assertThat(result, is(NumberChecker.NO_RESULT));
    }

    /**
     * Test when a number satisfies a single rule.
     */
    @Test
    public void testSingleMatch() {

        NumberChecker numberChecker = new NumberChecker();
        numberChecker.addRule(divisibleBy(3), "FOO");
        numberChecker.addRule(divisibleBy(5), "BAR");

        String result = numberChecker.checkNumber(6);

        assertThat(result, is("FOO"));
    }

    /**
     * Test when the checker has been updated with duplicate rules.
     */
    @Test
    public void testUpdatedMatch() {

        NumberChecker numberChecker = new NumberChecker();
        numberChecker.addRule(divisibleBy(3), "FOO");
        numberChecker.addRule(divisibleBy(5), "BAR");
        numberChecker.addRule(divisibleBy(3), "FOO2");

        String result = numberChecker.checkNumber(6);

        assertThat(result, is("FOO2"));
    }

    /**
     * Test when a number satisfies no rule.
     */
    @Test
    public void testNoMatch() {

        NumberChecker numberChecker = new NumberChecker();
        numberChecker.addRule(divisibleBy(3), "FOO");
        numberChecker.addRule(divisibleBy(5), "BAR");

        String result = numberChecker.checkNumber(7);

        assertThat(result, is(NumberChecker.NO_RESULT));
    }

    /**
     * Test when a number satisfies multiple rules.
     */
    @Test
    public void testMultipleMatch() {

        NumberChecker numberChecker = new NumberChecker();
        numberChecker.addRule(divisibleBy(3), "FOO");
        numberChecker.addRule(divisibleBy(5), "BAR");

        String result = numberChecker.checkNumber(15);

        assertThat(result, is(NumberChecker.INDETERMINATE_RESULT));
    }

    /**
     * Test when a the checker has only mutually exclusive rules.
     */
    @Test
    public void testExclusiveMatch() {

        NumberChecker numberChecker = new NumberChecker();
        numberChecker.addRule(compoundCondition(divisibleBy(3), not(divisibleBy(5))), "FOO");
        numberChecker.addRule(compoundCondition(divisibleBy(5), not(divisibleBy(3))), "BAR");
        numberChecker.addRule(compoundCondition(divisibleBy(3), divisibleBy(5)), "BAZ");

        String result = numberChecker.checkNumber(15);

        assertThat(result, is("BAZ"));
    }

}
