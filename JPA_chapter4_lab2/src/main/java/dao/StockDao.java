package dao;

import db.Connection;
import entity.Stock;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
/*
20043331
Lê Trần Tú Uyên
*/
public class StockDao {
	private EntityManager em;
	
	public StockDao() {
		em = Connection.getInstance().getEmf().createEntityManager();
	}
	
	public boolean addStock(Stock stock) {
		
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			em.persist(stock);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return false;
	}

}
