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
     * {@inheritDoc}
     */
    @Override
    public boolean evaluate(int numberToTest) {
        return !conditionToInvert.evaluate(numberToTest);
    }

}

