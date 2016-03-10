package database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import auction.Bid;
import auction.IBid;

public class BidDAO implements GenericDao<IBid>{

	@SuppressWarnings("unchecked")
	@Override
	public IBid find(IBid entity, EntityManager em) {
		IBid  found = null;
		
		StringBuilder stringBuilder = new StringBuilder();		
		stringBuilder
			.append("SELECT a FROM Bid a ")
			.append("WHERE a.bidder = :bidder ")
			.append("AND a.item = :item ");
		
		List<IBid> bids =
				em
					.createQuery(stringBuilder.toString())
					.setParameter("bidder", entity.getBidder())
					.setParameter("item", entity.getItem())
					.getResultList();
					
		if(!bids.isEmpty())
		{
			found = bids.get(0);
		}
		return found;
	}

	@Override
	public IBid findById(IBid entity, EntityManager em) {
		return (IBid) em.find(Bid.class, entity.getBidid());
	}

	@Override
	public void persist(IBid entity, EntityManager em) {
		em.persist(entity);
	}

	@Override
	public void remove(IBid entity, EntityManager em) {
		em.remove(entity);
	}

	private static BidDAO INSTANCE = null;
	
	public static BidDAO getInstance() {
		if(BidDAO.INSTANCE == null)
		{
			BidDAO.INSTANCE = new BidDAO();
		}
		return BidDAO.INSTANCE;
	}
	
	public static void setINSTANCE(BidDAO INSTANCE) {
		INSTANCE = INSTANCE;
	}

	@Override
	public List<IBid> findAll(EntityManager em) {
		Query queryItems = em.createQuery("Select a From Bid a");
		return queryItems.getResultList();
	}
}
