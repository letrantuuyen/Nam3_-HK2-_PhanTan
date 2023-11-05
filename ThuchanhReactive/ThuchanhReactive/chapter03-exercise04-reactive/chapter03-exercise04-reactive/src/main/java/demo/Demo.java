package demo;

import java.util.List;

import dao.ProductDao;
import entity.Product;

public class Demo {
	public static void main(String[] args) {
		
		ProductDao productDao = new ProductDao();
	//	Product pr = new Product(432342l, "asd", "sdf", List.of("red"), 2000, "bike aaa", 156.0);
	//	boolean rs = productDao.addProduct(pr);
//		System.out.println(rs);
		
		productDao.getProductsByName("bike")
		.forEach(p->System.out.println(p));
		
	}
}
