package database;

import javax.persistence.EntityManager;

import auction.AuctionItem;
import auction.IAuctionItem;

public class AuctionItemDAO implements GenericDao<IAuctionItem> {

	@Override
	public IAuctionItem find(IAuctionItem entity, EntityManager em) {
		return null;
	}

	@Override
	public IAuctionItem findById(IAuctionItem entity, EntityManager em) {
		return (IAuctionItem) em.find(AuctionItem.class, entity.getAuctionItemId());
	}

	@Override
	public void persist(IAuctionItem entity, EntityManager em) {
		em.persist(entity);
	}

	@Override
	public void remove(IAuctionItem entity, EntityManager em) {
		em.remove(entity);
	}

	private static AuctionItemDAO INSTANCE = null;
	
	public static AuctionItemDAO getInstance() {
		if(AuctionItemDAO.INSTANCE == null)
		{
			AuctionItemDAO.INSTANCE = new AuctionItemDAO();
		}
		return AuctionItemDAO.INSTANCE;
	}
	
	public static void setINSTANCE(AuctionItemDAO INSTANCE) {
		INSTANCE = INSTANCE;
	}
}
