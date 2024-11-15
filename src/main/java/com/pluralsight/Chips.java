package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chips implements  ItemPrice {
    static Scanner reader = new Scanner(System.in);

    private double chipsPrice;
    private String chipsFlavor;

    public Chips(String chipsFlavor, double chipsPrice){
        this.chipsFlavor = chipsFlavor;
        this.chipsPrice = chipsPrice;
    }

    public static void addChips(){
        System.out.println("Would you like to add a bag of chips? (yes/no)");
        String response = reader.nextLine().trim();

        if(response.equalsIgnoreCase("yes")){
            System.out.println("What flavor would you like: bbq, sea salt, or salt and vinegar?");
            String flavor = reader.nextLine().trim();
            Chips chip = new Chips(flavor, 1.50);

            Checkout checkout = new Checkout();
            checkout.addChips(chip);

            System.out.println(chip.toString());

        } else if (response.equalsIgnoreCase("no")){
            System.out.println("You've selected no chips.");
        } else {
            System.out.println("That's an incorrect selection, please try again.");
        }

    }

    @Override
    public String toString() {
        return "Chips: " + chipsFlavor +
                "\nPrice....................$" + chipsPrice;
    }

    @Override
    public double getPrice() {
        return chipsPrice;
    }
}
