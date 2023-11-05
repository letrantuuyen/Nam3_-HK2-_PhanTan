package db;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class Connection {
	private static Connection instance;
	private MongoClient mongoClient;
	
	private Connection() {
//		String uri = "mongodb+srv://myAtlasDBUser:1234@myatlasclusteredu.nomdcie.mongodb.net/?retryWrites=true&w=majority";
		String uri="mongodb://localhost:1009";
		MongoClientSettings settings = MongoClientSettings.builder()
				.applyConnectionString(new ConnectionString(uri))
				.applyToConnectionPoolSettings((builder) -> {
					builder.maxSize(50);
				})
				.build();
		
		mongoClient = MongoClients.create(settings);
	}
	
	public static Connection getInstance() {
		if(instance == null)
			instance = new Connection();
		return instance;
	}
	
	public MongoClient getMongoClient() {
		return mongoClient;
	}
}
