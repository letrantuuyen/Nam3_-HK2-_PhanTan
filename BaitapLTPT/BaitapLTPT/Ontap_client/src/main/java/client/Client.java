package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;

import entity.Employee;
import entity.Gender;
import rmi.EmployeeService;

public class Client {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		EmployeeService employeeService = (EmployeeService) Naming.lookup("rmi://b14m30:8989/employeeService");
		
		Employee emp = new Employee(544, "asda", "asd", Gender.F, "sd", new Date(2002 - 1900, Calendar.JANUARY, 2));
		
		boolean rs = employeeService.addEmployee(emp );
		System.out.println(rs);
		
	}
}
