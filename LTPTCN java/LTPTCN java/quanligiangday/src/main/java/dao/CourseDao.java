package dao;

import Entity.Course;
import Entity.Faculty;
import connect.MyEMFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CourseDao {
	private EntityManager em;
	public CourseDao() {
		em = MyEMFactory.getInstance().getEntityManagerFactory().createEntityManager();
	}
	public boolean addCourse(Course course)
	{
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(course);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
}
