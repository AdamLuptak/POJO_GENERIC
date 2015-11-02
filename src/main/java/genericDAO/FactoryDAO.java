package genericDAO;

import entities.ACL;
import entities.Group;
import entities.User;

public class FactoryDAO {

	@SuppressWarnings("rawtypes")
	public static GenerciDAOImpl getShape(String factoryType) {

		if (factoryType == null) {
			return null;
		}
		if (factoryType.equalsIgnoreCase("User")) {
			return new GenerciDAOImpl<User, Long>(User.class);
		} else if (factoryType.equalsIgnoreCase("Group")) {
			return new GenerciDAOImpl<Group, Long>(Group.class);
		} else if (factoryType.equalsIgnoreCase("Acl")) {
			return new GenerciDAOImpl<ACL, Long>(ACL.class);
		}
		return null;
	}
}
