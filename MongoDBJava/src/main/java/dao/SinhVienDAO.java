package dao;

import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.MongoClientException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import entity.SinhVien;

public class SinhVienDAO extends AbstracDAO {
	private MongoCollection<Document> sinhvienCollection;
	public SinhVienDAO(MongoClient client) {
		super(client);
		
		sinhvienCollection = db.getCollection("dsSinhVien");
		// TODO Auto-generated constructor stub
	}
	
	//them SV
	public SinhVien add(SinhVien sv) {	
		
		try {
			// chuyen doi tuong sang document
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ms", sv.getMsvv());
			map.put("ho", sv.getHo());
			map.put("ten", sv.getTen());
			map.put("tuoi", sv.getTuoi());
			Document doc = new Document(map);
			sinhvienCollection.insertOne(doc);
			
			return sv;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	// cap nhat 
	public boolean capNhatTuoiSV(String mssv, int tuoi) {
		Document filter = new Document("_id", mssv);
		Document update = new Document("$set", new Document("tuoi", tuoi));
		UpdateResult kq = sinhvienCollection.updateOne(filter, update);
		
		return kq.getModifiedCount() > 0 ? true : false;
	}
	
	// cap nhat tuoi cach 2
	//db.dsSinhvien.updateOne({_id:"432"},{$set:{tuoi:25}})
	public boolean capNhatTuoiSV2(String mssv, int tuoi) {
		
		UpdateResult kq = sinhvienCollection.updateOne(
				Filters.eq("_id", mssv), 
				Updates.set("tuoi", tuoi));
		
		
		return kq.getModifiedCount() > 0 ? true : false;
	}
	
	// them nhieu sv
	public void themDSSinhvien(List<SinhVien> dssv) {
		List<Document> docs = new ArrayList<Document>();
			try {
				dssv.forEach(sv ->{
					Document doc = new Document()
							.append("_id", sv.getMsvv())
							.append("ho_sv", sv.getHo())
							.append("ten", sv.getTen())
							.append("tuoi", sv.getTuoi());
							
						docs.add(doc);
				});
				
				sinhvienCollection.insertMany(docs);
				
				
			}catch (MongoClientException e) {
				e.printStackTrace();
			}
	}
	
	private SinhVien chuyenSinhVien(Document doc) {
		SinhVien sv = new SinhVien();
		sv.setMsvv(doc.getString("_id"));
		sv.setHo(doc.getString("ho_sv"));
		sv.setTen(doc.getString("ten"));
		sv.setTuoi(doc.getInteger("tuoi"));
		
		
		return sv;
	}
	//tim sinh vien
	public List<SinhVien> getDSSinhVien(int skip, int limit){
		List<SinhVien> dssv = new ArrayList<SinhVien>();
		
		FindIterable<Document> docs = sinhvienCollection
				.find()
				.skip(skip)
				.limit(limit);
		
				MongoCursor<Document> it = docs.iterator();
				while(it.hasNext()) {
					Document doc = it.next();
					SinhVien sv1 = chuyenSinhVien(doc);
				}		
		
		return dssv;
	}
	
	// xoa sinh vien
	public boolean xoaSinhVien(String mssv) {
		
		DeleteResult kq= sinhvienCollection.deleteOne(Filters.eq("_id", mssv));
		
		return kq.getDeletedCount() > 0 ? true : false;
	}

}
