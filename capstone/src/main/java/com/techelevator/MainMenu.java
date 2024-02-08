package com.techelevator;
import java.util.Scanner;

public class MainMenu {


    private String[] mainMenu = new String[]{ "Welcome to the Vendo-Matic 800", "Please select an option","(1) Display Vending Machine Items", "(2) Purchase" ,"(3) Exit"};

    public void getMainMenu() {
        for(String menuItem : mainMenu) {
            System.out.println(menuItem);
            System.out.println("");

        }

    }
}
