package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class InventoryBuilder {
    public List<String> itemName;

//    public InventoryBuilder(List itemName){
//        this.itemName = itemName;
//    }

    public Map<String, Items> getInventory() throws FileNotFoundException {

        File inventoryFile = new File("catering.csv");  //"catering1.csv"
        Map<String, Items> inventory = new HashMap<>();
        try(Scanner scanner = new Scanner(inventoryFile)) {

            while (scanner.hasNextLine()) {
                String lineFromInventory = scanner.nextLine();
                String[] itemInfo = lineFromInventory.split(",");
                Items items;
                if(itemInfo[4].equals("Gum")){
                    items = new Gum(itemInfo[0]);
                } else if(itemInfo[4].equals("Drink")) {
                    items = new Drinks(itemInfo[0]);
                } else if(itemInfo[4].equals("Candy")){
                    items = new Candy(itemInfo[0]);
                } else {
                    items = new Munchies(itemInfo[0]);
                }
                items.setName(itemInfo[1]);
                BigDecimal price = new BigDecimal(itemInfo[2]);
                items.setPrice(price);

                inventory.put(itemInfo[0], items);
                itemName.add(itemInfo[1]);
            }

        }

        return inventory;
    }

    public List<String> getItemName() {
        return itemName;
    }
}

