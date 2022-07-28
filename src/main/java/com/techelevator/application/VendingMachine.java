package com.techelevator.application;

import com.techelevator.ui.UserInterface;


public class VendingMachine {
    UserInterface userInterface = new UserInterface();

    public void run() {
        while(true) {
            userInterface.displayHomeScreen();
            String choice = userInterface.getHomeScreenOption();

            System.out.println(choice);
            if(choice.equals("display")) {
                // display the items
            }
            else if(choice.equals("purchase")) {
                // make a purchase
            }
            else if(choice.equals("exit")) {
                // good bye
                break;
            }
        }
    }
}
