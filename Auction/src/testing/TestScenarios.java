package testing;

import static org.junit.Assert.*;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

import auction.AuctionItem;
import auction.IAuctionItem;
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
		this.wait(1000);
		Query queryItem = em.createQuery("SELECT * FROM AuctionItem WHERE auctionitem_id = 5");
		
		
	}

}
