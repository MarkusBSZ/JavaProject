package auction;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IAuctionItem {

	boolean add(Bid bid);

	boolean equals(Object obj);

	IBid findBid(IAuctionUser auctionUser);

	int getAuctionItemId();

	List<Bid> getBids();

	String getDescription();

	IAuctionUser getSeller();

	IBid getSuccessfulBid();

	int hashCode();

	boolean remove(IBid bid);

	void setAuctionItemId(int auctionItemId);

	void setBids(List<Bid> bids);

	void setDescription(String description);

	void setEnds(LocalDate ends);

	void setSeller(IAuctionUser seller);

	void setSuccessfulBid(IBid successfulBid);

	String toString();

}