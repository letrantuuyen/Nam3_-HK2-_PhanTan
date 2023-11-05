package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Patient;

public class PatientDao {
	private EntityManager em;
	public PatientDao() {
		
		em = MyEMFactory
				.getInstance()
				.getEntityManagerFactory()
				.createEntityManager();
		
	}
	
	public boolean addPatient(Patient patient) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(patient);
			tr.commit();
			
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return false;
	}
	public boolean updatePatient(Patient patient) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(patient);
			tr.commit();
			
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return false;
	}
	public boolean deletePatient(String id) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(Patient.class, id));
			tr.commit();
			
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return false;
	}
	
//	public Patient getPatient(String id) {
//		return em.find(Patient.class, id);
//	}
	
	
	public Patient getPatient(String id) {
		String query = "select p from Patient p where p.patientId = '"+id+"'";
		return em.createQuery(query, Patient.class).getSingleResult();
	}
	
//	 db.patients.find({_id:'PT_49759'})
//	public Patient getPatient(String id) {
//		String query = " db.patients.find({_id:'"+id+"'})";
//		return (Patient) em.createNativeQuery(query, Patient.class).getSingleResult();
//	}
	
	public List<Patient> getPatients() {
		return em.createNamedQuery("get_all_patients", Patient.class).getResultList();
	}
	
//	 db.patients.updateOne( { _id: 'PT_49759' }, { $pull: { tests: { test_id: '5623'} } } )
	public boolean deleteTest(String patientId, String testId) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String query = "db.patients.updateOne( { _id: '"+patientId+"' }, { $pull: { tests: { test_id: '"+testId+"'} } } )";
			int n = em.createNativeQuery(query).executeUpdate();
			tr.commit();
			
			return n > 0;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return false;
	}
	
}




