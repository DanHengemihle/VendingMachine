package com.techelevator.application;

import com.techelevator.*;
import com.techelevator.ui.Menu;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;


public class VendingMachine {
    Menu userInterface = new Menu();
    private Map<String, Item> displayInventory = new HashMap<>();

    public VendingMachine(Inventory inventory) throws FileNotFoundException {
        displayInventory = inventory.getInventory();
    }

    public void run() throws FileNotFoundException {
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
            } if (choice.equals("Purchase Menu")) {
                userInterface.displayPurchaseMenu();
                if (userInterface.getPurchaseOption().equals("Feed Money")) {
                    feedMoney();
                } if (userInterface.getPurchaseOption().equals("Select Item")) {
                    selectItem();
                } if (choice.equals("Exit")) {
                    userInterface.displayMessage("Good Bye");
                    break;

                }
            }
        }
    }

    public void selectItem() throws FileNotFoundException {
        Balance currentBalance = new Balance();
        Stock currentStock = new Stock();

        if (userInterface.menuSelection().equals("s")) {
            for (Map.Entry<String, Item> currentEntry : displayInventory.entrySet()) {
                String itemProperties = currentEntry.getKey() + " " + currentEntry.getValue().getName() + " " + currentEntry.getValue().getPrice();
                //add stock above ^
                System.out.println(itemProperties);
            }
            for (String currentItem : displayInventory.keySet()) {
                if (userInterface.menuSelection().equals(currentItem)) {
                    //change the stock, print name/cost/remaining balance, and return message
                    currentStock.updateStock();
                }
            }
        }
    }

    public void feedMoney() {
        Balance newBalance = new Balance();

        while (!userInterface.menuSelection().equals("Yes")){
            userInterface.feedingMoneyMenu();
            String userInput = userInterface.menuSelection();

                if (userInput.equals("$1") || userInput.equals("1")) {
                    newBalance.updateBalance(Money.ONE_DOLLAR);
                    userInterface.displayMessage("Your balance is " + newBalance.getBalance());
                } else if (userInput.equals("$5") || userInput.equals("5")) {
                    newBalance.updateBalance(Money.FIVE_DOLLARS);
                    userInterface.displayMessage("Your balance is " + newBalance.getBalance());
                } else if (userInput.equals("$10") || userInput.equals("10")) {
                    newBalance.updateBalance(Money.TEN_DOLLARS);
                    userInterface.displayMessage("Your balance is " + newBalance.getBalance());
                } else if (userInput.equals("$20") || userInput.equals("20")) {
                    newBalance.updateBalance(Money.TWENTY_DOLLARS);
                    userInterface.displayMessage("Your balance is " + newBalance.getBalance());
                } else if (userInput.toLowerCase().equals("yes")){
                    userInterface.displayPurchaseMenu();
                } else userInterface.displayMessage("Invalid money amount.");


        }
    }
}

