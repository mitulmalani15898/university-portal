package edu.dalhousie.business.Tender.controller;

import edu.dalhousie.business.Tender.model.Bidder;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Tender extends AbstractTender{
    @Override
    public Bidder findWinner() throws Exception {
        Set<Bidder> activeBidders = new HashSet<Bidder>(bidders);
        System.out.println(String.format("Starting auction for '%s'", this.tenderEvent));
        while (activeBidders.size() > 1) {
            Bidder lowestBidder = null;

            for (Bidder bidder : bidders) {
                // Skip the bidder if he is no longer active
                if (!activeBidders.contains(bidder)) {
                    continue;
                }

                // Get this bidders next bid amount
                int nextBid = bidder.getBid() + bidder.getIncrement();

                // De-activate the bidder if this takes them over the max bid
                if (bidder.getMaxBid() < nextBid) {
                    activeBidders.remove(bidder);
                    continue;
                }

                // Check if this bidder has the next lowest bid out of all bidders (cumulative)
                if (lowestBidder == null ||
                        (nextBid < lowestBidder.getBid() + lowestBidder.getIncrement())) {
                    lowestBidder = bidder;
                }
            }

            if (lowestBidder != null) {
                lowestBidder.bid();
            }
        }
        return Collections.max(bidders, new BiddingComparator());
    }
}
