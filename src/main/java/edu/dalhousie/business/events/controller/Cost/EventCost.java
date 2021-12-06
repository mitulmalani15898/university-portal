/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.controller.Cost;

import edu.dalhousie.presentation.StudentView;

public class EventCost {
    public StudentView studentView;

    public EventCost() {
        this.studentView = new StudentView();
    }

    public void studentPayment(int num) {
        this.studentView.showMessage("The overall cost for " +
                "the event is estimated to be : $" + (num) * 10);
    }
}
