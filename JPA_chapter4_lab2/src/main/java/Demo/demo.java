package Demo;

import db.Connection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
/*
20043331
Lê Trần Tú Uyên
*/
public class demo {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Connection.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		
		tr.begin();
		try {
			tr.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
	}

}
