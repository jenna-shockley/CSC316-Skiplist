package edu.ncsu.csc316.airline_mileage.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Date;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.list.CustomerSkipList;
import edu.ncsu.csc316.airline_mileage.list.FlightSkipList;

/**
 * Tests the CustomerReader class
 * @author Jenna Shockley
 *
 */
public class CustomerReaderTest {

    /**
     * Tests the Customer Reader class using given file
     */
    @SuppressWarnings("deprecation")
    @Test
    public void test() {
        FlightSkipList f1 = new FlightSkipList();
        f1.add(new Flight(new Date(2015, 12, 20), "UA", 346, "ORD", 
            "MIA", 0));
        f1.add(new Flight(new Date(2015, 7, 26), "DL", 1233, "ATL",
                "ORF", 0));
        f1.add(new Flight(new Date(2015, 1, 27), "B6", 1316, "FLL",
                "JAX", 0));
        f1.add(new Flight(new Date(2015, 12, 20), "UA", 346, "ORD",
                "MIA", 0));
        f1.add(new Flight(new Date(2015, 12, 20), "UA", 346, "ORD",
                "MIA", 0));
        
        FlightSkipList f2 = new FlightSkipList();
        f2.add(new Flight(new Date(2015, 12, 20), "UA", 346, "ORD",
                "MIA", 0));
        f2.add(new Flight(new Date(2015, 12, 20), "UA", 346, "ORD",
                "MIA", 0));
        f2.add(new Flight(new Date(2015, 12, 20), "UA", 346, "ORD",
                "MIA", 0));
        f2.add(new Flight(new Date(2015, 12, 20), "UA", 346, "ORD",
                "MIA", 0));
        f2.add(new Flight(new Date(2015, 12, 20), "UA", 346, "ORD",
                "MIA", 0));
        
        //Customer c2 = new Customer("Kassandra", "Stiltner", f2);
        //Customer c1 = new Customer("Erick", "Mcfarland", f1);
        
        try {
            CustomerReader r = new CustomerReader();
            assertTrue(r != null);
            CustomerSkipList customers = CustomerReader.readCustomerFile("input/customer_file.txt");
            assertEquals(2, customers.getSize());
            assertEquals(5, ((Customer) customers.lookUp("Stiltner", "Kassandra")).getFlightNumber());
            assertEquals(5, ((Customer) customers.lookUp("Mcfarland", "Erick")).getFlightNumber());
            
        } catch (FileNotFoundException | ParseException e) {
            fail();
        }
    }

}
