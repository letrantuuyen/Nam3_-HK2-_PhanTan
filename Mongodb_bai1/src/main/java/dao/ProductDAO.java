package dao;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import com.google.gson.Gson;
import com.mongodb.MongoClientException;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.model.Filters;import com.mongodb.client.model.UpdateOneModel;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;

import Entity.Product;
import db.connectDB;


public class ProductDAO {

	private final Gson gson = new Gson();
	private MongoCollection<Document> productionCollection;
	private MongoClient mongoClient;
	
	public ProductDAO() {
		super();
		productionCollection = connectDB.getInstance().getMongoClient().getDatabase("BikeStores").getCollection("products");
	}
	
	// them 1 product
	public boolean addProduct(Product p) {
		// chuyen object -> json
		String jsonProduct = gson.toJson(p);
		//chuyen sang doccument
		Document doc = Document.parse(jsonProduct);
		Publisher<InsertOneResult> pub = productionCollection.insertOne(doc);
		ProductSubcription<InsertOneResult> sub = new ProductSubcription<InsertOneResult>();
		
		pub.subscribe(sub);
		
		return sub.getResult() != null;
	}
	
	// them nhieu san pham
	public boolean addDS(List<Product> pros) {
		List<Document> docs = new ArrayList<Document>();
			pros.forEach(p->{
				Document doc = new Document()
						.append("_id", p.getId())
						.append("brandName", p.getBrandName())
						.append("categoryName", p.getCategoryName())
						.append("color", p.getColor())
						.append("modelYear", p.getModelYear())
						.append("productName", p.getProductName())
						.append("price", p.getPrice());
				
				docs.add(doc);
			});
			Publisher<InsertManyResult> pub = productionCollection.insertMany(docs);
			ProductSubcription<InsertManyResult> sub  = new ProductSubcription<InsertManyResult>();
			pub.subscribe(sub);
		
		return sub.getSingleResults().getInsertedIds()!=null;
		
	}	
	// cap nhat updateOne
	public boolean updateOneProduct(Long maSP, String brandName) {
		Publisher<UpdateResult> pub  = productionCollection.updateOne(
			     	Filters.eq("_id",maSP),
					Updates.set("brandName", brandName));
		ProductSubcription<UpdateResult> sub  = new ProductSubcription<UpdateResult>();
		pub.subscribe(sub);
		return sub.getResult() !=null;
	}
	
	// cap nhat updateMany
	
	public boolean updateManyProduct(String brandName, List<Product> list) {
		
		list.forEach(p->{
			
		}
		
				);
		
		Publisher<UpdateResult> pub = productionCollection.updateMany(
					Filters.eq("brand_name",brandName),
					Updates.set("brand_name",brandName));
		ProductSubcription<UpdateResult> sub = new ProductSubcription<UpdateResult>();
		pub.subscribe(sub);
		return false;
	}
	
	// xoa san pham
	public boolean deleteOne(Product p) {
		// chuyen object -> json
			String jsonProduct = gson.toJson(p);
		//chuyen sang doccument
			Document doc = Document.parse(jsonProduct);
	
		Publisher<DeleteResult> pub = productionCollection.deleteOne(doc);
		ProductSubcription<DeleteResult> sub  = new ProductSubcription<DeleteResult>();
		pub.subscribe(sub);
		return sub.getResult() != null;
	}
	
}		
