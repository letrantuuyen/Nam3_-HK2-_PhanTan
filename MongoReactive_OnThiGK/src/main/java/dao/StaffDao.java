package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.Doc;

import org.bson.Document;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import com.google.gson.Gson;
import com.mongodb.MongoCursorNotFoundException;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.reactivestreams.client.AggregatePublisher;
import com.mongodb.reactivestreams.client.FindPublisher;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;

import db.ConnectDB;
import entity.Phone;
import entity.Staff;

public class StaffDao {
	private MongoCollection<Document> collectionS;
	private Gson gson = new Gson();
	private MongoClient client;
	public StaffDao() {
		super();
		collectionS = ConnectDB.getDB().getClient().getDatabase("BikeStores").getCollection("staffs");
		
	}
	public boolean addStaff(Staff staff) {
		String jsonS = gson.toJson(staff);
		Document doc = Document.parse(jsonS);
		Publisher<InsertOneResult> pub  = collectionS.insertOne(doc);
		BikeSubcription<InsertOneResult> sub  =new BikeSubcription<>();
		pub.subscribe(sub);
		return sub.getSingleResult() != null;
	}
	public boolean addList(List<Staff> list) {
		List<Document> docs = new ArrayList<Document>();
		list.forEach(a->{
			Document doc = new Document()
					.append("staffId", a.getStaffId())
					.append("firstName", a.getFirstName())
					.append("lastName", a.getLastName())
					.append("phone", a.getPhone())
					.append("email", a.getEmail())
					.append("staffManager", a.getStaffManager());
			docs.add(doc);
		});
		Publisher<InsertManyResult> pub = collectionS.insertMany(docs);
		BikeSubcription<InsertManyResult> sub = new BikeSubcription<>();
		return sub.getResult() != null;
	}
	/*
	public boolean update(long id, Staff s) {
		String json = gson.toJson(s);
		Publisher<UpdateResult> pub = collectionS.findOneAndReplace(Filters.eq("staffId"),id, Updates.set(s));
		BikeSubcription<UpdateResult> sub = new BikeSubcription<>();
		pub.subscribe(sub);
		return sub.getResult() != null;
	}
	
	public List<Product> getProductByName(String keywords){
		Publisher<String> pub1  = collectionP.createIndex(Document.parse("{\"product_name\":\"text\"}"));
		BikeSubcription<String> sub1 = new BikeSubcription<>();
		pub1.subscribe(sub1);
		sub1.await();
		
		FindPublisher<Product> pub = collectionP.find(Filters.text(keywords));
		BikeSubcription<Product> sub = new BikeSubcription<>();
		pub.subscribe(sub);
		return sub.getResult();
	}
	*/

}
