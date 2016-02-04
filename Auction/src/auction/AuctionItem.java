package auction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

public class AuctionItem {
	private int auctionItemId = 0;
	private List<Bid> bids = new ArrayList<Bid>();
	
	private String description;
	
	private Date ends;

	private AuctionUser seller;
	
	private Bid successfulBid;

	public AuctionItem() {
		super();
	}

	public boolean add(Bid bid) {
		boolean answer;
		answer = this.getBids().add(bid);
		answer = bid.getBidder().add(this);

		return answer;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuctionItem other = (AuctionItem) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (ends == null) {
			if (other.ends != null)
				return false;
		} else if (!ends.equals(other.ends))
			return false;
		if (seller == null) {
			if (other.seller != null)
				return false;
		} else if (!seller.equals(other.seller))
			return false;
		return true;
	}

	public Bid findBid(AuctionUser auctionUser) {
		for (Bid bid : this.getBids()) {
			if (bid.getBidder().equals(auctionUser))
				return bid;
		}
		return null;
	}

	public int getAuctionItemId() {
		return auctionItemId;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public String getDescription() {
		return description;
	}

	public AuctionUser getSeller() {
		return seller;
	}

	public Bid getSuccessfulBid() {
		return successfulBid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((ends == null) ? 0 : ends.hashCode());
		result = prime * result + ((seller == null) ? 0 : seller.hashCode());
		return result;
	}

	public boolean remove(Bid bid) {
		boolean answer = false;
		if (this.getBids().contains(bid)) {
			answer = bid.getBidder().remove(this);
		}
		return answer;
	}

	public void setAuctionItemId(int auctionItemId) {
		this.auctionItemId = auctionItemId;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEnds(Date ends) {
		this.ends = ends;
	}

	public void setSeller(AuctionUser seller) {
		this.seller = seller;
	}

	public void setSuccessfulBid(Bid successfulBid) {
		this.successfulBid = successfulBid;
	}

	@Override
	public String toString() {
		return "AuctionItem [description=" + description + ", ends=" + ends
				+ ", seller=" + seller + "]";
	}

}
