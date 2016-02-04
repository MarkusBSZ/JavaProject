package auction;

import java.time.LocalDate;
import java.util.Date;

public interface IBid {

	boolean equals(Object obj);

	float getAmount();

	IAuctionUser getBidder();

	LocalDate getDatetime();

	int getId();

	IAuctionItem getItem();

	int hashCode();

	void setAmount(float amount);

	void setBidder(IAuctionUser bidder);

	void setDatetime(LocalDate datetime);

	void setId(int id);

	void setItem(IAuctionItem item);

	String toString();

}