package edu.dalhousie.business.tender.database;

import static edu.dalhousie.business.tender.database.TenderConstants.*;

public class TenderWinnerQueryBuilder implements ITenderWinnerDAOQueryBuilder {
    @Override
    public String updateWinner(String winnerName) {
        return "INSERT INTO " +
                TENDER_TABLE +
                " (bidder) " + "VALUES("+"'"+winnerName+"'"+")";


    }
}
