package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public abstract class Person {
	
	@Id
	protected int id;
	protected String firstName;
	protected String lastName;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

}
