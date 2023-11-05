package Entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="FacultyCourses")
public class facultyCourse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6847454438675235312L;
	@Id
	@ManyToOne
	@JoinColumn(name="fact_id")
	private Faculty faculty;
	@Id
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	
	
	public facultyCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public facultyCourse(Faculty faculty, Course course) {
		super();
		this.faculty = faculty;
		this.course = course;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "facultyCourse [faculty=" + faculty + ", course=" + course + "]";
	}
	
	
	
}
