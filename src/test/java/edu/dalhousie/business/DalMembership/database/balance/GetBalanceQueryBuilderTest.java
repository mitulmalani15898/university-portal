package edu.dalhousie.business.DalMembership.database.balance;

import edu.dalhousie.business.DalMembership.database.balance.getBalance.GetBalanceQueryBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GetBalanceQueryBuilderTest {
    @Test
    public void selectBalanceQuery(){
        GetBalanceQueryBuilder getBalanceQueryBuilder
                = GetBalanceQueryBuilder.getInstance();
        String expectedQuery = getBalanceQueryBuilder.selectBalanceQuery(1);
        String actualQuery = "SELECT balance FROM membership_details " +
                "WHERE member_id = 1";
        assertEquals(expectedQuery,actualQuery);
    }
}
