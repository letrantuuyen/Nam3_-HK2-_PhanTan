package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.EmployeeDao;
import entity.Employee;

public class EmployeeServiceImpl extends UnicastRemoteObject implements EmployeeService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 274805564930671204L;
	private EmployeeDao employeeDao;
	
	public EmployeeServiceImpl() throws RemoteException{
		employeeDao = new EmployeeDao();
	}
	
	@Override
	public boolean addEmployee(Employee employee) throws RemoteException {
		
//		if(employee.getId() < 100)
//			return false;
		return employeeDao.addEmployee(employee);
	}

}
