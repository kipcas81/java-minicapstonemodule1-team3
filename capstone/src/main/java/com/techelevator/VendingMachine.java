package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class VendingMachine {

	private static final Scanner userInput = new Scanner(System.in);
	public static void main(String[] args) throws FileNotFoundException {
		Scanner userInput = new Scanner(System.in);
		processMainMenu();
	}

	public static void processMainMenu() throws FileNotFoundException {
		MainMenu mainMenu = new MainMenu();
		Inventory inventory = new Inventory();
		mainMenu.getMainMenu();
		String mainMenuChoice = userInput.nextLine();
		do {
			if (mainMenuChoice.equals("1")) {
				inventory.displayItems();
				System.out.println("*************end of items*************");
				System.out.println("*********Printing Main Menu Again *******************");
				goToMainMenu();
			} else if(mainMenuChoice.equals("2")) {
				Purchase purchase = new Purchase();
				Money money = new Money();
				TransactionsLog transactionsLog = new TransactionsLog();
				Item item = new Item("","",0.00,"",0,0);
				processPurchaseMenu(purchase,money,inventory,transactionsLog,item);
			}
		} while (!mainMenuChoice.equals("3"));

		if (mainMenuChoice.equals("3")) {
			System.out.println("Exiting the Vending Machine. Enjoy your drink or whatever!");
			System.exit(0);
		}
	}

	public static void processPurchaseMenu(Purchase purchase, Money money, Inventory inventory, TransactionsLog transactionsLog, Item newItem) throws  FileNotFoundException {
		purchase.getPurchaseMenu();
		System.out.println("Enter your choice from the purchase options?");

		String purchaseMenuChoice = userInput.nextLine();

		if (purchaseMenuChoice.equals("1")) {
			boolean continueFeedingMoney = true;
			do {
				System.out.println("Feed the money in whole dollar amounts.");
				String userEnteredDollarsString = userInput.nextLine();
				BigDecimal userEnteredDollars = new BigDecimal(userEnteredDollarsString);
				money.feedMoney(userEnteredDollars);
				transactionsLog.logTransaction("1",money,userEnteredDollars,null);
				System.out.println("Do you want to continue feeding the money? Enter 'Yes' or 'No'!");
				String userContinueFeedingMoneyChoice = userInput.nextLine();
				if(userContinueFeedingMoneyChoice.equalsIgnoreCase("No")) {
					continueFeedingMoney = false;
					goToPurchaseMenu(purchase,money,inventory, transactionsLog, newItem);
				}
			} while(continueFeedingMoney);
		} else if (purchaseMenuChoice.equals("2")) {
			inventory.displayItems();
			System.out.println("Select your product! Enter the slot location.");
			String userEnteredSlotLocation = userInput.nextLine();
			if (inventory.getItem(userEnteredSlotLocation) != null) {
				if (inventory.getItem(userEnteredSlotLocation).getItemQuantity() == 0) {
					System.out.println("Product: " + inventory.getItem(userEnteredSlotLocation).getItemName() + " sold out! Please select another product!");
				} else if (money.getBalance().setScale(2,RoundingMode.HALF_UP).compareTo(new BigDecimal(inventory.getItem(userEnteredSlotLocation).getItemPrice())) < 0) {
					System.out.println("Insufficient funds! Please feed money and try again!");
				} else {
					Item item = inventory.getItem(userEnteredSlotLocation);
					double itemPrice = inventory.getItem(userEnteredSlotLocation).getItemPrice();
					BigDecimal itemPriceBigDecimal = new BigDecimal(itemPrice);
					int itemQuantity = inventory.getItem(userEnteredSlotLocation).getItemQuantity() - 1;
					System.out.println("Item is: " + inventory.getItem(userEnteredSlotLocation).getItemName() + " and it's price is: " + inventory.getItem(userEnteredSlotLocation).getItemPrice());
					money.reduceMoney(itemPriceBigDecimal);
					System.out.println("Money remaining is: " + money.getBalance().setScale(2, RoundingMode.HALF_UP));
					System.out.println(stuffedAnimalMessage(inventory.getItem(userEnteredSlotLocation)));
					inventory.removeItem(item);
					item.setItemQuantity(itemQuantity);
					inventory.addItem(item);
					transactionsLog.logTransaction("2",money,new BigDecimal("0.00"),item);
				}
			} else {
				System.out.println("Product not available! Please select another product!");
			}
			goToPurchaseMenu(purchase,money,inventory,transactionsLog,newItem);
		} else if (purchaseMenuChoice.equals("3")) {
			System.out.println("Thanks for your purchase! " + money.getBalanceInSmallestCoins() + " is your balance");
			transactionsLog.logTransaction("3",money,new BigDecimal("0.00"),newItem);
			goToMainMenu();
		} else if (purchaseMenuChoice.equals("4")) {
			System.out.println("Current available balance: " + money.getBalance().setScale(2,RoundingMode.HALF_UP));
			goToPurchaseMenu(purchase,money,inventory,transactionsLog,newItem);
		} else {
			goToMainMenu();
		}
	}

	 public static void goToMainMenu() throws FileNotFoundException {
		System.out.println("Going to main menu now.");
		processMainMenu();
	}

	public static void goToPurchaseMenu(Purchase purchase, Money money,Inventory inventory,TransactionsLog transactionsLog, Item item) throws FileNotFoundException {
		System.out.println("Going to purchase menu now. Enter your choice?");
		processPurchaseMenu(purchase,money,inventory,transactionsLog,item);
	}

	public static String stuffedAnimalMessage(Item item) {
		String stuffedAnimalMessage = "";
		if (item.getItemType().equals("Duck")) {
			stuffedAnimalMessage = "Quack, Quack, Splash!";
		} else if(item.getItemType().equals("Penguin")) {
			stuffedAnimalMessage = "Squawk, Squawk, Whee!";
		} else if(item.getItemType().equals("Cat")) {
			stuffedAnimalMessage = "Meow, Meow, Meow!";
		} else if(item.getItemType().equals("Pony")) {
			stuffedAnimalMessage = "Neigh, Neigh, Yay!";
		}
		return stuffedAnimalMessage;
	}
}
