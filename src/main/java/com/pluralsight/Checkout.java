package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Checkout {
    static Scanner reader = new Scanner(System.in);
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

    public static void checkOutOrder(){
        System.out.println("✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★" +
                "\nHere's your order: ");
        System.out.println("-✮--★--☆-Sandwiches-☆--★--✮-");
        for (Sandwich sandwich : sandwiches) {
            System.out.println(sandwich);
        }
        System.out.println("-✮--★--☆---Drinks---☆--★--✮-");
        for (Drinks drink : drinks) {
            System.out.println(drink);
        }
        System.out.println("-✮--★--☆---Chips---☆--★--✮-");
        for (Chips chip : chips) {
            System.out.println(chip);
        }
        System.out.println("-✮--★--☆-Order Total-☆--★--✮-" +
                "\nYour total today was $" + checkOutTotal());

        System.out.println("Would you like to confirm your order? (yes/no)");
        String response = reader.nextLine().toLowerCase().trim();
        switch(response){
            case "yes" -> {
                System.out.println("✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★");
                System.out.println("Enjoy! Have a DELI-ghtful day (˶ˆᗜˆ˵)");
                createOrderReceipt();
            }
            case "no" -> {
                System.out.println("Your order has been cancelled (;o;)");
                OrderScreen.showOrderScreen();
            }
        }
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

    public static void createOrderReceipt(){
        File receiptsFolder = new File("Receipts");
        if(!receiptsFolder.exists()){
            receiptsFolder.mkdir();
        }

        DateTimeFormatter dateAndTime = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String receiptFile = "Receipts/" + LocalDateTime.now().format(dateAndTime) + ".txt";

        try(FileWriter writer = new FileWriter(receiptFile)) {
            writer.write("-✮--★--☆---Sandwiches---☆--★--✮-\n");
            for (Sandwich sandwich : sandwiches) {
                writer.write(sandwich.toString());
            }
            writer.write("\n-✮--★--☆---Drinks---☆--★--✮-\n");
            for (Drinks drink : drinks) {
                writer.write(drink.toString());
            }
            writer.write("\n-✮--★--☆---Chips---☆--★--✮-\n");
            for (Chips chip : chips) {
                writer.write(chip.toString());
            }
            writer.write("\n-✮--★--☆-Order Total-☆--★--✮-\n");
            writer.write("Your total today was $" + checkOutTotal());
            System.out.println("Your receipt was successfully created");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
