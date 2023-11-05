 package entity;

import java.util.List;

public class Person {
	private String firstName;
	private String lastName;
	private int age;
	private Address address;
	List<Phone> phoneNumbers;
	public Person(String firstName, String lastName, int age, Address address, List<Phone> phones) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.phoneNumbers = phones;
	}
	public Person() {
		super();
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Phone> getPhones() {
		return phoneNumbers;
	}
	public void setPhones(List<Phone> phones) {
		this.phoneNumbers = phones;
	}
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", address=" + address
				+ ", phones=" + phoneNumbers + "]";
	}
	
	

}
