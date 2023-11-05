package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="DepartmentEmployees")
public class DepartmentEmployee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2319162979297590066L;
	@Id
	@ManyToOne
	@JoinColumn(name="departmentId")
	private Department department;
	@Id
	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee;
	@Id
	@Column(nullable = false)
	private Date fromDate;
	private Date toDate;
	
	public DepartmentEmployee() {
	}

	public DepartmentEmployee(Department department, Employee employee, Date fromDate, Date toDate) {
		super();
		this.department = department;
		this.employee = employee;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	@Override
	public String toString() {
		return "DepartmentEmployee [department=" + department + ", employee=" + employee + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(department, employee, fromDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartmentEmployee other = (DepartmentEmployee) obj;
		return Objects.equals(department, other.department) && Objects.equals(employee, other.employee)
				&& Objects.equals(fromDate, other.fromDate);
	}
	
	
}
