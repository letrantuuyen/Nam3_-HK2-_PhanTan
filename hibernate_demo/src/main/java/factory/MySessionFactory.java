package factory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class MySessionFactory {
	private static MySessionFactory instance;
	private SessionFactory sessionFactory;
	
	
	private MySessionFactory() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		
		Metadata metadata = new MetadataSources(registry)
				.getMetadataBuilder()
				.build();
		
		sessionFactory = metadata 
				.getSessionFactoryBuilder()
				.build();
	}


	public static MySessionFactory getInstance() {
		if(instance == null)
			instance = new MySessionFactory();
		return instance;
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}




	
	
	
	
	

}
