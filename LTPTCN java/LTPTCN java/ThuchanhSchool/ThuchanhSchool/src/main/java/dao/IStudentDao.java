package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.Student;

public interface IStudentDao extends Remote{
	public Student getStudent(int id) throws RemoteException;
	public void addStudent(Student student) throws RemoteException;

}
