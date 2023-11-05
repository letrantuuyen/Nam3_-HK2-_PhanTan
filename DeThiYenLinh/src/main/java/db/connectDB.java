package db;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoDatabase;

public class connectDB {
	private static final String My_db = "LeTranTuUyen";
	protected MongoClient mongoclient;
	private static connectDB instance;
	
	
	public connectDB() {
		super();
		mongoclient = MongoClients.create();
	}


	public synchronized static connectDB getMyDb() {
		if(instance == null)	
			instance = new connectDB();
		return instance;
	}


	public MongoClient getMongoclient() {
		return mongoclient;
	}
	
	
	
	
	
	

}
