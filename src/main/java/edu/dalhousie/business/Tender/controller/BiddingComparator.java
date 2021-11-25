package edu.dalhousie.business.Tender.controller;

import edu.dalhousie.business.Tender.model.Bidder;

import java.util.Comparator;

public class BiddingComparator implements Comparator<Bidder> {
    @Override
    public int compare(Bidder bidder1, Bidder bidder2) {
        int comparison = bidder1.getBid() - bidder2.getBid();

        // Use the date as the discriminator if the bids are equal
        if (comparison == 0) {
            comparison = (int) (bidder1.getBidTime().getTime() - bidder2.getBidTime().getTime());
        }

        return comparison;
    }
}
