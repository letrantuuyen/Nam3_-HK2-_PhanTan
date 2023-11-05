package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Brand;
import entity.Category;
import factory.MySessionFactory;

public class CategoryDao {
private SessionFactory sessionFactory;
	
	public CategoryDao() {
		sessionFactory = MySessionFactory.getInstance().getSessionFactory();
	}
	
	public boolean add(Category categories) {
		
		Transaction tr = null;;
		try(
				Session session = sessionFactory.openSession();
				){
			tr  = session.beginTransaction();			
			session.persist(categories);
			tr.commit();
			
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return false;
		
	}
public Category getCat(int id) {
		
		Transaction tr = null;;
		try(
				Session session = sessionFactory.openSession();
				){
			tr  = session.beginTransaction();
			Category cate  = session.find(Category.class, id);
			tr.commit();
			
			return cate;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return null;
		
	}
public List<Category> getAll() {
	
	Transaction tr = null;;
	try(
			Session session = sessionFactory.openSession();
			){
		tr  = session.beginTransaction();
		String sql = "select * from Categories";
		List<Category> list = session.createNativeQuery(sql, Category.class).getResultList();
		tr.commit();
		
		return list;
	}catch (Exception e) {
		e.printStackTrace();
		tr.rollback();
	}
	
	return null;
	
}

	

}
