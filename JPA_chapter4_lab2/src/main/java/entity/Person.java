package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrimaryKeyJoinColumn;
/*
20043331
Lê Trần Tú Uyên
*/
//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // gia tri nao thuoc lop nao la lay lop do
//@Inheritance(strategy = InheritanceType.JOINED) // lay mqh 1-1
//lay bang con 
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public abstract class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	@Column(name ="first_name", columnDefinition = "nvarchar(50)")
	protected String firstName;
	@Column(name ="last_name",columnDefinition = "nvarchar(50)")
	protected String lastName;
	
	@Embedded
	private Contact contact;
	
	
	
	public Person(String firstName, String lastName, Contact contact) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
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



	public Contact getContact() {
		return contact;
	}



	public void setContact(Contact contact) {
		this.contact = contact;
	}



	public Person() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", contact=" + contact
				+ "]";
	}



	
}
