package com.afl.challenge.iterator;

/**
 * Class used to check whether a number fulfills a certain condition. The condition checked
 * must relate to properties of the number, for example, whether it is odd, whether it is
 * divisible by 5, whether it is greater than 2, whether it is prime, whether it is positive, etc.
 */
public interface Condition {

    /**
     * Evaluates whether the provided number fulfills this condition.
     * @param numberToTest  the number to evaluate the condition for.
     * @return  {@code true} if the number satisfies the condition,
     *          {@code false} otherwise.
     */
    boolean evaluate(int numberToTest);

}
