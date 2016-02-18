package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import auction.IAuctionUser;
import auction.Name;

public class ChangeDataTests {

	private IAuctionUser user;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Before
	public void setUp() throws Exception {	
		user.setAuctionUserId(Long.valueOf(1));
		user =
				AuctionQueryHandler.INSTANCE.changeUserDetails(user);
	}
	
	public void changed_user_data_test()
	{
		assertTrue(user.getPassword().equals("password1"));
	}
}