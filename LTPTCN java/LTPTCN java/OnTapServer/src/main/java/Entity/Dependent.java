package Entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class Dependent implements Serializable{
	private String firstName;
	private String lastName;
	private String relationship;
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
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	@Override
	public String toString() {
		return "Dependent [firstName=" + firstName + ", lastName=" + lastName + ", relationship=" + relationship + "]";
	}
	
}
