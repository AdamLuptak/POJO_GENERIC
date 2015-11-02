package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "\"ACL\"")
public class ACL {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String premission;

	@ManyToMany(targetEntity = Group.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Group> groupAcl = new ArrayList<Group>();

	@ManyToMany(targetEntity = User.class, fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<User> user = new ArrayList<User>();

	public ACL() {

	}

	public ACL(String name, String premission) {

		this.name = name;
		this.premission = premission;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPremission() {
		return premission;
	}

	public void setPremission(String premission) {
		this.premission = premission;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Group> getGroup() {
		return groupAcl;
	}

	public void setGroups(List<Group> group) {
		this.groupAcl = group;
	}

	public void setGroup(Group group) {
		this.groupAcl.add(group);
	}

	public List<User> getUser() {
		return user;
	}

	public void setUsers(List<User> user) {
		this.user = user;
	}

	public void setUser(User user) {
		this.user.add(user);
	}
}
