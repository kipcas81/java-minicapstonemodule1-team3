package com.techelevator;

public class Item {
    private String slotLocation;
    private double itemPrice;
    private String itemName;
    private String itemType;
    private int itemQuantity;


    public Item(String slotLocation, String itemName, double itemPrice, String type, int itemQuantity) {
        this.slotLocation = slotLocation;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemType = type;
        this.itemQuantity = itemQuantity;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public void setSlotLocation(String slotLocation) {
        this.slotLocation = slotLocation;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setType(String type) {
        itemType = type;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}




