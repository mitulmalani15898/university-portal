package edu.dalhousie.business.DalMembership.database.subscription;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UpdateSubscriptionQueryBuilderTest {
    @Test
    public void updateSubscriptionQuery(){
        UpdateSubscriptionQueryBuilder updateSubscriptionQueryBuilder
                = new UpdateSubscriptionQueryBuilder();
        String actualQuery = updateSubscriptionQueryBuilder
                .updateSubscriptionQuery(1,"bronze");
        String expectedQuery =  "UPDATE membership_details " +
                "SET subscription = 'bronze' WHERE member_id = 1";
        assertEquals(expectedQuery,actualQuery);
    }
}
