package testing;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import auction.IAuctionInfo;
import auction.IAuctionItem;
import auction.IAuctionUser;
import auction.IBid;
import database.DaoFactory;
import database.GenericDao;

public class CreateDatabase {
	public static void main(String... args) {
		EntityManager em = DaoFactory.getInstance().getEm();
		
		EntityTransaction tx = em.getTransaction();
		GenericDao<IBid> jpaBidDao = DaoFactory.getInstance().getBidDao();
		GenericDao<IAuctionItem> jpaAuctionItemDao = DaoFactory.getInstance().getAuctionItemDao();
		GenericDao<IAuctionUser> jpaAuctionUserDao = DaoFactory.getInstance().getAuctionUserDao();
		GenericDao<IAuctionInfo> jpaAuctionInfoDao = DaoFactory.getInstance().getAuctionInfoDao();
		tx.begin();
		// populate data
		//jpaAuctionUserDao.persist(AuctionObjectFactory.INSTANCE.abel(),em);
     	//jpaAuctionUserDao.persist(AuctionObjectFactory.INSTANCE.bebel(),em);
     	jpaAuctionItemDao.persist(AuctionObjectFactory.INSTANCE.car(), em);
     	jpaAuctionItemDao.persist(AuctionObjectFactory.INSTANCE.computer(), em);
		tx.commit();
		
		DaoFactory.getInstance().closeEm();
		DaoFactory.getInstance().closeEntityManagerFactory();
		
		return;
	}
}
