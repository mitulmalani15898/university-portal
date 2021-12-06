/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.dalmembership.controller.balance;

import edu.dalhousie.business.dalmembership.database.balance.getBalance.GetBalanceQueryBuilder;
import edu.dalhousie.business.dalmembership.database.balance.updateBalance.UpdateBalanceQueryBuilder;
import edu.dalhousie.controllers.UserSession;
import edu.dalhousie.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Balance implements IBalance{
    UserSession userSession;
    GetBalanceQueryBuilder balanceQueryBuilder;
    UpdateBalanceQueryBuilder rechargeBalanceQueryBuilder;
    public Balance(){
        userSession = UserSession.getInstance();
        this.balanceQueryBuilder = GetBalanceQueryBuilder.getInstance();
    }
    @Override
    public void showExistingBalance(DatabaseConnection databaseConnection) {
        try {
            final Connection connection =
                    databaseConnection.getDatabaseConnection();
            final Statement statement =
                    connection.createStatement();
            final ResultSet balanceAmount = statement
                    .executeQuery(
                            this.balanceQueryBuilder
                            .selectBalanceQuery(userSession.getUser().getUserId())
            );
            while (balanceAmount.next()) {
                System.out.println("The balance available in your account is: "
                        + balanceAmount.getInt("balance"));
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void rechargeBalance(DatabaseConnection databaseConnection,double amount){
        try {
            final Connection connection =
                    databaseConnection.getDatabaseConnection();
            final Statement statement =
                    connection.createStatement();
            statement.executeUpdate(this.rechargeBalanceQueryBuilder
                    .rechargeBalanceQuery(
                            userSession.getUser().getUserId(), amount
            ));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
