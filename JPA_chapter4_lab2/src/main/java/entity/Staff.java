package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.PrimaryKeyJoinColumns;
import jakarta.persistence.Table;
/*
20043331
Lê Trần Tú Uyên
*/
@Entity
//@PrimaryKeyJoinColumn(name ="id")
@AttributeOverrides({@AttributeOverride(name ="id",column = @Column(name="staff_id"))})
@Table(name ="staffs")
public class Staff extends Person implements Serializable {
//	@PrimaryKeyJoinColumns({@PrimaryKeyJoinColumn(name ="id", referencedColumnName   ="staff_id")})
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private byte active;
	
	@OneToMany(mappedBy = "staff",fetch = FetchType.LAZY)
	private Set<Order> orders;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="store_id")
	private Store store;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="manager_id")
	private Staff manager;
	
	
	
	
	public byte getActive() {
		return active;
	}



	public void setActive(byte active) {
		this.active = active;
	}



	public Set<Order> getOrders() {
		return orders;
	}



	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}



	public Store getStore() {
		return store;
	}



	public void setStore(Store store) {
		this.store = store;
	}



	public Staff getManager() {
		return manager;
	}



	public void setManager(Staff manager) {
		this.manager = manager;
	}



	public Staff() {
		// TODO Auto-generated constructor stub
	}



	public Staff(String firstName, String lastName, Contact contact, byte active, Set<Order> orders, Store store,
			Staff manager) {
		super(firstName, lastName, contact);
		this.active = active;
		this.orders = orders;
		this.store = store;
		this.manager = manager;
	}



	@Override
	public String toString() {
		return "Staff [active=" + active + ", orders=" + orders + ", store=" + store + ", manager=" + manager + "]";
	}
	

}
