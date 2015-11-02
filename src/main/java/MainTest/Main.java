package MainTest;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Group;
import entities.User;
import genericDAO.FactoryDAO;
import genericDAO.GenerciDAOImpl;

public class Main {

	private static final String FACTORY_NAME = "hello-world";

	public static void main(String[] args) {

		User usr1 = new User("adam", "admin");
		User usr2 = new User("Peter", "admin");
		User usr3 = new User("Milan", "admin");
		User usr4 = new User("H", "admin");
		User usr5 = new User("Edo", "admin");

		User usr6 = new User("adam", "admin");
		User usr7 = new User("Peter", "admin");
		User usr8 = new User("Milan", "admin");
		User usr9 = new User("H", "admin");
		User usr10 = new User("Edo", "admin");

		List<User> users = Arrays.asList(usr1, usr2, usr3, usr4, usr5);

		List<User> users2 = Arrays.asList(usr6, usr7, usr8, usr9, usr10);
		// GenerciDAOImpl<User, Long> userDAO = new GenerciDAOImpl<User,
		// Long>(User.class);
		// GenerciDAOImpl<Group, Long> groupDAO = new GenerciDAOImpl<Group,
		// Long>(Group.class);

		GenerciDAOImpl<User, Long> userDAO = FactoryDAO.getShape("User");

		GenerciDAOImpl<Group, Long> groupDAO = FactoryDAO.getShape("Group");

		// for (User user : users2) {
		// userDAO.create(user);
		// }
		//
		// for (int i = 0; i < 10; i++) {
		// groupDAO.create(new Group("sdfs", "sdfsdsdf"));
		// }

		
		User usr = userDAO.read(1l);
		Group temp = groupDAO.read(4l);
		Group temp2 = groupDAO.read(6l);
//		
//		temp.setUser(usr);
//		groupDAO.update(temp);
//
//		temp.setUser(usr);
//		groupDAO.update(temp);
//		
//		temp2.setUser(usr);
//		groupDAO.update(temp2);

		
		
		// usr.setGroup(temp);
		// userDAO.update(usr);
		//
		// usr.setGroup(temp2);
		// userDAO.update(usr);
		//
		 groupDAO.delete(temp);

		// userDAO.delete(usr);

		// groupDAO.update(temp);
		// userDAO.update(usr);

		// userDAO.create(usr1);
		// groupDAO.create(new Group("root", "vsetko vie"));
		//
		// User findUser = userDAO.read(1l);
		// System.out.println("stare meno " + findUser.getName());
		// findUser.setName("zmenen meno");
		// userDAO.update(findUser);
		// findUser = userDAO.read(1l);
		// System.out.println("meno po zmene " + findUser.getName());
		// userDAO.delete(findUser);
		// userDAO.create(usr1);
		//

	}

}
