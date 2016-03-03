package database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import auction.AuctionItem;
import auction.IAuctionItem;

public class AuctionItemDAO implements GenericDao<IAuctionItem> {

	@Override
	public IAuctionItem find(IAuctionItem entity, EntityManager em) {
		IAuctionItem found = null;
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder
			.append("SELECT a FROM AuctionItem a ")
			.append("WHERE a.Auction = :auction AND ")
			.append("a.Description = :description");
		
		List<IAuctionItem> auctionItems =
			em
				.createQuery(stringBuilder.toString())
				.setParameter("auction", entity.getAuctionInfo())
				.setParameter("description", entity.getDescription())
				.getResultList();
				
		if(!auctionItems.isEmpty())
		{
			found = auctionItems.get(0);
		}
		return found;
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

	@Override
	public List<IAuctionItem> findAll(EntityManager em) {
		Query queryItems = em.createQuery("Select a From AuctionItem a");
		return queryItems.getResultList();
	}
}
