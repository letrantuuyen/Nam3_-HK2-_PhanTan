package factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entity.Group;
import entity.User;
import entity.UserGroup;
import entity.UserGroupId;


public class MySession {
	private static MySession instance;
	private SessionFactory sessionFactory;
	
	private MySession() {
		
		StandardServiceRegistry registry = 	new StandardServiceRegistryBuilder()
				.configure()
				.build();
		Metadata metadata = new MetadataSources(registry)
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(Group.class)
				.addAnnotatedClass(UserGroup.class)
				.addAnnotatedClass(UserGroupId.class)
				.getMetadataBuilder()
				.build();
		sessionFactory = metadata
				.getSessionFactoryBuilder()
				.build();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
	
		tr.begin();
		try {
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
				
	}
		
	}
	public static MySession getInstance() {
		if(instance == null)
			instance = new MySession();
		return instance;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	

}
