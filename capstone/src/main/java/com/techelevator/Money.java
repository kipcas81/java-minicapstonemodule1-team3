package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {

    private BigDecimal balance = new BigDecimal(0.0);

    public BigDecimal getBalance() {
        return this.balance;
    }

    public String getBalanceInSmallestCoins() {
        String balanceInSmallestCoins = "";
        BigDecimal currentBalance = getBalance().setScale(2, RoundingMode.HALF_UP);
        int wholeDollars = currentBalance.intValue();
        if(wholeDollars > 0) {
            balanceInSmallestCoins += wholeDollars + " Dollars ";
        }
        int remainingBalanceInCents = currentBalance.movePointRight(2).intValue() % 100;
        int numberOfQuarters, numberOfDimes, numberOfNickels, numberOfCents = 0;
        boolean continueDeterminingSmallestCoins = true;
        do {
            if(remainingBalanceInCents >= 25) {
                numberOfQuarters = remainingBalanceInCents/25;
                remainingBalanceInCents = remainingBalanceInCents % 25;
                balanceInSmallestCoins += numberOfQuarters + " Quarters ";
            } else if (remainingBalanceInCents >= 10) {
                numberOfDimes = remainingBalanceInCents/10;
                remainingBalanceInCents = remainingBalanceInCents % 10;
                balanceInSmallestCoins += numberOfDimes + " Dimes ";
            } else if (remainingBalanceInCents >=5) {
                numberOfNickels = remainingBalanceInCents/5;
                remainingBalanceInCents = remainingBalanceInCents % 5;
                balanceInSmallestCoins += numberOfNickels + " Nickels ";
            } else if (remainingBalanceInCents >= 1) {
                numberOfCents = remainingBalanceInCents;
                remainingBalanceInCents = 0;
                balanceInSmallestCoins += numberOfCents + " Cents ";
            }

            if(remainingBalanceInCents == 0) {
                continueDeterminingSmallestCoins = false;
            }

        } while(continueDeterminingSmallestCoins);
        return balanceInSmallestCoins;
    }

    public BigDecimal feedMoney(BigDecimal dollars) {
        this.balance = this.balance.add(dollars);
        return this.balance;
    }

    public BigDecimal reduceMoney(BigDecimal purchaseAmount) {
        this.balance = this.balance.subtract(purchaseAmount);
        return this.balance;
    }

}
