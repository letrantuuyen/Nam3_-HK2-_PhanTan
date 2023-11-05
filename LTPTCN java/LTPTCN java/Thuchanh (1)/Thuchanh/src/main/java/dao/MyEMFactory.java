package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyEMFactory {
	private static MyEMFactory instance; 
	
	private EntityManagerFactory entityManagerFactory;
	private MyEMFactory() {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("Thuchanh");
		
		
	}
	
	public synchronized static MyEMFactory getInstance() {
		if(instance == null)
			instance = new MyEMFactory();
			
		return instance;
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
}
