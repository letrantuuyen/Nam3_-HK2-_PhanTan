package dao;

import static org.bson.codecs.configuration.CodecRegistries.*;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import com.mongodb.MongoClientSettings;
import static com.mongodb.client.model.Filters.*;

import com.mongodb.reactivestreams.client.AggregatePublisher;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;

import db.Connection;
import entity.Customer;

public class CustomerDao {
	
	private MongoCollection<Customer> collection;
	private MongoCollection<Document> docColl;
	
	public CustomerDao() {
		MongoClient mongoClient = Connection.getInstance().getMongoClient();
		MongoDatabase mongoDb = mongoClient.getDatabase("BikeStores");
//		CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
//					MongoClientSettings.getDefaultCodecRegistry(),
//					CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
//				);
		
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
				fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		
		collection = mongoDb.getCollection("customers", Customer.class)
				.withCodecRegistry(pojoCodecRegistry );
		
		docColl = mongoDb.getCollection("customers");
	}
	
//	db.customers.find({"_id": "CHAR5"})
	public Customer findById(String id) {
		Publisher<Customer> publisher = collection.find(eq("_id", id)).first();
		BikeSubscriber<Customer> subscriber = new BikeSubscriber<Customer>();
		
		publisher.subscribe(subscriber);
		
		Customer cus = subscriber.getSingleResult();

		return cus;
	}
	
//	Tổng số khách hàng theo từng ban, giảm dần theo số khách hàng
//	db.customers.aggregate([
//	  {$group: {_id: "$address.state", count: {$sum: 1}}},
//	  {$sort: {count: -1}}
//	 ])
	
	public Map<String, Integer> getNumberCustomersByState() {
		
		Map<String, Integer> map = new LinkedHashMap<String, Integer>(); 
//		HashMap, TreeMap, LinkedHashMap, Hashtable
		
		AggregatePublisher<Document> publisher = docColl.aggregate(List.of(
					Document.parse(" {$group: {_id: '$address.state', count: {$sum: 1}}}"),
					Document.parse("{$sort: {count: -1}}")
				));
		
		BikeSubscriber<Document> subscriber = new BikeSubscriber<Document>();
		
		publisher.subscribe(subscriber);
		
		List<Document> results = subscriber.getResults();
		results.forEach(doc -> map.put(doc.getString("_id"), doc.getInteger("count")));
	
		return map;
	}
	
}
