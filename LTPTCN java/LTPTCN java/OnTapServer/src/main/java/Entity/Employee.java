package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "employees")
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9094010714078054939L;
	private String email;
	private String firstName;
	private String gender;
	private Date hireDate;
	@Id
	private String id;
	private String lastName;
	@ElementCollection
	private Set<String>phones;
	@ElementCollection
	private List<Dependent>dependents;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Set<String> getPhones() {
		return phones;
	}
	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}
	public Employee(String email, String firstName, String gender, Date hireDate, String id, String lastName,
			Set<String> phones, List<Dependent> dependents) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.gender = gender;
		this.hireDate = hireDate;
		this.id = id;
		this.lastName = lastName;
		this.phones = phones;
		this.dependents = dependents;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [email=" + email + ", firstName=" + firstName + ", gender=" + gender + ", hireDate=" + hireDate
				+ ", id=" + id + ", lastName=" + lastName + ", phones=" + phones + ", dependents=" + dependents + "]";
	}
	
}
