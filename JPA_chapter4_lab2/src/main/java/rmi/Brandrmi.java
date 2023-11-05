package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Brand;

public interface Brandrmi extends Remote {

	public boolean addBrand(Brandrmi brand) throws RemoteException;
	public boolean deleteBrand(int id) throws RemoteException;
	public boolean updateBrand(Brandrmi brand) throws RemoteException;
	public Brandrmi getBrand(int id) throws RemoteException;
	public List<Brandrmi> getAll() throws RemoteException;
	
}
