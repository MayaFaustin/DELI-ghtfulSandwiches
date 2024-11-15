package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Checkout {
    private static List<Sandwich> sandwiches = new ArrayList<>();
    private static List<Drinks> drinks = new ArrayList<>();
    private static List<Chips> chips = new ArrayList<>();

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }
    public void addDrink(Drinks drink) {
        drinks.add(drink);
    }
    public void addChips(Chips chip) {
        chips.add(chip);
    }

    public static void displayEntireOrder() {
        System.out.println("\"✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★ \"" +
                "Here's your order: ");
        System.out.println("----★------Sandwiches------★----");
        for (Sandwich sandwich : sandwiches) {
            System.out.println(sandwich);
        }
        System.out.println("----★------Drinks------★----");
        for (Drinks drink : drinks) {
            System.out.println(drink);
            System.out.println("----★------Chips------★----");
            for (Chips chip : chips) {
                System.out.println(chip);
            }
        }
        System.out.println("Order total: $" + checkOutTotal());
    }

    public static double checkOutTotal() {
        double orderTotal = 0;
        for (Sandwich sandwich : sandwiches) {
            orderTotal += sandwich.getPrice();
        }
        for (Drinks drink : drinks) {
            orderTotal += drink.getPrice();
        }
        for (Chips chip : chips) {
            orderTotal += chip.getPrice();
        }
        return orderTotal;
    }
}
