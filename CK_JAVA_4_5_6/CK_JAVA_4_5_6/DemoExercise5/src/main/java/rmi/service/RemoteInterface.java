package rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import entity.Employee;
import entity.EmployeeProject;
import entity.Project;

public interface RemoteInterface  extends Remote  {
	public boolean insertEP (EmployeeProject ep) throws RemoteException;
	public boolean updateEP (EmployeeProject ep) throws RemoteException;
	public boolean deleteEP (Object id) throws RemoteException;
	public List<EmployeeProject> getAllEP () throws RemoteException;
	public EmployeeProject getByIDEP(Object id1, Object id2) throws RemoteException;
	public Employee getEmployeebyID(Object id) throws RemoteException;
	public boolean insertEmployee (Employee e) throws RemoteException;
	public boolean insertProject (Project p) throws RemoteException;
	public Project getProjectByID (Object id) throws RemoteException;
	public Map<Employee, Integer> getHoursOfEmployee (Object id) throws RemoteException;
	public Map<Project, Integer> getHoursForEachProject () throws RemoteException;
}
