package entity;

public class Address {
	private String steetAddress;
	private String city;
	private String state;
	private int postalCode;
	public Address(String steetAddress, String city, String state, int postalCode) {
		super();
		this.steetAddress = steetAddress;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
	}
	public Address() {
		super();
	}
	public String getSteetAddress() {
		return steetAddress;
	}
	public void setSteetAddress(String steetAddress) {
		this.steetAddress = steetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	@Override
	public String toString() {
		return "Address [steetAddress=" + steetAddress + ", city=" + city + ", state=" + state + ", postalCode="
				+ postalCode + "]";
	}
	
	

}
