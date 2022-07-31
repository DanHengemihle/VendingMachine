package com.techelevator.application;

import com.techelevator.*;
import com.techelevator.ui.Menu;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

import static com.techelevator.Money.*;


public class VendingMachine {
    Menu userInterface = new Menu();
    Stock currentStock = new Stock();
    Balance currentBalance = new Balance();
    Money dispenser = new Money();
    private Map<String, Item> displayInventory = new HashMap<>();

    public VendingMachine(Inventory inventory) throws FileNotFoundException {
        displayInventory = inventory.getInventory();
    }

    public void run() throws FileNotFoundException {
        while (true) {
            userInterface.displayHomeScreen();
            String choice = userInterface.getHomeScreenOption();
            // Item testItem = displayInventory.get("A1");
//            String userInput = userInterface.selectItemMenuOption();
            //      userInterface.displayMessage(choice);
            if (choice.equals("Items List")) {
                for (Map.Entry<String, Item> currentEntry : displayInventory.entrySet()) {
                    String itemProperties = currentEntry.getKey() + " " + currentEntry.getValue().getName()
                            + " " + currentEntry.getValue().getPrice()
                            + " " + currentStock.stockFiller("").get(currentEntry.getKey());
                    //add stock above ^
                    userInterface.displayMessage(itemProperties);
                }
            }

           else if (choice.equals("Purchase Menu")) {
                userInterface.displayPurchaseMenu();
                 String purchaseChoice = userInterface.getPurchaseOption();
                if (purchaseChoice.equals("Select Item")) {
                    selectItem();
                }
                if (purchaseChoice.equals("Feed Money")) {
                    feedMoney();
                }
                if (purchaseChoice.equals("Finish Transaction")) {
                    dispenseChange();
                }
            }

           else if (choice.equals("Exit")) {
                userInterface.displayMessage("Good Bye");
                break;
            } else userInterface.displayMessage("Invalid input, try again.");
        }
    }
/*                    ????????????? TO DO LIST ???????????????
*
*fix stock
*
*
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
            userInterface.displayMessage(itemProperties);
        }

           String userInput = userInterface.selectItemMenuOption();

        if (!displayInventory.containsKey(userInput)) {
            userInterface.displayMessage("Invalid Slot Identifier. Try Again");
        }

            else if (currentBalance.getBalance().compareTo(displayInventory.get(userInput).getPrice()) < 0){
                userInterface.displayMessage("Not enough money for this item.");
            }

            else if (displayInventory.containsKey(userInput)) {
                //change the stock, print name/cost/remaining balance, and return message
                String type = displayInventory.get(userInput).getType();
                currentStock.stockFiller(userInput); // double check
                currentBalance.subtractBalance(displayInventory.get(userInput).getPrice());
                userInterface.displayMessage("Dispensing " + displayInventory.get(userInput).getName()
                + " " + displayInventory.get(userInput).getPrice() + " " + currentBalance.getBalance() + " " +
                        getMessage(userInput));
//                currentBalance.setBalance(currentBalance.getBalance());
            }

    }

    public String getMessage (String userInput){
        Candy candy = new Candy(userInput);
        Drink drink = new Drink(userInput);
        Gum gum = new Gum(userInput);
        Munchy munchy = new Munchy(userInput);
        String type = displayInventory.get(userInput).getType();
        if (type.equals("Candy")){
            return candy.itemMessage();
        } if (type.equals("Drink")){
            return drink.itemMessage();
        } if (type.equals("Gum")){
            return gum.itemMessage();
        } if (type.equals("Munchy")){
            return munchy.itemMessage();
        }
        return "";
    }


    public void feedMoney() {
//        Balance newBalance = new Balance();
        String userInput = "";
        userInterface.feedingMoneyMenu();
        while (!userInput.equals("Yes")) {
            userInput = userInterface.feedMoneyMenuSelection();


            if (userInput.equals("$1") || userInput.equals("1")) {
                currentBalance.updateBalance(ONE_DOLLAR);
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
    public void dispenseChange () {
//        Menu menu = new Menu();
//        Money money = new Money();
        BigDecimal zero = new BigDecimal(0);

        while (currentBalance.getBalance().compareTo(zero) > 0) {
//            for (BigDecimal i = new BigDecimal(0); i.compareTo(current.getBalance()) < 0; i.add(iterator)) {

            while (currentBalance.getBalance().compareTo(ONE_DOLLAR) >= 0) {
                currentBalance.subtractBalance(ONE_DOLLAR);
                userInterface.displayMessage("Dispensing One Dollar");
            }
            while (currentBalance.getBalance().compareTo(QUARTER) >= 0) {
                currentBalance.subtractBalance(QUARTER);
                userInterface.displayMessage("Dispensing One Quarter");
            }
            while (currentBalance.getBalance().compareTo(DIME) >= 0) {
                currentBalance.subtractBalance(DIME);
                userInterface.displayMessage("Dispensing One Dime");
            }
            while (currentBalance.getBalance().compareTo(NICKEL) >= 0) {
                currentBalance.subtractBalance(NICKEL);
                userInterface.displayMessage("Dispensing One Nickel");
            }
        }

    }
}

