package db;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoDatabase;

public  class  connectDB {
	private static final String MY_DB = "BikeStores";
	
	protected MongoClient client;
	private static  connectDB instance;
	
	private connectDB() {
		client = MongoClients.create();
	}
	
	public synchronized static connectDB getInstance() {
		if(instance == null)
			instance = new connectDB();
		return instance;
	}
	
	public MongoClient getMongoClient() {
		return client;
	}

	
	

	
	
	
	
	

}
