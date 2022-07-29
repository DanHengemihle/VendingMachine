package com.techelevator;

import java.io.FileNotFoundException;
import java.util.Map;

public class Stock extends Inventory{
    private int startingStock = 6;
    private Map<String, Integer> stock;

    public Stock() throws FileNotFoundException {

    }

    public void updatedStock () throws FileNotFoundException {
        for(String slotIdentifier : getInventory().keySet()){
            stock.put(slotIdentifier, startingStock);
        }
    }
}
