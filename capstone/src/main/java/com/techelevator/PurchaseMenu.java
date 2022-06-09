package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

public class PurchaseMenu {
    public static void main(String[] args) {

            String[] mainMenu = {"[1] Feed Money", "[2] Select Product", "[3] Finish Transaction"};

            Scanner userInput = new Scanner(System.in);

            System.out.println("Purchase Menu\n");
            for (int i = 0; i < mainMenu.length; i++) {
                System.out.println(mainMenu[i]);
            }
            System.out.println("\n");
            System.out.println("Please make a selection by number: ");
            Integer userSelection = Integer.parseInt(userInput.nextLine());


// account for wrong input (wrong format, less than 0 val)
        boolean addMore = true;
        if (userSelection.equals(1)) {
            Scanner moneyInput = new Scanner(System.in);

            BigDecimal currentlBalance = new BigDecimal("0.00");
            while(addMore) {
                System.out.printf("Current Balance: %s\n", currentlBalance);
                System.out.println("How much money do you want to feed?");
                System.out.println("Note: please enter whole dollar values in x.xx format.");
                String fedMoney = moneyInput.nextLine();
                BigDecimal fedMoneyBD = new BigDecimal(fedMoney);

                currentlBalance = currentlBalance.add(fedMoneyBD);
//                BigDecimal newCash = currentlBalance;
                System.out.println(currentlBalance);

                System.out.printf("New Balance: $%s\n", currentlBalance);

                Scanner moreMoney = new Scanner(System.in);
                String addMoreMoney = "Do you want to add more money? Y/N";
                System.out.println(addMoreMoney);
                String userAnswer = moreMoney.nextLine();

                if (userAnswer.equalsIgnoreCase("y")) {
                    addMore = true;
                } else if (userAnswer.equalsIgnoreCase("n")) {
                    addMore = false;
                    // return back to menu???
                    System.out.println("purchase menu");
                }
            }
        } else if (userSelection.equals(2)){
            Inventory items = new Inventory();

            for(Item item : items.getInventory()){
                System.out.printf("%s %s %s %s\n", item.getSlotLocation(), item.getProductName(), item.getPrice(), item.getProductType());
            }
            System.out.println("==========================================");
            Scanner codeSelection = new Scanner(System.in);
            System.out.println("Enter product code (i.e. A1, D3, etc.): \n");
//            String userCodeSelection = codeSelection.nextLine();

        }
    }
}



