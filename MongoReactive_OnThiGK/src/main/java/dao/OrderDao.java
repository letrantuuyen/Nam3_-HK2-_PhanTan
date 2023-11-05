package dao;

import org.bson.Document;
import org.reactivestreams.Publisher;

import com.google.gson.Gson;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;

import db.ConnectDB;
import entity.Order;

public class OrderDao {
	private final Gson gson = new Gson();
	private MongoCollection<Document> collectionO;

	public OrderDao() {
		super();
		MongoClient mongoclient = ConnectDB.getDB().getClient();
		MongoDatabase mongoDatabase = mongoclient.getDatabase("BikeStores");
		mongoDatabase.getCollection("orders");
		
	}
	
	//them mot order
	public boolean addOrder(Order order) {
		String json = gson.toJson(order);
		Document doc = Document.parse(json);
		Publisher<InsertOneResult> pub = collectionO.insertOne(doc);
		BikeSubcription<InsertOneResult> sub = new BikeSubcription<>();
		pub.subscribe(sub);
		return sub.getResult() != null;
	}
	
	

}
