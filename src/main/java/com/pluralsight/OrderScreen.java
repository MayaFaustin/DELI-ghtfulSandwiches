package com.pluralsight;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class OrderScreen {
/*
 1) Add Sandwich
o 2) Add Drink
o 3) Add Chips
o 4) Checkout
o 0) Cancel Order
 */

    static Scanner reader = new Scanner(System.in);
    public static void showOrderScreen(){
        int orderScreenSelection;
        // another do while loop, will run unless 0 is selected
        do {
            System.out.println("You've chosen \" Start a new order\". Select one of the following to craft a DELI-ghtful meal:" +
                    "\n 1. Add a sandwich" +
                    "\n 2. Add a drink" +
                    "\n 3. Add chips" +
                    "\n 4. Checkout" +
                    "\n 0. Exit");
            orderScreenSelection = reader.nextInt();
            switch (orderScreenSelection) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    System.out.println("Have a DELI-ghtful day :D");
                    break;
                default:
                    System.out.println("That is not a valid selection. Please try again.");
            }
        } while (orderScreenSelection != 0);
    }


}
