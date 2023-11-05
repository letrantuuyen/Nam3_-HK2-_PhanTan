package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="patients")
@NamedQueries({
	@NamedQuery(name="get_all_patients", query = "select p from Patient p")
})
public class Patient implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1553778605484017070L;
	@Id
	private String patientId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	private String gender;
	private String telephone;
	@Column(name="blood_type")
	private String bloodType;
	@Column(name="year_of_birth")
	private int yearOfBirth;
	
	@ElementCollection
	private List<Test> tests;
	
	@Embedded
	private Address address;
	
	
	public Patient() {
	}

	public Patient(String patientId, String firstName, String lastName, String gender, String telephone,
			String bloodType, int yearOfBirth) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.telephone = telephone;
		this.bloodType = bloodType;
		this.yearOfBirth = yearOfBirth;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}


	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", telephone=" + telephone + ", bloodType=" + bloodType + ", yearOfBirth=" + yearOfBirth
				+"]";
	}
	
	
}
