package com.afl.challenge.iterator;

import java.util.HashMap;
import java.util.Map;

/**
 * Checks a number against a collection of stored conditions, returning an output string corresponding
 * to the conditions which matched.
 */
public class NumberChecker {

    /**
     * The number checker may be initialised with conditions which are not mutually exclusive.
     * In such cases, multiple conditions may evaluate to true for a tested number. We return
     * a known string in this case, rather than concatenating results or returning empty.
     */
    public static final String INDETERMINATE_RESULT = "???";

    /**
     * If a tested number matches no conditions, return an empty string.
     */
    public static final String NO_RESULT = "";

    /**
     * Mapping of conditions to the output required when the condition evaluates true.
     */
    private final Map<Condition, String> conditionToOutputMap = new HashMap<Condition, String>();

    /**
     * Adds a rule to the number checker. Duplicate conditions will be replaced.
     * @param condition  the condition to evaluate.
     * @param matchingOutput  the string to be displayed if the condition evaluates true.
     */
    public void addRule(Condition condition, String matchingOutput) {
        conditionToOutputMap.put(condition, matchingOutput);
    }

    /**
     * Returns a string representing the conditions which matched this number.
     * NOTE: the NumberChecker may have been initialised with conditions which are
     * not mutually exclusive. If multiple conditions evaluate to true for the tested number,
     * the result will be indeterminate ("???").
     * @param number
     * @return  the result of checking this number.
     */
    public String checkNumber(int number) {
        String result = NO_RESULT;

        for (Condition condition : conditionToOutputMap.keySet()) {
            if (!INDETERMINATE_RESULT.equals(result)) {
                boolean conditionMatches = condition.evaluate(number);
                if (conditionMatches) {
                    if (NO_RESULT.equals(result)) {
                        result = conditionToOutputMap.get(condition);
                    }
                    else {
                        // We have had multiple matches for this number.
                        result = INDETERMINATE_RESULT;
                    }
                }
            }
        }

        return result;
    }

}
