package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item {

    public Candy(String slotLocation, String productName, BigDecimal price) {

        super(slotLocation, productName, price);
    }

    @Override
    public String getSound() {

        return "Munch munch, Yum!";
    }

}
