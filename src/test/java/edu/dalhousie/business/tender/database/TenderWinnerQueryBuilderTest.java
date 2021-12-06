package edu.dalhousie.business.tender.database;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TenderWinnerQueryBuilderTest {
    @Test
    public void updateWinner(){
        TenderWinnerQueryBuilder tenderWinnerQueryBuilder
                = new TenderWinnerQueryBuilder();
        String expectedQuery = tenderWinnerQueryBuilder.updateWinner("flash");
        String actualQuery = "INSERT INTO tender (bidder) VALUES('flash')";
        assertEquals(expectedQuery,actualQuery);
    }
}
