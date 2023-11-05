package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
/*
20043331
Lê Trần Tú Uyên
*/
@Entity
@Table(name ="categories")
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="category_id")
	private int id;
	@Column(name ="category_name", columnDefinition = "nvarchar(255)")
	private String name;
	
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private Set<Product> products;
	
	
	





	public Category(int id, String name) {
		this.id = id;
		this.name = name;
	}




	public Category(String name) {
		super();
		this.name = name;
	}

	


	public Category(int id) {
		this.id = id;
	}




	public int getId() {
		return id;
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



	public Set<Product> getProducts() {
		return products;
	}



	public void setProducts(Set<Product> products) {
		this.products = products;
	}



	public Category() {
		// TODO Auto-generated constructor stub
	}




	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
}
