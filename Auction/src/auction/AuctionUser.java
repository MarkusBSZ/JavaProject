package auction;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

public class AuctionUser {
	
	private List<AuctionItem> auctions = new ArrayList<AuctionItem>();
	
	private List<Bid> bids = new ArrayList<Bid>();
	
	private int auctionUserId = 0;
	
	private String email;
	
	private Name name;
	
	private String password;
	
	private String username;

	public AuctionUser() {
		super();
	}

	public boolean add(AuctionItem auctionItem) {
		return this.getAuctions().add(auctionItem);
	}

	public boolean add(Bid bid) {
		return this.getBids().add(bid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuctionUser other = (AuctionUser) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public List<AuctionItem> getAuctions() {
		return auctions;
	}

	public int getAuctionUserId() {
		return auctionUserId;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public String getEmail() {
		return email;
	}

	public Name getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	public boolean remove(AuctionItem auctionItem) {
		return this.getBids().remove(auctionItem);
	}

	public boolean remove(Bid bid) {
		return this.getBids().remove(bid);
	}

	public void setAuctions(List<AuctionItem> auctions) {
		this.auctions = auctions;
	}

	public void setAuctionUserId(int auctionUserId) {
		this.auctionUserId = auctionUserId;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
