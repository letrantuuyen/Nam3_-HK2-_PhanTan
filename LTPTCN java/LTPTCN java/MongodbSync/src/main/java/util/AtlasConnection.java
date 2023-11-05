package util;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class AtlasConnection {
	private static AtlasConnection instance;
	private MongoClient mongoClient;
	
	private AtlasConnection() {
		String uri = "mongodb+srv://dbAdmin:dbPass@khanhcluster.qxnzc5d.mongodb.net/?retryWrites=true&w=majority";
		
//		MongoClientSettings settings = MongoClientSettings.builder()
//		.applicationName("Demo")
//		.applyConnectionString(new ConnectionString(uri))
//		.applyToSocketSettings(builder -> builder.connectTimeout(5, TimeUnit.SECONDS))
//		.applyToConnectionPoolSettings(builder -> builder.maxSize(0))
//		.build();
		
//		mongoClient = MongoClients.create(); //localhost:27017
//		mongoClient = MongoClients.create("mongodb+srv://adAdmin:dbPass@khanhcluster.qxnzc5d.mongodb.net/?retryWrites=true&w=majority"); 
		mongoClient = MongoClients.create(uri); 
		
	}
	
	public synchronized static AtlasConnection getInstance() {
		if(instance == null)
			instance = new AtlasConnection();
		return instance;
	}
	
	public MongoClient getMongoClient() {
		return mongoClient;
	}
}
