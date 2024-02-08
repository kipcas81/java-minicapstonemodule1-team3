package com.techelevator;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class PurchaseMenu {
    private double currentFunds =0.00;

    private String[] purchaseMenu = new String[]{"Current Money Provided:" + "$" + currentFunds,"(1) Feed Money" ,"(2) Select Product" ,"(3) Finish Transaction"};
    Scanner userInput = new Scanner(System.in);

    public void getPurchaseMenu() throws FileNotFoundException {
        Inventory inventory = new Inventory();

        for (String purchaseMenuItem : purchaseMenu) {
            System.out.println(purchaseMenuItem);
            System.out.println("");
        }
        String purchaseMenuChoice = userInput.nextLine();
        if(purchaseMenuChoice.equals("2")){
            inventory.displayItems();
            System.out.println("");
            System.out.println("Please Select a Product");
            String productChoice = userInput.nextLine();

            while(!inventory.getItemMap().containsKey(productChoice)) {
                System.out.println("Please make a valid selection");
                productChoice = userInput.nextLine();
            }
            if(inventory.getItemMap().containsKey(productChoice) && inventory.getItemQuantityMap().get(productChoice) == 0){
                System.out.println("Sorry " + inventory.getItemMap().get(productChoice) + " is Sold Out");
            }else if(inventory.getItemMap().containsKey(productChoice))
            {
                System.out.println("You have selected " + inventory.getItemMap().get(productChoice));
                if(inventory.getItemTypeMap().get(productChoice) == "duck"){
                    System.out.println("Quack, Quack, Splash!");
                } else if(inventory.getItemTypeMap().get(productChoice) == "penguin"){
                    System.out.println("Squawk, Squawk, Whee!");
                } else if(inventory.getItemTypeMap().get(productChoice) == "cat"){
                    System.out.println("Meow, Meow, Meow!");
                } else if(inventory.getItemTypeMap().get(productChoice) == "cat"){
                    System.out.println("Neigh, Neigh, Yay!");
                }
            }


        }


    }
}
