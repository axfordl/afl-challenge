package com.afl.challenge.game;

import java.util.NoSuchElementException;

/**
 * Data structure representing a items arranged in a circle.
 * Each circle should maintain the item which is currently at its head, as well as the
 * total number of items within the circle.
 *
 * Items within a circle are iterated over sequentially from first until last using {@link #next()}.
 * Doing so advances the current head of the circle. When the last item is reached, invoking {@link #next()}
 * will loop back to the beginning, such that iteration recommences at the first item.
 *
 * Items can be removed from the circle using {link #removeCurrent()}. Doing so removes the current
 * head of the circle, and advances the head to the next available item.
 */
public interface ICircle<T> {

    /**
     * Gets the current number of items contained within the circle.
     * @return the total number of items currently in the circle.
     */
    int getSize();

    /**
     * Retrieves the item which is currently the head of the circle.
     * @throws NoSuchElementException if the circle is empty.
     * @return the current head of the circle.
     */
    T getCurrent() throws NoSuchElementException;

    /**
     * Removes the item which is currently at the head of the circle, advancing
     * the current head to the next available item.
     * @throws NoSuchElementException if the circle is empty.
     * @return the current head of the circle.
     */
    T removeCurrent() throws NoSuchElementException;

    /**
     * Advances the head of the circle by one item.
     * @throws NoSuchElementException if the circle is empty.
     */
    void next() throws NoSuchElementException;

}
