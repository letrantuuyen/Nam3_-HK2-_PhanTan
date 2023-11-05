package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class StudentGrade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6813985504531693073L;

	@Id
	@Column(name = "EnrollmentID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enrollmentID;

	@ManyToOne
	@JoinColumn(name="StudentID")
	private Student student;
	@ManyToOne
	@JoinColumn(name="CourseID")
	private Course course;
	
	@Column(name="Grade", columnDefinition = "decimal(3, 2)")
	private double grade;
	
	public StudentGrade() {
	}

	public StudentGrade(Student student, Course course, double grade) {
		super();
		this.student = student;
		this.course = course;
		this.grade = grade;
	}

	
	
}
