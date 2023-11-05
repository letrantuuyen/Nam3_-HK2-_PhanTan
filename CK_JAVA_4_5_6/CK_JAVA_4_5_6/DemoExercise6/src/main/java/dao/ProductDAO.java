package dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import entity.Product;

public class ProductDAO extends AbstractDAO<Product> {
	public ProductDAO () {
		super(Product.class);
	}
	
	public List<Product> getProductNotSales () {
		return em.createNativeQuery(" select * \r\n"
				+ " from Product p\r\n"
				+ " where p.productID Not in (select Distinct productID from OrderDetail)", Product.class).getResultList();
	}
	
	public Map<Product, Integer> getQuanTityOfProductByDate (int month, int year) {
		Map<Product, Integer> map = new LinkedHashMap<>();
 		List<Object[]> objs = em.createNativeQuery("select od.productID, sum(od.quantity) as QuantityOfProduct\r\n"
				+ "from OrderDetail od\r\n"
				+ "join Orders o on o.orderID = od.orderID\r\n"
				+ "join Product p on p.productID = od.productID\r\n"
				+ "where MONTH(o.orderDate) = "+month+" and YEAR (o.orderDate) = "+year+"\r\n"
				+ "group by od.productID\r\n"
				+ "order by sum(od.quantity) desc").getResultList();
 		objs.forEach(o -> {
 			Product p = new ProductDAO().getByID(o[0]);
 			Integer count = (Integer) o[1];
 			map.put(p, count);
 		});
 		return map;
	}
}
