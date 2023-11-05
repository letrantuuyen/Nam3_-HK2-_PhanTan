package entity;

import java.util.Date;
import java.util.List;

public class Customer {
	private String customerId;
	private String firstName;
	private String lastName;
	private String email;
	private Date registationDate;
	private Address address;
	private List<Phone> phones;
	public Customer(String customerId, String firstName, String lastName, String email, Date registationDate,
			Address address, List<Phone> phones) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.registationDate = registationDate;
		this.address = address;
		this.phones = phones;
	}
	public Customer(String customerId) {
		super();
		this.customerId = customerId;
	}
	public Customer() {
		super();
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegistationDate() {
		return registationDate;
	}
	public void setRegistationDate(Date registationDate) {
		this.registationDate = registationDate;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Phone> getPhones() {
		return phones;
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", registationDate=" + registationDate + ", address=" + address + ", phones=" + phones + "]";
	}
	

}
