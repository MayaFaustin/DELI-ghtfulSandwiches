package com.pluralsight;

import java.util.Scanner;

public class Drinks implements ItemPrice {
    static Scanner reader = new Scanner(System.in);

    private String drinkFlavor;
    private String drinkSize;
    private double drinkPrice;

    public Drinks(String drinkSize, double drinkPrice, String drinkFlavor){
        this.drinkSize = drinkSize;
        this.drinkPrice = drinkPrice;
        this.drinkFlavor = drinkFlavor;
    }


    public static void addDrinks(){
        System.out.println("Would you like to a drink? (yes/no)");
        String response = reader.nextLine();

        if(response.equalsIgnoreCase("yes")){
            System.out.println("What size drink would you like: small, medium, or large?");
            String size = reader.nextLine().toLowerCase();
            double price = 0;
            switch(size){
                case "small" -> price = 2.00;
                case "medium" -> price = 2.50;
                case "large" -> price = 3.00;
                default -> System.out.println("That's an incorrect size.Please try again.");
            }
            System.out.println("Would you like iced tea, lemonade, or soda?");
            String flavor = reader.nextLine();
            Drinks drink = new Drinks(size, price, flavor);
            System.out.println(drink.toString());

        } else if (response.equalsIgnoreCase("no")){
            System.out.println("You've selected no drink.");
        } else {
            System.out.println("That's an incorrect selection, please try again.");
        }

    }

    @Override
    public String toString() {
        return "Drink: " + drinkSize + " " + drinkFlavor + ", Price: $" + drinkPrice;
    }
    @Override
    public double getPrice() {
        return drinkPrice;
    }
}
