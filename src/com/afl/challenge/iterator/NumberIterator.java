package com.afl.challenge.iterator;

import static com.afl.challenge.iterator.CompoundCondition.compoundCondition;
import static com.afl.challenge.iterator.DivisibleByCondition.divisibleBy;
import static com.afl.challenge.iterator.NotCondition.not;

import java.util.Scanner;

/**
 * Application for iterating over numbers to provide output.
 * Prompts the user for the number (n) to iterate up until. Outputs the numbers from 0 to n which match the rules:
 * - outputs "FOO" when the number is divisible by 3
 * - outputs "BAR" when the number is divisible by 5
 * - outputs "BAZ" when the number is divisible by both 3 and 5.
 */
public class NumberIterator {

    /**
     * Main application entry point.
     * @param args  unused.
     */
    public static void main(String[] args) {

        // Initialise the number checker
        NumberChecker numberChecker = new NumberChecker();
        numberChecker.addRule(compoundCondition(divisibleBy(3), not(divisibleBy(5))), "FOO");
        numberChecker.addRule(compoundCondition(divisibleBy(5), not(divisibleBy(3))), "BAR");
        numberChecker.addRule(compoundCondition(divisibleBy(3), divisibleBy(5)), "BAZ");


        Scanner scanner = new Scanner(System.in);
        int numberToIterateUntil = promptForPositiveInteger(scanner);
        scanner.close();

        // Should all iterated numbers be output, or just the ones which have output?
        boolean outputAllIterations = false;

        for (int i = 0; i <= numberToIterateUntil; i++) {
            String result = numberChecker.checkNumber(i);

            if (!result.equals(NumberChecker.NO_RESULT) || outputAllIterations) {
                System.out.println(i + " " + result);
            }
        }
    }

    /**
     * Prompts for a positive integer.
     * @param scanner  the scanner used to read an integer.
     * @return  the positive integer.
     */
    private static int promptForPositiveInteger(Scanner scanner) {
        boolean validInput = false;
        int positiveInteger = -1;
        while(!validInput) {
            System.out.println("Please specify number to iterate until: ");
            String input = scanner.nextLine();

            try {
                positiveInteger = Integer.valueOf(input);

                if (positiveInteger <= 0) {
                    throw new IllegalArgumentException("Negative number provided " + positiveInteger);
                }

                validInput = true;

            } catch (IllegalArgumentException e) {
                validInput = false;
                System.err.println("Number to iterate until must be positive integer (was " + input + ")");
            }
        }
        return positiveInteger;
    }
}
