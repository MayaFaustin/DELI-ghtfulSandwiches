package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chips {
    static Scanner reader = new Scanner(System.in);
    public static void addChips(){
        System.out.println("Would you like to add a bag of chips? (yes/no)");

        String response = reader.nextLine();
        if(response.equalsIgnoreCase("yes")){
            System.out.println("");
        } else if (response.equalsIgnoreCase("no")){

        } else {
            System.out.println("That's an incorrect selection, please try again.");
        }
    }

}
