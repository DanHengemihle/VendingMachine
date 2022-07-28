package com.techelevator;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<String, Items> inventory = new HashMap<>();
    private Map<String, Integer> itemStock = new HashMap<>();

    public Inventory(InventoryBuilder inventoryBuilder) throws FileNotFoundException {
        inventory = inventoryBuilder.getInventory();
        for (int i = 0; i < inventoryBuilder.getItemName().size(); i++) {
            itemStock = itemStock.put(inventoryBuilder.getItemName().get(i), 6);
        }
    }



    public Map<String, Integer> getItemStock() {

        return itemStock;
    }
    public Map<String, Items> getInventory() {
        return inventory;
    }

}
