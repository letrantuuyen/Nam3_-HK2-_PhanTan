package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyEMFactory {
	
	private static MyEMFactory instance;
	
	private EntityManagerFactory factory;
	
	private  MyEMFactory() {
		factory = Persistence.createEntityManagerFactory("PatientOGM");
	}
	
	public synchronized static MyEMFactory getInstance() {
		if(instance == null)
			instance = new MyEMFactory();
		return instance;
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return factory;
	}
}
