package com.techelevator.application;

import com.techelevator.*;
import com.techelevator.ui.Menu;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;


public class VendingMachine {
    Menu userInterface = new Menu();
    Stock currentStock = new Stock();
    Balance currentBalance = new Balance();
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
                    String itemProperties = currentEntry.getKey() + " " + currentEntry.getValue().getName()
                            + " " + currentEntry.getValue().getPrice() + " " + currentStock.getStock().get(currentEntry.getKey());
                    //add stock above ^
                    userInterface.displayMessage(itemProperties);
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
/*                    ????????????? TO DO LIST ???????????????
*
*fix stock
*
* if balance isnt enough, notify
*
*  if wrong input for slot identifier, notify
*
*  add the messages to dispenseing
*
*  after finish transaction, give change in largest possible coins, update balance to zero
*  put them back at the main menu^
*
* audit print to a new file
*
* unit tests
*
* *//////////////////////////////////////////////////////////////////

    public void selectItem() throws FileNotFoundException {

        userInterface.displayMessage("Make your selection. Choose the slot identifier desired.");

        for (Map.Entry<String, Item> currentEntry : displayInventory.entrySet()) {
            String itemProperties = currentEntry.getKey() + " " + currentEntry.getValue().getName()
                    + " " + currentEntry.getValue().getPrice();
            //add stock above ^
            System.out.println(itemProperties);
        }

            String userInput = userInterface.selectItemMenuOption();
            if (displayInventory.containsKey(userInput)) {
                //change the stock, print name/cost/remaining balance, and return message
                currentStock.updateStock(userInput);
                currentBalance.subtractBalance(displayInventory.get(userInput).getPrice());
                userInterface.displayMessage("Dispensing " + displayInventory.get(userInput).getName()
                + " " + displayInventory.get(userInput).getPrice() + " " + currentBalance.getBalance());
            }

    }


    public void feedMoney() {
//        Balance newBalance = new Balance();
        String userInput = "";
        userInterface.feedingMoneyMenu();
        while (!userInput.equals("Yes")) {
            userInput = userInterface.feedMoneyMenuSelection();


            if (userInput.equals("$1") || userInput.equals("1")) {
                currentBalance.updateBalance(Money.ONE_DOLLAR);
                userInterface.displayMessage("Your balance is " + currentBalance.getBalance());
                userInterface.doneFeedingMenu();
            } else if (userInput.equals("$5") || userInput.equals("5")) {
                currentBalance.updateBalance(Money.FIVE_DOLLARS);
                userInterface.displayMessage("Your balance is " + currentBalance.getBalance());
                userInterface.doneFeedingMenu();
            } else if (userInput.equals("$10") || userInput.equals("10")) {
                currentBalance.updateBalance(Money.TEN_DOLLARS);
                userInterface.displayMessage("Your balance is " + currentBalance.getBalance());
                userInterface.doneFeedingMenu();
            } else if (userInput.equals("$20") || userInput.equals("20")) {
                currentBalance.updateBalance(Money.TWENTY_DOLLARS);
                userInterface.displayMessage("Your balance is " + currentBalance.getBalance());
                userInterface.doneFeedingMenu();
            }
            else if (userInput.equalsIgnoreCase("yes")) {
                break;
            } else userInterface.displayMessage("Invalid money amount.");


        }
    }
}

