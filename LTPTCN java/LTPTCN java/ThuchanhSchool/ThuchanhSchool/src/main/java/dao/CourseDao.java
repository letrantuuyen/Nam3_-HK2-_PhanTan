package dao;

import entity.Course;
import jakarta.persistence.EntityManager;

public class CourseDao {
	private EntityManager em;
	
	public CourseDao() {
		em = MyEMFactory.getInstance().getEntityManagerFactory().createEntityManager();
	}
	
	public Course getCourse(int id) {
		return em.find(Course.class, id);
	}
}
