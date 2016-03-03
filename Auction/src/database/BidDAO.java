package database;

import java.util.List;

import javax.persistence.EntityManager;

import auction.Bid;
import auction.IBid;

public class BidDAO implements GenericDao<IBid>{

	@Override
	public IBid find(IBid entity, EntityManager em) {
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}
}
