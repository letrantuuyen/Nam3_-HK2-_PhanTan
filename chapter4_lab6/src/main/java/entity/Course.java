package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Course implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "Credits")
	protected int credits;
	@Id
	@Column(name ="CouseID")
	protected int id;
	@Column(name ="Title", columnDefinition = "nvarchar(100)")
	protected String title;
	
	
	
	@ManyToMany
	@JoinTable(name ="CoureInstructor",
	joinColumns = @JoinColumn(name ="CourseID"),
	inverseJoinColumns = @JoinColumn(name ="PersonID",referencedColumnName = "PersonID")
	)
	private Set<Instructor> instructors;
	
	
	@ManyToOne
	@JoinColumn(name ="DepartmentID")
	private Department department;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	 

	
}
