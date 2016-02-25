package testing;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
	{
		
	}
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
		GenericDao<IAuctionItem> jpaAuctionItemDao = DaoFactory.getInstance().getAuctionItemDao();
		GenericDao<IAuctionUser> jpaAuctionUserDao = DaoFactory.getInstance().getAuctionUserDao();
		GenericDao<IAuctionInfo> jpaAuctionInfoDao = DaoFactory.getInstance().getAuctionInfoDao();
		
		EntityManager em = DaoFactory.getInstance().getEm();
		
     	EntityTransaction tx = em.getTransaction();
     	
     	tx.begin();
     	
     	//jpaAuctionUserDao.persist(AuctionObjectFactory.INSTANCE.abel(),em);
     	//jpaAuctionUserDao.persist(AuctionObjectFactory.INSTANCE.bebel(),em);
     	jpaAuctionItemDao.persist(AuctionObjectFactory.INSTANCE.computer(), em);
     	jpaAuctionItemDao.persist(AuctionObjectFactory.INSTANCE.car(), em);

     	
     	tx.commit();
		
		return;
	}
	

	 
	
}
