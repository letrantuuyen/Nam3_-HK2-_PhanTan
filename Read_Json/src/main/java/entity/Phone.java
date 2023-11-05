package entity;

import java.util.ArrayList;
import java.util.List;

public class Phone {
	List<String> phones = new ArrayList<String>();
	public Phone(List<String> phones) {
		super();
	
		this.phones = phones;
	}
	
	public List<String> getPhones() {
		return phones;
	}
	public void setPhones(List<String> phones) {
		this.phones = phones;
	}
	public Phone() {
		super();
	}
	@Override
	public String toString() {
		return "Phone [ phones=" + phones + "]";
	}

	
	

}
