package dao;

import entity.Employee;
import factory.MyEntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EmployeeDao {
	private EntityManager em;
	
	public EmployeeDao() {
		em = MyEntityManagerFactory.getInstance().getEntityManagerFactory().createEntityManager();
	}
	
	public boolean addEmployee(Employee employee) {
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			em.persist(employee);
			
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
