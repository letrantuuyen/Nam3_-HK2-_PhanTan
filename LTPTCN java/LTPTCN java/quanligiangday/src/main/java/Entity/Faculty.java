package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="Faculties")
public class Faculty implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -179909529319609597L;
	@Column(name="date_of_birth",columnDefinition = "date")
	private Date dateOfBirth;
	@Id
	@Column(name="fact_id",columnDefinition = "char(9)",nullable = false)
	private String id;
	@Column(name="full_name",columnDefinition = "nvarchar(100)",nullable = false)
	private String name;
	@Column(columnDefinition = "decimal(10,2)")
	private double salary;
	@ManyToMany
	@JoinTable(name="FacultyCourses",joinColumns = @JoinColumn(name="fact_id",referencedColumnName = "fact_id"),
			inverseJoinColumns = @JoinColumn(name="course_id",referencedColumnName = "course_id"))
	private List<Course> courses;
	public Faculty(Date dateOfBirth, String id, String name, double salary) throws Exception {
		super();
		this.dateOfBirth = dateOfBirth;
		this.id = id;
		setName(name);
		this.salary = salary;
	}
	
	

	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
	public void setName(String name) throws Exception {
		if(name == ""|| name == null)
		{
			throw new Exception("Ten khong duoc rong");
			
		}
		else
		{
			this.name = name;
		}
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Faculty [dateOfBirth=" + dateOfBirth + ", id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
	
	
	
	
}
