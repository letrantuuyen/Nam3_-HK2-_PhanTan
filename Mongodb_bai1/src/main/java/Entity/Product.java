package Entity;

import java.util.List;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import com.google.gson.annotations.SerializedName;

public class Product {
	
	@SerializedName("_id")
	@BsonId
	private long id;
	@BsonProperty("brand_name")
	private String brandName;
	@BsonProperty("category_name")
	private String categoryName;
	@BsonProperty("colors")
	private List<String> color;
	@BsonProperty("model_year")
	private int modelYear;
	@BsonProperty("product_name")
	private String productName;
	@BsonProperty("price")
	private double price;
	public Product(long id, String brandName, String categoryName, List<String> color, int modelYear, String productName,
			double price) {
		super();
		this.id = id;
		this.brandName = brandName;
		this.categoryName = categoryName;
		this.color = color;
		this.modelYear = modelYear;
		this.productName = productName;
		this.price = price;
	}
	public Product() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<String> getColor() {
		return color;
	}
	public void setColor(List<String> color) {
		this.color = color;
	}
	public int getModelYear() {
		return modelYear;
	}
	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", brandName=" + brandName + ", categoryName=" + categoryName + ", color=" + color
				+ ", modelYear=" + modelYear + ", productName=" + productName + ", price=" + price + "]";
	}
	
	

	
}
