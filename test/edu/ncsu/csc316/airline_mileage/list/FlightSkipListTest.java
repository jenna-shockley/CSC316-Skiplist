package edu.ncsu.csc316.airline_mileage.list;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Flight;

/**
 * Tests the FlightSkipList class
 * @author Jennna Shockley
 *
 */
public class FlightSkipListTest {
    /** flight object 1 */
    @SuppressWarnings("deprecation")
    Flight f1 = new Flight(new Date(2015, 12, 20), "UA", 346, "ORD",
            "MIA", 1197);
    
    /** flight object 2 */
    @SuppressWarnings("deprecation")
    Flight f2 = new Flight(new Date(2015, 7, 26), "DL", 1233, "ATL",
            "ORF", 516);
     
    /** flight object 3 */
    @SuppressWarnings("deprecation")
    Flight f3 = new Flight(new Date(2015, 1, 27), "B6", 1316, "FLL",
            "JAX", 319);
    
    /** flight object 4 */
    @SuppressWarnings("deprecation")
    Flight f4 = new Flight(new Date(2015, 12, 20), "UA", 1287, "ORD",
            "MIA", 1197);
    
    /** flight object 5 */
    @SuppressWarnings("deprecation")
    Flight f5 = new Flight(new Date(2015, 1, 27), "B6", 574, "FLL",
            "JAX", 319);
    
    /**
     * Tests the add() method for FlightSkipList
     */
    @Test
    public void testAdd() {
        FlightSkipList list = new FlightSkipList();
        assertTrue(list.isEmpty());
        list.add(f1);
        list.add(f2);
        list.add(f3);
        list.add(f4);
        list.add(f5);
        assertEquals(list.getSize(), 5);
        assertFalse(list.isEmpty());
    }
    
    /**
     * Tests the lookUp() method for FlightSkipList
     */
    @Test
    public void testLookUp() {
        FlightSkipList list = new FlightSkipList();
        assertTrue(list.isEmpty());
        list.add(f1);
        list.add(f2);
        list.add(f3);
        list.add(f4);
        list.add(f5);
        assertEquals(((Flight) list.lookUp(f1.getAirline(), f1.getOriginAirport(), f1.getDestinationAirport(), f1.getFlightNumber())), f1);
        assertEquals(((Flight) list.lookUp(f1.getAirline(), f1.getOriginAirport(), f1.getDestinationAirport(), f1.getFlightNumber())).getDate(), f1.getDate());
        assertEquals(((Flight) list.lookUp(f1.getAirline(), f1.getOriginAirport(), f1.getDestinationAirport(), f1.getFlightNumber())).getOriginAirport(), f1.getOriginAirport());
        assertEquals(((Flight) list.lookUp(f1.getAirline(), f1.getOriginAirport(), f1.getDestinationAirport(), f1.getFlightNumber())).getDestinationAirport(), f1.getDestinationAirport());
    }

}
