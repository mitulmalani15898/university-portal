package edu.dalhousie.business.Events.controller.State;

public class StateContext {
    private State state = null;

    public void setState(State state) {
        this.state = state;
    }
    public State getState(){
        return state;
    }
}