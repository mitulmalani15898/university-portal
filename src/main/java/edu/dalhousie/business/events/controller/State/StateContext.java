package edu.dalhousie.business.events.controller.State;

public class StateContext {
    private State state = null;

    public void setState(State state) {
        this.state = state;
    }
    public State getState(){
        return state;
    }
}