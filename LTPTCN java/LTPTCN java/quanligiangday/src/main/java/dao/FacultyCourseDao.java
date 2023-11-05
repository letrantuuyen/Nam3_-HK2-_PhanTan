package dao;

import Entity.Course;
import Entity.Faculty;
import Entity.facultyCourse;
import connect.MyEMFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class FacultyCourseDao {
	private EntityManager em;
	public FacultyCourseDao() {
		em = MyEMFactory.getInstance().getEntityManagerFactory().createEntityManager();
	}
	
//	public boolean addFacultyCourse (Course course, Faculty faculty)
//	{
//		EntityTransaction tr = em.getTransaction();
//		facultyCourse facultyCourse = new facultyCourse(faculty, course);
//		try {
//			tr.begin();
//			em.persist(facultyCourse);
//			tr.commit();
//			return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//		
//	}
	
	public boolean addFacultyCourse(Course course,Faculty faculty)
	{
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			Query query = em.createNativeQuery("insert into [dbo].[FacultyCourses] ([course_id],[fact_id])\r\n"
					+ "values(?1,?2)");
			query.setParameter(1, course.getId());
			query.setParameter(2, faculty.getId());
			query.executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
