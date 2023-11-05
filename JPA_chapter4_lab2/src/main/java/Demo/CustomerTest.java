package Demo;

import dao.CustomerDao;
import entity.Address;
import entity.Contact;
import entity.Customer;
/*
20043331
Lê Trần Tú Uyên
*/
public class CustomerTest {
	public static void main(String[] args) {
		
		Contact contact = new Contact("03423424", "lttu.hhtt@gmail.com");
		Address address  = new Address("abc", "xyz", "qwe", "poi");
		Customer customer  = new Customer("Le", "Uyen", contact, address);
		Customer customer1  = new Customer("Le", "Tien", contact, address);
		Customer customer2  = new Customer("Le", "Hong", contact, address);
		CustomerDao customerDao = new CustomerDao();
		customerDao.addCus(customer);
		customerDao.addCus(customer2);
		customerDao.addCus(customer1);
		
		customerDao.deleteCus(2);
		
		customer.setFirstName("hihi");
		customerDao.updateCus(customer);
		
		customerDao.getAll().forEach(cus->System.out.println(cus));
		customer = customerDao.getCus(1);
		System.out.println(customer);
	}

}
