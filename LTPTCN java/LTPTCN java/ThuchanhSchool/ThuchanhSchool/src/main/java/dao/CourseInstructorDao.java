package dao;

import entity.Course;
import entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class CourseInstructorDao {
	private EntityManager em;
	
	public CourseInstructorDao() {
		em = MyEMFactory.getInstance().getEntityManagerFactory().createEntityManager();
	}
	
	public void addCourseInstructor(Course course, Instructor instructor) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String sql = "INSERT INTO [dbo].[CourseInstructor] "
					+ "           ([CourseID] "
					+ "           ,[PersonID]) "
					+ "     VALUES "
					+ "           (?1,?2)";
			
			Query query = em.createNativeQuery(sql);
			query.setParameter(1, course.getId());
			query.setParameter(2, instructor.getId());
			
			query.executeUpdate();
			
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
	}
}
//
//EntityTransaction tr = em.getTransaction();
//try {
//	tr.begin();
//	
//	tr.commit();
//}catch (Exception e) {
//	e.printStackTrace();
//	tr.rollback();
//}
