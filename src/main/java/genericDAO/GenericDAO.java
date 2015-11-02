package genericDAO;

import java.io.Serializable;

/**
 * This is Generic Interface use for universal data tranaction with database
 */
public interface GenericDAO<T, PK extends Serializable> {
	/** Persist the newInstance object into database */
	void create(T newInstance);

	/**
	 * Retrieve an object that was previously persisted to the database using
	 * the indicated id as primary key
	 */
	T read(PK id);

	/** Save changes made to a persistent object. */
	void update(T transientObject);

	/** Remove an object from persistent storage in the database */
	void delete(T persistentObject);
}
