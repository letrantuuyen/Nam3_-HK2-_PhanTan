package entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
/*
20043331
Lê Trần Tú Uyên
*/
@Entity
@Table(name ="order_items")
public class OrderItem implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="product_id")
	private Product product;
	@Id
	@ManyToOne
	@JoinColumn(name ="order_id")
	private Order order;
	
	private int quantity;
	@Column(name ="list_price")
	private double listPrice;
	private double discount;
	
	public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}

	@Override
	public String toString() {
		return "OrderItem [product=" + product + ", order=" + order + ", quantity=" + quantity + ", listPrice="
				+ listPrice + ", discount=" + discount + "]";
	}
	
	

}
