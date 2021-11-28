package edu.dalhousie.business.Events.controller.Event;

import edu.dalhousie.business.Events.controller.Judge.EventJudge;
import edu.dalhousie.business.Events.controller.State.StateAtEnd;
import edu.dalhousie.business.Events.controller.State.StateAtStart;
import edu.dalhousie.business.Events.controller.State.StateContext;
import edu.dalhousie.business.Events.controller.State.StateInProgress;
import edu.dalhousie.business.Events.controller.Winner.EventWinner;
import edu.dalhousie.presentation.StudentView;

public class Event {
    public String eventName;
    public String eventLocation;
    public String eventDate;
    public String eventTime;
    public String eventDescription;
    protected StateContext stateContext;
    protected StateAtStart stateAtStart;
    protected StateAtEnd stateAtEnd;
    protected StateInProgress stateInProgress;
    public StudentView studentView;
    public EventWinner eventWinner;
    public EventJudge eventJudge;

    public Event(String eventName,
                 String eventLocation,
                 String eventDate,
                 String eventTime,
                 String eventDescription){
        this.stateContext = new StateContext();
        this.stateAtStart = new StateAtStart();
        this.stateAtEnd = new StateAtEnd();
        this.stateInProgress = new StateInProgress();
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventDescription = eventDescription;
        this.studentView = new StudentView();
        this.stateAtStart.performAction(stateContext);
        this.eventJudge = new EventJudge();
        this.eventWinner = new EventWinner();
    }
    public void EventProgress(){
        this.stateInProgress.performAction(stateContext);
        this.eventJudge.setJudgeName();
        this.eventWinner.setWinnerName();
        this.studentView.showMessage("The winner is:");
        this.eventWinner.getWinnerName();
        this.stateAtEnd.performAction(stateContext);
    }

    public void getEventInfo(){
        this.studentView.showMessage("Event Name : "+ eventName);
        this.studentView.showMessage("Event Location : "+ eventLocation);
        this.studentView.showMessage("Event Date : "+ eventDate);
        this.studentView.showMessage("Event Time : "+ eventTime);
        this.studentView.showMessage("Event Description : "+ eventDescription);
    }
}
