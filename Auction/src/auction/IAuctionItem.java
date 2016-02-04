package auction;

import java.util.Date;
import java.util.List;

public interface IAuctionItem {

	boolean add(Bid bid);

	boolean equals(Object obj);

	Bid findBid(AuctionUser auctionUser);

	int getAuctionItemId();

	List<Bid> getBids();

	String getDescription();

	AuctionUser getSeller();

	Bid getSuccessfulBid();

	int hashCode();

	boolean remove(Bid bid);

	void setAuctionItemId(int auctionItemId);

	void setBids(List<Bid> bids);

	void setDescription(String description);

	void setEnds(Date ends);

	void setSeller(AuctionUser seller);

	void setSuccessfulBid(Bid successfulBid);

	String toString();

}