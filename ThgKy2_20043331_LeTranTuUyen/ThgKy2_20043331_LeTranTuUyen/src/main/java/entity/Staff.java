package entity;


public class Staff {
    private long staffID;
    private String firstName;
    private String lastName;
    private Phone phone;
    private String email;
    
    private Staff staffManager;

    public Staff() {
    }

	public Staff(long staffID, String firstName, String lastName, Phone phone, String email, Staff staffManager) {
		super();
		this.staffID = staffID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.staffManager = staffManager;
	}

	public long getStaffID() {
		return staffID;
	}

	public void setStaffID(long staffID) {
		this.staffID = staffID;
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
		return "Staff [staffID=" + staffID + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", email=" + email + ", staffManager=" + staffManager + "]";
	}
    
    
  
    
}
