package auction;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="BID")
public class Bid implements IBid {
	public Bid() {
		super();
	}

	/* (non-Javadoc)
	 * @see auction.IBid#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bid other = (Bid) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (bidder == null) {
			if (other.bidder != null)
				return false;
		} else if (!bidder.equals(other.bidder))
			return false;
		if (datetime == null) {
			if (other.datetime != null)
				return false;
		} else if (!datetime.equals(other.datetime))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see auction.IBid#getAmount()
	 */
	public float getAmount() {
		return amount;
	}
	
	/* (non-Javadoc)
	 * @see auction.IBid#getBidder()
	 */
	public IAuctionUser getBidder() {
		return bidder;
	}

	/* (non-Javadoc)
	 * @see auction.IBid#getDatetime()
	 */
	public LocalDate getDatetime() {
		return datetime;
	}

	/* (non-Javadoc)
	 * @see auction.IBid#getId()
	 */
	public int getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see auction.IBid#getItem()
	 */
	public IAuctionItem getItem() {
		return item;
	}

	/* (non-Javadoc)
	 * @see auction.IBid#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + ((bidder == null) ? 0 : bidder.hashCode());
		result = prime * result
				+ ((datetime == null) ? 0 : datetime.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see auction.IBid#setAmount(float)
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}

	/* (non-Javadoc)
	 * @see auction.IBid#setBidder(auction.IAuctionUser)
	 */
	public void setBidder(IAuctionUser bidder) {
		this.bidder = bidder;
	}

	/* (non-Javadoc)
	 * @see auction.IBid#setDatetime(java.util.Date)
	 */
	public void setDatetime(LocalDate datetime) {
		this.datetime = datetime;
	}

	/* (non-Javadoc)
	 * @see auction.IBid#setId(int)
	 */
	public void setId(int id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see auction.IBid#setItem(auction.IAuctionItem)
	 */
	public void setItem(IAuctionItem item) {
		this.item = item;
	}

	/* (non-Javadoc)
	 * @see auction.IBid#toString()
	 */
	@Override
	public String toString() {
		return "Bid [bidder=" + bidder.getName() + "]";
	}

	@Id
	@Column(name="AMOUNT",columnDefinition="NUMBER (4,0)")
	private Long bidid = Long.valueOf(0);
	
	private float amount;

	private IAuctionUser bidder;

	private LocalDate datetime;

	protected int id;

	private IAuctionItem item;
}
