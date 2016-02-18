package database;

import javax.persistence.EntityManager;

import auction.IBid;

public class BidDAO implements GenericDao<IBid>{

	@Override
	public IBid find(IBid entity, EntityManager em) {
		return null;
	}

	@Override
	public IBid findById(IBid entity, EntityManager em) {
		return null;
	}

	@Override
	public void persist(IBid entity, EntityManager em) {
		
	}

	@Override
	public void remove(IBid entity, EntityManager em) {
		
	}

	private static BidDAO INSTANCE = null;
	
	
	public static void setINSTANCE(BidDAO INSTANCE) {
		INSTANCE = INSTANCE;
	}
}
