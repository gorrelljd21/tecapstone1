package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Money {
    private BigDecimal balance = new BigDecimal("0.00");


    public BigDecimal getBalance() {
        return balance;
    }

    public void calculatingMoney() {

        Scanner moneyInput = new Scanner(System.in);

        System.out.printf("Current Balance: $%s\n", balance);
        System.out.println("How much money do you want to feed?");
        System.out.println("Note: please enter whole dollar values in x.xx format.");
        String fedMoney = moneyInput.nextLine();

        BigDecimal fedMoneyBD = new BigDecimal(fedMoney);

        balance = balance.add(fedMoneyBD);
        System.out.printf("New Balance: $%s\n", balance);

    }
}








