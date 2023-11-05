package entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="stores")
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="store_id")
	private int storeId;
	
	
	@Column(name ="store_name",columnDefinition = "nvarchar(255)")
	private String storeName;
	
	//1 store nhieu stock
	
	@OneToMany(mappedBy = "store")
	private Set<StoreProduct> id;
	
	@Embedded
	private Address address;
	@Embedded
	private Contact contact;
	
	//1 store quan li boi nhieu staff
	@OneToMany(mappedBy = "store_id")
	private Set<Staff> store_id;
	
	public Store() {
		// TODO Auto-generated constructor stub
	}
	
	
}
