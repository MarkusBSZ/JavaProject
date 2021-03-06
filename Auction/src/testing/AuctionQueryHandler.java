package testing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import auction.AuctionInfo;
import auction.AuctionItem;
import auction.AuctionUser;
import auction.Bid;
import auction.IAuctionInfo;
import auction.IAuctionItem;
import auction.IAuctionUser;
import auction.IBid;
import auction.Name;
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
		
		if(found != null)
		{
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			jpaAuctionItemDao.remove(found, em);
			tx.commit();
		}
		return found;
	}
	
	public IAuctionUser registerUser(GenericDao<IAuctionUser> jpaAuctionUserDao, EntityManager em)
	{
		IAuctionUser auctionUser = new AuctionUser()
				.setAuctionUserId(Long.valueOf(3))
				.setName(new Name(Long.valueOf(3),"Marius","Haupt"))
				.setUsername("hauptmarius")
				.setPassword("mariuspassword")
				.setEmail("marius.haupt@gmx.de");
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		jpaAuctionUserDao.persist(auctionUser, em);
		tx.commit();
		
		return auctionUser;
	}
	
	public IAuctionUser unregisterUser(GenericDao<IAuctionUser> jpaAuctionUserDao, EntityManager em)
	{
		IAuctionUser search = new AuctionUser().setAuctionUserId(Long.valueOf(3));
		IAuctionUser found = jpaAuctionUserDao.findById(search, em);
		
		if(found != null)
		{
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			jpaAuctionUserDao.remove(found, em);
			tx.commit();
		}
		return found;
	}
	
	public List<IAuctionItem> auctionItems(GenericDao<IAuctionItem> jpaAuctionItemDao, EntityManager em)
	{
		return jpaAuctionItemDao.findAll(em);
	}
	
	public List<IAuctionItem> auctionItemsFor(IAuctionUser bidder, GenericDao<IBid> jpaBidDao, EntityManager em)
	{
		List<IBid> allBids = jpaBidDao.findAll(em);
		List<IAuctionItem> auctionItems = null;
		
		if(!allBids.isEmpty())
		{
			auctionItems =
			allBids
				.stream()
				.filter(bid -> bid.getBidder().equals(bidder))
				.map(bid -> bid.getItem())
				.distinct()
				.collect(Collectors.toList());
		}
		return auctionItems;
	}
	public List<IBid> bidsByUser(IAuctionUser bidder, GenericDao<IBid> jpaBidDao, EntityManager em)
	{
		List<IBid> allBids = jpaBidDao.findAll(em);

		if(!allBids.isEmpty())
		{
			allBids
				.stream()
				.filter(bid -> bid.getBidder().equals(bidder))
				.collect(Collectors.toList());
		}
		return allBids;
	}
	public List<IBid> bidsForAuctionItem(IAuctionItem item, GenericDao<IAuctionItem> jpaAuctionItemDao, EntityManager em)
	{
		IAuctionItem found = jpaAuctionItemDao.find(item, em);
		List<IBid> allBids = null;
		
		if(found != null)
		{
			allBids = found.getBids();
		}
		return allBids;
	}
	public IBid successfulBid(IAuctionItem item, GenericDao<IAuctionItem> jpaAuctionItemDao, EntityManager em)
	{
		IAuctionItem found = jpaAuctionItemDao.find(item, em);
		IBid sucsessfulBid = null;
		
		if(found != null)
		{
			sucsessfulBid = found.getSuccessfulBid();
		}
		return sucsessfulBid;
	}
	
	public IBid bidForAuctionItem(
			EntityManager em, 
			GenericDao<IAuctionItem> jpaAuctionItemDao,
			GenericDao<IBid> jpaBidDao,
			GenericDao<IAuctionUser> jpaUserDao,
			IAuctionUser bidder, 
			IAuctionItem item, 
			float amount)
	{
		IBid bid = new Bid()
			.setAmount(amount)
			.setBidder(jpaUserDao.findById(bidder, em))
			.setItem(jpaAuctionItemDao.findById(item, em));

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		jpaBidDao.persist(bid, em);
		tx.commit();
	
		return bid;
	}
	public IBid cancelBidForAuctionItem(
			EntityManager em, 
			GenericDao<IAuctionItem> jpaAuctionItemDao,
			GenericDao<IBid> jpaBidDao,
			GenericDao<IAuctionUser> jpaUserDao,
			IAuctionUser bidder, 
			IAuctionItem item)
	{
		IBid bid = new Bid()
				.setBidder(jpaUserDao.findById(bidder, em))
				.setItem(jpaAuctionItemDao.findById(item, em));

		IBid found = jpaBidDao.find(bid, em);
		
		if(found != null)
		{
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			jpaBidDao.remove(bid, em);
			tx.commit();
		}
		return bid;
	}
	
	public IAuctionUser changeUserDetails(GenericDao<IAuctionUser> jpaUserDao,EntityManager em,Long userId)
	{
		IAuctionUser auctionUser = new AuctionUser()
									.setAuctionUserId(Long.valueOf(1));
		IAuctionUser resultUser = jpaUserDao.findById(auctionUser, em);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		resultUser.setEmail("newEmail@gmx.de");
		tx.commit();
		
		return resultUser;
	}
	public IAuctionItem changeItemDescription(
				GenericDao<IAuctionItem> jpaAuctionItemDao, 
				EntityManager em,
				Long itemId, 
				String newDescription)
	{
		
		IAuctionItem auctionItem = new AuctionItem()
							.setAuctionItemId(itemId);
		
		IAuctionItem resultItem = jpaAuctionItemDao.findById(auctionItem, em);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		auctionItem.setDescription(newDescription);
		tx.commit();
		return resultItem;
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
