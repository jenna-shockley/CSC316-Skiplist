package edu.ncsu.csc316.airline_mileage.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.list.AirlineSkipList;

/**
 * Tests the AirlineReader class
 * @author Jenna Shockley
 *
 */
public class AirlineReaderTest {

    /**
     * Tests the AirlineReader class with given file
     */
    @Test
    public void test() {
        /** airline 1 */
        Airline a1 = new Airline("United Airlines", "UA", "UNITED", "United States"); 
        
        Airline a2 = new Airline("Delta Air Lines", "DL", "DELTA", "United States"); 
        
        Airline a3 = new Airline("JetBlue Airways", "B6", "JETBLUE", "United States"); 
        AirlineSkipList airlines;
        try {
            AirlineReader r = new AirlineReader();
            assertTrue(r != null);
            airlines = AirlineReader.readAirlineFile("input/airline_file.txt");
            assertEquals(a1.getIATACode(), ((Airline) airlines.lookUp("UA")).getIATACode());
            assertEquals(a1.getDescription(), ((Airline) airlines.lookUp("UA")).getDescription());
            assertEquals(a1.getCallsign(), ((Airline) airlines.lookUp("UA")).getCallsign()); 
            assertEquals(a2.getIATACode(), ((Airline) airlines.lookUp("DL")).getIATACode());
            assertEquals(a3.getIATACode(), ((Airline) airlines.lookUp("B6")).getIATACode());
        } catch (FileNotFoundException e) {
            fail();
        }
    }

}
