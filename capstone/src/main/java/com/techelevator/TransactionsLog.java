package com.techelevator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TransactionsLog {



    public String LOG_FILE = "Test.txt";



    public  void logTransaction(String purchaseOption, Money money, BigDecimal feedAmount, Item item) {




        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             PrintWriter pw = new PrintWriter(fw);) {
            LocalDateTime timestamp = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
            String formattedTimestamp = timestamp.format(formatter);

            String transactionType;
            if (purchaseOption.equals("1")) {
                pw.println(formattedTimestamp  + " FEED MONEY" + ": $" + feedAmount.setScale(2, RoundingMode.HALF_UP) + " " + "$" + money.getBalance().setScale(2,RoundingMode.HALF_UP));
            } else if (purchaseOption.equals("2")) {
                pw.println(formattedTimestamp + " " + item.getItemName() + " " + " " + item.getSlotLocation() + " " + " " + "$" +item.getItemPrice() + " " + "$" + money.getBalance().setScale(2, RoundingMode.HALF_UP));
            } else if (purchaseOption.equals("3")) {
                pw.println(formattedTimestamp  + " GIVE CHANGE:" + " " + "$" + money.getBalance().setScale(2, RoundingMode.HALF_UP) + " " + "$0.00");
            }


        } catch (IOException e) {
            System.out.println("Error logging transaction");
        }

    }
}