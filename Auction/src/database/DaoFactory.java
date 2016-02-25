package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import auction.IAuctionItem;
import auction.IAuctionUser;
import auction.IBid;
import auction.IAuctionInfo;


public final class DaoFactory {
	private DaoFactory() {
		this.emf = PersistenceManager.getEntityManagerFactory();
	}

	public void closeEntityManagerFactory() {
		PersistenceManager.closeEntityManagerFactory();
	}

	public void closeEm() {
		if (this.getEm().isOpen() && this.getEm() != null) {
			this.getEm().close();
		}
	}

	public EntityManager getEm() {
		if (this.em == null) {
			this.em = this.getEmf().createEntityManager();
		}
		return em;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	private EntityManager em = null;
	private EntityManagerFactory emf = null;

	private static DaoFactory INSTANCE = null;

	public static DaoFactory getInstance() {
		if (DaoFactory.INSTANCE == null) {
			DaoFactory.INSTANCE = new DaoFactory();
		}
		return INSTANCE;
	}
	
	public GenericDao<IAuctionItem> getAuctionItemDao() {
		return AuctionItemDAO.getInstance();
	}
	public GenericDao<IAuctionUser> getAuctionUserDao() {
		return AuctionUserDAO.getInstance();
	}
	public GenericDao<IBid> getBidDao() {
		return BidDAO.getInstance();
	}
	public GenericDao<IAuctionInfo> getAuctionInfoDao() {
		return AuctionInfoDAO.getInstance();
	}
}
