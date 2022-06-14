package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//errors

public class MainMenu {

    public static void main(String[] args) {

        VendingMachine vendingMachine = new VendingMachine();
        Log tranxLog = new Log();
        boolean mainRunning = true;

        do {

            try {

                String[] mainMenu = {"[1] Display Items", "[2] Purchase", "[3] Exit"};

                Scanner userInput = new Scanner(System.in);
                System.out.println("==========================================");
                System.out.println("Welcome to our vending machine!\n");
                System.out.println("Main Menu");
                for (int i = 0; i < mainMenu.length; i++) {
                    System.out.println(mainMenu[i]);
                }
                System.out.println("\n");
                System.out.println("Please make a selection by number.");
                Integer userSelection = Integer.parseInt(userInput.nextLine());

                if (userSelection >= 4) {
                    System.out.println("Please enter a valid number selection");
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

                    if (purchaseMenuSelection >= 4) {
                        System.out.println("Please enter a valid number selection");
                    }

                    if (purchaseMenuSelection.equals(1)) {

                        boolean addMoney = true;

                        do {

                            try {
                                System.out.printf("Current Balance: $%s\n", vendingMachine.getMoney().getBalance());
                                System.out.println("How much money do you want to feed?");
                                System.out.println("Note: please enter whole dollar values in x.xx format.");
                                BigDecimal fedMoney = new BigDecimal(userInput.nextLine());
                                    if (!vendingMachine.money.isWholeNumber(fedMoney))  {
                                        throw new NumberFormatException("Invalid input.");
                                    }

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
                            } catch (NumberFormatException nfe) {
                                System.out.println("Please enter a whole number");
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
                } else {
                    mainRunning = true;
                }
            } catch (NumberFormatException nfe) {
                System.out.print("Please enter valid inputs per menu instructions \n");
            }

        } while (mainRunning);
    }
}

