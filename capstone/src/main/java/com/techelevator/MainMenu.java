package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
        Inventory items = new Inventory();

        String[] mainMenu = {"[1] Display Items", "[2] Purchase", "[3] Exit"};

        Scanner userInput = new Scanner(System.in);

        System.out.println("Welcome to our vending machine!\n");
        System.out.println("Main Menu");
        for (int i = 0; i < mainMenu.length; i++) {
            System.out.println(mainMenu[i]);
        }
        System.out.println("\n");
        System.out.println("Please make a selection by number: ");
        Integer userSelection = Integer.parseInt(userInput.nextLine());

        if (userSelection.equals(1)) {
            for(Item item : items.getInventory()){
                System.out.printf("%s %s %s %s\n", item.getSlotLocation(), item.getProductName(), item.getPrice(), item.getProductType());
            }
        } else if (userSelection.equals(2)){
            System.out.println("purchase");
        } else if (userSelection.equals(3)) {
            System.out.println("Goodbye.");
        }
    }
}
