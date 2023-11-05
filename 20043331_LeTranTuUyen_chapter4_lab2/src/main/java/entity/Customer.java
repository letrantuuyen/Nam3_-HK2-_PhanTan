package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
// tao id tu lop cha 
@AttributeOverrides({@AttributeOverride(name ="id",column = @Column(name ="customer_id"))})
@Table(name ="customers")
public class Customer extends Person implements Serializable {
	
	@Embedded
	private Address address;
	
	// //1 cus co nhieu order
	
	@OneToMany(mappedBy = "customer")
	private Set<Order> orders;

	
	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public Customer() {
		// TODO Auto-generated constructor stub
	}

}
