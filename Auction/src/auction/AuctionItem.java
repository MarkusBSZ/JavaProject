package auction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "AuctionItem")
public class AuctionItem extends Persistence implements IAuctionItem{
	public AuctionItem() {
		super();
	}
	/* (non-Javadoc)
	 * @see auction.IAuctionItem#add(auction.Bid)
	 */
	public boolean add(Bid bid) {
		boolean answer;
		answer = this.getBids().add(bid);
		answer = bid.getBidder().add(this);

		return answer;
	}
	
	/* (non-Javadoc)
	 * @see auction.IAuctionItem#equals(java.lang.Object)
	 */
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
	
	/* (non-Javadoc)
	 * @see auction.IAuctionItem#findBid(auction.AuctionUser)
	 */
	public IBid findBid(IAuctionUser auctionUser) {
		for (IBid bid : this.getBids()) {
			if (bid.getBidder().equals(auctionUser))
				return bid;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#getAuctionItemId()
	 */
	public int getAuctionItemId() {
		return auctionItemId;
	}
	
	/* (non-Javadoc)
	 * @see auction.IAuctionItem#getBids()
	 */
	public List<Bid> getBids() {
		return bids;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#getDescription()
	 */
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#getSeller()
	 */
	public IAuctionUser getSeller() {
		return seller;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#getSuccessfulBid()
	 */
	public IBid getSuccessfulBid() {
		return successfulBid;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#hashCode()
	 */
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

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#remove(auction.Bid)
	 */
	public boolean remove(IBid bid) {
		boolean answer = false;
		if (this.getBids().contains(bid)) {
			answer = bid.getBidder().remove(this);
		}
		return answer;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#setAuctionItemId(int)
	 */
	public void setAuctionItemId(int auctionItemId) {
		this.auctionItemId = auctionItemId;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#setBids(java.util.List)
	 */
	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#setDescription(java.lang.String)
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#setEnds(java.util.Date)
	 */
	public void setEnds(LocalDate ends) {
		this.ends = ends;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#setSeller(auction.AuctionUser)
	 */
	public void setSeller(IAuctionUser seller) {
		this.seller = seller;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#setSuccessfulBid(auction.Bid)
	 */
	public void setSuccessfulBid(IBid successfulBid) {
		this.successfulBid = successfulBid;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#toString()
	 */
	@Override
	public String toString() {
		return "AuctionItem [description=" + description + ", ends=" + ends
				+ ", seller=" + seller + "]";
	}

	
	@Id
	@Column(name="MESSAGEID", columnDefinition = "NUMBER(4,0)")
	private int auctionItemId = 0;

	
	private List<Bid> bids = new ArrayList<Bid>();

	@Column(name="DESCRIPTION", columnDefinition= "")
	private String description;

	@Column(name="ENDS", columnDefinition= "DATE")
	private LocalDate ends;
	
	@ManyToOne(targetEntity = AuctionUser.class,
		 	cascade = CascadeType.PERSIST,
		 	fetch = FetchType.EAGER)
		@JoinColumn(
		name = "SELLER",
		columnDefinition = "Number(4,0) CONSTRAINT Auctionitem_Seller_NN NOT NULL")
	private IAuctionUser seller;

	@Column(name="SUCCESFULBID", columnDefinition= "VARCHAR2 (28)")
	private IBid successfulBid;

}
