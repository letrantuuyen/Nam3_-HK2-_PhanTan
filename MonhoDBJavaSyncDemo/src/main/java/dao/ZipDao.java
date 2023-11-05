package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.bson.BsonValue;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;

import db.Connection;
import entity.Zip;

public class ZipDao {
	private MongoCollection<Document> zipColl;
	
	public ZipDao() {
		MongoClient mongoClient = Connection.getInstance().getMongoClient();
		MongoDatabase db = mongoClient.getDatabase("sample_training");
		zipColl = db.getCollection("zips");
	}
	
//	db.zips.find({_id: ObjectId("5c8eccc1caa187d17ca6ed19")})
	public Zip findById(ObjectId id) {
		Zip zip = null;
		Document filter = new Document("_id", id);
		Document firstDoc = zipColl.find(filter).first();
		if(firstDoc != null)
			zip = Mapper.fromDocument(firstDoc);
		return zip;
	}
	
	// Insert one document --> Bson Document
	public String insertZip(Zip zip) { //POJO -- Plain Old Java Object
		
		Document doc = Mapper.toDocument(zip);
		System.out.println(doc);
		
		InsertOneResult oneResult = zipColl.insertOne(doc);
//		System.out.println(oneResult);
		return oneResult.getInsertedId().toString();
	}
	
	// Insert many documents
	public List<String> insertZips(List<Zip> zips) {
		List<String> rs = new ArrayList<String>();
		// Ánh xạ zips sang documents
		// insertMany
		List<Document> docs = Mapper.toDocuments(zips);
		InsertManyResult manyResult = zipColl.insertMany(docs);
		
		
		Set<Entry<Integer, BsonValue>> entrySet = manyResult.getInsertedIds().entrySet();
		Iterator<Entry<Integer, BsonValue>> its = entrySet.iterator();
		while(its.hasNext()) {
			Entry<Integer, BsonValue> it = its.next();
			rs.add(it.getValue().toString());
//			BsonValue value = it.getValue();
		}
		
		return rs;
	}
	
}
