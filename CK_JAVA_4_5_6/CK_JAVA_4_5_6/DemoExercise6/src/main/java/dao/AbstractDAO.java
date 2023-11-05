package dao;

import db.connection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public abstract class AbstractDAO<T> {
	private Class<T> clazz;
	protected EntityManager em;
	public AbstractDAO (Class<T> clazz) {
		em = new connection().getInstance().getEM();
		this.clazz = clazz;
	}
	public boolean insert (T t) {
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			em.persist(t);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
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
			e.printStackTrace();
			tr.rollback();
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
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	public T getByID (Object id) {
		return em.find(clazz, id);
	}

}
