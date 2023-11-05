package entity;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class Staff {
	private long staffId;
	@BsonProperty("first_name")
	private String firstName;
	private String lastName;
	private Phone phone;
	private String email;
	private Staff staffManager;
	public Staff(long staffId, String firstName, String lastName, Phone phone, String email, Staff staffManager) {
		super();
		this.staffId = staffId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.staffManager = staffManager;
	}
	public Staff(long staffId) {
		super();
		this.staffId = staffId;
	}
	public Staff() {
		super();
	}
	
	public Staff(Staff staffManager) {
		super();
		this.staffManager = staffManager;
	}
	public long getStaffId() {
		return staffId;
	}
	public void setStaffId(long staffId) {
		this.staffId = staffId;
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
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Staff getStaffManager() {
		return staffManager;
	}
	public void setStaffManager(Staff staffManager) {
		this.staffManager = staffManager;
	}
	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", email=" + email + ", staffManager=" + staffManager + "]";
	}
	
	

}
