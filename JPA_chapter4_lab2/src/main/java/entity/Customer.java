package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.PrimaryKeyJoinColumns;
import jakarta.persistence.Table;
/*
20043331
Lê Trần Tú Uyên
*/
@Entity
//@PrimaryKeyJoinColumn(name ="ids")
@Table(name ="customers")
@AttributeOverrides({@AttributeOverride(name ="id",column = @Column(name ="customer_id"))})
public class Customer extends Person implements Serializable {
//	@PrimaryKeyJoinColumns({@PrimaryKeyJoinColumn(name ="id", referencedColumnName = "customer_id")})
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Embedded
	private Address address;
	
	@OneToMany(mappedBy = "customer")
	private Set<Order> order;
	
	public Customer(String firstName, String lastName, Contact contact, Address address, Set<Order> order) {
		super(firstName, lastName, contact);
		this.address = address;
		this.order = order;
	}



	public Customer(String firstName, String lastName, Contact contact, Address address) {
		super(firstName, lastName, contact);
		this.address = address;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public Set<Order> getOrder() {
		return order;
	}



	public void setOrder(Set<Order> order) {
		this.order = order;
	}



	public Customer() {
		// TODO Auto-generated constructor stub
	}








	
	

}
