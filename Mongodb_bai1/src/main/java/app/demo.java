package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

import Entity.Product;
import dao.ProductDAO;
import dao.ProductSubcription;

public class demo {

	public static void main(String[] args) {
		 
		
		
		ProductDAO productDao = new ProductDAO();
		
		Product p = new Product(2000, "dsd", "sdf", Arrays.asList("ble"), 2022, "wef", 50000);
		/*
		Product p1 = new Product(9000, "dsd", "sdf", Arrays.asList("ble"), 2022, "wef", 50000);
		Product p2 = new Product(8000, "dsd", "sdf", Arrays.asList("ble"), 2022, "wef", 50000);
		Product p3 = new Product(7000, "dsd", "sdf", Arrays.asList("ble"), 2022, "wef", 50000);
		List<Product> dsP = new ArrayList<Product>(); 
		dsP.add(p3);
		dsP.add(p2);
		dsP.add(p1);
		productDao.addDS(dsP);
		*/
		
		productDao.updateOneProduct(2l, "Tu Uyen");
		/*
		MongoClient client = MongoClients.create();
		ProductPOJODAO pojo = new ProductPOJODAO(client);
		Product pro = new Product(9000, "dsd", "sdf", Arrays.asList("ble"), 2022, "wef", 50000);
		System.out.println(pojo.addProductPOJO(pro));
		
	*/
		productDao.deleteOne(p);
	}

	
	
	
	
}
