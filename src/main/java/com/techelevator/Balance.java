package com.techelevator;

import java.math.BigDecimal;

public class Balance {
    private BigDecimal balance;

    public BigDecimal getBalance() {

        return balance;
    }
    public void updateBalance(BigDecimal amountAdded) {
        balance.add(amountAdded);
    }
}
