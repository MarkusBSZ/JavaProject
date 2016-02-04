package auction;

import java.util.List;

public interface IAuctionUser {

	boolean add(AuctionItem auctionItem);

	boolean add(Bid bid);

	boolean equals(Object obj);

	List<AuctionItem> getAuctions();

	int getAuctionUserId();

	List<Bid> getBids();

	String getEmail();

	IName getName();

	String getPassword();

	String getUsername();

	int hashCode();

	boolean remove(IAuctionItem auctionItem);

	boolean remove(IBid bid);

	void setAuctions(List<AuctionItem> auctions);

	void setAuctionUserId(int auctionUserId);

	void setBids(List<Bid> bids);

	void setEmail(String email);

	void setName(IName name);

	void setPassword(String password);

	void setUsername(String username);

}