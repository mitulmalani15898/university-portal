package edu.dalhousie.business.Events.database;
import static edu.dalhousie.business.Events.database.WinnerConstant.*;

public class InsertWinnerNameQueryBuilder implements IInsertWinnerNameDAOQueryBuilder{
    @Override
    public String insertWinnerName(String winnerName) {
        return "INSERT INTO" +
                WINNER_TABLE +
                "(" + WINNER_NAME + ")" +
                "VALUES" + "(" + winnerName + ")";

    }
}
