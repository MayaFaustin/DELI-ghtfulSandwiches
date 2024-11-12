package com.pluralsight;

import java.util.Scanner;

public class HomeScreen {
    static Scanner reader = new Scanner(System.in);
    public static void showHomeScreen(){
        int homeScreenSelection;
        // another do while loop, will run unless 0 is selected
        do {
            System.out.println("Thank you for choosing DELI-ghtufl Sandwiches! Please select one of the following: " +
                    "\n 1. Start a new order" +
                    "\n 0. Exit");
            homeScreenSelection = reader.nextInt();
            switch (homeScreenSelection) {
                case 1:
                    OrderScreen.showOrderScreen();
                    break;
                case 0:
                    System.out.println("Have a DELI-ghtful day :D");
                    break;
                default:
                    System.out.println("That is not a valid selection. Please try again.");
            }
        } while (homeScreenSelection != 0);
    }
}
