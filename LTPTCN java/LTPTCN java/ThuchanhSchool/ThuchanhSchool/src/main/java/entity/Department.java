package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Department implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6732201408508224077L;
	@Id
	@Column(name="DepartmentID")
	private int id;
	@Column(name="Name", columnDefinition = "nvarchar(50)")
	private String name;
	@Column(name="Budget", columnDefinition = "money")
	private double budget;
	@Column(name="StartDate", columnDefinition = "datetime")
	private LocalDateTime startDate;
	@Column(name="Administrator")
	private int administrator;
	
	public Department() {
	}

	
	
}