package com.afl.challenge.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Representation of a children's game.
 * Children stand around in a circle. Starting from a selected child, they count from
 * 1 up to k. The k'th child is eliminated from the circle, and counting starts again.
 * This process repeats until there is only one child remaining in the circle (the winner).
 */
public class StandInCircleGame {

    /**
     * The children who are playing the game, arranged in a circle.
     */
    private final Circle<Child> childrenInACircle;

    /**
     * The number of children to count before a player is eliminated.
     */
    private final int numChildrenToSkip;

    /**
     * Set up the game.
     * @param childrenPlaying  the children who are playing the game, in the order that they are standing.
     * @param k  the number of children to count before a player is eliminated.
     */
    public StandInCircleGame(Collection<Child> childrenPlaying, int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("k must be a positive integer");
        }
        this.childrenInACircle = new Circle<Child>(childrenPlaying);
        this.numChildrenToSkip = k;
    }

    /**
     * Returns an ordered list of children who played the game, from the first
     * child eliminated up until the last child standing.
     * The winning child will reside at the end of the list.
     * @return  a list of children in order from first eliminated to last standing.
     */
    public List<Child> playGame() {

        List<Child> eliminatedChildren = new ArrayList<Child>(childrenInACircle.getSize());

        if (childrenInACircle.getSize() > 0) {
            while(childrenInACircle.getSize() > 1) {

                for (int i = 1; i < numChildrenToSkip; i++) {
                    childrenInACircle.next();
                }
                Child eliminatedChild = childrenInACircle.removeCurrent();
                eliminatedChildren.add(eliminatedChild);
            }

            // The winner is the last child remaining in the circle, and will be the last child in the list.
            Child winningChild = childrenInACircle.removeCurrent();
            eliminatedChildren.add(winningChild);
        }

        return eliminatedChildren;
    }

}
