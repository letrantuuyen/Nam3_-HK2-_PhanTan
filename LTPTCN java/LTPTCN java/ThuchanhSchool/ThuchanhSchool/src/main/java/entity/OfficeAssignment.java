package entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class OfficeAssignment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8127503129971893021L;

	@Id
	@OneToOne
	@JoinColumn(name="InstructorID", unique = true)
	private Instructor instructor;
	
	@Column(name="Location", columnDefinition = "nvarchar(50)")
	private String location;
	@Column(name="Timestamp", columnDefinition = "timestamp")
	private Timestamp timestamp;
	
	public OfficeAssignment() {
	}

	
	
	
}
