package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    private List<Item> inventory = new ArrayList<>();

    public Inventory() {

        File inventoryFile = new File("vendingmachine.csv");


        try (Scanner scanner = new Scanner(inventoryFile)) {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] arrayString = input.split("\\|");
                //convert third entry to BD index 2
                BigDecimal stringToDecimal = new BigDecimal(arrayString[2]);
                if (arrayString[3].equals("Chip")) {
                    Chip chip = new Chip(arrayString[0], arrayString[1], stringToDecimal);
                    inventory.add(chip);
                } else if (arrayString[3].equals("Candy")) {
                    Candy candy = new Candy(arrayString[0], arrayString[1], stringToDecimal);
                    inventory.add(candy);
                } else if (arrayString[3].equals("Drink")) {
                    Drink drink = new Drink(arrayString[0], arrayString[1], stringToDecimal);
                    inventory.add(drink);
                } else if (arrayString[3].equals("Gum")) {
                    Gum gum = new Gum(arrayString[0], arrayString[1], stringToDecimal);
                    inventory.add(gum);
                }
            }
        } catch (FileNotFoundException fnf) {
            System.out.println("File not here.");
        }

    }

    protected List<Item> getInventory() {

        return inventory;
    }
}
