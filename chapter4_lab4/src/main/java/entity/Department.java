package entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="departments")
public class Department {
	@Id
	@Column(name ="dept_id")
	private String id;
	private String location;
	@Column(name ="dept_name")
	private String name;
	
	
	@OneToMany(mappedBy = "department")
	private Set<Staff> staffs;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}
	


	
	
}
