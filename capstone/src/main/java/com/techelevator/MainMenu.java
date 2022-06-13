package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//errors

public class MainMenu {

    public static void main(String[] args) {

        boolean mainRunning = true;
        Log tranxLog = new Log();
        VendingMachine vendingMachine = new VendingMachine();

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

            //TODO create handle
            //create handle to see if their selection is 1 2 or 3
            if(!userSelection.equals(1)) {
                System.out.println("Please make a correct selection");
            } else if (!userSelection.equals(2)) {
                System.out.println("Please make a correct selection");
            } else if (!userSelection.equals(3)) {
                System.out.println("Please make a correct selection");
            } else if (userSelection.equals("")) {
                System.out.println("Please make a numbered selection");
            }

            if (userSelection.equals(1)) {
                System.out.println("==========================================");
                for (Item item : vendingMachine.getInventory().getInventory()) {
                    System.out.printf("%s %s %s %n", item.getSlotLocation(), item.getProductName(), item.getPrice());
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

                //TODO create handle
                //create handle to see if their selection is 1 2 or 3
                if(!userSelection.equals(1)) {
                    System.out.println("Please make a correct selection");
                } else if (!userSelection.equals(2)) {
                    System.out.println("Please make a correct selection");
                } else if (!userSelection.equals(3)) {
                    System.out.println("Please make a correct selection");
                }

                if (purchaseMenuSelection.equals(1)) {

                    boolean addMoney = true;

                    do {

                        System.out.printf("Current Balance: $%s\n", vendingMachine.getMoney().getBalance());
                        System.out.println("How much money do you want to feed?");
                        System.out.println("Note: please enter whole dollar values in x.xx format.");
                        BigDecimal fedMoney = new BigDecimal(userInput.nextLine());

                        final String LOG_OUTPUT_FEEDING_MONEY = "FEED MONEY";
                        vendingMachine.getMoney().addMoney(fedMoney);
                        tranxLog.writeToLog(LOG_OUTPUT_FEEDING_MONEY, fedMoney, vendingMachine.getMoney().getBalance());

                        String addMoreMoney = "Do you want to add more money? Y/N";
                        System.out.println(addMoreMoney);
                        String userAnswer = userInput.nextLine();

                        if (userAnswer.equalsIgnoreCase("y")) {

                            addMoney = true;
                        } else if (userAnswer.equalsIgnoreCase("n")) {

                            addMoney = false;
                        }

                    } while (addMoney);
                } else if (purchaseMenuSelection.equals(2)) {

                    boolean anotherPurchase = true;

                    do {

                        for (Item item : vendingMachine.getInventory().getInventory()) {
                            System.out.printf("%s %s %s %n", item.getSlotLocation(), item.getProductName(), item.getPrice());
                        }
                        System.out.println("==========================================");
                        System.out.printf("Your balance is $%s\n", vendingMachine.getMoney().getBalance());
                        System.out.println("Enter product code (i.e. A1, D3, etc.): \n");
                        String userCodeSelection = userInput.nextLine();

                        //if item in stock then if they have the funds the purchase funds

                        Item item = vendingMachine.purchaseItem(userCodeSelection);

                        if (item != null) {
                            if (item.getIsInStock()) {
                                String sound = item.getSound();
                                System.out.printf("%s %n", sound);
                                tranxLog.writeToLog(item.getProductName(), item.getPrice(), vendingMachine.getMoney().getBalance());
                            } else {
                                System.out.println("Item out of stock. Make a different selection.");
                            }
                        } else {
                            System.out.println("Insufficient funds.");
                        }

                        System.out.printf("Your balance is: $%s\n", vendingMachine.getMoney().getBalance());
                       System.out.println("Do you want to make another selection? Y/N");
                        String wantsAnother = userInput.nextLine();

                        if (wantsAnother.equalsIgnoreCase("y")) {
                            anotherPurchase = true;
                        } else if (wantsAnother.equalsIgnoreCase("n")) {
                            anotherPurchase = false;

                        }
                    } while (anotherPurchase);

                } else if (purchaseMenuSelection.equals(3)) {

                    final String LOG_OUTPUT_GIVING_CHANGE = "GIVE CHANGE";
                    vendingMachine.getMoney().makeChange(vendingMachine.getMoney().getBalance());
                    System.out.printf("Machine balance: $%s\n", vendingMachine.money.zeroBalance());
                    tranxLog.writeToLog(LOG_OUTPUT_GIVING_CHANGE, vendingMachine.getMoney().getBalance(), vendingMachine.money.zeroBalance());
                }

            } else if (userSelection.equals(3)) {
                System.out.println("Goodbye.");
                mainRunning = false;
            }

        } while (mainRunning);
    }
}

