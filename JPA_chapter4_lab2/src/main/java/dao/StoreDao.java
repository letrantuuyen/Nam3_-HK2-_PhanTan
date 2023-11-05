package dao;

import java.util.List;

import db.Connection;
import entity.Product;
import entity.Store;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
/*
20043331
Lê Trần Tú Uyên
*/
public class StoreDao {
	
	private EntityManager em ;
	
	public StoreDao() {
		em = Connection.getInstance().getEmf().createEntityManager();
	}
	
	public boolean addStore(Store store) {
		
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			em.persist(store);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return false;
	}
	
	public boolean deleteStore(int id) {
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			em.remove(em.find(Store.class, id));
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		
		return false;
	}
	
	public boolean updateStore(Store store) {
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			em.merge(store);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			}
		
		
		return false;
	}
	
	public List<Store> getAll(){
		return em.createQuery("Select s from Store s", Store.class).getResultList();
	}

}
