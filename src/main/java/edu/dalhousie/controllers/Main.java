package edu.dalhousie.controllers;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        WelcomeClass welcome = new WelcomeClass();
        welcome.displayWelcomeScreen();
    }
}
