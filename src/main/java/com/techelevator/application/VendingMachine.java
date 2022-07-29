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
            if (choice.equals("display")) {
                for (Map.Entry<String, Item> currentEntry : displayInventory.entrySet()) {
                    String itemProperties = currentEntry.getKey() + " " + currentEntry.getValue().getName() + " " + currentEntry.getValue().getPrice();
                    //add stock above ^
                    System.out.println(itemProperties);

                }
            } else if (choice.equals("purchase")) {
                userInterface.displayMessage(">(M) Feed Money");
                userInterface.displayMessage(">(S) Select Item");
                userInterface.displayMessage(">(F) Finish Transaction");
            } else if (choice.equals("Exit")) {
                userInterface.displayMessage("Good Bye");
                break;
            }


        }
    }

    public Balance feedMoney() {
        Balance newBalance = new Balance();
        Money fedMoney = new Money();
        BigDecimal balance = new BigDecimal(0);
        if (userInterface.getPurchaseOption().equals("Feed Money")) {
            userInterface.displayMessage("Insert your cash");
            userInterface.displayMessage("$1");
            userInterface.displayMessage("$5");
            userInterface.displayMessage("$10");
            userInterface.displayMessage("$20");
        }
        if (userInterface.getPurchaseOption().equals("$1")) {
            newBalance.updateBalance(new BigDecimal(1));
        }
        if (userInterface.getPurchaseOption().equals("$5")) {
            newBalance.updateBalance(new BigDecimal(5));
        }
        if (userInterface.getPurchaseOption().equals("$10")) {
            newBalance.updateBalance(new BigDecimal(10));
            {
            }
            if (userInterface.getPurchaseOption().equals("$20")) {
                newBalance.updateBalance(new BigDecimal(20));
            }
        }
        return newBalance;
    }
}