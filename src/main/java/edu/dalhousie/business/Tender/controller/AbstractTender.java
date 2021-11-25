package edu.dalhousie.business.Tender.controller;

import edu.dalhousie.business.Tender.model.Bidder;

import java.util.Collection;
import java.util.HashSet;

public abstract class AbstractTender implements ITender{
    protected String tenderEvent = null;
    protected Collection<Bidder> bidders = new HashSet<Bidder>();


    @Override
    public void setTenderEvent(String tenderEvent) {
        this.tenderEvent = tenderEvent;
    }

    @Override
    public void addNewBidders(Collection<Bidder> bidders) {
        this.bidders.addAll(bidders);
    }

    @Override
    public Bidder startTender() throws Exception {
        if (tenderEvent == null) {
            throw new Exception("No item submitted for auction.  Auction canceled.");
        }

        if (bidders.size() == 0) {
            throw new Exception("No bids were submitted.  Auction canceled.");
        }
        if (bidders.size() == 1) {
            Bidder winner = bidders.iterator().next();
            String message = String.format("%s won auction for '%s' by default.",
                    winner.getName(),
                    this.tenderEvent);
            System.out.println(message);
            return winner;
        }

        Bidder winner = findWinner();

        String message = String.format("%s wins the auction for '%s' with a bid of %d",
                winner.getName(),
                this.tenderEvent,
                winner.getBid());
        System.out.println(message);
        System.out.println();

        return winner;
    }
    public abstract Bidder findWinner() throws Exception;
}
