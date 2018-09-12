/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.list.CustomerSkipList;
import edu.ncsu.csc316.airline_mileage.list.FlightSkipList;

/**
 * Reads a file with a list of customer flights and creates a skip list of customers
 * @author Jenna Shockley
 *
 */
public class CustomerReader {
    
    /**
     * Reads the customer file and creates a skip list of customers
     * @param fileName the name of the file to be read
     * @return the skip list of customers
     * @throws FileNotFoundException if the file does not exist
     * @throws ParseException if the file has wrong data type
     */
    public static CustomerSkipList readCustomerFile(final String fileName) throws FileNotFoundException, ParseException {
        final Scanner fileReader = new Scanner(new File(fileName));
        final CustomerSkipList customers = new CustomerSkipList();
        boolean first = true;
        Scanner lineReader;
        while (fileReader.hasNextLine()) {
            try {
                if(first) {
                    fileReader.nextLine();
                    first = false;
                }
                lineReader = new Scanner(fileReader.nextLine()); 
                try {
                    lineReader.useDelimiter(",");
                    final String firstName = lineReader.next();
                    final String lastName = lineReader.next();
                    final String dateString = lineReader.next();
                    final DateFormat formatter = new SimpleDateFormat(dateString);
                    final Date date = (Date)formatter.parse(dateString);
                    final String str = lineReader.next();
                    final String airline = Character.toString(str.charAt(0)) + Character.toString(str.charAt(1));
                    final int flightNumber = (int) Integer.parseInt(str.substring(2));
                    final String origin = lineReader.next();
                    final String destination = lineReader.next();
                    
                    final Flight f = new Flight(date, airline, flightNumber, origin, destination, 0);
                    Customer c = (Customer) customers.lookUp(lastName, firstName);
                    if (c == null) {
                        c = new Customer(firstName, lastName, new FlightSkipList());
                        customers.add(c);
                    }
                    c.addFlight(f);
                    
                    lineReader.close();
                    
                } catch (final NoSuchElementException e) {
                    throw new IllegalArgumentException();
                }
            } catch (final IllegalArgumentException e) {
                //skip the line
            }
        }
        fileReader.close();
        return customers;
    }
}