package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="user_group")
public class UserGroup {

	@Id
	@ManyToOne
	private User user;
	@Id
	@ManyToOne
	private Group group;
	public UserGroup() {
		// TODO Auto-generated constructor stub
	}
	public UserGroup(User user, Group group) {
		super();
		this.user = user;
		this.group = group;
	}
	
	
}
