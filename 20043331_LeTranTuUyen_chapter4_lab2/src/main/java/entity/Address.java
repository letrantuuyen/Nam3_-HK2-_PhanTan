package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String street;
	@Column(columnDefinition = "nvarchar(50)")
	private String city;
	@Column(columnDefinition = "nvarchar(10)")
	private String state;
	@Column(name ="zip_code",columnDefinition = "nvarchar(5)")
	private int zipCode;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	

}
