/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 */
package edu.dalhousie.business.tender.controller.Tender;

import edu.dalhousie.business.tender.controller.TenderComparator;
import edu.dalhousie.business.tender.database.ITenderWinnerDAOQueryBuilder;
import edu.dalhousie.business.tender.database.TenderWinnerQueryBuilder;
import edu.dalhousie.business.tender.model.Auctioneer;
import edu.dalhousie.database.DatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;

import java.sql.Connection;
import java.sql.Statement;
import java.util.*;

public class Tender extends AbstractTender {

    private static ITenderWinnerDAOQueryBuilder iTenderWinnerDAOQueryBuilder;
    private static DatabaseConnection databaseConnection;

    @Override
    public Auctioneer findBestAuctioneer() {
        Set<Auctioneer> activeAuctioneers = new HashSet<>(bidders);
        System.out.println("Starting auction for : " + this.tenderEvent);
        while (activeAuctioneers.size() > 1) {
            Auctioneer lowestAuctioneer = null;

            for (Auctioneer bidder : bidders) {

                if (!activeAuctioneers.contains(bidder)) {
                    continue;
                }

                int nextBid = bidder.getBidAmount() + bidder.getIncrement();

                if (bidder.getMaximumAmount() < nextBid) {
                    activeAuctioneers.remove(bidder);
                    continue;
                }

                if (lowestAuctioneer == null ||
                        (nextBid < lowestAuctioneer.getBidAmount() + lowestAuctioneer.getIncrement())) {
                    lowestAuctioneer = bidder;
                }
            }

            if (lowestAuctioneer != null) {
                lowestAuctioneer.bid();
            }
        }
        return Collections.max(bidders, new TenderComparator());
    }

    public void getTenderData() throws Exception {
        iTenderWinnerDAOQueryBuilder = new TenderWinnerQueryBuilder();
        databaseConnection = DatabaseConnectivity.getInstance();
        System.out.println("Enter the event name:");
        String eventName = sc.nextLine();
        setTenderEvent(eventName);
        List Auctioneers = new ArrayList<>();
        System.out.println("Enter the number of bidders:");
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.println("Enter Auctioneer name:");
            String auctioneerName = sc.next();
            System.out.println("Enter base amount:");
            int biddingAmount = sc.nextInt();
            System.out.println("Enter maximum amount:");
            int maximumBiddingAmount = sc.nextInt();
            System.out.println("Enter incremental amount:");
            int incrementalValueForEachRound = sc.nextInt();
            Auctioneers.add(new Auctioneer(auctioneerName,
                    biddingAmount, maximumBiddingAmount, incrementalValueForEachRound));
        }
        addNewAuctioneers(Auctioneers);
        Auctioneer winner = startTender();
        String winnerName = winner.getName();
        final Connection connection =
                databaseConnection.getDatabaseConnection();
        final Statement statement =
                connection.createStatement();
        statement.executeUpdate(
                iTenderWinnerDAOQueryBuilder
                        .updateWinner(winnerName));
    }
}
