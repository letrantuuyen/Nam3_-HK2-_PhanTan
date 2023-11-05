package db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class connection {
	private connection instance;
	private EntityManager em;
	public connection () {
		em = Persistence.createEntityManagerFactory("DemoExercise4").createEntityManager();
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
