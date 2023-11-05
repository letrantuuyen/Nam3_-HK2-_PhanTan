package db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class connection {
	private EntityManager em;
	private connection instance;
	public connection () {
		em = Persistence.createEntityManagerFactory("DemoExercise5").createEntityManager();
	}
	public connection getInstance () {
		if (instance == null)
			instance = new connection();
		return instance;
	}
	public EntityManager getEM () {
		return em;
	}
}
