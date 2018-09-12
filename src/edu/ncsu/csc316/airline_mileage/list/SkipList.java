/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.list;

import java.util.Random;

/**
 * Abstract class for a Skip List
 * @author Jenna Shockley
 *
 */
public abstract class SkipList {
    
    /** the head (top left) skip node */
    protected SkipNode head;
    
    /** elements in the skip list */
    protected int size;
    
    /** the index of the highest level of the skip list starting at 0 */
    protected int maxLevel;

    /** the probability value for random level */
    protected static final double PROBABILITY = 0.5;
    
    /**
     * the SkipList constructor
     */
    public SkipList() {
        size = 0;
        maxLevel = 0;
        head = new SkipNode(null); 
    }
    
    /**
     * Abstract method to add value into skip list
     * @param o the object to add
     */
    public abstract void add(Object o);
    
    /**
     * Checks if the skip list is empty
     * @return true if the list is empty
     */
    public boolean isEmpty() {
        return head.right == null && head.down == null;
    }
    
    
    /**
     * Class that creates a SkipNode object
     * @author Jenna Shockley
     *
     */
    public class SkipNode {
        /** the element(object) of the skip node */
        Object element;
        
        /** the skip node to the right */
        SkipNode right;
        
        /** the skip node below */
        SkipNode down;
        
        /**
         * SkipNode constructor
         * @param o the element of the skip node
         */
        public SkipNode(final Object o) {
            this(o, null, null);
        }
        
        /**
         * SkipNode constructor
         * @param o the element of the skip node
         * @param right the skip node to the right
         * @param down the skip node below
         */
        public SkipNode(final Object o, final SkipNode right, final SkipNode down) {
            element = o;
            this.right = right;
            this.down = down;
        }
    }
    
    /**
     * Method to compare alphabetical order of strings
     * @param a the first string to compare
     * @param b the second string to compare
     * @return true if a comes before b
     */
    protected boolean lessThan(String a, String b) {
    return a.compareTo(b) < 0;
    }


    /**
     * Returns a random level to start inserting object into skip list
     * @return the level to start insertion on
     */
    protected int randomLevel() {
        final Random rand = new Random();
        int level = 0;
        while(rand.nextDouble() < PROBABILITY && level <= maxLevel){
            level++;
        }
        if (level == maxLevel) {
            adjustHead();
        }
        return level;
    }
    
    /**
     * Adjust the head of the list up one creating 
     * another level 
     */
    protected void adjustHead() {
        SkipNode temp = head;
        head = new SkipNode(null, null, temp);
        maxLevel++;
    }
    
    /**
     * Gets the number of elements in the skip list
     * @return the number of elements
     */
    public int getSize() {
        return size;
    }
    
    
}
