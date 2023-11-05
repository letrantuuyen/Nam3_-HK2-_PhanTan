package dao;

import java.util.List;

import db.Connection;
import entity.Brand;
import entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
/*
20043331
Lê Trần Tú Uyên
*/
public class CustomerDao {
	
	private EntityManager em;
	
	public CustomerDao() {
		em = Connection.getInstance().getEmf().createEntityManager();
	}


	public boolean addCus(Customer cus) {
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			em.persist(cus);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
	}
		return false;
}
	public boolean deleteCus(int id) {
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			em.remove(em.find(Customer.class, id));
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	public boolean updateCus(Customer cus) {
		 EntityTransaction tr =em.getTransaction();
		 tr.begin();
		 try {
			 em.merge(cus);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return false;
	}
	public Customer getCus(int id) {
		return em.find(Customer.class, id);
	}
	public List<Customer> getAll() {
		return em.createQuery("from Customer ", Customer.class).getResultList();
	}

}
