package auction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.eclipse.persistence.annotations.TypeConverter;

@Entity
@Table(name = "AuctionItem")
public class AuctionItem extends Persistence implements IAuctionItem{
	@Id
	@Column(name="AuctionItem_ID", columnDefinition = "NUMBER(4,0)")
	private Long auctionItemId;
	private List<Bid> bids = new ArrayList<Bid>();
	
	@Column(name="DESCRIPTION", columnDefinition= "")
	private String description;
	
	@Column(name="ENDS", columnDefinition= "DATE")
	@TypeConverter(name = "LocalDateToSqlDate", 
    dataType = LocalDateTime.class, 
    objectType = java.time.LocalDateTime.class)
	private LocalDateTime ends;

	@ManyToOne(targetEntity = AuctionUser.class,
		 	cascade = CascadeType.PERSIST,
		 	fetch = FetchType.EAGER)
		@JoinColumn(
		name = "SELLER",
		columnDefinition = "Number(4,0) CONSTRAINT Auctionitem_Seller_NN NOT NULL")
	private IAuctionUser seller;
	
	@OneToOne(targetEntity = Bid.class,
			cascade = CascadeType.PERSIST,
		 	fetch = FetchType.EAGER)
	@JoinColumn(
			name = "SuccessfulBid",
			columnDefinition = "Number(4,0)")
	private IBid successfulBid;

	@ManyToOne(targetEntity = AuctionInfo.class,
		 	cascade = CascadeType.PERSIST,
		 	fetch = FetchType.EAGER)
		@JoinColumn(
		name = "Auction",
		columnDefinition = "Number(4,0)")
	private IAuctionInfo auctionInfo;

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

	public IAuctionInfo getAuctionInfo() {
		return auctionInfo;
	}
	/* (non-Javadoc)
	 * @see auction.IAuctionItem#getAuctionItemId()
	 */
	public Long getAuctionItemId() {
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

	public LocalDateTime getEnds() {
		return ends;
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

	
	public IAuctionItem setAuctionInfo(IAuctionInfo auctionInfo) {
		this.auctionInfo = auctionInfo;
		return this;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#setAuctionItemId(int)
	 */
	public IAuctionItem setAuctionItemId(Long auctionItemId) {
		this.auctionItemId = auctionItemId;
		return this;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#setBids(java.util.List)
	 */
	public IAuctionItem setBids(List<Bid> bids) {
		this.bids = bids;
		return this;
	}
	
	/* (non-Javadoc)
	 * @see auction.IAuctionItem#setDescription(java.lang.String)
	 */
	public IAuctionItem setDescription(String description) {
		this.description = description;
		return this;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#setEnds(java.util.Date)
	 */
	public IAuctionItem setEnds(LocalDateTime ends) {
		this.ends = ends;
		return this;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#setSeller(auction.AuctionUser)
	 */
	public IAuctionItem setSeller(IAuctionUser seller) {
		this.seller = seller;
		return this;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#setSuccessfulBid(auction.Bid)
	 */
	public IAuctionItem setSuccessfulBid(IBid successfulBid) {
		this.successfulBid = successfulBid;
		return this;
	}
	/* (non-Javadoc)
	 * @see auction.IAuctionItem#toString()
	 */
	@Override
	public String toString() {
		return "AuctionItem [description=" + description + ", ends=" + ends
				+ ", seller=" + seller + "]";
	}
}
