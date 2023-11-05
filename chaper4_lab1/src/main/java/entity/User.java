package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@Column(name ="user_id")
	private int userId;
	
	@Column(name ="user_name")
	private String userName;
	
	private String password;
	private String email;
	public User() {
		// TODO Auto-generated constructor stub
	}
}
