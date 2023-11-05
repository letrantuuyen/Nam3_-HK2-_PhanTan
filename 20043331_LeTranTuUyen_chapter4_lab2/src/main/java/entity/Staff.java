 package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name ="staffs")
//@PrimaryKeyJoinColumn(name="staff_id")
//@AttributeOverrides(value = { @AttributeOverride(name = "id", column = "id") })
@AttributeOverrides({@AttributeOverride(name ="id",column = @Column(name ="staff_id"))})

public class Staff extends Person implements Serializable {

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_id")
	private Staff manager;
	
	// 1 staff co nhieu order
	
	@OneToMany(mappedBy = "staff")
	private Set<Order> orders;
	
	// nhieu staff quan li 1 store
	
	@ManyToOne
	@JoinColumn(name ="store_id")
	private Store store_id;
	
	@Column(columnDefinition = "tinyint")
	private byte active;
	/*
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_id")
	private Staff manager;
	*/
	public Staff() {
		// TODO Auto-generated constructor stub
	}
	

}
