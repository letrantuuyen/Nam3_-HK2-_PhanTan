package demo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import dao.OrderDao;

public class OrderDaoTest2 {
	public static void main(String[] args) throws IOException {
		
		PrintWriter out = new PrintWriter(new FileWriter("data/rs2.txt"), true);
		
		OrderDao orderDao = new OrderDao();
		
		orderDao.getOrdersByCustomersSortByFirstName()
		.entrySet()
		.forEach(entry -> {
//			System.out.println("Customer: " + entry.getKey());
//			System.out.println("Number of orders: " + entry.getValue());
//			System.out.println("==================");
			out.println("Customer: " + entry.getKey());
			out.println("Number of orders: " + entry.getValue());
			out.println("=================");
		});
		
		out.close();
		
	}
}
