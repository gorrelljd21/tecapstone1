package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Item {

    public Gum(String slotLocation, String productName, BigDecimal price) {

        super(slotLocation, productName, price);
    }

    @Override
    public String getSound() {

        return "Chew chew, Yum!";
    }

}
