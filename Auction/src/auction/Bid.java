package auction;

import java.util.Date;
import javax.persistence.*;

public class Bid {
	private float amount;

	private AuctionUser bidder;
	
	private Date datetime;
	
	protected int id;

	private AuctionItem item;

	public Bid() {
		super();
	}

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

	public float getAmount() {
		return amount;
	}

	public AuctionUser getBidder() {
		return bidder;
	}

	public Date getDatetime() {
		return datetime;
	}

	public int getId() {
		return id;
	}

	public AuctionItem getItem() {
		return item;
	}

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

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public void setBidder(AuctionUser bidder) {
		this.bidder = bidder;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setItem(AuctionItem item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Bid [bidder=" + bidder.getName() + "]";
	}
}
