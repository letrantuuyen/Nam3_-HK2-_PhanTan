package demo;


import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import db.Connection;

public class ConnectDemo {
	public static void main(String[] args) {
		MongoClient mongoClient = Connection.getInstance().getMongoClient();
//		MongoIterable<String> dbNames = mongoClient.listDatabaseNames();
//		dbNames.forEach(System.out::println);
		MongoDatabase db = mongoClient.getDatabase("sample_mflix");
//		db.listCollectionNames().forEach(System.out::println);
		
		MongoCollection<Document> movieDocument = db.getCollection("movies");
		
		Document firstDocument = movieDocument.find().first();
		System.out.println(firstDocument);
		
	}
}
