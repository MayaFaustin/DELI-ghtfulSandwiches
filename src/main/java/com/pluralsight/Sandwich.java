package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sandwich implements ItemPrice{
    static Scanner reader = new Scanner(System.in);

    private double basePrice;
    private double extraMeatPrice;
    private double extraCheesePrice;
    double cheesePrice = 0;
    double meatPrice = 0;
    private String breadType;
    private String sandwichSize;
    List<String>toppings;
    private boolean isToasted;
    private String meat;
    private String cheese;
    private String regularToppings;
    private String sauces;
    private String sides;


    public Sandwich(String _breadType, String _sandwichSize,List<String> toppings, boolean _isToasted) {
            this.breadType = _breadType;
            this.sandwichSize = _sandwichSize;
            this.toppings = toppings;
            this.isToasted = _isToasted;
    }

    public static void addSandwich() {
        List<String> myToppings = new ArrayList<>();

        // temporary object
        Sandwich sandwich = new Sandwich("", "", new ArrayList<>(), false);

        sandwich.selectBread();
        sandwich.selectSandwichSize();
        sandwich.selectMeat();
        sandwich.selectCheese();
        sandwich.selectRegularToppings();
        sandwich.selectSauces();
        sandwich.selectSides();
        sandwich.toasted();

        Checkout checkout = new Checkout();
        checkout.addSandwich(sandwich);

        System.out.println(sandwich);


    }

    public String selectBread(){
        System.out.println("Let's get your sandwich started. What type of bread would you like: white, wheat, rye, or wrap? Type your response here: ");
        String breadSelection = reader.nextLine().toLowerCase().trim();
        switch(breadSelection) {
            case "white", "wheat", "rye", "wrap" -> {
                this.breadType = breadSelection;
                return breadSelection;
            }
            default -> {
                System.out.println("That's not a valid selection. Please try again.");
                return selectBread();
            }
        }
    }

    public String selectSandwichSize() {
        System.out.println("What size sandwich would you like: 4 inches, 8 inches, or 12 inches?");
        String sandwichSizeSelection = reader.nextLine().trim();
        this.sandwichSize = sandwichSizeSelection;
        switch (sandwichSizeSelection) {
            case "4 inches" -> {
                this.basePrice = 5.50;
            }
            case "8 inches" -> {
                this.basePrice = 7.00;
            }
            case "12 inches" -> {
                this.basePrice = 8.50;
            }
            default -> {
                System.out.println("That's not a valid selection. Please try again.");
                return selectSandwichSize();
            }
        }
        return sandwichSizeSelection;
    }

    public String selectMeat(){ // size dependent prices: 1, 2, 3
        System.out.println("What meat would you like to add: \nsteak, ham, salami, roast beef, chicken or bacon");
        meat = reader.nextLine().toLowerCase().trim();
        toppings.add(meat);
        switch (this.sandwichSize) {
            case "4 inches" -> this.meatPrice = 1.0;
            case "8 inches" -> this.meatPrice = 2.0;
            case "12 inches" -> this.meatPrice = 3.0;
        }

        System.out.println("Would you like to add extra meat? (yes/no)");
        String extraMeat = reader.nextLine().toLowerCase().trim();
        if (extraMeat.equals("yes")){
            switch (this.sandwichSize) {
                case "4 inches" -> this.extraMeatPrice = 0.75;
                case "8 inches" -> this.extraMeatPrice = 1.50;
                case "12 inches" -> this.extraMeatPrice = 2.25;
            }
        }
        return extraMeat;
    }

    public String selectCheese(){
        System.out.println("What cheese would you like to add: \namerican, provolone, cheddar, or swiss");
        cheese = reader.nextLine().toLowerCase().trim();
        toppings.add(cheese);
        switch (this.sandwichSize) {
            case "4 inches" -> this.cheesePrice = 0.75;
            case "8 inches" -> this.cheesePrice = 1.5;
            case "12 inches" -> this.cheesePrice = 2.25;
        }
        System.out.println("Would you like to add extra cheese? (yes/no)");
        String extraCheese = reader.nextLine().toLowerCase().trim();
        if (extraCheese.equals("yes")){
            switch (this.sandwichSize) {
                case "4 inches" -> this.extraCheesePrice = 0.30;
                case "8 inches" -> this.extraCheesePrice = 0.60;
                case "12 inches" -> this.extraCheesePrice = 0.90;
            }
        }
        return extraCheese;
    }

    public String selectRegularToppings()
    {
        System.out.println("What vegetables would you like to add: \nlettuce, peppers, onions, tomatoes, jalepeños, cucumbers, pickles, guacamole, or mushrooms");
        regularToppings = reader.nextLine().trim();
        toppings.add(regularToppings);
        return regularToppings;
    }

    public String selectSauces(){
        System.out.println("What sauces would you like to add: \nmayo, mustard, ketchup, ranch, thousand islands, or vinaigrette ");
        sauces = reader.nextLine().trim();
        toppings.add(sauces);
        return sauces;
    }

    public String selectSides(){
        System.out.println("What sides would you like to add: \nau jus or sauce");
        sides = reader.nextLine().trim();
        toppings.add(sides);
        return sides;
    }

    public void toasted(){
        System.out.println("Would you like your sandwich toasted? (yes/no)");
        String toastedResponse = reader.next().trim();
        if (toastedResponse.equalsIgnoreCase("yes")){
            this.isToasted = true;
        } else if(toastedResponse.equalsIgnoreCase("no")){
            this.isToasted = false;
        } else{
            System.out.println("That is not a valid response. Please try again.");
            toasted();
        }
    }

    public String toString() {
        return  "Bread: " + breadType +
                "\nSandwich size: " + sandwichSize +
                "\nMeat: " + meat +
                "\nCheese: " + cheese +
                "\nVegetables: " + regularToppings +
                "\nSauce: " + sauces +
                "\nSides: " + sides +
                "\nToasted: " + isToasted +
                "\nPrice....................$" + getPrice();
    }

    @Override
    public double getPrice() {
        return basePrice + meatPrice + extraMeatPrice + cheesePrice + extraCheesePrice;
    }
}


