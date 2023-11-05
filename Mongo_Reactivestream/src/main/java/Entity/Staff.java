package Entity;

public class Staff {
	private int id;
	private String firstName;
	private String lastName;
	private Phone phone;
	private Staff managerID;
	private String email;
	public Staff(int id, String firstName, String lastName, Phone phone, Staff managerID, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.managerID = managerID;
		this.email = email;
	}
	public Staff() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Staff getManagerID() {
		return managerID;
	}
	public void setManagerID(Staff managerID) {
		this.managerID = managerID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Staff [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", managerID=" + managerID + ", email=" + email + "]";
	}
	
	
	

}
