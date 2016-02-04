package auction;

import java.util.List;

public interface IAuctionUser {

	boolean add(AuctionItem auctionItem);

	boolean add(Bid bid);

	boolean equals(Object obj);

	List<AuctionItem> getAuctions();

	Long getAuctionUserId();

	List<Bid> getBids();

	String getEmail();

	IName getName();

	String getPassword();

	String getUsername();

	int hashCode();

	boolean remove(IAuctionItem auctionItem);

	boolean remove(IBid bid);

	IAuctionUser setAuctions(List<AuctionItem> auctions);

	IAuctionUser setAuctionUserId(Long auctionUserId);

	IAuctionUser setBids(List<Bid> bids);

	IAuctionUser setEmail(String email);

	IAuctionUser setName(IName name);

	IAuctionUser setPassword(String password);

	IAuctionUser setUsername(String username);

}