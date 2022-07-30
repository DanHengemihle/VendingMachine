package com.techelevator;

import java.math.BigDecimal;

public class Balance {
    private BigDecimal balance = new BigDecimal("0");

    public Balance() {
    }


    public BigDecimal getBalance() {
        return balance;
    }

    public void updateBalance(BigDecimal amountAdded) {
        balance = balance.add(amountAdded);
    }
    public void subtractBalance(BigDecimal amountToSubtract){
        balance = balance.subtract(amountToSubtract);
    }
}
