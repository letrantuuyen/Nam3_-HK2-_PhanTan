package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
/*
20043331
Lê Trần Tú Uyên
*/
@Entity
@Table(name ="stores")
public class Store implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="store_id")
	private int id;
	@Column(name ="store_name",columnDefinition = "nvarchar(255)")
	private String name;
	
	@OneToMany(mappedBy = "store",fetch = FetchType.LAZY)
	private Set<Staff> staffs;
	
	@Embedded
	private Contact contact;
	
	@Embedded
	private Address address;
	
	
	
	public Store(String name, Contact contact, Address address) {
		this.name = name;
		this.contact = contact;
		this.address = address;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Set<Staff> getStaffs() {
		return staffs;
	}



	public void setStaffs(Set<Staff> staffs) {
		this.staffs = staffs;
	}



	public Contact getContact() {
		return contact;
	}



	public void setContact(Contact contact) {
		this.contact = contact;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public Store() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", staffs=" + staffs + ", contact=" + contact + ", address="
				+ address + "]";
	}
	

}
