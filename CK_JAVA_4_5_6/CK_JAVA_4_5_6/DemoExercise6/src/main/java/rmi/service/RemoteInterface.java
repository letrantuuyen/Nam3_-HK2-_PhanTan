package rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import entity.OrderDetail;
import entity.Orders;
import entity.Product;

public interface RemoteInterface extends Remote {
	public boolean insertOrderDetail(OrderDetail od) throws RemoteException;
	public boolean updateOrderDetail(OrderDetail od) throws RemoteException;
	public boolean deleteOrderDetail(Object proID, Object orderID) throws RemoteException;
	public OrderDetail getByIDOrderDetail(Object proID, Object orderID) throws RemoteException;
	public Orders getByIDOrder(Object id) throws RemoteException;
	public Product getByIDProduct(Object id) throws RemoteException;
	public List<Product> getProductNotSales () throws RemoteException;
	public Map<Product, Integer> getQuanTityOfProductByDate (int month, int year) throws RemoteException;
}	
