package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import auction.*;

public class FindAuctionItemsTest {

	private IAuctionUser abel;
	private List<IAuctionItem> auctionItems = new ArrayList<>();
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Before
	public void setUp() throws Exception {	
		
		abel = new AuctionUser()
				.setName(new Name()
							.setFirstName("Dieter")
							.setLastName("Abel"))
				.setUsername("abeldieter");
		
		auctionItems =
				AuctionQueryHandler.INSTANCE.auctionItemsFor(abel);
	}
	
	public void search_items_for_bebel()
	{	
		List<IAuctionItem> testList =
				auctionItems.stream()
				.filter(item -> !item.getSeller().getName().getLastName().equals("abel"))
				.filter(item -> !item.getSeller().getName().getFirstName().equals("dieter"))
				.filter(item -> !item.getSeller().getUsername().equals("abeldieter"))
				.collect(Collectors.toList());
		
		assertTrue(testList.isEmpty());
	}
	
	
}
