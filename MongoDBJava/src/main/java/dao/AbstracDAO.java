package dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class  AbstracDAO {
	private static final String MY_DB = "BikeStores";
	
	protected MongoClient client;
	protected MongoDatabase db;
	
	// lay database 
	public AbstracDAO(MongoClient client) {
		super();
		this.client = client;
		db = client.getDatabase(MY_DB);
	}
	public MongoClient getClient() {
		return client;
	}
	public MongoDatabase getDb() {
		return db;
	}
	
	
	
	
	

}
