package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Money {

    BigDecimal quarter = BigDecimal.valueOf(0.25);
    BigDecimal dime = BigDecimal.valueOf(0.10);
    BigDecimal nickel = BigDecimal.valueOf(0.05);


    private BigDecimal balance = new BigDecimal("0.00");

    public BigDecimal getBalance() {
        return balance;
    }

    public void makeChange(BigDecimal balance){

        BigDecimal quartersReturned = balance.divideToIntegralValue(quarter);
        BigDecimal qR = quartersReturned.divide(quarter);
        BigDecimal dimesReturned = quartersReturned.subtract(quarter.multiply(BigDecimal.valueOf(qR.intValue())));
        BigDecimal dR = dimesReturned.divide(dime);
        BigDecimal nicklesReturned = dimesReturned.subtract(dime.multiply(BigDecimal.valueOf(dR.intValue())));
        BigDecimal nR = nicklesReturned.divide(nickel);


//        double change = 0.00;
//
//        int quarters = (int)(change/25);
//        quarters = quarters % 25;
//
//        int dimes = (int)(change/10);
//        dimes= dimes % 10;
//
//        int nickles = (int)(change/5);
//        nickles = nickles % 5;

        System.out.printf("Your change is: %s quarters, %s dimes, and %s nickles %n", quartersReturned.intValue(), dR.intValue(), nR.intValue());
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








