package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Connection.MyEMFactory;
import Entity.Project;

public class ProjectDao {
	private EntityManager em;

	public ProjectDao() {
		em = MyEMFactory.getInstance().getEntityManagerFactory().createEntityManager();
		// TODO Auto-generated constructor stub
	}
	public boolean addProject(Project p) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(p);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
}
