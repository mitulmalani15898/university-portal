package edu.dalhousie.business.DalMembership.controller.subscription.handler;

import edu.dalhousie.business.DalMembership.controller.subscription.GoldSubscription;
import edu.dalhousie.business.DalMembership.controller.subscription.Subscription;

public class GoldHandler extends Handler{
    private Handler handler;
    @Override
    public Handler nextHandler() {
        this.handler = new SilverHandler();
        return handler;
    }

    @Override
    public Subscription processRequest(String choice) throws Exception {
        if ("gold".equalsIgnoreCase(choice)) {
            return new GoldSubscription();
        }
        return this.nextHandler().processRequest(choice);
    }
}
