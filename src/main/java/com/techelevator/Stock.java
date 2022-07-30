package com.techelevator;

import com.techelevator.ui.Menu;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Stock extends Inventory{
    public int startingStock = 6;
    //public Map<Item, Integer> stock;
    Menu userInterface = new Menu();

    public Stock() throws FileNotFoundException {
    }


public Map<Item, Integer> getStock() throws FileNotFoundException {
    Map<Item, Integer> stock = new HashMap<>();
    for (Item slotIdentifier : getInventory().values()) {
        stock.put(slotIdentifier, startingStock);
    }
    return stock;
}

    public void updateStock() throws FileNotFoundException {
        String userInput = userInterface.selectItemMenuOption();
        for (Item slotIdentifier : getStock().keySet()) {
            if (userInput.equals(slotIdentifier.getSlotIdentifier())) {
                getStock().replace(slotIdentifier, (startingStock -= 1));
            }
        }
    }



}
