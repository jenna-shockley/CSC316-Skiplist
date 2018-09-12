package edu.ncsu.csc316.airline_mileage.ui;


import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.manager.AirlineMileageManager;

/**
 * Command Line interface
 * @author Jenna Shockley
 *
 */
public class AirlineMileageManagerUI {

    private static Scanner console;

    /**
     * Main method to run AirlineMileageManager
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        console = new Scanner(System.in);
        AirlineMileageManager a = null;
        do {
            System.out.println("Enter Airline File: ");
            String airline = console.next();
            System.out.println("Enter Customer File: ");
            String customer = console.next();
            System.out.println("Enter Flight File: ");
            String flight = console.next();
            a = new AirlineMileageManager(airline, customer, flight);
        } while(a == null);
        String c;
        String l;
        String f;
        
        while (true) {
            System.out.println("Choose getMiles, getMileageReport, or quit: ");
            c = console.next();
            if (c.equals("getMiles")) {
                System.out.println("\nEnter Last Name: ");
                l = console.next();
                System.out.println("\nEnter First Name: ");
                f = console.next();
                c = a.getMiles(f, l);
                System.out.println("\n" + c);
            } else if(c.equals("getMileageReport")) {
                c = a.getMileageReport();
                System.out.println("\n" + c);
            } else if(c.equals("quit")) {
                System.exit(1);
            } else {
                System.out.println("\nInvalid Response. Try again.");
            }
        }

    }

}
