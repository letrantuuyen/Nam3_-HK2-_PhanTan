package Demo;

import dao.ProductDao;
import entity.Brand;
import entity.Category;
import entity.Product;
/*
20043331
Lê Trần Tú Uyên
*/
public class ProductTest {
	
	public static void main(String[] args) {
		
		ProductDao productDao = new ProductDao();
		Product product = productDao.getP(1);
		System.out.println(product);
		productDao.addProduct(product);
	}

}
