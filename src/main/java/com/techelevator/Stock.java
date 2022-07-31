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


public Map<String, Integer> getStock() throws FileNotFoundException {
    Map<String, Integer> stock = new HashMap<>();
    for (String slotIdentifier : getInventory().keySet()) {
        stock.put(slotIdentifier, startingStock);
    }
    return stock;
}
// choose between these two above and below
    public Map<String, Integer> stockFiller() throws FileNotFoundException {
        Map<String, Integer> stock = new HashMap<>();
        for (String slotIdentifier : getInventory().keySet()) {
            stock.put(slotIdentifier, startingStock);
        }
        return stock;
    }

    public void updateStock(String userInput) throws FileNotFoundException {
      //  String userInput = userInterface.selectItemMenuOption();
        for (String slotIdentifier : getStock().keySet()) {
            if (userInput.equals(slotIdentifier)) {
                int number = getStock().get(slotIdentifier);
                getStock().replace(slotIdentifier, number-1);
            }
        }
    }



}
