package dao;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.bson.Document;

import com.mongodb.reactivestreams.client.AggregatePublisher;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;

import db.Connection;
import entity.Customer;

public class OrderDao {
	private MongoCollection<Document> collection;
	private CustomerDao customerDao;
	
	public OrderDao() {
		MongoClient mongoClient = Connection.getInstance().getMongoClient();
		MongoDatabase mongoDb = mongoClient.getDatabase("BikeStores");
		collection = mongoDb.getCollection("orders");
		
		customerDao = new CustomerDao();
	}
	
//	6.  Đếm số đơn hàng của từng khách hàng. 
//	+ getOrdersByCustomers() : Map<Customer, Integer>
//	db.orders.aggregate([
//    {$group: {_id: '$customer',count: { $sum: 1 }}}
//])
	public Map<Customer, Integer> getOrdersByCustomers() {
		
		Map<Customer, Integer> map = new HashMap<>();
		
		AggregatePublisher<Document> publisher = collection.aggregate(List.of(
					Document.parse("{$group: {_id: '$customer',count: { $sum: 1 }}}")					
				));
		
		BikeSubscriber<Document> sub = new BikeSubscriber<>();
		
		publisher.subscribe(sub);
		
		List<Document> docs = sub.getResults();
		for(Document doc : docs) {
			Document temp = doc.get("_id", Document.class);
			String customerId = temp.getString("customer_id");
			Customer cus = customerDao.getCustomer(customerId);
			
			map.put(cus, doc.getInteger("count"));
		}
			
		
		return map;
	}
	
//	6.  Đếm số đơn hàng của từng khách hàng. Sort by [number of orders]
//	+ getOrdersByCustomers() : Map<Customer, Integer>
//	db.orders.aggregate([
//    {$group: {_id: '$customer',count: { $sum: 1 }}}
//])
	public Map<Customer, Integer> getOrdersByCustomersSortByNumOfOrders() {
		
//		Map<Customer, Integer> map = new LinkedHashMap<>();
		Map<Customer, Integer> map = new HashMap<>();
		
		AggregatePublisher<Document> publisher = collection.aggregate(List.of(
					Document.parse("{$group: {_id: '$customer',count: { $sum: 1 }}}"),
					Document.parse("{$sort: {count: 1}}")
				));
		
		BikeSubscriber<Document> sub = new BikeSubscriber<>();
		
		publisher.subscribe(sub);
		
		List<Document> docs = sub.getResults();
		for(Document doc : docs) {
			Document temp = doc.get("_id", Document.class);
			String customerId = temp.getString("customer_id");
			Customer cus = customerDao.getCustomer(customerId);
			
			map.put(cus, doc.getInteger("count"));
		}
			
		
		return map;
	}
	
	

//	6.  Đếm số đơn hàng của từng khách hàng. Sort by customer firstName
//	+ getOrdersByCustomers() : Map<Customer, Integer>
//	db.orders.aggregate([
//    {$group: {_id: '$customer',count: { $sum: 1 }}}
//])
	public Map<Customer, Integer> getOrdersByCustomersSortByFirstName() {
		
//		Comparator<Customer> comparator = new Comparator<Customer>() {
//
//			@Override
//			public int compare(Customer o1, Customer o2) {
//				return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
//			}
//		};
		
		Comparator<Customer> comparator = (Customer o1, Customer o2) -> {
							return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
					};
					
//		Comparator<Customer> comparator = (o1, o2) -> {
//						return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
//				};
//		
	//	Map<Customer, Integer> map = new TreeMap<>(comparator);
	Map<Customer, Integer> map = new LinkedHashMap<>();
//		Map<Customer, Integer> map = new HashMap<>();
		
		AggregatePublisher<Document> publisher = collection.aggregate(List.of(
					Document.parse("{$group: {_id: '$customer',count: { $sum: 1 }}}")
				));
		
		BikeSubscriber<Document> sub = new BikeSubscriber<>();
		
		publisher.subscribe(sub);
		
		List<Document> docs = sub.getResults();
		for(Document doc : docs) {
			Document temp = doc.get("_id", Document.class);
			String customerId = temp.getString("customer_id");
			Customer cus = customerDao.getCustomer(customerId);
			
			map.put(cus, doc.getInteger("count"));
		}
			
		
		return map;
	}
}
