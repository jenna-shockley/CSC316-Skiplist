package edu.ncsu.csc316.airline_mileage.list;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Miles;

/**
 * Tests MilesSkipList
 * @author Jenna Shockley
 *
 */
public class MilesSkipListTest {

    /**
     * Tests MilesSkipList
     */
    @Test
    public void test() {
        Miles m1 = new Miles(12, "US");
        Miles m2 = new Miles(134, "B6");
        Miles m3 = new Miles(6, "DL");
        MilesSkipList list = new MilesSkipList();
        list.add(m1);
        list.add(m2);
        list.add(m3); 
        assertEquals(list.get(0).getMiles(), 134);
    }

}
