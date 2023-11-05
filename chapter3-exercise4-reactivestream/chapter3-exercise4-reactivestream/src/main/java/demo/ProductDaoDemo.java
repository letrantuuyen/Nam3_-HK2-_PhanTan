package demo;

import dao.ProductDao;
import entity.Product;

public class ProductDaoDemo {
	public static void main(String[] args) {
		
		ProductDao productDao = new ProductDao();
//		productDao.findByPrice(450, 500)
//		.forEach(p -> System.out.println(p));
		
		Product p = productDao.findById(345435);
		System.out.println(p);
		
	}
}
