package com.techelevator;

import com.techelevator.ui.Menu;

import java.io.FileNotFoundException;
import java.util.Map;

public class Stock extends Inventory{
    private int startingStock = 6;
    private Map<String, Integer> stock;
    Menu userInterface = new Menu();

    public Stock() throws FileNotFoundException {

    }

    public Map<String, Integer> getStock() {
        return stock;
    }

    public void updateStock() {
        for (String slotIdentifier : getStock().keySet()) {
            if (slotIdentifier.equals(userInterface.menuSelection())) {
                stock.replace(slotIdentifier, (startingStock -= 1));
            }
        }
    }

    public void startingStock () throws FileNotFoundException {
        for(String slotIdentifier : getInventory().keySet()){
            stock.put(slotIdentifier, startingStock);
        }
    }
}
