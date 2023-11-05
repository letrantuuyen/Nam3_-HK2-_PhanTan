package Connection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyEMFactory {
	private static MyEMFactory instance;
	private EntityManagerFactory entityManagerFactory;
	private MyEMFactory() {
		entityManagerFactory = Persistence.createEntityManagerFactory("OnTapServer");
		// TODO Auto-generated constructor stub
	}
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	public static MyEMFactory getInstance() {
		if(instance== null)
			instance = new MyEMFactory();
		return instance;
	}
	
}
