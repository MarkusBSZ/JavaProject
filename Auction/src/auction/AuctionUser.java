package auction;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

public class AuctionUser implements IAuctionUser {
	
	private List<AuctionItem> auctions = new ArrayList<AuctionItem>();
	
	private List<Bid> bids = new ArrayList<Bid>();
	
	private int auctionUserId = 0;
	
	private String email;
	
	private IName name;
	
	private String password;
	
	private String username;

	public AuctionUser() {
		super();
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionUser#add(auction.AuctionItem)
	 */
	@Override
	public boolean add(AuctionItem auctionItem) {
		return this.getAuctions().add(auctionItem);
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionUser#add(auction.Bid)
	 */
	@Override
	public boolean add(Bid bid) {
		return this.getBids().add(bid);
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionUser#equals(java.lang.Object)
	 */
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

	/* (non-Javadoc)
	 * @see auction.IAuctionUser#getAuctions()
	 */
	@Override
	public List<AuctionItem> getAuctions() {
		return auctions;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionUser#getAuctionUserId()
	 */
	@Override
	public int getAuctionUserId() {
		return auctionUserId;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionUser#getBids()
	 */
	@Override
	public List<Bid> getBids() {
		return bids;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionUser#getEmail()
	 */
	@Override
	public String getEmail() {
		return email;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionUser#getName()
	 */
	@Override
	public IName getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionUser#getPassword()
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionUser#getUsername()
	 */
	@Override
	public String getUsername() {
		return username;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionUser#hashCode()
	 */
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

	/* (non-Javadoc)
	 * @see auction.IAuctionUser#remove(auction.IAuctionItem)
	 */
	@Override
	public boolean remove(IAuctionItem auctionItem) {
		return this.getBids().remove(auctionItem);
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionUser#remove(auction.Bid)
	 */
	@Override
	public boolean remove(Bid bid) {
		return this.getBids().remove(bid);
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionUser#setAuctions(java.util.List)
	 */
	@Override
	public void setAuctions(List<AuctionItem> auctions) {
		this.auctions = auctions;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionUser#setAuctionUserId(int)
	 */
	@Override
	public void setAuctionUserId(int auctionUserId) {
		this.auctionUserId = auctionUserId;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionUser#setBids(java.util.List)
	 */
	@Override
	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionUser#setEmail(java.lang.String)
	 */
	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionUser#setName(auction.Name)
	 */
	@Override
	public void setName(IName name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionUser#setPassword(java.lang.String)
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionUser#setUsername(java.lang.String)
	 */
	@Override
	public void setUsername(String username) {
		this.username = username;
	}

}
