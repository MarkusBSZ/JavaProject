package auction;

import java.time.LocalDate;
import java.util.Date;

public interface IBid {

	boolean equals(Object obj);

	float getAmount();

	IAuctionUser getBidder();

	LocalDate getDatetime();

	Long getBidid();

	IAuctionItem getItem();

	int hashCode();

	IBid setAmount(float amount);

	IBid setBidder(IAuctionUser bidder);

	IBid setDatetime(LocalDate datetime);

	IBid setBidid(Long id);

	IBid setItem(IAuctionItem item);

	String toString();

}