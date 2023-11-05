package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@Column(name ="product_id")
	private int productId;
	
	private String name;
	private int modelYear;
	private double listPrice;
	
	@ManyToOne
	@JoinColumn(name ="id")
	private Brand brand;
		
	public Product() {
			// TODO Auto-generated constructor stub
		}
}
