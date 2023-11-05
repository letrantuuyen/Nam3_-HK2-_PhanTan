package demo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.text.DateFormatter;

import Entity.Address;
import Entity.Customer;
import Entity.Phone;
import dao.CustomerDao;

public class CustomerDemo {
	public static void main(String[] args) {
		List<Phone> phones = new ArrayList<Phone>();
		Phone phone = new Phone("345345345", "3452452");
		phones.add(phone);
		Date date = new Date(2002, 10, 9);
		Address ad = new Address("TPHCM", "P4", "NVB", "12 NVB");
		Customer cus1 = new Customer("TU123", "Tu", "Uyen", "lttu.hhtt", ad, date, phones);
		Customer cus2 = new Customer("TU123543", "Tu", "Uyen", "lttu.hhtt", ad, date, phones);
		Customer cus4 = new Customer("TU1233564", "Tu", "Uyen", "lttu.hhtt", ad, date, phones);
		CustomerDao daoCus = new CustomerDao();
		List<Customer> cusList = new ArrayList<Customer>();
		cusList.add(cus1);
		cusList.add(cus2);
		cusList.add(cus4);
	//	daoCus.addCus(cus1);
	//	daoCus.addListCus(cusList);
	//\	System.out.println(daoCus.findById("9"));
		//daoCus.updateOne(11, "Le");
	//	System.out.println(daoCus.updateMany(cusList, "Van"));
	//	daoCus.deleteOne(9);
		
	daoCus.getCustomerByName("Tu").
	forEach(c->System.out.println(c));
		
	
		
	}

}
