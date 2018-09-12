/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.data;

import java.util.Date;

/**
 * Creates a flight object
 * @author Jenna Shockley
 *
 */
public class Flight {
    /** the date of the flight */
    private Date date;
    
    /** the airline of the flight */
    private String airline;
    
    /** the number of the flight */
    private int flightNumber;
    
    /** the origin airport of the flight */
    private String originAirport;
    
    /** the destination airport of the flight */
    private String destinationAirport;

    /** the flight distance */
    private int miles;

    /**
     * The flight constructor
     * @param date the date of the flight
     * @param airline the airline of the flight
     * @param flightNumber the number of the flight
     * @param originAirport the origin airport of the flight
     * @param destinationAirport the destination airport of the flight
     * @param miles the distance of the flight
     */
    public Flight(final Date date, final String airline, final int flightNumber, final String originAirport,
            final String destinationAirport, final int miles) {
        super();
        this.date = date;
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.miles = miles;

    }
    /**
     * Gets the date
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Gets the airline
     * @return the airline
     */
    public String getAirline() {
        return airline;
    }
    /**
     * Gets the flight number
     * @return the flightNumber
     */
    public int getFlightNumber() {
        return flightNumber;
    }
    /**
     * Gets the origin airport
     * @return the originAirport
     */
    public String getOriginAirport() {
        return originAirport;
    }
    /**
     * Gets the destination airport
     * @return the destinationAirport
     */
    public String getDestinationAirport() {
        return destinationAirport;
    }

    /**
     * Gets the distance
     * @return the miles
     */
    public int getMiles() {
        return miles;
    }

    
}
