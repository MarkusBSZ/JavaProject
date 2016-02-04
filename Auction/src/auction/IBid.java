package auction;

import java.util.Date;

public interface IBid {

	boolean equals(Object obj);

	float getAmount();

	IAuctionUser getBidder();

	Date getDatetime();

	int getId();

	IAuctionItem getItem();

	int hashCode();

	void setAmount(float amount);

	void setBidder(IAuctionUser bidder);

	void setDatetime(Date datetime);

	void setId(int id);

	void setItem(IAuctionItem item);

	String toString();

}