package edu.dalhousie.business.dalmembership.database.balance.updateBalance;

import static edu.dalhousie.business.dalmembership.database.MembershipDetailsConstant.*;

public class UpdateBalanceQueryBuilder implements IUpdateBalanceDAOQueryBuilder {
    @Override
    public String rechargeBalanceQuery(int id, double amount) {
        return "UPDATE "+
                MEMBERSHIP_TABLE +
                " SET " +
                BALANCE + " = " + BALANCE + " + " + amount +
                " WHERE "+
                MEMBER_ID +" = " + id;
    }
}
