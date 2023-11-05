package rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import dao.EmployeeDAO;
import dao.EmployeeProjectDAO;
import dao.ProjectDAO;
import entity.Employee;
import entity.EmployeeProject;
import entity.Project;
import rmi.service.RemoteInterface;

public class RemoteImplement extends UnicastRemoteObject implements RemoteInterface{

	private EmployeeProjectDAO employeeProjectDAO;
	private EmployeeDAO employeeDAO;
	private ProjectDAO projectDAO;
	
	public RemoteImplement () throws RemoteException  {
		super();
		employeeProjectDAO = new EmployeeProjectDAO();
		employeeDAO = new EmployeeDAO();
		projectDAO = new ProjectDAO();
	}

	@Override
	public boolean insertEP(EmployeeProject ep) throws RemoteException {
		return employeeProjectDAO.insert(ep);
	}

	@Override
	public boolean updateEP(EmployeeProject ep) throws RemoteException {
		return employeeProjectDAO.update(ep);
	}

	@Override
	public boolean deleteEP(Object id) throws RemoteException {
		return employeeProjectDAO.delete(id);
	}

	@Override
	public EmployeeProject getByIDEP(Object id1, Object id2) throws RemoteException {
		return employeeProjectDAO.getByIDEP(id1, id2);
	}

	@Override
	public List<EmployeeProject> getAllEP() throws RemoteException {
		return employeeProjectDAO.getAll();
	}

	@Override
	public Employee getEmployeebyID(Object id) throws RemoteException {
		return employeeDAO.getByID(id);
	}

	@Override
	public boolean insertEmployee(Employee e) throws RemoteException {
		return employeeDAO.insert(e);
	}

	@Override
	public boolean insertProject(Project p) throws RemoteException {
		return projectDAO.insert(p);
	}

	@Override
	public Project getProjectByID(Object id) throws RemoteException {
		System.out.println(projectDAO.getByID(id));
		return projectDAO.getByID(id);
	}

	@Override
	public Map<Employee, Integer> getHoursOfEmployee(Object id) throws RemoteException {
		return employeeProjectDAO.getHoursOfEmployee(id);
	}

	@Override
	public Map<Project, Integer> getHoursForEachProject() throws RemoteException {
		return employeeProjectDAO.getHoursForEachProject();
	}

}
