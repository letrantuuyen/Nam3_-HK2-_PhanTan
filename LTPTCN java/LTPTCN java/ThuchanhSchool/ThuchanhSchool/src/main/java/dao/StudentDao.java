package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class StudentDao extends UnicastRemoteObject implements IStudentDao{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2664405976630212117L;
	private EntityManager em;
	public StudentDao() throws RemoteException{
		em = MyEMFactory.getInstance().getEntityManagerFactory().createEntityManager();
	}
	
	@Override
	public Student getStudent(int id) throws RemoteException{
		return em.find(Student.class, id);
	}
	
	@Override
	public void addStudent(Student student) throws RemoteException{
		
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(student);
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
	}
}
