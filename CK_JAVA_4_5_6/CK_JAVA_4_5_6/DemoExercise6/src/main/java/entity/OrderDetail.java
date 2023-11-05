package entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrderDetail")
public class OrderDetail implements Serializable{
	
	private int quantity;
	@Id
	@ManyToOne
	@JoinColumn(name = "orderID")
	private Orders orders;
	@Id
	@ManyToOne
	@JoinColumn(name = "productID")
	private Product product;
	public int getQuantity() {
		return quantity;
	}
	public OrderDetail(int quantity, Orders orders, Product product) {
		super();
		this.quantity = quantity;
		this.orders = orders;
		this.product = product;
	}
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "OrderDetail [quantity=" + quantity + ", ordersID=" + orders.getOrderID() + ", productID=" + product.getProductID() + "]";
	}
	
	
}
