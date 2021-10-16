package edu.dalhousie;

import edu.dalhousie.database.DatabaseConnectivity;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world");
        DatabaseConnectivity db = new DatabaseConnectivity();
        db.connectWithDataBase();
    }
}
