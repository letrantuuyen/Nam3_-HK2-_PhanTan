package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="stocks")
public class StoreProduct {
	
	
	@Id
	@ManyToOne
	@JoinColumn(name ="store_id")
	private Store store;
	
	@Id
	@ManyToOne
	@JoinColumn(name ="product_id")
	private Product product;
	
	private int quantity;
	
	public StoreProduct() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
