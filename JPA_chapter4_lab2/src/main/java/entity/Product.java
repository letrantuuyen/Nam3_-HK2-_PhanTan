package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
/*
20043331
Lê Trần Tú Uyên
*/
@Entity
@Table(name ="products")
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="product_id")
	private int id;
	@Column(name ="product_name",columnDefinition = "nvarchar(255)")
	private String name;
	@Column(name ="model_year",columnDefinition = "smallint")
	private int modelYear;
	@Column(name ="list_price")
	private double listPrice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="brand_id")
	private Brand brand;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="category_id")
	private Category category;
	/*
	@OneToMany(mappedBy = "product_id")
	private Set<Stock> stocks;
	*/
	
	
	public int getId() {
		return id;
	}



	public Product(String name, int modelYear, double listPrice) {
		this.name = name;
		this.modelYear = modelYear;
		this.listPrice = listPrice;
	}



	public Product(int id, String name, int modelYear, double listPrice, Brand brand, Category category) {
		this.id = id;
		this.name = name;
		this.modelYear = modelYear;
		this.listPrice = listPrice;
		this.brand = brand;
		this.category = category;
	}



	public Product(String name, int modelYear, double listPrice, Brand brand, Category category) {
		this.name = name;
		this.modelYear = modelYear;
		this.listPrice = listPrice;
		this.brand = brand;
		this.category = category;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getModelYear() {
		return modelYear;
	}



	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}



	public double getListPrice() {
		return listPrice;
	}



	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}



	public Brand getBrand() {
		return brand;
	}



	public void setBrand(Brand brand) {
		this.brand = brand;
	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}




	public Product() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", modelYear=" + modelYear + ", listPrice=" + listPrice
				+ ", brand=" + brand.getId() + ", category=" + category.getId() + "]";
	}

	
}
