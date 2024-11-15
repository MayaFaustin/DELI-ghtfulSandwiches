package com.pluralsight;
import java.util.Scanner;

public class OrderScreen {
    static Scanner reader = new Scanner(System.in);

    public static void showOrderScreen(){
        int orderScreenSelection;
        // another do while loop, will run unless 0 is selected
        do {
            System.out.println("""
                    ✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★\
                    
                     You've selected " Start a new order". Choose one of the following to start crafting your DELI-ghtful meal:\
                    
                     (1) Add a sandwich\
                    
                     (2) Add a drink\
                    
                     (3) Add chips\
                    
                     (4) Checkout\
                    
                     (0) Exit\
                    
                     ✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★✮☆★""");
            orderScreenSelection = reader.nextInt();
            switch (orderScreenSelection) {
                case 1 -> Sandwich.addSandwich();
                case 2 -> Drinks.addDrinks();
                case 3 -> Chips.addChips();
                case 4 -> System.out.println("temporary checkout");
                case 0 -> System.out.println("Have a DELI-ghtful day ദ്ദി(˵•̀ ᴗ -˵) ✧");
                default -> System.out.println("That is not a valid selection (ᵕ—ᴗ—) Please try again.");
            }
        } while (orderScreenSelection != 0);
    }
}
