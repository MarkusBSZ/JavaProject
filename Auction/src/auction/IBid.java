package auction;

import java.time.LocalDateTime;

public interface IBid {

	boolean equals(Object obj);

	float getAmount();

	IAuctionUser getBidder();

	LocalDateTime getDatetime();

	Long getBidid();

	IAuctionItem getItem();

	int hashCode();

	IBid setAmount(float amount);

	IBid setBidder(IAuctionUser bidder);

	IBid setDatetime(LocalDateTime datetime);

	IBid setBidid(Long id);

	IBid setItem(IAuctionItem item);

	String toString();

}