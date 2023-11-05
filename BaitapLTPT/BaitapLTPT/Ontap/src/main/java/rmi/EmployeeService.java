package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.Employee;

public interface EmployeeService extends Remote{

	public boolean addEmployee(Employee employee) throws RemoteException;
}
