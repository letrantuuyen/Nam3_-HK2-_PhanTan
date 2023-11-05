package Connection;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class AtlasConnection {
	private static AtlasConnection instance;
	private MongoClient mongoClient;
	public AtlasConnection() {
		mongoClient = MongoClients.create();
	}
	public static AtlasConnection getInstance() {
		if(instance==null)
			instance = new AtlasConnection();
		return instance;
	}
	public MongoClient getMongoClient() {
		return mongoClient;
	}
	
}
