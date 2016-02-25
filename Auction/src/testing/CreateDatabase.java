package testing;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import database.DaoFactory;

public class CreateDatabase {
	public static void main(String... args) {
		EntityManager em = DaoFactory.getInstance().getEm();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		
		
		// populate data
		tx.commit();
		
		DaoFactory.getInstance().closeEm();
		DaoFactory.getInstance().closeEntityManagerFactory();
		
		return;
	}
}
