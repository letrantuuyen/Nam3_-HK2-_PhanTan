package entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
/*
20043331
Lê Trần Tú Uyên
*/
@Entity
@Table(name ="orders")
public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="order_id")
	private int id;
	@Column(name ="order_status")
	private byte orderStatus;
	@Column(name ="order_date")
	private LocalDate orderDate;
	@Column(name ="required_date")
	private LocalDate requiredDate;
	@Column(name ="shipped_date")
	private LocalDate shippedDate;
	
	
	
	public Order( byte orderStatus, LocalDate orderDate, LocalDate requiredDate, LocalDate shippedDate) {

		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
	}



	@ManyToOne
	@JoinColumn(name ="customer_id")
	private Customer customer;
	
	@ManyToOne()
	@JoinColumn(name ="staff_id")
	private Staff staff;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public byte getOrderStatus() {
		return orderStatus;
	}



	public void setOrderStatus(byte orderStatus) {
		this.orderStatus = orderStatus;
	}



	public LocalDate getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}



	public LocalDate getRequiredDate() {
		return requiredDate;
	}



	public void setRequiredDate(LocalDate requiredDate) {
		this.requiredDate = requiredDate;
	}



	public LocalDate getShippedDate() {
		return shippedDate;
	}



	public void setShippedDate(LocalDate shippedDate) {
		this.shippedDate = shippedDate;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public Staff getStaff() {
		return staff;
	}



	public void setStaff(Staff staff) {
		this.staff = staff;
	}



	public Order() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Order [id=" + id + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + ", requiredDate="
				+ requiredDate + ", shippedDate=" + shippedDate + ", customer=" + customer + ", staff=" + staff + "]";
	}
	
	

}
