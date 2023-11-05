package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name ="Administrator")
	private int administrator;
	@Column(name ="Budget", columnDefinition = "money")
	private double budget;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="DepartmentID")
	@Id
	private int id;
	@Column(name ="Name")
	private String name;
	@Column(name ="StartDate")
	private LocalDate startDate;
	
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(int administrator, double budget, int id, String name, LocalDate startDate) {
		super();
		this.administrator = administrator;
		this.budget = budget;
		this.id = id;
		this.name = name;
		this.startDate = startDate;
	}
	

}
