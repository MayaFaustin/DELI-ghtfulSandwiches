package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sandwich {
    static Scanner reader = new Scanner(System.in);

    double cheesePrice = 0;
    double meatPrice = 0;
    private double price;
    private String breadType;
    private String sandwichSize;
    List<String>toppings;
    private boolean isToasted;

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public void addToppingPrice(double toppingsPrice) {
        setPrice(getPrice() + toppingsPrice);
    }

    public Sandwich(String _breadType, String _sandwichSize,List<String> toppings, boolean _isToasted) {
            this.breadType = _breadType;
            this.sandwichSize = _sandwichSize;
            this.toppings = toppings;
            this.isToasted = _isToasted;
    }

    public static void addSandwich() {
        // meat 1, 2, 3 xtra .5, 1, 1.5
        // cheese .75, 1.5, 2.25 xtra .3, .6, .9
        List<String> myToppings = new ArrayList<>();
        myToppings.add("steak");
        myToppings.add("ham");
        myToppings.add("salami");
        myToppings.add("roast beef");
        myToppings.add("chicken");
        myToppings.add("bacon");
        myToppings.add("american");
        myToppings.add("provolone");
        myToppings.add("cheddar");
        myToppings.add("swiss");
        myToppings.add("lettuce");
        myToppings.add("peppers");
        myToppings.add("onions");
        myToppings.add("tomatoes");
        myToppings.add("jalepeños");
        myToppings.add("cucumbers");
        myToppings.add("pickles");
        myToppings.add("guacamole");
        myToppings.add("mushrooms");
        myToppings.add("mayo");
        myToppings.add("mustard");
        myToppings.add("ketchup");
        myToppings.add("ranch");
        myToppings.add("vinaigrette");
        myToppings.add("thousand islands");
        myToppings.add("au jus");
        myToppings.add("sauce");

        Sandwich sandwich = new Sandwich("", "", myToppings, true);
        sandwich.selectBread();
        sandwich.selectSandwichSize();
        sandwich.toasted();

        System.out.println("What vegetables would you like to add: \nlettuce, peppers, onions, tomatoes, jalepeños, cucumbers, pickles, guacamole, or mushrooms");

        System.out.println("What sauces would you like to add: \nmayo, mustard, ketchup, ranch, thousand islands, or vinaigrette ");

        System.out.println("What sides would you like to add: \nau jus or sauce");

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

        switch (sandwichSizeSelection) {
            case "4 inches" -> {
                this.sandwichSize = "4 inches";
                setPrice(5.50);
                return "4 inches";
            }
            case "8 inches" -> {
                this.sandwichSize = "8 inches";
                setPrice(7.00);
                return "8 inches";
            }
            case "12 inches" -> {
                this.sandwichSize = "12 inches";
                setPrice(8.50);
                return "12 inches";
            }
            default -> {
                System.out.println("That's not a valid selection. Please try again.");
                return selectSandwichSize();
            }
        }
    }

    public String selectMeat(){ // size dependent prices: 1, 2, 3
        System.out.println("What meat would you like to add: \nsteak, ham, salami, roast beef, chicken or bacon");
        String meat = reader.nextLine().toLowerCase();
        toppings.add(meat);
        //  double meatPrice;
        if(this.sandwichSize == "4 inches") {
            meatPrice = 1.0;
            setPrice(getPrice() + meatPrice);
        } else if(this.sandwichSize == "8 inches"){
            meatPrice = 2.0;
            setPrice(getPrice() + meatPrice);
        } else if(this.sandwichSize == "12 inches"){
            meatPrice = 3.0;
            setPrice(getPrice() + meatPrice);
        }
        System.out.println("Would you like to add extra meat? (yes/no)");
        String extraMeat = reader.nextLine().toLowerCase();
        if (extraMeat.equals("yes")){
            if(this.sandwichSize == "4 inches") {
                setPrice(getPrice() + 0.5 + meatPrice);
            } else if(this.sandwichSize == "8 inches"){
                setPrice(getPrice() + 1.0 + meatPrice);
            } else if(this.sandwichSize == "12 inches"){
                setPrice(getPrice() + 1.5 + meatPrice);
            }
        }
        return extraMeat;
    }

    public String selectCheese(){
        System.out.println("What cheese would you like to add: \namerican, provolone, cheddar, or swiss");
        String cheese = reader.nextLine().toLowerCase();
        toppings.add(cheese);
        if(this.sandwichSize == "4 inches") {
            cheesePrice = 0.75;
            setPrice(getPrice() + cheesePrice);
        } else if(this.sandwichSize == "8 inches"){
            cheesePrice = 1.5;
            setPrice(getPrice() + cheesePrice);
        } else if(this.sandwichSize == "12 inches"){
            cheesePrice = 2.25;
            setPrice(getPrice() + cheesePrice);
        }
        System.out.println("Would you like to add extra cheese? (yes/no)");
        String extraCheese = reader.nextLine().toLowerCase();
        if (extraCheese.equals("yes")){
            if(this.sandwichSize == "4 inches") {
                setPrice(getPrice() + 0.30 + cheesePrice);
            } else if(this.sandwichSize == "8 inches"){
                setPrice(getPrice() + 0.60 + cheesePrice);
            } else if(this.sandwichSize == "12 inches"){
                setPrice(getPrice() + 0.90 + cheesePrice);
            }
        }
        return extraCheese;
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
}


