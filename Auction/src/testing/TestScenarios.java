package testing;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

import auction.AuctionInfo;
import auction.AuctionItem;
import auction.AuctionUser;
import auction.IAuctionInfo;
import auction.IAuctionItem;
import auction.IAuctionUser;
import auction.IBid;
import database.DaoFactory;
import database.GenericDao;

public class TestScenarios {
	EntityManager em;

	@Before
	public void setUp()
	{
		em = DaoFactory.getInstance().getEm();
	}
	
	
	@Test
	public void test_additem() {
		GenericDao<IAuctionItem> auctionItemDao = DaoFactory.getInstance().getAuctionItemDao();
		IAuctionItem item = new AuctionItem()
							 .setAuctionItemId(Long.valueOf(5))
							 .setAuctionInfo(AuctionObjectFactory.INSTANCE.auctionInfo)
							 .setDescription("Dreirad rot")
							 .setEnds(LocalDate.of(2016, 3, 10))
							 .setSeller(AuctionObjectFactory.INSTANCE.abel());
		
		AuctionQueryHandler.INSTANCE.addAuctionItem(item, auctionItemDao, em);
		Query queryItem = em.createQuery("SELECT * FROM AuctionItem WHERE auctionitem_id = 5");
		
		IAuctionItem resultItem = (IAuctionItem)queryItem.getSingleResult();
		
		assertEquals(resultItem.getDescription(),"Dreirad rot");
		assertEquals(resultItem.getEnds(),LocalDate.of(2016, 3, 10));
		assertEquals(resultItem.getSeller().getUsername(),"abeldieter");

	}
	
	@Test
	public void test_removeitem() 
	{
		
	}
	
	@Test
	public void test_findAucitonInfoById()
	{
		GenericDao<IAuctionInfo> auctionInfoDao = DaoFactory.getInstance().getAuctionInfoDao();
		IAuctionInfo auctionInfo = new AuctionInfo()
							.setAuctioninfoid(Long.valueOf(1));
		
		IAuctionInfo resultAuction = AuctionQueryHandler.INSTANCE.findAuctionInfoById(auctionInfoDao, em);
		
		assertEquals(resultAuction.getDescription(),"Auction from Haupt");
		assertEquals(resultAuction.getEnd(),LocalDate.of(2016, 3, 5));
	}
	
	@Test
	public void test_changeItemDescription()
	{
		IAuctionItem auctionItem = AuctionQueryHandler.INSTANCE.changeItemDescription(Long.valueOf(1), "Audi A6 mit 500 PS");
		
		Query queryItem = em.createQuery("SELECT * FROM AuctionItem WHERE auctionitem_id = 1");
		IAuctionItem resultItem = (IAuctionItem)queryItem.getSingleResult();
		
		assertEquals(resultItem.getDescription(),"Audi A6 mit 500 PS");
		
	}
	
	@Test
	public void test_bidForAuctionItem()
	{
		IAuctionUser bidder = new AuctionUser()
						.setAuctionUserId(Long.valueOf(1));
		IAuctionItem auctionItem = new AuctionItem()
							.setAuctionItemId(Long.valueOf(1));
		
		float amount = 150;
		
		AuctionQueryHandler.INSTANCE.bidForAuctionItem(bidder, auctionItem, amount);
		
		Query queryItem = em.createQuery("SELECT * "
				+ "						  FROM Bid b "
				+ "						  WHERE b.bidder = 1"
				+ "						  AND amount = 150");
		IBid bid = (IBid)queryItem.getSingleResult();
		
		assertEquals(bid.getBidder(), Long.valueOf(1));
		assertEquals(bid.getAmount(),150, 0.0);
		
	}
	
	@Test
	public void test_changeUserDetails()
	{
		IAuctionUser user = new AuctionUser()
							.setAuctionUserId(Long.valueOf(1));
		
		AuctionQueryHandler.INSTANCE.changeUserDetails(user);
		
		Query queryItem = em.createQuery("SELECT * FROM AuctionUser WHERE auctionuser_id = 1");
		IAuctionUser resultUser = (IAuctionUser)queryItem.getSingleResult();
		
		assertEquals(resultUser.getEmail(),"newEmail@gmx.de");
	}
	
	@Test
	public void test_bidsForAuctionItem()
	{
		
		AuctionQueryHandler.INSTANCE.bidsForAuctionItem();
	}
	

}