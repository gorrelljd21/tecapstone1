package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

public class Selection {
    public static void main(String[] args) {

        String chips = "Crunch crunch, Yum!";
        String candy = "Munch munch, Yum!";
        String drink = "Glug glug, Yum!";
        String gum = "Chew chew, Yum!";
        BigDecimal defaultBalance = new BigDecimal("0.00");
        BigDecimal balance = defaultBalance;
        boolean addmore = true;

        Inventory items = new Inventory();
        boolean anotherPurchase = true;

//        Money newMoney = new Money(balance, addmore);


        while(anotherPurchase) {
            for (Item item : items.getInventory()) {
                System.out.printf("%s %s %s %s\n", item.getSlotLocation(), item.getProductName(), item.getPrice(), item.getProductType());
            }
            System.out.println("==========================================");
            Scanner codeSelection = new Scanner(System.in);
//        System.out.println(newMoney.calculatingMoney()); //this should be currentBalance
            System.out.println("Enter product code (i.e. A1, D3, etc.): \n");
            String userCodeSelection = codeSelection.nextLine();

            for (Item item : items.getInventory()) {
                if (userCodeSelection.equalsIgnoreCase(item.getSlotLocation())) {
                    switch (item.getProductType()) {
                        case "Chip":
                            System.out.println(chips);
                            break;
                        case "Candy":
                            System.out.println(candy);
                            break;
                        case "Drink":
                            System.out.println(drink);
                            break;
                        case "Gum":
                            System.out.println(gum);
                            break;
                    }
                }
            }
            System.out.printf("Your remaining balance is: %s\n", balance);

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

            // errors - if product doesn't exist & if SOLD OUT
            // if no more, go back to main menu

        }
    }
}
