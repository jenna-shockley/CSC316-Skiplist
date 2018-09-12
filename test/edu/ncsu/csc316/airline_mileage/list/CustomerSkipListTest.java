package edu.ncsu.csc316.airline_mileage.list;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Customer;

/**
 * Tests the CustomerSkipList class
 * @author Jenna Shockley
 *
 */
public class CustomerSkipListTest {
    /** customer 1 object */
    Customer c1 = new Customer("Bill", "Smith", null);
    
    /** customer 2 object */
    Customer c2 = new Customer("Sarah", "Adams", null);
    
    /** customer 3 object */
    Customer c3 = new Customer("Beverly", "Smith", null);
    
    /**
     * Tests the add() method for CustomerSkipList
     */
    @Test
    public void testAdd() {
        CustomerSkipList list = new CustomerSkipList();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        assertEquals(3, list.getSize());
    }
    
    /**
     * Tests the lookUp() method for CustomerSkipList
     */
    @Test
    public void testLookUp() {
        CustomerSkipList list = new CustomerSkipList();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        assertEquals(list.lookUp("Smith", "Beverly"), c3);
    }

}
