package com.pluralsight;

import java.util.Scanner;

public class Drinks {
    static Scanner reader = new Scanner(System.in);
    public static void addDrinks(){
        System.out.println("Would you like to a drink? (yes/no)");
        String response = reader.nextLine();
        if(response.equalsIgnoreCase("yes")){
            System.out.println("");
        } else if (response.equalsIgnoreCase("no")){

        } else {
            System.out.println("That's an incorrect selection, please try again.");
        }
    }
}
