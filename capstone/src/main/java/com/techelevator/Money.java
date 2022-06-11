package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Money {

    private BigDecimal quarter = BigDecimal.valueOf(25);
    private BigDecimal dime = BigDecimal.valueOf(10);
    private BigDecimal nickel = BigDecimal.valueOf(5);

    private BigDecimal balance = new BigDecimal("0.00");

    public BigDecimal getBalance() {
        return balance;
    }

    public void makeChange(BigDecimal balance) {

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

        int qChange = 0;
        int dChange = 0;
        int nChange = 0;
        balance = balance.multiply(BigDecimal.valueOf(100));

        while (balance.intValue() >= quarter.intValue()) {
            qChange += 1;
            balance = balance.subtract(quarter);
        }
        while (balance.intValue() >= dime.intValue()) {
            dChange += 1;
            balance = balance.subtract(dime);
            while (balance.intValue() >= nickel.intValue()) {
                nChange += 1;
                balance = balance.subtract(nickel);
            }
        }


        System.out.printf("Your change is: %s quarters, %s dimes, and %s nickels %n", qChange, dChange, nChange);

    }

    public BigDecimal zeroBalance() {
        BigDecimal zeroBalance = balance.subtract(balance);
        return zeroBalance;
    }

    public void debitBalance(BigDecimal price) {
        balance = balance.subtract(price);
    }

    public void addMoney(BigDecimal cash) {
        balance = balance.add(cash);
    }

}








