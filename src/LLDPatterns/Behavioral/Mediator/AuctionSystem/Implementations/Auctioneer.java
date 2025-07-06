package LLDPatterns.Behavioral.Mediator.AuctionSystem.Implementations;

import LLDPatterns.Behavioral.Mediator.AuctionSystem.AuctionMediator;
import LLDPatterns.Behavioral.Mediator.AuctionSystem.Colleague;

import java.util.ArrayList;
import java.util.List;

public class Auctioneer implements AuctionMediator {
    List<Colleague> biddersList;

    public Auctioneer(){
        this.biddersList = new ArrayList<>();
    }

    public void addBidder(Colleague bidder) {
        this.biddersList.add(bidder);
    }

    public void placeBid(Colleague bidder, int bidAmount) {
        for(Colleague bidder1: biddersList){
            if(!bidder1.getName().equals(bidder.getName())){
                bidder1.receiveBidNotification(bidAmount);
            }
        }
    }
}
