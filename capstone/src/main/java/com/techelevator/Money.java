package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Money {

    private final BigDecimal QUARTER = new BigDecimal("0.25");
    private final BigDecimal DIME = new BigDecimal("0.10");
    private final BigDecimal NICKEL = new BigDecimal("0.05");


    private BigDecimal balance = new BigDecimal("0.00");

    public BigDecimal getBalance() {
        return balance;
    }

    public void makeChange(BigDecimal balance){
        double change;
        change = (balance.doubleValue() * 100);
        int quarters = (int)(change/25);
        quarters = quarters % 25;
        int dimes = (int)(change/10);
        dimes = dimes % 10;
        int nickles = (int)(change/5);
        nickles = nickles % 5;
        System.out.printf("Your change is: %s quarters %s dimes %s nickles %n", quarters, dimes, nickles);
    }

    public BigDecimal zeroBalance() {
        BigDecimal zeroBalance = balance.subtract(balance);
        return zeroBalance;
    }

    public void debitBalance(BigDecimal price){
        balance = balance.subtract(price);
    }

    public void addMoney(BigDecimal cash){
        balance = balance.add(cash);
    }

}








