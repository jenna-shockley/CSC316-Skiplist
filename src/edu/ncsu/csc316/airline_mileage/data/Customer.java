/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.data;

import edu.ncsu.csc316.airline_mileage.list.FlightSkipList;

/**
 * Creates a Customer object
 * @author Jenna Shockley
 *
 */
public class Customer {
	
    /** the customer's list of flights */
    private FlightSkipList listOfFlights;
    
    /** the customer's last name */
    private String lastName;
    
    /** the customer's first name */
    private String firstName;
    
    /**
     * The Customer constructor
     * @param firstName the customer's first name
     * @param lastName the customer's last name
     * @param listOfFlights the customer's list of flights
     */
    public Customer(final String firstName, final String lastName,
            final FlightSkipList listOfFlights) {
        this.listOfFlights = listOfFlights;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    /**
     * Gets the list of flights
     * @return the list of flights
     */
    public FlightSkipList getListOfFlights() {
        return listOfFlights;
    }
    
    /**
     * Gets the last name
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Gets the first name
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Adds a flight to the customer's list of flights
     * @param flight the flight to add
     */
    public void addFlight(final Flight flight) {
        listOfFlights.add(flight);
    }
    
    
    /**
     * Gets the number of flights in the list
     * @return the number of flights in the customer's list
     */
    public int getFlightNumber() {
        return listOfFlights.getSize();

    }

}
