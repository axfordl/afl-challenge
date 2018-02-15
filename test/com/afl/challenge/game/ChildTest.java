package com.afl.challenge.game;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Unit tests for {@link Child}.
 */
public class ChildTest {

    /**
     * Test retreival of id.
     */
    @Test
    public void testGetId() {
        Child childUnderTest = new Child(1);
        assertThat(childUnderTest.getId(), is(1));
    }

    /**
     * Test equality.
     */
    @Test
    public void testEqual() {
        Child child1 = new Child(1);
        Child child2 = new Child(1);
        assertThat(child1.equals(child2), is(true));
    }

    /**
     * Test equality.
     */
    @Test
    public void testNotEqual() {
        Child child1 = new Child(1);
        Child child2 = new Child(2);
        assertThat(child1.equals(child2), is(false));
    }

}
