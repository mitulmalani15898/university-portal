package edu.dalhousie.business.Tender.database;

import static edu.dalhousie.business.Tender.database.TenderConstants.*;

public class TenderWinnerQueryBuilder implements ITenderWinnerDAOQueryBuilder {
    @Override
    public String updateWinner(String winnerName) {
        return "INSERT INTO " +
                TENDER_TABLE +
                " (bidder) " + "VALUES("+"'"+winnerName+"'"+")";


    }
}
