package database;

import javax.persistence.EntityManager;

import auction.IAuctionItem;

public class AuctionItemDAO implements GenericDao<IAuctionItem> {

	@Override
	public IAuctionItem find(IAuctionItem entity, EntityManager em) {
		return null;
	}

	@Override
	public IAuctionItem findById(IAuctionItem entity, EntityManager em) {
		return null;
	}

	@Override
	public void persist(IAuctionItem entity, EntityManager em) {
		
	}

	@Override
	public void remove(IAuctionItem entity, EntityManager em) {
		
	}

}