/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.list;

import edu.ncsu.csc316.airline_mileage.data.Flight;

/**
 * Creates a flight skip list ordered by airline IATA code first
 * and then by flight number
 * @author Jenna Shockley
 *
 */
public class FlightSkipList extends SkipList {

    /**
     * FlightSkipList constructor
     */
    public FlightSkipList() {
        super();
    }

    /**
     * Adds a flight object to the skip list
     * @param o the flight object to add
     */
    @Override
    public void add(final Object o) {
        final Flight f = (Flight)o;
        SkipNode currentNewNode = null;
        size++;
        final int level = randomLevel();
        SkipNode current = head;
        int currentLevel = maxLevel;


        while (currentLevel >= 0) {
            while (current.right != null 
                    && lessThan(((Flight) current.right.element).getAirline(), f.getAirline())) {
                current = current.right;
            } 
            while (current.right != null && ((Flight) current.right.element).getAirline().equals(f.getAirline())
                    && ((Flight) current.right.element).getFlightNumber() < f.getFlightNumber()) {
                current = current.right;
            }
            while (current.right != null && 
                    ((Flight) current.right.element).getAirline().equals(f.getAirline())
                    && ((Flight) current.right.element).getFlightNumber() == f.getFlightNumber()
                    && lessThan(((Flight) current.right.element).getOriginAirport(), f.getOriginAirport())) {
                current = current.right;
            }
            while (current.right != null && 
                    ((Flight) current.right.element).getAirline().equals(f.getAirline())
                    && ((Flight) current.right.element).getFlightNumber() == f.getFlightNumber()
                    && ((Flight) current.right.element).getOriginAirport().equals(f.getOriginAirport())
                    && lessThan(((Flight) current.right.element).getDestinationAirport(), f.getDestinationAirport())) {
                current = current.right;
            }

            if (currentLevel <= level) {
                current.right = new SkipNode(f, current.right, null);
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
     * Looks up a flight object in the skip list using its airline
     * IATA code and its flight number
     * @param airline the airline IATA code
     * @param origin the origin airport
     * @param destination the destination airport
     * @param flightNum the flight number
     * @return the flight object
     */
    public Object lookUp(final String airline, final String origin, final String destination, final int flightNum) {
        if (isEmpty()) {
            return null;
        }
        int level = maxLevel;
        SkipNode current = head;
        while (level >= 0) {
            while (current.right != null && lessThan(((Flight) current.right.element).getAirline(), airline)) {
                current = current.right;
            } 
            while (current.right != null && 
                    ((Flight) current.right.element).getAirline().equals(airline)
                    && ((Flight) current.right.element).getFlightNumber() < flightNum) {
                current = current.right;
            }
            while (current.right != null && 
                    ((Flight) current.right.element).getAirline().equals(airline)
                    && ((Flight) current.right.element).getFlightNumber() == flightNum
                    && lessThan(((Flight) current.right.element).getOriginAirport(), origin)) {
                current = current.right;
            }
            while (current.right != null && 
                    ((Flight) current.right.element).getAirline().equals(airline)
                    && ((Flight) current.right.element).getFlightNumber() == flightNum
                    && ((Flight) current.right.element).getOriginAirport().equals(origin)
                    && lessThan(((Flight) current.right.element).getDestinationAirport(), destination)) {
                current = current.right;
            }
            if (current.right != null &&
                    ((Flight)current.right.element).getAirline().equals(airline) 
                    && ((Flight)current.right.element).getFlightNumber() == flightNum
                    && ((Flight) current.right.element).getOriginAirport().equals(origin)
                    && ((Flight) current.right.element).getDestinationAirport().equals(destination)) {
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
     * Gets a flight object at index i
     * @param i the index of the flight object
     * @return the flight 
     */
    public Flight get(final int i) {
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
        return (Flight) current.element;
    }

}
