package rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import entity.OrderDetail;
import entity.Orders;
import entity.Product;
import rmi.service.RemoteInterface;

public class Client {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		RemoteInterface ri = (RemoteInterface) Naming.lookup("rmi://LAPTOP-5ABCG2KH:1111/ri");

		// insert
		Orders o = ri.getByIDOrder(4);
		Product p = ri.getByIDProduct("NA3");
		OrderDetail od = new OrderDetail(1000, o, p);
		System.out.println(ri.insertOrderDetail(od));

		// getByID
		OrderDetail od1 = ri.getByIDOrderDetail("NA3", 4);
		System.out.println(od1);

		// update
		od1.setQuantity(300);
		System.out.println(ri.updateOrderDetail(od1));

		// delete
		System.out.println(ri.deleteOrderDetail("NA3", 4));
		
		//getNotSale 
		List<Product> l = ri.getProductNotSales();
		l.forEach(i -> System.out.println(i));
		
		//getQuanTityOfProductByDate
		Map<Product, Integer> map = ri.getQuanTityOfProductByDate(4, 2023);
		map.entrySet().iterator().forEachRemaining(en -> {
			System.out.println(en.getKey().getProductID() + " : " + en.getValue());
		});
	}
}
