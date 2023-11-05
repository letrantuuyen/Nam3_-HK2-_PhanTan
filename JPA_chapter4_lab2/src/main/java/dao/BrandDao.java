package dao;

import java.util.List;

/*
20043331
Lê Trần Tú Uyên
*/
import db.Connection;
import entity.Brand;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class BrandDao {
	private EntityManager em;
	
	public BrandDao() {
		em = Connection.getInstance().getEmf().createEntityManager();
	}
	

	public BrandDao(EntityManager em) {
		super();
		this.em = em;
	}


	public boolean addBrand(Brand brand) {
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			em.persist(brand);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
	}
		return false;
}
	public boolean deleteBrand(int id) {
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			em.remove(em.find(Brand.class, id));
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	public boolean updateBrand(Brand brand) {
		 EntityTransaction tr =em.getTransaction();
		 tr.begin();
		 try {
			 em.merge(brand);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return false;
	}
	public Brand getBrand(int id) {
		return em.find(Brand.class, id);
	}
	public List<Brand> getAll() {
		return em.createQuery("from Brand ", Brand.class).getResultList();
	}
}
