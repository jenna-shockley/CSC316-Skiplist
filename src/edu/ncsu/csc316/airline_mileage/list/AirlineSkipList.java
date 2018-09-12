/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.list;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.list.SkipList;

/**
 * Creates an airline skip list ordered 
 * alphabetically by IATA Code
 * @author Jenna Shockley
 *
 */
public class AirlineSkipList extends SkipList {

    /**
     * AirlineSkipList constructor
     */
    public AirlineSkipList() {
        super();
    }

    /**
     * Adds an airline object to the skip list
     * @param o the airline object
     */
    @Override
    public void add(final Object o) {
        final Airline a = (Airline)o;
        SkipNode currentNewNode = null;
        size++;
        final int level = randomLevel();
        int currentLevel = maxLevel;
        SkipNode current = head;


        while (currentLevel >= 0) {
            while (current.right != null && 
                    lessThan(((Airline) current.right.element).getIATACode(), a.getIATACode())) {
                current = current.right;
            } 
            if (currentLevel <= level) {
                current.right = new SkipNode(a, current.right, null);
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
     * Looks up an airline object in the skip list using its IATA code
     * @param iataCode the airline's IATA code
     * @return the airline object
     */
    public Object lookUp(final String iataCode) {
        if (isEmpty()) {
            return null;
        }
        int level = maxLevel;
        SkipNode current = head;
        while (level >= 0) {
            while (current.right != null && lessThan(((Airline) current.right.element).getIATACode(), iataCode)) {
                current = current.right;
            } 
            if (current.right != null && ((Airline)current.right.element).getIATACode().equals(iataCode)) {
                return current.right.element;
                
            } else {
                if (level != 0) {
                    current = current.down;
                }
                level--;
            }
        }
        return null;
    }

    /**
     * Gets an airline at index i
     * @param i the index of the airline
     * @return the airline object
     */
    public Airline get(final int i) {
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
        return (Airline)current.element;
    }
}
