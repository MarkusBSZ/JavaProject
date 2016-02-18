package testing;

import java.time.LocalDate;
import java.time.LocalDateTime;

import auction.AuctionItem;
import auction.AuctionUser;
import auction.IAuctionItem;
import auction.IAuctionUser;
import auction.IBid;
import auction.IName;
import auction.Name;

public enum AuctionObjectFactory {
	INSTANCE;
	public IAuctionUser abel(){
		IAuctionUser abel = new AuctionUser();

		abel
			.setAuctionUserId(Long.valueOf(1))
			.setName(new Name(Long.valueOf(1),"Dieter","Abel"))
			.setUsername("abeldieter")
			.setPassword("abelpassword")
			.setEmail("dieter.abel@gmx.de");
			
		return abel;
	}
	
	public IAuctionUser bebel(){
		IAuctionUser bebel = new AuctionUser();

		bebel
			.setAuctionUserId(Long.valueOf(2))
			.setName(new Name(Long.valueOf(2),"Max","Bebel"))
			.setUsername("bebelmax")
			.setPassword("bebelpassword")
			.setEmail("max.bebel@gmx.de");
			
		return bebel;
	}
	
	public IAuctionItem car(){
		IAuctionItem car = new AuctionItem();
		IAuctionUser abel = AuctionObjectFactory.INSTANCE.abel();

		car
			.setAuctionItemId(Long.valueOf(1))
			.setDescription("Audi A5 mit 500 PS")
			.setEnds(LocalDate.now().plusDays(5))
			.setSeller(abel);
		return car;
	}
	
	public IAuctionItem computer(){
		IAuctionItem computer = new AuctionItem();
		IAuctionUser bebel = AuctionObjectFactory.INSTANCE.bebel();
		computer
			.setAuctionItemId(Long.valueOf(2))
			.setDescription("Alienware Aurora mit 32GB RAM")
			.setEnds(LocalDate.now().plusDays(9))
			.setSeller(bebel);
		return computer;
	}
	
	public IBid abelBid(){
		return null;
	}
	
	public IBid bebelBid(){
		return null;
	}
}
