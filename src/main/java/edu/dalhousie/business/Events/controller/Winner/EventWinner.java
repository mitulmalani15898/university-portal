package edu.dalhousie.business.Events.controller.Winner;
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

    public void setWinnerName() {
        this.studentView.showMessage("Enter Winner name:");
        winnerName = this.studentView.getString();
    }


}
