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

}
