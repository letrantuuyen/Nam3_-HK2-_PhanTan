package db;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

public class connectDB {
	private static String MY_DB = "20043331_LeTranTuUyen";
	private MongoClient client;
	private static connectDB instance;
	public connectDB() {
		super();
		client = MongoClients.create();
		
	}
	public synchronized static connectDB getMY_DB() {
		if(instance == null)
			instance = new connectDB();
		return instance;
	}

	public MongoClient getClient() {
		return client;
	}
	
	

}
