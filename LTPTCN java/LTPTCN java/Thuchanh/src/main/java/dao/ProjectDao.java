package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Project;

public class ProjectDao {
	
	private EntityManager em;
	
	public ProjectDao() {
		em = MyEMFactory.getInstance().getEntityManagerFactory().createEntityManager();
	}
	
	public boolean addProject(Project p) {
		
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(p);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return false;
	}
	public boolean updateProject(Project p) {
		
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(p);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return false;
	}
	public boolean deleteProject(String id) {
		
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(Project.class, id));
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return false;
	}
	
	public List<Project> getProjects() {
		return em.createQuery("select p from Project p", Project.class).getResultList();
	}
	
	public Project getProject(String id) {
		return em.find(Project.class, id);
	}
}
