package dao;

import entity.Instructor;
import jakarta.persistence.EntityManager;

public class InstructorDao {
	private EntityManager em;
	public InstructorDao() {
		em = MyEMFactory.getInstance().getEntityManagerFactory().createEntityManager();
	}
	
	public Instructor getInstructor(int id) {
		return em.find(Instructor.class, id);
	}
}
