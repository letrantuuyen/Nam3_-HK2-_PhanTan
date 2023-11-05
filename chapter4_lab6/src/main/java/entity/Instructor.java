package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue(value = "Instructor")
public class Instructor extends Person implements Serializable{
	
	@Column(name = "HireDate", columnDefinition = "datetime")
	private LocalDate hireDate;
	
	public Instructor() {
		// TODO Auto-generated constructor stub
	}

	@ManyToMany(mappedBy = "instructors")
	private Set<Course> course;

	public Instructor(String firstName, String lastName, LocalDate hireDate) {
		super(firstName, lastName);
		this.hireDate = hireDate;
	}
	
	
	

}
