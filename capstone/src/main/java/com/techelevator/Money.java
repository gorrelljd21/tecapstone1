package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

public class Money {
    private BigDecimal balance = new BigDecimal("0.00");
    private boolean addMore = true;

    public BigDecimal getBalance() {
        return balance;
    }

    public boolean isAddMore() {
        return addMore;
    }

    public BigDecimal calculatingMoney() {
        Scanner moneyInput = new Scanner(System.in);

        System.out.printf("Current Balance: %s\n", balance);
        System.out.println("How much money do you want to feed?");
        System.out.println("Note: please enter whole dollar values in x.xx format.");
        String fedMoney = moneyInput.nextLine();
        BigDecimal fedMoneyBD = new BigDecimal(fedMoney);

        balance = balance.add(fedMoneyBD);
        BigDecimal currentBalance = balance;
        return currentBalance;
    }

    public Money(BigDecimal balance, boolean addMore) {

        while (addMore) {

            System.out.printf("New Balance: $%s\n", calculatingMoney());

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



    }



}


