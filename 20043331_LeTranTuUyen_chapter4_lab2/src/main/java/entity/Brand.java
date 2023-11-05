package entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="brands")
public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="brand_id")
	private int brandId;
	@Column(name ="brand_name", columnDefinition = "nvarchar(255)")
	private String brandName;
	
	
	@OneToMany(mappedBy = "brand")
	private Set<Product> product;
	
	public Brand() {
		// TODO Auto-generated constructor stub
	}

}
