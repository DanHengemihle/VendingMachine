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
            // Item testItem = displayInventory.get("A1");

            //      userInterface.displayMessage(choice);
            if (choice.equals("Items List")) {
                for (Map.Entry<String, Item> currentEntry : displayInventory.entrySet()) {
                    String itemProperties = currentEntry.getKey() + " " + currentEntry.getValue().getName() + " " + currentEntry.getValue().getPrice();
                    //add stock above ^
                    System.out.println(itemProperties);
                }
            }

            if (choice.equals("Purchase Menu")) {
                userInterface.displayPurchaseMenu();
                 String purchaseChoice = userInterface.getPurchaseOption();
                if (purchaseChoice.equals("Select Item")) {
                    selectItem();
                }
                if (purchaseChoice.equals("Feed Money")) {
                    feedMoney();
                }
            }

            if (choice.equals("Exit")) {
                userInterface.displayMessage("Good Bye");
                break;

            }
        }
    }


    public void selectItem() throws FileNotFoundException {
        Balance currentBalance = new Balance();
        Stock currentStock = new Stock();

        userInterface.displayMessage("Make your selection. Choose the slot identifier desired.");

        for (Map.Entry<String, Item> currentEntry : displayInventory.entrySet()) {
            String itemProperties = currentEntry.getKey() + " " + currentEntry.getValue().getName() + " " + currentEntry.getValue().getPrice();
            //add stock above ^
            System.out.println(itemProperties);
        }

            String userInput = userInterface.selectItemMenuOption();
            if (displayInventory.containsKey(userInput)) {
                //change the stock, print name/cost/remaining balance, and return message
                currentStock.updateStock();
                currentBalance.subtractBalance(displayInventory.get(userInput).getPrice());
                userInterface.displayMessage("Dispensing " + displayInventory.get(userInput).getName() + " " + displayInventory.get(userInput).getPrice() + " " + currentBalance.getBalance());
            }

    }


    public void feedMoney() {
        Balance newBalance = new Balance();
        String userInput = "";
        userInterface.feedingMoneyMenu();
        while (!userInput.equals("Yes")) {
            userInput = userInterface.feedMoneyMenuSelection();


            if (userInput.equals("$1") || userInput.equals("1")) {
                newBalance.updateBalance(Money.ONE_DOLLAR);
                userInterface.displayMessage("Your balance is " + newBalance.getBalance());
                userInterface.doneFeedingMenu();
            } else if (userInput.equals("$5") || userInput.equals("5")) {
                newBalance.updateBalance(Money.FIVE_DOLLARS);
                userInterface.displayMessage("Your balance is " + newBalance.getBalance());
                userInterface.doneFeedingMenu();
            } else if (userInput.equals("$10") || userInput.equals("10")) {
                newBalance.updateBalance(Money.TEN_DOLLARS);
                userInterface.displayMessage("Your balance is " + newBalance.getBalance());
                userInterface.doneFeedingMenu();
            } else if (userInput.equals("$20") || userInput.equals("20")) {
                newBalance.updateBalance(Money.TWENTY_DOLLARS);
                userInterface.displayMessage("Your balance is " + newBalance.getBalance());
                userInterface.doneFeedingMenu();
            }
            else if (userInput.equalsIgnoreCase("yes")) {
                break;
            } else userInterface.displayMessage("Invalid money amount.");


        }
    }
}

