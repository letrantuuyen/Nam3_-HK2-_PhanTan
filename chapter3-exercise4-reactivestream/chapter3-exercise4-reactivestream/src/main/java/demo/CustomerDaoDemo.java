package demo;

import dao.CustomerDao;
import entity.Customer;

public class CustomerDaoDemo {
	public static void main(String[] args) {
		CustomerDao customerDao = new CustomerDao();
//		Customer customer = customerDao.findById("CHAR5");
//		System.out.println(customer);
//		
		customerDao.getNumberCustomersByState()
		.entrySet()
		.forEach(entry -> {
			System.out.println("State: " + entry.getKey() + "\t Number of customers: " + entry.getValue());
		});
	}
}
