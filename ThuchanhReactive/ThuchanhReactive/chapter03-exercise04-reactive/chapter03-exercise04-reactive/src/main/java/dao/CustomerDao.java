package dao;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.reactivestreams.Publisher;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
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
		MongoDatabase mongoDb = mongoClient.getDatabase("20043331_LeTranTuUyen");

		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
				fromProviders(PojoCodecProvider.builder().automatic(true).build()));

		collection = mongoDb.getCollection("customers", Customer.class)
				.withCodecRegistry(pojoCodecRegistry);
		
		docColl = mongoDb.getCollection("customers");
	}
	
	public Customer getCustomer(String id) {
		
		BikeSubscriber<Customer> sub;
		collection.find(Filters.eq("_id", id)).first()
				.subscribe(sub = new BikeSubscriber<>());
		
		return sub.getSingleResult();
	}
	
	public boolean addCustomer(Customer cus) {
		
		Publisher<InsertOneResult> pub = collection.insertOne(cus);
		BikeSubscriber<InsertOneResult> sub = new BikeSubscriber<InsertOneResult>();
		pub.subscribe(sub);
		
		return sub.getSingleResult() != null;
	}
	/*
	 * Le Tran Tu Uyen
	 * 20043331
	 */
	
	
	
}
