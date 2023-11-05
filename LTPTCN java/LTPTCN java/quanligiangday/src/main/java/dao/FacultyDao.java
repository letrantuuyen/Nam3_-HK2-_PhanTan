package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import Entity.Faculty;
import connect.MyEMFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class FacultyDao extends UnicastRemoteObject implements ISFacultyDao {
	private EntityManager em;
	public FacultyDao() throws RemoteException{
		em = MyEMFactory.getInstance().getEntityManagerFactory().createEntityManager();
	}
	
	@Override
	public boolean addFaculty(Faculty faculty) throws RemoteException
	{
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(faculty);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	@Override
	public Faculty getFaculty(String id) throws RemoteException
	{
		return em.find(Faculty.class, id);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public  List<Faculty> getFacultiesByCourseTitle(String title) throws RemoteException
	{
		Query query = em.createNativeQuery("select f.* from Faculties f inner join FacultyCourses fc on f.fact_id = fc.fact_id \r\n"
				+ "						  inner join Courses c on fc.course_id = c.course_id \r\n"
				+ "						  where c.title='" + title +  "' ",Faculty.class);
		return query.getResultList();
		
	}
}
