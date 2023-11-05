package dao;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.reactivestreams.client.MongoCollection;

import db.connectDB;

public class MovieDao {
	private MongoCollection<Document> movieCollection;
	private Document doc = new Document();
	private Gson gson  = new Gson();
	// tạo constructor rỗng để lấy database
	public MovieDao() {
		super();
		movieCollection = connectDB.getMyDb().getMongoclient().getDatabase("LeTranTuUyen").getCollection("Movie");
	}
	
	
	
	
	
	

}
