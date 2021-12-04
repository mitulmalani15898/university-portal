package edu.dalhousie.business.Events.controller.Cost;

import edu.dalhousie.presentation.StudentView;

public class EventCost {
    public StudentView studentView;
    public EventCost(){
        this.studentView = new StudentView();
    }
    public void studentPayment(int num)
    {
        this.studentView.showMessage("Payment got from Students : $"+ (num) * 10);
    }
}
