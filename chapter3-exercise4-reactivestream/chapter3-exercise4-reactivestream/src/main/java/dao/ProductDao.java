package dao;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.List;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.reactivestreams.Publisher;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.model.Filters;

import static com.mongodb.client.model.Filters.*;
import com.mongodb.reactivestreams.client.FindPublisher;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;

import db.Connection;
import entity.Customer;
import entity.Product;

public class ProductDao {
private MongoCollection<Product> collection;
	
	public ProductDao() {
		MongoClient mongoClient = Connection.getInstance().getMongoClient();
		MongoDatabase mongoDb = mongoClient.getDatabase("BikeStores");
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
				fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		
		collection = mongoDb.getCollection("products", Product.class)
				.withCodecRegistry(pojoCodecRegistry );
	}
	
// Tìm danh sách sản phẩm có giá từ from đến to (tạo index tăng dần theo giá)
//db.products.createIndex({price: 1})
//db.products.explain("executionStats").find({$and:[{price:{$gt: 450}},{price:{$lt: 500}}]})
	
	public List<Product> findByPrice(double from, double to){
		
		createIndexByPrice();
		
		FindPublisher<Product> publisher = collection.find(and(gte("price", from), lte("price", to)));
		BikeSubscriber<Product> subcriber = new BikeSubscriber<Product>();
		publisher.subscribe(subcriber);
		
		return subcriber.getResults();
	}
	
	public String createIndexByPrice() {
		BikeSubscriber<String> sub;
		
		collection.createIndex(new Document("price", 1))
		.subscribe(sub = new BikeSubscriber<String>());
		return sub.getSingleResult();
	}
	
	public Product findById(long id) {
		BikeSubscriber<Product> sub;
		
		collection.find(Filters.eq("_id", id)).first()
		.subscribe(sub = new BikeSubscriber<Product>());
		
		return sub.getSingleResult();
		
	}
}




