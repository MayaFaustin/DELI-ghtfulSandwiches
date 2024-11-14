package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sandwich {
    static Scanner reader = new Scanner(System.in);

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
    /*
            Add Sandwich - the add sandwich screen will walk the user through
            several options to create the sandwich
            o Select your bread: done
            o Sandwich size: done
            o Toppings: - the user should be able to add extras of each topping
                § Meat:
                § Cheese:
                § Other toppings:
                § Select sauces:
            o Would you like the sandwich toasted?
             */
    public static void addSandwich() {
        // meat 1, 2, 3 xtra .5, 1, 1.5
        // cheese .75, 1.5, 2.25 xtra .3, .6, .9

        List<String> myToppings = new ArrayList<>();
        myToppings.add(1, "steak");
        myToppings.add(2,"ham");
        myToppings.add(3, "salami");
        myToppings.add(4, "roast beef");
        myToppings.add(5, "chicken");
        myToppings.add(6, "bacon");
        myToppings.add(7, "american");
        myToppings.add(8,"provolone");
        myToppings.add(9,"cheddar");
        myToppings.add(10, "swiss");
        myToppings.add(11, "lettuce");
        myToppings.add(12, "peppers");
        myToppings.add(13,"onions");
        myToppings.add(14,"tomatoes");
        myToppings.add(15,"jalepenos");
        myToppings.add(16,"cucumbers");
        myToppings.add(17, "pickles");
        myToppings.add(19,"guacamole");
        myToppings.add(20, "mushrooms");
        myToppings.add(21, "mayo");
        myToppings.add(22, "mustard");
        myToppings.add(23, "ketchup");
        myToppings.add(24, "ranch");
        myToppings.add(25, "vinaigrette");
        myToppings.add(26, "thousand islands");
        myToppings.add(27, "au jus");
        myToppings.add(28, "sauce");

        Sandwich sandwich = new Sandwich("white", "12 inches", myToppings, true);
        System.out.println("Let's get your sandwich started. What type of bread would you like: white, wheat, rye, or wrap? Type your response here: ");

        String breadSelection = reader.next().toLowerCase();
        switch(breadSelection) {
            case "white" -> {
                // add to sandwich array
            }
            case "wheat", "rye" ->  {
                // add
            }
            case "wrap" -> {
                // add
            }
            default -> System.out.println("That's not a valid selection. Please try again.");
        }

        System.out.println("What size sandwich would you like: 4 inches, 8 inches, or 12 inches?");
        String sandwichSizeSelection = reader.next();
        switch(sandwichSizeSelection){
            case "4 inches" -> // add to object
                    sandwich.setPrice(5.50);
            case "8 inches" -> // add to object
                    sandwich.setPrice(7.00);
            case "12 inches" -> // add to object
                    sandwich.setPrice(8.50);
        }
        /*
        - steak
        - ham
        - salami
        - roast beef
        - chicken
        - bacon
         */
        System.out.println("What meat would you like to add: \nsteak \nham \nsalami \nroast beef \nchicken \n bacon");

        System.out.println("Would you like to add extra meat?"); //if statement

        System.out.println("What cheese would you like to add: \namerican \nprovolone \ncheddar \nswiss");

        System.out.println("What vegetables would you like to add: \nlettuce \npeppers \nonions \ntomatoes \njalepenos \ncucumbers \npickles \nguacamole \nmushrooms");

        System.out.println("What sauces would you like to add: ");

        System.out.println("Do you want any extra toppings?");

        System.out.println("What sides would you like to add: \nau jus \nsauce");

        System.out.println("Would you like your sandwich toasted?");
    }

}

