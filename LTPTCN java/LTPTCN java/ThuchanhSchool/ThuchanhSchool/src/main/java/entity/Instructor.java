package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
@DiscriminatorValue(value = "Instructor")
public class Instructor extends Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5143124691785566527L;
	@Column(name = "HireDate", columnDefinition = "datetime")
	private LocalDateTime hireDate;
	
	@ManyToMany(mappedBy = "instructors")
	private Set<Course> courses;
	
	
	public Instructor() {
	}


	public Instructor(String firstName, String lastName, LocalDateTime hireDate) {
		super(firstName, lastName);
		this.hireDate = hireDate;
	}

	
	
}
