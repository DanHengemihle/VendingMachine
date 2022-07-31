package com.techelevator;

import com.techelevator.ui.Menu;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Stock extends Inventory{
    public int startingStock = 6;
   public Map<String, Integer> stock = new HashMap<>();
    Menu userInterface = new Menu();

    public Stock() throws FileNotFoundException {
    }
    Map<String, Integer> stockFill = new HashMap<>();
    public Map<String, Integer> stockFiller() throws FileNotFoundException {
        // Map<String, Integer> stockFill = new HashMap<>();
        for (String slotIdentifier : getInventory().keySet()) {
            stockFill.put(slotIdentifier, startingStock);
        }
        return stockFill;
    }

    public Map<String, Integer> getStock(){
    return stockFill;
}



    public void updateStock(String userInput){
        for (String slotIdentifier : getStock().keySet()) {
            if (userInput.equals(slotIdentifier)) {
                int number = getStock().get(slotIdentifier);
                getStock().replace(slotIdentifier, number - 1);
            }
        }
    }



}
