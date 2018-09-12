/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.data;

/**
 * Creates a miles object
 * @author Jenna Shockley
 *
 */
public class Miles {
	
    /** airline code */
    String iataCode;
    
    /** miles on airline */
    int miles;
    
    /**
     * Miles constructor
     * @param miles airline miles
     * @param iataCode airline code
     */
    public Miles(final int miles, final String iataCode) {
        this.iataCode = iataCode;
        this.miles = miles;
    }

    /**
     * Gets the airline code
     * @return the iataCode
     */
    public String getIataCode() {
        return iataCode;
    }

    /**
     * Gets the miles
     * @return the miles
     */
    public int getMiles() {
        return miles;
    }

}
