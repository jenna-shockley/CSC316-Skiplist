/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.manager;

import java.io.FileNotFoundException;
import java.text.ParseException;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.data.Miles;
import edu.ncsu.csc316.airline_mileage.io.AirlineReader;
import edu.ncsu.csc316.airline_mileage.io.CustomerReader;
import edu.ncsu.csc316.airline_mileage.io.FlightReader;
import edu.ncsu.csc316.airline_mileage.list.AirlineSkipList;
import edu.ncsu.csc316.airline_mileage.list.CustomerSkipList;
import edu.ncsu.csc316.airline_mileage.list.FlightSkipList;
import edu.ncsu.csc316.airline_mileage.list.MilesSkipList;

/**
 * Creates the airline mileage manager the will return miles
 * of each customer on each airline
 * @author Jenna Shockley
 *
 */
public class AirlineMileageManager {
    
    /** the skip list of airlines */
    AirlineSkipList airlines;
    
    /** the skip list of flights */
    FlightSkipList flights;
    
    /** the skip list of customers */
    CustomerSkipList customers;
    
    /**
     * Constructs an AirlineMileageManager
     * 
     * @param pathToAirlineFile - path to the airline information file
     * @param pathToCustomerFile - path to the customer information file
     * @param pathToFlightFile - path to the flight information file
     */
    public AirlineMileageManager(final String pathToAirlineFile, final String pathToCustomerFile, final String pathToFlightFile) {
        try {
            airlines = AirlineReader.readAirlineFile(pathToAirlineFile);
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            flights = FlightReader.readFlightFile(pathToFlightFile);
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            customers = CustomerReader.readCustomerFile(pathToCustomerFile);
        } catch (final FileNotFoundException | ParseException e) {
            e.printStackTrace(); 
        }
    }
    
    /**
     * Produces the mileage report for all cardholders
     * as a String, sorted alphabetically by cardholder
     * last name.
     * 
     * @return the mileage report for all customers
     */
    public String getMileageReport() {
        final StringBuilder str = new StringBuilder();
        Customer customer;
        for (int i = 0; i < customers.getSize(); i++) {
            customer = customers.get(i);
            if (i != 0) {
                str.append("\n\n");
            }
            str.append(getMiles(customer.getFirstName(), customer.getLastName()));
        }
        return str.toString();
        
    }
    

    /**
     * Retrieves the frequent flier mileage for the specified
     * cardholder with the given first name and last name.
     * Miles are listed in descending order by distance
     * 
     * @param firstName - the cardholder's first name
     * @param lastName - the cardholder's last name
     * @return the frequent flier mileage information for the cardholder
     */
    public String getMiles (final String firstName, final String lastName) {
        final StringBuilder str = new StringBuilder();
        str.append(firstName);
        str.append(" ");
        str.append(lastName);
        str.append(" earned");
        final Customer c = (Customer) customers.lookUp(lastName, firstName);
        if(c == null) {
            str.append("\n    no miles.");
        } else {
            Airline airline;
            int miles;
            Flight flight;
            final MilesSkipList milesList = new MilesSkipList();
            final FlightSkipList cFlights = c.getListOfFlights();
            for (int j = 0; j < airlines.getSize() ; j++) {
                airline = airlines.get(j);
                miles = 0;
         
                for (int i = 0; i < cFlights.getSize(); i++) {
                    flight = cFlights.get(i);
                    if (flight.getAirline().equals(airline.getIATACode())) {
                        miles += ((Flight) flights.lookUp(airline.getIATACode(), flight.getOriginAirport(), 
                                flight.getDestinationAirport(), flight.getFlightNumber())).getMiles();
                    }
                }
                if (miles != 0) {
                    final Miles m = new Miles(miles, airline.getIATACode());
                    milesList.add(m);
                }
                
                
            }
            Miles object;
            for (int i = 0; i < milesList.getSize(); i++) {
                object = milesList.get(i);
                str.append("\n    ");
                str.append(object.getMiles());
                str.append(" miles with ");
                str.append(((Airline) airlines.lookUp(object.getIataCode())).getDescription());
                str.append(" (");
                str.append(object.getIataCode());
                str.append(")");

            }
        }
        
        return str.toString();
    }
}
