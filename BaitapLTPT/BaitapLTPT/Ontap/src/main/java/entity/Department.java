package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;

@Entity
@Table(name="Departments")
public class Department implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2784389372596611253L;
	@Id
	private String id;
	private String name;
	
	@Embedded
	private Address address;
	
	@ElementCollection
	@JoinTable(name = "Phones", joinColumns = @JoinColumn(name="departmentId"))
	@Column(name="phone", nullable = false)
	private Set<String> contactNumbers;
	
	public Department() {
	}
	
	

	public Department(String id) {
		super();
		this.id = id;
	}



	public Department(String id, String name, Address address, Set<String> contactNumbers) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contactNumbers = contactNumbers;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<String> getContactNumbers() {
		return contactNumbers;
	}

	public void setContactNumbers(Set<String> contactNumbers) {
		this.contactNumbers = contactNumbers;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", address=" + address + ", contactNumbers=" + contactNumbers
				+ "]";
	}
	
	
	
}
