package entity;

import java.util.List;

public class Address {
	private int building;
	List<Float> coord;
	private String street;
	private int zipcode;
	public Address(int building, List<Float> coord, String street, int zipcode) {
		super();
		this.building = building;
		this.coord = coord;
		this.street = street;
		this.zipcode = zipcode;
	}
	public Address() {
		super();
	}
	public int getBuilding() {
		return building;
	}
	public void setBuilding(int building) {
		this.building = building;
	}
	public List<Float> getCoord() {
		return coord;
	}
	public void setCoord(List<Float> coord) {
		this.coord = coord;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "Address [building=" + building + ", coord=" + coord + ", street=" + street + ", zipcode=" + zipcode
				+ "]";
	}
	

}
