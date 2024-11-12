package com.pluralsight;

import java.util.Scanner;

public class Sandwich {
    static Scanner reader = new Scanner(System.in);

    /*
    Add Sandwich - the add sandwich screen will walk the user through
    several options to create the sandwich
    o Select your bread:
    o Sandwich size:
    o Toppings: - the user should be able to add extras of each topping
        § Meat:
        § Cheese:
        § Other toppings:
        § Select sauces:
    o Would you like the sandwich toasted?
     */
    public static void addSandwich() {
        System.out.println("Let's get your sandwich started. What type of bread would you like?");


    }
    enum breadOptions{
        white, wheat, rye, wrap
    }
    enum premiumToppingsOptions{
        steak, ham, salami, roast_beef, chicken, bacon, american, provolone, cheddar, swiss
    }
    enum regularToppingsOptions{
        lettuce, peppers, onions, tomatoes, jalapeños, cucumbers, pickles, guacamole, mushrooms
    }
    enum saucesOptions{
        mayo, mustard, ketchup, ranch, vinaigrette, thousand_islands
    }
    enum sidesOptions{
        au_jus, sauce
    }
}
