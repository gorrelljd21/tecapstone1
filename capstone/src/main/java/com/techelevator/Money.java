package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Money {

//    BigDecimal quarter = BigDecimal.valueOf(0.25);
//    BigDecimal dime = BigDecimal.valueOf(0.10);
//    BigDecimal nickel = BigDecimal.valueOf(0.05);


    private BigDecimal balance = new BigDecimal("0.00");

    public BigDecimal getBalance() {
        return balance;
    }

    public void makeChange(BigDecimal balance){

//        BigDecimal quartersReturned = balance.divideToIntegralValue(quarter);
//        BigDecimal qR = quartersReturned.divide(quarter);
//        BigDecimal dimesReturned = quartersReturned.subtract(quarter.multiply(BigDecimal.valueOf(qR.intValue())));
//        BigDecimal dR = dimesReturned.divide(dime);
//        BigDecimal nicklesReturned = dimesReturned.subtract(dime.multiply(BigDecimal.valueOf(dR.intValue())));
//        BigDecimal nR = nicklesReturned.divide(nickel);
//
//        double change = balance.doubleValue();
//        change = change * 100;
//
//        int quarters = (int)(change/25);
//        quarters = quarters % 25;
//
//        int dimes = quarters - (int)(change/10);
//        dimes = dimes % 10;
//
//        int nickles = dimes - (int)(change/5);
//        nickles = nickles % 5;
        int change = balance.multiply(BigDecimal.valueOf(100)).intValue();
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
//
        while (change >= 25) {
            quarters += 1;
            change -= 25;
        }
        while (change >= 10) {
            dimes += 1;
            change -= 10;
            while (change >= 5) {
                nickels += 1;
                change -= 5;
            }
        }


        System.out.printf("Your change is: %s quarters, %s dimes, and %s nickles %n", quarters, dimes, nickels);

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








