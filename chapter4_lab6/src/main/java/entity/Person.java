package entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="Discriminator")
public abstract class Person {
	
	@Column(name ="FirstName", columnDefinition = "nvarchar(50)")
	protected String firstName;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="PersonID")
	protected int id;
	@Column(name ="LastName", columnDefinition = "nvarchar(50)")
	protected String lastName;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", id=" + id + ", lastName=" + lastName + "]";
	}
	
	
	

}
