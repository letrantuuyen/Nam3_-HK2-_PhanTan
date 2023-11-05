package entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import jakarta.persistence.Table;

@Entity
@Table(name = "EmployeeProject")
public class EmployeeProject implements Serializable {
	private int hours;
	@Id
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "employeeID")
	private Employee employee;
	@Id
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "projectID")
	private Project project;
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public EmployeeProject(int hours, Employee employee, Project project) {
		super();
		this.hours = hours;
		this.employee = employee;
		this.project = project;
	}
	public EmployeeProject() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmployeeProject [hours=" + hours + ", employeeID=" + employee.getEmployeeID() + ", projectID=" + project.getProjectID() + "]";
	}
	
}
