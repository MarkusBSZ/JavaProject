package testing;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

import auction.IAuctionInfo;
import auction.IAuctionItem;
import auction.IAuctionUser;
import database.DaoFactory;

public class TestPopulatedData {
	EntityManager em;
	ArrayList<IAuctionUser> users;
	ArrayList<IAuctionItem> items;
	ArrayList<IAuctionInfo> auctionInfos;

	@Before
	public void setUp() throws Exception {	
		em = DaoFactory.getInstance().getEm();
		
		Query queryUsers = em.createQuery("SELECT u FROM AuctionUser u");
		users = new ArrayList<IAuctionUser>(queryUsers.getResultList());
		
		Query queryItems = em.createQuery("SELECT i FROM AuctionItem i");
		items = new ArrayList<IAuctionItem>(queryItems.getResultList());
		
		Query queryAuctionInfos = em.createQuery("SELECT i FROM AuctionInfo i");
		auctionInfos = new ArrayList<IAuctionInfo>(queryAuctionInfos.getResultList());

	}
	
	@Test
	public void test_bebel() {
		IAuctionUser bebel = users.get(0);	
		assertTrue(bebel.getAuctionUserId()== 2 &&
				   bebel.getUsername().equals("bebelmax") &&
				   bebel.getEmail().equals("max.bebel@gmx.de") &&
				   bebel.getPassword().equals("bebelpassword") &&
				   bebel.getName().getFirstName().equals("Max")&&
				   bebel.getName().getLastName().equals("Bebel"));
		
	}
	@Test
	public void test_abel() {
		IAuctionUser abel = users.get(1);
		assertTrue(abel.getAuctionUserId()== 1 && 
				   abel.getUsername().equals("abeldieter") &&
				   abel.getEmail().equals("dieter.abel@gmx.de") &&
				   abel.getPassword().equals("abelpassword") &&
				   abel.getName().getFirstName().equals("Dieter")&&
				   abel.getName().getLastName().equals("Abel"));
	}
	


	@Test
	public void test_car() {
		IAuctionItem car = items.get(0);
		assertTrue(car.getAuctionItemId() == 1 &&
				   car.getDescription().equals("Audi A5 mit 500 PS") &&
				   car.getEnds().equals(LocalDate.of(2016, 3, 1)) &&
				   car.getSeller().getUsername().equals("abeldieter"));
	}
	
	@Test
	public void test_computer() {
		IAuctionItem computer = items.get(1);
		assertTrue(computer.getAuctionItemId() == 2 &&
				   computer.getDescription().equals("Alienware Aurora mit 32GB RAM") &&
				   computer.getEnds().equals(LocalDate.of(2016, 3, 5)) &&
				   computer.getSeller().getUsername().equals("bebelmax"));
	}
	
	@Test
	public void test_auctioninfo(){
		IAuctionInfo auctionInfo = auctionInfos.get(0);
		
		assertTrue(auctionInfo.getAuctioninfoid() == 1 &&
			       auctionInfo.getAmount() == 10 &&
				   auctionInfo.getDescription().equals("Auction from Haupt") &&
				   auctionInfo.getEnd().equals(LocalDate.of(2016, 3, 6)));
	}

}
