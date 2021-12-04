package edu.dalhousie.business.Events.model.Winner;
import edu.dalhousie.presentation.StudentView;

public class EventWinner {
    String winnerName;
    public StudentView studentView;

    public EventWinner(){
        this.studentView = new StudentView();
    }

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }


}
