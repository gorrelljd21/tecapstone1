package com.techelevator;

import java.math.BigDecimal;

public class Money {

    private final BigDecimal QUARTER = BigDecimal.valueOf(25);
    private final BigDecimal DIME = BigDecimal.valueOf(10);
    private final BigDecimal NICKEL = BigDecimal.valueOf(5);
    private BigDecimal balance = new BigDecimal("0.00");


    public BigDecimal getBalance() {

        return balance;
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

    public void makeChange(BigDecimal balance) {

        balance = balance.multiply(BigDecimal.valueOf(100));
        int qChange = 0;
        int dChange = 0;
        int nChange = 0;

        while (balance.intValue() >= QUARTER.intValue()) {
            qChange += 1;
            balance = balance.subtract(QUARTER);
        }
        while (balance.intValue() >= DIME.intValue()) {
            dChange += 1;
            balance = balance.subtract(DIME);

            while (balance.intValue() >= NICKEL.intValue()) {
                nChange += 1;
                balance = balance.subtract(NICKEL);
            }
        }

        System.out.printf("Your change is: %s quarters, %s dimes, and %s nickels %n", qChange, dChange, nChange);

    }
    public boolean isWholeNumber(BigDecimal fedMoney) {
        double whole = (fedMoney.doubleValue() * 100);
        return whole % 100 == 0;
    }

}








