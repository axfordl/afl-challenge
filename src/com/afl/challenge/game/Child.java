package com.afl.challenge.game;

/**
 * POJO representing a child playing a game.
 */
public class Child {

    /**
     * The number used to identify the child.
     */
    private int id;

    /**
     * Create the child data.
     * @param id  the number used to identify the child.
     */
    public Child(int id) {
        this.id = id;
    }

    /**
     * Get the number used to identify the child.
     * @return  the child's id.
     */
    public int getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Child other = (Child) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
