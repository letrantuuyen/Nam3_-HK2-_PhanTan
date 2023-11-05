package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
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
	
}
