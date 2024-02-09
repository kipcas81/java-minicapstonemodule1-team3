package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {

    private Item testItem;

    @Before
    public void setup() {
        testItem = new Item("A1", "Unicorn Pony", 1.50, "Pony", 5, 1);
    }

    @Test
    public void getSlotLocationShouldReturnCorrectSlotLocation() {
        Assert.assertEquals("A1", testItem.getSlotLocation());
    }

    @Test
    public void getItemNameShouldReturnCorrectItemName() {
        Assert.assertEquals("Unicorn Pony", testItem.getItemName());
    }

    @Test
    public void getItemPriceShouldReturnCorrectItemPrice() {
        Assert.assertEquals(1.50, testItem.getItemPrice(), 0.001);
    }

    @Test
    public void getItemTypeShouldReturnCorrectItemType() {
        Assert.assertEquals("Pony", testItem.getItemType());
    }

}