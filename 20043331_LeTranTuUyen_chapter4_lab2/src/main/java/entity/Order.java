package entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="order_id")
	private int orderId;
	@Column(name ="order_status")
	private byte orderStatus;
	@Column(name = "order_date")
	private LocalDate orderDate;
	@Column(name ="required_date")
	private LocalDate requiredDate;
	@Column(name ="shipped_date")
	private LocalDate shippedDate;
	
	// nhieu order co 1 cus
	
	@ManyToOne
	@JoinColumn(name ="customer_id")
	private Customer customer;
	
	// nhieu order quan li boi 1 staff
	@ManyToOne
	@JoinColumn(name ="staff_id")
	private Staff staff;
	public Order() {
		// TODO Auto-generated constructor stub
	}
	

}
