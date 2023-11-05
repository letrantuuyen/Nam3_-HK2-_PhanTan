package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 335002113623795521L;
	private String street;
	private String city;
	private String ward;
	private String district;
	
	public Address() {
	}

	public Address(String street, String city, String ward, String district) {
		super();
		this.street = street;
		this.city = city;
		this.ward = ward;
		this.district = district;
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

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", ward=" + ward + ", district=" + district + "]";
	}
	
	
}
