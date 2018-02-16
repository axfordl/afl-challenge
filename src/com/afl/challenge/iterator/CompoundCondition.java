package com.afl.challenge.iterator;

import java.util.Arrays;
import java.util.Collection;

/**
 * A condition used to determine whether a number satisfies multiple conditions (using AND logical operator).
 */
public class CompoundCondition implements Condition {

    /**
     * The collection of conditions to check.
     */
    private final Collection<Condition> conditions;

    /**
     * Construct the compound condition.
     * @param conditions  the conditions to check.
     */
    public CompoundCondition(Condition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    /**
     * Static helper method to create a compound condition.
     * @param conditions  the conditions to check.
     * @return  the initialised condition.
     */
    public static CompoundCondition compoundCondition(Condition... conditions) {
        return new CompoundCondition(conditions);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean evaluate(int numberToTest) {
        // The AND condition will fail if any condition evaluates to false.
        for (Condition condition : conditions) {
            if (!condition.evaluate(numberToTest)) {
                return false;
            }
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((conditions == null) ? 0 : conditions.hashCode());
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
        CompoundCondition other = (CompoundCondition) obj;
        if (conditions == null) {
            if (other.conditions != null)
                return false;
        } else if (!conditions.equals(other.conditions))
            return false;
        return true;
    }
}
