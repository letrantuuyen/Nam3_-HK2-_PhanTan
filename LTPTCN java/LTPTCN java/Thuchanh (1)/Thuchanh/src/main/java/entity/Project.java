package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="projects")
public class Project implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5805451880942977744L;
	@Id
	private String id;
	private String name;
	private String location;
	private String department;
	private double budget;
	@Column(name="startDate")
	private Date startDate;
	
	public Project() {
	}

	public Project(String id, String name, String location, String department, double budget, Date startDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.department = department;
		this.budget = budget;
		this.startDate = startDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", location=" + location + ", department=" + department
				+ ", budget=" + budget + ", startDate=" + startDate + "]";
	}
}	
