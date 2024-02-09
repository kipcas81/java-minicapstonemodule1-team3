package com.techelevator;

public class Purchase {

    private String[] purchaseMenu = new String[]{"(1) Feed Money","(2) Select Product","(3) Finish Transaction", "(4) Available Money"};

    public void getPurchaseMenu() {
        for(String menu: purchaseMenu) {
            System.out.println(menu);
        }
    }


}
