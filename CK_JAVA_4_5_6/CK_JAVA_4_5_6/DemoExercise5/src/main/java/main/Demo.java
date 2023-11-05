package main;

import dao.EmployeeProjectDAO;
import db.connection;
import entity.EmployeeProject;
import jakarta.persistence.EntityManager;

public class Demo {
	private static EntityManager em;

	public static void main(String[] args) {
		em = new connection().getInstance().getEM();
		EmployeeProjectDAO employeeProjectDAO = new EmployeeProjectDAO();
		EmployeeProject ep = employeeProjectDAO.getByIDEP(1, 3);
		System.out.println(ep);
	}
}
