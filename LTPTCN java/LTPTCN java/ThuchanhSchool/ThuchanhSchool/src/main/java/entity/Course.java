package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Course implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3575027362974929085L;
	@Id
	@Column(name="CourseID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	@Column(name = "Title", columnDefinition = "nvarchar(100)")
	protected String title;
	@Column(name="Credits")
	protected int credits;
	
	@ManyToMany
	@JoinTable(name="CourseInstructor", joinColumns = @JoinColumn(name="CourseID", referencedColumnName = "CourseID"),
				inverseJoinColumns = @JoinColumn(name="PersonID", referencedColumnName = "PersonID")
			)
	private Set<Instructor> instructors;
	
	@ManyToOne
	@JoinColumn(name="DepartmentID")
	private Department department;
	
	
	public Course() {
	}


	public Course(String title, int credits) {
		super();
		this.title = title;
		this.credits = credits;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getCredits() {
		return credits;
	}


	public void setCredits(int credits) {
		this.credits = credits;
	}


	public Set<Instructor> getInstructors() {
		return instructors;
	}


	public void setInstructors(Set<Instructor> instructors) {
		this.instructors = instructors;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", credits=" + credits + "]";
	}

	
	
}
