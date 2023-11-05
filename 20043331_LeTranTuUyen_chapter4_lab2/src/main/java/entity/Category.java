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
@Table(name ="categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="category_id")
	private int categoryId;
	@Column(name ="category_name",columnDefinition = "nvarchar(255)")
	private String categoryName;
	
	//1 cate nhieu product
	@OneToMany(mappedBy = "category")
	private Set<Product> products;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}
}
