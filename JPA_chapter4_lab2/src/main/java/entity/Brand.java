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
@Table(name ="brands")
public class Brand implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="brand_id")
	private int id;
	@Column(name ="brand_name", columnDefinition = "nvarchar(255)")
	private String name;
	
	@OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
	private Set<Product> products;
	
	
	
	public Brand(int id, String name) {
		this.id = id;
		this.name = name;
	
	}


	public Brand(int id) {
		super();
		this.id = id;
	}


	public Brand( String name) {
		super();
		this.name = name;
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

	public Brand() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + "]";
	}

	
}
