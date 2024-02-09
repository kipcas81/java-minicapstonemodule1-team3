package com.techelevator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import static org.junit.Assert.assertTrue;

public class TransactionsLogTest {

    private TransactionsLog transactionsLog;
    private TemporaryFolder tempFolder;

    @Before
    public void setup() {
        transactionsLog = new TransactionsLog();
        tempFolder = new TemporaryFolder();
        try {
            tempFolder.create();
            File tempFile = tempFolder.newFile("Test.txt");
            transactionsLog.LOG_FILE = tempFile.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void LogTransactionTest() {
        BigDecimal initialBalance = new BigDecimal(10);
        Money money = new Money();
        money.setBalance(initialBalance);
        BigDecimal feedAmount = new BigDecimal(5);
        Item item = new Item("A1", "Unicorn Pony", 1.50, "Pony", 5, 1);

        transactionsLog.logTransaction("1", money, feedAmount, null);
        transactionsLog.logTransaction("2", money, feedAmount, item);
        transactionsLog.logTransaction("3", money, feedAmount, null);

        assertTrue(new File(transactionsLog.LOG_FILE).exists());
    }

}
