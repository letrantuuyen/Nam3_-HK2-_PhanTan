package dao;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import static org.bson.codecs.configuration.CodecRegistries.*;
import java.util.List;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.reactivestreams.Publisher;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.reactivestreams.client.FindPublisher;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;

import Entity.Customer;
import db.connectDB;

public class CustomerDao {
	
	private MongoCollection<Customer> collectionCus;

	public CustomerDao() {
		super();
		MongoClient mongoclient = connectDB.getMY_DB().getClient();
		MongoDatabase mongodb = mongoclient.getDatabase("20043331_LeTranTuUyen");
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		collectionCus = mongodb.getCollection("customers",Customer.class).withCodecRegistry(pojoCodecRegistry);
		
	}
	//insertOne
	//complete
	public boolean addCus(Customer customer) {
		Publisher<InsertOneResult> pub  = collectionCus.insertOne(customer);
		BikeSubscription<InsertOneResult> sub  = new BikeSubscription<InsertOneResult>();
		pub.subscribe(sub);
		return sub.getResult() != null;
	}
	//insertMany
	//complete
	public boolean addListCus(List<Customer> cusList) {
		Publisher<InsertManyResult> pub = collectionCus.insertMany(cusList);
		BikeSubscription<InsertManyResult> sub = new BikeSubscription<InsertManyResult>();
		pub.subscribe(sub);
		
		return sub.getResult() != null;
	}
	
	//updateOne
	//Complete
	public boolean updateOne(int id, String firstName) {
		Publisher<UpdateResult> pub  = collectionCus.updateOne(
									eq("_id", id), 
									set("firstName", firstName));
		BikeSubscription<UpdateResult> sub = new BikeSubscription<UpdateResult>();
		pub.subscribe(sub);
		return sub.getSingleResult().getUpsertedId() != null;
	}
	//updateMany
	public boolean updateMany(List<Customer> id, String firstName) {
		Publisher<String> pub1 = collectionCus.createIndex(Document.parse("{\"_id\":\"text\"}"));
		BikeSubscription<String> sub1 = new BikeSubscription<String>();
		pub1.subscribe(sub1);
		sub1.await();
		Publisher<UpdateResult> pub  = collectionCus.updateMany(
									eq("_id", id),
									set("firstName", firstName));
		BikeSubscription<UpdateResult> sub = new BikeSubscription<UpdateResult>();
		pub.subscribe(sub);
		return sub.getResult() != null;
	}

	//deleteOne
	//Complete
	public boolean deleteOne(int id) {	
		Publisher<DeleteResult> pub = collectionCus.deleteOne(eq("_id",id));
		BikeSubscription<DeleteResult> sub = new BikeSubscription<DeleteResult>();
		pub.subscribe(sub);
		return sub.getResult()!= null;
	}	
		/*
	//deleteMany
		public List<Customer> deleteMany(String key) {
		Publisher<String> pub1  = collectionCus.createIndex(Document.parse("{\"_id\":\"text\"}"));
		BikeSubscription<String> sub1 = new BikeSubscription<>();
		pub1.subscribe(sub1);
		Publisher<DeleteResult> pub = collectionCus.deleteMany(Filters.text(key));
		BikeSubscription<DeleteResult> sub = new BikeSubscription<>();
		sub.getResult();
		DeleteResult ds = sub.getResult();
		return ds.
		}
*/
		 
	//findManybyName
	public List<Customer> getCustomerByName(String keywords){
		Publisher<String> pub1 = collectionCus.createIndex(Document.parse("{\"first_name\":\"text\"}"));
		BikeSubscription<String> sub1 = new BikeSubscription<String>();
		pub1.subscribe(sub1);
		sub1.await();
	//	System.out.println(sub1.getSingleResult());
		FindPublisher<Customer> pub = collectionCus.find(Filters.text(keywords));
		BikeSubscription<Customer> sub = new BikeSubscription<Customer>();
		pub.subscribe(sub);
		return sub.getResult();
		
	}
	}
	
