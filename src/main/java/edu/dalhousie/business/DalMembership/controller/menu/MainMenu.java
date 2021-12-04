package edu.dalhousie.business.DalMembership.controller.menu;

import edu.dalhousie.business.DalMembership.controller.inMemoryDatabase.MasterDB;

public abstract class MainMenu {
    int count = 1;
    private void welcomeMessage() {

        System.out.println("Welcome to Dalhousie student Membership");
    }
    private void startUp() {

        System.out.println("Please wait while the menu is loaded");
    }
    public void printMenu() {
        System.out.println("Please select an option:");
        MasterDB.menu.stream().forEach(x -> {
            System.out.println(count + ". " + x);
            count++;

        });
        count = 1;
    }
    public final void start() {
        welcomeMessage();
        startUp();
        printMenu();
    }
}
