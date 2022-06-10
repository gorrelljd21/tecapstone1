package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Item{

    public Drink(String slotLocation, String productName, BigDecimal price) {
        super(slotLocation, productName, price);
    }

    @Override
    public String getSound() {
        return "Glug glug, Yum!";
    }

}
