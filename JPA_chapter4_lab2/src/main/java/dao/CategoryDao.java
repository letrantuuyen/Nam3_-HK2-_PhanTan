package dao;

import java.util.List;

import db.Connection;
import entity.Brand;
import entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
/*
20043331
Lê Trần Tú Uyên
*/
public class CategoryDao {
	private EntityManager em;
	
	public CategoryDao() {
		em = Connection.getInstance().getEmf().createEntityManager();
	}



	public boolean addCategory(Category category) {
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			em.persist(category);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
	}
		return false;
}
	public boolean deleteCategory(int id) {
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			em.remove(em.find(Category.class, id));
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	public boolean updateCategory(Category category) {
		 EntityTransaction tr =em.getTransaction();
		 tr.begin();
		 try {
			 em.merge(category);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return false;
	}
	public Category getCategory(int id) {
		return em.find(Category.class, id);
	}
	public void getAll() {
	//	em.createQuery("SELECT c FROM Category c ", Category.class).getResultList();
		System.out.println(em.createQuery("SELECT c FROM Category c ").getResultList());
	}

}
