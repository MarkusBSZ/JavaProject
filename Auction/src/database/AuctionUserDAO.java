package database;

import java.util.List;

import javax.persistence.EntityManager;

import auction.AuctionUser;
import auction.IAuctionUser;

public final class AuctionUserDAO implements GenericDao<IAuctionUser>{

	@SuppressWarnings("unchecked")
	@Override
	public IAuctionUser find(IAuctionUser entity, EntityManager em) {
		IAuctionUser found = null;
		
		StringBuilder stringBuilder = new StringBuilder();		
		stringBuilder
			.append("SELECT a FROM AuctionUser a ")
			.append("WHERE a.username = :user ");
		
		List<IAuctionUser> auctionUsers = 
			em
				.createQuery(stringBuilder.toString())
				.setParameter("user", entity.getUsername())
				.getResultList();
		
		if(!auctionUsers.isEmpty())
		{
			found = auctionUsers.get(0);
		}
		return found;
	}

	@Override
	public IAuctionUser findById(IAuctionUser entity, EntityManager em) {
		return (IAuctionUser) em.find(AuctionUser.class, entity.getAuctionUserId());
	}

	@Override
	public void persist(IAuctionUser entity, EntityManager em) {
		em.persist(entity);
	}

	@Override
	public void remove(IAuctionUser entity, EntityManager em) {
		
	}

private static AuctionUserDAO INSTANCE = null;
	
	public static AuctionUserDAO getInstance() {
		if(AuctionUserDAO.INSTANCE == null)
		{
			AuctionUserDAO.INSTANCE = new AuctionUserDAO();
		}
		return AuctionUserDAO.INSTANCE;
	}
	
	public static void setINSTANCE(AuctionUserDAO INSTANCE) {
		INSTANCE = INSTANCE;
	}
}
