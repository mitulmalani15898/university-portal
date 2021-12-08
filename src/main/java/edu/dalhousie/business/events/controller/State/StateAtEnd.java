/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.controller.State;

import edu.dalhousie.presentation.IStudentView;
import edu.dalhousie.presentation.StudentView;

public class StateAtEnd implements State{
    public IStudentView studentView;

    public StateAtEnd(){
        this.studentView = StudentView.getInstance();
    }

    @Override
    public void performStateTransition(StateContext stateContext) {
        if (stateContext == null) {
            stateContext = new StateContext();
        }
        this.studentView.showMessage("Event ends");
        stateContext.setState(this);
    }
}
