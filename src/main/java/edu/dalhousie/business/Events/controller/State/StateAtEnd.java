package edu.dalhousie.business.Events.controller.State;

import edu.dalhousie.presentation.StudentView;

public class StateAtEnd implements State{
    public StudentView studentView;

    public StateAtEnd(){
        this.studentView = new StudentView();
    }

    @Override
    public void performAction(StateContext stateContext) {
        if (stateContext == null) {
            stateContext = new StateContext();
        }
        this.studentView.showMessage("Event ends");
        stateContext.setState(this);
    }
}
