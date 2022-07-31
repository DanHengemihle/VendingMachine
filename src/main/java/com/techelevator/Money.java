package com.techelevator;

import com.techelevator.ui.Menu;

import java.math.BigDecimal;

public class Money extends Balance {
    public static final BigDecimal ONE_DOLLAR = new BigDecimal("1.00");
    public static final BigDecimal QUARTER = new BigDecimal("0.25");
    public static final BigDecimal DIME = new BigDecimal("0.10");
    public static final BigDecimal NICKEL = new BigDecimal("0.05");
    public static final BigDecimal FIVE_DOLLARS = new BigDecimal("5.00");
    public static final BigDecimal TEN_DOLLARS = new BigDecimal("10.00");
    public static final BigDecimal TWENTY_DOLLARS = new BigDecimal("20.00");

//    public void dispenseChange () {
//        Menu menu = new Menu();
//        BigDecimal zero = new BigDecimal(0);
//
//        while (getBalance().compareTo(zero) > 0) {
////            for (BigDecimal i = new BigDecimal(0); i.compareTo(current.getBalance()) < 0; i.add(iterator)) {
//
//                while (getBalance().compareTo(ONE_DOLLAR) > 0) {
//                    subtractBalance(ONE_DOLLAR);
//                    menu.displayMessage("Dispensing One Dollar");
//                }
//                while (getBalance().compareTo(QUARTER) > 0) {
//                    subtractBalance(QUARTER);
//                    menu.displayMessage("Dispensing One Quarter");
//                }
//                while (getBalance().compareTo(DIME) > 0) {
//                    subtractBalance(DIME);
//                    menu.displayMessage("Dispensing One Dime");
//                }
//                while (getBalance().compareTo(NICKEL) > 0) {
//                    subtractBalance(NICKEL);
//                    menu.displayMessage("Dispensing One Nickel");
//            }
//            }
//
//    }
    //update change to give


}
