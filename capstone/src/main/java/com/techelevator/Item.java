package com.techelevator;

import java.math.BigDecimal;

public abstract class Item {

    private String slotLocation;
    private String productName;
    private BigDecimal price;
    private int stock = 5;


    public Item(String slotLocation, String productName, BigDecimal price) {
        this.slotLocation = slotLocation;
        this.productName = productName;
        this.price = price;
    }

    public String getSlotLocation() {

        return slotLocation;
    }

    public String getProductName() {

        return productName;
    }

    public BigDecimal getPrice() {

        return price;
    }

    public void setPrice(BigDecimal price) {

        this.price = price;
    }

    public abstract String getSound();

    public int getStock() {

        return stock;
    }

    public void debitStock() {
        if (stock > 0) {
            stock = stock - 1;
        }
    }
        public boolean getIsInStock () {
            return stock > 0;
        }
    }



