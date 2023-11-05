package Dao;

import javax.persistence.EntityManager;

import Connection.MyEMFactory;
import Entity.Employee;

public class Employee_dao {
	private EntityManager em;

	public Employee_dao() {
		em = MyEMFactory.getInstance().getEntityManagerFactory().createEntityManager();
		// TODO Auto-generated constructor stub
	}
	public Employee findEmployeeByName(String name) {
		String query ="db.employees.find({firstName:{$eq:'Adam'}})";
		return (Employee) em.createNativeQuery(query, Employee.class).getSingleResult();
	}
}
