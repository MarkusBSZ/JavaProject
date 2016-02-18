package auction;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IAuctionItem {

	boolean add(Bid bid);

	boolean equals(Object obj);

	IBid findBid(IAuctionUser auctionUser);

	Long getAuctionItemId();

	List<Bid> getBids();

	String getDescription();

	IAuctionUser getSeller();

	IBid getSuccessfulBid();

	int hashCode();

	boolean remove(IBid bid);

	IAuctionItem setAuctionItemId(Long auctionItemId);

	IAuctionItem setBids(List<Bid> bids);

	IAuctionItem setDescription(String description);

	IAuctionItem setEnds(LocalDate ends);

	IAuctionItem setSeller(IAuctionUser seller);

	IAuctionItem setSuccessfulBid(IBid successfulBid);

	String toString();

}