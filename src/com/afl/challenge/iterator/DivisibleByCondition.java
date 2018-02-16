package com.afl.challenge.iterator;

/**
 * A condition used to determine whether a number is evenly divisible by another number.
 */
public class DivisibleByCondition implements Condition {

    /**
     * The number to divide by.
     */
    private final int divisibleBy;

    /**
     * Constructor.
     * @param divisibleBy  The number to divide by.
     */
    public DivisibleByCondition(int divisibleBy) {
        this.divisibleBy = divisibleBy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean evaluate(int numberToTest) {
        // % operator returns the remainder after division.
        // Clean division occurs when (x % y) == 0
        return (numberToTest % divisibleBy == 0);
    }

}
