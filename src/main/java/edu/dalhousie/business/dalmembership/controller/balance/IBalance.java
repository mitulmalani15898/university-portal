/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.dalmembership.controller.balance;

import edu.dalhousie.database.DatabaseConnection;

public interface IBalance {
    void showExistingBalance(DatabaseConnection databaseConnection);
    void rechargeBalance(DatabaseConnection databaseConnection, double amount) throws Exception;
}
