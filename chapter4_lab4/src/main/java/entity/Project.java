package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="projects")
public class Project {
	
	private double budget;
	@Id
	@Column(name ="project_id")
	private String id;
	@Column(name ="project_name")
	private String name;
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

}
