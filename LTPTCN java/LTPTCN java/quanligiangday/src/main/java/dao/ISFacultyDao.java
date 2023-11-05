package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import Entity.Faculty;

public interface ISFacultyDao extends Remote {

	public boolean addFaculty(Faculty faculty) throws RemoteException;
	public Faculty getFaculty(String id) throws RemoteException;
	public  List<Faculty> getFacultiesByCourseTitle(String title) throws RemoteException;
}
