package entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value ="Student")
public class Student extends Person {
	
	@Column(name ="EnrollmentDate")
	private LocalDate enrollmentDate;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String firstName, String lastName, LocalDate enrollmentDate) {
		super(firstName, lastName);
		this.enrollmentDate = enrollmentDate;
	}

	public Student(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	@Override
	public String toString() {
		return "Student [enrollmentDate=" + enrollmentDate + ", firstName=" + firstName + ", id=" + id + ", lastName="
				+ lastName + "]";
	}

	
	
	

}
