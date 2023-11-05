package factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entity.Address;
import entity.Brand;
import entity.Category;
import entity.Contact;
import entity.Customer;
import entity.Order;
import entity.OrderProduct;
import entity.OrderProductId;
import entity.Person;
import entity.Product;
import entity.Staff;
import entity.Store;
import entity.StoreProduct;
import entity.StoreProductId;


public class MySessionFactory {
	
	private static MySessionFactory instance;
	
	private SessionFactory sessionFactory;
	
	public MySessionFactory() {
		// TODO Auto-generated constructor stub
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		
		Metadata metadata = new MetadataSources(registry)
				.addAnnotatedClass(Brand.class)
				.addAnnotatedClass(Product.class)
				.addAnnotatedClass(Category.class)
				.addAnnotatedClass(Store.class)
				.addAnnotatedClass(Address.class)
				.addAnnotatedClass(Contact.class)
				.addAnnotatedClass(Person.class)
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Staff.class)
				.addAnnotatedClass(OrderProduct.class)
				.addAnnotatedClass(OrderProductId.class)
				.addAnnotatedClass(Order.class)
				.addAnnotatedClass(StoreProduct.class)
				.addAnnotatedClass(StoreProductId.class)
				.addAnnotatedClass(Staff.class)
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
	public static MySessionFactory getInstance() {
		if(instance == null)
			instance = new MySessionFactory();
		return instance;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
