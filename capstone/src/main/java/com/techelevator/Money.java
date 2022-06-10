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

    public void debitBalance(BigDecimal price){
        balance = balance.subtract(price);

    }

    public void addMoney(BigDecimal cash){
        balance = balance.add(cash);
    }



}








