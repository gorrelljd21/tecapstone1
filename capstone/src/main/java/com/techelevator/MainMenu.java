package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//errors

public class MainMenu {

    public static void main(String[] args) {

        Inventory items = new Inventory();
        Selection selection = new Selection();
        Money money = new Money();
        boolean mainRunning = true;
        BigDecimal defaultBalance = new BigDecimal("0.00");
        BigDecimal balance = defaultBalance;
        Log tranxLog = new Log();


        do {

            String[] mainMenu = {"[1] Display Items", "[2] Purchase", "[3] Exit"};

            Scanner userInput = new Scanner(System.in);
            System.out.println("==========================================");
            System.out.println("Welcome to our vending machine!\n");
            System.out.println("Main Menu");
            for (int i = 0; i < mainMenu.length; i++) {
                System.out.println(mainMenu[i]);
            }
            System.out.println("\n");
            System.out.println("Please make a selection by number: ");
            Integer userSelection = Integer.parseInt(userInput.nextLine());

            if (userSelection.equals(1)) {
                System.out.println("==========================================");
                for (Item item : items.getInventory()) {
                    System.out.printf("%s %s %s %s\n", item.getSlotLocation(), item.getProductName(), item.getPrice(), item.getProductType());
                }
            } else if (userSelection.equals(2)) {

                System.out.println("Purchase Menu\n");
                String[] menu2 = {"[1] Feed Money", "[2] Select Product", "[3] Finish Transaction"};
                for (int i = 0; i < menu2.length; i++) {
                    System.out.println(menu2[i]);
                }
                System.out.println("\n");
                System.out.println("Please make a selection by number: ");
                Integer purchaseMenuSelection = Integer.parseInt(userInput.nextLine());

                if (purchaseMenuSelection.equals(1)) {
                    boolean addMoney = true;
                    do {

                        System.out.printf("Current Balance: $%s\n", money.getBalance());
                        System.out.println("How much money do you want to feed?");
                        System.out.println("Note: please enter whole dollar values in x.xx format.");
                        Double fedMoney = Double.parseDouble(userInput.nextLine());

//                        money.calculatingMoney(fedMoney);

                        String addMoreMoney = "Do you want to add more money? Y/N";
                        System.out.println(addMoreMoney);
                        String userAnswer = userInput.nextLine();

                        if (userAnswer.equalsIgnoreCase("y")) {
                            balance = money.getBalance();
                            tranxLog.writeToLog();
                            addMoney = true;
                        } else if (userAnswer.equalsIgnoreCase("n")) {
                            balance = money.getBalance();
                            tranxLog.writeToLog();
                            addMoney = false;
                        }

                    } while (addMoney);
                } else if (purchaseMenuSelection.equals(2)) {

                    boolean anotherPurchase = true;
                    for (Item item : items.getInventory()) {
                        System.out.printf("%s %s %s %s\n", item.getSlotLocation(), item.getProductName(), item.getPrice(), item.getProductType());
                    }
                    System.out.println("==========================================");
                    Scanner codeSelection = new Scanner(System.in);
                    System.out.printf("Your balance is $%s\n", money.getBalance());
                    System.out.println("Enter product code (i.e. A1, D3, etc.): \n");
                    String userCodeSelection = codeSelection.nextLine();
                    for (Item item : items.getInventory()) {
                        if (userCodeSelection.equalsIgnoreCase(item.getSlotLocation())) {
                            switch (item.getProductType()) {
                                case "Chip":
                                    System.out.println(item.getChips());
                                    break;
                                case "Candy":
                                    System.out.println(item.getCandy());
                                    break;
                                case "Drink":
                                    System.out.println(item.getDrink());
                                    break;
                                case "Gum":
                                    System.out.println(item.getGum());
                                    break;
                            }
                            BigDecimal price = item.getPrice();
                            balance = money.getBalance().subtract(price);
                        }
                    }
                    //METHOD GOES HERE
                    System.out.printf("Your balance is: $%s\n", balance);
                    Scanner anotherProduct = new Scanner(System.in);
                    String wantAnotherSelection = "Do you want to make another selection? Y/N";
                    System.out.println(wantAnotherSelection);
                    String wantsAnother = anotherProduct.nextLine();
                    if (wantsAnother.equalsIgnoreCase("y")) {
                        anotherPurchase = true;
                    } else if (wantsAnother.equalsIgnoreCase("n")) {
                        //return to purchase menu
                        anotherPurchase = false;
                        System.out.println("purchase menu");
                    }

                } else if (userSelection.equals(3)) {
                    BigDecimal remainingBalance = balance;
                    // to return change
//                    BigDecimal updatedBalance = balance;
                    balance = BigDecimal.valueOf(0);
                    System.out.printf("here is your change: $%s\n", remainingBalance);
                    System.out.printf("Machine balance: $%s\n", balance);

                } else if (userSelection.equals(3)) {
                    System.out.println("Goodbye.");
                    mainRunning = false;
                }

            }

        } while (mainRunning);
    }
}
