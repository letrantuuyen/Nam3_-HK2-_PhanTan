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
import com.mongodb.internal.connection.Connection;
import com.mongodb.reactivestreams.client.FindPublisher;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;

import Entity.Customer;
import Entity.Product;
import db.connectDB;

public class productDao {
	private MongoCollection<Product> collectionP;

	public productDao() {
		super();
		MongoClient client = connectDB.getMY_DB().getClient();
		MongoDatabase mongodatabase = client.getDatabase("20043331_LeTranTuUyen");
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		collectionP = mongodatabase.getCollection("products",Product.class).withCodecRegistry(pojoCodecRegistry);
	}
	
	public List<Product> getProductsByName(String keywords) {

		Publisher<String> pub1 = collectionP.createIndex(Document.parse("{\"product_name\":\"text\"}"));
		BikeSubscription<String> sub1 = new BikeSubscription<>();
		pub1.subscribe(sub1);
		sub1.await();
		
		FindPublisher<Product> pub = collectionP.find(Filters.text(keywords));
		BikeSubscription<Product> sub = new BikeSubscription<>();
		
		pub.subscribe(sub);
		
		return sub.getResult();
	}
	
	

	
	

}
