package edu.dalhousie.business.DalMembership.controller.subscription.handler;

import edu.dalhousie.business.DalMembership.controller.subscription.Subscription;

public abstract class Handler {
    public abstract Handler nextHandler();
    public abstract Subscription processRequest(String choice) throws Exception;
}
