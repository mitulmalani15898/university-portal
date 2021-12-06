package edu.dalhousie.business.events.controller.State;

import edu.dalhousie.presentation.StudentView;

public class StateInProgress implements State{
    public StudentView studentView;

    public StateInProgress(){
        this.studentView = new StudentView();
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
