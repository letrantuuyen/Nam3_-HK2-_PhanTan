package rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import dao.OrderDetailDao;
import dao.OrdersDAO;
import dao.ProductDAO;
import entity.OrderDetail;
import entity.Orders;
import entity.Product;
import rmi.service.RemoteInterface;

public class RemoteImplement extends UnicastRemoteObject implements RemoteInterface {

	private OrderDetailDao orderDetailDAO;
	private OrdersDAO orderDAO;
	private ProductDAO productDAO;

	public RemoteImplement() throws RemoteException {
		super();
		orderDetailDAO = new OrderDetailDao();
		orderDAO = new OrdersDAO();
		productDAO = new ProductDAO();
	}

	@Override
	public boolean insertOrderDetail(OrderDetail od) throws RemoteException {
		return orderDetailDAO.insert(od);
	}

	@Override
	public boolean updateOrderDetail(OrderDetail od) throws RemoteException {
		return orderDetailDAO.update(od);
	}

	@Override
	public boolean deleteOrderDetail(Object proID, Object orderID) throws RemoteException {
		return orderDetailDAO.deleteOrderDetailByID(proID, orderID);
	}

	@Override
	public OrderDetail getByIDOrderDetail(Object proID, Object orderID) throws RemoteException {
		return orderDetailDAO.getByIDOrderDetail(proID, orderID);
	}

	@Override
	public Orders getByIDOrder(Object id) throws RemoteException {
		return orderDAO.getByID(id);
	}

	@Override
	public Product getByIDProduct(Object id) throws RemoteException {
		return productDAO.getByID(id);
	}

	@Override
	public List<Product> getProductNotSales() throws RemoteException {
		return productDAO.getProductNotSales();
	}

	@Override
	public Map<Product, Integer> getQuanTityOfProductByDate(int month, int year) throws RemoteException {
		return productDAO.getQuanTityOfProductByDate(month, year);
	}

}
