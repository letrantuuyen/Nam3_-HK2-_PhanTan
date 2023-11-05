package demo;
import java.util.List;

import dao.productDao;

public class ProductDemo {
	public static void main(String[] args) {
		productDao pr = new productDao();
		
		pr.getProductsByName("bike")
		.forEach(p->System.out.println(p));
	}

}
