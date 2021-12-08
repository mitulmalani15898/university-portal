/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.controller.Cost;

import edu.dalhousie.presentation.IStudentView;
import edu.dalhousie.presentation.StudentView;

public class EventCost {
    public IStudentView studentView;

    public EventCost() {
        this.studentView = StudentView.getInstance();
    }

    public void studentPayment(int num) {
        this.studentView.showMessage("The overall cost for " +
                "the event is estimated to be : $" + (num) * 10);
    }
}
