package edu.ncsu.csc316.airline_mileage.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Date;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.list.FlightSkipList;

/**
 * Tests the FlightReader class
 * @author Jenna Shockley
 *
 */
public class FlightReaderTest {

    /**
     * Tests the FlightReader class using given file
     */
    @Test
    public void test() {
        @SuppressWarnings("deprecation")
        Flight f1 = new Flight(new Date(2015, 12, 20), "UA", 346, "ORD",
                "MIA", 1197);
        @SuppressWarnings("deprecation")
        Flight f2 = new Flight(new Date(2015, 7, 26), "DL", 1233, "ATL",
                "ORF", 516);
        @SuppressWarnings("deprecation")
        Flight f3 = new Flight(new Date(2015, 1, 27), "B6", 1316, "FLL",
                "JAX", 319);
        try {
            FlightReader r = new FlightReader();
            assertTrue(r != null); 
            FlightSkipList flights = FlightReader.readFlightFile("input/flight_file.txt");
            assertEquals(f1.getAirline(), ((Flight) flights.lookUp("UA", "ORD", "MIA", 346)).getAirline());
            assertEquals(f1.getFlightNumber(), ((Flight) flights.lookUp("UA", "ORD", "MIA", 346)).getFlightNumber());
            assertEquals(f2.getAirline(), ((Flight) flights.lookUp("DL", "ATL", "ORF", 1233)).getAirline());
            assertEquals(f2.getFlightNumber(), ((Flight) flights.lookUp("DL", "ATL", "ORF", 1233)).getFlightNumber());
            assertEquals(f3.getAirline(), ((Flight) flights.lookUp("B6", "FLL", "JAX", 1316)).getAirline());
            assertEquals(f3.getFlightNumber(), ((Flight) flights.lookUp("B6", "FLL", "JAX", 1316)).getFlightNumber());
        } catch (FileNotFoundException e) {
            fail();
        }
        
    }

}
