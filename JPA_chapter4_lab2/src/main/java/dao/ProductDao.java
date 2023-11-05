package dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import db.Connection;
import entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
/*
20043331
Lê Trần Tú Uyên
*/
public class ProductDao {
	
	private EntityManager em;
	
	public ProductDao() {
		em = Connection.getInstance().getEmf().createEntityManager();
	}
	
	public boolean addProduct(Product p) {
		
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			em.persist(p);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return false;
	}

	public boolean deleteP(int id) {
		
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			em.remove(em.find(Product.class, id));
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return false;
	}
	public boolean updateP(Product product) {
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			em.merge(product);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	public List<Product> getAll(){
		return em.createQuery("Select p from Product p", Product.class).getResultList();
	}
	
	
	public  Product getP(int id) {
		return em.find(Product.class,id);
	}
	//hashmap : khong sort
	//LinkedHashMap : sort
	public Map<Product, Integer> getTotalProduct(){
		String sql ="\r\n"
				+ "select product_id , total = sum(quantity)\r\n"
				+ "from order_items\r\n"
				+ "group by product_id";
		List<?> list  = em.createNativeQuery(sql).getResultList();
		for(Object obj : list) {
			//moi phan tu trong sql la mang 1 chieu
			Object[] o = (Object[]) obj;
			System.out.println(o[0].toString());
			System.out.println(o[1].toString());
		}
		return null;
	}
}
