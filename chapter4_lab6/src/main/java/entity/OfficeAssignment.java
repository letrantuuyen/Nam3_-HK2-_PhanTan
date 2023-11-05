package entity;

import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class OfficeAssignment {
	
	@Id
	@OneToOne
	@JoinColumn(name ="InstructorID", unique = true)
	private Instructor InstructorID;
	@Column(name ="Location", columnDefinition = "nvarchar(255)")
	private String location;
	@Column(name ="Timestamp")
	private Timestamp timestamp;
	
	public OfficeAssignment() {
		// TODO Auto-generated constructor stub
	}
	

}
