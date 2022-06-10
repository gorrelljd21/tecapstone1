//package com.techelevator;
//
//import java.math.BigDecimal;
//import java.util.Scanner;
//
////errors - sold out, incorrect input
////restock
//
//public class PurchaseMenu {
//    public void run() {
//
//        String chips = "Crunch crunch, Yum!";
//        String candy = "Munch munch, Yum!";
//        String drink = "Glug glug, Yum!";
//        String gum = "Chew chew, Yum!";
//        BigDecimal defaultBalance = new BigDecimal("0.00");
//        BigDecimal balance = defaultBalance;
//        Money money = new Money();
//        Log tranxLog = new Log();
//
//        boolean addmore = true;
//        boolean purchaseRunning = true;
//        boolean addMoney = true;
//
////        do {
////
////            String[] mainMenu = {"[1] Feed Money", "[2] Select Product", "[3] Finish Transaction"};
////
////            Scanner userInput = new Scanner(System.in);
////
////            System.out.println("Purchase Menu\n");
////            for (int i = 0; i < mainMenu.length; i++) {
////                System.out.println(mainMenu[i]);
////            }
////            System.out.println("\n");
////            System.out.println("Please make a selection by number: ");
////            Integer userSelection = Integer.parseInt(userInput.nextLine());
//
//// account for wrong input (wrong format, less than 0 val)
//
////            if (userSelection.equals(1)) {
////                do {
////                    money.calculatingMoney();
////
////                    String addMoreMoney = "Do you want to add more money? Y/N";
////                    System.out.println(addMoreMoney);
////                    String userAnswer = userInput.nextLine();
////METHOD HERE
//                    if (userAnswer.equalsIgnoreCase("y")) {
//                        balance = money.getBalance();
//                        tranxLog.writeToLog();
//
//                        addMoney = true;
//                    } else if (userAnswer.equalsIgnoreCase("n")) {
//                        balance = money.getBalance();
//                        tranxLog.writeToLog();
//                        addMoney = false;
//                    }
////                } while (addMoney);
////            } else if (userSelection.equals(2)) {
////                Inventory items = new Inventory();
////                boolean anotherPurchase = true;
//
////                for (Item item : items.getInventory()) {
////                    System.out.printf("%s %s %s %s\n", item.getSlotLocation(), item.getProductName(), item.getPrice(), item.getProductType());
////                }
////                System.out.println("==========================================");
////                Scanner codeSelection = new Scanner(System.in);
////                System.out.printf("Your balance is $%s\n", balance);
////                System.out.println("Enter product code (i.e. A1, D3, etc.): \n");
////                String userCodeSelection = codeSelection.nextLine();
////METHOD HERE
//                for (Item item : items.getInventory()) {
//                    if (userCodeSelection.equalsIgnoreCase(item.getSlotLocation())) {
//                        switch (item.getProductType()) {
//                            case "Chip":
//                                System.out.println(chips);
//                                break;
//                            case "Candy":
//                                System.out.println(candy);
//                                break;
//                            case "Drink":
//                                System.out.println(drink);
//                                break;
//                            case "Gum":
//                                System.out.println(gum);
//                                break;
//                        }
//                        BigDecimal price = item.getPrice();
//                        balance = balance.subtract(price);
//                    }
//                }
//
////                System.out.printf("Your balance is: $%s\n", balance);
////
////                Scanner anotherProduct = new Scanner(System.in);
////                String wantAnotherSelection = "Do you want to make another selection? Y/N";
////                System.out.println(wantAnotherSelection);
////                String wantsAnother = anotherProduct.nextLine();
//
//                if (wantsAnother.equalsIgnoreCase("y")) {
//                    anotherPurchase = true;
//                } else if (wantsAnother.equalsIgnoreCase("n")) {
//                    //return to purchase menu
//                    anotherPurchase = false;
//                    System.out.println("purchase menu");
//                }
//
//                // errors - if product doesn't exist & if SOLD OUT
//                // if no more, go back to main menu
////            } else if (userSelection.equals(3)) {
//
//                BigDecimal remainingBalance = balance;
//                // to return change
//                BigDecimal updatedBalance = balance;
//                balance = BigDecimal.valueOf(0);
////                System.out.printf("here is your change: $%s\n", remainingBalance);
////                System.out.printf("Machine balance: $%s\n", balance);
////                purchaseRunning = false;
////            }
////
////        } while (purchaseRunning);
////    }
//
//}
//
//
