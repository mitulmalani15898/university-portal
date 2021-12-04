package edu.dalhousie.business.DalMembership.controller.subscription.handler;

import edu.dalhousie.business.DalMembership.controller.subscription.BronzeSubscription;
import edu.dalhousie.business.DalMembership.controller.subscription.Subscription;

public class BronzeHandler extends Handler{
    private Handler handler;
    @Override
    public Handler nextHandler() {
         this.handler = new GoldHandler();
        return handler;
    }

    @Override
    public Subscription processRequest(String choice) throws Exception {
        if ("bronze".equalsIgnoreCase(choice)) {
            return new BronzeSubscription();
        }
        return this.nextHandler().processRequest(choice);
    }
}
