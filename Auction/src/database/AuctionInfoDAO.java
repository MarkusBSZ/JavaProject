package database;

import javax.persistence.EntityManager;

import auction.AuctionInfo;
import auction.IAuctionInfo;
import auction.IAuctionItem;

public class AuctionInfoDAO  implements GenericDao<IAuctionInfo>{

	@Override
	public IAuctionInfo find(IAuctionInfo entity, EntityManager em) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IAuctionInfo findById(IAuctionInfo entity, EntityManager em) {
		return (IAuctionInfo) em.find(AuctionInfo.class, entity.getAuctioninfoid());
	}

	@Override
	public void persist(IAuctionInfo entity, EntityManager em) {
		em.persist(entity);
	}

	@Override
	public void remove(IAuctionInfo entity, EntityManager em) {
		// TODO Auto-generated method stub
		
	}
	private static AuctionInfoDAO INSTANCE = null;
	
	public static AuctionInfoDAO getInstance() {
		if(AuctionInfoDAO.INSTANCE == null)
		{
			AuctionInfoDAO.INSTANCE = new AuctionInfoDAO();
		}
		return AuctionInfoDAO.INSTANCE;
	}
	
	public static void setINSTANCE(AuctionInfoDAO INSTANCE) {
		INSTANCE = INSTANCE;
	}

}
