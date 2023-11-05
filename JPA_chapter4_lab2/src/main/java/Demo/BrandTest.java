package Demo;

import dao.BrandDao;
import entity.Brand;
/*
20043331
Lê Trần Tú Uyên
*/
public class BrandTest {
	public static void main(String[] args) {
		BrandDao brandDao = new BrandDao();
		Brand brand = new Brand("Levents");
		Brand brand1 = new Brand("asdf");
		Brand brand2 = new Brand("yrewt");
		
		brandDao.addBrand(brand);
		brandDao.addBrand(brand1);
		brandDao.addBrand(brand2);
		
		brand2.setName("out");
		
		brandDao.updateBrand(brand2);
		
		brandDao.deleteBrand(2);
		System.out.println( brandDao.getBrand(1));
		
		brandDao.getAll().forEach(br->System.out.println(br));
		
		
		
	}

}
