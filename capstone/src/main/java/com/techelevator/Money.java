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

    public void calculatingMoney(Double money) {

        BigDecimal fedMoneyBD = new BigDecimal(money);
        balance = balance.add(fedMoneyBD);

    }
}








