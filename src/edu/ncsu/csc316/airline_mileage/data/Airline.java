/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.data;

/**
 * Creates an airline object
 * @author Jenna Shockley
 *
 */
public class Airline {
    /** the name of the airline */
    private String description;
    
    /** the airline IATA code */
    private String iataCode;
    
    /** the airline's callsign */
    private String callsign;
    
    /** the country of the airline */
    private String country;
    
    /**
     * The constructor for an airline
     * @param description the name of the airline
     * @param iataCode the airline IATA code
     * @param callsign the airline's callsign
     * @param country the country of the airline
     */
    public Airline(final String description, final String iataCode, final String callsign, final String country) {
        this.description = description;
        this.iataCode = iataCode;
        this.callsign = callsign;
        this.country = country;
    }
    
    /**
     * Gets the IATA code
     * @return the IATA Code
     */
    public String getIATACode() {
        return iataCode;
    }
    
    /**
     * Gets the name 
     * @return the name
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Gets the callsign
     * @return the callsign
     */
    public String getCallsign() {
        return callsign;
    }
    
    /**
     * Gets the country
     * @return the country
     */
    public String getCountry() {
        return country;
    }
}
