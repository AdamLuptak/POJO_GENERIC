package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;

@Entity
@Table(name = "\"Group\"")
public class Group implements Serializable {
	@Id
	@GeneratedValue
	private long id;

	private String name;

	private String Description;
	@OneToMany
	private List<Group> groups = new ArrayList<Group>();

	@ManyToMany(fetch = FetchType.EAGER)
	private List<User> user = new ArrayList<User>();

	@ManyToMany(targetEntity = ACL.class, mappedBy = "groupAcl")
	private List<ACL> acl = new ArrayList<ACL>();

	/*
	 * remove foreign keys
	 */
	@PreRemove
	private void CleanRelationShip() {

		List<ACL> tempList = new ArrayList<ACL>(acl);
		for (ACL c : tempList) {
			if (c != null) {
				c.getGroup().remove(this);
			}
		}
	}

	public Group() {

	}

	public Group(String name, String description) {
		this.name = name;
		Description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public void setUser(User user) {
		this.user.add(user);
	}

	public List<ACL> getAcl() {
		return acl;
	}

	public void setAcl(List<ACL> acl) {
		this.acl = acl;
	}

}
