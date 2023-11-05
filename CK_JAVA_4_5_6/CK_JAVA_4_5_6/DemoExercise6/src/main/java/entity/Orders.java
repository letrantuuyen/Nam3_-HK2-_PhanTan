package entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "Orders")
public class Orders implements Serializable{
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int orderID;
	private Date orderDate;
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "Orders [orderID=" + orderID + ", orderDate=" + orderDate + "]";
	}
	public Orders(int orderID, Date orderDate) {
		super();
		this.orderID = orderID;
		this.orderDate = orderDate;
	}
	public Orders(Date orderDate) {
		super();
		this.orderDate = orderDate;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
