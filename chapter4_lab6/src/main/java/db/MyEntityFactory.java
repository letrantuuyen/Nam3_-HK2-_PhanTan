package db;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MyEntityFactory {
	
	private static MyEntityFactory instance;
	
	private EntityManagerFactory emf;
	
	private MyEntityFactory() {
		emf = Persistence.createEntityManagerFactory("chapter4_lab6");
	
		}
	
	public static MyEntityFactory getInstance() {
		if(instance == null)
			instance = new MyEntityFactory();
		return instance;
	}
	
	public EntityManagerFactory getEmf() {
		return emf;
	}

}
