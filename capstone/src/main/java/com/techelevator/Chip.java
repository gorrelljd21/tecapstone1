package com.techelevator;

import java.math.BigDecimal;

public class Chip extends Item {

    public Chip(String slotLocation, String productName, BigDecimal price) {

        super(slotLocation, productName, price);
    }

    @Override
    public String getSound() {

        return "Crunch crunch, Yum!";
    }
}
