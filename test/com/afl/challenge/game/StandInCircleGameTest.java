package com.afl.challenge.game;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.withSettings;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Parameterized tests for {@link StandInCircleGame}.
 */
@RunWith(Parameterized.class)
public class StandInCircleGameTest {

    /**
     * A child who might be playing the game.
     */
    private static final Child CHILD_1 = mock(Child.class, withSettings().name("CHILD_1"));

    /**
     * A child who might be playing the game.
     */
    private static final Child CHILD_2 = mock(Child.class, withSettings().name("CHILD_2"));

    /**
     * A child who might be playing the game.
     */
    private static final Child CHILD_3 = mock(Child.class, withSettings().name("CHILD_3"));

    /**
     * The children who are playing the game in this test.
     */
    private Collection<Child> childrenPlaying;

    /**
     * The number of children to count before a player is eliminated in this test.
     */
    private int k;

    /**
     * The matcher to use to verify correct results in this test.
     */
    private Matcher<List<Child>> resultMatcher;

    /**
     * Create the current parameterized test.
     * @param childrenPlaying  the children who are playing the game in the order they are standing.
     * @param k  the number of children to count before a player is eliminated.
     * @param resultMatcher  the expected results.
     */
    public StandInCircleGameTest(Collection<Child> childrenPlaying, int k, Matcher<List<Child>> resultMatcher) {
        this.childrenPlaying = childrenPlaying;
        this.k = k;
        this.resultMatcher = resultMatcher;
    }

    /**
     * Perform the test using the parameterized data and expected results.
     */
    @Test
    public void testPlayGame() {

        StandInCircleGame game = new StandInCircleGame(childrenPlaying, k);
        List<Child> actualOrdering = game.playGame();

        assertThat(actualOrdering, resultMatcher);
    }

    /**
     * Parameterized test data.
     * @return  the test data to use.
     */
    @SuppressWarnings("rawtypes")
    @Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][] {
            {emptyList(), 1, empty()},

            {asList(CHILD_1), 1, contains(CHILD_1)},
            {asList(CHILD_1), 2, contains(CHILD_1)},
            {asList(CHILD_1), 3, contains(CHILD_1)},
            {asList(CHILD_1), 4, contains(CHILD_1)},

            {asList(CHILD_1, CHILD_2), 1, contains(CHILD_1, CHILD_2)},
            {asList(CHILD_1, CHILD_2), 2, contains(CHILD_2, CHILD_1)},
            {asList(CHILD_1, CHILD_2), 3, contains(CHILD_1, CHILD_2)},
            {asList(CHILD_1, CHILD_2), 4, contains(CHILD_2, CHILD_1)},

            {asList(CHILD_1, CHILD_2, CHILD_3), 1, contains(CHILD_1, CHILD_2, CHILD_3)},
            {asList(CHILD_1, CHILD_2, CHILD_3), 2, contains(CHILD_2, CHILD_1, CHILD_3)},
            {asList(CHILD_1, CHILD_2, CHILD_3), 3, contains(CHILD_3, CHILD_1, CHILD_2)},
            {asList(CHILD_1, CHILD_2, CHILD_3), 4, contains(CHILD_1, CHILD_3, CHILD_2)},
        });
    }

}
