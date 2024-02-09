package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.*;

public class Inventory {

    private List<Item> items = new ArrayList<>();

    private Item item = null;
    private String filePath = "C:\\Users\\Student\\workspace\\java-minicapstonemodule1-team3\\capstone\\vendingmachine.csv";
    private int quantity = 2;
    private int itemPosition = 0;


    File file = new File(filePath);

    public  Inventory() throws FileNotFoundException {
            try (Scanner readCSV = new Scanner(file)) {


                while (readCSV.hasNextLine()) {


                    String line = readCSV.nextLine();
                    String[] splitItemstring = line.split(",");
                    String slotLocation = splitItemstring[0];
                    String itemName = splitItemstring[1];
                    double itemPrice = Double.parseDouble(splitItemstring[2]);
                    String itemType = splitItemstring[3];

                    itemPosition++;
                    Item item = new Item(slotLocation, itemName, itemPrice, itemType, quantity, itemPosition);
                    items.add(item);

                }

            }
            catch (Exception exception) {

            }
    }
    public List<Item> getItems(){
        return this.items;
    }
    public void displayItems(){
        List<Item> displayItems = getItems();

        for(Item item : displayItems){
            String remarks = "";
            if(item.getItemQuantity() == 0) {
                remarks = "Sold Out";
            }
            System.out.println(item.getSlotLocation() + " " + item.getItemName() + " " + item.getItemPrice() + " " + "Quantity" + " " +  item.getItemQuantity() + " " + remarks);
        }
    }

    public Item getItem(String slotLocation){
        List<Item> searchItems = getItems();
        item = null;
        for(Item searchItem: searchItems) {
            if(searchItem.getSlotLocation().equalsIgnoreCase(slotLocation)) {
                item = searchItem;
            }
        }
        return item;
    }

    public boolean removeItem(Item item) {
        return this.getItems().remove(item);
    }

    public void addItem(Item item) {
        items.add(item.getItemPosition() - 1,item);
    }

}
