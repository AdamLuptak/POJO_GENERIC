package jpaHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAHelper {
	private static EntityManagerFactory factory;
	private static EntityManager em;
	private static final String PERSISTENCE_UNIT_NAME = "hello-world";

	private static void init() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		if (em == null) {
			em = factory.createEntityManager();
		}
	}

	public static EntityManager getEntityManager() {
		init();
		return em;
	}

	public static void beginTransaction() {
		init();
		em.getTransaction().begin();
	}

	public static void commitTransaction() {
		try {
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public static void close() {
		if (em != null) {
			em.close();
			em = null;
		}
		if (factory != null) {
			factory.close();
			factory = null;
		}
	}

}
