package com.techelevator.application;

import com.techelevator.Inventory;
import com.techelevator.Item;
import com.techelevator.ui.Menu;

import java.io.FileNotFoundException;
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
        while(true) {
            userInterface.displayHomeScreen();
            String choice = userInterface.getHomeScreenOption();
            String purchaseChoice = userInterface.getPurchaseOption();

            System.out.println(choice);
            if(choice.equals("display")) {
                for (Map.Entry<String, Item> currentEntry : displayInventory.entrySet()) {
                    String itemProperties = currentEntry.getKey()  + " " + currentEntry.getValue().getName() + " " + currentEntry.getValue().getPrice();
                    //add stock above ^
                    System.out.println(itemProperties);

                }
            }
            else if(choice.equals("purchase")) {
                System.out.println(">(M) Feed Money");
                System.out.println(">(S) Select Item");
                System.out.println(">(F) Finish Transaction");
            }
            else if(choice.equals("Exit")) {
                System.out.println("Good Bye");
                break;
            }

        }
    }
}
