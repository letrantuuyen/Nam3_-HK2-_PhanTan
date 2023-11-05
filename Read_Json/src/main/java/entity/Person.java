package entity;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String id;
	private String first_name;
	private String last_name;
	private String gender;
	private String blood_type;
	private Address address;
	List<Phone> phone;
	List<Test> test;
	private int year_of_birth;
	
	public Person(String id, String first_name, String last_name, String gender, String blood_type, Address address,
			List<Phone> phone, List<Test> test, int year_of_birth) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.blood_type = blood_type;
		this.address = address;
		this.phone = phone;
		this.test = test;
		this.year_of_birth = year_of_birth;
	}
	
	public Person() {
		super();
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBlood_type() {
		return blood_type;
	}
	public void setBlood_type(String blood_type) {
		this.blood_type = blood_type;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	

	public List<Phone> getPhone() {
		return phone;
	}
	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}
	public List<Test> getTest() {
		return test;
	}
	public void setTest(List<Test> test) {
		this.test = test;
	}
	public int getYear_of_birth() {
		return year_of_birth;
	}
	public void setYear_of_birth(int year_of_birth) {
		this.year_of_birth = year_of_birth;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", gender=" + gender
				+ ", blood_type=" + blood_type + ", address=" + address + ", phone=" + phone + ", test=" + test
				+ ", year_of_birth=" + year_of_birth + "]";
	}
	
	
	

}
