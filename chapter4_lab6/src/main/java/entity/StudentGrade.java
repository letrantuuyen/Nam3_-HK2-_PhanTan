package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class StudentGrade {
	
	@Id
	@Column(name ="EnrollmentID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enrollmentID;
	
	@ManyToOne
	@JoinColumn(name ="CourseID")
	private Course course;
	
	
	@Column(name ="Grade", columnDefinition = "decimal")
	private double grade;
	
	@ManyToOne
	@JoinColumn(name="StudentID")
	private Student student;
	
	public StudentGrade() {
		// TODO Auto-generated constructor stub
	}

	public StudentGrade(Course course, double grade, Student student) {
		super();
		this.course = course;
		this.grade = grade;
		this.student = student;
	}
	 
	
	
	
	

}
