package database;

import java.util.List;

import javax.persistence.EntityManager;

import auction.AuctionInfo;
import auction.IAuctionInfo;
import auction.IAuctionItem;

public class AuctionInfoDAO  implements GenericDao<IAuctionInfo>{

	@SuppressWarnings("unchecked")
	@Override
	public IAuctionInfo find(IAuctionInfo entity, EntityManager em) {
		IAuctionInfo found = null;
		
		StringBuilder stringBuilder = new StringBuilder();		
		stringBuilder
			.append("SELECT a FROM AuctionUser a ")
			.append("WHERE a.end = :end ")
			.append("AND a.description = :description ");
		
		List<IAuctionInfo> auctionInfos =
				em
					.createQuery(stringBuilder.toString())
					.setParameter("description", entity.getDescription())
					.setParameter("end", entity.getEnd())
					.getResultList();
		
		if(!auctionInfos.isEmpty())
		{
			found = auctionInfos.get(0);
		}
		
		return found;
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
		em.remove(entity);
		
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

	@Override
	public List<IAuctionInfo> findAll(EntityManager em) {
		// TODO Auto-generated method stub
		return null;
	}

}
