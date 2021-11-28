package edu.dalhousie.business.Events.controller.Judge;

import edu.dalhousie.presentation.StudentView;

public class EventJudge {
    public StudentView studentView;

    private String judgeName;
    public EventJudge(){
        this.studentView = new StudentView();
    }
    public String getJudgeName() {
        return judgeName;
    }

    public void setJudgeName() {
        this.studentView.showMessage("Enter judge name:");
        String judgeName = this.studentView.getString();
        this.judgeName = judgeName;
    }



}
