/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.list;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Airline;

/**
 * Tests the AirlineSkipList 
 * @author Jenna Shockley
 *
 */
public class AirlineSkipListTest {

    /**
     * Tests the add() method in AirlineSkipList
     */
    @Test
    public void testAdd() {
        Airline a1 = new Airline("United Airlines", "UA", "UNITED",
            "United States");
        Airline a2 = new Airline("Delta Air Lines", "DL", "DELTA",
                "United States");
        Airline a3 = new Airline("JetBlue Airways", "B6", "JETBLUE",
                "United States");
        AirlineSkipList list = new AirlineSkipList();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        assertEquals(list.getSize(), 3);
        
    }
    
    /**
     * Tests the lookUp() method in AirlineSkipList
     */
    @Test
    public void testLookUp() {
        
        Airline a1 = new Airline("United Airlines", "UA", "UNITED",
                "United States");
        Airline a2 = new Airline("Delta Air Lines", "DL", "DELTA",
                    "United States");
        Airline a3 = new Airline("JetBlue Airways", "B6", "JETBLUE",
                    "United States");
        AirlineSkipList list = new AirlineSkipList();
        assertNull(list.lookUp(a1.getIATACode()));
        list.add(a1);
        list.add(a2);
        list.add(a3);
        assertEquals(((Airline) list.lookUp(a1.getIATACode())).getIATACode(), a1.getIATACode());
        assertEquals(((Airline) list.lookUp(a1.getIATACode())).getCountry(), a1.getCountry());
    }

}
