package dao;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.reactivestreams.client.FindPublisher;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;

import db.Connection;
import entity.Product;

public class ProductDao {
	private MongoCollection<Product> collection;

	public ProductDao() {
		MongoClient mongoClient = Connection.getInstance().getMongoClient();
		MongoDatabase mongoDb = mongoClient.getDatabase("20043331_LeTranTuUyen"
				+ "");

		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
				fromProviders(PojoCodecProvider.builder().automatic(true).build()));

		collection = mongoDb.getCollection("products", Product.class)
				.withCodecRegistry(pojoCodecRegistry);
	}

	public List<Product> getProductsByName(String keywords) {

		Publisher<String> pub1 = collection.createIndex(Document.parse("{\"product_name\":\"text\"}"));
		BikeSubscriber<String> sub1 = new BikeSubscriber<>();
		pub1.subscribe(sub1);
		sub1.await();
		
		FindPublisher<Product> pub = collection.find(Filters.text(keywords));
		BikeSubscriber<Product> sub = new BikeSubscriber<>();
		
		pub.subscribe(sub);
		
		return sub.getResults();
	}
	
	public boolean addProduct(Product product) {
		Publisher<InsertOneResult> publisher = collection.insertOne(product);
		BikeSubscriber<InsertOneResult> subscriber = new BikeSubscriber<>();
		
		publisher.subscribe(subscriber);
		
		InsertOneResult rs = subscriber.getSingleResult();
		
		return rs.getInsertedId() != null ;
	}

//	public boolean addProduct1(Product product) {
//
//		CountDownLatch latch = new CountDownLatch(1);
//
//		AtomicBoolean rs = new AtomicBoolean(false);
//
//		Publisher<InsertOneResult> publisher = collection.insertOne(product);
//
//		publisher.subscribe(new Subscriber<InsertOneResult>() {
//
//			@Override
//			public void onSubscribe(Subscription s) {
//				s.request(1);
//			}
//
//			@Override
//			public void onNext(InsertOneResult t) {
//				if(t != null)
//					rs.set(true);
//			}
//
//			@Override
//			public void onError(Throwable t) {
//				t.printStackTrace();
//			}
//
//			@Override
//			public void onComplete() {
//				System.out.println("Done");
//				latch.countDown();
//			}
//		});
//
//		//		try {
//		//			Thread.sleep(1000);
//		//		} catch (InterruptedException e) {
//		//			e.printStackTrace();
//		//		}
//
//		try {
//			latch.await();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		return rs.get();
//	}
}
