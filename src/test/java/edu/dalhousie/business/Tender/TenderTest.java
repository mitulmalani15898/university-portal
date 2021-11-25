package edu.dalhousie.business.Tender;

import edu.dalhousie.business.Tender.controller.ITender;
import edu.dalhousie.business.Tender.controller.Tender;
import edu.dalhousie.business.Tender.model.Bidder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

public class TenderTest {
    static ITender tender = null;
    static Collection<Bidder> bidders = null;

    @BeforeAll
    public static void setUp() throws Exception {
        tender =new Tender();
        bidders = new ArrayList<Bidder>();
    }

    @Test
    public void auctionTest() throws Exception {
        tender.setTenderEvent("Dalhousie Meals");

        bidders.add(new Bidder("Tim Horton's", 50, 80, 3));
        bidders.add(new Bidder("Adda", 60, 82, 2));
        bidders.add(new Bidder("Passage to India", 55, 85, 5));

        tender.addNewBidders(bidders);

        Bidder winner = tender.startTender();

        Assertions.assertEquals(85, winner.getBid());
        Assertions.assertEquals("Passage to India", winner.getName());
    }
}
