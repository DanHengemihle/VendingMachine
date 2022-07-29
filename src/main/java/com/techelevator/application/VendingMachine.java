package com.techelevator.application;

import com.techelevator.Balance;
import com.techelevator.Inventory;
import com.techelevator.Item;
import com.techelevator.Money;
import com.techelevator.ui.Menu;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class VendingMachine {
    Menu userInterface = new Menu();
    private Map<String, Item> displayInventory = new HashMap<>();

    public VendingMachine(Inventory inventory) throws FileNotFoundException {
        displayInventory = inventory.getInventory();
    }

    public void run() {
        while (true) {
            userInterface.displayHomeScreen();
            String choice = userInterface.getHomeScreenOption();
            String purchaseChoice = userInterface.getPurchaseOption();
            // Item testItem = displayInventory.get("A1");

            userInterface.displayMessage(choice);
            if (choice.equals("Items List")) {
                for (Map.Entry<String, Item> currentEntry : displayInventory.entrySet()) {
                    String itemProperties = currentEntry.getKey() + " " + currentEntry.getValue().getName() + " " + currentEntry.getValue().getPrice();
                    //add stock above ^
                    System.out.println(itemProperties);
                }
            } else if (choice.equals("Purchase Menu")) {
                userInterface.displayPurchaseMenu();
                if (userInterface.getPurchaseOption().equals("Feed Money")) ;
                feedMoney();
            } else if (choice.equals("Exit")) {
                userInterface.displayMessage("Good Bye");
                break;

            }
        }
    }

    public void feedMoney() {
        Balance newBalance = new Balance();

        userInterface.displayMessage("Insert your cash");
        userInterface.displayMessage("$1");
        userInterface.displayMessage("$5");
        userInterface.displayMessage("$10");
        userInterface.displayMessage("$20");
        userInterface.displayMessage("Done feeding money?");
        userInterface.displayMessage("Yes or No");


        while (!userInterface.menuSelection().equals("Yes")){
                if (userInterface.menuSelection().equals("$1")) {
                    newBalance.updateBalance(Money.dollar);
                    userInterface.displayMessage("Your balance is " + newBalance.getBalance());
                } else if (userInterface.menuSelection().equals("$5")) {
                    newBalance.updateBalance(new BigDecimal("5"));
                    userInterface.displayMessage("Your balance is " + newBalance.getBalance());
                } else if (userInterface.menuSelection().equals("$10")) {
                    newBalance.updateBalance(new BigDecimal("10"));
                    userInterface.displayMessage("Your balance is " + newBalance.getBalance());
                } else if (userInterface.menuSelection().equals("$20")) {
                    newBalance.updateBalance(new BigDecimal("20"));
                    userInterface.displayMessage("Your balance is " + newBalance.getBalance());
                } else if (userInterface.menuSelection().equals("Yes")){
                    userInterface.displayPurchaseMenu();
                } else userInterface.displayMessage("Invalid money amount.");
        }
    }
}

