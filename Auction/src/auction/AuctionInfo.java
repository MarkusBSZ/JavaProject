package auction;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="AuctionInfo")
public class AuctionInfo implements IAuctionInfo{

	
	
	/* (non-Javadoc)
	 * @see auction.IAuctionInfo#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auctioninfoid == null) ? 0 : auctioninfoid.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionInfo#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuctionInfo other = (AuctionInfo) obj;
		if (auctioninfoid == null) {
			if (other.auctioninfoid != null)
				return false;
		} else if (!auctioninfoid.equals(other.auctioninfoid))
			return false;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionInfo#getAuctioninfoid()
	 */
	@Override
	public Long getAuctioninfoid() {
		return auctioninfoid;
	}

	@Override
	public IAuctionInfo setAuctioninfoid(Long auctioninfoid) {
		this.auctioninfoid = auctioninfoid;
		return this;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionInfo#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public IAuctionInfo setDescription(String description) {
		this.description = description;
		return this;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionInfo#getEnd()
	 */
	@Override
	public LocalDate getEnd() {
		return end;
	}

	@Override
	public IAuctionInfo setEnd(LocalDate end) {
		this.end = end;
		return this;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionInfo#getAmount()
	 */
	@Override
	public Long getAmount() {
		return amount;
	}

	@Override
	public IAuctionInfo setAmount(Long amount) {
		this.amount = amount;		
		return this;
	}

	@Id
	@Column(name="AuctionInfo_ID",columnDefinition="Number (4,0)")
	private Long auctioninfoid = Long.valueOf(0);
	
	@Column(name="description",columnDefinition="VARCHAR2 (255)")
	private String description;
	
	@Column(name="End",columnDefinition="DATE")
	private LocalDate end;
	
	@Column(name="Amount",columnDefinition="Number (4,0)")
	private Long amount;
}
