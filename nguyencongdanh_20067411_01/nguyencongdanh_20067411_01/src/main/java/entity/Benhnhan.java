package entity;

import java.util.List;

public class Benhnhan {
	private String id;
	private String first_name;
	private String last_name;
	private String blood_type;
	private String gender;
	private Address address;
	private List<String> telephones;
	private Tests tests;
	private int year_of_birth;
	public Benhnhan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Benhnhan(String id, String first_name, String last_name, String blood_type, String gender, Address address,
			List<String> telephones, Tests tests, int year_of_birth) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.blood_type = blood_type;
		this.gender = gender;
		this.address = address;
		this.telephones = telephones;
		this.tests = tests;
		this.year_of_birth = year_of_birth;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getBlood_type() {
		return blood_type;
	}
	public void setBlood_type(String blood_type) {
		this.blood_type = blood_type;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<String> getTelephones() {
		return telephones;
	}
	public void setTelephones(List<String> telephones) {
		this.telephones = telephones;
	}
	public Tests getTests() {
		return tests;
	}
	public void setTests(Tests tests) {
		this.tests = tests;
	}
	public int getYear_of_birth() {
		return year_of_birth;
	}
	public void setYear_of_birth(int year_of_birth) {
		this.year_of_birth = year_of_birth;
	}
	@Override
	public String toString() {
		return "Benhnhan [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", blood_type="
				+ blood_type + ", gender=" + gender + ", address=" + address + ", telephones=" + telephones + ", tests="
				+ tests + ", year_of_birth=" + year_of_birth + "]";
	}

	
}
