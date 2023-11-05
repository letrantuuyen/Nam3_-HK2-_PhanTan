package factory;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MyEntityManagerFactory {
	private static MyEntityManagerFactory instance = null;
	
	private EntityManagerFactory emf;
	
	private MyEntityManagerFactory() {
		emf = Persistence.createEntityManagerFactory("Ontap");
	}
	
	public static MyEntityManagerFactory getInstance() {
		if(instance == null)
			instance = new MyEntityManagerFactory();
		return instance;
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
	
}
