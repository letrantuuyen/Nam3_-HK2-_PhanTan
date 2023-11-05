package rmi;

import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class BrandImpl extends UnicastRemoteObject implements Brandrmi {

	protected BrandImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addBrand(Brandrmi brand) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBrand(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBrand(Brandrmi brand) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Brandrmi getBrand(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Brandrmi> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
