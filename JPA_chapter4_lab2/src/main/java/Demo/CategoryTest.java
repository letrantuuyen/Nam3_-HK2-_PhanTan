package Demo;

import dao.CategoryDao;
import entity.Category;
/*
20043331
Lê Trần Tú Uyên
*/
public class CategoryTest {
	public static void main(String[] args) {
		
		CategoryDao categoryDao = new CategoryDao();
		Category category = new Category("oiterw");
		Category category1 = new Category("dfgd");
		Category category2 = new Category("dfg");
		
		categoryDao.addCategory(category);
		categoryDao.addCategory(category2);
		categoryDao.addCategory(category1);
		
		category2.setName("hehehe");
		
		categoryDao.updateCategory(category2);
		categoryDao.deleteCategory(1);
		
		categoryDao.getAll();
	}

}
