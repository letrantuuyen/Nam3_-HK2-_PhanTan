package dao;

import entity.Employee;

public class EmployeeDAO extends AbstractDao<Employee> {
	public EmployeeDAO () {
		super(Employee.class);
	}
}
