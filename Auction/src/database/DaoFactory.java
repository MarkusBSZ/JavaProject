package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


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

	public static DaoFactory getINSTANCE() {
		if (DaoFactory.INSTANCE == null) {
			DaoFactory.INSTANCE = new DaoFactory();
		}
		return INSTANCE;
	}

}
