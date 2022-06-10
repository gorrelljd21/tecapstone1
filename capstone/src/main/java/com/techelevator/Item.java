package com.techelevator;

import java.math.BigDecimal;

public class Item {

    private String slotLocation;
    private String productName;
    private BigDecimal price;
    private String productType;
    private String chips = "Crunch crunch, Yum!";
    private String candy = "Munch munch, Yum!";
    private String drink = "Glug glug, Yum!";
    private String gum = "Chew chew, Yum!";

    public String getChips() {
        return chips;
    }

    public String getCandy() {
        return candy;
    }

    public String getDrink() {
        return drink;
    }

    public String getGum() {
        return gum;
    }

    public Item(String slotLocation, String productName, BigDecimal price, String productType) {
        this.slotLocation = slotLocation;
        this.productName = productName;
        this.productType = productType;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getProductType() {
        return productType;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public String getProductName() {
        return productName;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



}

