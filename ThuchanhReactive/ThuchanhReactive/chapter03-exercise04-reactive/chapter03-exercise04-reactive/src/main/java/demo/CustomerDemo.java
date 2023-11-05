package demo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.CustomerDao;
import entity.Address;
import entity.Customer;
import entity.Phone;

/*
 * Le Tran Tu Uyen
 * 20043331
 */

public class CustomerDemo {

	public static void main(String[] args) {
		CustomerDao cusDao = new CustomerDao();
		Address ad = new Address("NVB", "TPHCM", "P4", 20);
		Date date = new Date(2002, 10, 9);
		List<Phone> phones  = new ArrayList<Phone>();
		Phone p = new Phone("126456432", "vina");
		Phone p1 = new Phone("12645432", "vina");
		
		Customer customer = new Customer("0123", "Tu", "Uyen", "lttu.hhtt@gmail.com", ad, date, phones);
	}
}
