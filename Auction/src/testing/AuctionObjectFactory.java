package testing;

import java.time.LocalDate;

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
			.setName(new Name("Dieter","Abel"))
			.setUsername("abeldieter")
			.setPassword("abelpasswort")
			.setEmail("dieter.abel@gmx.de");
			
		return abel;
	}
	
	public IAuctionUser bebel(){
		return null;
	}
	
	public IAuctionItem car(){
		return null;
	}
	
	public IAuctionItem computer(){
		return null;
	}
	
	public IBid abelBid(){
		return null;
	}
	
	public IBid bebelBid(){
		return null;
	}
}
