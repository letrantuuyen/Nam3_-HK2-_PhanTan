package demo;

import dao.BrandDao;
import entity.Brand;

public class BrandDaoTest {
	public static void main(String[] args) {
//		MySessionFactory.getInstance().getSessionFactory();
		
		
		BrandDao brandDao = new BrandDao();
		
//		brandDao.add(new Brand("asdsad"));
		
		Brand x = brandDao.getBrand(10);
	//	x.setName("New Bike");
		//brandDao.update(x);
		
	//	brandDao.getAll().forEach(b -> System.out.println(b));
		
		
	}
}
