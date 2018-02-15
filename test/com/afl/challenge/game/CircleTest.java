package com.afl.challenge.game;

import static java.lang.Integer.valueOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class CircleTest {

    private Circle<Integer> circleUnderTest;

    /**
     * Setup the test.
     */
    @Before
    public void setup() {
        circleUnderTest = new Circle<Integer>(Arrays.asList(
                valueOf(1),valueOf(2), valueOf(3),
                valueOf(4), valueOf(5), valueOf(6),
                valueOf(7), valueOf(8), valueOf(9),
                valueOf(10), valueOf(11)));
    }

    /**
     * Ensure that the initial size is equal to what we expect.
     */
    @Test
    public void testInitialSize() {
        assertThat(circleUnderTest.getSize(), is(11));
    }

    /**
     * Ensure that the initial head of the circle is equal to what we expect.
     */
    @Test
    public void testInitialHead() {
        assertThat(circleUnderTest.getCurrent(), is(1));
    }

    /**
     * Ensure that invoking next will get us the item we expect.
     */
    @Test
    public void testNext() {
        circleUnderTest.next();
        assertThat(circleUnderTest.getCurrent(), is(2));
    }

    /**
     * Ensure that invoking next many times will cycle us back to the beginning.
     */
    @Test
    public void testNextCycle() {
        for (int i = 0; i < 11; i++) {
            circleUnderTest.next();
        }
        assertThat(circleUnderTest.getCurrent(), is(1));
    }

    /**
     * Ensure that removing an item causes the head to advance.
     */
    @Test
    public void testRemove() {
        circleUnderTest.removeCurrent();
        assertThat(circleUnderTest.getCurrent(), is(2));
    }

    /**
     * Ensure that removing many items causes the circle to be empty.
     */
    @Test
    public void testRemoveCycle() {
        for (int i = 0; i < 11; i++) {
            circleUnderTest.removeCurrent();
        }
        assertThat(circleUnderTest.getSize(), is(0));
    }

    /**
     * Ensure that invoking remove when there are no items left causes exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void testRemoveWhenEmpty() {
        Circle<Integer> emptyCircle = new Circle<Integer>(Collections.emptyList());
        emptyCircle.removeCurrent();
    }

    /**
     * Ensure that invoking getCurrent when there are no items left causes exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void testGetCurrentWhenEmpty() {
        Circle<Integer> emptyCircle = new Circle<Integer>(Collections.emptyList());
        emptyCircle.getCurrent();
    }

    /**
     * Ensure that invoking next when there are no items left causes exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void testNextWhenEmpty() {
        Circle<Integer> emptyCircle = new Circle<Integer>(Collections.emptyList());
        emptyCircle.next();
    }
}
