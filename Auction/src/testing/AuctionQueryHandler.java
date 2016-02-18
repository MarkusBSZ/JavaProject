package testing;

import javax.persistence.EntityManager;

import auction.AuctionUser;
import auction.IAuctionItem;
import auction.IAuctionUser;
import auction.IBid;
import database.DaoFactory;
import database.GenericDao;


public enum AuctionQueryHandler {
	INSTANCE;
	
	public void populateAuctions()
	{}
	
	public IAuctionItem addAuctionItem()
	{
		return null;
	}
	public IAuctionItem removeAuctionItem()
	{
		return null;
	}
	public IAuctionUser registerUser()
	{
		return null;
	}
	public IAuctionUser unregisterUser()
	{
		return null;
	}
	
	public void auctionItems()
	{}
	public void auctionItemsFor(IAuctionUser bidder)
	{}
	public void bidsByUser()
	{}
	public void bidsForAuctionItem()
	{}
	public void successfulBids(IAuctionItem item)
	{}
	
	public IBid bidForAuctionItem(IAuctionUser bidder, IAuctionItem item, float amount)
	{
		return null;
	}
	public IBid cancelBidForAuctionItem(IAuctionUser bidder, IAuctionItem item)
	{
		return null;
	}
	
	public IAuctionUser changeUserDetails(AuctionUser user)
	{
		return null;
	}
	public IAuctionUser changeItemDescription(Long ItemId, String description)
	{
		return null;
	}
	
	public static void main(String[] args)
	{	
		GenericDao<IBid> jpaBidDao = DaoFactory.getInstance().getBidDao();
		GenericDao<IBid> jpaAuctionItemDao = DaoFactory.getInstance().getAuctionItemDao();
		GenericDao<IBid> jpaAuctionUserDao = DaoFactory.getInstance().getAuctionUserDao();
		
		EntityManager em = DaoFactory.getInstance().getEm();
		return;
	}
}
