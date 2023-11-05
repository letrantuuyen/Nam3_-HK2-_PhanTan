package dao;

import static org.bson.codecs.configuration.CodecRegistries.*;

import java.util.List;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.reactivestreams.Publisher;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateManyModel;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.internal.operation.FindAndReplaceOperation;
import com.mongodb.reactivestreams.client.FindPublisher;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;

import db.ConnectDB;
import entity.Customer;
import entity.Product;

public class ProductDao {
	
	MongoCollection<Product> collectionP;

	public ProductDao() {
		super();
		MongoClient client = ConnectDB.getDB().getClient();
		MongoDatabase mongoDatabase = client.getDatabase("BikeStores");
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		collectionP = mongoDatabase.getCollection("products",Product.class).withCodecRegistry(pojoCodecRegistry);
	}
	
	public boolean addP(Product p) {
		Publisher<InsertOneResult> pub = collectionP.insertOne(p);
		BikeSubcription<InsertOneResult> sub = new BikeSubcription<InsertOneResult>();
		pub.subscribe(sub);
	//	System.out.println(sub.getSingleResult());
		return sub.getSingleResult() != null;
	}
	public boolean addListProduct(List<Product> list) {
		Publisher<InsertManyResult> pub = collectionP.insertMany(list);
		BikeSubcription<InsertManyResult> sub = new BikeSubcription<>();
		pub.subscribe(sub);
		return sub.getResult()!= null;
		
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
	
	public boolean updateOne(Long id, String productName){
		Publisher<UpdateResult> pub  = collectionP.updateOne(Filters.eq("_id", id), Updates.set("product_name",productName));
		BikeSubcription<UpdateResult> sub = new BikeSubcription<>();
		pub.subscribe(sub);
		return sub.getResult() != null;
	}
   	public List<Product> updateMany(List<Long> id, String productName){
		Publisher<Product> pub  = collectionP.findOneAndUpdate(Filters.in("_id", id), Updates.set("product_name",productName));
		BikeSubcription<Product> sub = new BikeSubcription<>();
		pub.subscribe(sub);
		return sub.getResult();
	}
	
	public List<Product> findProductByName(String productName){
		Publisher<Product> pub = collectionP.find(Filters.eq("product_name", productName));
		BikeSubcription<Product> sub = new BikeSubcription<>();
		pub.subscribe(sub);
		return sub.getResult();
	}
	public boolean deleteOneProduct(long id) {
		Publisher<DeleteResult> pub = collectionP.deleteOne(Filters.eq("_id",id));
		BikeSubcription<DeleteResult> sub = new BikeSubcription<>();
		pub.subscribe(sub);
		return sub.getSingleResult() != null;
		
	}
	

}
