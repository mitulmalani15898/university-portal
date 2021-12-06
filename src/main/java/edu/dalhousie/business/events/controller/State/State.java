package edu.dalhousie.business.events.controller.State;

public interface State {
    public void performStateTransition(StateContext stateContext);
}
