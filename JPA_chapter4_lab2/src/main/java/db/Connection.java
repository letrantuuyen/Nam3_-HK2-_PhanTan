package db;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
/*
20043331
Lê Trần Tú Uyên
*/
public class Connection {
	
	private static Connection instance;
	private EntityManagerFactory emf;
	
	private Connection() {
		// TODO Auto-generated constructor stub
		emf = Persistence.createEntityManagerFactory("JPA_chapter4_lab2");
		
	}
	
	public static Connection getInstance() {
		if(instance == null)
			instance = new Connection();
		return instance;
	}
	public EntityManagerFactory getEmf() {
		return emf;
	}

}
