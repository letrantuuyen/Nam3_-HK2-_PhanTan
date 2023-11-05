package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userID;
	private String userEmail;
	private String userName;
	private String userPassword;
	@ElementCollection
	@CollectionTable(name="Users_ResearchAreas", joinColumns = @JoinColumn(name = "userID"))
	private Set<String> researchAreas;
	@Embedded
	private Address address;
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Set<String> getResearchAreas() {
		return researchAreas;
	}
	public void setResearchAreas(Set<String> researchAreas) {
		this.researchAreas = researchAreas;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userEmail=" + userEmail + ", userName=" + userName + ", userPassword="
				+ userPassword + ", address=" + address + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(long userID, String userEmail, String userName, String userPassword, Set<String> researchAreas,
			Address address) {
		super();
		this.userID = userID;
		this.userEmail = userEmail;
		this.userName = userName;
		this.userPassword = userPassword;
		this.researchAreas = researchAreas;
		this.address = address;
	}
	public User(String userEmail, String userName, String userPassword, Set<String> researchAreas, Address address) {
		super();
		this.userEmail = userEmail;
		this.userName = userName;
		this.userPassword = userPassword;
		this.researchAreas = researchAreas;
		this.address = address;
	}
	
}
