package edu.dalhousie.business.DalMembership.controller.subscription.handler;

import edu.dalhousie.business.DalMembership.controller.subscription.SilverSubscription;
import edu.dalhousie.business.DalMembership.controller.subscription.Subscription;

public class SilverHandler extends Handler{
    private Handler handler;
    @Override
    public Handler nextHandler() {
       return null;
    }

    @Override
    public Subscription processRequest(String choice) throws Exception {
        if ("silver".equalsIgnoreCase(choice)) {
            return new SilverSubscription();
        }
        return this.nextHandler().processRequest(choice);
    }
}
