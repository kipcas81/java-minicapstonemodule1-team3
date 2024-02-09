package com.techelevator;
import org.junit.Test;
import java.math.BigDecimal;
import java.math.RoundingMode;
import static org.junit.Assert.assertEquals;

public class MoneyTest {

    @Test
    public void FeedMoneyTest() {
        Money money = new Money();
        BigDecimal initialBalance = new BigDecimal(0);
        money.setBalance(initialBalance);

        BigDecimal feedAmount = new BigDecimal(10);
        BigDecimal expectedBalance = initialBalance.add(feedAmount);

        BigDecimal newBalance = money.feedMoney(feedAmount);

        assertEquals(expectedBalance, newBalance);
    }

}
