package Demo;

import dao.StockDao;
import entity.Address;
import entity.Brand;
import entity.Category;
import entity.Contact;
import entity.Product;
import entity.Stock;
import entity.Store;
/*
20043331
Lê Trần Tú Uyên
*/
public class StockTest {
	public static void main(String[] args) {
		
		StockDao stockDao = new StockDao();
		Brand brand  = new Brand(2);
		Category cate  = new Category(1) ;
		Product product = new Product(700, "iphone", 2023, 234233, brand, cate);
		Contact contact = new Contact("234234234", "abcxyz@gmail.com");
		Address address  = new Address("abc", "xyz", "mnp", "hhuh");
		Store store1 = new Store("kkk", contact, address);
		Stock stock = new Stock(product, store1, 1000);
		
		stockDao.addStock(stock);
	}

}
