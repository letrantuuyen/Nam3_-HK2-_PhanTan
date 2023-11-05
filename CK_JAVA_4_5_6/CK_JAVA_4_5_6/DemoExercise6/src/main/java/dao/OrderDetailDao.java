package dao;

import entity.OrderDetail;
import jakarta.persistence.EntityTransaction;

public class OrderDetailDao extends AbstractDAO<OrderDetail> {
	public OrderDetailDao () {
		super (OrderDetail.class);
	}
	
	public OrderDetail getByIDOrderDetail (Object proID, Object orderID)  {
		System.out.println("select * from OrderDetail where productID = 'NA3' and orderID = "+orderID);
		return (OrderDetail) em.createNativeQuery("select * from OrderDetail where productID = '" +proID+ "' and orderID = "+orderID, OrderDetail.class).getResultList().get(0);
	}
	
	public boolean deleteOrderDetailByID (Object proID, Object orderID) {
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			em.remove(getByIDOrderDetail(proID, orderID));
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
}
