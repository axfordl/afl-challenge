package com.afl.challenge.game;

import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Implementation of the {@link ICircle} interface using a queue.

 * @param <T>  the type of item stored in the circle.
 */
public class Circle<T> implements ICircle<T> {

    /**
     * The items in the circle.
     */
    private final Queue<T> items;

    /**
     * Creates the circle from the provided collection of items.
     * @param itemsToArrange  the items to arrange into a circle.
     */
    public Circle(Collection<T> itemsToArrange) {
        this.items = new LinkedList<T>(itemsToArrange);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize() {
        return items.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getCurrent() {
        T currentItem = items.peek();
        if (currentItem == null) {
            throw new NoSuchElementException("Circle is empty");
        }
        return items.peek();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T removeCurrent() {
        return items.remove();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void next() {
        T cycledItem = items.remove();
        items.add(cycledItem);
    }

}
