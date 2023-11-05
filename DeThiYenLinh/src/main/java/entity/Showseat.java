package entity;

public class Showseat {

	private String id;
	private String type;
	private double price;
	private boolean isAvailable;
	public Showseat(String id, String type, double price, boolean isAvailable) {
		super();
		this.id = id;
		this.type = type;
		this.price = price;
		this.isAvailable = isAvailable;
	}
	public Showseat() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	@Override
	public String toString() {
		return "Showseat [id=" + id + ", type=" + type + ", price=" + price + ", isAvailable=" + isAvailable + "]";
	}
	
}
