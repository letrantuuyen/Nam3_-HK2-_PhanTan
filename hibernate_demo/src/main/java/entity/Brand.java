package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Brand {
	@Id
	private int id;
	@Column(columnDefinition = "nvarchar(255)")
	private String name;
	public Brand(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Brand() {
		super();
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
	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + "]";
	}
	
	

}
