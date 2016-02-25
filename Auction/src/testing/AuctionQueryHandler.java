package testing;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import auction.AuctionInfo;
import auction.AuctionItem;
import auction.AuctionUser;
import auction.IAuctionInfo;
import auction.IAuctionItem;
import auction.IAuctionUser;
import auction.IBid;
import database.DaoFactory;
import database.GenericDao;


public enum AuctionQueryHandler {
	INSTANCE;
	
	public IAuctionItem addAuctionItem(IAuctionItem auctionItem, GenericDao<IAuctionItem> jpaAuctionItemDao, EntityManager em)
	{
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		jpaAuctionItemDao.persist(auctionItem, em);

		tx.commit();
		
		return auctionItem;
	}
	public IAuctionUser findAuctionUser(GenericDao<IAuctionUser> jpaAuctionUserDao, EntityManager em) 
	{
		IAuctionUser search = new AuctionUser().setUsername("abeldieter");
		return jpaAuctionUserDao.find(search, em);
	}
	public IAuctionInfo findAuctionInfoById(GenericDao<IAuctionInfo> jpaAuctionInfoDao, EntityManager em)
	{
		IAuctionInfo search = new AuctionInfo().setAuctioninfoid(Long.valueOf(1));
		return jpaAuctionInfoDao.findById(search, em);
	}
	
	public IAuctionItem removeAuctionItem(GenericDao<IAuctionItem> jpaAuctionItemDao, EntityManager em)
	{
		IAuctionItem search = new AuctionItem().setAuctionItemId(Long.valueOf(3));
		IAuctionItem found = jpaAuctionItemDao.findById(search, em);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//Hier weiter.
		jpaAuctionItemDao.remove(found, em);
		tx.commit();
		
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
		EntityManager em = DaoFactory.getInstance().getEm();
		GenericDao<IBid> jpaBidDao = DaoFactory.getInstance().getBidDao();
		GenericDao<IAuctionItem> jpaAuctionItemDao = DaoFactory.getInstance().getAuctionItemDao();
		GenericDao<IAuctionUser> jpaAuctionUserDao = DaoFactory.getInstance().getAuctionUserDao();
		GenericDao<IAuctionInfo> jpaAuctionInfoDao = DaoFactory.getInstance().getAuctionInfoDao();
		
		IAuctionItem auctionItem = new AuctionItem();

		auctionItem
			.setAuctionItemId(Long.valueOf(3))
			.setDescription("Wohnung")
			.setEnds(LocalDate.now().plusDays(3))
			.setSeller(AuctionQueryHandler.INSTANCE.findAuctionUser(jpaAuctionUserDao,em))
			.setAuctionInfo(AuctionQueryHandler.INSTANCE.findAuctionInfoById(jpaAuctionInfoDao,em));
		
		IAuctionItem wohnung = AuctionQueryHandler.INSTANCE.addAuctionItem(auctionItem,jpaAuctionItemDao, em);
		
//     	EntityTransaction tx = em.getTransaction();
//     	tx.begin();
//     	tx.commit();
		
		return;
	}
	

	 
	
}
