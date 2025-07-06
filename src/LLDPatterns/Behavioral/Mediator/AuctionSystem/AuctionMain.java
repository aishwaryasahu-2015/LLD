package LLDPatterns.Behavioral.Mediator.AuctionSystem;

import LLDPatterns.Behavioral.Mediator.AuctionSystem.Implementations.Auctioneer;
import LLDPatterns.Behavioral.Mediator.AuctionSystem.Implementations.Bidder;

public class AuctionMain {

    public static void main(String[] args){
        AuctionMediator auctioneer1 = new Auctioneer();
        Bidder bidder1 = new Bidder("Aishwarya", auctioneer1);
        Bidder bidder2 = new Bidder("abc", auctioneer1);
        Bidder bidder3 = new Bidder("xyz", auctioneer1);

        bidder1.placeBid(100);
        bidder2.placeBid(200);
        bidder3.placeBid(300);
        bidder1.placeBid(500);
        bidder2.placeBid(1000);
    }
}
