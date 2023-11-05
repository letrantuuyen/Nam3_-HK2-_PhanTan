package db;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoDatabase;

public class ConnectDB {
	
	//private static String My_DB;
	private MongoClient client;
	private static ConnectDB instance;
	public ConnectDB() {
		super();
		client = MongoClients.create();
	}
	
	public synchronized static ConnectDB getDB() {
		if(instance == null)
			instance = new ConnectDB();
		return instance;
	}
	
	public MongoClient getClient() {
		return client;
	}
}
