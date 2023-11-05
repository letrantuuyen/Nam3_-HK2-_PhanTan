package gui;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.lt;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;

import util.AtlasConnection;

public class App {
	public static void main(String[] args) {
		MongoClient mongoClient = AtlasConnection.getInstance().getMongoClient();
//		MongoIterable<String> dbs = mongoClient.listDatabaseNames();
//		dbs.forEach(db -> System.out.println(db));
		
		MongoDatabase db = mongoClient.getDatabase("sample_training");
//		db.listCollectionNames().forEach(col -> System.out.println(col));
		
//		MongoCollection<Document> col = db.getCollection("students");
//		col.find().forEach(doc -> System.out.println(doc));
		
		
		MongoCollection<Document> col = db.getCollection("students");
//				Document first = col.find(Filters.eq("id", "19496281"))
//				.first();
//				
//				System.out.println(first);
//				
//				col.find()
//				.forEach(doc -> System.out.println(doc));
		
		Document n = col.aggregate(Arrays.asList(Aggregates.count())).first();
		System.out.println(n);
		
		
				
//		col.find().limit(5).forEach(zip -> System.out.println(zip));
		
//		db.zips.find({city:"PALMER"})
		
//		col.find(new Document().append("city", "PALMER"))
		
//		col.find(Document.parse("{city:\"PALMER\"}"))
		
//		
//		
//		col.find(eq("city", "PALMER"))
//		.forEach(doc -> System.out.println(doc));
//		db.zips.find({$and:[{pop:{$gt:10000}}, {pop:{$lt:20000}}]})
//		String json = "{$and:[{pop:{$gt:10000}}, {pop:{$lt:20000}}]}";
//		
////		col.find(Document.parse(json))
//		col.find(and(Arrays.asList(gt("pop", 10000L), lt("pop", 20000L))))
//		.forEach(doc -> System.out.println(doc));
	}

}
