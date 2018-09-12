/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.list.FlightSkipList;

/**
 * Reads a file of flights and creates a skip list of all of the flights
 * @author Jenna Shockley
 *
 */
public class FlightReader {
    /**
     * Reads a flight file and creates the skip list of flights
     * @param fileName the name of the file to read
     * @return the skip list of flights
     * @throws FileNotFoundException if the file does not exist
     */
    public static FlightSkipList readFlightFile(final String fileName) throws FileNotFoundException {
        final Scanner fileReader = new Scanner(new File(fileName));
        final FlightSkipList flights = new FlightSkipList();
        while (fileReader.hasNextLine()) {
            try {
                final Flight flight = readFlight(fileReader.nextLine());

                flights.add(flight);
            } catch (final IllegalArgumentException e) {
                //skip the line
            }
        }
        fileReader.close();
        return flights;
    }
    
    /**
     * Helper method that gets data from a line and creates a flight object
     * @param nextLine the line to read
     * @return the flight object
     * @throws IllegalArgumentException if there is a wrong data type
     */
    public static Flight readFlight(final String nextLine) throws IllegalArgumentException {
        final Scanner lineReader = new Scanner(nextLine);
        Flight flight;
        try {
            lineReader.useDelimiter(",");
            final int year = lineReader.nextInt();
            final int month = lineReader.nextInt();
            final int day = lineReader.nextInt();
            @SuppressWarnings("deprecation")
            final Date date = new Date(year, month, day);
            lineReader.nextInt();
            final String airline = lineReader.next();
            final int flightNumber = lineReader.nextInt();
            final String origin = lineReader.next();
            final String destination = lineReader.next();
            lineReader.nextInt();
            lineReader.nextInt();
            final int distance = lineReader.nextInt();
            lineReader.nextInt();
            lineReader.nextInt();
            
            
            lineReader.close();
            flight = new Flight(date, airline, flightNumber, origin, 
                    destination, distance);
            
            return flight;
        } catch (final NoSuchElementException e) {
            throw new IllegalArgumentException();
        }
    }
}
