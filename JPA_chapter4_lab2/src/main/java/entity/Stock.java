package entity;

import java.io.Serializable;
import java.util.Objects;

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
@Table(name ="stocks")
public class Stock implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="product_id")
	private Product product;
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="store_id")
	private Store store;
	
	private int quantity;
	
	
	public Stock() {
		// TODO Auto-generated constructor stub
	}

	
	public Product getProduct() {
		return product;
	}
	
	


	public Stock(Product product, Store store, int quantity) {
		this.product = product;
		this.store = store;
		this.quantity = quantity;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Store getStore() {
		return store;
	}


	public void setStore(Store store) {
		this.store = store;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	@Override
	public int hashCode() {
		return Objects.hash(product, store);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		return Objects.equals(product, other.product) && Objects.equals(store, other.store);
	}


	@Override
	public String toString() {
		return "Stock [product=" + product + ", store=" + store + ", quantity=" + quantity + "]";
	}
	

}
