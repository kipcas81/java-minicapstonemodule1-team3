package com.techelevator;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendingMachine {

	private final Scanner userInput = new Scanner(System.in);
	public static void main(String[] args) throws FileNotFoundException {
		Scanner userInput = new Scanner(System.in);
		Inventory inventory = new Inventory();
		MainMenu mainMenu = new MainMenu();
		PurchaseMenu purchaseMenu = new PurchaseMenu();
		mainMenu.getMainMenu();
		String choice = userInput.nextLine();
		if (choice.equals("2")) {
			purchaseMenu.getPurchaseMenu();
		}
		do {
			if (choice.equals("1")) {
				inventory.displayItems();
				System.out.println("*************end of items*************");
				System.out.println("*********Main Menu*******************");
				mainMenu.getMainMenu();
				choice = userInput.nextLine();
			}
		} while (!choice.equals("3"));
		if (choice.equals("3")) {
			System.out.println("Exiting the Vending Machine. Enjoy your drink or whatever!");
		}











	}
}
