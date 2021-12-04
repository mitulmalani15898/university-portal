package edu.dalhousie.business.Tender.controller;

import edu.dalhousie.business.Tender.model.Auctioneer;

import java.util.Comparator;

public class BiddingComparator implements Comparator<Auctioneer> {
    @Override
    public int compare(Auctioneer bidder1, Auctioneer bidder2) {
        int comparison = bidder1.getBid() - bidder2.getBid();

        if (comparison == 0) {
            comparison = (int) (bidder1.getBidTime().getTime() - bidder2.getBidTime().getTime());
        }

        return comparison;
    }
}
