package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="order_items")
public class OrderProduct {

	@Id
	@ManyToOne
	@JoinColumn(name ="order_id")
	private Order order;
	@Id
	@ManyToOne
	@JoinColumn(name ="product_id")
	private Product product;
	
	private int quantity;
	@Column(name ="list_price")
	private double listPrice;
	private double discount;
	
	
	
	public OrderProduct() {
		// TODO Auto-generated constructor stub
	}
	
}
