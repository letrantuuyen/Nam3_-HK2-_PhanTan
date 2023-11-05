package dao;

import db.connection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public abstract class AbstractDao<T> {
	private Class<T> clazz;
	private String name;
	protected EntityManager em;
	public AbstractDao (Class<T> clazz) {
		this.clazz = clazz;
		em = new connection().getInstance().getEM();
		
	}
	
	public boolean insert (T t) {
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			em.persist(t);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}
	public boolean update (T t) {
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			em.merge(t);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete (Object id) {
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			em.remove(getByID(id));
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}
	public T getByID (Object id) {
		return em.find(clazz, id);
	}
}
