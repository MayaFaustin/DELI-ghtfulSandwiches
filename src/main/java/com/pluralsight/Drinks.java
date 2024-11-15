package com.pluralsight;

import java.util.Scanner;

public class Drinks implements ItemPrice {
    static Scanner reader = new Scanner(System.in);

    // attributes
    // prices 2, 2.50, 3
    private static final double SMALL_SANDWICH_PRICE = 4.0; private static final double MEDIUM_SANDWICH_PRICE = 6.0; private static final double LARGE_SANDWICH_PRICE = 8.0;
    public static void addDrinks(){
        System.out.println("Would you like to a drink? (yes/no)");
        String response = reader.nextLine();
        if(response.equalsIgnoreCase("yes")){
            System.out.println("Would you like iced tea, lemonade, or soda?");

        } else if (response.equalsIgnoreCase("no")){

        } else {
            System.out.println("That's an incorrect selection, please try again.");
        }
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
