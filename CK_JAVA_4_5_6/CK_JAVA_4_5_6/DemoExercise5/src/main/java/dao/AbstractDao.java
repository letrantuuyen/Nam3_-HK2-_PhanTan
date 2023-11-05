package dao;

import java.util.List;

import db.connection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public abstract class AbstractDao<T> {
	private Class<T> clazz;
	protected EntityManager em;
	private String name;
	public AbstractDao (Class<T> clazz) {
		this.clazz = clazz;
		this.em = new connection().getInstance().getEM();
		name = clazz.getName().replace("entity.", "");
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
	public List<T> getAll () {
		return em.createNativeQuery("select * from " + name, clazz).getResultList();
	}
}
