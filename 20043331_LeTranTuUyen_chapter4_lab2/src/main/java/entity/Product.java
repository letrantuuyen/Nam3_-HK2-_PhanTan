package entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="products")
public class Product {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="product_id")
	private int productId;
	
	@Column(name ="product_name",columnDefinition = "nvarchar(255)")
	private String productName;
	@Column(name ="model_year", columnDefinition = "smallint")
	private int modelYear;
	@Column(name ="list_price")
	private double listPrice;
	
	
	@ManyToOne
	// ten thuoc tinh duoc join tu bang 1
	@JoinColumn(name ="brand_id")
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name ="category_id")
	private Category category;
	 
	//1 product nhieu stock
	@OneToMany(mappedBy = "product")
	private Set<StoreProduct> storeproductId;
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	

}
