package testing;

import java.time.LocalDate;
import java.time.LocalDateTime;

import auction.AuctionInfo;
import auction.AuctionItem;
import auction.AuctionUser;
import auction.IAuctionInfo;
import auction.IAuctionItem;
import auction.IAuctionUser;
import auction.IBid;
import auction.IName;
import auction.Name;

public enum AuctionObjectFactory {
	INSTANCE;
	IAuctionInfo auctionInfo;
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
		IAuctionInfo auctionInfo = AuctionObjectFactory.INSTANCE.auctionComputers();

		car
			.setAuctionItemId(Long.valueOf(1))
			.setDescription("Audi A5 mit 500 PS")
			.setEnds(LocalDate.now().plusDays(5))
			.setSeller(abel)
			.setAuctionInfo(auctionInfo);
		return car;
	}
	
	public IAuctionItem computer(){
		IAuctionItem computer = new AuctionItem();
		IAuctionUser bebel = AuctionObjectFactory.INSTANCE.bebel();
		IAuctionInfo auctionInfo = AuctionObjectFactory.INSTANCE.auctionComputers();

		computer
			.setAuctionItemId(Long.valueOf(2))
			.setDescription("Alienware Aurora mit 32GB RAM")
			.setEnds(LocalDate.now().plusDays(9))
			.setSeller(bebel)
			.setAuctionInfo(auctionInfo);
		return computer;
	}
	
	public IAuctionInfo auctionComputers(){
		if(auctionInfo == null)
			{
			auctionInfo = 
				new AuctionInfo()
				.setAuctioninfoid(Long.valueOf(1))
				.setDescription("Auction for Computers")
				.setEnd(LocalDate.now().plusDays(Long.valueOf(10)))
				.setAmount(Long.valueOf(10));
			}
		return auctionInfo;
	}
	
	public IBid abelBid(){
		return null;
	}
	
	public IBid bebelBid(){
		return null;
	}
}
