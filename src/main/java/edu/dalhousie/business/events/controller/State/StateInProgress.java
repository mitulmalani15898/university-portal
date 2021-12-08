/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.controller.State;

import edu.dalhousie.presentation.IStudentView;
import edu.dalhousie.presentation.StudentView;

public class StateInProgress implements State{
    public IStudentView studentView;

    public StateInProgress(){
        this.studentView = StudentView.getInstance();
    }

    @Override
    public void performStateTransition(StateContext stateContext) {
        if (stateContext == null) {
            stateContext = new StateContext();
        }
        this.studentView.showMessage("Event is in progress");
        stateContext.setState(this);
    }
}
