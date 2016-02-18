package auction;

import java.time.LocalDate;

public interface IAuctionInfo {

	int hashCode();

	boolean equals(Object obj);

	Long getAuctioninfoid();

	IAuctionInfo setAuctioninfoid(Long auctioninfoid);

	String getDescription();

	IAuctionInfo setDescription(String description);

	LocalDate getEnd();

	IAuctionInfo setEnd(LocalDate end);

	Long getAmount();

	IAuctionInfo setAmount(Long amount);

}