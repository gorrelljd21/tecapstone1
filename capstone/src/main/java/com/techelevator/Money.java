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

//    public void makeChange(int change){
//        int quarters = Math.round((int)change/25);
//        change = change % 25;
//        int dimes = Math.round((int)change/10);
//        change = change % 10;
//        int nickles = Math.round((int)change/5);
//        change = change % 5;
//
//    }

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








