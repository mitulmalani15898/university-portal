/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.model.Judge;

import edu.dalhousie.presentation.IStudentView;
import edu.dalhousie.presentation.StudentView;

public class EventJudge {
    public IStudentView studentView;
    private String judgeName;

    public EventJudge(){
        this.studentView = StudentView.getInstance();
    }

    public String getJudgeName() {
        return judgeName;
    }

    public void setJudgeName() {
        this.studentView.showMessage("Enter judge name:");
        this.judgeName = this.studentView.getString();
    }



}
