package com.afl.challenge.iterator;

/**
 * A condition used to invert the result of another condition.
 */
public class NotCondition implements Condition {

    /**
     * The condition to invert.
     */
    private final Condition conditionToInvert;

    /**
     * Construct the inverse condition.
     * @param conditionToInvert  the condition to invert.
     */
    public NotCondition(Condition conditionToInvert) {
        this.conditionToInvert = conditionToInvert;
    }

    /**
     * Static helper method to create a not condition.
     * @param conditionToInvert  the condition to invert.
     * @return  the initialised condition.
     */
    public static NotCondition not(Condition conditionToInvert) {
        return new NotCondition(conditionToInvert);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean evaluate(int numberToTest) {
        return !conditionToInvert.evaluate(numberToTest);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((conditionToInvert == null) ? 0 : conditionToInvert.hashCode());
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
        NotCondition other = (NotCondition) obj;
        if (conditionToInvert == null) {
            if (other.conditionToInvert != null)
                return false;
        } else if (!conditionToInvert.equals(other.conditionToInvert))
            return false;
        return true;
    }

}

