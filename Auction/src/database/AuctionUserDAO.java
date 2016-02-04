package database;

import javax.persistence.EntityManager;

import auction.IAuctionUser;

public final class AuctionUserDAO implements GenericDao<IAuctionUser>{

	@Override
	public IAuctionUser find(IAuctionUser entity, EntityManager em) {
		return null;
	}

	@Override
	public IAuctionUser findById(IAuctionUser entity, EntityManager em) {
		return null;
	}

	@Override
	public void persist(IAuctionUser entity, EntityManager em) {
		
	}

	@Override
	public void remove(IAuctionUser entity, EntityManager em) {
		
	}

}
