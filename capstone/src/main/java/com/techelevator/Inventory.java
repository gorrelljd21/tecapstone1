package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    List<Item> inventory = new ArrayList<>();

    public Inventory() {

        File inventoryFile = new File("vendingmachine.csv");

        try (Scanner scanner = new Scanner(inventoryFile)) {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] arrayString = input.split("\\|");
                //convert third entry to BD index 2
                BigDecimal stringToDecimal = new BigDecimal(arrayString[2]);
                Item snack = new Item(arrayString[0], arrayString[1], stringToDecimal, arrayString[3]);
                inventory.add(snack);
            }
        } catch (FileNotFoundException fnf) {
            System.out.println("File not here, bro!");
        }
//        for (int i = 0; i < productArray.length; i++) {
//            this.inventory.add(productArray[i]);
//        }
        // RESTOCK and loop through to ensure there are x5 items

    }

    protected List<Item> getInventory() {
        return inventory;
    }
}
