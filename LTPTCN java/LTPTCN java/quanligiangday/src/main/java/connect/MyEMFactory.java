package connect;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MyEMFactory {
	private static MyEMFactory instance;
	private EntityManagerFactory entityManagerFactory;
	
	public MyEMFactory() {
		entityManagerFactory = Persistence.createEntityManagerFactory("quanligiangday");
	}

	public synchronized static MyEMFactory getInstance() {
		if(instance == null)
		{
			instance = new MyEMFactory();
		}
		return instance;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
	
}
