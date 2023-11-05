package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Student")
public class Student extends Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4394960857524025011L;
	@Column(name = "EnrollmentDate", columnDefinition = "datetime")
	private LocalDateTime enrollmentDate;
	
	public Student() {
	}

	public Student(String firstName, String lastName, LocalDateTime enrollmentDate) {
		super(firstName, lastName);
		this.enrollmentDate = enrollmentDate;
	}

	public LocalDateTime getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDateTime enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	@Override
	public String toString() {
		return "Student [enrollmentDate=" + enrollmentDate + ", toString()=" + super.toString() + "]";
	}

	
	
}
