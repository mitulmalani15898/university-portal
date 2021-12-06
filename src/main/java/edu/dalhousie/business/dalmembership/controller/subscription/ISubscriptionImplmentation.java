package edu.dalhousie.business.dalmembership.controller.subscription;

import edu.dalhousie.controllers.User;
import edu.dalhousie.database.DatabaseConnection;

public interface ISubscriptionImplmentation {
    Subscription subscribe(String choice,
                           Double duration,
                           User user,
                           DatabaseConnection databaseConnection) throws Exception;
}
