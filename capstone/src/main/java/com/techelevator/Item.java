package com.techelevator;

import java.math.BigDecimal;

public class Item {

    private String slotLocation;
    private String productName;
    private BigDecimal price;
    private String productType;



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

