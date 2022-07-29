package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item{

    public Candy(String slotIdentifier) {
        super(slotIdentifier);
    }

    @Override
    public String itemMessage() {
        return null;
    }
}
