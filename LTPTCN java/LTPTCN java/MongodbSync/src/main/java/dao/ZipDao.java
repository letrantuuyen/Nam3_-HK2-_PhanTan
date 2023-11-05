package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;
import java.util.concurrent.TimeUnit;

import javax.print.Doc;

import org.bson.Document;
import util.AtlasConnection;

public class ZipDao {
	
	private static final String DB_NAME = "sample_training";
	private static final List<Document> FindIterable = null;
	private MongoCollection<Document> zipDoc;
	
	public ZipDao() {
		zipDoc = AtlasConnection.getInstance()
				.getMongoClient()
				.getDatabase(DB_NAME)
				.getCollection("zips");
	}
	
	public boolean addZip(Document zip) {
		InsertOneResult result = zipDoc.insertOne(zip);
		return result.getInsertedId() != null;
	}
	
	public boolean updateZip(Document zipNew) {
		Document result = zipDoc.findOneAndReplace(
				Filters.eq("_id", zipNew.getObjectId("_id")), zipNew);
		
		return result != null;
	}
	
//	 db.zips.find({ city: 'PALMER' })
	public List<Document> getZipsByCity(String city){
//		Document doc = new Document("city", city);
//		Document doc = Document.parse("{ city: '"+city+"' }");
		return zipDoc.find(Filters.eq("city", city)).into(new ArrayList<Document>());
	}
	
	

//	db.zips.find().limit(5).skip(2)
	public List<Document> getDocment() {
		return zipDoc.find().limit(2).skip(2).into(new ArrayList<Document>());
	}


//	public List<Document> getZipsByPop(int pop) {
//		// TODO Auto-generated method stub
//		return zipDoc.find(Filters.lt("pop", pop)).into(new ArrayList<Document>());
//	}
//
//	public List<Document> getPopByCity(String city) {
//		Bson filter = new Document("city", city);
//		Bson project = new Document("city", 1L)
//		    .append("pop", 1L);
//		return zipDoc.find(filter).projection(project).into(new ArrayList<Document>());
//	}
	public List<Document> getCityByPop() {
		Bson filter = new Document("pop", new Document("$gte", 10L)
		        .append("$lte", 50L));
		Bson project = new Document("city", 1L);
		FindIterable<Document> result = zipDoc.find(filter).projection(project).limit(10);
		return result.into(new ArrayList<Document>());
		
	}
//Cau8
	public List<Document> getCityByStateAndPop(String state, int pop) {
		Bson filter = new Document("state",state).append("pop", new Document("$gt",pop));
		FindIterable<Document> result = zipDoc.find(filter).limit(10);
		return result.into(new ArrayList<Document>());
	}
//Cau12
	public List<Document> getDocByStateAndCity(String state, String city) {
		Bson filter = new Document("state",state).append("city", city);
		FindIterable<Document> result = zipDoc.find(filter);
		return result.into(new ArrayList<Document>());
	}
//Cau9
//	db.zips.aggregate([{$group:{_id:'$state'}}])
	public List<Document> getStates() {
//		{$group:{_id:'$state'}}
		Document doc = new Document("$group", new Document("_id", "$state"));
		return zipDoc.aggregate(Arrays.asList(doc))
				.into(new ArrayList<Document>());
	}
//Cau11
	public List<Document> getAvgByState() {
		AggregateIterable<Document> result = zipDoc.aggregate(Arrays.asList(new Document("$group", 
			    new Document("_id", "$state")
			            .append("tb", 
			    new Document("$avg", "$pop")))));
		return result.into(new ArrayList<Document>());
	}

	public List<Document> getCountCityByState() {
		AggregateIterable<Document> result = zipDoc.aggregate(Arrays.asList(new Document("$match", new Document("state","WA")),
				new Document("$count","Tong")));
		return result.into(new ArrayList<Document>());
	}

	public List<Document> getCountCityByStateSort() {

		AggregateIterable<Document> result = zipDoc.aggregate(Arrays.asList(new Document("$group",
				new Document("_id","$state")
				.append("tongCity",
				new Document("$sum",1L))),
				new Document("$sort",
						new Document("tongCity",-1L))));
		return result.into(new ArrayList<Document>());
	}

	public List<Document> getStateBy1000000(int pop) {
		AggregateIterable<Document> result = zipDoc.aggregate(Arrays.asList(new Document("$group", 
			    new Document("_id", "$state")
			            .append("tongPop", 
			    new Document("$sum", "$pop"))), 
			    new Document("$match", 
			    new Document("tongPop", 
			    new Document("$gt", 10000000L)))));
		return result.into(new ArrayList<Document>());
	}
//Cau 6
	public List<Document> getPopByCity(String city) {
		Bson filter = new Document("city", city);
		Bson project = new Document("pop", 1L);
		
		FindIterable<Document>result = zipDoc.find(filter).projection(project);
		return result.into(new ArrayList<Document>());
	}
//Cau5
	public List<Document> getZipsByPop(int pop) {
		FindIterable<Document>result = zipDoc.find(Filters.gt("pop", pop));
		return result.into(new ArrayList<Document>());
	}

}



