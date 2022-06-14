package com.techelevator;

import java.math.BigDecimal;

public abstract class Item {

    private String slotLocation;
    private String productName;
    private BigDecimal price;
    private int stock = 5;
    private boolean isInStock = true;


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
        } else {
            setInStock(false);
        }
    }

    public boolean getIsInStock() {

        return isInStock;
    }

    public void setInStock(boolean inStock) {

        this.isInStock = inStock;
    }
}

