package demo;

import java.util.Calendar;
import java.util.Date;

import dao.EmployeeDao;
import entity.Employee;
import entity.Gender;

public class Demo {
	public static void main(String[] args) {
		
//		MyEntityManagerFactory.getInstance().getEntityManagerFactory();
		
		EmployeeDao employeeDao = new EmployeeDao();
		Employee emp = new Employee(43435, "asda", "asd", Gender.F, "sd", new Date(2002 - 1900, Calendar.JANUARY, 2));
		
		boolean rs = employeeDao.addEmployee(emp );
		System.out.println(rs);
	}
}
