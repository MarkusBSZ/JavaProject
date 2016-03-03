package testing;

import static org.junit.Assert.*;

import java.time.LocalDate;

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
		GenericDao<IAuctionUser> auctionUserDao = DaoFactory.getInstance().getAuctionUserDao();
		GenericDao<IAuctionInfo> auctionInfoDao = DaoFactory.getInstance().getAuctionInfoDao();
		IAuctionUser seller = new AuctionUser();
		IAuctionInfo findAuctionInfo = new AuctionInfo().setAuctioninfoid(Long.valueOf(1));
		IAuctionItem item = new AuctionItem()
							 .setAuctionItemId(Long.valueOf(5))
							 .setAuctionInfo(auctionInfoDao.findById(findAuctionInfo, em))
							 .setDescription("Dreirad rot")
							 .setEnds(LocalDate.of(2016, 3, 10))
							 .setSeller(auctionUserDao.
									 	findById(
									 		new AuctionUser()
									 		.setAuctionUserId(Long.valueOf(1)), 
									 		em));
		
		AuctionQueryHandler.INSTANCE.addAuctionItem(item, auctionItemDao, em);

		Query queryItem = em.createQuery("SELECT * FROM AuctionItem WHERE auctionitem_id = 5");
		IAuctionItem finalItem = (IAuctionItem)queryItem.getSingleResult();
		assertTrue(finalItem.getAuctionItemId() == 5 &&
				   finalItem.getDescription().equals("Dreirad rot") &&
				   finalItem.getEnds().equals(LocalDate.of(2016, 3, 10)) &&
				   finalItem.getSeller().equals(auctionUserDao.
									 	findById(
									 		new AuctionUser()
									 		.setAuctionUserId(Long.valueOf(1)), 
									 		em)));
		
	}

}
