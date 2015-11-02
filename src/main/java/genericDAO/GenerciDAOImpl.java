package genericDAO;

import java.io.Serializable;

import jpaHelper.JPAHelper;

/**
 * Implementation of GenericDAO
 */
public class GenerciDAOImpl<T, PK extends Serializable> implements GenericDAO<T, PK> {

	private Class<T> type;

	/**
	 * Create instance of Objcet type, for Type save operations
	 */
	public GenerciDAOImpl(Class<T> type) {

		this.type = type;
	}

	/**
	 * new instance object type T
	 */
	public void create(T newInstance) {
		JPAHelper.beginTransaction();
		JPAHelper.getEntityManager().persist(newInstance);
		JPAHelper.commitTransaction();
		JPAHelper.close();
	}

	/**
	 * find object with specific Id
	 */
	public T read(PK id) {
		JPAHelper.beginTransaction();
		T returnEntity = type.cast(
				JPAHelper.getEntityManager().createQuery("SELECT e FROM " + type.getName() + " e where e.id = :id")
						.setParameter("id", id).getSingleResult());
		JPAHelper.close();
		return returnEntity;
	}

	/**
	 * update specific object in database
	 */
	public void update(T transientObject) {
		JPAHelper.beginTransaction();
		JPAHelper.getEntityManager().merge(transientObject);
		JPAHelper.commitTransaction();
		JPAHelper.close();
	}

	/**
	 * delete instance from datasource
	 */
	public void delete(T persistentObject) {
		JPAHelper.beginTransaction();
		JPAHelper.getEntityManager().remove(JPAHelper.getEntityManager().contains(persistentObject) ? persistentObject
				: JPAHelper.getEntityManager().merge(persistentObject));
		JPAHelper.commitTransaction();
		JPAHelper.close();
	}

}
