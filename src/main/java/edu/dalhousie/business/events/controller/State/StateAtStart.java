/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.controller.State;

import edu.dalhousie.presentation.StudentView;

public class StateAtStart implements State{
    public StudentView studentView;

    public StateAtStart(){
        this.studentView = new StudentView();
    }
    @Override
    public void performStateTransition(StateContext stateContext) {
        if (stateContext == null) {
            stateContext = new StateContext();
        }
        this.studentView.showMessage("Event starts");
        stateContext.setState(this);
    }
}
