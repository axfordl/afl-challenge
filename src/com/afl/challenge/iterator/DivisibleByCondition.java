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
     * Static helper method to create a divisible by condition.
     * @param divisibleBy  The number to divide by.
     * @return  the initialised condition.
     */
    public static DivisibleByCondition divisibleBy(int divisibleBy) {
        return new DivisibleByCondition(divisibleBy);
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

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + divisibleBy;
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DivisibleByCondition other = (DivisibleByCondition) obj;
        if (divisibleBy != other.divisibleBy)
            return false;
        return true;
    }

}
