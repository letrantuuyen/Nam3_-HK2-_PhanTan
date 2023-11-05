package entity;

import jakarta.persistence.Entity;

@Entity
public class Staff extends Person {
	
	private byte active;
	
	public Staff() {
		// TODO Auto-generated constructor stub
	}

}
