package entity;

public class phoneNumber {
	private String type;
	private String number;
	public phoneNumber(String type, String number) {
		super();
		this.type = type;
		this.number = number;
	}
	public phoneNumber() {
		super();
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "phoneNumber [type=" + type + ", number=" + number + "]";
	}
	

}
