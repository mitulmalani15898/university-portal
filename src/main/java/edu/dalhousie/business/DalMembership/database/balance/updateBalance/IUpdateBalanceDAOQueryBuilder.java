/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.DalMembership.database.balance.updateBalance;

public interface IUpdateBalanceDAOQueryBuilder {
    String rechargeBalanceQuery(int id,double amount);
}
