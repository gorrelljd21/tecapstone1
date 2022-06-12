package com.techelevator;

public class VendingMachine {

    Money money = new Money();
    Inventory inventory = new Inventory();

    public Item purchaseItem(String slotLocation) {
        for (Item item : inventory.getInventory()) {
            if(item.getSlotLocation().equalsIgnoreCase(slotLocation)){
                if(item.getPrice().compareTo(money.getBalance()) <= 0){
                    if(item.getIsInStock()){
                       item.debitStock();
                       money.debitBalance(item.getPrice());
                       return item;
                    } else {
                        return item;
                    }
                }
            }
        }
        return null;
    }

    public Money getMoney() {
        return money;
    }

    public Inventory getInventory() {
        return inventory;
    }



}
