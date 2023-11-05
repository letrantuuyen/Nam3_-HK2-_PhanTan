package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Group {

	@Id
	@Column(name ="group_id")
	private int groupId;
	private String name;
	
	public Group() {
		// TODO Auto-generated constructor stub
	}
	
	
}
