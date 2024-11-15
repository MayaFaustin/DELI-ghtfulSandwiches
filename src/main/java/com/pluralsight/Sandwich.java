package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sandwich {
    static Scanner reader = new Scanner(System.in);

    private static double basePrice;
    private double extraMeatPrice;
    private double extraCheesePrice;
    double cheesePrice = 0;
    double meatPrice = 0;
    private double price;
    private String breadType;
    private String sandwichSize;
    List<String>toppings;
    private boolean isToasted;
    private String meat;
    private String cheese;
    private String regularToppings;
    private String sauces;
    private String sides;

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

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

        double totalSandwichPrice = basePrice + sandwich.meatPrice + sandwich.extraMeatPrice + sandwich.cheesePrice + sandwich.extraCheesePrice;
        sandwich.setPrice(totalSandwichPrice);

        System.out.println(sandwich.toString());
        System.out.println("Price: $" + totalSandwichPrice);


    }

    public String selectBread(){
        System.out.println("Let's get your sandwich started. What type of bread would you like: white, wheat, rye, or wrap? Type your response here: ");
        String breadSelection = reader.nextLine().toLowerCase();
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
        String sandwichSizeSelection = reader.nextLine();
        this.sandwichSize = sandwichSizeSelection;
        switch (sandwichSizeSelection) {
            case "4 inches" -> {
                basePrice = 5.50;
            }
            case "8 inches" -> {
                basePrice = 7.00;
            }
            case "12 inches" -> {
                basePrice = 8.50;
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
        meat = reader.nextLine().toLowerCase();
        toppings.add(meat);
        if(this.sandwichSize == "4 inches") {
            meatPrice = 1.0;
        } else if(this.sandwichSize == "8 inches"){
            meatPrice = 2.0;
        } else if(this.sandwichSize == "12 inches"){
            meatPrice = 3.0;
        }

        System.out.println("Would you like to add extra meat? (yes/no)");
        String extraMeat = reader.nextLine().toLowerCase();
        if (extraMeat.equals("yes")){
            if(this.sandwichSize == "4 inches") {
                extraMeatPrice = 0.75;
            } else if(this.sandwichSize == "8 inches"){
                extraMeatPrice = 1.50;
            } else if(this.sandwichSize == "12 inches"){
                extraMeatPrice = 2.25;
            }
        }
        return extraMeat;
    }

    public String selectCheese(){
        System.out.println("What cheese would you like to add: \namerican, provolone, cheddar, or swiss");
        cheese = reader.nextLine().toLowerCase();
        toppings.add(cheese);
        if(this.sandwichSize == "4 inches") {
            cheesePrice = 0.75;
        } else if(this.sandwichSize == "8 inches"){
            cheesePrice = 1.5;
        } else if(this.sandwichSize == "12 inches"){
            cheesePrice = 2.25;
        }
        System.out.println("Would you like to add extra cheese? (yes/no)");
        String extraCheese = reader.nextLine().toLowerCase();
        if (extraCheese.equals("yes")){
            if(this.sandwichSize == "4 inches") {
               extraCheesePrice = 0.30;
            } else if(this.sandwichSize == "8 inches"){
                extraCheesePrice = 0.60;
            } else if(this.sandwichSize == "12 inches"){
                extraCheesePrice = 0.90;
            }
        }
        return extraCheese;
    }

    public String selectRegularToppings()
    {
        System.out.println("What vegetables would you like to add: \nlettuce, peppers, onions, tomatoes, jalepeños, cucumbers, pickles, guacamole, or mushrooms");
        regularToppings = reader.nextLine();
        toppings.add(regularToppings);
        return regularToppings;
    }

    public String selectSauces(){
        System.out.println("What sauces would you like to add: \nmayo, mustard, ketchup, ranch, thousand islands, or vinaigrette ");
        sauces = reader.nextLine();
        toppings.add(sauces);
        return sauces;
    }

    public String selectSides(){
        System.out.println("What sides would you like to add: \nau jus or sauce");
        sides = reader.nextLine();
        toppings.add(sides);
        return sides;
    }

    public void toasted(){
        System.out.println("Would you like your sandwich toasted? (yes/no)");
        String toastedResponse = reader.next();
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
        return "✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★"
                + "\nBread: " + breadType +
                "\nSandwich size: " + sandwichSize +
                "\nMeat: " + meat +
                "\nCheese: " + cheese +
                "\nVegetables: " + regularToppings +
                "\nSauce: " + sauces +
                "\nSides: " + sides +
                "\nToasted: " + isToasted;
    }
}


