package edu.dalhousie.business.DalMembership.database.subscription;

import static edu.dalhousie.business.DalMembership.database.MembershipDetailsConstant.*;

public class UpdateSubscriptionQueryBuilder implements IUpdateSubscriptionDAOQueryBuilder{
    @Override
    public String updateSubscriptionQuery(int id,String subscription) {
        return  "UPDATE "+
                MEMBERSHIP_TABLE +
                " SET " +
                SUBSCRIPTION + " = '" + subscription + "'" +
                " WHERE "+
                MEMBER_ID +" = " + id;
    }
}
