package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;

@Entity
@Table(name = "\"User\"")
public class User implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	private String firstName;

	private String lastName;

	private String loginName;

	private String password;

	private boolean active;

	private boolean locked;

	private String email;

	private int phone;

	@ManyToMany(targetEntity = Group.class, mappedBy = "user")
	private List<Group> groupUser = new ArrayList<Group>();

	@ManyToMany(targetEntity = ACL.class, mappedBy = "user")
	private List<ACL> acl = new ArrayList<ACL>();

	/*
	 * remove foreign keys
	 */
	@PreRemove
	private void CleanRelationShip() {

		List<Group> tempList = new ArrayList<Group>(groupUser);
		for (Group c : tempList) {
			if (c != null) {
				c.getUser().remove(this);
			}
		}

		List<ACL> tempListAcl = new ArrayList<ACL>(acl);
		for (ACL c : tempListAcl) {
			if (c != null) {
				c.getUser().remove(this);
			}
		}

	}

	public User() {
	}

	public User(String firstName, String password) {
		this.firstName = firstName;
		this.password = password;
	}

	public User(String title, String firstName, String lastName, String loginName, String password, boolean active,
			boolean locked, String email, int phone) {
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginName = loginName;
		this.password = password;
		this.active = active;
		this.locked = locked;
		this.email = email;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Group> getGroup() {
		return groupUser;
	}

	public void setGroups(List<Group> group) {
		this.groupUser = group;
	}

	public void setGroup(Group group) {
		this.groupUser.add(group);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public void setGroup(List<Group> group) {
		this.groupUser = group;
	}

	public List<ACL> getAcl() {
		return acl;
	}

	public void setAcls(List<ACL> acl) {
		this.acl = acl;
	}

	public void setAcl(ACL acl) {
		this.acl.add(acl);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", title=" + title + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", loginName=" + loginName + ", password=" + password + ", active=" + active + ", locked=" + locked
				+ ", email=" + email + ", phone=" + phone + ", group=" + groupUser + "]";
	}

}
