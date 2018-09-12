/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.io;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;


import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.list.AirlineSkipList;
/**
 * Reads data from a file with a list of airlines
 * @author Jenna Shockley
 *
 */
public class AirlineReader {


    /**
     * Reads data from an file with a list of airlines and creates an airline skip list
     * @param fileName the name of the file to read from
     * @return a skip list with all of the airlines
     * @throws FileNotFoundException if the file does not exist
     */
    public static AirlineSkipList readAirlineFile(final String fileName) throws FileNotFoundException {
        final Scanner fileReader = new Scanner(new File(fileName));
        final AirlineSkipList airlines = new AirlineSkipList();
        boolean first = true;
        while (fileReader.hasNextLine()) {
            try {
                if (first) {
                    fileReader.nextLine();
                    first = false;
                }
                final Airline airline = readAirline(fileReader.nextLine());

                airlines.add(airline);
            } catch (final IllegalArgumentException e) {
                //skip the line
            }
        }
        fileReader.close();
        return airlines;
    }
    
    /**
     * Helper method that gets airline data from each line and returns the airline object
     * @param nextLine the line to be read
     * @return the airline object based on the info in the line
     * @throws IllegalArgumentException if the line has illegal data types
     */
    public static Airline readAirline(final String nextLine) throws IllegalArgumentException {
        final Scanner lineReader = new Scanner(nextLine);
        Airline airline;
        try {
            lineReader.useDelimiter(",");
            final String description = lineReader.next();
            final String iataCode = lineReader.next();
            final String callsign = lineReader.next();
            final String country = lineReader.next();
            
            lineReader.close();
            airline = new Airline(description, iataCode, callsign, country);
            
            return airline;
        } catch (final NoSuchElementException e) {
            throw new IllegalArgumentException();
        }
    }
}
