/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.controller.Cost;

import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;

public class EventCost {
    public ICommonPrinting studentView;

    public EventCost() {
        this.studentView = CommonPrinting.getInstance();
    }

    public void studentPayment(int num) {
        this.studentView.showMessage("The overall cost for " +
                "the event is estimated to be : $" + (num) * 10);
    }
}
