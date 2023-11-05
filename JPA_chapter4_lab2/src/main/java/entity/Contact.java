package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
/*
20043331
Lê Trần Tú Uyên
*/
@Embeddable
public class Contact implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(columnDefinition  ="nvarchar(25)")
	private String phone;
	private String email;
	
	
	
	public String getPhone() {
		return phone;
	}



	public Contact(String phone, String email) {
		this.phone = phone;
		this.email = email;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Contact() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Contact [phone=" + phone + ", email=" + email + "]";
	}
	

}
