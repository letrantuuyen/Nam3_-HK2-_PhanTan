package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "projects")
public class Project implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -367433948090444792L;
	private double budget;
	private String department;
	@Id
	private String id;
	private String location;
	private String name;
	private Date startDate;
	//private List<Assignment> assignments;
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Project(double budget, String department, String id, String location, String name, Date startDate) {
		super();
		this.budget = budget;
		this.department = department;
		this.id = id;
		this.location = location;
		this.name = name;
		this.startDate = startDate;
	}
	public Project(double budget, String department, String id, String location, String name, Date startDate,
			List<Assignment> assignments) {
		super();
		this.budget = budget;
		this.department = department;
		this.id = id;
		this.location = location;
		this.name = name;
		this.startDate = startDate;
		//this.assignments = assignments;
	}
	@Override
	public String toString() {
		return "Project [budget=" + budget + ", department=" + department + ", id=" + id + ", location=" + location
				+ ", name=" + name + ", startDate=" + startDate + "]";
	}
	public Project() {
		// TODO Auto-generated constructor stub
	}
	
}
