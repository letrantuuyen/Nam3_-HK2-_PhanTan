package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Brand;
import factory.MySessionFactory;

public class BrandDao {
	private SessionFactory sessionFactory;
	
	public BrandDao() {
		sessionFactory = MySessionFactory.getInstance().getSessionFactory();
	}
	
	public boolean add(Brand brand) {
		
		Transaction tr = null;;
		try(
				Session session = sessionFactory.openSession();
				){
			tr  = session.beginTransaction();			
			session.persist(brand);
			tr.commit();
			
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return false;
		
	}
	public boolean update(Brand brand) {
		
		Transaction tr = null;;
		try(
				Session session = sessionFactory.openSession();
				){
			tr  = session.beginTransaction();
			session.merge(brand);
			tr.commit();
			
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return false;
		
	}
	public boolean delete(int id) {
		
		Transaction tr = null;;
		try(
				Session session = sessionFactory.openSession();
				){
			tr  = session.beginTransaction();
			session.remove(session.find(Brand.class, id));
			tr.commit();
			
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return false;
		
	}
	public Brand getBrand(int id) {
		
		Transaction tr = null;;
		try(
				Session session = sessionFactory.openSession();
				){
			tr  = session.beginTransaction();
			Brand brand = session.find(Brand.class, id);
			tr.commit();
			
			return brand;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return null;
		
	}
	public List<Brand> getAll() {
		
		Transaction tr = null;;
		try(
				Session session = sessionFactory.openSession();
				){
			tr  = session.beginTransaction();
			String sql = "select * from brands";
			List<Brand> list = session.createNativeQuery(sql, Brand.class).getResultList();
			tr.commit();
			
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return null;
		
	}
	public List<Brand> getAll2() {
		
		Transaction tr = null;;
		try(
				Session session = sessionFactory.openSession();
				){
			tr  = session.beginTransaction();
			List<Brand> list = session.createQuery("from Brand", Brand.class).getResultList();
			tr.commit();
			
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return null;
		
	}
}
