package entity;

import java.io.Serializable;

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
@DiscriminatorColumn(name="Discriminator", columnDefinition = "nvarchar(50)")
public abstract class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6810854021622013397L;
	@Id
	@Column(name="PersonID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	@Column(name="FirstName", columnDefinition = "nvarchar(50)")
	protected String firstName; //varchar(255)
	@Column(name="LastName",  columnDefinition = "nvarchar(50)")
	protected String lastName;

	public Person() {
	}

	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	

	
}
