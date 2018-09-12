/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.list;


import edu.ncsu.csc316.airline_mileage.data.Customer;


/**
 * Creates a customer skip list ordered by last name and
 * then by first name
 * @author Jenna Shockley
 *
 */
public class CustomerSkipList extends SkipList {

    /**
     * CustomerSkipList constructor
     */
    public CustomerSkipList() {
        super();
    }

    /**
     * Adds a customer object to the skip list
     * @param o the customer object to add
     */
    @Override
    public void add(final Object o) {
        final Customer c = (Customer)o;
        SkipNode currentNewNode = null;
        size++;
        final int level = randomLevel();
        SkipNode current = head;
        int currentLevel = maxLevel;

        while (currentLevel >= 0) {
            while (current.right != null && 
                    lessThan(((Customer) current.right.element).getLastName(), c.getLastName())) {
                current = current.right;
            } 
            while (current.right != null && 
                    ((Customer) current.right.element).getLastName().equals(c.getLastName())
                    && lessThan(((Customer) current.right.element).getFirstName(), c.getFirstName())) {
                current = current.right;
            }
            if (currentLevel <= level) {
                current.right = new SkipNode(c, current.right, null);
                if (currentNewNode != null) {
                    currentNewNode.down = current.right;
                }
                currentNewNode = current.right;
            }
            if (currentLevel > 0) {
                current = current.down;
            }
            currentLevel--;
        }

    }

    /**
     * Looks up a customer object using last name and first name
     * @param lastName the last name of the customer
     * @param firstName the first name of the customer
     * @return the customer object
     */
    public Object lookUp(final String lastName, final String firstName) {
        if (isEmpty()) {
            return null;
        }
        int level = maxLevel;
        SkipNode current = head;
        while (level >= 0) {
            while (current.right != null && lessThan(((Customer) current.right.element).getLastName(), lastName)) {
                current = current.right;
            } 
            while (current.right != null && ((Customer) current.right.element).getLastName().equals(lastName)
                    && lessThan(((Customer) current.right.element).getFirstName(), firstName)) {
                current = current.right; 
            }

            if (current.right != null && ((Customer)current.right.element).getLastName().equals(lastName) && 
                    ((Customer)current.right.element).getFirstName().equals(firstName)) {
                return current.right.element;
            } else {
                if (level != 0) {
                    current = current.down;
                }
                level--;
            } 
        }
        return null;
    }

    /**
     * Gets a customer object at index i
     * @param i the index of the object
     * @return the customer object
     */
    public Customer get(final int i) {
        SkipNode current = head;
        int level = maxLevel;
        while(level != 0) {
            current = current.down;
            level--;
        }
        current = current.right;
        int pos = 0;
        while (pos != i) {
            current = current.right;
            pos++;
        } 
        return (Customer)current.element;
    }
}
