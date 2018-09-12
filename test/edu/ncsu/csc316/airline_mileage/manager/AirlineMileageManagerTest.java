package edu.ncsu.csc316.airline_mileage.manager;

import static org.junit.Assert.*;



import org.junit.Test;

/**
 * Tests the AirlineMileageManager class
 * @author jenna
 *
 */
public class AirlineMileageManagerTest {
    /** the path to the airline file */
    String airlineFile = "input/airline_file.txt";
    
    /** the path to the customer file */
    String customerFile = "input/customer_file.txt";
    
    /** the path to the flight file */
    String flightFile = "input/flight_file.txt";
    
    /** the expected output for erick mcfarland getMiles() */
    String erick = "Erick Mcfarland earned\n    3591 miles with United Airlines (UA)\n"
            + "    516 miles with Delta Air Lines (DL)\n    319 miles with JetBlue Airways (B6)";
    
    /** the expected output for mileageReport() */
    String mileageReport = "Erick Mcfarland earned\n    3591 miles with United Airlines (UA)\n    "
            + "516 miles with Delta Air Lines (DL)\n    319 miles with JetBlue Airways (B6)\n\n"
            + "Kassandra Stiltner earned\n    5985 miles with United Airlines (UA)";
    

    /** 
     * Tests the getMiles() method for AirlineMileageManager
     */
    @Test
    public void testGetMiles() {

        AirlineMileageManager manager = new AirlineMileageManager(airlineFile, customerFile, flightFile);
        assertEquals(erick, manager.getMiles("Erick", "Mcfarland"));

        
        
    }
    
    /** 
     * Tests the getMileageReport() method for AirlineMileageManager
     */
    @Test
    public void testGetMileageReport() {

        AirlineMileageManager manager = new AirlineMileageManager(airlineFile, customerFile, flightFile);
        assertEquals(mileageReport, manager.getMileageReport());
        
        
    }

}
