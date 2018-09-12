/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.list;

import edu.ncsu.csc316.airline_mileage.data.Miles;

/**
 * Creates an ordered miles skip list
 * based on distance
 * @author Jenna Shockley
 *
 */
public class MilesSkipList extends SkipList {

    /**
     * MilesSkipList constructor
     */
    public MilesSkipList() {
        super();
    }

    /**
     * Adds a mileage amount
     * @param o the miles object to add
     */
    @Override
    public void add(final Object o) {
        final Miles m = (Miles)o;
        SkipNode currentNewNode = null;
        size++;
        int level = randomLevel();
        int currentLevel = maxLevel;
        SkipNode current = head;


        while (currentLevel >= 0) {
            while (current.right != null && 
                    ((Miles) current.right.element).getMiles() > m.getMiles()) {
                current = current.right;
            } 
            while (current.right != null && 
                    ((Miles) current.right.element).getMiles() == m.getMiles() &&
                    lessThan(((Miles) current.right.element).getIataCode(), m.getIataCode())) {
                current = current.right;
             
            } 
            if (currentLevel <= level) {
                current.right = new SkipNode(m, current.right, null);
                if (currentNewNode != null) {
                    currentNewNode.down = current.right;
                }
                currentNewNode = current.right;
            }
            if (currentLevel > 0) {
                current = current.down;
            }
            currentLevel--;
        }

    }


    
    /**
     * Gets a miles object at index i
     * @param i the index of the miles object
     * @return the miles object
     */
    public Miles get(final int i) {
        SkipNode current = head;
        int level = maxLevel;
        while(level != 0) {
            current = current.down;
            level--;
        }
        current = current.right;
        int pos = 0;
        while (pos != i) {
            current = current.right;
            pos++;
        } 
        return (Miles)current.element;
    }

}
