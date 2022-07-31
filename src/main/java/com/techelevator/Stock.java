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
//    Map<String, Integer> stockFill = new HashMap<>();
    public void stockFiller() throws FileNotFoundException {
        Map<String, Integer> stockFill = new HashMap<>();
        for (String slotIdentifier : getInventory().keySet()) {
            this.stock.put(slotIdentifier, startingStock);
//            if (userInput.equals(slotIdentifier)) {
//                int number = stockFill.get(slotIdentifier);
//                stockFill.replace(slotIdentifier, number - 1);
//            }
//        }
//        return stockFill;
        }
    }


    public void updateStock(String userInput){
        for (String slotIdentifier : getStock().keySet()) {
            if (userInput.equals(slotIdentifier)) {
                int number = getStock().get(slotIdentifier);
                this.stock.replace(slotIdentifier, number - 1);
            }
        }
    }


    public Map<String, Integer> getStock(){
        return this.stock;
    }



}
