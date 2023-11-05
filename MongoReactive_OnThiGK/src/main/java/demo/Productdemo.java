package demo;

import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import entity.Product;

public class Productdemo {

	public static void main(String[] args) {
		List<String> color = new ArrayList<String>();
		color.add("black");
		color.add("white");
		Product product = new Product(10001l, "Tu", "Uyen", "Tu Uyen",color , 2012, 23423);
		Product product1 = new Product(1008l, "Tu", "Uyen", "Tu Uyen",color , 2012, 23423);
		ProductDao productDao = new ProductDao();
	//	System.out.println(	productDao.addP(product));
	//	productDao.addP(product);
	//	productDao.addP(product1);

		
	//	productDao.getProductByName("Tu Uyen")
	//	.forEach(p-> System.out.println(p));
	//	Product p = new Product(10);
		List<Long> ids = new ArrayList<Long>();
		ids.forEach(p->{
			System.out.println(p);
		});
		ids.add(1000l);
		ids.add(10001l);
		ids.add(10l);
		productDao.updateMany(ids, "huhu").forEach(p->{
			System.out.println(p);
		});
		//productDao.findProductByName("Tu Uyen").forEach(p->System.out.println(p));
	//	System.out.println(productDao.deleteOneProduct(1008l));
	}
}
